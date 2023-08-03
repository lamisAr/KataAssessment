import java.io.*;
import java.util.*;

public class Attempt1Readable {
    List<String> wordsLessThan6;
    List <String> wordsEqual6;
    String path2File;

    public Attempt1Readable(String path2File){
        wordsEqual6 = new ArrayList<>();
        wordsLessThan6 = new ArrayList<>();
        this.path2File = path2File;
    }
    public void process_dictionary(){
        long startTime = System.currentTimeMillis();
        scanDictionary();
        int count = 0;
        for(String word:wordsEqual6){
            for(int i =1; i<6; i++){
                String sub1 = word.substring(0,i);
                String sub2 = word.substring(i,6);
                if(wordsLessThan6.contains(sub1) && wordsLessThan6.contains(sub2))
                {System.out.println(sub1+" + "+sub2+" => "+word); count++;
                    System.out.println(count);}
            }
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime/1000.0 + " seconds");

    }
    private void scanDictionary(){
        try {
            FileReader file = new FileReader(path2File);
            BufferedReader fileStream = new BufferedReader(file);
            String word = fileStream.readLine();
            while (word!=null) {

                if (word.length() == 6) {
                    wordsEqual6.add(word);
                }
                if (word.length() < 6) {
                    wordsLessThan6.add(word);
                }
                word = fileStream.readLine();
            }

        } catch(FileNotFoundException e)
        {

            System.out.println("No file was read");
        }
        catch(IOException e)
        {
            System.out.println("There was a problem reading the file");
        }
    }


}
