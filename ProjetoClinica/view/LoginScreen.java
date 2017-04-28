package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import dao.Acess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;
	private JTextField txtLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 221);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new TitledBorder(null, "Login Screen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(75, 45, 63, 23);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(148, 82, 117, 20);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(69, 79, 63, 23);
		lblSenha.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		
		txtLogin = new JTextField();
		txtLogin.setBounds(148, 48, 117, 20);
		txtLogin.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancel");
		btnCancelar.setBounds(174, 124, 102, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(75, 124, 76, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Acess cl = new Acess();
				try {
					cl.Acesso(txtLogin.getText(),txtSenha.getText());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(cl.acess==true){
					MenuScreen tl = new MenuScreen();
					tl.show();
					tl.setExtendedState(new MenuScreen().MAXIMIZED_BOTH);
					dispose();
				}else if(cl.acess==false){
					txtLogin.setText("");
					txtSenha.setText("");
					txtLogin.requestFocus();
				}
				
				cl.acess=false;
			}
		});
		btnLogin.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(txtSenha);
		contentPane.add(lblSenha);
		contentPane.add(txtLogin);
		contentPane.add(btnCancelar);
		contentPane.add(btnLogin);
	}
}
