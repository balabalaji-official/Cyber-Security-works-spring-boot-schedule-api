# Cyber-Security-works-spring-boot-schedule-api
Task:
Spring Boot Rest API to be built to serve below needs
Note: For Backend, you can use any choice of database.(I had  used H2 in memory data base which has only one instance)
1) Create Schedule api which will accept employee id(emailAddress) and training period (it should support single Date, time and schedule Duration and multiple as well)

Example 1:
Case 1: Post employee data to make a New Employee entry
URL:http://localhost:8080/employee/save Request method:POST
Request Body in Postman:Raw Json
{
    "employeeId":3040,
	"employeeEmail":"xyz@gmail.com",
    "schedule":
        {
            "schedId":1,
            "startDate": "01 Apr 2021",
            "endDate": "1 Apr 2021",
            "time": "10:00",
            "duration": "60",
            "repeat": true,
            "frequency": "Daily"
        }
}
}

Example 2:
{
    "employeeId":3041,
	    "employeeEmail":"abc@gmail.com",
    "schedule":
        {
            "schedId":2,
            "startDate": "01 Apr 2021",
            "endDate": "1 Apr 2021",
            "time": "10:00",
            "duration": "60",
            "repeat": true,
            "frequency": "Daily"
        }
}

Case 1:Post list of employee data to make a New Employee entry

URL:http://localhost:8080/employee/saveall Request method:POST
Request Body in Postman:Raw JSON
[{
    "employeeId":3040,
	"employeeEmail":"xyz@gmail.com",
    "schedule":
        {
            "schedId":1,
            "startDate": "01 Apr 2021",
            "endDate": "1 Apr 2021",
            "time": "10:00",
            "duration": "60",
            "repeat": true,
            "frequency": "Daily"
        }
},{
    "employeeId":3041,
	"employeeEmail":"xyz@gmail.com",
    "schedule":
        {
            "schedId":1,
            "startDate": "01 Apr 2021",
            "endDate": "1 Apr 2021",
            "time": "10:00",
            "duration": "60",
            "repeat": true,
            "frequency": "Daily"
        }
},{
    "employeeId":3041,
	   "employeeEmail":"abc@gmail.com",
    "schedule":
        {
            "schedId":2,
            "startDate": "01 Apr 2021"    ,
            "endDate": "1 Apr 2021",
            "time": "10:00",
            "duration": "60",
            "repeat": true,
            "frequency": "Daily"
        }
}
]

2) List Schedule(s) by Employeeid
Case 2:Get one employee's details and all his schedules employee id
URL:http://localhost:8080/employee/details/3041      Request method:GET
Note:pathvariable 3041 is employeeId

3) Modify schedule(s) by Employeeid - Update one or more schedules at the same time
 Case 3:Modify and update one schedule by employee id
 URL:http://localhost:8080/employee/update/3040
 Note:pathvariable 3040 is employeeId
 Request Body in Postman:Raw JSON
 {
            "schedId": 1,
            "startDate": "31 Mar 2021",
            "endDate": "31 Mar 2021",
            "time": "10:00",
            "duration": "60",
            "repeat": true,
            "frequency": "Daily"
        }
        
 Case 3:Modify and update list of schedules for employee id
 URL:http://localhost:8080/employee/updateall/3040    Request method:PUT
 Note:pathvariable 3040 is employeeId
 Request Body in Postman:Raw JSON
 [{
            "schedId": 1,
            "startDate": "31 Mar 2021",
            "endDate": "31 Mar 2021",
            "time": "10:00",
            "duration": "60",
            "repeat": true,
            "frequency": "Daily"
        },
        {
            "schedId": 2,
            "startDate": "31 Mar 2021",
            "endDate": "31 Mar 2021",
            "time": "10:00",
            "duration": "60",
            "repeat": true,
            "frequency": "Daily"
        }]
        
4) Cancel Schedule(s) by Employeeid - Cancel one or more schedules at the same time. Also handle cancelling a schedule on a given date 

Case 4:Delete Schedule by employee id and schedule id    
URL:http://localhost:8080/employee/delete/3040/1         Request method:DELETE
Note:pathvariable 3040 is employeeId and 1 is schedId

5) Get schedules by date - Should provide the list of schedules for a given date. Say if I have one appointment repeating daily for 30 mins, the current date alone should be listed.

For example, In the above example 2 scenario, if I ask for schedule for today apr 2, it should list me date 2-apr-2021, time 10:00 am, duration: 60 mins

If I want to get the schedules for 1st April 2021 - I should get 2 records - one for employee 1 and the other for employee 2. 

 Case 5: Get Employee and Schedule Details of a particular date
 URL:http://localhost:8080/employee/date      Request method : GET
 Request Body in PostMan:Raw Json
 
 {
    "dateOfDetails":"01 Apr 2021"
}
 
 
 
General:

Case 6:Get all details
URL:http://localhost:8080/employee/all      Request method : GET


Case 7:Delete all details
URL:http://localhost:8080/employee/deleteall    Request method:DELETE
