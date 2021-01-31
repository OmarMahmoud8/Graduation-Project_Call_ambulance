 function formValidation()
{
    var fname = document.registration.firstname;
    var lname = document.registration.lastname;
    var uemail = document.registration.email;
    var uphone = document.registration.phone;
    var uage = document.registration.age;
    var ucity = document.registration.city;
    var passid = document.registration.passid;
    var umsex = document.registration.msex;
    var ufsex = document.registration.fsex;
    var utype = document.registration.utype;


    if (allLetter(fname))
    {
        if (allLetter(lname))
        {
            if (ValidateEmail(uemail))
            {
                if (allnumerics(uphone, 4, 12))
                {
                    if (allnumeric(uage, 1, 4))
                    {
                        if (alphanumeric(ucity))
                        {
                            if (passid_validation(passid, 5, 16))
                            {
                                if (validsex(umsex, ufsex))
                                {
                                  
                                }
                               
                            }
                        }
                    }
                }
            }
        }
    }
    return false;
}


function allLetter(fname)
{
    var letters = /^[A-Za-z]+$/;
    if (fname.value.match(letters))
    {
        return true;
    } else
    {
        alert('Name must have alphabet characters only');
        fname.focus();
        return false;
    }
}

function allLetter(lname)
{
    var letters = /^[A-Za-z]+$/;
    if (lname.value.match(letters))
    {
        return true;
    } else
    {
        alert('Name must have alphabet characters only');
        lname.focus();
        return false;
    }
}

function ValidateEmail(uemail)
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (uemail.value.match(mailformat))
    {
        return true;
    } else
    {
        alert("You have entered an invalid email address!");
        uemail.focus();
        return false;
    }
}

function allnumerics(uphone, mx, my)
{
    var phone_len = uphone.value.length;
    var phonenumbers = /^[0-9]+$/;
    if (phone_len == 0 || phone_len >= my || phone_len < mx)
    {
        alert("Phone Number should not be empty / length be between " + mx + " to " + my);
        uphone.focus();
        return false;
    }
   else if (uphone.value.match(phonenumbers))
    {
        return true;
    } 
    else
    {
        alert('Phone No. must have numeric characters only');
        uphone.focus();
        return false;
    }
    return true;
}

function allnumeric(uage, mx, my)
{
    var age_len = uage.value.length;
    var agenumbers = /^[0-9]+$/;
    if (age_len == 0 || age_len >= my || age_len < mx)
    {
        alert("Age should not be empty / length be between " + mx + " to " + my);
        uage.focus();
        return false;
    }
    else if (uage.value.match(agenumbers))
    {
        return true;
    }
    else
    {
        alert('Age must have numeric characters only');
        uage.focus();
        return false;
    }
    return  true;
}

function alphanumeric(ucity)
{
    var letters = /^[A-Za-z]+$/;
    if (ucity.value.match(letters))
    {
        return true;
    } else
    {
        alert('City must have alphanumeric characters only');
        ucity.focus();
        return false;
    }
}

function passid_validation(passid, mx, my)
{
    var passid_len = passid.value.length;
    if (passid_len == 0 || passid_len >= my || passid_len < mx)
    {
        alert("Password should not be empty / length be between " + mx + " to " + my);
        passid.focus();
        return false;
    }
    return true;
}

function validsex(umsex, ufsex)
{
    x = 0;

    if (umsex.checked)
    {
        x++;
    }
    if (ufsex.checked)
    {
        x++;
    }
    if (x == 0)
    {
        alert('Select Male/Female');
        umsex.focus();
        return false;
    } else
    {
        alert('Form Successfully Submitted');
        window.location.reload()
        return true;
    }
}





