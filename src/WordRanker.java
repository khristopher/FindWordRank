

import java.util.*;
import java.lang.Object;
import java.util.Arrays;


/**
 * Created by kyawmyintcho on 10/16/15.
 */
public class WordRanker {

    char[] originlword;
    char[] sortedWord;



    public WordRanker()
    {

    }
    //a healper method to find factorial
    public int factorial(int n)
    {
        return( n <=1)? 1:n* factorial(n-1);
    }


    public void populate(char[] word)
    {
        originlword = word;

        sortedWord = word.clone();
        Arrays.sort(sortedWord);


    }

    public int findRank()
    {
        char temp;

        int count = originlword.length;
        int before = 0;//before is the number before letter
        int coefficient = count; //the coefficient
        int answer = 0;
        int totalAnswer = 0;



        for(int i = 0; i < count; i ++)
        {
            temp = originlword[0];

            //will loop through individual
            for( int j = 0; j < sortedWord.length; j++)
            {

                if(temp == sortedWord[j])
                    break;

                before++;
            }



            coefficient--;
            answer = before * factorial(coefficient) ;
            before = 0;// must reset before to zero



            originlword = Arrays.copyOfRange(originlword, 1, originlword.length);

            sortedWord = removeAnElementFromCharArray(sortedWord, temp);



            totalAnswer = answer + totalAnswer;
        }

        return totalAnswer+1;
    }






    //remove the element from both original and sorted array to calculate next permuate computation
    public char[] removeAnElementFromCharArray(char[] charArray, char achar)
    {
        char[] newCharArray = new char[charArray.length-1];

        for(int i = 0; i < charArray.length ; i++)
        {

            if(achar == charArray[i])
            {

                System.arraycopy(charArray,0,newCharArray,0,i);
                System.arraycopy(charArray,i+1,newCharArray,i,charArray.length - i -1);
                break;
            }

        }
        return  newCharArray;
    }



    public static void main (String[] args) throws java.lang.Exception
    {
        //Testing using sample word to see if the program work
        // char word[] = {'m','a','s','t','e','r'};

        char word[] = {'q','u','e','s','t','i','o','n'};

        int answer = 0;
        WordRanker wordRanker = new WordRanker();
        wordRanker.populate(word);
        answer = wordRanker.findRank();
        System.out.println("The rank of word " + String.valueOf(word) + "is :" + answer );


    }
}
