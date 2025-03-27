🚀 Installation & Setup Instructions
1. Clone the Repository
bash
Copy
Edit
git clone (https://github.com/jayantkumar1604/Digital-Library-Book-Management-System)
cd springboot-auth-service
2. Configure the Database
Open src/main/resources/application.properties

Update MySQL configurations:

ini
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
Create the database manually or let JPA create it automatically.

3. Build the Project
bash
Copy
Edit
mvn clean install
4. Run the Application
bash
Copy
Edit
mvn spring-boot:run
The application will run on:
http://localhost:8080

🔥 API Endpoints
Authentication
POST /api/auth/register → Register new user

POST /api/auth/login → Login and receive JWT token

User APIs
GET /api/users/me → Get current user profile

GET /api/users → Get all users (Admin only)

Admin APIs
POST /api/admin/create → Create new admin

DELETE /api/admin/delete/{id} → Delete user by ID

⚙️ Environment Variables
If you are using environment variables, create a .env file with the following:

ini
Copy
Edit
JWT_SECRET=your_jwt_secret_key  
JWT_EXPIRATION=86400000  
MYSQL_HOST=localhost  
MYSQL_PORT=3306  
MYSQL_USER=your-username  
MYSQL_PASSWORD=your-password  
🚀 Deployment
If deployed, include the live URL here:

bash
Copy
Edit
Deployed at: <your deployment link here>
🛠️ Challenges Faced
Configuring JWT expiration and refresh tokens.

Handling Spring Security filters for JWT verification.
