/**
 * 
 */
package com.dts.etender.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.etender.model.Department;
import com.dts.etender.model.Profile;

/**
 * @author Administrator
 *
 */
public class DepartmentDAO extends AbstractDataAccessObject {
	
	public Connection con;
	private boolean flag=false;
//insert department
	public boolean insertDept(Department dept)
	{
		int deptID=getSequenceID("DepartmentMaster","DepartmentID");
		PreparedStatement pstmt=null;
		try
		{
		    con=getConnection();
		    pstmt=con.prepareStatement("insert into DepartmentMaster values(?,?,?,?)");
		    pstmt.setInt(1,deptID);
		    pstmt.setString(2,dept.getDepartmentName());
		    pstmt.setString(3,dept.getDepartmentAbbr());
		    pstmt.setInt(4,dept.getDepartmentInChgID());
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
	public boolean updateDept(Department dept)
	{
		
		PreparedStatement pstmt=null;
		try
		{
		    con=getConnection();
		    pstmt=con.prepareStatement("update DepartmentMaster set DepartmentName=?,DepartmentAbbr=?,DepartmentInChgID=? where DepartmentID=?");
		    
		    pstmt.setString(1,dept.getDepartmentName());
		    pstmt.setString(2,dept.getDepartmentAbbr());
		    pstmt.setInt(3,dept.getDepartmentInChgID());
		    pstmt.setInt(4,dept.getDepartmentID());
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
	//select Departments
	public CoreHash getDeptatments()
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Department dept=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from DepartmentMaster order by DepartmentId desc");
            	 while(rs.next())
                 {
              	   dept=new Department();
              	   dept.setDepartmentID(rs.getInt(1));
              	   dept.setDepartmentName(rs.getString(2));
              	   dept.setDepartmentAbbr(rs.getString(3));
              	   dept.setDepartmentInChgID(rs.getInt(4));
              	   
              	  
              	   aCoreHash.put(new Integer(sno),dept);
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
	public Department getDeptatment(int deptno)
	{
		Statement st;
		Department dept=null;
		try {
			 con = getConnection();
			 dept=new Department();
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from DepartmentMaster where departmentid="+deptno);
            	 if(rs.next())
                 {
              	   
              	   dept.setDepartmentID(rs.getInt(1));
              	   dept.setDepartmentName(rs.getString(2));
              	   dept.setDepartmentAbbr(rs.getString(3));
              	   dept.setDepartmentInChgID(rs.getInt(4));
              	              	  
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
		return dept;
	}

}
