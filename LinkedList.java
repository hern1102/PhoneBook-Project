/*
Description: Linked List are linear data structures where the elements are not
stored in contiguous locations and every element is a separate object with a 
data part and address part. The elements are linked using pointers and 
addresses. Each element is known as a node. This LinkedList class is a 
generic Linked List that can be created with an empty list, or you can pass 
an object to be stored in the constructor as the first element in the list.
 */

package project.pkg6;


public class LinkedList <T>{
    
    //default constructor
    public LinkedList(){
        
    }
    
    //overloaded constructor
    public LinkedList(T key, T value){
        append(key, value);
    }
    
    
    /*
    Creating a protected instance of Node as head in the field allows us
    to create an anchor to the first element in the Linked List when it
    is created. This will enable a lot of the methods below, and enable
    the methods of other classes that derived from LinkedList that it why
    this instance is protected.
    */
    
    protected Node head;

    
                // **********  Mutator Method  **********
    
    /*
    Function: append(T key, T value)
    Description: This method adds to the end of the linked list
    Inputs: This method takes the object that you wish to add as input (key, value)
    Outputs: None
    */
    
    public void append(T key, T value){
        
        if(head == null){
            head = new Node(key, value);
            return;
        }
        
        Node current = head;
        
        while(current.next != null){
            current = current.next;
        }
        
        current.next = new Node(key, value);
        
    }
    
    /*
    Function: prepend(T key, T value)
    Description: This method will add the data that you pass to it to the 
    front of the LinkedList. 
    Inputs: The data you wish to add to the front of the LinkedList
    Outputs: None
    */
    
    public void prepend(T key, T value){
        
        Node newHead = new Node(key, value);
        newHead.next = head;
        head = newHead;
        
    }
    
    
    
    /*
    Function: delete(T key)
    Description: This method takes a piece of data that you no longer want in 
    your linked list and removes it from the linked list
    Inputs: The piece of data that you want removed from the linked list
    Outputs: None
    */
    
    public void delete(T key){
        
        if(head == null){
            return;
        }
        if(head.key == key){
            head = head.next;
            return;
        }
        
        Node current = head;
        
        while(current.next != null){
            if(current.next.key == key){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    /*
    Function: T at(int nodeIndex)
    Description: This method will return the node at the index of the linked
    list that you pass it. 
    Inputs: The index you wish to return as an int
    Outputs: The object that was at the index that you were looking for
    */
    
    
    public T at(int nodeIndex){
        
        Node current = head;
        int counter = 0;
        
        while(current != null){
            if(counter == nodeIndex){
                return (T) current.value;
            }
            counter++;
            current = current.next;
        }
        return null;
    }
    
    /*
    Function: int find(T data)
    Description: This method is going to take a piece of data and search the
    linkedlist for a node that contains that piece of data. If it finds a node
    that contains that piece of data, the method will return the node index.    
    Inputs: The data that you wish to find 
    Outputs: An int that represents where in the linked list that data was found. 
    An index if you will.
    */
    
    public int find(T data){
        
        int counter = 0;
        Node current = head;
        
        while(current != null){
            if(current.key.equals(data)){
                return counter;
            }
            counter++;
            current = current.next;
        }
        counter = -1;
        return counter;
        
    }
    
    /*
    Function: int findData(T x)
    Description: This method is going to take a piece of data and then it is 
    going to search every node in the linked list and check to see if that node 
    has the data, if so, it is going to increment the count. 
    Inputs: The piece of data that you are search for
    Outputs: An int that will represent the amount of times the piece of data
    pass was in a node as a key
    */
    
    public int findData(T x){
        int count = 0;
        Node current = head;
        
        while(current != null){
            if(current.key.equals(x)){
                count++;
            }
            current = current.next;
        }
        
        return count;
    }
    
    
    /*
    Function: printList()
    Description: This method will traverse through the entire linked list and print
    the key section of every node in the linked list.
    Inputs: None
    Outputs: If you call this method in console, it will print the data section 
    as stated previously in the description
    */
    
    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.key);
            current = current.next;
        }
    }
    
}
