package Login;

import java.sql.*;
import javax.swing.JOptionPane;
public class HandleInsertData {
    Connection con;
    PreparedStatement preSql;
    public HandleInsertData(){
        con = GetDBConnection.connectDB("user","root","111111");
    }
    public void writeRegisterModel(Register register) {
        String sqlStr ="insert into register values(?,?)";
        int ok = 0;
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1,register.getID());
            preSql.setString(2,register.getPassword());
            ok = preSql.executeUpdate();
            con.close();
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"id�����ظ�","����",
                    JOptionPane.WARNING_MESSAGE);
        }
        if(ok!=0) {
            JOptionPane.showMessageDialog(null,"ע��ɹ�",
                    "��ϲ",JOptionPane.WARNING_MESSAGE);
        }
    }
}

