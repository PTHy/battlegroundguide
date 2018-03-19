package kr.hs.dgsw.bgg;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.*;

public class JoinForm extends JFrame implements ActionListener, KeyListener {
	private JTextField inputName;
	private JTextField inputAge;
	private JTextField inputId;
	private JTextField inputPassword;
	private JTextField inputRePassword;

	String stringAge;
	int idChk = 0;
	int nullCnt = 0;
	JRadioButton rbMale = new JRadioButton("남자");
	JRadioButton rbFemale = new JRadioButton("여자");
	private JPasswordField pwdSdfsdf;

	public static boolean isNumber(String str) {
		if (str == null || str.equals(""))
			return false;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		stringAge = inputAge.getText();
		if (e.getActionCommand().equals("확인")) {
			if (nullCnt <= 0) {
				if (idChk == 1) {
					if (inputPassword.getText().equals(inputRePassword.getText())) {
						if (isNumber(stringAge)) {
							if (rbMale.isSelected() == true) {
								try {
									dispose();
									new Back().JoinMain(inputName, "남자", stringAge, inputId, inputPassword);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else {
								try {
									dispose();
									new Back().JoinMain(inputName, "여자", stringAge, inputId, inputPassword);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "나이는 숫자만 입력 가능합니다", "오류", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 서로 다릅니다", "오류", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요", "오류", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "빈 칸이 존재합니다", "오류", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getActionCommand().equals("중복체크")) {
			try {
				if (new Back().OverlapCheck(inputId) == 1) {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다", "중복체크", JOptionPane.INFORMATION_MESSAGE);
					idChk = 1;
				} else {
					JOptionPane.showMessageDialog(null, "사용 불가능한 아이디입니다", "중복체크", JOptionPane.ERROR_MESSAGE);
					idChk = 0;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("취소")) {
			dispose();
		}
	}

	JoinForm() {
		// TODO Auto-generated constructor stub

		setTitle("회원가입");
		setVisible(true);
		setBounds(800, 300, 400, 500);
		getContentPane().setLayout(null);
		setResizable(false);

		JLabel lblJoinmain = new JLabel("회원가입");
		lblJoinmain.setBounds(160, 33, 57, 15);
		getContentPane().add(lblJoinmain);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(65, 92, 32, 15);
		getContentPane().add(lblName);

		JLabel lblGener = new JLabel("성별");
		lblGener.setBounds(65, 144, 32, 15);
		getContentPane().add(lblGener);

		JLabel lblAge = new JLabel("나이");
		lblAge.setBounds(65, 199, 32, 15);
		getContentPane().add(lblAge);

		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(63, 250, 48, 15);
		getContentPane().add(lblId);

		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setBounds(65, 296, 72, 15);
		getContentPane().add(lblPw);

		JLabel lblRepw = new JLabel("비밀번호확인");
		lblRepw.setBounds(56, 337, 81, 15);
		getContentPane().add(lblRepw);

		inputName = new JTextField();
		inputName.setBounds(149, 89, 116, 23);
		getContentPane().add(inputName);
		inputName.setColumns(10);

		rbMale.setBounds(149, 140, 68, 23);
		getContentPane().add(rbMale);
		rbMale.addActionListener(this);

		rbFemale.setBounds(213, 140, 57, 23);
		getContentPane().add(rbFemale);

		ButtonGroup gender = new ButtonGroup();
		gender.add(rbMale);
		gender.add(rbFemale);

		inputAge = new JTextField();
		inputAge.setBounds(149, 195, 48, 23);
		getContentPane().add(inputAge);
		inputAge.setColumns(10);

		inputId = new JTextField();
		inputId.setBounds(149, 247, 107, 21);
		getContentPane().add(inputId);
		inputId.setColumns(10);

		JButton btnOverlapcheck = new JButton("중복체크");
		btnOverlapcheck.setBounds(268, 241, 88, 33);
		getContentPane().add(btnOverlapcheck);

		inputPassword = new JPasswordField();
		inputPassword.setBounds(149, 293, 107, 21);
		getContentPane().add(inputPassword);
		inputPassword.setColumns(10);

		inputRePassword = new JPasswordField();
		inputRePassword.setBounds(149, 334, 107, 21);
		getContentPane().add(inputRePassword);
		inputRePassword.setColumns(10);

		JButton btnFinish = new JButton("확인");
		btnFinish.setBounds(99, 401, 75, 50);
		getContentPane().add(btnFinish);

		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(234, 401, 75, 50);
		getContentPane().add(btnCancel);

		btnFinish.addActionListener(this);
		btnCancel.addActionListener(this);
		btnOverlapcheck.addActionListener(this);
		inputRePassword.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			stringAge = inputAge.getText();
			if (nullCnt <= 0) {
				if (idChk == 1) {
					if (inputPassword.getText().equals(inputRePassword.getText())) {
						if (isNumber(stringAge)) {
							if (rbMale.isSelected() == true) {
								try {
									dispose();
									new Back().JoinMain(inputName, "남자", stringAge, inputId, inputPassword);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else {
								try {
									dispose();
									new Back().JoinMain(inputName, "여자", stringAge, inputId, inputPassword);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "나이는 숫자만 입력 가능합니다", "오류", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 서로 다릅니다", "오류", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요", "오류", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "빈 칸이 존재합니다", "오류", JOptionPane.WARNING_MESSAGE);
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
