/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentstrategy.StrategyDP;

import com.paymentstrategy.CreditCard;
import java.util.Scanner;

/**
 *
 * @author thieu
 */
public class CreditCartDetaIl implements IDetailStrategy {

    private static Scanner scanner = new Scanner(System.in);
    private CreditCard card;

    @Override
    public void getDetail() {
        System.out.println("-----Pay with Momo-----");
        System.out.print("Enter the card number: ");
        String number = scanner.nextLine();
        System.out.print("Enter the card expiration date 'mm/yy': ");
        String date = scanner.nextLine();
        System.out.print("Enter the CVV code: ");
        String cvv = scanner.nextLine();
        card = new CreditCard(number, date, cvv);
        System.out.print("Validate credit card number...\n\n");
    }

}
