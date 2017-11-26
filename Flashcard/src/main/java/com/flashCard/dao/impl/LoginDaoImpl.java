package com.flashCard.dao.impl;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.ModelAndView;
 
import com.flashCard.dao.LoginDao;
import com.flashCard.model.User;
 
public class LoginDaoImpl implements LoginDao {
 
       @Autowired
       DataSource datasource;
 
       @Autowired
       JdbcTemplate jdbcTemplate;
       public String saveLogin(User user) {
              String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
              String dbUserName = "newremoteuser";
              String dbPassword = "password";
              Connection conn = null;
              ModelAndView mav = null;
              boolean isValid = true;
              String response = "";
              if (!validateEmail(user)){
//                      mav = new ModelAndView("Register");
//                      mav.addObject("message", "Email already in use");
            	  isValid = false;
                     response = "Email already in use";
                }
                if (!validateUsername(user)){
//                      mav = new ModelAndView("Register");
//                      mav.addObject("message", "Username already in use");
                	isValid = false;
                	response = "Username already in use";
                }
              if(isValid) {
	              try {
	                    Class.forName("com.mysql.jdbc.Driver").newInstance();
	                    conn = DriverManager.getConnection(dbName, dbUserName, dbPassword);
	                    System.out.println("Database connection established");
	                    String insertSQL = "INSERT INTO User (USER_NAME, PASSWORD, EMAIL,NICKNAME) VALUES ('" + user.getUsername() + "' , '" + user.getPassword() +"', '" + user.getEmail() +"', '" +  user.getNickname() +"')";
	                    PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
	                    boolean rs= preparedStatement.execute();
	                    if(!rs) {
	                    	return "success";
	                    }else {
	                    	return "Unable to save user";
	                    }
	       
	               }
	               catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
	                    e.printStackTrace();
	               }
	              	catch (SQLException e) {
	                    e.printStackTrace();
	              	}
	             
	              try {
	            	  conn.close();
	              }
	              catch (SQLException e) {
	                    e.printStackTrace();
	              }
              }else {
            	  return response;
              }
			return response;
        
       }
       public boolean validateEmail(User user){
              String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
              String dbUserName = "newremoteuser";
              String dbPassword = "password";
              Connection conn = null;
              ModelAndView mav = null;

              try {
            	  Class.forName("com.mysql.jdbc.Driver").newInstance();
                  conn = DriverManager.getConnection(dbName, dbUserName, dbPassword);
                  
            	  String sql = ("SELECT * FROM User WHERE EMAIL ='" + user.getEmail() + "';");
            	  PreparedStatement preparedStatement = conn.prepareStatement(sql);
                  ResultSet rs= preparedStatement.executeQuery();
                  if(rs.next()){
                        return false;
                    }else {
                    	return true;
                    }
              } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
              }
              return false;
       }
       public boolean validateUsername(User user){
              String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
              String dbUserName = "newremoteuser";
              String dbPassword = "password";
              Connection conn = null;
              ModelAndView mav = null;
             
              Statement st = null;
              try {
            	  Class.forName("com.mysql.jdbc.Driver").newInstance();
                  conn = DriverManager.getConnection(dbName, dbUserName, dbPassword);
                  
                  String sql = ("SELECT * FROM User WHERE USER_NAME ='" + user.getUsername() + "';");
            	  PreparedStatement preparedStatement = conn.prepareStatement(sql);
                  ResultSet rs= preparedStatement.executeQuery();
                  if(rs.next()){
                      return false;
                  }else {
                	  return true;
                  }
             
              } catch (SQLException e1) {
                    e1.printStackTrace();
              } catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
        
       }
       public User validateLogin(User login) {
              User user = null;
              String sql = "select * from User where USER_NAME='" + login.getUsername() + "' and PASSWORD='"
                           + login.getPassword() + "'";
              String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
              String dbUserName = "newremoteuser";
              String dbPassword = "password";
              Connection conn = null;
              try {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = DriverManager.getConnection(dbName, dbUserName, dbPassword);
           System.out.println("Database connection established");
          PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
             ResultSet rs= preparedStatement.executeQuery();
              while(rs.next()) {
                    String username= rs.getString("USER_NAME");
                    String nickname = rs.getString("NICKNAME");
                    String email = rs.getString("EMAIL");
                    String password = rs.getString("PASSWORD");
                    user = new User(username, nickname, password, email);
                    }
              }
               catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
              } catch (SQLException e) {
                    e.printStackTrace();
              }
             
 
       try {
                    conn.close();
              } catch (SQLException e) {
                   
                    e.printStackTrace();
              }
       return user;
       }
       class UserMapper implements RowMapper<User> {
       public User mapRow(ResultSet rs, int arg1) throws SQLException {
              User user = new User();
              user.setUsername(rs.getString("USER_NAME"));
              user.setPassword(rs.getString("PASSWORD"));
              user.setNickname(rs.getString("NICKNAME"));
              user.setEmail(rs.getString("EMAIL"));
              return user;
       }
}
}
 