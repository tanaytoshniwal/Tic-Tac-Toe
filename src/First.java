import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class First extends JFrame implements ActionListener{
	JLabel label1,label2;
	JButton btn1;
	JTextField name,name2; 
	JPanel pan1,pan2,pan3;
	JRadioButton player2,player1;
	ButtonGroup grp;
	public First(String str){
		FrameProperty.set(this, str, 500, 500, false, new GridLayout(3, 0), EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		player2=new JRadioButton("Play with a friend?", true);
		player1=new JRadioButton("Play with Computer?");
		grp=new ButtonGroup();
		pan1=new JPanel();
		pan2=new JPanel();
		pan3=new JPanel();
		pan1.setLayout(null);
		pan2.setLayout(null);
		pan3.setLayout(null);
		label1=new JLabel("Enter Your Name:");
		label2=new JLabel("Enter 2nd Name:");
		name=new JTextField(10);
		name2=new JTextField(10);
		btn1=new JButton("Play");
		
		grp.add(player1);
		grp.add(player2);
		
		label1.setBounds(100, 70, 100, 20);
		name.setBounds(200, 70, 200, 20);
		label2.setBounds(100, 100, 100, 20);
		name2.setBounds(200, 100, 200, 20);
		btn1.setBounds(150, 50, 200, 30);
		player1.setBounds(180, 100, 200, 30);
		player2.setBounds(185, 50, 200, 30);
		
		label2.setVisible(true);
		name2.setVisible(true);
		
		pan1.add(label1);
		pan1.add(name);
		pan1.add(label2);
		pan1.add(name2);
		pan2.add(player2);
		pan2.add(player1);
		pan3.add(btn1);
		add(pan1);
		add(pan2);
		add(pan3);
		
		btn1.addActionListener(this);
		player2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(player2.isSelected()){
					label2.setVisible(true);
					name2.setVisible(true);
				}
				else{
					label2.setVisible(false);
					name2.setVisible(false);
				}
			}
		});
		player1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(player2.isSelected()){
					label2.setVisible(true);
					name2.setVisible(true);
				}
				else{
					label2.setVisible(false);
					name2.setVisible(false);
				}
			}
		});
	}
	boolean check(){
		boolean b=true;
		if(player1.isSelected()&&name.getText().equals(""))
			b=false;
		if(player2.isSelected())
			if(name.getText().equals("")||name2.getText().equals(""))
				b=false;
		return b;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(check()){
			User.name1=name.getText();
			if(player1.isSelected()){
				User.type=true;
				User.name2="CPU";
			}
			else{
				User.type=false;
				User.name2=name2.getText();
			}
			dispose();
			new Board("Tic-Tac-Toe").setVisible(true);
			if(User.type)
				JOptionPane.showMessageDialog(this, "It's your turn first!", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(this, "Input Error!", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	public static void main(String[] args){
		new First("Tic-Tac-Toe").setVisible(true);
	}
}
