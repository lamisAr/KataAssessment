public class Attempt4AllCombinations {
    Attempt3Extendible a3;
    void process(String path, int lower_limit,int upper_limit){
        int total_count=0;
        long startTime = System.currentTimeMillis();
        for(int i=lower_limit; i<upper_limit; i++){
            a3 = new Attempt3Extendible(path, i);
            int count = a3.process_dictionary();
            total_count+=count;
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\nTotal number of combination "+total_count);
        System.out.println("Total time to get all combinations "+totalTime/1000.0+" seconds");
    }
}
