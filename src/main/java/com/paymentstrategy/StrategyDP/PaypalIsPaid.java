/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentstrategy.StrategyDP;

/**
 *
 * @author thieu
 */
public class PaypalIsPaid implements IPayStrategy {

    @Override
    public boolean isPaid(int totalCost) {
        System.out.println("--> Paying " + totalCost + " using Paypal.");
        return true;
    }

}
