/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentstrategy;

import com.paymentstrategy.StrategyDP.IDetailStrategy;
import com.paymentstrategy.StrategyDP.IPayStrategy;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ProcessPay implements IDetailStrategy, IPayStrategy {

    private int totalCost = 0;
    private IDetailStrategy _detailStrategy;
    private IPayStrategy _payStrategy;

    public ProcessPay(){};

    @Override
    public void getDetail() {
        _detailStrategy.getDetail();
    }

    @Override
    public boolean isPay(int totalCost) {
        return _payStrategy.isPay(totalCost);
    }

    public void setStrategy(IDetailStrategy _detailStrategy,IPayStrategy _payStrategy){
         this._detailStrategy = _detailStrategy;
         this._payStrategy = _payStrategy;
    }


    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

}
