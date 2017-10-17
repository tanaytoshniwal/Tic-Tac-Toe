import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
public class Board extends JFrame implements MouseListener{
    public Board() {
        initComponents();
        p1.addMouseListener(this);
        p2.addMouseListener(this);
        p3.addMouseListener(this);
        p4.addMouseListener(this);
        p5.addMouseListener(this);
        p6.addMouseListener(this);
        p7.addMouseListener(this);
        p8.addMouseListener(this);
        p9.addMouseListener(this);
        setBackground(Color.BLACK);
        setLocationRelativeTo(this);
        
        setResizable(false);
        setSize(350,373);
        map.put(p1,0);
        map.put(p2,1);
        map.put(p3,2);
        map.put(p4,3);
        map.put(p5,4);
        map.put(p6,5);
        map.put(p7,6);
        map.put(p8,7);
        map.put(p9,8);
    }
    @Override
    public void mouseClicked(MouseEvent e){
    	check("chance");
    	player((JPanel)e.getSource());
    	check("player");
    	System.out.println(chance);
    	com();
    	check("computer");
    }
    public int get(int nigga){
    	int b=0;
    	if(board[0]==nigga&&board[1]==nigga&&board[2]==nigga){
			b=nigga;
		}
    	else if(board[3]==nigga&&board[4]==nigga&&board[5]==nigga){
    		b=nigga;
		}
    	else if(board[6]==nigga&&board[7]==nigga&&board[8]==nigga){
    		b=nigga;
		}
    	else if(board[0]==nigga&&board[3]==nigga&&board[6]==nigga){
    		b=nigga;
		}
    	else if(board[1]==nigga&&board[4]==nigga&&board[7]==nigga){
    		b=nigga;
		}
    	else if(board[2]==nigga&&board[5]==nigga&&board[8]==nigga){
    		b=nigga;
		}
    	else if(board[0]==nigga&&board[4]==nigga&&board[8]==nigga){
    		b=nigga;
		}
    	else if(board[2]==nigga&&board[4]==nigga&&board[6]==nigga){
    		b=nigga;
		}
    	return b;
    }
    public void check(String msg){
    	if(msg.equalsIgnoreCase("chance")){
    		if(chance==-1)
    			System.exit(0);
    	}
    	else if(msg.equalsIgnoreCase("player")){
    		int b=get(1);
    		if(b==1){
    			JOptionPane.showMessageDialog(this, "You Win!!!","Congratulations!!!",JOptionPane.OK_OPTION);
    			System.exit(0);
    		}
    	}
    	else if(msg.equalsIgnoreCase("computer")){
    		int b=get(2);
    		if(b==2){
    			JOptionPane.showMessageDialog(this, "You Lose!!!","Oops!!!",JOptionPane.OK_OPTION);
    			System.exit(0);
    		}
    	}
    }
    public void player(JPanel pan){
    	pan.setOpaque(true);
    	pan.setBackground(Color.GRAY);
    	pan.removeMouseListener(this);
    	board[map.get(pan)]++;
    	map.remove(pan);
    	chance--;
    }
    public void com(){
    	int rand = (int)(Math.random()*9);
    	if(map.containsValue(rand)){
    		JPanel pan=getPan(rand);
    		pan.setOpaque(true);
    		pan.setBackground(Color.DARK_GRAY);
    		pan.removeMouseListener(this);
    		board[map.get(pan)]+=2;
    		map.remove(pan);
    		chance--;
    	}
    	else{
    		if(chance!=0)
    			com();
    		else{
    			JOptionPane.showMessageDialog(this, "It's a tie!!!","Oops!!!",JOptionPane.OK_OPTION);
    			System.exit(0);
    		}
    	}
    }
    public JPanel getPan(int key){
    	JPanel pan=null;
    	switch(key){
	    	case 0:{
	    		pan=p1;
	    		break;
	    	}
	    	case 1:{
	    		pan=p2;
	    		break;
	    	}
	    	case 2:{
	    		pan=p3;
	    		break;
	    	}
	    	case 3:{
	    		pan=p4;
	    		break;
	    	}
	    	case 4:{
	    		pan=p5;
	    		break;
	    	}
	    	case 5:{
	    		pan=p6;
	    		break;
	    	}
	    	case 6:{
	    		pan=p7;
	    		break;
	    	}
	    	case 7:{
	    		pan=p8;
	    		break;
	    	}
	    	case 8:{
	    		pan=p9;
	    		break;
	    	}
    	}
    	return pan;
    }
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}
    @Override
    public void mousePressed(MouseEvent e){
    	JPanel pan=(JPanel)e.getSource();
    	pan.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
    }
    @Override
    public void mouseReleased(MouseEvent e){
    	JPanel pan=(JPanel)e.getSource();
    	pan.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
    }
    private void initComponents() {
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        p8 = new JPanel();
        p9 = new JPanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        p1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        GroupLayout p1Layout = new GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p2.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout p2Layout = new GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p3.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout p3Layout = new GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p4.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout p4Layout = new GroupLayout(p4);
        p4.setLayout(p4Layout);
        p4Layout.setHorizontalGroup(
            p4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p4Layout.setVerticalGroup(
            p4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p5.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout p5Layout = new GroupLayout(p5);
        p5.setLayout(p5Layout);
        p5Layout.setHorizontalGroup(
            p5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p5Layout.setVerticalGroup(
            p5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p6.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout p6Layout = new GroupLayout(p6);
        p6.setLayout(p6Layout);
        p6Layout.setHorizontalGroup(
            p6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p6Layout.setVerticalGroup(
            p6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p7.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout p7Layout = new GroupLayout(p7);
        p7.setLayout(p7Layout);
        p7Layout.setHorizontalGroup(
            p7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p7Layout.setVerticalGroup(
            p7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p8.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout p8Layout = new GroupLayout(p8);
        p8.setLayout(p8Layout);
        p8Layout.setHorizontalGroup(
            p8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p8Layout.setVerticalGroup(
            p8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p9.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout p9Layout = new GroupLayout(p9);
        p9.setLayout(p9Layout);
        p9Layout.setHorizontalGroup(
            p9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        p9Layout.setVerticalGroup(
            p9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p1, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p2, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p3,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(p7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(p4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p6, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p8,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p9,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(p3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(p5,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(p6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(p7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(p8, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(p9,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        Board b;
        b=new Board();
        b.setVisible(true);
        JOptionPane.showMessageDialog(b,"It's Your Turn First!","Welcome!",JOptionPane.INFORMATION_MESSAGE);
    }
    private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9;
    HashMap<JPanel,Integer> map=new HashMap<>();
	private int chance=9;
	int[] board={0,0,0,
				 0,0,0,
				 0,0,0};
}
