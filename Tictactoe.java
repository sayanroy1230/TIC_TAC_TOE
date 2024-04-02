import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tictactoe implements ActionListener{

	JFrame frame= new JFrame("TIC-TAC-TOE");
	JPanel titlepanel=new JPanel();
	JPanel buttonpanel=new JPanel();
	JLabel textfield=new JLabel();
	JButton[] buttons=new JButton[9];	
	JButton resetbutton = new JButton("Reset");
	int turn=0;
	int count=0;
	
	Tictactoe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.black);
		textfield.setForeground(Color.green);
		textfield.setFont(new Font("Verdana",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("X Turn");
		textfield.setOpaque(true);
		
		titlepanel.setLayout(new BorderLayout());
		titlepanel.setBounds(0,0,800,100);
		
		buttonpanel.setLayout(new GridLayout(3,3));
		buttonpanel.setBackground(Color.gray);
		
		for(int i=0;i<9;i++) {
			buttons[i]=new JButton();
			buttonpanel.add(buttons[i]);
			buttons[i].setFont(new Font("Verdana",Font.BOLD,100));
			buttons[i].setFocusable(false);
			buttons[i].setBackground(Color.white);
			buttons[i].addActionListener(this);
		}

		resetbutton.addActionListener(this);
		resetbutton.setForeground(Color.red);
		titlepanel.add(textfield);
		frame.add(titlepanel,BorderLayout.NORTH);
		frame.add(buttonpanel);
		frame.add(resetbutton, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetbutton) {
			for (int i = 0; i < 9; i++) {
	            buttons[i].setText(""); // clear button text
	            buttons[i].setEnabled(true); // enable buttons
	            buttons[i].setBackground(Color.white); // reset button background color
	        }
	        turn = 0; // Reset turn
	        count = 0; // Reset count
	        textfield.setText("X Turn"); 
		}
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(turn==0) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.red);
						buttons[i].setText("X");
						turn=1;
						count++;
						textfield.setText("O Turn");
						check();
						if(count==9) {
							textfield.setText("DRAW");
							for(int k=0;k<9;k++) {
								buttons[k].setBackground(Color.pink);
								buttons[k].setEnabled(false);
							}
						}
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.blue);
						buttons[i].setText("O");
						turn=0;
						count++;
						textfield.setText("X Turn");
						check();
					}
				}
			}
		}
		
	}
	
    public void check() {
		if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")){
			xwins(0,1,2);
			count=0;
		}
		else if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")){
			xwins(3,4,5);
			count=0;
		}
		else if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")){
			xwins(6,7,8);
			count=0;
		}
		else if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")){
			xwins(0,3,6);
			count=0;
		}
		else if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")){
			xwins(1,4,7);
			count=0;
		}
		else if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")){
			xwins(2,5,8);
			count=0;
		}
		else if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")){
			xwins(0,4,8);
			count=0;
		}
		else if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")){
			xwins(2,4,6);
			count=0;
		}
		
		if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O")){
			owins(0,1,2);
		}
		else if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")){
			owins(3,4,5);
		}
		else if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")){
			owins(6,7,8);
		}
		else if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O")){
			owins(0,3,6);
		}
		else if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")){
			owins(1,4,7);
		}
		else if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")){
			owins(2,5,8);
		}
		else if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")){
			owins(0,4,8);
		}
		else if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")){
			owins(2,4,6);
		}
		
	}
    public void xwins(int a,int b,int c) {
    	textfield.setText("X Wins");
    	buttons[a].setBackground(Color.GREEN);
    	buttons[b].setBackground(Color.GREEN);
    	buttons[c].setBackground(Color.GREEN);
    	for(int i=0;i<9;i++) {
    		buttons[i].setEnabled(false);
    	}
	}
    public void owins(int a,int b,int c) {
    	textfield.setText("O Wins");
    	buttons[a].setBackground(Color.GREEN);
    	buttons[b].setBackground(Color.GREEN);
    	buttons[c].setBackground(Color.GREEN);
    	for(int i=0;i<9;i++) {
    		buttons[i].setEnabled(false);
    	}
	}
    
    
    public static void main(String[] args) {
		Tictactoe tk=new Tictactoe();
	}
}
