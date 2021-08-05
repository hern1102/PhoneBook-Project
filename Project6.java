/*
Description: THIS IS THE MAIN CLASS. This class has a readFile method that reads
the file that is the sample text that was uploaded to the folder and automatically
reads the file once the program is ran. From there the program will ask you to enter
a name, and will output that persons name, hash value, and number. This class does 
all of this with the assistance of the hashtable that we create an instance of in 
the field.
 */
package project.pkg6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author antho
 */
public class Project6 {
    
    /*
    There is an instance of HashTable in order to properly implement the file being 
    read to the HashTable and access other methods related to the hashtable.
    */
    
    private HashTable ht;

    /*
    Function: public void readFile(String path)
    Description: This method reads a file from the project folder and then loads 
    the data from the text file to the hashtable, and in order to search for the 
    data with additional functions.
    Inputs: The file path to the file to be read.
    Outputs: None
    */

    
    public void readFile(String path){
            
            FileReader fr = null;
            BufferedReader br = null;

            try{
                ht = new HashTable(53);
                fr  = new FileReader(path);
                br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null){
                   String[] data = line.split(";");
                   String name = data[0];
                   String number = data[1];
                   ht.hash(name, number);
                }
    
            }
            catch(Exception e){
                System.out.println("Error opening file");
                 }
            finally{
                try{
                    fr.close();
                    br.close();
                }
                catch(Exception e){
                System.out.println(e.getMessage());
                }
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
        
        return ht.getNumber(name);
        
    }
    
    
    public static void main(String[] args){
        
        try{
           String name, again;
           Project6 proj;
           Scanner keyboard = new Scanner(System.in);

        do{  
            proj = new Project6();
            proj.readFile("text\\Hashdata.txt");
            System.out.println("CASE SENSITIVE (e.g. Anthony, Hannah) first letter must be uppercase.");
            System.out.println("Enter Name: ");
            name = keyboard.nextLine();
            System.out.println(proj.getNumber(name));
            System.out.print("Would you like to look up another number? [Y/N]? ");
            again = keyboard.nextLine();
            } while (again.equalsIgnoreCase("y"));
        
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
        
        
    }
    
}
