<!DOCTYPE html>  
<html lang="en"><head>  
        <meta charset="utf-8">  
        <title>Add User Form</title>  
        <link rel='stylesheet' href='Styles.css' type='text/css' />  
        <script src="sample-registration-form-validation.js"> </script>  
    </head>  
    <body onload="document.registration.firstname.focus();"> 
        <div id="body">
         
                 
    <center> <h1>Add User Form</h1> </center>  
    <br/><br/>
        <div style="width:90%;
	height:50%;
 background-image: url(logo2.png);
 background-size: 100%;
 opacity:0.8;
 margin-left: 0px">
        <div id="body">
            <div class="content">

                <form name='registration' onSubmit="return formValidation();" method="post" action="./AddAction">  

                    <label for="firstname"> <span>First Name : </span>
                        <input type="text" name="firstname" size="50" required/>
                    </label>

                    <label for="lastname"> <span> Last Name : </span>
                         <input type="text" name="lastname" size="50" required/>
                    </label>

                    <label for="email"><span> Email : </span>
                        <input type="text" name="email" size="50" required/>
                    </label>

                    <label for="phone"><span> Phone No. : </span>
                        <input type="number" name="phone" size="12" required />  
                    </label>

                    <label for="age"><span> Age : </span>
                        <input type="number" name="age" size="4" required/>  
                    </label>

                    <label for="city"><span> City : </span>
                        <input type="text" name="city" required/>  
                    </label>

                    <label for="passid"><span> Password : </span>
                        <input type="password" name="passid" size="16" required/>  
                    </label>

                    <label id="gender">  <span> Gender : </span> </label>
                    <div style="margin-left:140px;margin-top: -32px; ">
                        <input type="radio" name="sex" value="M" checked="true"/>Male
                        <input type="radio" name="sex" value="F" />Female
                    </div>

                    <label for="utype"><span> User Type : </span>
                      
                        <select name="utype">   
                              
                            <option selected="" value="2">Admin</option>  
                            <option value="1">Patient</option>  
                            <!--<option value="3">Doctor</option> -->
                          
                </select> 
                    </label>
                     
                    
                    <input type="submit" name="submit" value="ADD" class="sign"/>

                </form> 
                
                <br/> <br/>
                  <a href="Admin.jsp" class="link"> BACK </a>
            </div> </div>
        </div>
   
                </body>  
                </html>  
