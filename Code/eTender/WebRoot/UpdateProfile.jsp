<%@ page import="com.dts.etender.dao.*,com.dts.etender.model.*" %>
<script type="text/javascript">
function onchangeAddress()
{
var form = document.register;
 var selectWidget = document.forms.register.elements["addressType"];
 
 var myValue = selectWidget.options[selectWidget.selectedIndex].value;
 if(myValue=="home")
 {
 document.register.houseNo.value=document.register.homehouseno.value
 document.register.street.value=document.register.homestreet.value
  
 document.register.country.value=document.register.homecountry.value
 document.register.pin.value=document.register.homepin.value
 document.register.state.value=document.register.homestate.value
 document.register.phoneNo.value=document.register.homephoneno.value
 document.register.city.value=document.register.homecity.value
//document.register.fax.value=document.register.homefax.value
return false;
	}
else if(myValue=="office")
{
  document.register.houseNo.value=document.register.officehouseno.value
 document.register.street.value=document.register.officestreet.value
  
 document.register.country.value=document.register.officecountry.value
 document.register.pin.value=document.register.officepin.value
 document.register.state.value=document.register.officestate.value
 document.register.phoneNo.value=document.register.officephoneno.value
 document.register.city.value=document.register.officecity.value
//document.register.fax.value=document.register.officefax.value
 return false;
 }
 else if(myValue=="personal")
{
 document.register.houseNo.value=document.register.personalhouseno.value
 document.register.street.value=document.register.personalstreet.value
 document.register.country.value=document.register.personalcountry.value
 document.register.pin.value=document.register.personalpin.value
 document.register.state.value=document.register.personalstate.value
 document.register.phoneNo.value=document.register.personalphoneno.value
 document.register.city.value=document.register.personalcity.value
//document.register.fax.value=document.register.personalfax.value
 return false;
  
}
return true;
}
</script>

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

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js"></script>
 <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>

<script language="JavaScript" src="images/javascripts.js"></script>
<script language="JavaScript" src="images/pop-closeup.js"></script>

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
<style type="text/css">
<!--
.style1 {
	color: #7D4B00;
	font-weight: bold;
}
a:hover {
	color: #0099CC;
}
a:link {
	color: #0000FF;
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
    
    <%
String name=(String)session.getAttribute("user");
String path=request.getRealPath("/userimages");
		Profile aprofile=new ProfileDAO().getProfile(name,path);


%>
     
        
      <p>&nbsp;</p><%if(request.getParameter("status")!=null){ %>
      <%=request.getParameter("status") %><%} %>
      
      <table bgcolor="#FEE8B6"><tr><td border="1" bgcolor="#FEE8B6">
      <form action="./updateAction" name="register">
      <center><span class=subHead><h3>Update Profile</h3></span></center>
      <p align="center">
      
       <table width="405" border="0" align="left">
<th colspan=2><span class=Title>1.Personal Details</span></th>
<tr></tr><tr></tr>
  <tr>
    <td align="center"><span class=Title>First Name</span></td>
    <td width="255"><input type="text" name="firstName" value="<%=aprofile.getFirstname()%>" type="text" STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;" size="18" maxlength="30" readonly/></td>
  </tr>
<tr>
     <td align="center"><span class=Title>Last Name</span></td>
    <td width="273"><font size="3" face="Verdana">
      <input type="text" name="lastName" value="<%=aprofile.getLastname()%>" type="text" STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;" size="18" maxlength="30" readonly/>
    </font></td>
  </tr>
  <tr>
    <td align="center"><span class=Title> Birth Date</span></td>
    <td>
   <input type="text" name="dob" value="<%=aprofile.getBdate()%>" type="text" STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;" size="18" maxlength="30" readonly/><a href="javascript:show_calendar('document.register.dob', document.register.dob.value);"> 
    </td>
  </tr>
  
  <tr>
    <td align="center"><span class=Title>Browse Photo</span></td>
    <td><input type="file" name="photo" class="textfield" onChange="preview(this)"/></td>
  </tr> 
 
  <tr>
    <td align="center"><span class=Title>Email</span></td>
    <td><input type="text" name="email" value="<%=aprofile.getEmail()%>"/></td>
  </tr>
  <tr>
    <td align="center"><span class=Title> Phone No</span></td>
    <td>
      <input type="text" name="fax" value="<%=aprofile.getPhone()%>" size="20"/>
    </td>
  </tr>
<th colspan="2"><span class=Title>2.Contact Details</span></th>
<tr></tr><tr></tr>
<tr>
    <td align="center"><span class=Title> Address Type </span></td>
    <td width="255"><select name="addressType" onChange="onchangeAddress()">
    <option value="select" selected="true"><font size="3" face="Verdana">Select </font></option>
    <option value="home"><font size="3" face="Verdana">Home</font></option>
    <option value="office"><font size="3" face="Verdana">Office</font></option>
    <option value="personal"><font size="3" face="Verdana">Personal</font></option>
      </select></td>
</tr>
<tr>
    <td align="center"><span class=Title> House No</span></td>
    <td><input type="text" name="houseNo" value="" size="20" onChange="showStatus1()"/></td>
</tr>
<tr>
    <td align="center"><span class=Title>Street</span></td>
    <td><input type="text" name="street" value="" size="20" onChange="showStatus1()"/></td>
</tr>

  <tr>
    <td align="center"><span class=Title> State</span></td>
    <td>
      <input type="text" name="state" value="" size="20" onChange="showStatus1()"/>
    </td>
  </tr>
<tr>
    <td></td>
    <td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="createAccount" class="ygbtem" value="Update"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="cancel" value="Cancel"/></td>
</tr>
</table>
<table width="403" border="0" align="center" height="167">
  <tr rowspan="7"></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr>
	  
    <tr colspan="3">
    <td><img alt="See Photo Here" id="previewField" src="userimages/<%=session.getAttribute("user") %>.gif" height="150" width="120"></td>
  </tr>
  
</table>
<table width="403" border="0" align="center" height="126">
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr rowspan="2"></tr>
 
  <tr>
    <td><span class=Title> Country</span></td>
    <td>
      <input type="text" name="country" value="" size="20" onChange="showStatus1()"/>
    </td>
  </tr>
  <tr>
    <td><span class=Title> Pin</span></td>
    <td>
      <input type="text" name="pin" value="" size="20" onChange="showStatus1(),showStatus()"/>
    </td>
  </tr>
  
  </table>
  </td></tr></table>
  <input type="hidden" name="homeaddresstype" value="home"/>
<input type="hidden" name="homehouseno" value="<%=aprofile.getHno()%>"/>
<input type="hidden" name="homestreet" value="<%=aprofile.getStreet()%>"/>
<input type="hidden" name="homephoneType" value="home"/>
<input type="hidden" name="homecountry" value="<%=aprofile.getCountry()%>"/>
<input type="hidden" name="homepin" value="<%=aprofile.getPin()%>"/>
<input type="hidden" name="homestate" value="<%=aprofile.getState()%>"/>
<input type="hidden" name="homephoneno" value="<%=aprofile.getPhone()%>"/>
<input type="hidden" name="homecity" value="<%=aprofile.getCity()%>"/>




<input type="hidden" name="officeaddresstype" value="office"/>
<input type="hidden" name="officehouseno" value="<%=aprofile.getOhno()%>"/>
<input type="hidden" name="officestreet" value="<%=aprofile.getOstreet()%>"/>
<input type="hidden" name="officephonetype" value="office"/>
<input type="hidden" name="officecountry" value="<%=aprofile.getOcountry()%>"/>
<input type="hidden" name="officepin" value="<%=aprofile.getOpin()%>"/>
<input type="hidden" name="officestate" value="<%=aprofile.getOstate()%>"/>
<input type="hidden" name="officephoneno" value="<%=aprofile.getOphone()%>"/>
<input type="hidden" name="officecity" value="<%=aprofile.getOcity()%>"/>



<input type="hidden" name="personaladdresstype" value="personal"/>
<input type="hidden" name="personalhouseno" value="<%=aprofile.getChno() %>"/>
<input type="hidden" name="personalstreet" value="<%=aprofile.getCstreet() %>"/>
<input type="hidden" name="personalphonetype" value="mobile"/>
<input type="hidden" name="personalcountry" value="<%=aprofile.getCcountry() %>"/>
<input type="hidden" name="personalpin" value="<%=aprofile.getCpin() %>"/>
<input type="hidden" name="personalstate" value="<%=aprofile.getCstate() %>"/>
<input type="hidden" name="personalphoneno" value="<%=aprofile.getCphone() %>"/>
<input type="hidden" name="personalcity" value="<%=aprofile.getCcity() %>"/>


  


  <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
 
  frmvalidator.addValidation("firstName","req","Please enter your First Name");
  frmvalidator.addValidation("firstName","maxlen=20",	"Max length for FirstName is 20");
  frmvalidator.addValidation("firstName","alpha"," First Name Alphabetic chars only");
  
  frmvalidator.addValidation("lastName","req","Please enter your Last Name");
  frmvalidator.addValidation("lastName","maxlen=20","Max length is 20");
  frmvalidator.addValidation("lastName","alpha"," Last Name Alphabetic chars only");
  
  
   frmvalidator.addValidation("dob","req","Please enter your DOB"); 
  
   frmvalidator.addValidation("photo","req","Please Load Your Photo"); 
  
  frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
   
  
   frmvalidator.addValidation("addressType","dontselect=0");
   
   frmvalidator.addValidation("houseNo","req","Please enter your House Number");
   
   frmvalidator.addValidation("street","req","Please enter your Street Number");
     
   frmvalidator.addValidation("phoneNo","req");
  
  frmvalidator.addValidation("phoneNo","maxlen=50");
  frmvalidator.addValidation("phoneNo","numeric");
 frmvalidator.addValidation("phoneNo","Phone");
   
   frmvalidator.addValidation("city","req","Please enter your city Name");
   frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("country","req","Please enter your Country Name");
   frmvalidator.addValidation("pin","req","Please enter your pin Number");
   
   frmvalidator.addValidation("fax","req","Please enter Fax Number");
  
   frmvalidator.addValidation("fax","age");
    
 </script>
<br><br></TD></TR>
  <TR>
    <TD vAlign=top>
     
    </TD></TR></TBODY></TABLE>
<br>
  </BODY></HTML>

