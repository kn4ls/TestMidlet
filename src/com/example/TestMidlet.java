/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import java.util.Timer;
import javax.microedition.midlet.MIDlet;

/**
 *
 * @author Jordi Canals <jordicanalsros@gmail.com>
 */
public class TestMidlet extends MIDlet implements CountListener{
    
    private MyThread myThread;
    private Timer timer;
    private MyTask myTask;
    private CountingDevice device;
    
    @Override
    public void startApp() {
        System.out.println("Hola");
        
        //Create a thread
        myThread = new MyThread();
        myThread.start();
        
        //Create a task
        timer = new Timer();
        myTask = new MyTask();
        timer.schedule(myTask, 0, 4000);
        
        //counting Devide
        
        device = new CountingDevice(5);
        device.addCountListener(this);
        device.start();
        
        
    }
    
    @Override
    public void destroyApp(boolean unconditional) {
        System.out.println("Adios");
        myThread.stop();
        myTask.cancel();
        device.stop();
    }

    @Override
    public void countReached(int count) {
        System.out.println("countReached: " + count);
    }

    private CountingDevice countingDevice(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
