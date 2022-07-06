package org.example;

//class MyTask{
//    void executeTask(){
//        for(int doc = 1; doc  <= 10; doc++){
//            System.out.println("@@ Printing document #" + doc + "from Printer 2");
//        }
//    }
//}

// MyTask IS-A Thread
class MyTask extends Thread{
    @Override
    public void run(){
        for(int doc = 1; doc  <= 10; doc++){
            System.out.println("@@ Printing document #" + doc + "from Printer 2");
        }
    }

}

public class Main {
    // main method is the main thread
    public static void main(String[] args) {
        // Whatever we write in here will be executed by main thread
        // threads always execute the jobs in a sequence
        // Execution Context: in a sequence

        // JOB1
        System.out.println("==Application Started==");

        // JOB2
        MyTask task = new MyTask(); // Child Thread or Worker Thread
        //task.executeTask(); This would be the regular version
        task.start(); // Start should internally execute the run method

        // Till Job2 is not finished, below written jobs are waiting and are not executed.
        // If Job2 is a long-running operation such as several document suppose to be printed
        // In such a use case OS/JVM shall give a message that the app is not responding
        // Such sluggish behavior in app can be observed -> App seems to hang.

        // With Threads, main and MyTask are executing both parallelled or concurrently.

        // JOB3
        for(int doc = 1; doc  <= 10; doc++){
            System.out.println("^^ Printing document #" + doc + "from Printer 1");
        }

        // JOB3
        System.out.println("==Application Finished==");
    }
}