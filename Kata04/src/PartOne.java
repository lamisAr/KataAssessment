import java.io.*;

public class PartOne {
    String day_nb;
    int smallestSpread;

    public String smallest_spread(String path_to_file) {
        smallestSpread=Integer.MAX_VALUE;
        readFile(path_to_file);
        System.out.println("The day with the smallest spread is day "+  day_nb+ " with a spread of "+ smallestSpread);
        return day_nb;
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
                if(firstLine) {temp = fileStream.readLine();firstLine=false;}

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
        //for (String ele:eles) {
        //        System.out.print(ele+" ");
        //    }

        try{int max = Integer.parseInt(eles[2]);
            int min = Integer.parseInt(eles[3]);
            int spread = max- min;
            if(spread<smallestSpread) {smallestSpread=spread;day_nb = eles[1];}
            //System.out.println(day_nb);
        }catch (NumberFormatException e){
            //System.out.println("e");
            //I don't quite know how to handle the temperatures with * values(e.g 97*) as no instructions were provided for that.
            //I will skip for now but later new code can be added in this section to handle them
        }
        catch (IndexOutOfBoundsException e){}
    }



}
