package kr.hs.dgsw.bgg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class UserExitCheck extends JFrame implements ActionListener{
	public UserExitCheck() {
		getContentPane().setLayout(null);
		
		JLabel lblChk = new JLabel("정말 간절히 회원탈퇴를 원하십니까?");
		lblChk.setBounds(44, 28, 217, 48);
		getContentPane().add(lblChk);
		
		JButton btnOk = new JButton("확인");
		btnOk.setBounds(44, 108, 84, 43);
		getContentPane().add(btnOk);
		
		JButton button = new JButton("취소");
		button.setBounds(162, 108, 84, 43);
		getContentPane().add(button);
		
		JLabel label = new JLabel("※탈퇴하시면 복구하실 수 없습니다");
		label.setBounds(44, 72, 207, 15);
		getContentPane().add(label);
		setVisible(true);
		setBounds(800,500,300,200);
		
		btnOk.addActionListener(this);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("확인")){
			try {
				if(new Back().UserExit()){
					JOptionPane.showMessageDialog(null, "지금까지 저희서비스를 이용해주셔서 감사합니다\n프로그램을 재실행 해주세요", "탈퇴성공", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}else{
					JOptionPane.showMessageDialog(null, "탈퇴에 실패하였습니다", "탈퇴실패", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("취소")){
			JOptionPane.showMessageDialog(null, "잘 생각하셨습니다", "감사", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}
}
