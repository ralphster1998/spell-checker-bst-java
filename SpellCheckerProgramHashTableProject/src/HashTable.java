
public class HashTable <T> {
    
    private final static int TABLE_SIZE = 179; 

    // This table shows that it is made out of 179 Linked Lists
    LinkedHashEntry[] table;

    // Initializes the separate chaining
    HashTable() {
          table = new LinkedHashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

    // this helps search a word in the hash table/ dictionary
    public T get(int key, T word) {
          // This is minus 65 b/c for character "A", it is 65. And for 
          // characters "zz", its ascii value is 244. So the key for A would be
          // 0, which would fit in the hash table of size 244 minus 65, which
          // is a size of 179. This helps lessen the size of hash table. 
          int hashNumber = key - 65; 
          int hash = (hashNumber % TABLE_SIZE);
          // If searched word is not found by the key index, it will return null.
          if (table[hash] == null)  
                return null;
          else {
                // This goes through the linked list of key index to check if
                // the searched word is there. 
                LinkedHashEntry entry = table[hash];
                while (entry != null && entry.getKey() == key) {
                    // uses compareTo method to check between the string of the 
                    // searched word and the string of the node. Goes out of the
                    // loop searching if word is found or it will call the 
                    // .getNext method to go to the next node. 
                    if(word.toString().compareTo(entry.getValue().toString()) == 0)
                        break;
                    entry = entry.getNext();
                }
                // if there is not match in the linked list, return null
                if (entry == null)
                    return null;
                // if there is a match, return the string
                else
                    return (T) entry.getValue(); 
          }
    }

    // this helps insert words as the dictionary
    public void put(int key, T value) {
          // Minus 65 b/c same reason as above. 
          int hashNumber = key - 65;
          int hash = (hashNumber % TABLE_SIZE);
          
          // creates a new linked list if the value of hash index is null. 
          if (table[hash] == null) {
              table[hash] = new LinkedHashEntry(key, value);
          }
          else {
                LinkedHashEntry entry = table[hash];
                // loops through the list if the linked nodes are not null,
                // until it finds a null node
                while (entry.getNext() != null && entry.getKey() == key)
                      entry = entry.getNext();
                // when it finds a null node, it puts a new node with the 
                // new word. 
                entry.setNext(new LinkedHashEntry(key, value));
          }
    }
}

// This is the class that puts a linked chain on each key index.
class LinkedHashEntry<T> {
      private int key;
      private T value;
      private LinkedHashEntry next;
 
      // Constructor to make a linked node in a linked list, with 
      // members (key, value, and next). 
      LinkedHashEntry(int key, T value) {
            this.key = key;
            this.value = value;
            this.next = null;
      }
 
      // returns value of the linked node
      public T getValue() {
            return value;
      }
 
      // sets the value of the linked node
      public void setValue(T value) {
            this.value = value;
      }
 
      // returns the key of the linked node, based on the hash table
      public int getKey() {
            return key;
      }
 
      // this goes to the next node
      public LinkedHashEntry getNext() {
            return next;
      }
 
      // sets the value of the node
      public void setNext(LinkedHashEntry next) {
            this.next = next;
      }
}