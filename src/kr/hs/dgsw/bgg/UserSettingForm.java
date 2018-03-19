package kr.hs.dgsw.bgg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserSettingForm extends JFrame implements ActionListener{
	public UserSettingForm() {
		String userId = Back.currentUserId+"님";
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);
		
		JLabel lblWelcome = new JLabel("환영합니다");
		lblWelcome.setBounds(34, 35, 68, 15);
		getContentPane().add(lblWelcome);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(34, 60, 127, 15);
		getContentPane().add(lblId);
		lblId.setText(userId);
		
		JButton btnComputersetting = new JButton("컴퓨터 설정");
		btnComputersetting.setBounds(57, 160, 269, 78);
		getContentPane().add(btnComputersetting);
		
		JButton button = new JButton("비밀번호 변경");
		button.setBounds(57, 281, 269, 78);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("회원 탈퇴");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(57, 402, 269, 78);
		getContentPane().add(button_1);
		setBounds(640, 300, 400, 600);
		
		btnComputersetting.addActionListener(this);
		button.addActionListener(this);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("컴퓨터 설정")){
			try {
				ComputerSettingForm computerSettingForm = new ComputerSettingForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("비밀번호 변경")){
			PasswordChange pc = new PasswordChange();
		}else if(e.getActionCommand().equals("회원 탈퇴")){
			UserExitForm exit = new UserExitForm();
		}
	}
}