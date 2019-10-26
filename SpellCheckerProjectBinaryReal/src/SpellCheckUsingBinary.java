
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SpellCheckUsingBinary {
    public static void main(String[] args) throws IOException {
        // import dictionary
        File file = new File("1000words.txt");
        System.out.println("Spell Checker Application");
        System.out.println("--------------------------------");
        BinarySearchTree<String> dictionaryReal = new BinarySearchTree<>();
        long start = System.currentTimeMillis();
        WordsBST.importDictionary(dictionaryReal, file, 0, 999);
        long end = System.currentTimeMillis();
        System.out.println((end-start) + " milliseconds to import dictionary");
        long start1 = System.currentTimeMillis();

        System.out.println("Enter a sentence into the keyboard for the Spell Checker to check: ");

        //Create Scanner Object called Input
        Scanner input = new Scanner(System.in);
        
        //Create String Object called sentence to store input
        String sentence = input.nextLine();         

        //Test print to show sentence
        System.out.println(sentence);               

        //Split String sentence into Array and remove punctuation 
        String sentenceArr[] = sentence.replaceAll("[^a-zA-Z ]", "").split("\\s+");        
        // Use built in Sort Function to sort SentenceArr[]
        Arrays.sort(sentenceArr);                   

        for (int i = 0; i < sentenceArr.length; i++) {
            System.out.println(sentenceArr[i]);
        }
        
        //Create Queue Obj called SentenceQueue
        QueueImpl sentenceQueue = new QueueImpl(sentenceArr.length);
        StackArray<String> mistakenWords = new StackArray<>();
        
        // Enqueue each SentenceArr[] Obj into SentenceQueue
        for (int i = 0; i < sentenceArr.length; i++) {
            sentenceQueue.enqueue(sentenceArr[i]);
        }
        // check the input text with the dictionary
        while (!sentenceQueue.isQueueEmpty()) // while the queue isn't empty
        {
            String inputWord = sentenceQueue.dequeue();         
            if (dictionaryReal.contains(inputWord) == false) // if it isn't
                // push the misspelled word into a stack
                mistakenWords.push(inputWord);                                       
        }
        
        // print out the misspelled words or if the input text is good
        if (mistakenWords.isEmpty())
            System.out.println("Your paragraph is perfect.");
        else {
            System.out.println("Here are your misspelled words");
            while(!mistakenWords.isEmpty()) {
                System.out.println(mistakenWords.pop());
            }
        } 
    }
}