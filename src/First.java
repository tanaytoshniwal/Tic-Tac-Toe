import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class First extends JFrame{
	JLabel label;
	JButton btn1,btn2;
	JTextField name; 
	JPanel pan1,pan2,pan3;
	public First(String str){
		FrameProperty.set(this, str, 500, 500, false, new GridLayout(3, 0), EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		pan1=new JPanel();
		pan2=new JPanel();
		pan3=new JPanel();
		pan1.setLayout(null);
		pan2.setLayout(null);
		pan3.setLayout(null);
		label=new JLabel("Enter Your Name:");
		name=new JTextField(10);
		btn1=new JButton("1 Player");
		btn2=new JButton("2 Player");
		
		label.setBounds(100, 70, 100, 20);
		name.setBounds(200, 70, 200, 20);
		btn1.setBounds(150, 50, 200, 30);
		btn2.setBounds(150, 50, 200, 30);
		
		pan1.add(label);
		pan1.add(name);
		pan2.add(btn1);
		pan3.add(btn2);
		add(pan1);
		add(pan2);
		add(pan3);
	}
	public static void main(String[] args){
		new First("Tic-Tac-Toe").setVisible(true);
	}
}
