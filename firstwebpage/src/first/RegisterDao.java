package first;
import java.sql.*;

import first.ConnectionProvider;
import first.User;  

public class RegisterDao {  
  
public static String ValidateMsg = "";
	
	public static boolean Validate(User u){  
		boolean status=true;  
		
		try{  
		  
		if(u.getUname().length()<=6)
		{
			status=false;
			ValidateMsg.concat("User Name should be more than 6 characters");
		}
		
		if(u.getUname().length()>50)
		{
			status=false;
			ValidateMsg.concat("\n User Name should be less than 50 characters");
		}

		
		//check for email id duplicate
		//fetch record from table where emailid is same as getUemail, 
		//if record exists, then do not allow
		
		
		String eMailID = u.getUemail();
		//<% System.out.println("eMail ID is " + eMailID); %>
		//Logger.log(java.util.logging.Level.INFO , "INFO: eMail ID is " + eMailID);
		try{
			Connection con=ConnectionProvider.getCon();
		    PreparedStatement st=con.prepareStatement("select Count(*) C from USER432 where email=?");
		    st.setString(1,eMailID);
		    ResultSet rs=st.executeQuery();
		        while(rs.next())
		        {
		        	//if(eMailID.equals(rs.getString("email"))){
		        	if(rs.getInt(1)>0)
		        	{
		        		status=false;
		        		ValidateMsg.concat("\n User Name should be less than 50 characters");
		        		break;
		            }
		            
		        }
		}
		catch(Exception e){
		    e.printStackTrace();
		    status=false;
		}		  
		 
		 
	
	/*
		String eMailID = u.getUemail(); 
		int recCnt = 0;
		*/
		
		//recCnt = 
		
		if(u.getUemail().length()<=5)
		{
			status=false;
			ValidateMsg.concat("\n eMail ID should be more than 6 characters");
		}
		
		if(u.getUemail().length()>50)
		{
			status=false;
			ValidateMsg.concat("\n eMail ID should be less than 50 characters");
		}
		 
		if(u.getUemail().contains("@") && u.getUemail().contains(".") )
		{
			//status=true;
			
		}
		else
		{
			status=false;
			ValidateMsg.concat("\n enter valid eMail ID");
		}
		
		if(u.getUpass().length()<=7)
		{
			status=false;
			ValidateMsg.concat("\n User Password should be more than 7 characters");
		}
		
		if(u.getUpass().length()>20)
		{
			status=false;
			ValidateMsg.concat("\n User Password should be more than 20 characters");
		} 
		              
		}catch(Exception e){
			status=false;
		}  
		      
		return status;  
		}
	
public static int reg(User u){  
int status=0;  
try{  
Connection con=ConnectionProvider.getCon();  
PreparedStatement ps=con.prepareStatement("insert into user432 values(?,?,?)");  
ps.setString(1,u.getUname());  
ps.setString(2,u.getUemail());  
ps.setString(3,u.getUpass());  
              
status=ps.executeUpdate();  
}catch(Exception e){
	
}  
      
return status;  
}  
  
}  