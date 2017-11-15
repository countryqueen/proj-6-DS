/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Map;
import java.lang.Object;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import static java.util.Collections.list;
import static jdk.nashorn.internal.objects.NativeArray.map;
import java.util.HashMap;
import javax.swing.JOptionPane;
/**
 *
 * @author Owner
 *  ‘******************************************************
‘***  Class Name: Hash_Function
‘***  Class Author: Angelica
‘******************************************************
‘*** Purpose of the class:Create the hash table
*
‘***
‘******************************************************
‘*** Date: 11/14/17
 */

public class Hash_Function
{


     LinkedList[] Table;
    
  //this is a constructor
    public Hash_Function()
            //set the array/link list to a set size
    {
        Table = new LinkedList[1000];     
    }
    
  /* 
    ‘***  Method Name: add
‘***  Method Author: Angelica
‘******************************************************
‘*** Purpose of the Method: Puts strings in hash tablle
‘*** Method Inputs: newWord it is a String
‘*** List all the method parameters with their expected value ranges
‘*** Return value: void method
‘******************************************************
‘*** Date: 11/14/17

    */ 
    public void add(String newWord)
    { 
        int indexKey = theKey(newWord.trim()); //Gives a key for the location of the string
        
        if(indexKey <= 1000) //if the key is less than 1000
        {
            if(Table[indexKey] == null) //If the location in the array if empty, then fill it
            {
                LinkedList newObj = new LinkedList(); //new LinkList object is made
                newObj.setTerm(newWord); //New LinkList object is honored to store a string variable
                newObj.setLinkList(null); // LinkList reference variable is null
                
                Table[indexKey] = newObj; //LinkList is placed in the array            
            }
            else
            {
                LinkedList temp = Table[indexKey]; // temp will reference the beginning of the temp
                
                do
                {
                    if(temp.getTerm().equals(newWord)) // if the parameter word is found in the hash table, dont do anything
                    {
                        break;
                    }
                    else if(temp.getNextLink() == null)
                    {
                        LinkedList newObj = new LinkedList(); //new LinkList object is made
                        newObj.setTerm(newWord); //New linklist object is honored to store a string variable
                        
                        temp.setLinkList(newObj);    //temp holds address of new linklist
                        break;
                    } 
                    else
                    {
                        temp = temp.getNextLink();
                    }   
                }while(temp != null);
            } 
        }
        else //the possibility of a different language being added!
        {
            JOptionPane.showMessageDialog(null,"NOT AN ENGLISH WORD");
        }
    }
    
 /* 
 /* 
    ‘***  Method Name: isFound
‘***  Method Author: Angelica
‘******************************************************
‘*** Purpose of the Method: searches if word is found in hash table
‘*** Method Inputs: findWord 
‘*** Return value: boolean key (whether true or false)
‘******************************************************
‘*** Date: 11/14/17

    */
    public Boolean isFound(String findWord)
    {
        boolean isFound = false;
        
        int indexKey = theKey(findWord);    //gets the key that this string would have
            
        if(Table[indexKey] != null) // if the location is not empty, then
        {
            LinkedList temp = Table[indexKey]; //holds reference of location
            
                do
                {
                    if(temp.getTerm().equals(findWord)) //if the linklist matches the word, then
                    {
                        isFound = true; //change to true that the word is found in hash table
                        break;
                    } 
                    else
                    {
                        temp = temp.getNextLink();
                    }   
                }while(!(temp.getTerm().equals(findWord)));
        }       
        
        return isFound;
    }
    
     /* 
 /* 
    ‘***  Method Name: theKey
‘***  Method Author: Angelica
‘******************************************************
‘*** Purpose of the Method: makes a key for the strings
‘*** Method Inputs: the character inputs
‘*** Return value: boolean key (whether true or false)
‘******************************************************
‘*** Date: 11/14/17

    */
    private int theKey(String word)
    {
        int hashIndex=0;
        
        //iterates through string and gets the value of each character
        
        for(int i=0; i < word.length(); i++) 
        {
            hashIndex += LetterValue(Character.toString(word.charAt(i)));
        }
        
        return hashIndex;
    
    }
    
     /* 
 /* 
    ‘***  Method Name: letterValue
‘***  Method Author: Angelica
‘******************************************************
‘*** Purpose of the Method: switches the letters to uppercase 
‘*** Method Inputs: letter which is a string
‘*** Return value: returns the value
‘******************************************************
‘*** Date: 11/14/17

    */
    private int LetterValue(String letter)
    {
        int value = -1;
        
        switch(letter.toUpperCase())
        {
            case"A":value = 0;break;
            case"B":value = 1;break;                
            case"C":value = 2;break;                
            case"D":value = 3;break;
            case"E":value = 4;break;                
            case"F":value = 5;break;        
            case"G":value = 6;break;
            case"H":value = 7;break;                
            case"I":value = 8;break;        
            case"J":value = 9;break;
            case"K":value = 10;break;                
            case"L":value = 11;break;        
            case"M":value = 12;break;
            case"N":value = 13;break;                
            case"O":value = 14;break; 
            case"P":value = 15;break;
            case"Q":value = 16;break;                
            case"R":value = 17;break;        
            case"S":value = 18;break;
            case"T":value = 19;break;                
            case"U":value = 20;break;  
            case"V":value = 21;break;
            case"W":value = 22;break;                
            case"X":value = 23;break;        
            case"Y":value = 24;break;
            case"Z":value = 25;break;  
            default:break; 
        }       
        return value;
    }
}