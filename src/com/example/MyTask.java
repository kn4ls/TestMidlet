/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import java.util.TimerTask;

/**
 *
 * @author Jordi Canals <jordicanalsros@gmail.com>
 */
public class MyTask extends TimerTask{

    @Override
    public void run() {
        System.out.println("(Task) - Read temperature ...");
    }
    
    
    
}
