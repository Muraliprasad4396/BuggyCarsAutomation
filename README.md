# Buggy Cars Automation

This is a java selenium and TestNG automation project to automate the features of Buggy Cars Rating website.


### Install
* jdk 8
* maven
##### After checkout:

Ensure that the Chromedriver version you download corresponds to the version of your Google Chrome browser. In most cases, it is recommended to obtain the latest Chromedriver version (currently version 111). Subsequently, substitute the current Chromedriver in your project with the newly acquired version.
Run the project using the command line with:

```
mvn clean test
```


### Technologies
* Selenium:		3.141.59
* TestNG: 		6.14.2
* Log4j: 		1.2.17

### Pre-requisite
The username parameter for testing needs to be changed for register and voting case in StepDefinitions.java.

##### NOTE
Logs will be generated in the folder logs/log4j.log
