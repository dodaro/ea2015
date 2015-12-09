<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>

 <link rel="stylesheet" href="/resources/lib/jquery-ui-1.11.4/jquery-ui.theme.min.css">
<link rel="stylesheet" type="text/css" href="/resources/style/styleNew.css">
<link rel="stylesheet" type="text/css" href="/resources/style/form.css">
<script src="/resources/style/js/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/lib/jquery-ui-1.11.4/jquery-ui.css">
<script src="/resources/lib/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="/resources/lib/jquery-ui-1.11.4/jquery-ui.js"></script>
<script src="/resources/style/js/form.js"></script>
<script src="/resources/images"></script>

<script>


function toggleupload(cont)
{
      if(cont.checked)
      {
          document.getElementById("upload").style.display = "block";
      }
      else
            document.getElementById("upload").style.display = "none";
}

function togglecrecard(cont)
{
      if(cont.checked)
      {
          document.getElementById("crecard").style.display = "block";
      }
      else
            document.getElementById("crecard").style.display = "none";
}

function init() {
	  
    var _inputs = document.getElementsByTagName('input');

    for (var i = 0; i < _inputs.length; i++) {

        if(!Modernizr.inputtypes[_inputs[i].type]) {
            _inputs[i].className = 'not-supported';
        }

        _inputs[i].parentNode.getElementsByClassName('result')[0].innerHTML = _inputs[i].value;

        _inputs[i].onchange = function () {
            //console.log(this.value);
            var result_node = this.parentNode.getElementsByClassName('result');
            result_node[0].innerHTML = this.value;
        }
    }
}

</script>

</head>
<body>
   <header>
		<div class="banner">
			<img src="/resources/images/logo_unical.png" alt="Logo" />
			<div>Personal Information Manager</div>
		</div>
		
	</header>
	<div class="wrapper">
		<div class="front-page">
			<div class="front-welcome-text">
						<h2><i>Registration Application</i></h2>
				<div class="front-information-text"></div>
			</div>    
<fieldset id="personal">
	 <legend> Personal Information 
	 
			</legend>
	   <table>
		  <tr>
		  	<th><label for="fname">First Name:</label></th> 
		  	<th><label for="lname">Last Name:</label></th> 
		  	<th></th> 
		  </tr>
		  <tr>
		  	<td><input type="text" name="fname" id="fname" /></td>
		  	<td><input type="text" name="lname" id="lname" /></td>
		  	
		  </tr>
		  <tr>
		  	<td><span id="fnamecheck" class="check">Please Enter First Name</span></td>
		  	<td><span id="lnamecheck" class="check">Please Enter Last Name </span></td>
		  </tr> 
		 </table>
		 
		
	<ol>
		<li><label>Birth Date:</label> <input id="input-date" type="date" value="2014-10-31"></li>
		<li><label for="gend">Gender:</label>&nbsp;&nbsp;&nbsp;&nbsp;Male:<input type="radio" name="gend" id="gend" value="m" checked="checked"/>&nbsp;&nbsp;&nbsp;&nbsp;Female:<input type="radio" name="gend" id="gend" value="f" /> </li>
		<li><label for="address">Address 1:</label>
		<textarea name="address" id="address" cols="30" rows="2" ></textarea><span id="addresscheck"  class="check">Please Enter Address</span></li>
		<li><label for="address">Address 2:</label>
		<textarea name="address" id="address" cols="30" rows="2" ></textarea>* &nbsp;&nbsp;<i><b> (Optional) </b></i></li>
		<li><label for="mobile">Mobile:</label>
		<input type="text" name="mobile" id="mobile" /><span id="mobilecheck"  class="check"></span></li>                                                               
		<li><label for="email">E-Mail:</label>
		<input type="text" name="email" id="email" /><span id="emailcheck"  class="check">Please Enter E-mail</span></li>                                                                                                                                                                                         
	</ol>                                                          
</fieldset>
<div id="infoselect"> 
Upload Documents:<input type="checkbox" onclick="toggleupload(this)" />       &nbsp;&nbsp;&nbsp;&nbsp;
Credit Cards:    <input type="checkbox" onclick="togglecrecard(this)" />      &nbsp;&nbsp;&nbsp;&nbsp;
</div>

<div id="cont">   
<fieldset id="upload"  style="display:none">
<legend> Upload Documents </legend>
 
 
                                                               
</fieldset>
<fieldset id="crecard"  style="display:none">
<legend> Credit Cards </legend>
 

                                                               
</fieldset>

</div>

   </div>
   
		 <input type="button" value="Register" id="sub" />  
   <div id="status"></div>
</div>	
<div id="footer"><b>Enterprise Applications - Department of Mathematics and Computer Science - University of Calabria - Arcavacata di Rende (CS) - Italy</b></div>
</body>
</html>
