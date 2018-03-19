package kr.hs.dgsw.bgg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class PasswordChange extends JFrame implements ActionListener, KeyListener{
	private JTextField currentPw;
	private JTextField inputChangePw;
	private JTextField inputReChangePw;
	private JButton btnOk;
	private JButton button;
	String stringId;
	String changePw;
	String reChangePw;
	public PasswordChange() {
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(640,300,400,300);
		
		JLabel lblNow = new JLabel("현재 비밀번호");
		lblNow.setBounds(80, 57, 99, 30);
		getContentPane().add(lblNow);
		
		currentPw = new JPasswordField();
		currentPw.setBounds(180, 58, 162, 30);
		getContentPane().add(currentPw);
		currentPw.setColumns(10);
		
		JLabel label = new JLabel("바꿀 비밀번호");
		label.setBounds(80, 104, 99, 30);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("비밀번호 확인");
		label_1.setBounds(80, 155, 99, 30);
		getContentPane().add(label_1);
		
		inputChangePw = new JPasswordField();
		inputChangePw.setColumns(10);
		inputChangePw.setBounds(180, 105, 162, 30);
		getContentPane().add(inputChangePw);
		
		inputReChangePw = new JPasswordField();
		inputReChangePw.setColumns(10);
		inputReChangePw.setBounds(180, 156, 162, 30);
		getContentPane().add(inputReChangePw);
		
		btnOk = new JButton("확인");
		btnOk.setBounds(109, 212, 77, 39);
		getContentPane().add(btnOk);
		
		button = new JButton("취소");
		button.setBounds(235, 212, 77, 39);
		getContentPane().add(button);
		
		inputReChangePw.addKeyListener(this);
		btnOk.addActionListener(this);
		button.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("확인")){
			stringId = currentPw.getText();
			changePw = inputChangePw.getText();
			reChangePw = inputReChangePw.getText();
			try {
				if(new Back().PasswordCheck(stringId)){
					if(changePw.equals(reChangePw)){
						if(stringId.equals(changePw)){
							JOptionPane.showMessageDialog(null, "바뀔 비밀번호가 현재 비밀번호와 같습니다", "변경실패", JOptionPane.ERROR_MESSAGE);
						}else{
							if(new Back().ChangePw(changePw)){
								JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다", "변경성공", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "캬 변경이 안됬네요 왜 안됬는지는 몰라요~", "변경실패", JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "바뀔 비밀번호가 서로 다릅니다", "변경실패", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "현재 비밀번호가 다릅니다", "변경실패", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("취소")){
			dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			stringId = currentPw.getText();
			changePw = inputChangePw.getText();
			reChangePw = inputReChangePw.getText();
			try {
				if(new Back().PasswordCheck(stringId)){
					if(changePw.equals(reChangePw)){
						if(stringId.equals(changePw)){
							JOptionPane.showMessageDialog(null, "바뀔 비밀번호가 현재 비밀번호와 같습니다", "변경실패", JOptionPane.ERROR_MESSAGE);
						}else{
							if(new Back().ChangePw(changePw)){
								JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다", "변경성공", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "캬 변경이 안됐네요 왜 안됐는지는 몰라요~", "변경실패", JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "바뀔 비밀번호가 서로 다릅니다", "변경실패", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "현재 비밀번호가 다릅니다", "변경실패", JOptionPane.ERROR_MESSAGE);
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
