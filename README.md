# ISS App Data

## Created with
* Java 17
* JDBC and Hibernate
* MySQL Database



## About
It is a simple app to gather and process ISS traffic data.
Data is transformed form JSON file obtained through network service:  
```
http://open-notify.org/Open-Notify-API/
```
**Main functionalities:**
* showing the current position of the ISS,
* calculation of the speed of the ISS,
* returning the number of people in space within the ISS.

All results are presented in command line after running [Main.java](https://github.com/moRR3no/IssAppData/blob/master/src/main/java/org/example/Main.java) class.
