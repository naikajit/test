package com.dts.etender.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.etender.dao.ProfileDAO;
import com.dts.etender.model.Profile;

public class RegisterAction extends HttpServlet {

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

		String target="Registerform.jsp?status=Registration Failed"; 
		try{
		 Profile rb = new Profile(); 
	    rb.setPhoto(request.getParameter("photo"));
        rb.setFirstName(request.getParameter("firstName")); 
        rb.setLastName(request.getParameter("lastName")); 
        rb.setBirthDate(request.getParameter("dob")); 
        rb.setEmail(request.getParameter("email"));
        rb.setPhone(request.getParameter("PhoneNo"));
        rb.setDeptID(Integer.parseInt(request.getParameter("DepartmentID")));
        //home
        String home=request.getParameter("homeaddresstype");
        if(home!=null)
        {
        rb.setHome(home);	
        rb.setHno(request.getParameter("homehouseno"));
        rb.setStreet(request.getParameter("homestreet"));
        rb.setCity(request.getParameter("homecity")); 
        rb.setState(request.getParameter("homestate")); 
        rb.setCountry(request.getParameter("homecountry"));
        rb.setPin(request.getParameter("homepin"));
        }
        //office
        String office=request.getParameter("officeaddresstype");
        if(office!=null)
        {
        rb.setOffice(office);	
        rb.setOhno(request.getParameter("officehouseno"));
        rb.setOstreet(request.getParameter("officestreet"));
        rb.setOcity(request.getParameter("officecity")); 
        rb.setOstate(request.getParameter("officestate")); 
        rb.setOcountry(request.getParameter("officecountry"));
        rb.setOpin(request.getParameter("officepin"));
        }
        //contact
        String contact=request.getParameter("personaladdresstype");
        if(contact!=null)
        {
       	rb.setContact(contact);	
       	rb.setChno(request.getParameter("personalhouseno"));
        rb.setCstreet(request.getParameter("personalstreet"));
        rb.setCcity(request.getParameter("personalcity")); 
        rb.setCstate(request.getParameter("personalstate")); 
        rb.setCcountry(request.getParameter("personalcountry"));
        rb.setCpin(request.getParameter("personalpin"));
        }
        rb.setLoginID(request.getParameter("userName")); 
        rb.setLoginType(request.getParameter("Desingation")); 
        rb.setPassword(request.getParameter("password")); 
        
        String questid=""; 
        if(request.getParameter("ch")!=null) 
        { 
         
            rb.setSecretQuestionID(request.getParameter("ownquest")); 
        } 
        else 
        { 
            questid=request.getParameter("squest"); 
            rb.setSecretQuestionID(questid); 
            rb.setOwnSecretQuestion("Not Mentioned"); 
        } 
        rb.setSecretAnswer(request.getParameter("secrete")); 
        rb.setLocale(request.getLocale().toString()); 
        String passportstatus=request.getParameter("passport");
        System.out.println("passport"+passportstatus);
        boolean flag=false;
        if(request.getParameter("passport")==null)
        {
        	rb.setPassportStatus(0);
            flag=new ProfileDAO().registration(rb);
        }
        else
        {
        	rb.setPassportStatus(1);
        	HttpSession session=request.getSession();
        	session.setAttribute("regbean", rb);
        	
        	response.sendRedirect("PassPortForm.jsp");
        	return;
        	
        }
        if(flag) 
           target = "AdminHome.jsp?status=Registration Success"; 
        else  
            target = "Registerform.jsp?status=Registration Failed"; 
            }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}

}
