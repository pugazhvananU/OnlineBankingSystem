import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class balance {

	public balance(String name) {
		
		  Fillo filloc= new Fillo();
			Connection connection1;
			try {
				connection1 = filloc.getConnection("bank.xlsx");
				String str1Queryc ="SELECT * FROM Sheet1 WHERE Username='"+name+"'";
				Recordset rsc=connection1.executeQuery(str1Queryc);					
			
              while(rsc.next()) {
            	  JFrame bal=new JFrame("Balance");
          		
            	  JLabel wel=new JLabel("Account Status");
          			wel.setFont(new Font("Timesnewroman", Font.BOLD, 20));
          			wel.setForeground(Color.red);
          			wel.setBounds(0, 30, 400, 30);
          		
            	  JLabel acno=new JLabel("Account Number:"+rsc.getField("Accno.")+"");      		  
          		  JLabel nam=new JLabel("Name="+name);
            	  JLabel ball=new JLabel("Current account Balance: Rs."+rsc.getField("Balance")+"");      	
            	  acno.setBounds(100, 120, 400, 30);
            	  acno.setFont(new Font("Timesnewroman", Font.BOLD, 16));
        			acno.setForeground(Color.red);
        		
            	  nam.setBounds(100, 150, 400, 30);
            	  nam.setFont(new Font("Timesnewroman", Font.BOLD, 16));
        			nam.setForeground(Color.red);
        		
            	  ball.setBounds(100, 180, 400, 30);
            	  ball.setFont(new Font("Timesnewroman", Font.BOLD, 16));
        			ball.setForeground(Color.red);

        		
            	  
         		 bal.setVisible(true);
        		 bal.setContentPane(new JLabel(new ImageIcon("img3.jpg")));
        		 bal.add(wel);
        		 bal.add(acno);
        		 bal.add(nam);
        		 bal.add(ball);
        			 		
        		 bal.setSize(500,500);

              	
              }
              	
                      
				
				
			} catch (FilloException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
		
		// TODO Auto-generated constructor stub
	}

}
