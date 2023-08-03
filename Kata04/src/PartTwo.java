import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PartTwo {
        String teamName;
        int smallestSpread;

        public String team_smallest_diff(String path_to_file) {
            smallestSpread=Integer.MAX_VALUE;
            readFile(path_to_file);
            System.out.println("The team with the smallest score difference is "+  teamName + " with a difference of "+ smallestSpread);
            return teamName;
        }
        public void readFile(String path_to_file){
            //String fileContent="";
            try
            {
                //make filereader object to read the file
                FileReader file = new FileReader(path_to_file);
                //create bufferreader to wrap the file
                BufferedReader fileStream = new BufferedReader(file);


                String temp=fileStream.readLine();
                boolean firstLine =true;
                while(temp!=null)
                {
                    //fileContent=fileContent + " " +temp;
                    if(firstLine) {
                      temp = fileStream.readLine();firstLine=false;}

                    findSpread(temp);

                    temp = fileStream.readLine();
                }
                fileStream.close();

            }
            catch(FileNotFoundException e)
            {

                System.out.println("No file was read");
            }
            catch(IOException e)
            {
                System.out.println("There was a problem reading the file");
            }
            //System.out.println(fileContent);
        }
        public void findSpread(String temp){

            String [] eles = temp.split("\\s+");
//            for (String ele:eles) {
//                    System.out.print(ele+" ");
//                }

            try{int max = Integer.parseInt(eles[7]);
                int min = Integer.parseInt(eles[9]);
                int spread = Math.abs(max- min);
                if(spread<smallestSpread) {smallestSpread=spread;teamName = eles[2];}
                //System.out.println(teamName);
            }catch (NumberFormatException e){
                //I don't quite know how to handle the temperatures with * values(e.g 97*) as no instructions were provided for that.
                //I will skip for now but later new code can be added in this section to handle them
            }catch (IndexOutOfBoundsException e){
                //if index is out of bound it mean that we have an enter or a line of "--s" so we want to skip these if possible
            }
        }



    }
