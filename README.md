# Trip Advisor assignment


* Assumptions: 
1. There is a very strong assumption made here that hotel name entered by user is a unique key (as far as location is concerned )and so are the names mentioned in csv.
        Example: There could be Hotel Marriot (on actual site there will be a location attached to this which gives it a unique identifier) but here it is assumed Hotel Marriot entered by user
        is the same as one mentioned in csv.
 2. Another strong assumption made is that hits per second/minute on this service is not much. And this service is not often used.      
3. In assignment given values of deal are in negative(i have considered it same as examples in assignment and have added so it gets subtracted in helper functions)
4. Some helper methods are purposely made public so it could be tested. In real life scenarios it will be private.
5. There can be a lot more tests added for each and every module of the program.
6. There are basic validations involved when fetching data from csv, they can be made much more stronger depending upon requirements.
7. We can hav different methds of input (UI/Service).
8. File Parser used is a very basic one, depending upon types of input files(excel/csv) we can modify it.


<h1>Scenarios</h1>

    1.If a hotel is entered whose deals do not match they return no deals available.
    2.Depending upon highest discount a user is getting based on duration * nightlyPrice and comparing with dealType and dealValue user gets bestdeal.
    3.If user gives any of the required fields empty he gets a exception which can be gracefully handled on front end or from service point of view.
    
<h2>Scope Of Improvement</h2>

1. We can instead of having list of n hotels (n being name of that hotel with multiple deals) we can even compute deal on the fly by storing best deal in hashmap and accessing deal in a much quicker way.
which would increase my performance to O(1) from O(k) [k being matched number of hotels]
 2. If we do that we can get rid of processDeal() method.
  3. We can use this map mechanism when amount of hits/payload is a lot. Service is hit multiple times in a second then probably hashmap is the best solution since it will privide much much faster access to this deal, also as it gets computed on the fly there is not much space required hence reduces space complexity. 
