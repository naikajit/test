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
import com.dts.core.util.LoggerManager;
import com.dts.etender.model.Item;

/**
 * @author JAVAPROJECTS
 *
 */
public class ItemDAO extends AbstractDataAccessObject {

	public Connection con;
	private boolean flag=false;
//insert department
	public boolean insertItem(Item item)
	{
		int itemID=getSequenceID("Item","ItemID");
		PreparedStatement pstmt=null;
		try
		{
		    con=getConnection();
		    pstmt=con.prepareStatement("insert into Item values(?,?,?)");
		    pstmt.setInt(1,itemID);
		    pstmt.setString(2,item.getItemName());
		    pstmt.setString(3,item.getItemType());
		    
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
	//updateDepartmentt
	public boolean updateItem(Item item)
	{
		
		PreparedStatement pstmt=null;
		try
		{
		    con=getConnection();
		    pstmt=con.prepareStatement("update Item set ItemName=?,itemType=? where ItemID=?");
		    
		    
		    pstmt.setString(1,item.getItemName());
		    pstmt.setString(2,item.getItemType());
		    pstmt.setInt(3,item.getItemID());
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
	//select Items
	public CoreHash getAllItems()
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Item item=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from Item order by ItemId desc");
            	 while(rs.next())
                 {
              	   item=new Item();
              	   item.setItemID(rs.getInt(1));
              	   item.setItemName(rs.getString(2));
              	   item.setItemType(rs.getString(3));
              	      
              	  
              	   aCoreHash.put(new Integer(sno),item);
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

	//select Particular Item
	public Item getItem(int itemno)
	{
		Statement st;
		Item item=null;
		try {
			 con = getConnection();
			 item=new Item();
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from Item where Itemid="+itemno);
            	 if(rs.next())
                 {
              	   
            		 
                	   item.setItemID(rs.getInt(1));
                	   item.setItemName(rs.getString(2));
                	   item.setItemType(rs.getString(3));
                	               	  
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
		return item;
	}
	//itemname
	public String getItemName(int itemno)
	{
		Statement st;
		String name=null;
		try {
			 con = getConnection();
			 
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT itemName from Item where Itemid="+itemno);
            	 if(rs.next())
                 {
              	   
            		 
                	   
                	   name=rs.getString(1);
                	   
                	               	  
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
		return name;
	}

}
