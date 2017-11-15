/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Owner
 *  * ‘******************************************************
‘***  Class Name: acceptFile
‘***  Class Author: Angelica
‘******************************************************
‘*** Purpose of the class:Accept the file 
* Also removes the punctuation.
‘***
‘******************************************************
‘*** Date: 11/4/17
‘******************************************************
‘*** List of changes with dates. 
‘*******************************************************

 */
public class acceptFile {
     //these are our private variables.
    private File textFile;
    private String strFile;
    private String fileName;
    private Hash_Function Table;
    
    
    //this is a constructor 
    public acceptFile(File textFile)
    {
        this.textFile = textFile;
        this.strFile = "";
    } 
       
   //this is a getter
//returns a file name    
    public String getFileName()
    {
        return fileName;
    }      
    
    //this is a getter and returns table
    public Hash_Function getHashTable()
    {
        return Table;
    }
    
    /* 
    ‘***  Method Name: readFile
‘***  Method Author: Angelica
‘******************************************************
‘*** Purpose of the Method: Reads the File
‘*** Method Inputs:
‘*** List all the method parameters with their expected value ranges
‘*** Return value: void method
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date: 11/14/17

    */ 
    public void readFile() throws IOException 
    {
        String fileName = textFile.getAbsolutePath(); //gets file's path
        
        this.fileName = textFile.getName(); // gets simple name of the File and stores it in private variable
        BufferedReader br = new BufferedReader(new FileReader(fileName)); 
        
        //ensures this does not crash
        try 
        {
            StringBuilder sb = new StringBuilder(); // reads from ACII to Strings ?
            String line = br.readLine(); //Reads each line of text file

            while (line != null)  //while there exist a String
            {
                sb.append(line); //adds the line
                sb.append(" "); //string builder adds space
                line = br.readLine(); //not sure here either
            }
   
            strFile = sb.toString(); // the read text file is stored as a string in the private variable strFile
            
            composer(strFile); // changes the string to alphabetical order
        }
        finally 
        {
            br.close(); // closes file
        }

    }
        
    /* 
    /* 
    ‘***  Method Name: composer
‘***  Method Author: Angelica
‘******************************************************
‘*** Purpose of the Method: add the words to the hash table
‘*** Method Inputs: String sentence
‘*** List all the method parameters with their expected value ranges
‘*** Return value: void method
‘*** Date: 11/14/17

    */   
    private void composer(String sentence) 
    {      
        String word =""; // compiler wanted this initialized... empty variable

        Table = new Hash_Function();
        
        int i = 0;
        //a for loop is chosen instead of a while loop because the for loop will know how long the sentence is 
        for(i=0; i< sentence.length(); i++) // will read each character in the String sentence
        {
            
            if(!Character.toString(sentence.charAt(i)).equals(" ")) // if the character in a given element is not a blank space,then the code will run
            {
                if(specialCase(Character.toString(sentence.charAt(i)))) // if the character is a given element is not a special character, then the code will run
                {
                    word+=Character.toString(sentence.charAt(i)); //the character of a given element is concantenated 
                }
            }
            
            if((Character.toString(sentence.charAt(i)).equals(" ") || i==sentence.length()-1) && !word.isEmpty())      
            {
               if(!word.isEmpty() && !word.trim().equals(""))
               {
                   Table.add(word.trim().toLowerCase());//calls the add function in the hash_function class
               }
               
                word = "";
 
            }       
        }
    
    }

    /* 
 /* 
    ‘***  Method Name: specialCase
‘***  Method Author: Angelica
‘******************************************************
‘*** Purpose of the Method: deletes the punctuations
‘*** Method Inputs: the character inputs
‘*** Return value: boolean key (whether true or false)
‘******************************************************
‘*** Date: 11/14/17

    */
    private boolean specialCase(String characterInput)
    {
        String compare = characterInput; //parameter is stored in this variable
        boolean key = false; // initialized as false
        
        switch(compare) //if the character stored in compare is a special character, then, key stays false
        {
            //special characters found on an American Englsih keyboard
            case"!": break;
            case"@": break;
            case"#": break;
            case"$": break;
            case"%": break;
            case"^": break;                    
            case"&": break;
            case"*": break;
            case"(": break;        
            case")": break;
            case"-": break;
            case"_": break;
            case"+": break;
            case"=": break;
            case"`": break;                    
            case"~": break;
            case"[": break;
            case"]": break;       
            case"{": break;
            case"}": break;
            case"\\":break;
            case"|": break;
            case";": break;
            case":": break;        
            case"\'":break; //escapes the second pair of quotation marks
            case"\"":break; //escapes the second pair of double quotation marks
            case"<": break;
            case">": break;
            case",": break;                    
            case".": break;
            case"?": break;
            case"/": break;  
            //case" ": break;
            default: key = true; //if compare was not a special character, then key is set to true
           
        }
        
        return key; // returns the boolean key
        
    }
}
