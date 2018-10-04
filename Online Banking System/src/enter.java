import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class enter {

	public enter(String name,String Tpass) {
		
		JFrame Acc=new JFrame("Account");
		JLabel wel=new JLabel("Welcome back "+name+"!!!");
		wel.setFont(new Font("Timesnewroman", Font.BOLD, 20));
		wel.setForeground(Color.white);
		wel.setBounds(0, 30, 400, 30);
		
		JLabel wel1=new JLabel("Options:");
		wel1.setFont(new Font("Timesnewroman", Font.BOLD, 20));
		wel1.setForeground(Color.white);
		wel1.setBounds(0, 90, 400, 30);
		
		JButton bal = new JButton("Balance");
		JButton with = new JButton("Money Transfer");
		bal.setBounds(50, 120, 400, 30);
		with.setBounds(50, 150, 400, 30);
		
		 Acc.setVisible(true);
		 Acc.setContentPane(new JLabel(new ImageIcon("img2.jpg")));
		 Acc.add(wel);
		 Acc.add(wel1);
		 Acc.add(bal);
		 Acc.add(with);
			 		
		 Acc.setSize(500,500);
		 
		 bal.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
				  new balance(name);
			          }  
			      }); 

		 

		 with.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			   new transfer(name,Tpass);       
			  }  
			      }); 


	}
	public static void main(String args[]) {
		new enter("Pugazhvana","Pugazh");
	}

}
