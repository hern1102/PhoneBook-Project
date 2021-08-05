/*
Description: This class allows for the creation of Node in which you can 
create a Node and access that nodes next node and the data of the current node. 
It really is the base of LinkedList
 */

package project.pkg6;

/**
 *
 * @author antho
 */
public class Node <T>{
    
    protected Node next;
    protected T value;
    protected T key;
        
        public Node(){ 
        }
        
        public Node(T key, T value) {
            this.key = key;
            this.value = value;
        }
        
        /*
        Function: T getValue()
        Description: This method is a getter method that allows the user to pull
        down the value of the node which can be of any type.
        Inputs: None
        Outputs: The value of the node will be returned.
        */

        public T getValue() {
            return this.value;
        }
    
}
