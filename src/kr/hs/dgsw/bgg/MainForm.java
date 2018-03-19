package kr.hs.dgsw.bgg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainForm extends JFrame implements ActionListener{
	
	public MainForm() {
		getContentPane().setLayout(null);
		
		JButton btnLogout = new JButton("종료");
		btnLogout.setBounds(563, 10, 109, 44);
		getContentPane().add(btnLogout);
		
		JButton btnOptimization = new JButton("최적화 코드");
		btnOptimization.setBounds(79, 103, 320, 107);
		getContentPane().add(btnOptimization);
		
		JButton btnHpet = new JButton("hpet 설정");
		btnHpet.setBounds(80, 250, 319, 107);
		getContentPane().add(btnHpet);
		
		JButton computerOption = new JButton("회원정보수정");
		computerOption.setBounds(438, 10, 113, 44);
		getContentPane().add(computerOption);
		setBounds(640,300,700,500);
		setVisible(true);
		
		btnLogout.addActionListener(this);
		btnOptimization.addActionListener(this);
		btnHpet.addActionListener(this);
		computerOption.addActionListener(this);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("종료")){
			JOptionPane.showMessageDialog(null, "종료되었습니다", "프로그램종료",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}else if(e.getActionCommand().equals("최적화 코드")){
			new CodeForm();
		}else if(e.getActionCommand().equals("hpet 설정")){
			new OptimizationForm();
		}else if(e.getActionCommand().equals("회원정보수정")){
			UserSettingForm userSetting = new UserSettingForm();
		}
	}
}
