# Shortest remaining Time First

Shortest Remaining Time First
SRTF, Which Stands for Shortest Remaining Time First is a scheduling algorithm used in Operating Systems, which can also be called as the preemptive version of the SJF scheduling algorithm. The process which has the least processing time remaining is executed first. As it is a preemptive type of schedule, it is claimed to be better than SJF Scheduling Algorithm. When a job is preempted, all of it’s processing information must be saved in it’s PCB for later when it is to be continued, and the contents of the PCB of the other job to which the OS is switching are loaded into the registers in the memory. This is known as Context Switching.
Language: JAVA

[![SRTF](https://i.ytimg.com/an_webp/d_8HNIDWAhk/mqdefault_6s.webp?du=3000&sqp=CIPu5_8F&rs=AOn4CLAtM0bjkS_kzfBnfhmJf5uGIg2cOg)](https://youtu.be/d_8HNIDWAhk)
## Getting started

1. Enter number if processes 
2. Enter Arrival Time and Brust Time of each process

   **On Windows:**

   ```
   Enter number of processes : 4

   Enter process information
   [Arraival Time] [Brust Time]
    1 2
    2 2
    2 1
    3 2
   ```
## Output will contain

```
process Table
 ---------------------------------------
|Process ID |Arrival Time |  Brust Time |
 ---------------------------------------
|     Pid-0 |           1 |           2 |
|     Pid-1 |           2 |           2 |
|     Pid-2 |           2 |           1 |
|     Pid-3 |           3 |           2 |
 --------------------------------------- 

Algo evaluation..........................

 ---------------------------------------
|Process ID |Arrival Time |  Brust Time |
 --------------------------------------- 
|     Pid-0 |           1 |           2 |
 --------------------------------------- 
At time : 1
Pid-0 is selected by CPU with mininum brust time : 2
__________________________________________
 --------------------------------------- 
|Process ID |Arrival Time |  Brust Time |
 --------------------------------------- 
|     Pid-0 |           1 |           1 |
|     Pid-1 |           2 |           2 |
|     Pid-2 |           2 |           1 |
 ---------------------------------------
At time : 2
Pid-2 is selected by CPU with mininum brust time : 1
preemption of : Pid-0
Pid-2 completed at : 3
__________________________________________
 ---------------------------------------
|Process ID |Arrival Time |  Brust Time |
 --------------------------------------- 
|     Pid-0 |           1 |           1 |
|     Pid-1 |           2 |           2 |
|     Pid-3 |           3 |           2 |
 --------------------------------------- 
At time : 3
Pid-0 is selected by CPU with mininum brust time : 1
Pid-0 completed at : 4
__________________________________________
 ---------------------------------------
|Process ID |Arrival Time |  Brust Time |
 ---------------------------------------
|     Pid-1 |           2 |           2 |
|     Pid-3 |           3 |           2 |
 --------------------------------------- 
At time : 4
Pid-3 is selected by CPU with mininum brust time : 2
__________________________________________
 ---------------------------------------
|Process ID |Arrival Time |  Brust Time |
 ---------------------------------------
|     Pid-1 |           2 |           2 |
|     Pid-3 |           3 |           1 |
 ---------------------------------------
At time : 5
Pid-3 is selected by CPU with mininum brust time : 1
Pid-3 completed at : 6
__________________________________________
 ---------------------------------------
|Process ID |Arrival Time |  Brust Time |
 ---------------------------------------
|     Pid-1 |           2 |           2 |
 ---------------------------------------
At time : 6
Pid-1 is selected by CPU with mininum brust time : 2
__________________________________________
 ---------------------------------------
|Process ID |Arrival Time |  Brust Time |
 ---------------------------------------
|     Pid-1 |           2 |           1 |
 ---------------------------------------
At time : 7
Pid-1 is selected by CPU with mininum brust time : 1
Pid-1 completed at : 8
__________________________________________
 ------------------------------------------------------------------------
|Process ID |Arrival Time |  Brust Time | Turnaround Time | Waiting Time |
 ------------------------------------------------------------------------
|     Pid-0 |           1 |           2 |               3 |            1 |
|     Pid-1 |           2 |           2 |               2 |            0 |
|     Pid-2 |           2 |           1 |               1 |            0 |
|     Pid-3 |           3 |           2 |               2 |            0 |
 ------------------------------------------------------------------------
Average waiting time : ( 8 - 1 ) / 4 = 1.75
```

