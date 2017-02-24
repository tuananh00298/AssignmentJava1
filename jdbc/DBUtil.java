/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.java1.assignment.jdbc;

import fpt.java1.assignment.config.Gconfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thinh Nguyen
 */
public class DBUtil {

    public static void closeAll(PreparedStatement pstm, Connection con, ResultSet rs) {
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void closeAll(PreparedStatement pstm, Connection con) {
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void closeAll(Statement stm, Connection con) {
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public static Connection openConnection() {
        Connection con = null;
        Gconfig cfig = new Gconfig();
        try {
            Class.forName(cfig.getClassForname());
            con = DriverManager.getConnection(cfig.getUrl(), cfig.getUsername(), cfig.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection DB Failed : " + e.getMessage());
        }
        return con;
    }
}
