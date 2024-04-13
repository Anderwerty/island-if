package ua.javarush.island.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RetryUtil {

    public void repeatUntilSuccess(int times){
        int counter =0;
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        // while(true)
        while (counter <times){
           if(lock1.tryLock() && lock2.tryLock()){
               try {
                   // move animal from AreaFrom to AreaTo
               } finally {
                   lock1.unlock();
                   lock2.unlock();
               }
               break;
           } else {
               counter++; //
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        }

    }
}
