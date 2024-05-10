/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentstrategy.StrategyDP;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thieu
 */
public class IsPaypalPaid implements IsPaidStrategy {

    @Override
    public boolean isPaid(int totalCost) {
        try {
            System.out.println(".....executing payment.....");
            Thread.sleep(2000);
            System.out.println("--> Paying " + totalCost + " using Paypal.");
            return true;
        } catch (InterruptedException ex) {
            Logger.getLogger(IsPaypalPaid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
