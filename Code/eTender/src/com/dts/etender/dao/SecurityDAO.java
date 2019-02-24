/*
 * SecurityDAO.java
 *
 * 
 */

package com.dts.etender.dao;


import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.etender.model.Profile;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
/**
 *
 * @author 
 */
public class SecurityDAO extends AbstractDataAccessObject
{
     Connection con;
     private String desc;
     private boolean flag;
    /** Creates a new instance of SecurityDAO */
    public SecurityDAO() 
    {
       
               //getting Database Connection
    	
               
    }
    
   
   
    //Login Check
    public String loginCheck(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String password=regbean.getPassword();
        String role="";        
        try
        {   con=getConnection();
        System.out.println("con"+con);
        //  con.setAutoCommit(true);
          CallableStatement cstmt=con.prepareCall("{call logincheck(?,?,?)}");
          cstmt.setString(1,loginid);
          cstmt.setString(2,password);
          cstmt.registerOutParameter(3,Types.VARCHAR);
          boolean flag= cstmt.execute();
          System.out.println("flag->"+flag);
          role=cstmt.getString(3);
          System.out.println("logintype="+role);
          
          
            
            
        }
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            desc="Database Connection problem";
            flag=false;
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
      
        
        return role;
    }
    
    
    //Method for login audit
    public void loginaudit(String loginid)
    {
        try 
        {
        	con=getConnection();
        	CallableStatement cstmt=con.prepareCall("{call signoutprocedure(?)}");
            cstmt.setString(1,loginid);
            
            System.out.println("in loginaudit");
           cstmt.execute();
           
            
        }
        catch(Exception e)
        {
             
            e.printStackTrace();
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
      
    }
    //Change Password
    public boolean changePassword(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String oldpassword=regbean.getPassword();
        String newpassword=regbean.getNewPassword();
        try 
        {
        	con=getConnection();
        	con.setAutoCommit(false);
           
            PreparedStatement pstmt=con.prepareStatement("update EmployeeMaster set password=? where loginid=? and password=?");
            
            pstmt.setString(1,newpassword);
            pstmt.setString(2,loginid);
            pstmt.setString(3,oldpassword);
                       
            int i=pstmt.executeUpdate();
            if(i==1)
            {
                flag=true;
                con.commit();
            }
            else
            {
                flag=false;
                con.rollback();
            }
            
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
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
            catch (SQLException sex) 
            {sex.printStackTrace();
            	LoggerManager.writeLogSevere(sex);
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
    
    
     //Change Secret Question
    public boolean changeQuestion(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String password=regbean.getPassword();
        String secretquestid=regbean.getSecretQuestionID();
        
        String secretans=regbean.getSecretAnswer();
        
        PreparedStatement pstmt;
        int i=0;
        try 
        {   
           
            	con=getConnection();
            	//con.setAutoCommit(false);
                
               
                pstmt=con.prepareStatement("update EmployeeMaster set forgotpwquestion=?,forgotpwanswer=? where loginid=? and password=?");
            
                pstmt.setString(1,secretquestid);
                pstmt.setString(2,secretans);
                pstmt.setString(3,loginid);
                pstmt.setString(4,password);
                i=pstmt.executeUpdate();
                
                if(i==1)
                {
                    flag=true;
                    con.commit();
                }
                else
                {
                    flag=false;
                    con.rollback();
                }
           
          
        }
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
        }
        catch (Exception e) 
        {e.printStackTrace();
        	LoggerManager.writeLogSevere(e);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
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
    
     //Recover Password using Existed Question
    public String recoverPasswordByQuestion(Profile regbean)
    {
        String password=null;
        String loginid=regbean.getLoginID();
        String secretquestid=regbean.getSecretQuestionID();
        String secretans=regbean.getSecretAnswer();
        try 
        {con=getConnection();
        	con.setAutoCommit(true); 
            PreparedStatement pstmt=con.prepareStatement("select password from EmployeeMaster where loginid=? and forgotpwquestion=? and forgotpwanswer=?");
            pstmt.setString(1,loginid);
            pstmt.setString(2,secretquestid);
            pstmt.setString(3,secretans);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
            password=rs.getString(1);
            }
      
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            password="";
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
            password=null;
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
      
        return password;        
    }
    //check useravailability
    public String  checkUser(String userName)
    {
 	   String user=null;
 	   System.out.println("username"+userName);
 	   try 
 	   
        {con=getConnection();
        	
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select loginid from EmployeeMaster where loginid=+'"+userName+"'");
           if(rs.next())
           {
            user=rs.getString(1);
            System.out.println("loginid alredy exist"+userName);
            }
           else
        	   user=null;
        
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            user=null;
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
        	user=null;
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
        
        return user;        
    }
    
}
   
