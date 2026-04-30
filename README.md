# Problem Statement 15: SweetCart – Selenium-Java Test Automation Framework for a Sweet Shop Web Application

##  Project Overview
SweetCart is a Selenium-based automation testing framework built using **Java + TestNG + Page Object Model (POM)**. 
This framework automates end-to-end user flows of a sweet shop web application.

The project focuses on building a **scalable, reusable, and maintainable automation framework** rather than standalone scripts.

---

## Tech Stack
* **Language:** Java
* **Automation:** Selenium WebDriver
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Management:** WebDriverManager
* **Data Handling:** Apache POI (Excel)
* **Reporting:** Extent Reports
* **Design Pattern:** Page Object Model (POM)

---

##  Application Under Test
**URL:** [https://sweetshop.netlify.app](https://sweetshop.netlify.app)

---

##  Project Structure
```plaintext
SweetCart/
│
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   ├── BasePage.java
│   │   │   └── BaseTest.java
│   │   │
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   ├── SweetsPage.java
│   │   │   ├── BasketPage.java
│   │   │   ├── AccountPage.java
│   │   │   └── NavigationPage.java
│   │   │
│   │   ├── utils/
│   │   │   ├── ConfigReader.java
│   │   │   ├── ExcelUtil.java
│   │   │   ├── ScreenshotUtil.java
│   │   │   └── ExtentManager.java
│   │   │
│   │   └── listeners/
│   │       └── TestListener.java
│
│   ├── test/java/
│   │   ├── tests/
│   │   │   ├── LoginTest.java
│   │   │   ├── SweetsTest.java
│   │   │   ├── BasketTest.java
│   │   │   ├── AccountTest.java
│   │   │   └── NavigationTest.java
│   │
│   └── test/resources/
│       ├── config.properties
│       └── testdata.xlsx
│
├── reports/
│   └── ExtentReport.html
│
├── screenshots/
│
├── testng.xml
├── pom.xml
└── README.md
```

---

##  Test Modules Covered

### Module 1: Authentication
* Valid login verification
* Invalid login validation
* Unauthorized access handling

###  Module 2: Product Browsing
* Verify sweets listing
* Validate product details
* Verify Add to Basket button

###  Module 3: Basket
* Add product to basket
* Verify basket contents
* Add multiple products

###  Module 4: Account
* Login and land on account page
* Verify order section
* Validate order data (date and total amount)

###  Module 5: Navigation
* Verify navigation links (Home, Sweets, About, Login)
* Validate About page heading
* Verify footer content and links

---

##  Key Features
- **Page Object Model (POM)**
- **Data-driven testing** using Excel
- **Explicit waits** (No `Thread.sleep` used)
- **Screenshot capture** on test failure
- **Extent Report** integration
- **Configurable browser** setup
- **Clean and reusable** code structure

---

## Screenshot on Failure
* Automatically captured using **TestNG Listeners**.
* Stored in the `/screenshots/` folder.
* Automatically attached to the **Extent Report** for failed steps.

---

## Reporting (Extent Reports)
An interactive HTML report is generated after each execution, providing:
* **Test Overview:** Name and Pass/Fail status.
* **Traceability:** Detailed error logs for failures.
* **Visual Evidence:** Screenshots embedded directly in the report.

 **Report Location:**
```plaintext
reports/ExtentReport.html
```

---

## Configuration

### `config.properties`
```properties
browser=chrome
baseUrl=https://sweetshop.netlify.app
timeout=10
```

---

##  How to Run the Project

### Using Maven
```bash
mvn test
```

### Using TestNG
* Right-click on `testng.xml`
* Select **Run as TestNG Suite**

---

## Design Approach
* **POM Pattern:** Encapsulated page elements and actions for high maintainability.
* **Separation of Concerns:** Distinct layers for Page classes, Test logic, and Utilities.
* **Dynamic Handling:** Used Explicit Waits and flexible locators to handle UI fluctuations.
* **Zero Hardcoding:** All configurations and test data are driven by external files.

---

## Challenges & Solutions


| Challenge | Solution |
| :--- | :--- |
| Dynamic UI behavior | Implemented flexible locators (XPath/CSS) |
| Inconsistent DOM elements | Utilized Explicit Waits for element stability |
| Account page routing issues | Validated page transitions using stable anchor elements |

---

##  Future Enhancements
* Implementation of **Parallel test execution**.
* **CI/CD integration** via GitHub Actions.
* **Docker** support for cross-environment consistency.
* Enhanced reporting with more granular dashboard analytics.

---

##  Author
**Bhavya Sree Kasa**

---

## Conclusion
This project demonstrates a comprehensive understanding of building a modern Selenium framework, focusing on clean code, robust reporting, and scalable design.

