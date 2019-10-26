import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordsHash<T> {
    public static HashTable importDictionary() throws FileNotFoundException {
        // instantiates the hash table
        HashTable<String> dictionary = new HashTable<>();
        
        // This part scans linearly through the "words.txt" file, 
        // which is in the project folder
        String fileName = "words.txt";
        File textFile = new File(fileName);
        Scanner in = new Scanner(textFile); 
        
        // This scans each line of the file and inserts each word 
        // into each linked node. The key is based from the first two letters'
        // ASCII value of each word
        while(in.hasNextLine()) {
            String line = in.nextLine();
            dictionary.put(getASCIIFirstTwo(line), line);
        }
        in.close(); 
        
        return (HashTable) dictionary;
    }
    
    public static int getASCIIFirstTwo(String line) {
        String before;
        
        // if there's less than two letters for a word, just get the first 
        // letter as the ASCII value. Or else, get ASCII value of first two
        // letters
        if (line.length() < 2) {
            before = line.substring(0, 1);
        }
        else
            before = line.substring(0,2);
        
        int ascii = 0;
        
        // ASCII values calculated to make a key index
        for(int i=0; i < before.length(); i++) {
                char character = line.charAt(i); 
                ascii = ascii + (int) character; 
            }
        
        return ascii;
    }
}
