//Makana Tavepholjalern
//3/11/14
//this is a program to find the (three) most common words in a piece of writing
//when you compile, enter text.txt exactly

import java.util.Scanner;
//import java.util.ArrayList;
//import java.io.File;
//import java.io.IOException;
import java.io.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.*;


public class commandFplusDriver
{
  public static void main(String[] args) throws IOException
  {
    //Brianna helped me to write a method to read in text, but it used a buffered reader which was kind of confusing
    //It read in the text without any spaces, so I had no way of separating the individual words, so I had
    //to look for another solution
    /*FileReader fr = new FileReader("text.txt");
     BufferedReader textReader = new BufferedReader(fr);
     String text = new String();
     while (textReader.readLine() != null)
     {
     text += textReader.readLine();
     }
     textReader.close();
     System.out.println(text);*/
    
    
    commandFplus wordCounter = new commandFplus();
    Scanner kb = new Scanner(System.in);
    String writing = "";//string that will hold the passage of writing
   
    System.out.println("What is the name of your file?");
    String fileName = "./Files/" + kb.nextLine();
    
    /*int numWordsWanted = 0;
    while(numWordsWanted < 1)
    {
      System.out.println("How many words would you like?(ie 3 will give you the 3 most commonly used words in the paper)");
      numWordsWanted = kb.nextInt();
    }*/
    
    /*System.out.println("Please enter the words you would not like to include in the search separated by spaces, if none, press enter");
    String str = kb.nextLine();//the string of words to not include
    ArrayList <String> arrayWordsNotInc = new ArrayList<String>();
    String[] arrayOfBadWords = str.split("");
    arrayWordsNotInc = wordCounter.toArrayList(arrayOfBadWords);//arraylist of words not to include*/
      
    Scanner x = new Scanner(new File(fileName));//a new scanner to read in from a file
    //Amanda helped me to write the code to read in text from a file
    while (x.hasNext())
    {
      writing += x.nextLine(); //next string
    }
    //System.out.println(writing);//printing to the screen what is in the string
    
    writing = wordCounter.strip(writing);//taking out the punctuation from the string, 
    //and no capital letters
    String[] arrayWords = writing.split(" ");// the array of words not to use
    ArrayList<String> arrayOfWords = new ArrayList<String>();
    arrayOfWords = wordCounter.toArrayList(arrayWords);//turning the string into an arraylist of individual words not to use
    
    arrayOfWords = wordCounter.selectionSort(arrayOfWords);//sort the arraylist alphabetically
    
    System.out.println(arrayOfWords);
    
    String[][] mostCommonWords = wordCounter.mostCommonWords(arrayOfWords);// took out , int numWordsWanted, ArrayList wordsNotInclude
    //rows by columns
    System.out.println(mostCommonWords[0][0] + ", was used " + Integer.parseInt(mostCommonWords[1][0]));
    System.out.println(mostCommonWords[0][1] + ", was used " + Integer.parseInt(mostCommonWords[1][1]));
    System.out.println(mostCommonWords[0][2] + ", was used " + Integer.parseInt(mostCommonWords[1][2]));
    
    
    /*for(int i; i < numWordsWanted; i++)
    {
      System.out.println(mostCommonWords[0][i] + " : " + mostCommonWords[1][i]);
    }*/
    
    
  }
  
  
}