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
public class AccountDetail implements IDetailStrategy {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void getDetail() {
        System.out.println("-----Pay with ZaloPay-----");
        System.out.print("Enter the user's email: ");
        String email = scanner.nextLine();;
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();
        // Validate account...
        System.out.print("Validate your account...\n\n");
    }

}
