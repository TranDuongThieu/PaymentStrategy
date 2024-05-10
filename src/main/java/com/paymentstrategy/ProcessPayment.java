/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentstrategy;

import com.paymentstrategy.StrategyDP.GetPaymentDetailsStrategy;
import com.paymentstrategy.StrategyDP.IsPaidStrategy;

/**
 *
 * @author ADMIN
 */
public class ProcessPayment {
    private int totalCost = 0;
    private GetPaymentDetailsStrategy getPaymentDetailsStrategy;
    private IsPaidStrategy isPaidStrategy;

    public ProcessPayment(){};

    public void setStrategy(GetPaymentDetailsStrategy getPaymentDetailsStrategy, IsPaidStrategy isPaidStrategy){
         this.getPaymentDetailsStrategy = getPaymentDetailsStrategy;
         this.isPaidStrategy = isPaidStrategy;
    }

    public GetPaymentDetailsStrategy getGetPaymentDetailsStrategy() {
        return getPaymentDetailsStrategy;
    }

    public IsPaidStrategy getIsPaidStrategy() {
        return isPaidStrategy;
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
