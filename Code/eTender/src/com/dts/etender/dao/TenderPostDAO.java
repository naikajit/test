/**
 * 
 */
package com.dts.etender.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.etender.model.Department;
import com.dts.etender.model.TenderPost;


/**
 * @author JAVAPROJECTS
 *
 */
public class TenderPostDAO extends AbstractDataAccessObject {

	public Connection con;
	private boolean flag=false;
//insert department
	public boolean postTender(TenderPost  tenderPost)
	{
		int tenderID=getSequenceID("TenderPost","TenderID");
		PreparedStatement pstmt=null;
		try
		{
		    con=getConnection();
		    pstmt=con.prepareStatement("insert into TenderPost values(?,?,?,?,?,?,?,?,?,?)");
		    pstmt.setInt(1,tenderID);
		    pstmt.setString(2,DateWrapper.parseDate(tenderPost.getPostingdate()));
		    pstmt.setString(3,tenderPost.getTendername());
		    pstmt.setDouble(4,tenderPost.getCostofdoc());
		    pstmt.setDouble(5,tenderPost.getTendervalue());		    
		    pstmt.setInt(6,tenderPost.getQuantity());
		    pstmt.setString(7,tenderPost.getDuedate());		    
		    pstmt.setString(8,tenderPost.getOrdrreplaceddate());
		    pstmt.setString(9,tenderPost.getSpicification());
		    pstmt.setInt(10,tenderPost.getItemid());
		  
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
	
	
	
	public boolean UpdatePostTender(TenderPost  tenderPost)
	{
		
		PreparedStatement pstmt=null;
		try
		{
		    con=getConnection();
		    pstmt=con.prepareStatement("update  TenderPost set PosingDate=?,TenderName=?,CostofDoc=?,tenderValue=?,Quantity=?,DueDate=?,orderPlacedDate=?,spesification=?,ItemID=?  where  TenderID=?");
		  
		  
		    pstmt.setString(1,tenderPost.getPostingdate());
		    pstmt.setString(2,tenderPost.getTendername());
		    pstmt.setDouble(3,tenderPost.getCostofdoc());
		    pstmt.setDouble(4,tenderPost.getTendervalue());		    
		    pstmt.setInt(5,tenderPost.getQuantity());
		    pstmt.setString(6,tenderPost.getDuedate());		    
		    pstmt.setString(7,tenderPost.getOrdrreplaceddate());
		    pstmt.setString(8,tenderPost.getSpicification());
		    pstmt.setInt(9,tenderPost.getItemid());
		    pstmt.setInt(10,Integer.parseInt(tenderPost.getTenderid()));
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
	
	public CoreHash getAllTenderPosts()
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		TenderPost tenderPost=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from TenderPost order by TenderID desc");
            	 while(rs.next())
                 {
              	   tenderPost=new TenderPost();
              	 tenderPost.setTenderid(rs.getInt(1)+"");
     		    tenderPost.setPostingdate(DateWrapper.parseDate(rs.getDate(2)));
     		    tenderPost.setTendername(rs.getString(3));
     		    tenderPost.setCostofdoc(rs.getDouble(4));
     		    tenderPost.setTendervalue(rs.getDouble(5));		    
     		    tenderPost.setQuantity(rs.getInt(6));
     		    tenderPost.setDuedate(DateWrapper.parseDate(rs.getDate(7)));		    
     		    tenderPost.setOrdrreplaceddate(DateWrapper.parseDate(rs.getDate(8)));
     		    tenderPost.setSpicification(rs.getString(9));
     		    tenderPost.setItemid(rs.getInt(10));
              	   
              	  
              	   aCoreHash.put(new Integer(sno),tenderPost);
 			    sno++;
 		  
                 }
		}
		catch(Exception e)
		{e.printStackTrace();
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
		return aCoreHash;
	}

	//view tenders with date
	public CoreHash getAllTenderPostsDate()
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		TenderPost tenderPost=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from TenderPost where DueDate>=sysdate");
            	 while(rs.next())
                 {
              	   tenderPost=new TenderPost();
              	 tenderPost.setTenderid(rs.getInt(1)+"");
     		    tenderPost.setPostingdate(DateWrapper.parseDate(rs.getDate(2)));
     		    tenderPost.setTendername(rs.getString(3));
     		    tenderPost.setCostofdoc(rs.getDouble(4));
     		    tenderPost.setTendervalue(rs.getDouble(5));		    
     		    tenderPost.setQuantity(rs.getInt(6));
     		    tenderPost.setDuedate(DateWrapper.parseDate(rs.getDate(7)));		    
     		    tenderPost.setOrdrreplaceddate(DateWrapper.parseDate(rs.getDate(8)));
     		    tenderPost.setSpicification(rs.getString(9));
     		    tenderPost.setItemid(rs.getInt(10));
              	   
              	  
              	   aCoreHash.put(new Integer(sno),tenderPost);
 			    sno++;
 		  
                 }
		}
		catch(Exception e)
		{e.printStackTrace();
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
		return aCoreHash;
	}

	//select Particular Department
	public TenderPost getTenderPost(int tenderid)
	{
		Statement st;
		TenderPost tenderPost=null;
		try {
			 con = getConnection();
			 tenderPost=new TenderPost();
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from TenderPost where TenderID="+tenderid);
            	 if(rs.next())
                 {
              	   
            		 tenderPost.setTenderid(rs.getInt(1)+"");
          		    tenderPost.setPostingdate(DateWrapper.parseDate(rs.getDate(2)));
          		    tenderPost.setTendername(rs.getString(3));
          		    tenderPost.setCostofdoc(rs.getDouble(4));
          		    tenderPost.setTendervalue(rs.getDouble(5));		    
          		    tenderPost.setQuantity(rs.getInt(6));
          		    tenderPost.setDuedate(DateWrapper.parseDate(rs.getDate(7)));		    
          		    tenderPost.setOrdrreplaceddate(DateWrapper.parseDate(rs.getDate(8)));
          		    tenderPost.setSpicification(rs.getString(9));
          		    tenderPost.setItemid(rs.getInt(10));
                   	 
              	              	  
              	 }
		    }
		catch(Exception e)
		{e.printStackTrace();
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
		return tenderPost;
	}

}
