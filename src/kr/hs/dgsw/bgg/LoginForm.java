package kr.hs.dgsw.bgg;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener , KeyListener{

	Font labelFont = new Font("돋움", Font.BOLD, 30);
	private JTextField idInput;
	private JTextField pwInput;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("회원가입")){
			new JoinForm();
		}
		else if(e.getActionCommand().equals("로그인")){
			try {
				if(new Back().LoginBack(idInput,pwInput)){	
					dispose();
					new MainForm();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else
			System.out.println("나도 모르겠오욤..ㅠ");
	}

	
	LoginForm() {
		getContentPane().setLayout(null);
		setBounds(640, 300, 700, 500);
		setTitle("BattleGroundGuide");
		setVisible(true);
			
		JLabel idWrite = new JLabel("ID");
		idWrite.setBounds(180, 240, 35, 45);
		idWrite.setFont(labelFont);
		getContentPane().add(idWrite);

		JLabel pwWrite = new JLabel("PW");
		pwWrite.setBounds(180, 295, 50, 45);
		pwWrite.setFont(labelFont);
		getContentPane().add(pwWrite);

		idInput = new JTextField();
		idInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		idInput.setBounds(293, 249, 220, 39);
		getContentPane().add(idInput);
		idInput.setColumns(10);

		pwInput = new JPasswordField();
		pwInput.setColumns(10);
		pwInput.setBounds(293, 298, 220, 39);
		pwInput.addKeyListener(this);
		getContentPane().add(pwInput);

		JButton joinButton = new JButton("회원가입");
		joinButton.setVisible(true);
		joinButton.setBounds(211, 382, 97, 45);
		getContentPane().add(joinButton);

		JButton loginButton = new JButton("로그인");
		loginButton.setBounds(382, 382, 97, 45);
		getContentPane().add(loginButton);
		
		joinButton.addActionListener(this);
		loginButton.addActionListener(this);
		
		setResizable(false);
		repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		LoginForm loginForm = new LoginForm();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			try {
				if(new Back().LoginBack(idInput,pwInput)){
					dispose();
					idInput = null;
					pwInput = null;
					MainForm mainForm = new MainForm();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
