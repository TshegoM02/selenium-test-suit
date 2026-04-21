# Selenium Test Suite – Login Automation

## 📌 Overview

This project is a beginner-friendly Selenium automation test suite built using Java, JUnit 5, and the Page Object Model (POM). It focuses on testing login functionality using both positive and negative test scenarios.

The goal of this project is to demonstrate clean test structure, basic automation skills, and an understanding of software testing principles.

---

## 🧪 What Is Being Tested

The application under test is a sample login page:

https://the-internet.herokuapp.com/login

### Test Scenarios:

* 🔍 Page load test (verify Google page title)
* ✅ Valid login (correct username and password)
* ❌ Invalid login (incorrect password)

---

## 🛠️ Tech Stack

* Java
* Selenium WebDriver
* JUnit 5
* WebDriverManager
* Maven

---

## 🧱 Project Structure

* `tests` → Contains test cases
* `pages` → Contains Page Object classes (LoginPage)
* `pom.xml` → Project dependencies

---

## 🧠 Key Concepts Demonstrated

* Page Object Model (POM)
* Test automation with Selenium
* Element location strategies (By.id, By.cssSelector)
* Assertions for validation
* Implicit waits for handling timing issues
* Separation of concerns (test logic vs page logic)

---

## ▶️ How to Run the Tests

1. Clone the repository:

```
git clone: 
https://github.com/TshegoM02/selenium-test-suit.git
```

2. Open in IntelliJ IDEA

3. Run tests:

* Right-click `LoginTest`
* Click **Run**

---

## 📈 Future Improvements

* Add explicit waits (WebDriverWait)
* Add more test scenarios (empty fields, locked user, etc.)
* Integrate reporting (Allure or Extent Reports)
* Run tests in headless mode
* Add CI/CD (GitHub Actions)

---

## 👩‍💻 Author

### Tshegofatso Mnguni

Software Developer | QA Enthusiast

---
