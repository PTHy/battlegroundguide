package kr.hs.dgsw.bgg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.JButton;

public class UserExitForm extends JFrame implements ActionListener, KeyListener{
	private JTextField inputPw;
	String stringPw;
	public UserExitForm() {
		getContentPane().setLayout(null);
		
		JLabel lblAsf = new JLabel("본인확인을 위해 비밀번호를 한번 더");
		lblAsf.setBounds(34, 20, 208, 23);
		getContentPane().add(lblAsf);
		
		inputPw = new JPasswordField();
		inputPw.setBounds(34, 69, 208, 36);
		getContentPane().add(inputPw);
		inputPw.setColumns(10);
		
		JButton btnOk = new JButton("확인");
		btnOk.setBounds(53, 115, 71, 36);
		getContentPane().add(btnOk);
		
		JButton button = new JButton("취소");
		button.setBounds(154, 115, 71, 36);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("입력해주세요");
		lblNewLabel.setBounds(34, 44, 78, 15);
		getContentPane().add(lblNewLabel);
		setVisible(true);
		setBounds(640,400,300,200);
		
		btnOk.addActionListener(this);
		button.addActionListener(this);
		inputPw.addKeyListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			stringPw = inputPw.getText();
			try {
				if(new Back().PasswordCheck(stringPw)){
					dispose();
					UserExitCheck exitCheck = new UserExitCheck();
				}else{
					JOptionPane.showMessageDialog(null, "비밀번호를 확인하세요", "오류", JOptionPane.ERROR_MESSAGE);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("확인")){
			stringPw = inputPw.getText();
			try {
				if(new Back().PasswordCheck(stringPw)){
					dispose();
					UserExitCheck exitCheck = new UserExitCheck();
				}else{
					JOptionPane.showMessageDialog(null, "비밀번호를 확인하세요", "오류", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("취소")){
			dispose();
		}
	}

}
