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
import com.dts.etender.dao.QuatationDAO;
import com.dts.etender.dao.TenderPostDAO;
import com.dts.etender.model.Quatation;
import com.dts.etender.model.TenderPost;

public class QuatationTenderAction extends HttpServlet {

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

		String target="QuatationTender.jsp?status=QuatationPosting Failed";
		try
		{

  			Quatation quatation=new Quatation(); 
  		quatation.setTenderID(Integer.parseInt(request.getParameter("TenderID")));
  		quatation.setSuppierName(request.getParameter("SuppName"));
        quatation.setDDNo(request.getParameter("DDNo"));
        quatation.setQuantity(Integer.parseInt(request.getParameter("Quantity"))); 
        quatation.setSpesification(request.getParameter("Specification"));
        quatation.setPricebid(Integer.parseInt(request.getParameter("PriceBid")));
         
        boolean flag=new QuatationDAO().postQuatation(quatation); 
         
        if(flag) 
            target="QuatationTender.jsp?status=Quatationed Successfully"; 
        else 
            target="QuatationTender.jsp?status=QuatationPosting Failed"; 
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}catch(Exception e){RequestDispatcher rd = request.getRequestDispatcher(target);
    rd.forward(request,response);
}
	}

}
