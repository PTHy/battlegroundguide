package kr.hs.dgsw.bgg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class CodeForm extends JFrame implements ActionListener{
	static JTextField txtCode;
	
	public CodeForm() {
		getContentPane().setLayout(null);
		
		txtCode = new JTextField();
		txtCode.setEditable(false);
		txtCode.setBounds(104, 130, 366, 41);
		getContentPane().add(txtCode);
		txtCode.setColumns(10);
		
		JLabel lblCode = new JLabel("코드");
		lblCode.setBounds(36, 143, 57, 15);
		getContentPane().add(lblCode);
		
		JButton btnCopy = new JButton("복사하기");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCopy.setBounds(482, 130, 90, 41);
		getContentPane().add(btnCopy);
		
		JButton btnSelect = new JButton("컴퓨터 선택");
		btnSelect.setBounds(186, 217, 212, 60);
		getContentPane().add(btnSelect);
		setBounds(800,250,600,400);
		setVisible(true);
		
		btnCopy.addActionListener(this);
		btnSelect.addActionListener(this);
		setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("컴퓨터 선택")){
			try {
				new CodeComSelectForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("복사하기")){
			CodeCopy<JTextField> codeCopy = new CodeCopy<JTextField>();
			if(codeCopy.Copy(txtCode))
				JOptionPane.showMessageDialog(null, "복사되었습니다", "복사성공", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "복사되지않았습니다", "복사실패", JOptionPane.ERROR_MESSAGE);
		}
	}
}
