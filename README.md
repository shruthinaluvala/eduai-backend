🎓 EduAI – AI Powered Assignment Evaluation Platform (Backend)

This repository contains the **Spring Boot backend** for EduAI, handling authentication, assignment lifecycle management, and AI evaluation APIs.

---

##  Live Backend URL

🔗 https://eduai-backend-ez9q.onrender.com

---

##  Features

- User authentication (Student & Faculty)
- Assignment submission APIs
- Assignment lifecycle management
- Faculty review & grading APIs
- AI evaluation API
- RESTful architecture

---

## 🛠 Tech Stack

- **Backend:** Java, Spring Boot
- **Build Tool:** Maven
- **Deployment:** Render (Docker)
- **Architecture:** REST APIs

---

##  API Endpoints

###  Authentication
- `POST /api/auth/login`
- `POST /api/auth/register`

###  Assignments
- `POST /api/assignments/submit`
- `GET /api/assignments/all`
- `GET /api/assignments/count/{username}`
- `POST /api/assignments/review/{index}`
- `POST /api/assignments/grade/{index}`

### 🤖 AI Evaluation
- `POST /api/ai/evaluate`

---

##  Local Setup

```bash
git clone https://github.com/shruthinaluvala/eduai-backend.git
cd eduai-backend
mvn spring-boot:run
🐳 Docker Support
bash
Copy code
docker build -t eduai-backend .
docker run -p 8080:8080 eduai-backend




👩‍💻 Developed By
Naluvala Sruthi
B.Tech CSE 

⭐ If you like this project, give it a star!
