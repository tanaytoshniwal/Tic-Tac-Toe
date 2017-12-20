import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScoreBoard extends JFrame{
	JPanel pan1,pan2;
	public ScoreBoard(String str){
		FrameProperty.set(this, str, 500, 500, false, new GridLayout(0,2), EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
	}
}
