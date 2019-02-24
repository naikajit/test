/**
 * 
 */
package com.dts.etender.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.etender.model.Quatation;
import com.dts.etender.model.TenderPost;

/**
 * @author JAVAPROJECTS
 *
 */
public class QuatationDAO extends AbstractDataAccessObject {
	public Connection con;
	private boolean flag=false;
//insert department
	public boolean postQuatation(Quatation  quatation)
	{
		int quatationID=getSequenceID("QuatationPost","QuatatonID");
		PreparedStatement pstmt=null;
		try
		{System.out.println("in quatationpost");
		    con=getConnection();
		    pstmt=con.prepareStatement("insert into QuatationPost values(?,?,?,?,?,?,?,?)");
		    pstmt.setInt(1,quatationID);
		    pstmt.setInt(2,quatation.getTenderID());
		    pstmt.setString(3,quatation.getSuppierName());
		    pstmt.setString(4,quatation.getDDNo());
		    pstmt.setString(5,DateWrapper.parseDate(new Date()));		    
		    pstmt.setInt(6,quatation.getQuantity());
		    pstmt.setString(7,quatation.getSpesification());		    
		    pstmt.setDouble(8,quatation.getPricebid());
		  
		    int i=pstmt.executeUpdate();
		    if(i>0)
		    	flag=true;
		}
		catch(Exception e)
		{   e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return flag;
	}
}
