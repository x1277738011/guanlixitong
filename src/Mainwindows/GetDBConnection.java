package Mainwindows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDBConnection {
   public static Connection connectDB(String DBName,String id,String p) {
      Connection con = null;
      String 
      uri = "jdbc:mysql://localhost:3306/"+DBName+"?useSSL=false&serverTimezone=UTC";
      try{  Class.forName("com.mysql.cj.jdbc.Driver");//加载JDBC-MySQL驱动
      }
      catch(Exception e){}
      try{  
         con = DriverManager.getConnection(uri,id,p); //连接代码
      }
      catch(SQLException e){}
      return con;
   }
}