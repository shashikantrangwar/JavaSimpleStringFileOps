import java.util.*;

public class logicalTest {

    public static void main(String[] args)
    {

        charOps coTest = new charOps();
        coTest.setInputStr("This this This This This");
        System.out.println("String is "+coTest.getInputStr());
        coTest.getDuplicateCharCount();
    }

}
class charOps
{
    private String inputSource;
    HashMap<Character,Integer> k;
     ArrayList<Character> keys = new ArrayList<>();
     ArrayList<Integer> vals = new ArrayList<>();
     public String getInputStr()
    {
        return inputSource;

    }

    public void setInputStr(String tempStr)
    {
        inputSource=tempStr;
    }

    public int getDuplicateCharCount()
    {
        String tempStr = inputSource;
        int counterChar=0;
        int i=0;
        k = new HashMap<Character,Integer>();

        for( i=0;i<tempStr.length();i++) {
            if(!isPresent(tempStr.charAt(i)))
            {
                k.put(tempStr.charAt(i),1);
            }
            else
            {
                Integer z = k.get(tempStr.charAt(i));
                z=z+1;
                k.replace(tempStr.charAt(i),z);
            }
            System.out.println("Key="+tempStr.charAt(i)+k+ "Value="+k.get(tempStr.charAt(i)));


        }
       k.forEach((k,v) -> System.out.println("Key = "
                       + k + ", Value = " + v));
        displayMap(k);
        return 1;

    }

    private void displayMap(HashMap<Character,Integer> tempHmap)
    {
            Set<Map.Entry<Character,Integer>> mEntry = tempHmap.entrySet();
            Iterator<Map.Entry<Character,Integer>> itr = mEntry.iterator();
             while(itr.hasNext())
             {
                 Map.Entry<Character,Integer> x = itr.next();
                 System.out.println("Key="+x.getKey());
                 System.out.println("Value="+x.getValue());

             }


    }
       private void findNonDuplicate()
       {


           String tempStr = inputSource;
           int counterChar=0;
           for(int i=0;i<tempStr.length();i++)
              {
                 if(!charPresent(tempStr.charAt(i))) {
                     keys.add(tempStr.charAt(i));
                     vals.add(1);
                 }
                 else
                 {
                     int c1=getIdx(tempStr.charAt(i));
                     int v1 = vals.get(c1);
                     v1=v1+1;
                     vals.set(c1,v1);
                     c1=0;
                     v1=0;
                 }
              }

       }
       public boolean charPresent(Character c)
       {
           for(int i=0;i<keys.size();i++)
           {
               if(c==keys.get(i))
                   return true;
           }
           return false;
       }
       public int getIdx(Character c)
       {
          for(int i=0;i<keys.size();i++)
          {
             if(c==keys.get(i))
                 return i;
          }
          return -1;
       }

    private boolean isPresent(Character charAt) {
        if(k.containsKey(charAt))
            return  true;
        else
            return  false;

    }


}