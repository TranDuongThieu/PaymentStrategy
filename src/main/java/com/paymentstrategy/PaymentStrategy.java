/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.paymentstrategy;

import com.paymentstrategy.StrategyDP.GetAccountDetails;
import com.paymentstrategy.StrategyDP.GetCreditCardDetails;
import com.paymentstrategy.StrategyDP.IsCreditCardPaid;
import com.paymentstrategy.StrategyDP.IsPaypalPaid;
import com.paymentstrategy.StrategyDP.IsZaloPaid;
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

        System.out.println("""
                           --> Please, select a payment method:
                           \t1 - PayPal
                           \t2 - Credit Card
                           \t3 - ZaloPay""");
        String paymentMethod = scanner.nextLine();

        switch (paymentMethod) {
            case "1":
                procPay.setStrategy(new GetAccountDetails(), new IsPaypalPaid());
                break;
            case "2":
                procPay.setStrategy(new GetCreditCardDetails(), new IsCreditCardPaid());
                break;
            case "3":
                procPay.setStrategy(new GetAccountDetails(), new IsZaloPaid());
                break;
        }
        procPay.getGetPaymentDetailsStrategy().getPaymentDetails();
        
        Thread.sleep(1000);
        if (procPay.getIsPaidStrategy().isPaid(procPay.getTotalCost())) {
            System.out.println("--> Payment has been successful.");
        } else {
            System.out.println("--> FAIL! Please, check your data.");
        }
    }
}
