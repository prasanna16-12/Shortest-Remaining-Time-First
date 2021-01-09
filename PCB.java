public class PCB {
    private int processID;
    private int arrivalTime;
    private int brustTime;

    public PCB(int processID, int arrivalTime, int brustTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.brustTime = brustTime;
    }

    public PCB(PCB e) {
        this.processID = e.processID;
        this.arrivalTime = e.arrivalTime;
        this.brustTime = e.brustTime;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBrustTime() {
        return brustTime;
    }

    public void setBrustTime(int brustTime) {
        this.brustTime = brustTime;
    }
    
    
    
}
