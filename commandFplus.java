//Makana Tavepholjalern
//3/11/14
//this is a program to find the (three) most common words in a piece of writing
//when you compile, enter text.txt exactly

import java.util.Scanner;
import java.util.ArrayList;
/*import java.io.File;
 import java.io.IOException;
 import java.io.*;
 import java.io.BufferedReader;
 import java.io.FileReader;*/

public class commandFplus
{
  
  public String strip(String str)//should return the modified string with only single spaces and lower cased letters, and no numbers
  {
    str = str.toLowerCase();
    String alphaAndSpaces = "abcdefghijklmnopqrstuvwxyz ";
    String alphaChecked = "";
    Boolean alternate = false;
    
    for(int i = 0; i < str.length(); i++)
    {
      if(alphaAndSpaces.indexOf(str.substring(i,i+1)) == -1)//if there is anything other than letters and spaces, delete
      {}
      else
        alphaChecked += str.substring(i,i+1);//otherwise keep the letters
    }
    
    /*for(int i = 0; i < str.length() - 2; i++)
     {
     if(alphaChecked.substring(i,i+2).equals("  "))//if the two characters are spaces
     {
     
     alphaChecked = alphaChecked.substring(0,i) + alphaChecked.substring(i+1);//delete a space
     System.out.println(alphaChecked);
     i -= 1;//continue from last position   
     }
     else {}
     }*/
    
    
    /*if(!(str.substring(str.length()-1).equals(" ")))// if the last character is a letter,
     str += " ";//add on a space
     
     if(str.substring(0,1).equals(" "))// if the first character is a space, then delete it
     str = str.substring(1,str.length());*/
    
    return alphaChecked;
  }
  
  public ArrayList<String> toArrayList(String[] arr)
  {
    ArrayList<String> arrList = new ArrayList<String>();
    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i].compareTo(" ") == 0)
      {}
      else
        arrList.add(arr[i]);
    }
    
    return arrList;
    
    
    /*String intermediate = "";
     ArrayList<String> individualWords= new ArrayList<String>();
     
     while(str.length() > 0 && str.indexOf(" ") != -1)
     {
     int i = str.indexOf(" ");
     individualWords.add(str.substring(0,i));
     intermediate += str.substring(i+1);
     str = intermediate;
     intermediate = "";
     }
     
     //when it no longer has
     return individualWords;*/
  }
  
  
  
  //public static Arraylist<String> okWords()//prompts the player 
  //{
  
  //}
  
  public ArrayList<String> selectionSort(ArrayList <String> list){
    //a lot of this code came from the textbook on different ways to sort an array/arraylist
    int min; 
    String temp;
    
    for (int outer = 0; outer < list.size() - 1; outer++){
      min = outer;
      for (int inner = outer + 1; inner < list.size(); inner++){
        if (list.get(inner).compareTo(list.get(min)) == -1) {
          min = inner; // a new smallest item is found
        }
      }
      //swap list[outer] & list[min]
      temp = list.get(outer);
      list.set(outer, list.get(min));
      list.set(min, temp);
    }
    return list;
  }
  
  public String[][] mostCommonWords(ArrayList<String> list)//took out, int numWordsWanted, ArrayList wordsNotInclude
  {
    
    String output[][] = new String[2][3];
    int maxCount = 0;// the occurrances of the most common word so far
    int maxCount2 = 0;
    int maxCount3 = 0;
    int count = 0;
    String maxWord = "";// the most common word so far
    String maxWord2 = "";
    String maxWord3 = "";
    String current = "";
    String previous = "";
    
    for(int i = 0; i < list.size(); i++)
    {
      if(i == 0)
      {
        current = list.get(i);
        maxWord = list.get(i);
        maxCount++;
        count++;    
      }
      else
      {
        previous = current;
        current = list.get(i);//add in the new word
        if(current.equals(previous))
        {
          count++;
        }
        else
          count = 1;// adjust the current count accordingly
        
        if(count > maxCount3)//placing the current word in it's proper place if it is in the top three
        {
          maxCount3 = count;
          maxWord3 = current;
          if(count > maxCount2)
          {
            int holdInt = maxCount2;
            maxCount2 = maxCount3;
            maxCount3 = holdInt;
            String holdString = maxWord2;
            maxWord2 = maxWord3;
            maxWord3 = holdString;
            if(count > maxCount3)
            {
              int holdInt2 = maxCount;
              maxCount = maxCount2;
              maxCount2 = holdInt;
              String holdString2 = maxWord;
              maxWord = maxWord2;
              maxWord2 = holdString;
            }
          }
        }
        
      }
      output[0][0] = maxWord;
      output[1][0] = Integer.toString(maxCount);
      output[0][1] = maxWord2;
      output[1][1] = Integer.toString(maxCount2);
      output[0][2] = maxWord3;
      output[1][2] = Integer.toString(maxCount3);
    }
    return output;
    
    /*String currentWord = "";
    int numTimes = 0;
    int[][] mostCommonWords = new int[2][numWordsWanted];// 2D array-- two rows, and colums for the number of words
    for(int i = 0; i < list.size(); i++)
    {
      currentWord = list.get(i);
      if((list.get(i)).equals(list.get(i+1)))
      {
        numTimes += 1;
      }
      else{}
    }
    return mostCommonWords;*/
  }
}