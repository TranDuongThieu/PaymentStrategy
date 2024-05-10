/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.paymentstrategy;

import com.paymentstrategy.StrategyDP.AccountDetail;
import com.paymentstrategy.StrategyDP.CreditCardDetaIl;
import com.paymentstrategy.StrategyDP.IDetailStrategy;
import com.paymentstrategy.StrategyDP.IPayStrategy;
import com.paymentstrategy.StrategyDP.CreditCardIsPaid;
import com.paymentstrategy.StrategyDP.PaypalIsPaid;
import com.paymentstrategy.StrategyDP.ZaloIsPaid;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class PaymentStrategy {

    private static Map<Integer, Integer> productList = new HashMap<>();
    private static ProcessPayment procPay = new ProcessPayment();
    private static Scanner scanner = new Scanner(System.in);

    //With
    private static IPayStrategy isPayStrategy;
    private static IDetailStrategy detailStrategy;

    int idx = 0;

    static {
        productList.put(1, 100);
        productList.put(2, 150);
        productList.put(3, 200);
        productList.put(4, 250);
    }

    public static void main(String[] args) throws InterruptedException {
        int cost;
        String continueChoice;
        do {
            System.out.print("Please, select a product:" + "\n"
                    + "\t1 - Mother board" + "\n"
                    + "\t2 - CPU" + "\n"
                    + "\t3 - HDD" + "\n"
                    + "\t4 - Memory" + "\n");
            System.out.print("--> Please, select a product:");

            int choice = Integer.parseInt(scanner.nextLine());
            cost = productList.get(choice);

            System.out.print("--> Count: ");
            int count = Integer.parseInt(scanner.nextLine());
            procPay.setTotalCost(cost * count);

            System.out.print("--> Do you wish to continue selecting products? Y/N: ");
            continueChoice = scanner.nextLine();
        } while (continueChoice.equalsIgnoreCase("Y"));

        System.out.println("--> Please, select a payment method:" + "\n"
                + "\t1 - PayPal\n"
                + "\t2 - Credit Card\n"
                + "\t3 - ZaloPay");
        String paymentMethod = scanner.nextLine();
//            PaypalPayment paypalStrategy = new PayPalPay();

        switch (paymentMethod) {
            case "1":
                procPay.setStrategy(new AccountDetail(), new PaypalIsPaid());
                break;
            case "2":
                procPay.setStrategy(new CreditCardDetaIl(), new CreditCardIsPaid());
                break;
            case "3":
                procPay.setStrategy(new AccountDetail(), new ZaloIsPaid());
                break;
        }
        procPay.getPaymentDetails();
        Thread.sleep(1000);
        if (procPay.isPaid(procPay.getTotalCost())) {
            System.out.println("--> Payment has been successful.");
        } else {
            System.out.println("--> FAIL! Please, check your data.");
        }

    }

}
