/*
 * ProfileDAO.java
 *
 * 
 * 
 */

package com.dts.etender.dao;
import oracle.jdbc.driver.*;
import com.dts.core.dao.AbstractDataAccessObject; 
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.etender.model.Profile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;


/**
 *
 * @author 
 */
public class ProfileDAO extends AbstractDataAccessObject{
    
    public Connection con;

    private boolean flag;
    /** Creates a new instance of ProfileDAO */
    public ProfileDAO() 
    {
           //getting Database Connection
           
    }
    
       
    //User Registration
    public boolean registration(Profile regbean)
    {
    	
        String loginid=regbean.getLoginID();
        String password=regbean.getPassword();
        String firstname=regbean.getFirstName();
        String lastname=regbean.getLastName();
        String logintype=regbean.getLoginType();
        String regdate=regbean.getRegDate();
        String secretquest=regbean.getSecretQuestionID();
        String ownsecretquest=regbean.getOwnSecretQuestion();
        String secretans=regbean.getSecretAnswer();
        String bdate=DateWrapper.parseDate(regbean.getBirthDate());
        String PhoneNo=regbean.getPhone();
        int passportbit=regbean.getPassportStatus();
        int deptno=regbean.getDeptID();
       //home
        String hno=regbean.getHno();
        String home=regbean.getHome();
        String street=regbean.getStreet();
        String city=regbean.getCity();
        String state=regbean.getState();
        String country=regbean.getCountry();
        String pin=regbean.getPin();
       
        //office
        String ohno=regbean.getOhno();
        String office=regbean.getOffice();
        String ostreet=regbean.getOstreet();
        String ocity=regbean.getOcity();
        String ostate=regbean.getOstate();
        String ocountry=regbean.getOcountry();
        String opin=regbean.getOpin();
        //personal
        String phno=regbean.getChno();
        String contact=regbean.getContact();
        String pstreet=regbean.getCstreet();
        String pcity=regbean.getCcity();
        String pstate=regbean.getCstate();
        String pcountry=regbean.getCcountry();
        String ppin=regbean.getCpin();
        String email=regbean.getEmail();
        String photo=regbean.getPhoto();
        String newdate=DateWrapper.parseDate(new Date());
        try 
        {
        	System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());
           
            
        	con=getConnection();
           con.setAutoCommit(false);
           CallableStatement pstmt=con.prepareCall("{call insertEmpprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        
    
           /*
			    fname EmployeeMaster.FIRSTNAME%type,
			    lname EmployeeMaster.LASTNAME%type,
			    db EmployeeMaster.DOB%type,
			    doj EmployeeMaster.DOJ%type,
			    logid EmployeeMaster.LOGINID%type,
			    pass EmployeeMaster.PASSWORD%Type,
			    secretquestion EmployeeMaster.FORGOTPWQUESTION%type,
			    secretanswer EmployeeMaster.FORGOTPWANSWER%type,
			    passstatus EmployeeMaster.Passportstatusbit%type, 
			    email EmployeeMaster.EMAIL%type,
			    Phno EmployeeMaster.phone%type,
			    photo BLOB,
			    dept EmployeeMaster.DepartmentID%type,
			    logintype EmployeeMaster.DesignationID%type,
			   */
           pstmt.setString(1,firstname);
           pstmt.setString(2,lastname);
           pstmt.setString(3,bdate);
           pstmt.setString(4, newdate);
           pstmt.setString(5,loginid);
           pstmt.setString(6,password);
          
           pstmt.setString(7,secretquest);
           pstmt.setString(8,secretans);
           pstmt.setInt(9,passportbit);
           pstmt.setString(10,email);
           pstmt.setString(11,PhoneNo);
           pstmt.setBinaryStream(12, fis,(int)f.length());
           pstmt.setInt(13,deptno);
           pstmt.setString(14,logintype);
           
    /*
     * 
    addresshome addresses.ADDRESSTYPE%type,
    housenohome addresses.DoorNO%type,
    streethome addresses.STREET%type,
    cityhome addresses.CITY%type,
    statehome addresses.STATE%type,
    countryhome addresses.COUNTRY%type,
    pincodehome addresses.PINCODE%type,
     * */       
           
           pstmt.setString(15,home);
           pstmt.setString(16,hno);
           pstmt.setString(17,street);
           pstmt.setString(18,city);
           pstmt.setString(19,state);
           pstmt.setString(20,country);
           pstmt.setString(21,pin);
           /*
            * 
    
    addressoffice addresses.ADDRESSTYPE%type,
    housenooffice addresses.DoorNO%type,
    streetoffice addresses.STREET%type,
    cityoffice addresses.CITY%type,
    stateoffice addresses.STATE%type,
    countryoffice addresses.COUNTRY%type,
    pincodeoffice addresses.PINCODE%type,
    */
           pstmt.setString(22,office);
           pstmt.setString(23,ohno);
           pstmt.setString(24,ostreet);
           pstmt.setString(25,ocity);
           pstmt.setString(26,ostate);
           pstmt.setString(27,ocountry);
           pstmt.setString(28,opin);
           /*
            * 
       
    addresspersonal addresses.ADDRESSTYPE%type,
    housenopersonal addresses.DoorNO%type,
    streetpersonal addresses.STREET%type,
    citypersonal  addresses.CITY%type,
    statepersonal addresses.STATE%type,
    countrypersonal addresses.COUNTRY%type,
    pincodepersonal addresses.PINCODE%type
    
        
        */
           pstmt.setString(29,contact);
           pstmt.setString(30,phno);
           pstmt.setString(31,pstreet);
           pstmt.setString(32,pcity);
           pstmt.setString(33,pstate);
           pstmt.setString(34,pcountry);
           pstmt.setString(35,ppin);
           int i= pstmt.executeUpdate();
             
             if(i==1)
             {
              flag=true;
             }
             else
             {
            	 flag=false;
            	 
             }
            
        } 
        catch(SQLException e)
    	{
    	System.out.println(e.toString());
    	if(e.toString().equalsIgnoreCase("java.sql.SQLException: [Microsoft][ODBC driver for Oracle][Oracle]ORA-12571: TNS:packet writer failure"))
    		{
    		flag=true;
    		System.out.println("n==="+flag);
    		}
    System.out.println(e);

    	}
        catch (Exception e) 
        {
            e.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException se) 
            {
                se.printStackTrace();
            }
        }
        finally
        {
        	try{
        		con.close();
        	}catch(Exception e)
        	{
        		LoggerManager.writeLogSevere(e);
            }
        	
        }
      
        return flag;
    }
      
    //Getting profile
    public Profile getProfile(String loginname,String path)
    {
        Profile rb=new Profile();
        try
        {
        	con=getConnection();
        	CallableStatement cs=con.prepareCall("{call showprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		    
		    /*
		
		 1 logid EmployeeMaster.loginid%type,
		 2 pass out EmployeeMaster.PASSWORD%type,
		 3 fname OUT EmployeeMaster.FIRSTNAME%type,
		 4 lname OUT  EmployeeMaster.LASTNAME%type,
		 5 db OUT varchar2,
		 6 emailid OUT  EmployeeMaster.EMAIL%type,
		 7 phno OUT EmployeeMaster.phone%type,
		 8 addresshome OUT addresses.ADDRESSTYPE%type,
		 9 housenohome OUT addresses.DoorNO%type,
		 10 streethome OUT addresses.STREET%type,
		 11 cityhome OUT addresses.CITY%type,
		 12 statehome OUT addresses.STATE%type,
		 13 countryhome OUT addresses.COUNTRY%type,
		 14 pincodehome OUT addresses.PINCODE%type,
		 15 addressoffice OUT addresses.ADDRESSTYPE%type,
		 16 housenooffice OUT addresses.doorNO%type,
		 17 streetoffice OUT addresses.STREET%type,
		 18 cityoffice OUT  addresses.CITY%type,
		 19 stateoffice OUT addresses.STATE%type,
		 20 countryoffice OUT addresses.COUNTRY%type,
		 21 pincodeoffice OUT addresses.PINCODE%type,
		 22 addresspersonal OUT addresses.ADDRESSTYPE%type,
		 23 housenopersonal OUT addresses.doorNO%type,
		 24 streetpersonal OUT addresses.STREET%type,
		 25 citypersonal OUT addresses.CITY%type,
		 26 statepersonal OUT addresses.STATE%type,
		 27 countrypersonal OUT addresses.COUNTRY%type,
		 28 pincodepersonal OUT addresses.PINCODE%type,
		 29 photograph OUT  EmployeeMaster.PHOTO%type

		     */
		    		
		    
		    cs.setString(1,loginname);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.VARCHAR);
			cs.registerOutParameter(7,Types.VARCHAR);
			cs.registerOutParameter(8,Types.VARCHAR);
			cs.registerOutParameter(9,Types.VARCHAR);
			cs.registerOutParameter(10,Types.VARCHAR);
			cs.registerOutParameter(11,Types.VARCHAR);
			cs.registerOutParameter(12,Types.VARCHAR);
			cs.registerOutParameter(13,Types.VARCHAR);
			cs.registerOutParameter(14,Types.VARCHAR);
			cs.registerOutParameter(15,Types.VARCHAR);
			cs.registerOutParameter(16,Types.VARCHAR);
			cs.registerOutParameter(17,Types.VARCHAR);
			cs.registerOutParameter(18,Types.VARCHAR);
			cs.registerOutParameter(19,Types.VARCHAR);
			cs.registerOutParameter(20,Types.VARCHAR);
			cs.registerOutParameter(21,Types.VARCHAR);
			cs.registerOutParameter(22,Types.VARCHAR);
			cs.registerOutParameter(23,Types.VARCHAR);
			cs.registerOutParameter(24,Types.VARCHAR);
			cs.registerOutParameter(25,Types.VARCHAR);
			cs.registerOutParameter(26,Types.VARCHAR);
			cs.registerOutParameter(27,Types.VARCHAR);
			cs.registerOutParameter(28,Types.VARCHAR);
			cs.registerOutParameter(29,Types.BLOB);
			cs.execute();
			   /*
			
			 1 logid EmployeeMaster.loginid%type,
			 2 pass out EmployeeMaster.PASSWORD%type,
			 3 fname OUT EmployeeMaster.FIRSTNAME%type,
			 4 lname OUT  EmployeeMaster.LASTNAME%type,
			 5 db OUT varchar2,
			 6 emailid OUT  EmployeeMaster.EMAIL%type,
			 7 phno OUT EmployeeMaster.phone%type,
			 8 addresshome OUT addresses.ADDRESSTYPE%type,
			 9 housenohome OUT addresses.DoorNO%type,
			 10 streethome OUT addresses.STREET%type,
			 11 cityhome OUT addresses.CITY%type,
			 12 statehome OUT addresses.STATE%type,
			 13 countryhome OUT addresses.COUNTRY%type,
			 14 pincodehome OUT addresses.PINCODE%type,
			*/
			rb.setPassword(cs.getString(2));
			rb.setFirstname(cs.getString(3));
			rb.setLastname(cs.getString(4));
			rb.setBdate(cs.getString(5));
			rb.setEmail(cs.getString(6));
			rb.setPhone(cs.getString(7));
			rb.setHome(cs.getString(8));
			rb.setHno(cs.getString(9));
			rb.setStreet(cs.getString(10));
			rb.setCity(cs.getString(11));
			rb.setState(cs.getString(12));
			rb.setCountry(cs.getString(13));
			rb.setPin(cs.getString(14));
			/*
		 
		  15 addressoffice OUT addresses.ADDRESSTYPE%type,
		 16 housenooffice OUT addresses.doorNO%type,
		 17 streetoffice OUT addresses.STREET%type,
		 18 cityoffice OUT  addresses.CITY%type,
		 19 stateoffice OUT addresses.STATE%type,
		 20 countryoffice OUT addresses.COUNTRY%type,
		 21 pincodeoffice OUT addresses.PINCODE%type,
		 22 addresspersonal OUT addresses.ADDRESSTYPE%type,
		 23 housenopersonal OUT addresses.doorNO%type,
		 24 streetpersonal OUT addresses.STREET%type,
		 25 citypersonal OUT addresses.CITY%type,
		 26 statepersonal OUT addresses.STATE%type,
		 27 countrypersonal OUT addresses.COUNTRY%type,
		 28 pincodepersonal OUT addresses.PINCODE%type,
		 29 photograph OUT  EmployeeMaster.PHOTO%type

			  */
			rb.setOffice(cs.getString(15));
			rb.setOhno(cs.getString(16));
			rb.setOstreet(cs.getString(17));
			rb.setOcity(cs.getString(18));
			rb.setOstate(cs.getString(19));
			rb.setOcountry(cs.getString(20));
			rb.setOpin(cs.getString(21));
			rb.setContact(cs.getString(22));
			rb.setChno(cs.getString(23));
			rb.setCstreet(cs.getString(24));
			rb.setCcity(cs.getString(25));
			rb.setCstate(cs.getString(26));
			rb.setCcountry(cs.getString(27));
			rb.setCpin(cs.getString(28));
			Blob b =cs.getBlob(29);
		byte b1[]=b.getBytes(1,(int)b.length());
		OutputStream fout=new FileOutputStream(path+"/"+loginname+".gif");
		fout.write(b1);

	}
	
        catch(Exception e)
        {e.printStackTrace();
        	LoggerManager.writeLogSevere(e);
        }
        finally
        {
        	try{
        		con.close();
        	}catch(Exception e)
        	{
        		LoggerManager.writeLogSevere(e);
            }
        	
        }
        return rb;
    }     // Modify Profile
    
    //getting inchargeUserName
    public String getUserID(int empid)
    {
    	String loginid=null;
    	try {
			 con = getConnection();
			   
           	 
			 Statement st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT loginid from EmployeeMaster where EmployeeID="+empid);
           	 if(rs.next())
                {
             	   loginid=rs.getString(1);
             	   
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
		return loginid;
	}
    
    
    public boolean modifyProfile(Profile regbean)
    {
    	String loginid=regbean.getLoginID();
        String firstname=regbean.getFirstName();
        String lastname=regbean.getLastName();
        String phone=regbean.getPhone();
        // String bdate=DateWrapper.parseDate(regbean.getBirthDate());
       //home
        String hno=regbean.getHno();
        String home=regbean.getHome();
        String street=regbean.getStreet();
        String city=regbean.getCity();
        String state=regbean.getState();
        String country=regbean.getCountry();
        String pin=regbean.getPin();
                
        //office
        String ohno=regbean.getOhno();
        String office=regbean.getOffice();
        String ostreet=regbean.getOstreet();
        String ocity=regbean.getOcity();
        String ostate=regbean.getOstate();
        String ocountry=regbean.getOcountry();
        String opin=regbean.getOpin();
        //personal
        String phno=regbean.getChno();
        String contact=regbean.getContact();
        String pstreet=regbean.getCstreet();
        String pcity=regbean.getCcity();
        String pstate=regbean.getCstate();
        String pcountry=regbean.getCcountry();
        String ppin=regbean.getCpin();
        
        
        String email=regbean.getEmail();
        String photo=regbean.getPhoto();
        String newdate=DateWrapper.parseDate(new Date());
        try 
        {
        	System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());
           
        	con=getConnection();
          // con.setAutoCommit(false);
        	CallableStatement cs=con.prepareCall("{call changeprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    
        	/*
    	   1 fname userdetails.FIRSTNAME%type,
		   2 lname userdetails.LASTNAME%type,
		   3 logid userdetails.LOGINID%type,
		   4 photo userdetails.photograph%type,
		   5 email userdetails.EMAILID%type,
		       
        	 */
        	cs.setString(1,firstname);
    		cs.setString(2,lastname);
    		cs.setString(3,loginid);
    		cs.setBinaryStream(4, fis,(int)f.length());
    		cs.setString(5,email);
    		cs.setString(6,phone);    
    		/*
    	    7 addresshome addresses.ADDRESSTYPE%type,
		    8 housenohome addresses.HOUSENO%type,
		    9 streethome addresses.STREET%type,
		    10 cityhome addresses.CITY%type,
		    11 statehome addresses.STATE%type,
		    12 countryhome addresses.COUNTRY%type,
		    13 pincodehome addresses.PINCODE%type,
	   		 */
       		cs.setString(7,home);
    		cs.setString(8,hno);
    		cs.setString(9,street);
    		cs.setString(10,city);
    		cs.setString(11,state);
    		cs.setString(12,country);
    		cs.setString(13,pin);
       		/*
    		 14  addressoffice addresses.ADDRESSTYPE%type,
			 15  housenooffice addresses.HOUSENO%type,
			 16  streetoffice addresses.STREET%type,
			 17  cityoffice addresses.CITY%type,
			 18  stateoffice addresses.STATE%type,
			 19  countryoffice addresses.COUNTRY%type,
			 20 pincodeoffice addresses.PINCODE%type,
	   		 */
    		cs.setString(14,office);
       		cs.setString(15,ohno);
    		cs.setString(16,ostreet);
    		cs.setString(17,ocity);
    		cs.setString(18,ostate);
    		cs.setString(19,ocountry);
    		cs.setString(20,opin);
    		/*
       		21 addresspersonal addresses.ADDRESSTYPE%type,
		    22 housenopersonal addresses.HOUSENO%type,
		    23 streetpersonal addresses.STREET%type,
		    24 citypersonal  addresses.CITY%type,
		    25 statepersonal addresses.STATE%type,
		    26 countrypersonal addresses.COUNTRY%type,
		    27 pincodepersonal addresses.PINCODE%type,
		    
    		 */
    		cs.setString(21,contact);
    		cs.setString(22,phno);
    		cs.setString(23,pstreet);
    		cs.setString(24,pcity);
    		cs.setString(25,pstate);
    		cs.setString(26,pcountry);
    		cs.setString(27,ppin);
    
    		/*
    	    28 phonehome phones.PHONETYPE%type,
    	    29 phonenohome phones.PHONENO%type,
    	    30 phoneoffice phones.PHONETYPE%type,
    	    31 phonenooffice phones.PHONENO%type,
    	    32 phonepersonal phones.PHONETYPE%type,
    	    33 phonenopersonal phones.PHONENO%type,
    	    34 flag out number
    	          
    	    */ 
    	    cs.registerOutParameter(28,Types.INTEGER);
    			cs.execute();
    		int n=cs.getInt(28);
    		if(n>0)
    		{
    			flag=true;
    	}
           
            else
            {
                flag=false;
            con.rollback();
            }
           
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
                sex.printStackTrace();
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException se) 
            {
                se.printStackTrace();
            }
        }
        finally
        {
        	try{
        		con.close();
        	}catch(Exception e)
        	{
        		LoggerManager.writeLogSevere(e);
            }
        	
        }
      
        return flag;
    }
	//select Admins
	public CoreHash getAdmins()
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Profile aProfile=null;
		try {
			 
			     con = getConnection();
			   	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT EmployeeID,loginid from EmployeeMaster where DesignationID='admin'");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	   aProfile.setEmpid(rs.getInt(1));
              	   aProfile.setLoginID(rs.getString(2));
              	   
              	  
              	   aCoreHash.put(new Integer(sno),aProfile);
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
   //getreport of login fromdate todate
    public CoreHash getReportFromTo(String sdate,String edate)
	{
		System.out.println("sdate"+sdate+" edate="+edate);
		Properties p=getProperties();
		String pattern="";
		if(p.getProperty("dbname").equals("access"))
			pattern="#";
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT DISTINCT(UD.LOGINID ),UD.FIRSTNAME,UD.LASTNAME,UD.DOB,UD.DOR,UD.EMAILID FROM USERDETAILS UD,LOGINMASTER LM WHERE UD.USERID=LM.USERID AND TO_CHAR(LOGINDATE,'DD-MM-YYYY')>='"+sdate+"' AND TO_CHAR(LOGINDATE,'DD-MM-YYYY')<='"+edate+"'");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	  
              	   aProfile.setLoginID(rs.getString(1));
              	   aProfile.setFirstname(rs.getString(2));  
              	   aProfile.setLastName(rs.getString(3));
              	   String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	aProfile.setBirthDate(date);
                   aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   aProfile.setEmail(rs.getString(6));
                   /*Blob b =rs.getBlob(7);
          			byte b1[]=b.getBytes(1,(int)b.length());
          			OutputStream fout=new FileOutputStream(path+"/"+rs.getString(1)+".gif");
       			fout.write(b1);
               	   */
              	 aCoreHash.put(new Integer(sno),aProfile);
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
  //getreport of login fromdate todate
    public CoreHash getReportByRegisterDate(String sdate,String edate,String path )
	{
		
		Properties p=getProperties();
		System.out.println("sdate="+sdate);
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT LOGINID ,FIRSTNAME,LASTNAME,DOB,DOR,EMAILID,photograph FROM USERDETAILS WHERE TO_CHAR(DOR,'DD-MM-YYYY')>='"+sdate+"' AND TO_CHAR(DOR,'DD-MM-YYYY')<='"+edate+"'");
            	 System.out.println("after result set inregisterusers ");
            	 while(rs.next())
                 {System.out.println("after result set inregisterusers in while");
              	   aProfile=new Profile();
              	  
              	   aProfile.setLoginID(rs.getString(1));
              	   aProfile.setFirstname(rs.getString(2));  
              	   aProfile.setLastName(rs.getString(3));
              	   String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	aProfile.setBirthDate(date);
                   aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   aProfile.setEmail(rs.getString(6));
                   Blob b =rs.getBlob(7);
       			byte b1[]=b.getBytes(1,(int)b.length());
       			OutputStream fout=new FileOutputStream(path+"/"+rs.getString(1)+".gif");
    			fout.write(b1);   
              	 aCoreHash.put(new Integer(sno),aProfile);
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

    public CoreHash getAllEmps(String path)
	{
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT EmployeeID,loginid,firstname,lastname,DOB,Email,phone,Passportstatusbit,photo FROM EmployeeMaster");
            	 
            	 while(rs.next())
                 {
            	   
              	   aProfile=new Profile();
              	   aProfile.setEmpid(rs.getInt(1));
              	   aProfile.setLoginID(rs.getString(2));
              	   aProfile.setFirstname(rs.getString(3));  
              	   aProfile.setLastName(rs.getString(4));
              	   String date=DateWrapper.parseDate(rs.getDate(5)).trim();
                   aProfile.setBirthDate(date);
                   aProfile.setEmail(rs.getString(6));
                   aProfile.setPhone(rs.getString(7));
                   aProfile.setPassportStatus(rs.getInt(8));
                   Blob b =rs.getBlob(9);
       			byte b1[]=b.getBytes(1,(int)b.length());
       			OutputStream fout=new FileOutputStream(path+"/"+rs.getString(2)+".gif");
    			fout.write(b1);   
              	 aCoreHash.put(new Integer(sno),aProfile);
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

//employeeswithpassports
    public CoreHash getAllEmpsPassPorts(String path)
	{
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT EmployeeID,loginid,firstname,lastname,DOB,Email,phone,Passportstatusbit,photo FROM EmployeeMaster where Passportstatusbit=1");
            	 
            	 while(rs.next())
                 {
            	   
              	   aProfile=new Profile();
              	   aProfile.setEmpid(rs.getInt(1));
              	   aProfile.setLoginID(rs.getString(2));
              	   aProfile.setFirstname(rs.getString(3));  
              	   aProfile.setLastName(rs.getString(4));
              	   String date=DateWrapper.parseDate(rs.getDate(5)).trim();
                   aProfile.setBirthDate(date);
                   aProfile.setEmail(rs.getString(6));
                   aProfile.setPhone(rs.getString(7));
                   aProfile.setPassportStatus(rs.getInt(8));
                   Blob b =rs.getBlob(9);
       			byte b1[]=b.getBytes(1,(int)b.length());
       			OutputStream fout=new FileOutputStream(path+"/"+rs.getString(2)+".gif");
    			fout.write(b1);   
              	 aCoreHash.put(new Integer(sno),aProfile);
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


    
    //presentloginuser getting
    
    public CoreHash getReportPresent()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		CallableStatement cstmt;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
			
            	 cstmt=con.prepareCall("{call REF_CURSOR_TEST.GET_ACCOUNTS_PROCEDURE(?)}");
            	 cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            	 cstmt.executeUpdate();
            	 ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
            	  while(rs.next())
                 {
              	   aProfile=new Profile();
              	   
              	   aProfile.setLoginID(rs.getString(1));
              	   aProfile.setFirstname(rs.getString(2));  
              	   aProfile.setLastName(rs.getString(3));
              	   String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	aProfile.setBirthDate(date);
                   aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   aProfile.setEmail(rs.getString(6));
                   	
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
    
    
    public boolean changeAccountStatus(String loginid,int status)
    {
        try 
        {
        	con=getConnection();
            con.setAutoCommit(false);
            
        }
        catch(Exception e){}
        return flag;
    }
}
