import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class ScoreBoard extends JFrame{
	JPanel pan1,pan2,pan3;
	JLabel player1,player2;
	JLabel score1,score2;
	public ScoreBoard(String str){
		FrameProperty.set(this, str, 500, 500, false, new GridLayout(0,2), EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		pan1=new JPanel(null);
		pan2=new JPanel(null);
		player1=new JLabel(User.name1+"'s Score:");
		player2=new JLabel(User.name2+"'s Score:");
		score1=new JLabel(User.p1+"");
		score2=new JLabel(User.p2+"");
		
		pan1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		pan2.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		score1.setFont(new Font("Serif", Font.PLAIN, 80));
		score2.setFont(new Font("Serif", Font.PLAIN, 80));
		
		player1.setBounds(70, 50, 100, 20);
		player2.setBounds(70, 50, 100, 20);
		score1.setBounds(100,200,50,100);
		score2.setBounds(100,200,50,100);
		
		pan1.add(player1);
		pan1.add(score1);
		pan2.add(player2);
		pan2.add(score2);
		add(pan1);
		add(pan2);
	}
}
