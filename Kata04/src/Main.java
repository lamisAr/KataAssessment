import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        PartOne p1 = new PartOne();
//        String day_smallest_spread = p1.smallest_spread("C:\\Users\\user\\Desktop\\Kudwa_Assessment_LamisArmoush\\Kata04\\src\\weather.dat");
//        System.out.println(day_smallest_spread);
        PartThreeOne p1 = new PartThreeOne();
        String day_smallest_spread = p1.smallest_diff("C:\\Users\\user\\Desktop\\Kudwa_Assessment_LamisArmoush\\Kata04\\src\\weather.dat");
        System.out.println(day_smallest_spread);
//        PartTwo p2 = new PartTwo();
//        String team_smallest_spread = p2.team_smallest_diff("C:\\Users\\user\\Desktop\\Kudwa_Assessment_LamisArmoush\\Kata04\\src\\football.dat");
//        System.out.println(team_smallest_spread);
        PartThreeTwo p2 = new PartThreeTwo();
        String team_smallest_spread = p2.smallest_diff("C:\\Users\\user\\Desktop\\Kudwa_Assessment_LamisArmoush\\Kata04\\src\\football.dat");
        System.out.println(team_smallest_spread);
    }
}