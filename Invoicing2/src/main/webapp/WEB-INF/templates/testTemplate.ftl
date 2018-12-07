<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Invoicepdf</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
           font-family: 'Arial','sans-serif';
            color: #000000;
            font-size: 10.0pt;
            
        }
      
th, td {
    padding: 5px;
    text-align: left;
}
    </style>
</head>
<body style="margin: 0; padding: 0;">
    <table  border="0" cellpadding="0" cellspacing="0" width="800" style="border-collapse: collapse;">
      
        <tr>
            <td  >
            <img src=${imagePath} height="60px" width="150px" />
           
            </td>
            <TD>
            <div  align="left" style="max-width:20px;">
            Cross and Pillory House<br>
            Cross and Pillory Lane<br>
				Alton<br>
				Hampshire<br>
				GU34 1HL<br>
          </div>  
            
            </TD>
            
          
        </tr>
        
        </table>
       <br>
         Invoice <br><br>
      
         


<div style="width:800; height: 100; ">
  <div style="width:200; height:100; float:left; margin: 10px; border:1px solid #000000;">   ${invoiceSummaryBean.billingAddress.addressName}<br>
            ${invoiceSummaryBean.billingAddress.buildingName}<br>
            ${invoiceSummaryBean.billingAddress.streetName}<br>
            ${invoiceSummaryBean.billingAddress.town}<br>
            ${invoiceSummaryBean.billingAddress.county}<br>
            ${invoiceSummaryBean.billingAddress.postCode}<br>
            ${invoiceSummaryBean.billingAddress.country}<br></div>

  <div style="width: 100; float:left; margin: 5px; "></div>
  <div style="width: 300; height:100  float:left; ">
   <table style=" border: 1px solid black; border-collapse: collapse;">
  <tr>
    <th style=" border: 1px solid black; border-collapse: collapse;">Invoice No.</th>
    <td style=" border: 1px solid black; border-collapse: collapse;">${invoiceNumber}</td>
  </tr>
  <tr>
    <th style=" border: 1px solid black; border-collapse: collapse;">Invoice/Tax Date</th>
    <td style=" border: 1px solid black; border-collapse: collapse;">01/08/2018</td>
  </tr>
  <tr>
    <th style=" border: 1px solid black; border-collapse: collapse;">Purchase Order No.</th>
    <td style=" border: 1px solid black; border-collapse: collapse;">555 77 855</td>
  </tr>
  <tr>
    <th style=" border: 1px solid black; border-collapse: collapse;">Account No.</th>
    <td style=" border: 1px solid black; border-collapse: collapse;">555 77 855</td>
  </tr>
</table>
  </div>
</div>

</body>
</html>


