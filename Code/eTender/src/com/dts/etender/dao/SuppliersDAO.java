/**
 * 
 */
package com.dts.etender.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.etender.model.Supplier;
import com.dts.etender.model.TenderPost;

/**
 * @author JAVAPROJECTS
 *
 */
public class SuppliersDAO extends AbstractDataAccessObject {
	public Connection con;
	private boolean flag=false;
//insert department
	public boolean insertSupplier(Supplier  supplier)
	{
		
		PreparedStatement pstmt=null;
		try
		{
			 String filePath=supplier.getDocs();	 
		     StringTokenizer stk=new StringTokenizer(filePath,".");
	 	     String uploadpath=stk.nextToken();
      		 String extension=stk.nextToken();
	 		 StringTokenizer stkFileName=new StringTokenizer(uploadpath,"\\");
	 		 int tokenCount=	stkFileName.countTokens();
	 	
	 		 int j=0;
	 		 String uploadFileName=null;
	 		 while (stkFileName.hasMoreTokens())
	 		 {
	 			j++;
	 			uploadFileName=stkFileName.nextToken();
	 			System.out.println("tokens"+j);
	 		 } 
	 		 File file=new File(filePath);
	 		 FileReader reader=new FileReader(file);
		    con=getConnection();
		    pstmt=con.prepareStatement("insert into Suppliers values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		    pstmt.setString(1,supplier.getCompanyName());
		    pstmt.setString(2,supplier.getHno());
		    pstmt.setString(3,supplier.getStreet());
		    pstmt.setString(4,supplier.getCity());
		    pstmt.setString(5,supplier.getState());		    
		    pstmt.setString(6,supplier.getCounty());
		    pstmt.setString(7,supplier.getPin());		    
		    pstmt.setString(8,supplier.getPhno());
		    pstmt.setString(9,supplier.getFax());
		    pstmt.setString(10,supplier.getWebsite());
		    pstmt.setString(11,supplier.getEmail());
		    pstmt.setString(12,supplier.getYearofEst());
		    pstmt.setString(13,supplier.getTypeofcompany());
		    pstmt.setString(14,supplier.getItemManufactures());
		    pstmt.setString(15,supplier.getCompanyTurnover());		    
		    pstmt.setString(16,supplier.getChiefExe());
		    pstmt.setCharacterStream(17, reader, (int) file.length());
		    pstmt.setString(18,DateWrapper.parseDate(supplier.getDor()));
		    pstmt.setString(19,supplier.getMajorCustomers());
		  
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
	
	
	public CoreHash getAllSuppliers(String path)
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Supplier supplier=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from Suppliers");
            	 while(rs.next())
                 {
              	   supplier=new Supplier();
              	 supplier.setCompanyName(rs.getString(1));
              	supplier.setHno(rs.getString(2));
    		    supplier.setStreet(rs.getString(3));
    		    supplier.setCity(rs.getString(4));
    		    supplier.setState(rs.getString(5));		    
    		    supplier.setCounty(rs.getString(6));
    		    supplier.setPin(rs.getString(7));		    
    		    supplier.setPhno(rs.getString(8));
    		    supplier.setFax(rs.getString(9));
    		    supplier.setWebsite(rs.getString(10));
    		    supplier.setEmail(rs.getString(11));
    		    supplier.setYearofEst(rs.getString(12));
    		    supplier.setTypeofcompany(rs.getString(13));
    		    supplier.setItemManufactures(rs.getString(14));
    		    supplier.setCompanyTurnover(rs.getString(15));		    
    		    supplier.setChiefExe(rs.getString(16));
    		    File data = new File(path+"/"+rs.getString(1)+".doc");
    		    Reader reader = rs.getCharacterStream(2);
    		    FileWriter writer = new FileWriter(data);
                char[] buffer = new char[1];
                while (reader.read(buffer) > 0) {
                    writer.write(buffer);
                    
                }
                writer.close();
    		    supplier.setDor(DateWrapper.parseDate(rs.getDate(18)));
    		    supplier.setMajorCustomers(rs.getString(19));
              	  
              	   aCoreHash.put(new Integer(sno),supplier);
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
	public Supplier getSupplier(String comName,String path)
	{
		Statement st;
		Supplier supplier=null;
		try {
			 con = getConnection();
			 supplier=new Supplier();
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from Suppliers where companyName='"+comName+"'");
            	 if(rs.next())
                 {
              	   
            		 supplier.setCompanyName(rs.getString(1));
                   	supplier.setHno(rs.getString(2));
         		    supplier.setStreet(rs.getString(3));
         		    supplier.setCity(rs.getString(4));
         		    supplier.setState(rs.getString(5));		    
         		    supplier.setCounty(rs.getString(6));
         		    supplier.setPin(rs.getString(7));		    
         		    supplier.setPhno(rs.getString(8));
         		    supplier.setFax(rs.getString(9));
         		    supplier.setWebsite(rs.getString(10));
         		    supplier.setEmail(rs.getString(11));
         		    supplier.setYearofEst(rs.getString(12));
         		    supplier.setTypeofcompany(rs.getString(13));
         		    supplier.setItemManufactures(rs.getString(14));
         		    supplier.setCompanyTurnover(rs.getString(15));		    
         		    supplier.setChiefExe(rs.getString(16));
         		    File data = new File(path+"/"+rs.getString(1)+".doc");
         		    Reader reader = rs.getCharacterStream(2);
         		    FileWriter writer = new FileWriter(data);
                     char[] buffer = new char[1];
                     while (reader.read(buffer) > 0) {
                         writer.write(buffer);
                         
                     }
                     writer.close();
         		    supplier.setDor(DateWrapper.parseDate(rs.getDate(18)));
         		    supplier.setMajorCustomers(rs.getString(19));
                   	  
                   	 
              	              	  
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
		return supplier;
	}

}
