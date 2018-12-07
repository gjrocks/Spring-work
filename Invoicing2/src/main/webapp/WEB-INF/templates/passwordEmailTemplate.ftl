<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
           font-family: 'Arial','sans-serif';
            color: #717073;
            font-size: 10.0pt;
            
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">
    <table  border="0" cellpadding="0" cellspacing="0" width="800" style="border-collapse: collapse;">
      
        <tr>
            <td  >
          
                <p>Dear ${name},</p>
            <p style="text-align:justify"> This email details your password for ebulk Invoicing application.
                Please keep your password safe and do not disclose it to anyone else or write it down. 
              If you think that the security of your password may have been compromised please contact CRVS immediately to request a password reset.
				After your initial login you will be able to change your password to something more memorable.</p>
            <p>Your password for  login is:<b> ${password}</b></p>
                <p>Kind Regards,<br>
               ${fromName}</p>
            </td>
        </tr>
       
    </table>

</body>
</html>


