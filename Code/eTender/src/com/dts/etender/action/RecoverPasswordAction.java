package com.dts.etender.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.core.util.LoggerManager;
import com.dts.etender.dao.SecurityDAO;
import com.dts.etender.model.Profile;

public class RecoverPasswordAction extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "RecoverPassword.jsp?status=<font color=red>Entries not Matched... Try Again</font>";;
	      try{
	          Profile rb=new Profile();
	          String loginid=request.getParameter("username");
	          String sanswer=request.getParameter("sanswer");
	          rb.setLoginID(loginid);
	          rb.setSecretAnswer(sanswer);
	          String squestid="";
	          String password="";
	          squestid=request.getParameter("squest");
	           if(request.getParameter("ch")!=null)
	          {
	          
	        	   squestid=request.getParameter("ownquest");
	            
	          }
	             
	          
	          rb.setSecretQuestionID(squestid);    
	              password=new SecurityDAO().recoverPasswordByQuestion(rb);
	          if(password.equals("") || password==null)
	              target="RecoverPassword.jsp?status=<font color=red>Entries not Matched... Try Again</font>";
	          else
	             target="LoginForm.jsp?status=Password is  <font color=green>"+password+"</font>";
	        }
	        catch(Exception e)
	        {
	           LoggerManager.writeLogSevere(e);
	        }
	        RequestDispatcher rd = request.getRequestDispatcher(target);
	        rd.forward(request,response);
	  
	}

}
