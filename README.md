# Cyber-Security-works-spring-boot-schedule-api
Task:
Spring Boot Rest API to be built to serve below needs
Note: For Backend, you can use any choice of database.(I had  used H2 in memory data base which has only one instance)
1) Create Schedule api which will accept employee id(emailAddress) and training period (it should support single Date, time and schedule Duration and multiple as well)

Example 1:

{

"employeeId": "1",

"schedule": {

"startDate": "01 Apr 2021",

"endDate": "01 Apr 2021",

"time": "10:00",

"duration": "60", //minutes

"repeat": false,

"frequency": null

}

}

Example 2:

{

"employeeId": "1",

"schedule": {

"startDate": "01 Apr 2021",

"endDate": "10 Apr 2021",

"time": "10:00",

"duration": "60", //minutes

"repeat": true,

"frequency": "Weekdays" // ENUM should accept , Weekdays, Daily, Weekly, Monthly

}

} 

2) List Schedule(s) by Employeeid

3) Modify schedule(s) by Employeeid - Update one or more schedules at the same time

4) Cancel Schedule(s) by Employeeid - Cancel one or more schedules at the same time. Also handle cancelling a schedule on a given date 

For example: if i have 2 schedule between 1st April 2021 and 1st May 2021 at 10 AM and another schedule from  1st April 2021 and 1st May 2021 at 5PM - I can 

cancel the complete schedule from  1st April 2021 and 1st May 2021 at 10 AM
cancel both the schedules for the full duration
cancel any one schedule on a given date alone (if the employee busy on another work)
cancel all schedules on a given date  (if the employee is sick or if its a public holiday)

5) Get schedules by date - Should provide the list of schedules for a given date. Say if I have one appointment repeating daily for 30 mins, the current date alone should be listed.

For example, In the above example 2 scenario, if I ask for schedule for today apr 2, it should list me date 2-apr-2021, time 10:00 am, duration: 60 mins

If I want to get the schedules for 1st April 2021 - I should get 2 records - one for employee 1 and the other for employee 2. 

 
