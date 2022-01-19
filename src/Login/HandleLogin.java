package Login;

import java.sql.*;
import javax.swing.JOptionPane;
import Mainwindows.MainFrame;
public  class  HandleLogin {
   Connection con;
   PreparedStatement preSql;
   ResultSet rs;
   public static String  id;
    public static String  pw;
    public HandleLogin(){
      try{  Class.forName("com.mysql.cj.jdbc.Driver");
      }
      catch(Exception e){}
      String 
      uri = "jdbc:mysql://localhost:3306/user"+
      "?useSSL=false&&serverTimezone=UTC&characterEncoding=utf-8";
      try{  
         con = DriverManager.getConnection(uri,"root","111111");
      }
      catch(SQLException e){}
   }
   public Login queryVerify(Login loginModel) {
        id = loginModel.getID();
       pw = loginModel.getPassword();
      String sqlStr ="select id,password from register where "+
                      "id = ? and password = ?";
      try { 
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,id);       
          preSql.setString(2,pw);  
          rs = preSql.executeQuery(); 
          if(rs.next()==true) {
             loginModel.setLoginSuccess(true);
             JOptionPane.showMessageDialog(null,"µÇÂ¼³É¹¦",
                             "¹§Ï²",JOptionPane.WARNING_MESSAGE);
              MainFrame win=new MainFrame();

          }
          else {
             loginModel.setLoginSuccess(false);
             JOptionPane.showMessageDialog(null,"µÇÂ¼Ê§°Ü",
                "µÇÂ¼Ê§°Ü£¬ÖØÐÂµÇÂ¼",JOptionPane.WARNING_MESSAGE);
          }
          con.close();
      }
      catch(SQLException e) {}
      return loginModel;
   }
}
