/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.java1.assignment.main;

import static fpt.java1.assignment.controller.UserController.input;
import static fpt.java1.assignment.controller.UserController.start;
import java.util.Scanner;

/**
 *
 * @author Thinh Nguyen
 */
public class Main {

    private static int temp;

    public static void exit() {
        System.out.println("--- Tam biet ! Cam on ban da su dung chuong trinh ---");
        System.exit(0);
    }

    public static void main(String[] args) {
        while (true) {
            try {
                input();
                temp = new Scanner(System.in).nextInt();
                if (temp > 0 && temp < 7) {
                    if (temp == 6) {
                        exit();
                    }
                }
                start(temp);
                System.out.print("Ban co muon tiep tuc khong (Y/N) ?? : ");
                String tmp = new Scanner(System.in).nextLine().trim();
                if (tmp.equals("N") || tmp.equals("n")) {
                    exit();
                }
            } catch (Exception e) {
                System.out.println(" Loi : !!! Ban hay nhap gia tri so !!!");
            }
        }
    }
}
