package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginView extends JPanel implements ActionListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = -478640763899809884L;
Login login;
   JTextField inputID;
   JPasswordField inputPassword;
   JButton buttonLogin;
   boolean loginSuccess;
   public static String a;
   LoginView() {
      login = new Login();
      inputID = new JTextField(12);
      inputPassword = new JPasswordField(12);
      buttonLogin = new JButton("µÇÂ¼");
      add(new JLabel("ID:"));
      add(inputID);
      add(new JLabel("ÃÜÂë:"));
      add(inputPassword);
      add(buttonLogin); 
      buttonLogin.addActionListener(this);
   }
   public boolean isLoginSuccess() {
      return loginSuccess;    
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      login.setID(inputID.getText());
      a=inputID.getText().substring(0,1);
      char [] pw =inputPassword.getPassword();
      login.setPassword(new String(pw));
      HandleLogin handleLogin = new HandleLogin();
      login = handleLogin.queryVerify(login);
      loginSuccess = login.getLoginSuccess();
   }
}