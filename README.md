# 🛒 DemoKart Automation Framework  

A **Selenium Test Automation Framework** built for an E-commerce demo app: [DemoKart](https://automatedemokart.vercel.app/).  
Since I couldn’t find a single demo application with all essential features, I built this small **E-commerce clone app** using **Vibe Coding** and designed a robust automation framework around it.  

---

## 🚀 Features  

- ✅ **Selenium WebDriver (Java)**  
- ✅ **TestNG** for test execution and annotations  
- ✅ **Page Object Model (POM)** design pattern for maintainability  
- ✅ **ExtentReports** for professional reporting  
- ✅ **Soft Assertions** for better validations  
- ✅ **Dynamic element handling** (toasts, cards, etc.)  
- ✅ **Synchronization** (explicit waits for stability)  

---

## ✅ Automated Scenarios  

1. Restriction on adding to cart without login  
2. Login with valid credentials  
3. Verify product page with welcome toast message  
4. Add to cart and validate URL navigation  
5. Checkout flow with order confirmation  

---

## 📌 Upcoming Enhancements  

- 🔄 **Data-Driven Testing** with Excel  
- ⚙️ **CI/CD Integration with Jenkins**  
- 📈 Additional test scenarios & validations  

---

## 🏁 Getting Started  

### 🔧 Prerequisites  
- Java (JDK 11 or above)  
- Maven  
- TestNG plugin  
- ChromeDriver  

### ▶️ Run Tests  
mvn clean test

```bash
mvn clean test
