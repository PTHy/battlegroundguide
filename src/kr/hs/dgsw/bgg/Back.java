package kr.hs.dgsw.bgg;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.jna.platform.win32.WinDef.BOOL;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.*;

public class Back {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/battlegroundguide";
	public static Connection conn = null;
	public static PreparedStatement stmt = null;
	public static PreparedStatement stmt2 = null;
	public static ResultSet rs;
	public static String currentUserId;

	public static int OverlapCheck(JTextField inputId) throws SQLException {
		int chk = 0;
		String stringId = inputId.getText();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"select idx from userinfo where id = " + "HEX(AES_ENCRYPT('" + stringId + "','gkfwltdjqtsi'))");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				chk = rs.getInt(1);
			}
			if (stringId.length() == 0)
				chk = 1;
			System.out.println(stringId.length());
			if (chk == 0)
				return 1;
			else
				return 0;

		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

		return 0;
		// if(chk != 0)
		// return 1;
		// else{
		// System.out.println(rs);
		// System.out.println(stringId);
		// return 0;
		// }
	}

	public boolean PasswordCheck(String currentPw) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement("select idx from userinfo where id = " + "HEX(AES_ENCRYPT('" + currentUserId
					+ "','gkfwltdjqtsi')) AND password = Password('" + currentPw + "')");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getString(1) != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return false;
	}

	public boolean ChangePw(String inputPw) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement("update userinfo set password = PASSWORD('" + inputPw
					+ "') where id = HEX(AES_ENCRYPT('" + currentUserId + "','gkfwltdjqtsi'))");
			int rs = 0;
			rs = stmt.executeUpdate();
			if (rs != 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return false;
	}

	public boolean UserExit() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"delete from userinfo where id = HEX(AES_ENCRYPT('" + currentUserId + "','gkfwltdjqtsi'))");
			stmt2 = conn.prepareStatement(
					"delete from computer where id = HEX(AES_ENCRYPT('" + currentUserId + "','gkfwltdjqtsi'))");
			int rs1 = 0;
			int rs2 = 0;
			rs1 = stmt.executeUpdate();
			rs2 = stmt2.executeUpdate();
			
			if(rs1 != 0 || rs2 != 0){
				currentUserId = null;
				return true;
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return false;
	}

	public void JoinMain(JTextField tempName, String Gender, String tempAge, JTextField tempId,
			JTextField inputPassword) throws SQLException {
		String name = tempName.getText();
		int age = Integer.parseInt(tempAge);
		String id = tempId.getText();
		String password = inputPassword.getText();

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"insert into userinfo(name,gender,age,id,password) values('" + name + "','" + Gender + "','" + age
							+ "',HEX(AES_ENCRYPT('" + id + "','gkfwltdjqtsi')),PASSWORD('" + password + "'))");
			int rs = 0;
			rs = stmt.executeUpdate();

			if (rs != 0) {
				JOptionPane.showMessageDialog(null, "성공적으로 회원가입되었습니다", "회원가입성공", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다", "회원가입실패", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public boolean LoginBack(JTextField inputId, JTextField inputPassword) throws SQLException {
		String userId = inputId.getText();
		String tempPassword = inputPassword.getText();
		String userPassword = null;
		String password = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"select password from userinfo where id = (HEX(AES_ENCRYPT('" + userId + "','gkfwltdjqtsi')))");
			ResultSet rs;
			rs = stmt.executeQuery();
			while (rs.next()) {
				password = rs.getString(1);
			}
			stmt = conn.prepareStatement("select PASSWORD('" + tempPassword + "')");
			rs = stmt.executeQuery();
			while (rs.next()) {
				userPassword = rs.getString(1);
			}

			if (password != null) {
				if (password.equals(userPassword)) {
					currentUserId = userId;
					return true;
				} else
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다." + "\n아이디나 비밀번호를 확인해주세요", "로그인실패",
							JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다", "로그인실패", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return false;
	}

	public Boolean ComputerPlus(JTextField tempName, JTextField tempCore, JTextField tempRam, JTextField tempThreads,
			JTextField tempMonitor, JTextField tempVram) throws SQLException {
		String comName = tempName.getText();
		if (comName.length() == 0)
			comName = "0";
		String comCore = tempCore.getText();
		if (comCore.length() == 0)
			comCore = "0";
		String comRam = tempRam.getText();
		if (comRam.length() == 0)
			comRam = "0";
		String comThreads = tempThreads.getText();
		if (comThreads.length() == 0)
			comThreads = "0";
		String comMonitor = tempMonitor.getText();
		if (comMonitor.length() == 0)
			comMonitor = "0";
		String comVram = tempVram.getText();
		if (comVram.length() == 0)
			comVram = "0";

		int chk = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"insert into computer(id,name,core,ram,threads,monitor,vram) values(HEX(AES_ENCRYPT('"
							+ currentUserId + "','gkfwltdjqtsi')),'" + comName + "','" + comCore + "','" + comRam
							+ "','" + comThreads + "','" + comMonitor + "','" + comVram + "')");
			chk = stmt.executeUpdate();

			if (chk != 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();

		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return false;
	}

	public Boolean ComputerIsFull() throws SQLException {
		int chk = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"select idx from computer where id = HEX(AES_ENCRYPT('" + currentUserId + "','gkfwltdjqtsi'))");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			while (rs.next()) {
				chk++;
			}
			if (chk >= 5)
				return false;
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return true;
	}

	public void ButtonFormBack() throws SQLException {
		int change = 1;
		int i;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"select name from computer where id = HEX(AES_ENCRYPT('" + currentUserId + "','gkfwltdjqtsi'))");
			rs = stmt.executeQuery();
			while (rs.next()) {
				switch (change) {
				case 1:
					ComputerDeleteForm.btn.setText(rs.getString(1));
					CodeComSelectForm.btnSelect.setText(rs.getString(1));
					ComputerDeleteForm.btn.setVisible(true);
					CodeComSelectForm.btnSelect.setVisible(true);
					break;
				case 2:
					ComputerDeleteForm.btn_1.setText(rs.getString(1));
					CodeComSelectForm.btnSelect_1.setText(rs.getString(1));
					ComputerDeleteForm.btn_1.setVisible(true);
					CodeComSelectForm.btnSelect_1.setVisible(true);
					break;
				case 3:
					ComputerDeleteForm.btn_2.setText(rs.getString(1));
					CodeComSelectForm.btnSelect_2.setText(rs.getString(1));
					ComputerDeleteForm.btn_2.setVisible(true);
					CodeComSelectForm.btnSelect_2.setVisible(true);
					break;
				case 4:
					ComputerDeleteForm.btn_3.setText(rs.getString(1));
					CodeComSelectForm.btnSelect_3.setText(rs.getString(1));
					ComputerDeleteForm.btn_3.setVisible(true);
					CodeComSelectForm.btnSelect_3.setVisible(true);
					break;
				case 5:
					ComputerDeleteForm.btn_4.setText(rs.getString(1));
					CodeComSelectForm.btnSelect_4.setText(rs.getString(1));
					ComputerDeleteForm.btn_4.setVisible(true);
					CodeComSelectForm.btnSelect_4.setVisible(true);
					break;
				}
				change++;
			}
			for (i = change; i <= 5; i++) {
				switch (i) {
				case 1:
					ComputerDeleteForm.btn.setVisible(false);
					CodeComSelectForm.btnSelect.setVisible(false);
					break;
				case 2:
					ComputerDeleteForm.btn_1.setVisible(false);
					CodeComSelectForm.btnSelect_1.setVisible(false);
					break;
				case 3:
					ComputerDeleteForm.btn_2.setVisible(false);
					CodeComSelectForm.btnSelect_2.setVisible(false);
					break;
				case 4:
					ComputerDeleteForm.btn_3.setVisible(false);
					CodeComSelectForm.btnSelect_3.setVisible(false);
					break;
				case 5:
					ComputerDeleteForm.btn_4.setVisible(false);
					CodeComSelectForm.btnSelect_4.setVisible(false);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public void ComputerSettingFormBack() throws SQLException {
		int change = 1;
		int i;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"select name from computer where id = HEX(AES_ENCRYPT('" + currentUserId + "','gkfwltdjqtsi'))");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			while (rs.next()) {
				switch (change) {
				case 1:
					ComputerSettingForm.label.setText(rs.getString(1));
					ComputerSettingForm.label.setBorder(new LineBorder(new Color(0, 0, 0)));
					break;
				case 2:
					ComputerSettingForm.label_1.setText(rs.getString(1));
					ComputerSettingForm.label_1.setBorder(new LineBorder(new Color(0, 0, 0)));
					break;
				case 3:
					ComputerSettingForm.label_2.setText(rs.getString(1));
					ComputerSettingForm.label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
					break;
				case 4:
					ComputerSettingForm.label_3.setText(rs.getString(1));
					ComputerSettingForm.label_3.setBorder(new LineBorder(new Color(0, 0, 0)));
					break;
				case 5:
					ComputerSettingForm.label_4.setText(rs.getString(1));
					ComputerSettingForm.label_4.setBorder(new LineBorder(new Color(0, 0, 0)));
					break;
				}
				change++;
			}
			for (i = change; i <= 5; i++) {
				switch (i) {
				case 1:
					ComputerSettingForm.label.setText("");
					ComputerSettingForm.label.setBorder(null);
					break;
				case 2:
					ComputerSettingForm.label_1.setText("");
					ComputerSettingForm.label_1.setBorder(null);
					break;
				case 3:
					ComputerSettingForm.label_2.setText("");
					ComputerSettingForm.label_2.setBorder(null);
					break;
				case 4:
					ComputerSettingForm.label_3.setText("");
					ComputerSettingForm.label_3.setBorder(null);
					break;
				case 5:
					ComputerSettingForm.label_4.setText("");
					ComputerSettingForm.label_4.setBorder(null);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public Boolean ComputerOverlap(JTextField inputName) throws SQLException {
		String computerName = inputName.getText();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement(
					"select name from computer where id = HEX(AES_ENCRYPT('" + currentUserId + "','gkfwltdjqtsi'))");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(computerName))
					return false;
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return true;
	}

	public void ComputerDelete(String comName) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement("delete from computer where name = '" + comName
					+ "' and id = HEX(AES_ENCRYPT('" + currentUserId + "','gkfwltdjqtsi'))");
			int rs = 0;
			rs = stmt.executeUpdate();
			if (rs != 0) {
				ComputerSettingFormBack();
				ButtonFormBack();
				JOptionPane.showMessageDialog(null, "삭제되었습니다", "삭제성공", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "삭제에 실패하였습니다", "삭제실패", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public String CodeBack(String comName) throws SQLException {
		int comCore;
		int comRam;
		int comVram;
		int comThreads;
		int comMonitor;
		String code = "";
		String codeCore = "";
		String codeRam = "";
		String codeThreads = "";
		String codeMonitor = " -refresh 60";
		String codeVram = "";
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "wlq9506");
			stmt = conn.prepareStatement("select * from computer where id = HEX(AES_ENCRYPT('" + currentUserId
					+ "','gkfwltdjqtsi')) and name = '" + comName + "'");
			ResultSet rs = null;
			rs = stmt.executeQuery();
			rs.next();
			comCore = rs.getInt(4);
			comRam = rs.getInt(5);
			comThreads = rs.getInt(6);
			comMonitor = rs.getInt(7);
			comVram = rs.getInt(8);
			if (comCore != 0)
				codeCore = " -cpuPause " + comCore;
			if (comRam != 0)
				codeRam = " -maxMem=" + comRam * 1024;
			if (comThreads != 0)
				codeThreads = " -threads " + comThreads;
			if (comMonitor != 0)
				codeMonitor = " -refresh " + comMonitor;
			if (comVram <= 1)
				codeVram = " -maxVram=" + (comVram * 1024 - 512);
			code = "-malloc=system -heapsize 1572864 -d3d9 -high -USEALLAVAILABLECORES -force-feature-level-11-0"
					+ codeCore + codeRam + codeThreads + codeMonitor + codeVram;
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return code;
	}
}
