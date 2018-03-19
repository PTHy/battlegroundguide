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
		
		JLabel lblChk = new JLabel("���� ������ ȸ��Ż�� ���Ͻʴϱ�?");
		lblChk.setBounds(44, 28, 217, 48);
		getContentPane().add(lblChk);
		
		JButton btnOk = new JButton("Ȯ��");
		btnOk.setBounds(44, 108, 84, 43);
		getContentPane().add(btnOk);
		
		JButton button = new JButton("���");
		button.setBounds(162, 108, 84, 43);
		getContentPane().add(button);
		
		JLabel label = new JLabel("��Ż���Ͻø� �����Ͻ� �� �����ϴ�");
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
		if(e.getActionCommand().equals("Ȯ��")){
			try {
				if(new Back().UserExit()){
					JOptionPane.showMessageDialog(null, "���ݱ��� ���񼭺񽺸� �̿����ּż� �����մϴ�\n���α׷��� ����� ���ּ���", "Ż�𼺰�", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}else{
					JOptionPane.showMessageDialog(null, "Ż�� �����Ͽ����ϴ�", "Ż�����", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("���")){
			JOptionPane.showMessageDialog(null, "�� �����ϼ̽��ϴ�", "����", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}
}
