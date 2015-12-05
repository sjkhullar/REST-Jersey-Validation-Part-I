REST parameters validation using Jersey framework.

1.) Requests for http://localhost:9090/student/reg

	For request
		http://localhost:9090/student/reg?firstName=don&lastName=brad&age=16
	Response:
		Message from Server :
		firstName: don, lastName: brad, age: 16

	 for request - We have provided the invalid firstName, so we will get exception message from server
		http://localhost:9090/student/reg?firstName=&lastName=brad&age=16
	 Response   : 
		registerStudent.arg0 firstName Length should be between 2 and 25 character
		
	 for request - We have provided the invalid age, so we will get exception message from server
		http://localhost:9090/student/reg?firstName=don&lastName=brad&age=10
	 Response
		registerStudent.arg2 age should not be less that 15

2.) http://localhost:9090/student/register   [The Content-Type should be set to "application/json" for request raised to server]


	Valid input
	{"firstName":"Don","lastName":"bradman","email":"don.bradman@ymail.com","age":"18"}

	The json used to send to call the api. As we do not have firstName.
	{"firstName":"","lastName":"last","email":"lovetoyogesh@ymail.com","age":"15"}

	Exception
	registerStudent.arg0.firstName The length of firstName should be between 1 to 25


	Invalid Email Address
	{"firstName":"Don","lastName":"bradman","email":"don bradman@ymail.com","age":"18"}
	Exception :
	registerStudent.arg0.email Invalid Email Address->Valid emails:user@gmail.com or my.user@domain.com etc.


	Invalid Minimum Age of student
	{"firstName":"Don","lastName":"bradman","email":"don.bradman@ymail.com","age":"14"}
	Exception:
	registerStudent.arg0.age Student shall be minimum of age 15 yr

	Invalid Maximum Age of student
	{"firstName":"Don","lastName":"bradman","email":"don.bradman@ymail.com","age":"40"}

	Exception:
	registerStudent.arg0.age Student can not have age more than 30 yr
