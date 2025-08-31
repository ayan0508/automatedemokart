# 🛒 DemoKart Automation Framework

A **Selenium Test Automation Framework** built for the [DemoKart E-commerce App](https://automatedemokart.vercel.app/).  
Since no single demo app offered all essential features, I built this lightweight clone using **Vibe Coding** and designed a robust automation framework around it.

---

## 🚀 Features

- ✅ **Selenium WebDriver (Java)**
- ✅ **TestNG** for test orchestration
- ✅ **Page Object Model (POM)** for modular design
- ✅ **ExtentReports** for rich, visual reporting
- ✅ **SoftAssert** for non-blocking validations
- ✅ **Dynamic element handling** (toasts, cards, etc.)
- ✅ **Explicit waits** for reliable synchronization
- ✅ **Cross-browser support** (Chrome & Edge via Jenkins parameters)
- ✅ **Headless mode compatibility** (CI-ready)

---

## ✅ Automated Scenarios

1. Restriction on adding to cart without login
2. Login with valid credentials
3. Verify product page with welcome toast message
4. Add to cart and validate URL navigation
5. Checkout flow with order confirmation

---

## 🔄 What's Next?

- 📊 **Data-Driven Testing** using Excel
- ☁️ **AWS Integration** to trigger test cases via Lambda or CodeBuild
- 🧠 **Java Streams Optimization** for cleaner, functional code
- 🧪 Additional test scenarios and edge case validations

---

## 🏁 Getting Started

### 🔧 Prerequisites

- Java (JDK 11 or above)
- Maven
- TestNG plugin
- ChromeDriver / EdgeDriver

### ▶️ Run Tests Locally

```bash
mvn clean test -DBROWSER=chrome
