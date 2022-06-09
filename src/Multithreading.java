public class Multithreading {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            MultithreadThing multithreadThing = new MultithreadThing(i);

            //Calling the thread execution by extending class Thread
           // multithreadThing.start();

            //Calling the thread execution by implementing interface Runnable
            Thread myThread = new Thread(multithreadThing);
            myThread.start();

            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //just throwing an exception to demonstrate all the threads continues execution despite the main thread failed
        //throw new RuntimeException();

    }
}

class MultithreadThing /*extends Thread*/ implements Runnable{

    private int threadNumber;

    public MultithreadThing(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " from thread "+threadNumber);

            //just throwing an exception to demonstrate the other threads continues execution
            //if(threadNumber == 3)throw new RuntimeException();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
