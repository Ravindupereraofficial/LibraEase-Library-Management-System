# Library Management System

📚 **Library Management System** is a **JavaFX-based application** designed to streamline library operations, including book borrowing, fine management, membership tracking, and real-time book availability monitoring. The system follows a **Layered Architecture**, ensuring scalability, maintainability, and modular development.

---

## 🚀 Features

✅ **Book Management** – Add, update, categorize, and check book availability.  
✅ **Borrow & Return System** – Track book transactions and enforce return policies.  
✅ **Fine Management** – Automatically calculate overdue fines and process payments.  
✅ **Membership Handling** – Register, manage, and analyze member activity.  
✅ **Comprehensive Reports** – Generate insights on book usage, fines, and top borrowers.  

---

## 🏗 Architecture (Layered Design)

The system follows a **Layered Architecture**, dividing functionalities into separate modules:

1️⃣ **Presentation Layer (UI)** – Developed using **JavaFX**, providing an intuitive and responsive graphical user interface.  
2️⃣ **Service Layer (Business Logic)** – Handles core functionalities like borrowing books, calculating fines, and updating availability.  
3️⃣ **Data Access Layer (DAO)** – Manages database operations using **MySQL**, ensuring efficient data retrieval and storage.  
4️⃣ **Database Layer** – MySQL database storing books, members, transactions, and fines.  

---

## 🛠 Technologies Used

🔹 **Java (JavaFX)** – GUI Development  
🔹 **MySQL** – Database Management  
🔹 **JDBC (DAO Pattern)** – Data Handling  
🔹 **FXML & CSS** – UI Styling  
🔹 **Maven/Gradle** – Dependency Management  

---

## 📂 Project Structure

- `/src` – Contains all Java classes structured by layer (Controller, Service, DAO, Models).  
- `/resources` – Includes UI layouts (`.fxml`), stylesheets, and icons.  
- `/db` – SQL scripts for database schema and sample data.  
- `/docs` – System documentation, report templates, and API references.  

---

## 📌 Installation & Setup

1️⃣ Clone this repository:
```bash
 git clone https://github.com/yourusername/library-management-system.git
```
2️⃣ Configure the database (`library.sql` in `/db`).
3️⃣ Import the project into **IntelliJ IDEA** or **Eclipse**.
4️⃣ Run the `Main.java` file to launch the system.

---

## 📊 Reports Generated

📄 **Book Reports** – Lists all books, categorized, with availability status.  
📄 **Borrowing Reports** – Shows books borrowed, due dates, and overdue records.  
📄 **Fine Reports** – Details of fines, amounts, and payment status.  
📄 **Membership Reports** – Summary of active and inactive members.  
📄 **Top Borrowers Report** – Highlights the most active readers.  

---

## 💡 Contributing

Pull requests are welcome! Feel free to open issues for feature requests or bug fixes.

---

## 📜 License

This project is licensed under the **MIT License** – free to use and modify!

---

### **📢 Thank You!**

📖 "Thank you for using our Library Management System! We strive to enhance your reading experience by providing efficient services and insightful reports. If you have any questions or suggestions, feel free to reach out to the library administration."

📚 **"Empowering Knowledge | Enriching Lives"** 📚
