package kr.hs.dgsw.bgg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CodeComSelectForm extends JFrame{
	static JButton btnSelect = new JButton("");
	static JButton btnSelect_1 = new JButton("");
	static JButton btnSelect_2 = new JButton("");
	static JButton btnSelect_3 = new JButton("");
	static JButton btnSelect_4 = new JButton("");
	
	public CodeComSelectForm() throws SQLException {
		getContentPane().setLayout(null);
		setBounds(900,350,400,700);
		setVisible(true);
		setResizable(false);
	
		btnSelect.setBounds(40, 64, 312, 77);
		btnSelect.setVisible(false);
		getContentPane().add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CodeForm.txtCode.setText(new Back().CodeBack(btnSelect.getText()));
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
			
		});
		
		btnSelect_1.setBounds(40, 151, 312, 77);
		btnSelect_1.setVisible(false);
		getContentPane().add(btnSelect_1);
		btnSelect_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CodeForm.txtCode.setText(new Back().CodeBack(btnSelect_1.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		btnSelect_2.setVisible(false);
		btnSelect_2.setBounds(40, 250, 312, 77);
		getContentPane().add(btnSelect_2);
		btnSelect_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CodeForm.txtCode.setText(new Back().CodeBack(btnSelect_2.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		btnSelect_3.setVisible(false);
		btnSelect_3.setBounds(40, 351, 312, 77);
		getContentPane().add(btnSelect_3);
		btnSelect_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CodeForm.txtCode.setText(new Back().CodeBack(btnSelect_3.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		btnSelect_4.setVisible(false);
		btnSelect_4.setBounds(40, 453, 312, 77);
		getContentPane().add(btnSelect_4);
		btnSelect_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					CodeForm.txtCode.setText(new Back().CodeBack(btnSelect_4.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("√Îº“");
		btnNewButton.setBounds(136, 573, 111, 50);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		new Back().ButtonFormBack();
		
		validate();
	}
}
