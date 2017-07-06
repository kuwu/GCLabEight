import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by kuwu on 2017/07/05.
 */
public class BattingStats {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to the Batting Average Calculator!\n\n");
    System.out.print("Please enter the number of times at bat: ");
    int atBat = scan.nextInt();
    int i;
    double count = 0;
    String input = "";

    // array for batting stats
    int[] bat = new int[atBat];

    do {

      // assigning batter's results
      System.out.println("0 = out, 1 = Single, 2 = Double, 3 = Triple, 4 = HomeRun\n");
      count = getResults(scan, bat, count);
      getBatAverage(atBat, count);
      getSluggerAverage(atBat, bat);

      System.out.println("do you want to continue?   Please type 'y");
      input = scan.next();


    } while (input.equalsIgnoreCase("y"));


  }

  private static void getSluggerAverage(int atBat, int[] bat) {
    //slugging average
    double sum = IntStream.of(bat).sum();
    sum = sum / atBat;
    System.out.println();
    System.out.printf("PLayer's Slugging average is: %.3f\n", sum);
  }

  private static void getBatAverage(double atBat, double count) {
    // batting average
    count = count / atBat;
    System.out.println();
    System.out.printf("Player's Batting Average is: %.3f\n", count);
  }

  private static double getResults(Scanner scan, int[] bat, double count) {
    int i;
    for (i = 0; i < bat.length; i++) {

      System.out.print("Result for at bat: " + i + " ");
      int result = scan.nextInt();
      bat[i] = result;
      // finding the number of hits
      if (bat[i] > 0) count++;
    }
    return count;
  }

}
