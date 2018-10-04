import javax.swing.JOptionPane;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class updaterc {

	public updaterc(String sn,String rc,int amt)  {
	
	Fillo fillup=new Fillo();
	Connection connection1c;
	try {
		connection1c = fillup.getConnection("bank.xlsx");
		String query="SELECT * FROM Sheet1 WHERE Username='"+sn+"'";
		Recordset rsc=connection1c.executeQuery(query);
		 while(rsc.next())
     	{
			 if(Integer.parseInt(rsc.getField("Balance"))>amt) {
					int d=Integer.parseInt(rsc.getField("Balance"))-amt;
					String query1="UPDATE Sheet1 SET Balance='"+Integer.toString(d)+"' WHERE Username='"+sn+"'";
					connection1c.executeUpdate(query1);
					new updaters(sn,rc,amt);
				}
				else {
					JOptionPane.showMessageDialog(null,"Insufficient Balance ");
					
				} 
            	}
		    
		
		
		
	} catch (FilloException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

}
