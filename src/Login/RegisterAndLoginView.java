package Login;

import javax.swing.*;
import java.awt.*;
public class RegisterAndLoginView extends JPanel{
    JTabbedPane p;
    RegisterView registerView;
    LoginView loginView;
    public RegisterAndLoginView(){
        registerView=new RegisterView();
        loginView = new LoginView();
        setLayout(new BorderLayout());
        p = new JTabbedPane();
        p.add("ע��",registerView);
        p.add("��¼",loginView);
        registerView.setEnabled(false);
        p.validate();
        add(p,BorderLayout.CENTER); 
    }
    public boolean isLoginSuccess() {
        return loginView.isLoginSuccess();
    }
}
