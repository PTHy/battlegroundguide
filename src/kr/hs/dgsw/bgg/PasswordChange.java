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
		
		JLabel lblNow = new JLabel("���� ��й�ȣ");
		lblNow.setBounds(80, 57, 99, 30);
		getContentPane().add(lblNow);
		
		currentPw = new JPasswordField();
		currentPw.setBounds(180, 58, 162, 30);
		getContentPane().add(currentPw);
		currentPw.setColumns(10);
		
		JLabel label = new JLabel("�ٲ� ��й�ȣ");
		label.setBounds(80, 104, 99, 30);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("��й�ȣ Ȯ��");
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
		
		btnOk = new JButton("Ȯ��");
		btnOk.setBounds(109, 212, 77, 39);
		getContentPane().add(btnOk);
		
		button = new JButton("���");
		button.setBounds(235, 212, 77, 39);
		getContentPane().add(button);
		
		inputReChangePw.addKeyListener(this);
		btnOk.addActionListener(this);
		button.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Ȯ��")){
			stringId = currentPw.getText();
			changePw = inputChangePw.getText();
			reChangePw = inputReChangePw.getText();
			try {
				if(new Back().PasswordCheck(stringId)){
					if(changePw.equals(reChangePw)){
						if(stringId.equals(changePw)){
							JOptionPane.showMessageDialog(null, "�ٲ� ��й�ȣ�� ���� ��й�ȣ�� �����ϴ�", "�������", JOptionPane.ERROR_MESSAGE);
						}else{
							if(new Back().ChangePw(changePw)){
								JOptionPane.showMessageDialog(null, "��й�ȣ�� ����Ǿ����ϴ�", "���漺��", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "ļ ������ �ȉ�׿� �� �ȉ������ �����~", "�������", JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "�ٲ� ��й�ȣ�� ���� �ٸ��ϴ�", "�������", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "���� ��й�ȣ�� �ٸ��ϴ�", "�������", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("���")){
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
							JOptionPane.showMessageDialog(null, "�ٲ� ��й�ȣ�� ���� ��й�ȣ�� �����ϴ�", "�������", JOptionPane.ERROR_MESSAGE);
						}else{
							if(new Back().ChangePw(changePw)){
								JOptionPane.showMessageDialog(null, "��й�ȣ�� ����Ǿ����ϴ�", "���漺��", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "ļ ������ �ȵƳ׿� �� �ȵƴ����� �����~", "�������", JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "�ٲ� ��й�ȣ�� ���� �ٸ��ϴ�", "�������", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "���� ��й�ȣ�� �ٸ��ϴ�", "�������", JOptionPane.ERROR_MESSAGE);
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
