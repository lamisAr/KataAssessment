import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Attempt2Faster {
        HashMap<Character,HashMap<Integer,List<String>>> wordsLessThan6;
        List <String> wordsEqual6;
        String path2File;

        public Attempt2Faster(String path2File){
            wordsEqual6 = new ArrayList<>();
            wordsLessThan6 = new HashMap<>();
            this.path2File = path2File;
        }
        public void process_dictionary(){
            long startTime = System.currentTimeMillis();
            int count =0;
            scanDictionary();
            for(String word:wordsEqual6){
                for(int i =1; i<6; i++){
                    String sub1 = word.substring(0,i);
                    char c1 = sub1.charAt(0);
                    String sub2 = word.substring(i,6);
                    char c2 = sub2.charAt(0);
                    try{if(wordsLessThan6.get(c1).get(i).contains(sub1) && wordsLessThan6.get(c2).get(6-i).contains(sub2))
                    {System.out.println(sub1+" + "+sub2+" => "+word); count++;
                        System.out.println(count);}
                    }catch(Exception e){ }
            }}
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
                        char firstLetter = word.charAt(0);
                        if (!wordsLessThan6.containsKey(firstLetter)){
                            HashMap<Integer, List<String>> map= new HashMap<>();
                            List <String> list = new ArrayList<>();
                            list.add(word);
                            map.put(word.length(),list);
                            wordsLessThan6.put(firstLetter,map);
                        }
                        else {
                            HashMap<Integer, List<String>> map= wordsLessThan6.get(firstLetter);
                            if(map.containsKey(word.length())) {
                                List <String> list = map.get(word.length());
                                list.add(word);
                                map.put(word.length(),list);
                            }
                            else {
                                List <String> list = new ArrayList<>();
                                list.add(word);
                                map.put(word.length(),list);
                            }
                        }
                    }
                    word = fileStream.readLine();
                }

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        }




}
