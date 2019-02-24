package com.dts.etender.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.core.util.DateWrapper;
import com.dts.etender.dao.DepartmentDAO;
import com.dts.etender.dao.TenderPostDAO;
import com.dts.etender.model.Department;
import com.dts.etender.model.TenderPost;

public class TenderPostAction extends HttpServlet {

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
		String target="AddTenderPost.jsp?status=TenderPosting Failed";
		try
		{

  			TenderPost tender=new TenderPost(); 
  			tender.setPostingdate(request.getParameter("bpod"));
  			
        tender.setTendername(request.getParameter("Tname"));
        tender.setCostofdoc(Double.parseDouble(request.getParameter("CostofDoc")));
        tender.setTendervalue(Double.parseDouble(request.getParameter("TenderVal")));
        tender.setQuantity(Integer.parseInt(request.getParameter("Quantity")));
        tender.setDuedate(DateWrapper.parseDate(request.getParameter("ddate")));
        tender.setSpicification(request.getParameter("Specification")); 
        tender.setItemid(Integer.parseInt(request.getParameter("ItemID")));
        tender.setOrdrreplaceddate(DateWrapper.parseDate(new Date()));
         
        boolean flag=new TenderPostDAO().postTender(tender); 
         
        if(flag) 
            target="ViewAllPostTenders.jsp?status=TenderPosted Successfully"; 
        else 
            target="AddTenderPost.jsp?status=TenderPosting Failed"; 
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}catch(Exception e){RequestDispatcher rd = request.getRequestDispatcher(target);
    rd.forward(request,response);
}
	}

}
