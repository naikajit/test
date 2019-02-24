<%@page import="com.dts.etender.model.Item"%> 
<%@page import="java.util.Enumeration,com.dts.core.util.CoreHash"%>
<%@page import="com.dts.etender.dao.ItemDAO,com.dts.core.util.DateWrapper"%>
<HTML><HEAD><TITLE>ECIL</TITLE>
<LINK 
href="images/spec_new.css" 
type=text/css rel=stylesheet><LINK 
href="images/menu.css" 
type=text/css rel=stylesheet><LINK media=print 
href="images/print.css" 
type=text/css rel=stylesheet>
<SCRIPT language=JavaScript 
src="images/main_menu.js" 
type=text/javascript></SCRIPT>

<SCRIPT language=JavaScript 
src="images/new_menu.js" 
type=text/javascript></SCRIPT>

<SCRIPT 
src="images/jquery-1.2.2.pack.js" 
type=text/javascript></SCRIPT>

<SCRIPT 
src="images/ddaccordion.js" 
type=text/javascript>

/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/

</SCRIPT>

<SCRIPT type=text/javascript>


ddaccordion.init({
	headerclass: "expandable", //Shared CSS class name of headers group that are expandable
	contentclass: "categoryitems", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})


</SCRIPT>

<META content="MSHTML 6.00.2900.2180" name=GENERATOR><meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"><style type="text/css">
<!--
body {
	background-color: #B30000;
}
-->
</style>

<link href="index_files/Style.css" type="text/css" rel="stylesheet">
<script>
<!--

function land(ref, target) 

{ lowtarget=target.toLowerCase();
if (lowtarget=="_self") {window.location=loc;} 
else {if (lowtarget=="_top") {top.location=loc;} 
else {if (lowtarget=="_blank") {window.open(loc);} 
else {if (lowtarget=="_parent") {parent.location=loc;} 
else {parent.frames[target].location=loc;}; 
}}} 
} 
function jump(menu) 
{ ref=menu.choice.options[menu.choice.selectedIndex].value; splitc=ref.lastIndexOf("&"); 
target=""; 
if (splitc!=-1)
{loc=ref.substring(0,splitc); target=ref.substring(splitc+1,1000);}
else {loc=ref; target="_top";}; 
if (ref != "") {land(loc,target);} 
}

-->

</script>
<script language="JavaScript" src="index_files/menu.js"></script>
<script language="javascript1.2">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
<script language="JavaScript" src="index_files/main_menu.js"></script>
<script language="JavaScript" src="scripts/project.js"></script>
<script language="JavaScript" src="scripts/ts_picker.js"></script>
<style type="text/css">
<!--
.style1 {
	color: #7D4B00;
	font-weight: bold;
}
-->
</style>

</HEAD>
<BODY><TABLE cellSpacing=0 cellPadding=0 width="906" align=center border=0 bgcolor='cray' height="485">
  <TBODY>
  
  <TR>
    <TD>
      <TABLE width="906" border=0 cellPadding=0 cellSpacing=0 bordercolor="#000000" bgcolor='#000000' class=white_bg height="476">
        <TBODY>
        
        <TR>
          <TD>
            <table bgcolor='cray' width="902" height="164"><tr><td>
          	<br></td><td><IMG SRC="images/ya.JPG" height="155" width="888"><!--<jsp:include page="header.html"/> header --></td><td align='right' width='1%'><br></td></tr></table>

         
         <!-- InstanceEndEditable -->
        <TR>
          <TD><%if(session.getAttribute("role")!=null){
   				if (session.getAttribute("role").equals("admin"))
		
					{%>
					<jsp:include page="adminoptions.html"/>
					<% }
				else if (session.getAttribute("role").equals("employee"))
					{%>
					
					<jsp:include page="empoptions.html"/>			
					<%}
				else {%>
						<jsp:include page="generaloptions.html"/>
					<%}
			}		
				else{
					response.sendRedirect("LoginForm.jsp?status=session expired login again...." );
			}		%>
<!-- options --></TD>

</TR>
  <TR>
    <TD>
    <br><br><br><br>	
    <form action="./TenderPostAction" method="post" name="tenderpost" onSubmit="">
         <table width="200" border="0" align="center" bgcolor="#CCCCCC" >
           <tr>
             <td><table  border="0" width="530" height="152">
               
               <tr>
               
                 <td><table border="0" align="center" bgcolor="#CCCCCC"  width="270">
               
                   <tr>
                   
                   <center> <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TenterPost Form </h2>
                     <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><%=request.getParameter("status")%></strong>
                      <%}%>
      </center>
               <br>
                   
                   
                   
                   
                  
                   
                     
                 <tr>
    <td><pre><span class=Title> Posting Date</span></pre></td>
    <td>
   <input type="text" name="bpod" value="" size="20" /><a href="javascript:show_calendar('document.tenderpost.bpod', document.tenderpost.bpod.value);"> <img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a>    </td>
  </tr>
                      
                  
                  
                  
                     <tr> <td >Tender Name</td>
                      <td ><input type="text "  name="Tname">   </td>   </tr>
                      
                       <tr> <td >Cost Of Doc</td>
                      <td ><input type="text"  name="CostofDoc">   </td>   </tr>
                        <tr> <td >Tender Value</td>
                      <td ><input type="text"  name="TenderVal">   </td>   </tr>
                      <tr> <td >Quantity</td>
                      <td ><input type="text" name="Quantity">   </td> </tr>
                      <tr>
    <td><pre><span class=Title>Due Date</span></pre></td>
    <td>
   <input type="text" name="ddate" value="" size="20" /><a href="javascript:show_calendar('document.tenderpost.ddate', document.tenderpost.ddate.value);"> <img src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a>    </td>
  </tr>
                             <tr> <td >Specification</td>
                      <td ><textarea row=1 columns=1  name="Specification"> </textarea>  </td> </tr>
                       <tr> <td >Item Name</td>
                      <td ><select name="ItemID">    
                                         
                      <%CoreHash aCoreHash=new ItemDAO().getAllItems();
                      Enumeration e=aCoreHash.keys();
		   while(e.hasMoreElements())
		   {
					   Integer i=(Integer)e.nextElement();
					   Item aItem=(Item)aCoreHash.get(i);%>
			           <option  value="<%=aItem.getItemID() %>"><%=aItem.getItemName() %></option>
                      <%} %>
                      </select>   </td>             </tr>
                  <TR>
                     <td colspan="2">
                       <div align="center">
                         <input type="submit" name="Submit" value="PostTender"/>
                          &nbsp;
                          <input name="Input2" type="reset" value="Clear"/>
                         </div>                        </td>
                      </tr>
                 </table></td>
                 
               </tr>
               
                 </table></td>
           </tr>
           </table>
              </form><br><br><br></TD></TR>
  <TR>
    <TD vAlign=top>
     
    </TD></TR></TBODY></TABLE>
<br>
  </BODY></HTML>
