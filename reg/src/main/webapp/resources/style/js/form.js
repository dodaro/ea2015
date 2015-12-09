
function isValidEmailAddress(emailAddress) {
	var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
	return pattern.test(emailAddress);
	}





	
	$(document).ready(function(){ 
	
		var check=0,check1=0,check3=0,check4=0,check5=0,check6=0,check7=0;


	
	   $("#mobile").keypress(function (e)
		{
  			//if the letter is not digit then display error and don't type anything
  		if( e.which!=8 && e.which!=0 && (e.which<48 || e.which>57))
  		{
    		//display error message
			$("#mobilecheck").css("background","url(../resources/images/form/close.png) no-repeat");
    		$("#mobilecheck").html("Digits Only").show().fadeOut("slow");
    		return false;
  		}
		});
		
		
		
		 $("#fname").keypress(function (e)
		{
			
			if(e.which>64 && e.which<91)
  			{
					$("#fnamecheck").css("background","url(../resources/images/form/close.png) no-repeat");
    				$("#fnamecheck").html("Uppercase is NOT allowed").show().fadeOut("slow");
    				return false;
			}
			else if(e.which>=48 && e.which<=57)
			{
					$("#fnamecheck").css("background","url(../resources/images/form/close.png) no-repeat");
    				$("#fnamecheck").html("Numbers are NOT allowed").show().fadeOut("slow");
    				return false;
			}
			else
			{
				return true;
			}
		});
		
		
        $("#lname").keypress(function (e)
        {
            
            if(e.which>64 && e.which<91)
              {
                    $("#lnamecheck").css("background","url(../resources/images/form/close.png) no-repeat");
                    $("#lnamecheck").html("Uppercase is NOT allowed").show().fadeOut("slow");
                    return false;
            }
            else if(e.which>=48 && e.which<=57)
            {
                    $("#lnamecheck").css("background","url(../resources/images/form/close.png) no-repeat");
                    $("#lnamecheck").html("Numbers are NOT allowed").show().fadeOut("slow");
                    return false;
            }
            else
            {
                return true;
            }
        });
        
        
		
		 $("#email").keypress(function (e)
		{
			var email = $("#email").val();
	 
			if(email != 0)
			{
				if(isValidEmailAddress(email))
				{
					$("#emailcheck").css("background","url(../resources/images/form/check.png) no-repeat");	
					$("#emailcheck").html("").fadeIn("slow");
					
				}
				else
				{
					$("#emailcheck").css("background","url(../resources/images/form/close.png) no-repeat");	
					$("#emailcheck").html("Please Enter Valid E-mail Address").fadeIn("slow");
					
				}
			}
			
		});
		
		$("#name").blur(function ()
		{
			if($("#name").val() == "")
			 {
			 		$("#namecheck").css("background","url(../resources/images/form/close.png) no-repeat");	
					$("#namecheck").html("Please Enter Name.").fadeIn("slow");
					check = 0;
			 }	
			 else
			 {
			 		$("#namecheck").css("background","url(../resources/images/form/check.png) no-repeat");	
					$("#namecheck").html("").fadeIn("slow");
					check = 1;
			 }
			
		});
        
        
        $("#fname").blur(function ()
        {
            if($("#fname").val() == "")
             {
                     $("#fnamecheck").css("background","url(../resources/images/form/close.png) no-repeat");    
                    $("#fnamecheck").html("Please First Enter Name.").fadeIn("slow");
                    check5 = 0;
             }    
             else
             {
                     $("#fnamecheck").css("background","url(../resources/images/form/check.png) no-repeat");    
                    $("#fnamecheck").html("").fadeIn("slow");
                    check5 = 1;
             }
            
        });
        
        
        $("#lname").blur(function ()
        {
            if($("#lname").val() == "")
             {
                     $("#lnamecheck").css("background","url(../resources/images/form/close.png) no-repeat");    
                    $("#lnamecheck").html("Please Enter Last Name.").fadeIn("slow");
                    check6 = 0;
             }    
             else
             {
                     $("#lnamecheck").css("background","url(../resources/images/form/check.png) no-repeat");    
                    $("#lnamecheck").html("").fadeIn("slow");
                    check6 = 1;
             }
            
        });
		
		$("#mobile").blur(function()
		{
			if( $("#mobile").val() == "")
				{
					$("#mobilecheck").css("background","url(../resources/images/form/close.png) no-repeat");	
					$("#mobilecheck").html("Please Enter Mobile No.").fadeIn("slow");
					check1 = 0;
					
				}
				else if($("#mobile").val().length != 10)
				{
					$("#mobilecheck").css("background","url(../resources/images/form/close.png) no-repeat");	
					$("#mobilecheck").html("Please Enter VALID Mobile No.").fadeIn("slow");
					check1 = 0;
				}
				else
				{
					$("#mobilecheck").css("background","url(../resources/images/form/check.png) no-repeat");	
					$("#mobilecheck").html("").fadeIn("slow");
					check1 = 1;
				}
		});
		
		$
		
		
		$("#email").blur(function ()
		{
			if($("#email").val() == "")
			 {
			 		$("#emailcheck").css("background","url(../resources/images/form/close.png) no-repeat");	
					$("#emailcheck").html("Please Enter E-Mail Address").fadeIn("slow");
					check3 = 0;
			 }	
			 else
			 {
			 		$("#emailcheck").css("background","url(../resources/images/form/check.png) no-repeat");	
					$("#emailcheck").html("").fadeIn("slow");
					check3 = 1;
			 }
			
		});
		
		
		
		$("#address").blur(function ()
		{
			if($("#address").val() == "")
			 {
			 		$("#addresscheck").css("background","url(../resources/images/form/close.png) no-repeat");	
					$("#addresscheck").html("Please Enter Address").fadeIn("slow");
					check4 = 0;
			 }	
			 else
			 {
			 		$("#addresscheck").css("background","url(../resources/images/form/check.png) no-repeat");	
					$("#addresscheck").html("").fadeIn("slow");
					check4 = 1;
			 }
			
		});
		
         $("#pass").blur(function ()
        {
            if($("#pass").val() == "")
             {
                     $("#passcheck").css("background","url(../resources/images/form/close.png) no-repeat");    
                    $("#passcheck").html("Please Enter Password").fadeIn("slow");
                    check7 = 0;
             }    
             else
             {
                     $("#passcheck").css("background","url(../resources/images/form/check.png) no-repeat");    
                    $("#passcheck").html("").fadeIn("slow");
                    check7 = 1;
             }
            
        });
  
        
		  $("#cpass").blur(function ()
        {
            if($("#cpass").val() == "" || ($("#cpass").val() != $("#pass").val() ))
             {
                     $("#cpasscheck").css("background","url(../resources/images/form/close.png) no-repeat");    
                    $("#cpasscheck").html("Password Does not Match").fadeIn("slow");
                    document.getElementById("pass").value = "";
                    
                    check7 = 0;
             }    
             else
             {
                     $("#cpasscheck").css("background","url(../resources/images/form/check.png) no-repeat");    
                    $("#cpasscheck").html("").fadeIn("slow");
                    check7 = 1;
             }
            
        });
     
        
        
		$("#sub").click(function ()
		{
           
       
			if(check == 1 && check1 == 1 && check3 == 1 && check4==1 && check5==1 && check6 ==1 & check7 == 1)
            {
              
              var qstr = "name=" + $("#name").val() + "&mobile=" + $("#mobile").val()  + "&email=" + $("#email").val() + "&address=" + $("#address").val() + "&fname=" + $("#fname").val() + "&lname=" + $("#lname").val() + "&gend=" + $("#gend").val() + "&pass=" + $("#pass").val() + "&exam=" + $("#exam").val() + "&sscbrdtype=" + $("#sscbrdtype").val() + "&sscschool=" + $("#sscschool").val() + "&sscper=" + $("#sscper").val() + "&sscyear=" + $("#sscyear").val() + "&sscbrdtype=" + $("#hscbrdtype").val() + "&hscschool=" + $("#hscschool").val() + "&hscper=" + $("#hscper").val() + "&hscyear=" + $("#hscyear").val() + "&gradschool=" + $("#gradschool").val() + "&gradper=" + $("#gradper").val() + "&graddegree=" + $("#graddegree").val() + "&gradyear=" + $("#gradyear").val() + "&pgschool=" + $("#pgschool").val() + "&pgper=" + $("#pgper").val() + "&pgdegree=" + $("#pgdegree").val() + "&pgyear=" + $("#pgyear").val() + "&experience=" + $("#experience").val() + "&industry=" + $("#industry").val() + "&company=" + $("#company").val();
				//alert(qstr);
                $.ajax({ 
                    type: "POST", 
                    url: "registration.php", 
                    data: qstr, 
                    success: function(msg1){ 
						if(msg1=='1')
						{
							alert("Registration Successful");
							document.location="index.html";
						}
						else
						{
                       $("#status").css("display","block");
                       $("#status").html(msg1);
						}
            
                    } 
              });
            }
            else
                alert("Enter Valid Credentials");
		});
		
     
});
