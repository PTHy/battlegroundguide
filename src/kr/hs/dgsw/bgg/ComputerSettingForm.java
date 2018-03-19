package kr.hs.dgsw.bgg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ComputerSettingForm extends JFrame implements ActionListener{
	public static JLabel label;
	public static JLabel label_1;
	public static JLabel label_2;
	public static JLabel label_3;
	public static JLabel label_4;
	
	public static int A = 0;
	public static ComputerDeleteForm computerDeleteForm;
	ComputerSettingForm() throws SQLException {
		getContentPane().setLayout(null);
		setBounds(800,250,400,700);
		setVisible(true);
		setResizable(false);
		
		label = new JLabel("");
		label.setBounds(40, 64, 312, 77);
		getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(40, 151, 312, 77);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(40, 250, 312, 77);
		getContentPane().add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(40, 351, 312, 77);
		getContentPane().add(label_3);
		
		label_4 = new JLabel("");
		label_4.setBounds(40, 453, 312, 77);
		getContentPane().add(label_4);
		
		new Back().ComputerSettingFormBack();
		
		JButton btnPlus = new JButton("�߰�");
		btnPlus.setBounds(183, 10, 76, 34);
		getContentPane().add(btnPlus);
		
		JButton btnDelete = new JButton("����");
		btnDelete.setBounds(285, 10, 76, 34);
		getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("���");
		btnNewButton.setBounds(136, 573, 111, 50);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		btnPlus.addActionListener(this);
		btnDelete.addActionListener(this);
		try {
			new Back().ComputerSettingFormBack();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		repaint();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("�߰�")){
			try {
				if(new Back().ComputerIsFull()){
					new ComputerPlusForm();
				}
				else
					JOptionPane.showMessageDialog(null, "��ǻ�ʹ� 5������ �߰��Ͻ� �� �ֽ��ϴ�", "�߰�����",JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("����")){
			try {
				if(A == 0) {
					computerDeleteForm = new ComputerDeleteForm();
					A = 1;
				} else {
					computerDeleteForm.setVisible(true);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
