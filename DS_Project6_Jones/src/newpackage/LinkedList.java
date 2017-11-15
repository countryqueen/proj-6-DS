/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Owner
 * * ‘******************************************************
‘***  Class Name: LinkedList
‘***  Class Author: Angelica
‘******************************************************
‘*** Purpose of the class: Create a Link List with all the variables!
‘***
‘******************************************************
‘*** Date: 11/4/17
 */
public class LinkedList 
{
    private String word;
    private LinkedList nextLL;
    
   //the following are getters and setters
    public String getTerm()
    {
        return word;
    }  
   
    public LinkedList getNextLink()
    {
        return nextLL;
    } 
 
    public void setTerm(String word)
    {
        this.word = word;
    } 
    
    public void setLinkList(LinkedList link) 
    {
        this.nextLL = link;
    }
    
}
