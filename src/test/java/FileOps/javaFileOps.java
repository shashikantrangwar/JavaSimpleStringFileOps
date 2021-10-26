package FileOps;

import java.io.*;
import java.util.Scanner;

public class javaFileOps {
    public static void main(String[] args) throws IOException {
        fileOperations fOps= new fileOperations();
        fOps.createFile();
        fOps.writeInfo();
        fOps.readByChar();
        fOps.readByLine();
        fOps.readByScanner();
        fOps.writeByLine();
        fOps.readByLine();
    }

}

class fileOperations
{
    private File f;
    private String filePath="C:/public/a1/Test/sk1.txt";


    public void createFile() throws IOException {
        f = new File(filePath);
        f.createNewFile();

    }

    public void writeInfo() throws IOException {
      f = new File(filePath);
      FileWriter fWrite = new FileWriter(f);
      fWrite.append("This is the First Line");
      fWrite.append("\n");
      fWrite.append("This is the Second Line");
      fWrite.close();
    }

    public void readByChar() throws IOException {
        f = new File(filePath);
        FileReader fRead = new FileReader(f);
        int ch;
        while (( ch =fRead.read()) != -1)
        {
            System.out.println("Character="+ (char) ch);
        }
        fRead.close();
    }

    public void readByLine() throws IOException {
        f = new File(filePath);
        String st = null;
        FileReader fRead = new FileReader(f);
        BufferedReader bufReader = new BufferedReader(fRead);
        while ((st = bufReader.readLine()) != null )
        {
            System.out.println("file data="+st);
        }
        fRead.close();
        bufReader.close();
    }
    public void writeByLine() throws  IOException {
        f= new File(filePath);
        FileWriter fWrite = new FileWriter(f);
        BufferedWriter bufWriter = new BufferedWriter(fWrite);
        bufWriter.append("This is using Buffered Writer");
        bufWriter.close();



    }


    public void readByScanner() throws IOException {
        f = new File(filePath);
        String st = null;
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine())
        {
            System.out.println("Scanner lines-"+sc.nextLine());
        }
        sc.close();
        Scanner sc1 = new Scanner(f);
        sc1.useDelimiter("\\Z");
        System.out.println("All lines="+sc1.next());
        sc1.close();
        sc1 = new Scanner(f);
        sc1.useDelimiter("i");
        while(sc1.hasNext())
        System.out.println("delimited lines="+sc1.next());

    }


}