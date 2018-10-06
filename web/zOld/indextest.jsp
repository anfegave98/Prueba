<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
         pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
        <title>Insert title here</title> 
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script> 
        <script type="text/javascript">
            $(document).ready(function () {
                $("#click").click(function () {
                    name = $("input#name").val();
                    age = $("input#age").val();
                    $.ajax({
                        type: "POST",
                        url: "jsp/pageTwo.jsp",
                        data: "name=" + name + "&age=" + age,
                        success: function (data) {
                            $("#response").html(data);
                        }
                    });
                });
            });
        </script> 
    </head> 
    <body> 
        Name: <input type="text" id="name" name="name"><br/><br/> 
        Age  : <input type="text" id="age" name="age"><br/><br/> 
        <button id="click">Click Me</button> 
        <div id="response"></div> 
    </body> 
</html>