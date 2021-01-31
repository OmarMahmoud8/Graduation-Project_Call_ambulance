<!DOCTYPE html>  
<html lang="en"><head>  
        <meta charset="utf-8">  
        <title>Add Comment Form</title>  
        <link rel='stylesheet' href='Styles.css' type='text/css' />  
        <script src="sample-registration-form-validation.js"> </script>  
    </head>  
    <body onload="document.registration.firstname.focus();">  
    <center> <h1>Add Comment Form</h1> </center>  

        <div id="body">
            <div class="content">

                <form name='registration' onSubmit="return formValidation();" method="post" action="./AddComments">  

                    <label for="name"> <span>Name : </span>
                        <input type="text" name="name" size="50" required/>
                    </label>

                    <label for="email"><span> Email : </span>
                        <input type="text" name="email" size="50" required/>
                    </label>

                   
                    <label for="content"><span> Content : </span>
                        <input type="text" name="content" required/>  
                    </label>
                   
                    <input type="submit" name="submit" value="ADD" class="sign"/>

                </form> 
                <br/> <br/>
                  <a href="Patient.jsp" class="link"> BACK </a>
            </div> </div>
   
                </body>  
                </html>  
