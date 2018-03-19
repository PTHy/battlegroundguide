package kr.hs.dgsw.bgg;

import java.awt.Toolkit;
import java.awt.datatransfer.*;

import javax.swing.JTextField;

public class CodeCopy <code>{
	public boolean Copy(JTextField code){
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String copyString = code.getText();
		if(copyString != null)
		{
			StringSelection contents = new StringSelection(copyString);
			clipboard.setContents(contents, null);
			return true;
		}
		return false;
	}
}
