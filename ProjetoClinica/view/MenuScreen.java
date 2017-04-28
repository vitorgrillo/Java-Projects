package view;
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
public class MenuScreen extends JFrame {
 
 private JPanel contentPane;
 
 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     MenuScreen frame = new MenuScreen();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }
 
 /**
  * Create the frame.
  */
 public MenuScreen() {
  setTitle("Tela Principal");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 574, 336);
   
  JMenuBar menuBar = new JMenuBar();
  setJMenuBar(menuBar);
   
  JMenu mnGerenciamento = new JMenu("Cliente");
  menuBar.add(mnGerenciamento);
   
  JMenuItem mntmCliente = new JMenuItem("Cadastro");
  mntmCliente.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    
   }
  });
  mnGerenciamento.add(mntmCliente);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
 }
}
