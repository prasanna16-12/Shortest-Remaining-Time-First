import java.util.Scanner;
public class Test {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes : ");
        int numberOfProcesses = sc.nextInt();

        ShortestRemainingTimeFirst SRTF = new ShortestRemainingTimeFirst(numberOfProcesses);
        System.out.println("\nEnter process information\n[Arraival Time] [Brust Time]");
        for (int i = 0; i < numberOfProcesses; i++) {
            int arrivalTime = sc.nextInt();
            int brustTime = sc.nextInt();
            SRTF.addProcessInfo(i, arrivalTime, brustTime);
        }

        SRTF.executeSRTFAlgo();


    }
}
