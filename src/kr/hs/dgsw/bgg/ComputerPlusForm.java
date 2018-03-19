package kr.hs.dgsw.bgg;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ComputerPlusForm extends JFrame implements ActionListener{
	private JTextField txtName;
	private JTextField txtCore;
	private JTextField txtRam;
	private JTextField txtVram;
	private JTextField txtMonitor;
	private JTextField txtThreads;
	public ComputerPlusForm() {
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		setBounds(640, 400,	600, 400);
		setVisible(true);
		setResizable(false);
		
		JLabel lblName = new JLabel("�̸�");
		lblName.setBounds(52, 52, 57, 15);
		getContentPane().add(lblName);
		
		JLabel lblCpu = new JLabel("cpu�ھ� ��");
		lblCpu.setBounds(262, 52, 82, 15);
		getContentPane().add(lblCpu);
		
		JLabel lblVram = new JLabel("Vram");
		lblVram.setBounds(287, 192, 57, 15);
		getContentPane().add(lblVram);
		
		JLabel lblRam = new JLabel("ram");
		lblRam.setBounds(52, 124, 57, 15);
		getContentPane().add(lblRam);
		
		JLabel lblMonitor = new JLabel("����� �ֻ���");
		lblMonitor.setBounds(27, 192, 82, 15);
		getContentPane().add(lblMonitor);
		
		txtName = new JTextField();
		txtName.setBounds(121, 49, 116, 21);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtCore = new JTextField();
		txtCore.setBounds(339, 49, 57, 21);
		getContentPane().add(txtCore);
		txtCore.setColumns(10);
		
		txtRam = new JTextField();
		txtRam.setBounds(121, 121, 57, 21);
		getContentPane().add(txtRam);
		txtRam.setColumns(10);
		
		txtVram = new JTextField();
		txtVram.setBounds(339, 189, 57, 21);
		getContentPane().add(txtVram);
		txtVram.setColumns(10);
		
		txtMonitor = new JTextField();
		txtMonitor.setBounds(121, 189, 57, 21);
		getContentPane().add(txtMonitor);
		txtMonitor.setColumns(10);
		
		txtThreads = new JTextField();
		txtThreads.setBounds(339, 121, 57, 21);
		getContentPane().add(txtThreads);
		txtThreads.setColumns(10);
		
		JLabel lblThread = new JLabel("������");
		lblThread.setBounds(287, 124, 57, 15);
		getContentPane().add(lblThread);
		
		JButton btnOk = new JButton("Ȯ��");
		btnOk.setBounds(112, 282, 90, 41);
		getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("���");
		btnCancel.setBounds(282, 282, 90, 41);
		getContentPane().add(btnCancel);
		
		JLabel lblHz = new JLabel("Hz");
		lblHz.setBounds(180, 192, 57, 15);
		getContentPane().add(lblHz);
		
		JLabel lblGb = new JLabel("GB");
		lblGb.setBounds(180, 124, 57, 15);
		getContentPane().add(lblGb);
		
		JLabel lblGb_1 = new JLabel("GB");
		lblGb_1.setBounds(398, 192, 57, 15);
		getContentPane().add(lblGb_1);
		
		JLabel lblGe = new JLabel("��");
		lblGe.setBounds(398, 124, 57, 15);
		getContentPane().add(lblGe);
		
		JLabel lblGe_1 = new JLabel("��");
		lblGe_1.setBounds(398, 52, 57, 15);
		getContentPane().add(lblGe_1);
		setBounds(640,400,500,400);
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Ȯ��")){
			if(txtName.getText().length() != 0){
				try {
					if(new Back().ComputerOverlap(txtName)){
						try {
							if(new Back().ComputerPlus(txtName,txtCore,txtRam,txtThreads,txtMonitor,txtVram)){
								new Back().ComputerSettingFormBack();
								new Back().ButtonFormBack();
								dispose();
								JOptionPane.showMessageDialog(null, "�߰��Ǿ����ϴ�", "�߰�����",JOptionPane.INFORMATION_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "��ǻ�Ͱ� �߰����� �ʾҽ��ϴ�", "�߰�����",JOptionPane.ERROR_MESSAGE);
							}
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else
						JOptionPane.showMessageDialog(null, "�̸��� �ߺ��� �� �����ϴ�", "�̸��ߺ�",JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else
				JOptionPane.showMessageDialog(null, "�̸��� ������ �� �� �����ϴ�", "�߰�����",JOptionPane.ERROR_MESSAGE);
		}else if(e.getActionCommand().equals("���")){
			dispose();
		}
	}
}