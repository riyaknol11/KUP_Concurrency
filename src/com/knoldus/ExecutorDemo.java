package com.knoldus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Runnable{
    private int value;
    public Task(int value) {
        this.value = value;
    }
    @Override
    public void run() {
        System.out.println("Number value: " + value);
    }
}

public class ExecutorDemo{
    public static void main(String[] args) {
        //Executor object used to execute 10 instances of the Task class
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int number = 0; number < 10; number++) {
            Task task = new Task(number);
            Future<?> future = executor.submit(task);
            try {
           future.get();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
