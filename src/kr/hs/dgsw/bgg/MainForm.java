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
		
		JButton btnLogout = new JButton("����");
		btnLogout.setBounds(563, 10, 109, 44);
		getContentPane().add(btnLogout);
		
		JButton btnOptimization = new JButton("����ȭ �ڵ�");
		btnOptimization.setBounds(79, 103, 320, 107);
		getContentPane().add(btnOptimization);
		
		JButton btnHpet = new JButton("hpet ����");
		btnHpet.setBounds(80, 250, 319, 107);
		getContentPane().add(btnHpet);
		
		JButton computerOption = new JButton("ȸ����������");
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
		if(e.getActionCommand().equals("����")){
			JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�", "���α׷�����",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}else if(e.getActionCommand().equals("����ȭ �ڵ�")){
			new CodeForm();
		}else if(e.getActionCommand().equals("hpet ����")){
			new OptimizationForm();
		}else if(e.getActionCommand().equals("ȸ����������")){
			UserSettingForm userSetting = new UserSettingForm();
		}
	}
}
