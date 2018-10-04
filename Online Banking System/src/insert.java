import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class insert {

	public insert(String sn,String rc,int amt) {
		Fillo fillocc= new Fillo();
    	Connection connection1cccc;
    	try {

			connection1cccc = fillocc.getConnection("bank.xlsx");
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   String date=dtf.format(now);
			String query1="INSERT INTO Sheet2  VALUES('"+date+"','"+sn+"','"+rc+"','"+Integer.toString(amt)+"')  ";
    		connection1cccc.executeUpdate(query1);

    		connection1cccc.close();
    		  JOptionPane.showMessageDialog(null,"Transaction Successfull");
    	}catch (FilloException e1){
    		e1.printStackTrace();
    	}

	}

}
