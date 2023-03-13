package com.knoldus;

public class CounterIncrement{
    private static volatile int counter =0;

    public void increment(){
        counter++;
    }

    public int getCount(){
        return counter;
    }

    public static void main(String[] args) {
        CounterIncrement counterIncrement = new CounterIncrement();

        //Creating a main thread that will increment the counter variable.
        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(counter < 10){

                    counterIncrement.increment();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
     //Creating a printingThread that will print the updated value
        Thread printingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter < 10){
                    System.out.println("Counter value has been changed to : " + counterIncrement.getCount() );

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }});

        mainThread.start();
        printingThread.start();
    }
}

