import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class First extends JFrame implements ActionListener{
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
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	boolean check(){
		if(name.getText().toString().equals("")){
			return false;
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JButton b=(JButton)e.getSource();
		if(check()&&b==btn1){
			User.type=true;
			dispose();
			new Board("Tic-Tac-Toe").setVisible(true);
		}
		else if(check()&&b==btn2){
			User.type=false;
			dispose();
			new Board("Tic-Tac-Toe").setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(this, "Name can't be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	public static void main(String[] args){
		new First("Tic-Tac-Toe").setVisible(true);
	}
}
