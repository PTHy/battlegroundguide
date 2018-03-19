package kr.hs.dgsw.bgg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;

public class OptimizationForm extends JFrame implements ActionListener{

	public static void runCommand(String command) throws IOException {
		Runtime.getRuntime().exec("cmd /C " + command);
	}
	
	public static void runCommandAsAdmin(String command) {
		Elevator.executeAsAdmin("c:\\windows\\system32\\cmd.exe", "/C " + command);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("hpet �ѱ�")){
			runCommandAsAdmin("bcdedit /set useplatformclock true");
		}else if(e.getActionCommand().equals("hpet ����")){
			runCommandAsAdmin("bcdedit /set useplatformclock false");
		}else if(e.getActionCommand().equals("hpet�̶�?")){
			
		}else if(e.getActionCommand().equals("Ȯ��")){
			dispose();
		}
	}
	
	OptimizationForm() {
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		setBounds(800, 400, 400, 300);
		setResizable(false);
		
		JButton button = new JButton("hpet �ѱ�");
		button.setBounds(51, 30, 282, 67);
		getContentPane().add(button);
		
		JButton btnNewButton_1 = new JButton("hpet�̶�?");
		btnNewButton_1.setBounds(65, 209, 100, 42);
		getContentPane().add(btnNewButton_1);
				
		JButton button_1 = new JButton("hpet ����");
		button_1.setBounds(51, 117, 282, 67);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Ȯ��");
		button_2.setBounds(218, 209, 100, 42);
		getContentPane().add(button_2);
		setVisible(true);
		
		button_2.addActionListener(this);
		button_1.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		button.addActionListener(this);
	}
}
