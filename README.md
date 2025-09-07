# Billing-software


A full-stack, real-world billing software application for retail clients, developed using a modern tech stack. This project provides a complete 
solution for managing products, categories, orders, and payments, with a focus on a user-friendly and responsive experience.

## Screenshots

| Dashboard | Order Creation |
| :---: | :---: |
| ![Dashboard](https://github.com/user-attachments/assets/a676694c-cef2-4e5a-b8f8-4b3ef2a1c173) | ![Order Creation](https://github.com/user-attachments/assets/eb1cbf49-7342-459d-adb7-ed52d13abcdd) |

| Payment | Receipt |
| :---: | :---: |
| ![Payment](https://github.com/user-attachments/assets/68af7289-51f6-4eb3-a1d3-628fe61eca3b) | ![Receipt](https://github.com/user-attachments/assets/85ce4e6f-7873-4f02-ac4a-1d136d68c358) |



## Key Features

* **Category & Product Management:** CRUD (Create, Read, Update, Delete) operations for categories and products.
* **Order & Billing System:** Intuitive interface for creating new orders, adding items, and generating receipts.
* **Real-time UI Updates:** Dynamic updates to the cart and totals as items are added or removed.
* **Secure Payments:** Seamless integration with **Razorpay** for secure online transactions.
* **File Upload & Management:** Handles product image uploads and storage using **AWS S3**.
* **RESTful API:** A robust backend built with Spring Boot, providing clean and efficient REST APIs.
* **User Authentication:** Secure access control using **Spring JWT (JSON Web Tokens)**.
* **Responsive Design:** Optimized for a great user experience on various screen sizes.

* ## Technologies Used

* **Frontend:**
    * React.js
    * Bootstrap 5
    * Axios
    * Vite (for a fast development environment)

* **Backend:**
    * Spring Boot
    * Java
    * Spring Data JPA
    * MySQL Database
    * Maven (Build tool)
    * Spring Security & JWT
    * Postman

* **Payment Gateway:**
    * Razorpay

* **Cloud Services:**
    * AWS S3 (for image storage)
 
    * ## Getting Started

Follow these steps to set up and run the project locally.

### Prerequisites

* Java JDK 17+
* Node.js and npm (or yarn)
* MySQL Server
* Maven
* AWS S3 account and credentials
* Razorpay account and API keys

### Backend Setup

1.  Clone the repository:
    ```bash
    git clone [your-repo-link]
    cd your-project-folder
    ```
2.  Configure your `application.properties` file:
    * Database connection details (`spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`).
    * AWS S3 credentials.
    * Razorpay API keys.
3.  Build and run the Spring Boot application using Maven:
    ```bash
    mvn spring-boot:run
    ```

### Frontend Setup

1.  Navigate to the `client` directory:
    ```bash
    cd client
    ```
2.  Install dependencies:
    ```bash
    npm install
    ```
3.  Start the React application:
    ```bash
    npm run dev
    ```

The application should now be running on `http://localhost:5173` (or the port specified in your Vite config).

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-FF6C37?style=for-the-badge&logo=apachemaven&logoColor=white)

![React](https://img.shields.io/badge/React-18-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![Vite](https://img.shields.io/badge/Vite-4.0-646CFF?style=for-the-badge&logo=vite&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
![Axios](https://img.shields.io/badge/Axios-API%20Calls-5A29E4?style=for-the-badge&logo=axios&logoColor=white)

![AWS S3](https://img.shields.io/badge/AWS-S3-FF9900?style=for-the-badge&logo=amazons3&logoColor=white)
![Razorpay](https://img.shields.io/badge/Razorpay-Payments-02042B?style=for-the-badge&logo=razorpay&logoColor=00AEEF)
![Postman](https://img.shields.io/badge/Postman-API%20Testing-FF6C37?style=for-the-badge&logo=postman&logoColor=white)



## Author

* Vithika Pawar - https://www.linkedin.com/in/vithikapawar/ - https://github.com/vithikasingh

Feel free to connect with me if you have any questions or feedback!
