package com.dts.etender.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.etender.dao.ItemDAO;
import com.dts.etender.model.Item;

public class UpdateItemAction extends HttpServlet {

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
		String target = "UpdateItem.jsp?status=Item Updation Failed";
		try
		{
			
			
		Item item = new Item();
		item.setItemID(Integer.parseInt(request.getParameter("ItemID")));  
		item.setItemName(request.getParameter("ItemName"));
		  item.setItemType(request.getParameter("Itemtype"));
			
             System.out.println("in itemlogincheck");
			boolean flag = new ItemDAO().updateItem(item);
                if(flag)
                	target = "ViewAllItems.jsp?status=Item <font color=green>"+request.getParameter("ItemName")+"</font> Updated Successfully";               	
                else
                target ="UpdateItem.jsp?status=Item Updation Failed";
		}
		catch (Exception e)
		{
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
		
	

}
