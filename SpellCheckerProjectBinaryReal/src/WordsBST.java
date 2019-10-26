
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordsBST<T> {
    public static void importDictionary(BinarySearchTree dictionary, File file,      
                      int first, int last) throws FileNotFoundException { 
       // once it reaches last middle word, just insert it          
        if (last - first <= 0) { 
            int mid = getMid(first,last);
            insertLine(dictionary, file,mid);
            // no need to recursively call the function itself
        } else {
            int mid = getMid(first,last); // get middle position value of middle word
            insertLine(dictionary, file, mid); // inserts the middle word in the root
            
            // recursively inserts the middle words for the left and right childs
            importDictionary(dictionary, file, first, mid-1); 
            importDictionary(dictionary, file, mid+1,last);
        }
    } 
    //gets middle value to go toward the position of the middle word
    private static int getMid(int first, int last) {
        int middle = first + (last - first) / 2;
        return middle;
    }
    // searches linearly from the beginning of the file to the middle word
    private static void insertLine(BinarySearchTree dictionary, 
            File file, int middle) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        String line = null;
        // Scanner linearly goes to the middle position of the middle word
        for(int i=0; i<= middle;i++) { 
            line = in.nextLine();
        }
        dictionary.insert(line);
        in.close();
    }
}