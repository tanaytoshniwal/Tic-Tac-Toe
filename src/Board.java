import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Board extends JFrame implements ActionListener{
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8;
	String result="";
	int chance = 9;
	int[][] bMatrix={{0,0,0},{0,0,0},{0,0,0}};
	ImageIcon cross=new ImageIcon("./images/c.png");
	ImageIcon zero=new ImageIcon("./images/o.png");
	HashMap<JButton, Integer> map;
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
		map=new HashMap<>();
        map.put(b0,0);
        map.put(b1,1);
        map.put(b2,2);
        map.put(b3,3);
        map.put(b4,4);
        map.put(b5,5);
        map.put(b6,6);
        map.put(b7,7);
        map.put(b8,8);
		add(b0);add(b1);add(b2);
		add(b3);add(b4);add(b5);
		add(b6);add(b7);add(b8);
		
		Image image1=cross.getImage();
		image1=image1.getScaledInstance(156, 156, Image.SCALE_SMOOTH);
		cross=new ImageIcon(image1);
		image1=zero.getImage();
		image1=image1.getScaledInstance(156, 156, Image.SCALE_SMOOTH);
		zero=new ImageIcon(image1);
		
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
	void tie(){
		JOptionPane.showMessageDialog(this, "It's a tie!", "OOPS!", JOptionPane.INFORMATION_MESSAGE);
		int m=JOptionPane.showConfirmDialog(this, "Up for Another Game?", "Hey!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
		//System.out.println(m);
		dispose();
		if(m==0){
			new Board("Tic-Tac-Toe").setVisible(true);
		}
		else{
			new ScoreBoard("ScoreBoard").setVisible(true);
		}
	}
	void pass(boolean b){
		if(b){
			result="Player 1 Wins!";
			User.p1++;
		}
		else{
			result="Player 2 Wins!";
			User.p2++;
		}
		JOptionPane.showMessageDialog(this, result, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
		int m=JOptionPane.showConfirmDialog(this, "Up for Another Game?", "Hey!", JOptionPane.YES_OPTION);
		//System.out.println(m);
		dispose();
		if(m==0){
			new Board("Tic-Tac-Toe").setVisible(true);
		}
		else{
			new ScoreBoard("ScoreBoard").setVisible(true);
		}
	}
	int check(){
		int res=0;
		if(bMatrix[0][0]==1&&bMatrix[0][1]==1&&bMatrix[0][2]==1){
			pass(true);res++;
		}
		if(bMatrix[1][0]==1&&bMatrix[1][1]==1&&bMatrix[1][2]==1){
			pass(true);res++;
		}
		if(bMatrix[2][0]==1&&bMatrix[2][1]==1&&bMatrix[2][2]==1){
			pass(true);res++;
		}
		if(bMatrix[0][0]==1&&bMatrix[1][0]==1&&bMatrix[2][0]==1){
			pass(true);res++;
		}
		if(bMatrix[0][1]==1&&bMatrix[1][1]==1&&bMatrix[2][1]==1){
			pass(true);res++;
		}
		if(bMatrix[0][2]==1&&bMatrix[1][2]==1&&bMatrix[2][2]==1){
			pass(true);res++;
		}
		if(bMatrix[0][0]==1&&bMatrix[1][1]==1&&bMatrix[2][2]==1){
			pass(true);res++;
		}
		if(bMatrix[0][2]==1&&bMatrix[1][1]==1&&bMatrix[2][0]==1){
			pass(true);res++;
		}

		if(bMatrix[0][0]==-1&&bMatrix[0][1]==-1&&bMatrix[0][2]==-1){
			pass(false);res++;
		}
		if(bMatrix[1][0]==-1&&bMatrix[1][1]==-1&&bMatrix[1][2]==-1){
			pass(false);res++;
		}
		if(bMatrix[2][0]==-1&&bMatrix[2][1]==-1&&bMatrix[2][2]==-1){
			pass(false);res++;
		}
		if(bMatrix[0][0]==-1&&bMatrix[1][0]==-1&&bMatrix[2][0]==-1){
			pass(false);res++;
		}
		if(bMatrix[0][1]==-1&&bMatrix[1][1]==-1&&bMatrix[2][1]==-1){
			pass(false);res++;
		}
		if(bMatrix[0][2]==-1&&bMatrix[1][2]==-1&&bMatrix[2][2]==-1){
			pass(false);res++;
		}
		if(bMatrix[0][0]==-1&&bMatrix[1][1]==-1&&bMatrix[2][2]==-1){
			pass(false);res++;
		}
		if(bMatrix[0][2]==-1&&bMatrix[1][1]==-1&&bMatrix[2][0]==-1){
			pass(false);res++;
		}
		return res;
	}
	void result(){
		/*for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(bMatrix[i][j] + " ");
			}
			System.out.println();
		}*/
		int a=check();
		if(a==0 && chance==0){
			tie();
		}
	}
	public JButton get(int i){
		JButton btn=null;
		switch(i){
			case 0:
				btn=b0;
				break;
			case 1:
				btn=b1;
				break;
			case 2:
				btn=b2;
				break;
			case 3:
				btn=b3;
				break;
			case 4:
				btn=b4;
				break;
			case 5:
				btn=b5;
				break;
			case 6:
				btn=b6;
				break;
			case 7:
				btn=b7;
				break;
			case 8:
				btn=b8;
				break;
		}
		return btn;
	}
	public void com(){
		int rand = (int)(Math.random()*9);
    	if(map.containsValue(rand)){
    		JButton btn=get(rand);
    		if(btn==b0){
				bMatrix[0][0]=-1;
			}
			if(btn==b1){
				bMatrix[0][1]=-1;
			}
			if(btn==b2){
				bMatrix[0][2]=-1;
			}
			if(btn==b3){
				bMatrix[1][0]=-1;
			}
			if(btn==b4){
				bMatrix[1][1]=-1;
			}
			if(btn==b5){
				bMatrix[1][2]=-1;
			}
			if(btn==b6){
				bMatrix[2][0]=-1;
			}
			if(btn==b7){
				bMatrix[2][1]=-1;
			}
			if(btn==b8){
				bMatrix[2][2]=-1;
			}
			btn.setIcon(cross);
			map.remove(btn);
			btn.setEnabled(false);
			chance--;
			result();
    	}
    	else{
    		if(chance>0)
    			com();
    		else{
    			JOptionPane.showMessageDialog(this, "It's a tie!!!","Oops!!!",JOptionPane.OK_OPTION);
    			System.exit(0);
    		}
    	}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(!User.type){
			JButton btn=(JButton)e.getSource();
			boolean b=false;
			if(chance%2==1)
				b=true;
			if(b){
				if(btn==b0){
					bMatrix[0][0]=1;
				}
				if(btn==b1){
					bMatrix[0][1]=1;
				}
				if(btn==b2){
					bMatrix[0][2]=1;
				}
				if(btn==b3){
					bMatrix[1][0]=1;
				}
				if(btn==b4){
					bMatrix[1][1]=1;
				}
				if(btn==b5){
					bMatrix[1][2]=1;
				}
				if(btn==b6){
					bMatrix[2][0]=1;
				}
				if(btn==b7){
					bMatrix[2][1]=1;
				}
				if(btn==b8){
					bMatrix[2][2]=1;
				}
				btn.setIcon(cross);
				btn.setEnabled(false);
			}
			else{
				if(btn==b0){
					bMatrix[0][0]=-1;
				}
				if(btn==b1){
					bMatrix[0][1]=-1;
				}
				if(btn==b2){
					bMatrix[0][2]=-1;
				}
				if(btn==b3){
					bMatrix[1][0]=-1;
				}
				if(btn==b4){
					bMatrix[1][1]=-1;
				}
				if(btn==b5){
					bMatrix[1][2]=-1;
				}
				if(btn==b6){
					bMatrix[2][0]=-1;
				}
				if(btn==b7){
					bMatrix[2][1]=-1;
				}
				if(btn==b8){
					bMatrix[2][2]=-1;
				}
				btn.setIcon(zero);
				btn.setEnabled(false);
			}
			chance--;
			result();
		}
		else{
			JButton btn=(JButton)e.getSource();
			if(chance%2==1){
				btn.setIcon(zero);
				btn.setEnabled(false);
				map.remove(btn);
				if(btn==b0){
					bMatrix[0][0]=1;
				}
				if(btn==b1){
					bMatrix[0][1]=1;
				}
				if(btn==b2){
					bMatrix[0][2]=1;
				}
				if(btn==b3){
					bMatrix[1][0]=1;
				}
				if(btn==b4){
					bMatrix[1][1]=1;
				}
				if(btn==b5){
					bMatrix[1][2]=1;
				}
				if(btn==b6){
					bMatrix[2][0]=1;
				}
				if(btn==b7){
					bMatrix[2][1]=1;
				}
				if(btn==b8){
					bMatrix[2][2]=1;
				}
				com();
				chance--;
				result();
			}
		}
	}
	public static void main(String[] args){
		new Board("").setVisible(true);
	}
}
