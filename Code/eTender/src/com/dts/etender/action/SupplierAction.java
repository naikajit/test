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
import com.dts.etender.dao.SuppliersDAO;
import com.dts.etender.model.Profile;
import com.dts.etender.model.Supplier;

public class SupplierAction extends HttpServlet {

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

		String target="AddSuppliers.jsp?status=Supplier Registration Failed"; 
		try{
			
		Supplier supplier = new Supplier(); 
	    supplier.setCompanyName(request.getParameter("cname"));
        supplier.setHno(request.getParameter("hno")); 
        supplier.setStreet(request.getParameter("street")); 
        supplier.setCity(request.getParameter("city")); 
        supplier.setState(request.getParameter("state"));
        supplier.setCounty(request.getParameter("country"));
        supplier.setPin(request.getParameter("pin"));
        supplier.setPhno(request.getParameter("phoneno"));
        supplier.setFax(request.getParameter("fax"));
        supplier.setWebsite(request.getParameter("website"));
        supplier.setEmail(request.getParameter("email"));
        supplier.setYearofEst(request.getParameter("year"));
        supplier.setTypeofcompany(request.getParameter("typeofcompany"));
        supplier.setItemManufactures(request.getParameter("itemmanu"));
        supplier.setTypeofcompany(request.getParameter("turnover"));
        supplier.setChiefExe(request.getParameter("chiefexe"));
        supplier.setDocs(request.getParameter("doc"));
        supplier.setDor(request.getParameter("reg"));
        supplier.setMajorCustomers(request.getParameter("customer"));
        boolean flag=false;
       flag=new SuppliersDAO().insertSupplier(supplier);
        if(flag) 
           target = "Home.jsp?status=Supplier Registration Success"; 
        else  
            target = "AddSuppliers.jsp?status=Supplier Registration Failed"; 
            }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}

}
