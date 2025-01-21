package com.sakshi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sakshi.servlet.User;

public class RegisterDao {
      private String url = "jdbc:mysql://localhost:3306/sakshi";
      private String username = "root";
      private String password = "Shruti@2003";
      private String driver = "com.mysql.cj.jdbc.Driver";
      public void loadDriver(String Driver) {
    	  try {
    		  Class.forName(Driver);
    	  } catch(ClassNotFoundException e) {
    		  e.printStackTrace();
    	  }
      }
      public Connection getConnection() {
    	  Connection con = null;
    	  try {
    		  con = DriverManager.getConnection(url, username, password);
    	  } catch(SQLException e) {
    		  e.printStackTrace();
    	  }
    	  return con;
      }
      public String insert(User user) {
    	  loadDriver(driver);
    	  Connection con = getConnection();
    	  String sql = "insert into user values(?,?,?)";
    	  String result = "Data Entered Successfully";
    	  try {
    		  PreparedStatement ps = con.prepareStatement(sql);
    		  ps.setString(1, user.getUsername());
    		  ps.setString(2, user.getEmail());
    		  ps.setString(3, user.getPassword());
    		  //ps.setString(3, user.getEmail());
    		  ps.executeUpdate();
    		  } catch(SQLException e) {
    			  result = "Data Not Entered Successfully";
    			  e.printStackTrace();
    		  }
    	  return result;
      }
}
