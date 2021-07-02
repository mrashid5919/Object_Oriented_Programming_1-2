//Complete the following Java code that finds the total number of square numbers from a 100000 random integers array using an array of 20 threads in parallel. You cannot write any more classes.

import java.util.Random;

class ParallelSquareCounter implements Runnable {
    private int[] numbers;
    private int startIndex;
    private static final int NUMBER_COUNT = 5000;
    private int squareCount;
    // you are not allowed to add any more fields

    // you are not allowed to change this constructor, and you are not allowed to add any more constructor
    ParallelSquareCounter(int[] numbers, int startIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.squareCount = 0;
    }

    @Override
    public void run() {
        for(int i=0;i<NUMBER_COUNT;i++){
            if(isSquare(numbers[startIndex+i])){
                squareCount++;
            }
        }
    }
    // your code here
    private boolean isSquare(int n){
        if(n<0)
            return false;
        int x= (int) Math.sqrt(n);
        if(x*x==n)
            return true;
        else
            return false;
    }

    public int getSquareCount(){
        return squareCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        final int NUMBER_COUNT = 100000;
        final int THREAD_COUNT = 20;
        int[] numbers = new int[NUMBER_COUNT];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt();
        }
        ParallelSquareCounter[] parallelSquareCounters = new ParallelSquareCounter[THREAD_COUNT];
        Thread[] threads = new Thread[THREAD_COUNT];
        // your code here
        for(int i=0;i<THREAD_COUNT;i++){
            parallelSquareCounters[i]=new ParallelSquareCounter(numbers,i*NUMBER_COUNT/THREAD_COUNT);
            threads[i]=new Thread(parallelSquareCounters[i],"Thread "+i);
            threads[i].start();
        }

        int squareCount=0;
        for(int i=0;i<THREAD_COUNT;i++){
            try{
                threads[i].join();
            }
            catch(InterruptedException e){
                System.out.println("Interrupted");
            }
            squareCount+=parallelSquareCounters[i].getSquareCount();
        }
        System.out.println(squareCount);
    }
}
