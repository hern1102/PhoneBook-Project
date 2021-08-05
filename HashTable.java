/*
Description: This hash table consist of an array of linked lists in order to store
data and search for data more efficiently. It also uses a hashing algorithm, the Berstein
hasing algorithm, to assist with the index of the array, and then stores the (key, value)
pair in the linked list in the correct manner. 
 */

package project.pkg6;


public class HashTable {
    
    /*
    There is an instance of array of LinkedList that will be the foundation of 
    the hashtable as we move forward.
    */
    
    private LinkedList[] arr;
    
    
    public HashTable(){
        arr = new LinkedList[50];
    }
    
    public HashTable(int sizeOfArray){
        arr = new LinkedList[sizeOfArray];
    }
    
    /*
    Function: int hash(String name)
    Description: This method uses the bernstein algorithm to create a hash based 
    off of all of the characters in the string provided within the bounds of the 
    array set in the constructors. 
    Inputs: A string is required as a parameter for this method
    Outputs: An int which will indicate the index in the array.
    */
    
    public int hash(String name){
        
        //Bernstein hash function
        long hashVal = 5381;
        for(char ch : name.toCharArray()){
            hashVal*=32;
            hashVal+=(int)ch;
        }
        hashVal %= arr.length;
        
        if((int)hashVal < 0)
            return 0; //deals with out of bounds cases, just in case.
        else
            return (int)hashVal;
        
    }
    
    /*
    Function: void hash(String name, String number)
    Description: This method takes the name and number when parsed from the line,
    and then uses the hash function above to added to a certain index the key and 
    value pair required for task 2
    Inputs: The name and number of the person in String form.
    Outputs: None
    */
    
    
    public void hash(String name, String number){
        
        int index = hash(name);
        
        if(arr[index] == null){
            arr[index] = new LinkedList(name, number);
        }else{
            arr[index].append(name, number);
        }

    }
    
    /*
    Function: void printTable()
    Description: This method traverses the entire hashTable from Linked list in the arrays 
    first index, to the last and prints every nodes value. 
    Inputs: None
    Outputs: Will print to the console when called.
    */
    
    public void printTable(){
        
        for(int i = 0; i < arr.length; i++){
            if(!(arr[i] == null))
                arr[i].printList();
        }
        
    }
    
    /*
    Function: String getNumber(String name)
    Description: This method was created in order to get the persons phone number
    from the hashtable using their name and display output to the screen.
    Inputs: A name as a string
    Outputs: A string that will represent the number of the person you were looking 
    for
    */
    
    
    public String getNumber(String name){
        
        int index = hash(name);
        if(arr[index] == null){
            return "Sorry couldn't find the person you are looking for, try again.";
        }else{
            
            int n = arr[index].find(name);
            if(n == -1){
                return "Sorry couldn't find the person you are looking for, try again.";
            }else if(n > 0){
                return name + " (" + String.valueOf(index) + " - " + String.valueOf(n) + ") " + arr[index].at(n);
            }else{
                return name + " (" + String.valueOf(index) + ") " + arr[index].at(n);
            }
        
        }

    }
    
    /*
    Function: void hash(double value)
    Description: This method hashes the double value, and then adds the value to
    the array of linked lists in the appropriate location. 
    Inputs: A value of double type
    Outputs: None
    */
    
    public void hash(double value){
        
        int index = doubleIndex(value);
        
        if(arr[index] == null){
            arr[index] = new LinkedList(value, "");
        }else{
            arr[index].append(value, "");
        }
        
    }
    
    /*
    Function: private int doubleIndex(double value)
    Description: This method takes a double value and hashes the double using the 
    bernstein hashing algorithm and produces an int that will represent the hashing 
    value.
    Inputs: A value of data type double
    Outputs: An int that represents the hashing value
    */
    
    private int doubleIndex(double value){
        
        //Bernstein hash function
        String str = String.valueOf(value);
        long hashVal = 5381;
        for(char ch : str.toCharArray()){
            hashVal*=32;
            hashVal+=(int)ch;
        }
        hashVal %= arr.length;
        int index = (int)hashVal;
        return index;
        
    }
    
    /*
    Function: public int search(double value)
    Description: This method will take a value as input, and search the hashtable
    and check to see how many times that value is in the hashtable. It will 
    then return an int that will represent the number of times that it has found the 
    value that you had passed the method. 
    Inputs: A double is required 
    Outputs: An int that represents the number of times that that double was found.
    */
    
    public int search(double value){
        
        int index = doubleIndex(value);
        
        if(arr[index] == null){
            return -1;
        }else{
           return arr[index].findData(value);
            }    
        }
    
    /*
    In the main method, we hash 12 doubles to the hashtable, in order to test the
    collision handling capability. It worked well, we also test the print method,
    and the search method in the test code below as well. We added 24.0 (4 times)
    and when we search for how many times we added that number, the output is 4. 
    */

    /*
    public static void main(String[] args){
        
        HashTable ht = new HashTable(53);
        
        ht.hash(43.456);
        ht.hash(21);
        ht.hash(2);
        ht.hash(45.1);
        ht.hash(24);
        ht.hash(87);
        ht.hash(3.14);
        ht.hash(2.71);
        ht.hash(5.3);
        ht.hash(24);
        ht.hash(24);
        ht.hash(24);
        
        System.out.println("The number of times 24.0 was found in the HashTable: "+ ht.search(24));
        
        ht.printTable();
 
    }
    
    */
    
    
}
