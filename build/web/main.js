var employees = [], employeeNames = [];
var request = new XMLHttpRequest();
request.open("GET", "GetEmployeesServlet", true);
request.send();
request.onreadystatechange = function()
{
  if(this.readyState === 4 && this.status === 200)
  {
    employees = JSON.parse(this.responseText);
    
    for(var i = 0; i < employees.length; ++i)
    {
        employeeNames[i] = employees[i].empName;
    }
    
    setFirstElement();

    displayHierarchy(employees[0].reportingManager, 
    document.getElementById('list'));
  }
};

function setFirstElement()
{
    for(var i = 0; i < employees.length; ++i)
    {
        if(employees[i].empDesignation === 'CEO')
        {
            var temp = employees[i];
            employees[i] = employees[0];
            employees[0] = temp;
        }
    }
}

function displayHierarchy(manager, parentElement)
{
    for(var i = 0; i < employees.length; ++i)
    {
        var employee = employees[i];
        
        if(addedToList(employee.empName) === 1)
        {
            if(employee.reportingManager === manager)
            {
                var listItem = document.createElement('li');
                var listContent = document.createTextNode(employee.empName + 
                        ", " + employee.empDesignation);
                listItem.appendChild(listContent);
                parentElement.appendChild(listItem);

                if(hasSubordinate(employee) === 1)
                {
                    var nestedList = document.createElement('ul');
                    listItem.appendChild(nestedList);
                    displayHierarchy(employee.empName, nestedList);
                }
            }
        }
    }
}

function hasSubordinate(employee)
{
    for(var i = 0; i < employees.length; i++)
    {
        if(employees[i].reportingManager === employee.empName)
        {
            return 1;
        }
    }
    return 0;
}

function addedToList(empName)
{
    for(var i = 0; i < employeeNames.length; ++i)
    {
        if(empName === employeeNames[i])
            return 1;
    }
    return 0;
}