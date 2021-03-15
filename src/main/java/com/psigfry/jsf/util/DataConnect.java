/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psigfry.jsf.util;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Psigfry
 */
public class DataConnect {
    public static Connection getConnection() {
        Connection connection = null;
        Statement stmt = null;
        String host="localhost";
        String port="5432";
        String db_name="testsql";
        String username="postgres";
        String password="qwerty";
        try {
            Class.forName("postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
                return connection;
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed");
        }
        return connection;
    }
    
    public static void close(Connection connection) {
		try {
			connection.close();
		} catch (Exception ex) {
		}
	}
}
