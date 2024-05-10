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
    private boolean isClosed = false;
    private CreditCard card;
    private static Scanner scanner = new Scanner(System.in);
    private IDetailStrategy _detailStrategy;
    private IPayStrategy _payStrategy;

    public ProcessPay(){};
    public ProcessPay(IDetailStrategy detailStrategy, IPayStrategy payStrategy) {
        this._detailStrategy = detailStrategy;
        this._payStrategy = payStrategy;
    }

    @Override
    public void getDetail() {
        _detailStrategy.getDetail();
    }

    @Override
    public boolean isPay(int totalCost) {
        return _payStrategy.isPay(totalCost);
    }

    public void setDetailStrategy(IDetailStrategy _detailStrategy) {
        this._detailStrategy = _detailStrategy;
    }

    public void setPayStrategy(IPayStrategy _payStrategy) {
        this._payStrategy = _payStrategy;
    }
    
    

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }

}