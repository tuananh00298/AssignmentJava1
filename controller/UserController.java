/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.java1.assignment.controller;

import fpt.java1.assignment.dao.UserDAO;
import fpt.java1.assignment.model.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class xu ly cac van de lien quan den Controller
 * @author Thinh Nguyen
 */
public class UserController {

    private static User objUser;

    /**
     * Phuong thuc input hien thi giao dien ban dau voi nguoi dung
     */
    public static void input() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|******************** Chuong trinh quan ly User ********************|");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|   1. Them moi User                                                |");
        System.out.println("|   2. Hien thi danh sach User                                      |");
        System.out.println("|   3. Sua thong tin User                                           |");
        System.out.println("|   4. Xoa User                                                     |");
        System.out.println("|   5. Tim kiem User                                                |");
        System.out.println("|   6. Thoat                                                        |");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("| Chon :  ");
    }
    
    /**
     * Phuong thuc addUser the hien giao dien khi dung chuc nang addUser
     * @return se tra ve doi tuong la 1 Object User
     */
    public static User addUser() {
        User tmpUser = new User();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|************************* Them moi User ***************************|");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Nhap User ID : ");
        tmpUser.setId(new Scanner(System.in).nextLine());
        System.out.print("Nhap Ten User : ");
        tmpUser.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhap username : ");
        tmpUser.setUsername(new Scanner(System.in).nextLine());
        System.out.print("Nhap password : ");
        tmpUser.setPassword(new Scanner(System.in).nextLine());
        tmpUser.setStatus(true);
        return tmpUser;
    }
    
    /**
     * Phuong thuc showAll the hien giao dien khi in ra toan bo danh sach User
     */
    public static void showAll(ArrayList<User> listUser) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|************************** Danh sach User *************************|");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|  ID  |           Name           |    Username    |    Password    |");
        System.out.println("--------------------------------------------------------------------");
        listUser.forEach((user) -> {
            System.out.println(user);
        });
        System.out.println("--------------------------------------------------------------------");
    }

    /**
     * Phuong thuc loadUser the hien giao dien khi muon thay doi thong tin 1 User
     * @return se tra ve doi tuong la 1 Object User
     */
    public static User loadUser() {
        User tmpUser = new User();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|************************ Sua thong tin User ***********************|");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Nhap User ID : ");
        String id = new Scanner(System.in).nextLine();
        if (UserDAO.checkExistUser(id)) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("|  ID  |           Name           |    Username    |    Password    |");
            System.out.println("--------------------------------------------------------------------");
            UserDAO.loadUser(id);
            System.out.println("--------------------------------------------------------------------");
            tmpUser.setId(id);
            System.out.print("Nhap Ten User moi : ");
            tmpUser.setName(new Scanner(System.in).nextLine());
            System.out.print("Nhap username moi : ");
            tmpUser.setUsername(new Scanner(System.in).nextLine());
            System.out.print("Nhap password moi : ");
            tmpUser.setPassword(new Scanner(System.in).nextLine());
            tmpUser.setStatus(true);
            return tmpUser;
        } else {
            System.out.println("****** Loi : Khong ton tai User voi id = " + id + "*****");
            return tmpUser;
        }
    }

    /**
     * Phuong thuc findUser se hien thi ra giao dien khi muon tim kiem 1 User
     */
    public static void findUser() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|*********************** Tim thong tin User ************************|");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Nhap User ID : ");
        String id = new Scanner(System.in).nextLine();
        if (UserDAO.checkExistUser(id)) {
            UserDAO.loadUser(id);
        } else {
            System.out.println("Loi : Khong ton tai User voi id = " + id);
        }
    }
//    
//    private static User newUser(String id) {
//        objUser.setId(id);
//        System.out.print("Nhap Ten User moi : ");
//        objUser.setName(new Scanner(System.in).nextLine());
//        System.out.print("Nhap username moi : ");
//        objUser.setUsername(new Scanner(System.in).nextLine());
//        System.out.print("Nhap password moi : ");
//        objUser.setPassword(new Scanner(System.in).nextLine());
//        objUser.setStatus(true);
//        return objUser;
//    }

    /**
     * Phuong thuc deleteUser se the hien giao dien khi muon xoa mot User
     * @return tra ve doi tuong User
     */
    public static User deleteUser() {
        User tmpUser = new User();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|************************ Xoa thong tin User ***********************|");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Nhap User ID : ");
        String id = new Scanner(System.in).nextLine();
        if (UserDAO.checkExistUser(id)) {
            tmpUser.setId(id);
            UserDAO.deleteUser(tmpUser);
            return tmpUser;
        } else {
            System.out.println("Loi : Khong ton tai User voi id = " + id);
            return tmpUser;
        }
    }

    /**
     * Phuong thuc exit duoc goi khi thoat chuong tring ( co kem cau chao tam biet !!)
     */
    public static void exit() {
        System.out.println("--- Tam biet ! Cam on ban da su dung chuong trinh ---");
        System.exit(0);
    }

    /**
     * Phuong thuc chinh de chay chuong trinh
     * @param temp : chon tu 1 den 6 tuong ung voi 6 chuc nang cua chuong trinh
     */
    public static void start(int temp) {
        ArrayList<User> listUser;
        switch (temp) {
            case 1:
                objUser = addUser();
                UserDAO.insertUser(objUser);
                break;
            case 2:
                listUser = UserDAO.showAllUser();
                showAll(listUser);
                break;
            case 3:
                objUser = loadUser();
                UserDAO.update1User(objUser);
                break;
            case 4:
                deleteUser();
                break;
            case 5:
                findUser();
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println(" Loi : !!! Ban hay nhap gia tri tu 1-6 !!!");
                break;
        }
    }
}
