
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SpellCheckHash {
    public static void main(String[] args) throws FileNotFoundException {
        
        // imports the dictionary and measures the time it takes to insert every word
        long start = System.currentTimeMillis();
        System.out.println("Starting import of dictionary: ");
        HashTable<String> dictionaryReal = WordsHash.importDictionary();
        long end = System.currentTimeMillis();
        System.out.println((end-start) + " milliseconds to import dictionary ");
        long start1 = System.currentTimeMillis();
        
        System.out.println("Enter a sentence into the keyboard for the Spell Checker to check: ");

        //Create Scanner Object called Input
        Scanner input = new Scanner(System.in);     

        //Create String Object called sentence to store input
        String sentence = input.nextLine();         

        //Test print to show sentence
        System.out.println(sentence);               

        String sentenceArr[] = sentence.replaceAll("[^a-zA-Z ]", "").split("\\s+");       
        // Use built in Sort Function to sort SentenceArr[]
        Arrays.sort(sentenceArr);   

        for (int i = 0; i < sentenceArr.length; i++) {
            System.out.println(sentenceArr[i]);
        }

        //Create Queue Obj called SentenceQueue
        QueueImpl sentenceQueue = new QueueImpl(sentenceArr.length);    
        StackArray<String> mistakenWords = new StackArray<>();

        for (int i = 0; i < sentenceArr.length; i++) {
            // Enqueue each SentenceArr[] Obj into SentenceQueue
            sentenceQueue.enqueue(sentenceArr[i]);          
        }
        
        
        // check the input text with the dictionary
        while (!sentenceQueue.isQueueEmpty()) // while the queue isn't empty
        {
            String inputWord = sentenceQueue.dequeue();
            String checking = (String) dictionaryReal.get
                    (WordsHash.getASCIIFirstTwo(inputWord), inputWord);
            
            if (checking == null) // if it isn't
                // push the misspelled word 
                // into an stack
                mistakenWords.push(inputWord); 
        }
        
        // prints a message to the user if there are misspelled words or not
        if(mistakenWords.isEmpty())
            System.out.println("Your paragraph is perfect.");
        else {
            System.out.println("Here are your misspelled words");
            while(!mistakenWords.isEmpty()) {
                System.out.println(mistakenWords.pop());
            }
        } 
    }
}