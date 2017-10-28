<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACME Employee hierarchy</title>
    </head>
    <body>
        <h1>ACME Employees</h1>
        <div id="list"></div>
    </body>
    <script>
        var employees = [];
        var request = new XMLHttpRequest();
        request.open("GET", "GetEmployeesServlet", true);
        request.send();
        request.onreadystatechange = function() {
          if(this.readyState == 4 && this.status == 200)
          {
              employees = JSON.parse(this.responseText);
              console.log(employees);
              var firstEmployee = findFirstElement(employees);
              displayHierarchy(firstEmployee);
          }
        };
        
        function findFirstElement(employees)
        {
            for(var i = 0; i < employees.length; ++i)
            {
                if(employees[i].empDesignation === 'CEO')
                {
                    return employees[i];
                }
            }
        }
        
        function displayHierarchy(firstEmployee)
        {
            document.getElementById("list").
            for(var i = 0; i < employees.length; ++i)
            {
                if(hasSubordinates(employees[i]))
                {
                    
                }
            }
        }
    </script>
</html>
