# SII-Case-Study
It's a simple application consisting of two endpoints.
- one for storing a request in the database
![image](https://github.com/Lysioneer/SII-Case-Study/assets/88937724/d1b5e5b1-beea-478d-91f0-3861cccc18a3)

- and another for retrieving the saved record based on id
![image](https://github.com/Lysioneer/SII-Case-Study/assets/88937724/427b9789-a64d-47e9-95de-166d3473b392)

Application was written in Java 17 and connected to MySQL database.
![image](https://github.com/Lysioneer/SII-Case-Study/assets/88937724/834f0160-f9e5-4c3f-a40f-9955f068197e)
![image](https://github.com/Lysioneer/SII-Case-Study/assets/88937724/0908b058-a5d2-42fe-acf9-b5c1bd56323a)

In a case where user would try to retrieve a record by non-existing id, they'd receive following response:
![image](https://github.com/Lysioneer/SII-Case-Study/assets/88937724/e1e1e8a5-7639-40ca-8ba1-6638145b4cc1)

Testing the application was possible via Postman, integration & unit tests.

Application was written with the assignment in mind. Where there was not enough details I've implemented my own solutions.
The application could be improved in many ways, but considering the time spent and the assignment in general. I've decided to make it rather simple.

Improvements that comes to mind could be for example: proper validation of input, filtering what records user would like to retrieve etc.
