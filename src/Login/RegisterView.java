package Login;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegisterView extends JPanel implements ActionListener {
    Register register;
    JTextField inputID;
    JPasswordField inputPassword;
    JButton buttonRegister;
    RegisterView() {

        register = new Register();
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        buttonRegister = new JButton("×¢²á");
        JLabel jLabel1 = new JLabel("ID:");
        JLabel jLabel2 = new JLabel("ÃÜÂë");
        add(jLabel1);
        add(inputID);
        add(jLabel2);
        add(inputPassword);
        add(buttonRegister);
        buttonRegister.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        register.setID(inputID.getText());
        char [] pw =inputPassword.getPassword();
        register.setPassword(new String(pw));
        HandleInsertData handleRegister = new HandleInsertData();
        handleRegister.writeRegisterModel(register);
    }
}
