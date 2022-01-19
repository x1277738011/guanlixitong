package Login;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFrame;


public class MainWindow extends JFrame {
   JButton computerButton; 
   RegisterAndLoginView view;
  public MainWindow() {
      setBounds(100,100,800,260);
      view = new RegisterAndLoginView();
      add(view,BorderLayout.CENTER);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setVisible(true); 
   }


   public static void main(String args[]) {
       MainWindow window = new MainWindow();
       window.setTitle("教学管理系统");
   }
}
