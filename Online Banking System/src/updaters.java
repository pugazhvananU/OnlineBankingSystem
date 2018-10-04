import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class updaters {

	public updaters(String sn,String rc,int amt) {
	
		Fillo fillup=new Fillo();
		Connection connection1cc;
		
		try {
			connection1cc = fillup.getConnection("bank.xlsx");
			String query="SELECT * FROM Sheet1 WHERE Username='"+rc+"'";
			Recordset rsc=connection1cc.executeQuery(query);
			 while(rsc.next())
	     	{
				 int d=Integer.parseInt(rsc.getField("Balance"))+amt;
					String query1="UPDATE Sheet1 SET Balance='"+Integer.toString(d)+"' WHERE Username='"+rc+"'";
					connection1cc.executeUpdate(query1);
				    new insert(sn,rc, amt);	
				 
	     	}
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}

}
