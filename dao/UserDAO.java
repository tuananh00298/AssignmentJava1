/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.java1.assignment.dao;

import fpt.java1.assignment.jdbc.DBUtil;
import fpt.java1.assignment.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thinh Nguyen
 */
public class UserDAO {

    private static User objUser;

    /**
     * Phuong thuc de them 1 User vao DB
     * @param objUser : nhan parameter la 1 User
     */
    public static void insertUser(User objUser) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = DBUtil.openConnection();
            pstm = con.prepareStatement("insert into T_User values (?,?,?,?,?)");
            pstm.setString(1, objUser.getId());
            pstm.setString(2, objUser.getName());
            pstm.setString(3, objUser.getUsername());
            pstm.setString(4, objUser.getPassword());
            pstm.setBoolean(5, objUser.getStatus());
            pstm.execute();
            System.out.println("Insert User " + objUser.getName() + " Success !!!");
        } catch (SQLException e) {
            System.out.println("Loi insert DB : " + e.getMessage());
        } finally {
            DBUtil.closeAll(pstm, con);
        }
    }

    /**
     * Phuong thuc dung khi xoa 1 User khoi DB
     * @param objUser nhan parameter la User
     */
    public static void deleteUser(User objUser) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = DBUtil.openConnection();
            pstm = con.prepareStatement("delete from T_User where id = ?");
            pstm.setString(1, objUser.getId());
            pstm.execute();
            System.out.println("Delete User voi id = " + objUser.getId() + " Success !!!");
        } catch (SQLException e) {
            System.out.println("Loi DB : " + e.getMessage());
        } finally {
            DBUtil.closeAll(pstm, con);
        }
    }

    /**
     * Phuong thuc hien thi tat ca User
     * @return tra ve 1 List cac User
     */
    public static ArrayList<User> showAllUser() {
        ArrayList<User> listUser = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.openConnection();
            pstm = con.prepareStatement("Select * from T_User");
            rs = pstm.executeQuery();

            while (rs.next()) {
                objUser = new User();
                objUser.setId(rs.getString(1));
                objUser.setName(rs.getString(2));
                objUser.setUsername(rs.getString(3));
                objUser.setPassword(rs.getString(4));
                objUser.setStatus(true);
                listUser.add(objUser);
            }
        } catch (SQLException e) {
            System.out.println("Loi insert DB : " + e.getMessage());
        } finally {
            DBUtil.closeAll(pstm, con, rs);
        }
        return listUser;
    }

    /**
     * Phuong thuc kiem tra 1 User co ton tai trong DB hay khong
     * @param id : nhan vao id cua User
     * @return : tra ve true neu co ton tai, false neu khong ton tai
     */
    public static boolean checkExistUser(String id) {
        boolean flag = false;
        Connection con = DBUtil.openConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("select * from T_User where id = ?");
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
        } finally {
            DBUtil.closeAll(pstm, con, rs);
        }
        return flag;
    }

    /**
     * Phuong thuc hien thi thong tin 1 User
     * @param id : nhan parameter la id cua User can tim
     */
    public static void loadUser(String id) {
        Connection con = DBUtil.openConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("select * from T_User where id = ?");
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                User tmpUser = new User();
                tmpUser.setId(rs.getString(1));
                tmpUser.setName(rs.getString(2));
                tmpUser.setUsername(rs.getString(3));
                tmpUser.setPassword(rs.getString(4));
                tmpUser.setStatus(true);
                System.out.println(tmpUser);
            }
        } catch (SQLException e) {
        } finally {
            DBUtil.closeAll(pstm, con, rs);
        }
    }

    /**
     * Phuong thuc de sua thong tin cua 1 User
     * @param objUserNew : Doi tuong moi can thay doi
     */
    public static void update1User(User objUserNew) {
        Connection con = DBUtil.openConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("update T_USER set name = ? , username = ? , password = ? where id = ?");
            pstm.setString(1, objUserNew.getName());
            pstm.setString(2, objUserNew.getUsername());
            pstm.setString(3, objUserNew.getPassword());
            pstm.setString(4, objUserNew.getId());
            int i = pstm.executeUpdate();
            if (i == 1) {
                System.out.println("Ban da update thanh cong User voi id = " + objUserNew.getId());
            }
        } catch (SQLException e) {
        } finally {
            DBUtil.closeAll(pstm, con);
        }
    }
}
