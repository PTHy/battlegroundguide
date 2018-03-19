package kr.hs.dgsw.bgg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ComputerDeleteForm extends JFrame implements ActionListener, MouseListener, WindowListener {
	// new할 때 마다 static변수가 중복생성되는 오류
	public static JButton btn = new JButton("");
	public static JButton btn_1 = new JButton("");
	public static JButton btn_2 = new JButton("");
	public static JButton btn_3 = new JButton("");
	public static JButton btn_4 = new JButton("");
	public JButton btnExit;
	int chk = 0;

	ComputerDeleteForm() throws SQLException {
		getContentPane().setLayout(null);
		setBounds(900, 350, 400, 700);
		setVisible(true);
		setResizable(false);

		btn.setBounds(40, 64, 312, 77);
		btn.setVisible(false);
		getContentPane().add(btn);

		btn_1.setBounds(40, 151, 312, 77);
		btn_1.setVisible(false);
		getContentPane().add(btn_1);

		btn_2.setVisible(false);
		btn_2.setBounds(40, 250, 312, 77);
		getContentPane().add(btn_2);

		btn_3.setVisible(false);
		btn_3.setBounds(40, 351, 312, 77);
		getContentPane().add(btn_3);

		btn_4.setVisible(false);
		btn_4.setBounds(40, 453, 312, 77);
		getContentPane().add(btn_4);

		btnExit = new JButton("취소");
		btnExit.setBounds(136, 573, 111, 50);
		getContentPane().add(btnExit);

		try {
			new Back().ButtonFormBack();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		addWindowListener(this);

		repaint();

		// 액션 리스너
		btn.addActionListener(this);
		btn_1.addActionListener(this);
		btn_2.addActionListener(this);
		btn_3.addActionListener(this);
		btn_4.addActionListener(this);
		btnExit.addActionListener(this);

		// 마우스 리스너
		addMouseListener(this);
		btn.addMouseListener(this);
		btn_1.addMouseListener(this);
		btn_2.addMouseListener(this);
		btn_3.addMouseListener(this);
		btn_4.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object check = e.getSource();

		if (check.equals(btn)) {
			try {
				new Back().ComputerDelete(btn.getText());
				new Back().ButtonFormBack();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (check.equals(btn_1))

		{
			try {
				new Back().ComputerDelete(btn_1.getText());
				new Back().ButtonFormBack();
				validate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (check.equals(btn_2)) {
			try {
				new Back().ComputerDelete(btn_2.getText());
				new Back().ButtonFormBack();
				validate();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} else if (check.equals(btn_3)) {
			try {
				new Back().ComputerDelete(btn_3.getText());
				new Back().ButtonFormBack();
				validate();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (check.equals(btn_4)) {
			try {
				if (chk == 0) {
					new Back().ComputerDelete(btn_4.getText());
					new Back().ButtonFormBack();
					validate();

				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (check.equals(btnExit)) {
			chk = 0;
			setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println("X : " + e.getX() + "Y : " + e.getY());
		// System.out.println("눌렸음");
		// if (e.getButton() == 1)
		// chk = 0;
		// System.out.println("chk : " + chk);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
//		ComputerSettingForm.A = 0;
		setVisible(false);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
