import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class transfer {

	public transfer(String name,String Tpass) {
		JFrame frame = new JFrame("Federal Corporation Bank");
		  JLabel l1 = new JLabel("Account Transfer");
		  l1.setForeground(Color.magenta);
		  l1.setFont(new Font("Timesnewroman", Font.BOLD, 20));
		  JLabel l2 = new JLabel("Receiver's BankId");
		  l2.setForeground(Color.red);
		  
		  JLabel l3 = new JLabel("Transaction Password");
		  l3.setForeground(Color.red);
		  
		  JLabel l4=new JLabel("Amount");
		  l4.setForeground(Color.red);
		  
		  JTextField tf1 = new JTextField();
		  JPasswordField p1 = new JPasswordField();
		  JTextField tf2 = new JTextField();
		  JButton btn1 = new JButton("Confirm");	 
		  l1.setBounds(170, 30, 400, 30);
		  l2.setBounds(80, 90, 200, 30);
		  l3.setBounds(80, 130, 200, 30);
		  l4.setBounds(80,170,200,30);
		  tf1.setBounds(250, 90, 200, 30);
		  p1.setBounds(250, 130, 200, 30);
		  tf2.setBounds(250,170,200,30);
		  btn1.setBounds(300, 220, 100, 30);
		  frame.setContentPane(new JLabel(new ImageIcon("img4.gif")));
		  frame.add(l1);
		  frame.add(l2);
		  frame.add(tf1);
		  frame.add(l3);
		  frame.add(p1);
		  frame.add(btn1);
		  frame.add(tf2);
		  frame.add(l4);
		  
		  
		  
		  frame.setSize(800, 400);
		  
		  frame.setLayout(null);
		  frame.setVisible(true);
		  
		  btn1.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  

				  if(tf1.getText().equals("")||p1.getText().equals("")||tf2.getText().equals("")){

          		JOptionPane.showMessageDialog(null,"Please Enter all credentials");
      	
		            }
				  else if(p1.getText().equals(Tpass)) {
					Fillo fillocc= new Fillo();
			    	Connection connection1c;
			    	try {

						connection1c = fillocc.getConnection("bank.xlsx");
			    		String query="SELECT * FROM Sheet1 WHERE EXISTS (SELECT Username FROM Sheet1 WHERE Username='"+tf1.getText()+"')";
			    		Recordset rsc=connection1c.executeQuery(query);
			    		if(rsc.getCount()==0) {

			          		JOptionPane.showMessageDialog(null,"Receiver does not exist");
			    			
			    		}
			    		else {
			    			new updaterc(name,tf1.getText(),Integer.parseInt(tf2.getText()));
			    		}
			    	}catch (FilloException e1){
			    		e1.printStackTrace();
			    	}
				  }
				  else {
					  JOptionPane.showMessageDialog(null,"Incorrect Transaction Password");	  
				  }
				  
			  }			      }); 

	}
	
		  
	public static void main(String args[]) {
		new transfer("Pugazh","Pugazh");
	}

}
