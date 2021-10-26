package StrringOps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    public static void main(String[] args)
    {
        allOperations stringOps = new allOperations();
        stringOps.setString("MADDKAM");
       // stringOps.reverseString();
        //stringOps.reverseWordsinString();
        //stringOps.checkDigitsinString();
       // stringOps.checkRegularExprStrings();
       // stringOps.checkVowels();
     //   stringOps.getAllPermutations();
          //stringOps.findSubStrLoc();
         stringOps.findpalindrome();
    }

}

class allOperations
{
    private String inputString;
    public void setString(String val)
    {
        inputString =val;

    }
    public void reverseString()
    {
        int i=inputString.length()-1;
        String z="";
        for(i=inputString.length()-1;i>=0;i--) {
            System.out.println(" " + inputString.charAt(i));
            z=z+inputString.charAt(i);
        }
        System.out.println("Reversed String normal-->"+z);
    }
    public void newReverseString(String s)
    {
        int i=s.length()-1;
        String z="";
        for(i=s.length()-1;i>=0;i--) {
                 z=z+s.charAt(i);
        }
        System.out.println("Reversed String Special-->"+z);
    }
    public void reverseWordsinString()
    {
        String[] k = inputString.split(" ");
        for(String s : k)
        {
            newReverseString(s);
            System.out.println(" ");
        }


    }
    public void checkDigitsinString()
    {
        String tmp = inputString;
        boolean res = tmp.matches("(.*)[0-9]+(.*)");
        System.out.println("Digit status--"+res);

        res = tmp.matches("(.*)[^abc]+(.*)");
        System.out.println("Digit status--"+res);
        System.out.println(Pattern.matches("[amz]+.*", "vzta"));//false (z and t are not matching pattern)
    }
    public void checkRegularExprStrings()
    {
        Pattern p = Pattern.compile("[amn]");
        Matcher m = p.matcher("mm");
        System.out.println("Result = "+m.matches());

    }

    public void checkVowels()
    {
        Set<Character> allVowels = new HashSet<Character>();
        allVowels.addAll(Arrays.asList('a','e','i','o','u'));
        int vowelsCount=0;
        int consoCount=0;
        int i=0;
        for(i=0;i<inputString.length();i++)
        {
            if(allVowels.contains(inputString.charAt(i)))
                vowelsCount=vowelsCount+1;
            else if(!Character.isDigit(inputString.charAt(i)))
                consoCount++;
        }
        System.out.println("Vowels"+vowelsCount);
        System.out.println("Consonants"+consoCount);
    }

    public void getAllPermutations()
    {
        String x = "";
        String x1 = "This";
     permutateAndFix(x,x1);
    }

    public  void findSubStrLoc()
    {
        Pattern p = Pattern.compile("ABC");
        Matcher m = p.matcher(inputString);
        int position=0;
        int count=0;
        while(m.find(position))
        {
            position=m.start()+1;
            count++;
        }
      System.out.println("Count of word ABC="+count);
    }

    public void findpalindrome()
    {
        int left=0;

        int counter=0;
        int len = inputString.length();
        int right =len-1;
        while(left <right)
        {
            if(inputString.charAt(left) != inputString.charAt(right))
            {
               System.out.println("Not palindrone");
                return;
            }
            left=left+1;
            right=right-1;
        }

           System.out.println("palindrone");

    }


    public void permutateAndFix(String prefix,String str)
    {
        int n=str.length();
        if(n==0)
        {
            System.out.println(prefix+" ");

        }
        else
        {
            for(int i=0;i<str.length();i++)
            {
                permutateAndFix(prefix+str.charAt(i),str.substring(i+1,n)+str.substring(0,i));
            }

        }

    }

}