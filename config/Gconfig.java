/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.java1.assignment.config;

/**
 * Luu cac thong tin lien quan den connect DB SQLExpress
 *
 * @author Thinh Nguyen
 */
public class Gconfig {

    private final String username = "sa";
    private final String password = "thinh123";
    private final String hostname = "localhost";
    private final String sqlInstanceName = "SQLEXPRESS";
    private final String database = "AssignmentJava1";
    private final String classForname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url = "jdbc:sqlserver://" + hostname + ":1433"
            + ";instance=" + sqlInstanceName + ";databaseName=" + database;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getClassForname() {
        return classForname;
    }
}
