# \## DemoBlaze Automation Testing Project



This project contains a Page Object Model (POM) based Selenium Test Automation Framework designed to test the functionalities of the DemoBlaze shopping website:

🔗 https://www.demoblaze.com/



The framework uses Java + Selenium + TestNG + Maven + ExtentReports and follows a clean, modular, industry-standard structure.



### 🏗 Project Overview



The goal of this project is to automate the functional and UI testing of major modules in the DemoBlaze application, including:



🔹 Login Functionality

🔹 Sign-Up Functionality

🔹 Product Selection

🔹 Add to Cart

🔹 View Cart

🔹 Delete Product From Cart

🔹 Multiple Product Handling

🔹 Navigation \& UI Validations



All tests are executed through a centralized TestNG suite (testng.xml) and integrated with ExtentReports for advanced reporting.



### 📁 Project Structure



src/test/java

│

├── baseClass

│   └── BaseClass.java

│

├── pages

│   ├── AddProductPage.java

│   ├── CartFunctionPage.java

│   ├── HomePage.java

│   ├── LoginPage.java

│   ├── OrderPage.java

│

├── reports

│   └── ExtentReportManager.java

│

├── tests

│   ├── AddProductTest.java

│   ├── HomePageNavigationTest.java

│   ├── LoginPageTest.java

│   ├── LogoutTest.java

│   ├── OrderPageTest.java

│   └── UIUxTest.java

│

└── utils

     └── ExcelUtils.java



src/test/resources

    └── test data

       └── userdata.xlsx





#### Other important directories:



**Directory					Description**

reports/					HTML Test Reports (ExtentReports)
screenshots/				Screenshots captured on test failure
test-output/				TestNG default reports
pom.xml						Maven dependencies
testng.xml					Test suite configuration



#### 🧩 Tools \& Technologies Used



**Component								Description**

Java									Core programming language

Selenium WebDriver						Browser automation

TestNG									Test runner, annotations, assertions

Page Object Model (POM)					Framework design pattern

Maven									Build + dependency management

ExtentReports							Reporting

Apache POI								Excel data handling

TestNG Listeners (ITestListener)		Screenshot on failure





#### ⚙️ How to Run the Tests


Clone or download the project

Import into Eclipse/IntelliJ as a Maven Project

Run: Maven → Update Project

Right-click testng.xml → Run As → TestNG Suite

Or run via Maven:

mvn clean test



#### 🔧 Test Data (userdata.xlsx)



The test data Excel contains:



Name

Country

City

Credit card number

Month

Year



These values support data-driven testing for order placement scenarios.





### 📝 Test Coverage

🔹 Functional Tests



* Login Module
* Valid login
* Invalid password
* Invalid email format
* Empty field validation
* Password masking verification
* Sign-Up
* Existing username validation
* Empty field validation
* Cart Module
* Add product to cart
* Remove product
* View cart
* Add multiple products
* Price total verification
* Order Placement
* Purchase form validation using Excel test data



🔹 UI \& Navigation Tests



* Home page cards visibility
* Navigation bar link validation
* Clickability of menu categories
* Alerts and confirmation dialogues
* Product details verification
* Image visibility and content structure



### 📊 Reports \& Screenshots



After execution:



##### 📁 Extent Report

* Generated at:/reports/testrunreport.html



##### 📁 Screenshots

* Stored at:/screenshots/
* Screenshots are captured automatically upon failures via TestNG Listeners.



### 🎯 Jenkins Integration

This project is integrated with Jenkins CI for automated test execution using Maven and TestNG.
Jenkins pulls the project, runs clean test via Maven, and publishes both TestNG reports and Extent HTML Reports after every build.
The CI setup ensures continuous testing, build history tracking, and easy access to logs and screenshots.



### 🎯 Key Framework Features



✔ Page Object Model (POM)

✔ Centralised driver setup (BaseClass)

✔ Reusable utility methods

✔ TestNG annotations (priority, groups, parameters)

✔ Integrated ExtentReports

✔ Automatic screenshot capture

✔ Support for Excel-based Test Data (Apache POI)

✔ Modular and maintainable framework structure

✔ Jenkins Integration and TestNg result Generation



#### 👩‍💻 Author



Alagu Nandhana S

Automation Tester | Java | Selenium | TestNG



