import java.util.ArrayList;
import java.util.Arrays;

public class ShortestRemainingTimeFirst {

    private int numberOfProcesses;
    private ArrayList<PCB> processList;
    private ArrayList<PCB> currentProcesses;
    private boolean[] isFirstTime;
    private boolean[] isComplete;
    private int[] firstArrivalTime;
    private int[] processFinishTime;

    public ShortestRemainingTimeFirst(int numberOfProcesses) {
        this.numberOfProcesses = numberOfProcesses;
        processList = new ArrayList<PCB>(numberOfProcesses);
        currentProcesses = new ArrayList<PCB>();
        firstArrivalTime = new int[numberOfProcesses];
        processFinishTime = new int[numberOfProcesses];
        isFirstTime = new boolean[numberOfProcesses];
        isComplete = new boolean[numberOfProcesses];
        Arrays.fill(isFirstTime, true);
        Arrays.fill(isComplete, false);
    }

    public void executeSRTFAlgo() {

        int completeCount = 0;
        int prevPid;
        int currPid;
        System.out.println("process Table");
        displayProcessTable(processList);

        int startingArrivalTime = returnStartArrivalTime();
        int finalArrivalTime = returnFinalArrivalTime();

        System.out.println("\nAlgo evaluation..........................\n");

        fillCurrentProcessArrayWith(startingArrivalTime);
        if (!currentProcesses.isEmpty()) {
            displayProcessTable(currentProcesses);
        }
        int minBrustIndex = indexOfMinBurstTime();
        prevPid = currPid = currentProcesses.get(minBrustIndex).getProcessID();

        while (true) {

            System.out.println("At time : " + startingArrivalTime);
            int minBTIndex = indexOfMinBurstTime();
            if (minBTIndex == -1) {
                System.out.println("---------------------");
                System.out.println("| CPU in idle state |");
                System.out.println("---------------------");
                fillCurrentProcessArrayWith(++startingArrivalTime);

            } else {
                int processID = currentProcesses.get(minBTIndex).getProcessID();
                System.out.print("Pid-" + processID + " is selected by CPU");
                if (isFirstTime[processID] == true) {
                    firstArrivalTime[processID] = startingArrivalTime;
                    isFirstTime[processID] = false;
                }
                prevPid = currPid;
                currPid = processID;
                int brustTime = currentProcesses.get(minBTIndex).getBrustTime();
                System.out.println(" with mininum brust time : " + brustTime);
                currentProcesses.get(minBTIndex).setBrustTime(brustTime - 1);

                if (currPid != prevPid) {
                    if (isComplete[prevPid] != true) {
                        System.out.println("preemption of : Pid-" + prevPid);
                    }
                }


                if (currentProcesses.get(minBTIndex).getBrustTime() == 0) {
                    System.out.println(
                            "Pid-" + processID + " completed at : " + (startingArrivalTime + 1));
                    isComplete[processID] = true;
                    processFinishTime[processID] = startingArrivalTime + 1;
                    completeCount++;
                    currentProcesses.remove(minBTIndex);
                }
                fillCurrentProcessArrayWith(++startingArrivalTime);

                

                System.out.println("__________________________________________");

                if (!currentProcesses.isEmpty()) {
                    displayProcessTable(currentProcesses);
                }

                if (completeCount == numberOfProcesses) {
                    break;
                }


            }


        }

        System.out.println(
                " ------------------------------------------------------------------------");
        System.out.printf("|%10s |%12s |%12s |%16s |%13s |\n", "Process ID", "Arrival Time",
                "Brust Time", "Turnaround Time", "Waiting Time");
        System.out.println(
                " ------------------------------------------------------------------------");
        for (int i = 0; i < processList.size(); i++) {
            String id = "Pid-" + processList.get(i).getProcessID();
            int at = processList.get(i).getArrivalTime();
            int bt = processList.get(i).getBrustTime();
            System.out.format("|%10s |%12d |%12d |%16d |%13d |\n", id, at, bt,
                    processFinishTime[i] - firstArrivalTime[i],
                    processFinishTime[i] - firstArrivalTime[i] - bt);
        }
        System.out.println(
                " ------------------------------------------------------------------------");


        System.out.println("Average waiting time : " + "( " + startingArrivalTime + " - "
                + returnStartArrivalTime() + " ) / " + numberOfProcesses + " = "
                + (double) (startingArrivalTime - returnStartArrivalTime()) / numberOfProcesses);

        // System.out.println(Arrays.toString(firstArrivalTime) + "\n" + Arrays.toString(
        // processFinishTime));


    }

    public void addProcessInfo(int id, int arrivalTime, int brustTime) {
        processList.add(new PCB(id, arrivalTime, brustTime));
    }

    public void displayProcessTable(ArrayList<PCB> list) {

        System.out.println(" --------------------------------------- ");
        System.out.printf("|%10s |%12s |%12s |\n", "Process ID", "Arrival Time", "Brust Time");
        System.out.println(" --------------------------------------- ");
        for (int i = 0; i < list.size(); i++) {
            String id = "Pid-" + list.get(i).getProcessID();
            int at = list.get(i).getArrivalTime();
            int bt = list.get(i).getBrustTime();
            System.out.format("|%10s |%12d |%12d |\n", id, at, bt);
        }
        System.out.println(" --------------------------------------- ");
    }

    public int returnStartArrivalTime() {
        int startAT = processList.get(0).getArrivalTime();
        for (int i = 0; i < numberOfProcesses; i++) {
            if (startAT >= processList.get(i).getArrivalTime()) {
                startAT = processList.get(i).getArrivalTime();
            }
        }
        return startAT;
    }

    public int returnFinalArrivalTime() {
        int finalAT = 0;
        for (int i = 0; i < numberOfProcesses; i++) {
            if (finalAT <= processList.get(i).getArrivalTime()) {
                finalAT = processList.get(i).getArrivalTime();
            }
        }
        return finalAT;
    }

    public void fillCurrentProcessArrayWith(int arrivalTime) {
        for (int i = 0; i < numberOfProcesses; i++) {
            if (arrivalTime == processList.get(i).getArrivalTime()) {
                currentProcesses.add(new PCB(processList.get(i).getProcessID(),
                        processList.get(i).getArrivalTime(), processList.get(i).getBrustTime()));
            }
        }
    }

    public int indexOfMinBurstTime() {
        if (currentProcesses.isEmpty()) {
            return -1;
        } else {

            int minBT = currentProcesses.get(0).getBrustTime();
            int minBTindex = 0;
            for (int i = 0; i < currentProcesses.size(); i++) {
                if (minBT >= currentProcesses.get(i).getBrustTime()) {
                    minBT = currentProcesses.get(i).getBrustTime();
                    minBTindex = i;
                }
            }
            return minBTindex;
        }
    }

}
