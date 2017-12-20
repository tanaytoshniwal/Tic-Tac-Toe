import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Board extends JFrame implements ActionListener{
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8;
	static int chance = 9;
	int[][] bMatrix={{0,0,0},{0,0,0},{0,0,0}};
	public Board(String str){
		FrameProperty.set(this, str, 500, 500, false, new GridLayout(3,3), EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		b0=new JButton();
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		b4=new JButton();
		b5=new JButton();
		b6=new JButton();
		b7=new JButton();
		b8=new JButton();
		
		add(b0);add(b1);add(b2);
		add(b3);add(b4);add(b5);
		add(b6);add(b7);add(b8);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
	}
	void check(int i){
		if(i==1){
			if(bMatrix[0][0]!=0&&bMatrix[0][1]!=0&&bMatrix[0][2]!=0){
				System.out.println("p1 win");
				JOptionPane.showMessageDialog(this, "Player 1 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[1][0]!=0&&bMatrix[1][1]!=0&&bMatrix[1][2]!=0){
				System.out.println("p1 win");
				JOptionPane.showMessageDialog(this, "Player 1 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[2][0]!=0&&bMatrix[2][1]!=0&&bMatrix[2][2]!=0){
				System.out.println("p1 win");
				JOptionPane.showMessageDialog(this, "Player 1 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][0]!=0&&bMatrix[1][0]!=0&&bMatrix[2][0]!=0){
				System.out.println("p1 win");
				JOptionPane.showMessageDialog(this, "Player 1 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][1]!=0&&bMatrix[1][1]!=0&&bMatrix[2][1]!=0){
				System.out.println("p1 win");
				JOptionPane.showMessageDialog(this, "Player 1 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][2]!=0&&bMatrix[1][2]!=0&&bMatrix[2][2]!=0){
				System.out.println("p1 win");
				JOptionPane.showMessageDialog(this, "Player 1 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][0]!=0&&bMatrix[1][1]!=0&&bMatrix[2][2]!=0){
				System.out.println("p1 win");
				JOptionPane.showMessageDialog(this, "Player 1 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][2]!=0&&bMatrix[1][1]!=0&&bMatrix[2][0]!=0){
				System.out.println("p1 win");
				JOptionPane.showMessageDialog(this, "Player 1 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		}
		else{
			if(bMatrix[0][0]!=0&&bMatrix[0][1]!=0&&bMatrix[0][2]!=0){
				System.out.println("p2 win");
				JOptionPane.showMessageDialog(this, "Player 2 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[1][0]!=0&&bMatrix[1][1]!=0&&bMatrix[1][2]!=0){
				System.out.println("p2 win");
				JOptionPane.showMessageDialog(this, "Player 2 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[2][0]!=0&&bMatrix[2][1]!=0&&bMatrix[2][2]!=0){
				System.out.println("p2 win");
				JOptionPane.showMessageDialog(this, "Player 2 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][0]!=0&&bMatrix[1][0]!=0&&bMatrix[2][0]!=0){
				System.out.println("p2 win");
				JOptionPane.showMessageDialog(this, "Player 2 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][1]!=0&&bMatrix[1][1]!=0&&bMatrix[2][1]!=0){
				System.out.println("p2 win");
				JOptionPane.showMessageDialog(this, "Player 2 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][2]!=0&&bMatrix[1][2]!=0&&bMatrix[2][2]!=0){
				System.out.println("p2 win");
				JOptionPane.showMessageDialog(this, "Player 2 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][0]!=0&&bMatrix[1][1]!=0&&bMatrix[2][2]!=0){
				System.out.println("p2 win");
				JOptionPane.showMessageDialog(this, "Player 2 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			if(bMatrix[0][2]!=0&&bMatrix[1][1]!=0&&bMatrix[2][0]!=0){
				System.out.println("p2 win");
				JOptionPane.showMessageDialog(this, "Player 2 Wins!", "Over", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		}
	}
	void two(ActionEvent e){
		JButton b=(JButton)e.getSource();
		--chance;
		if(chance>=0&&chance%2==0){
			System.out.println(chance);
			if(b==b0){
				bMatrix[0][0]++;
				b.setOpaque(true);
				b.setBackground(Color.BLACK);
				b.removeActionListener(this);
				b.setEnabled(false);
			}
			if(b==b1){
				bMatrix[0][1]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.setBackground(Color.BLACK);
				b.removeActionListener(this);
			}
			if(b==b2){
				bMatrix[0][2]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.BLACK);
			}
			if(b==b3){
				bMatrix[1][0]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.BLACK);
			}
			if(b==b4){
				bMatrix[1][1]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.BLACK);
			}
			if(b==b5){
				bMatrix[1][2]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.BLACK);
			}
			if(b==b6){
				bMatrix[2][0]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.BLACK);
			}
			if(b==b7){
				bMatrix[2][1]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.BLACK);
			}
			if(b==b8){
				bMatrix[2][2]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.BLACK);
			}
			check(1);
		}
		else if(chance>=0&&chance%2==1){
			System.out.println(chance);
			if(b==b0){
				bMatrix[0][0]++;
				b.setOpaque(true);
				b.setBackground(Color.WHITE);
				b.removeActionListener(this);
				b.setEnabled(false);
			}
			if(b==b1){
				bMatrix[0][1]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.setBackground(Color.WHITE);
				b.removeActionListener(this);
			}
			if(b==b2){
				bMatrix[0][2]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.WHITE);
			}
			if(b==b3){
				bMatrix[1][0]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.WHITE);
			}
			if(b==b4){
				bMatrix[1][1]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.WHITE);
			}
			if(b==b5){
				bMatrix[1][2]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.WHITE);
			}
			if(b==b6){
				bMatrix[2][0]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.WHITE);
			}
			if(b==b7){
				bMatrix[2][1]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.WHITE);
			}
			if(b==b8){
				bMatrix[2][2]++;
				b.setOpaque(true);
				b.setEnabled(false);
				b.removeActionListener(this);
				b.setBackground(Color.WHITE);
			}
			check(2);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(User.type){
			two(e);
		}
	}
	public static void main(String[] args){
		new Board("").setVisible(true);
	}
}
