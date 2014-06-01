/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jordi Canals <jordicanalsros@gmail.com>
 */
public class MyThread extends Thread {

    private volatile boolean shuldRun = true;
    
    @Override
    public void run() {
        while (shuldRun) {
            System.out.println("(Thread) - Read temperature ...");
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public void stop() {
        shuldRun = false;
        interrupt();
    }
    
    
}
