/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jordi Canals <jordicanalsros@gmail.com>
 */
public class CountingDevice extends Thread {

    private volatile boolean shouldRun = true;
    private volatile int count;
    private final int trigger;
    private volatile List<CountListener> listener;
    
    public CountingDevice(int trigger) {
        this.trigger = trigger;
        listener = new ArrayList<>();
    }

    void addCountListener(CountListener countListener) {
        listener.add(countListener);
    }

    @Override
    public void start() {
        this.count = -1;
        while (this.shouldRun) {
            System.out.println("Current count: " + ++this.count);
            if (this.trigger == this.count) {
                for(CountListener c:listener){
                    c.countReached(count);
                }
            }
            
            if (count > 9) {
                count = -1;
            }
            
            
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CountingDevice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void stop() {
        shouldRun = false;
        interrupt();
    }
    
    
    
}
