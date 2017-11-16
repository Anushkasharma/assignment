# Trip Advisor assignment


* Assumptions: 
1. There is a very strong assumption made here that hotel name entered by user is a unique key (as far as location is concerned )and so are the names mentioned in csv.
        Example: There could be Hotel Marriot (on actual site there will be a location attached to this which gives it a unique identifier) but here it is assumed Hotel Marriot entered by user
        is the same as one mentioned in csv.
        
2. In assignment given values of deal are in negative(i have considered it same as examples in assignment and have added so it gets subtracted in helper functions)
3. Some helper methods are purposely made public so it could be tested. In real life scenarios it will be private.
4. There can be a lot more tests added for each and every module of the program.
5. There are basic validations involved when fetching data from csv, they can be made much more stronger depending upon requirements.
6. We can hav different methds of input (UI/Service).
7. File Parser used is a very basic one, depending upon types of input files(excel/csv) we can modify it.


<h1>Scenarios</h1>

    1.If a hotel is entered whose deals do not match they return no deals available.
    2.Depending upon highest discount a user is getting based on duration * nightlyPrice and comparing with dealType and dealValue user gets bestdeal.
    3.If user gives any of the required fields empty he gets a exception which can be gracefully handled on front end or from service point of view.
    

        
