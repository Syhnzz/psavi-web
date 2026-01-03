Partie front d'un site e-commerce en java avec spring/boot et javascript réalisé pour mon projet de licence

# PSAVI Web – Application web Java & API REST

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring-Security-green)
![Docker](https://img.shields.io/badge/Docker-ready-blue)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)

PSAVI Web est l’application web du projet PSAVI, développée en **Java / Spring Boot**
dans le cadre d’un **projet académique majeur**.

Elle fournit :
- une **interface web**
- une **API REST**
- la **gestion de la sécurité**
- l’accès aux données via le module **PSAVI Core**

---

## 🎯 Fonctionnalités
- Gestion des utilisateurs
- Création et consultation de discussions
- Création et consultation de messages
- Accès sécurisé aux ressources

---

## 🛠 Technologies
- Java
- Spring Boot (Spring MVC, Spring Security)
- API REST
- Thymeleaf, HTML, CSS
- Bootstrap
- Maven
- Docker
- Git

---

## 🏗 Architecture
psavi-web ├── api            # Contrôleurs REST ├── controller     # Contrôleurs web (vues Thymeleaf) ├── config         # Configuration sécurité ├── form           # Objets formulaires └── resources ├── static ├── templates └── schema.sql


---

## 🔗 API REST (extraits)

### Utilisateurs
- `GET /api/users`
- `GET /api/users/{id}`
- `POST /api/users`

### Discussions
- `GET /api/discussions`
- `POST /api/discussions`

### Messages
- `GET /api/messages/discussion/{id}`
- `POST /api/messages`

---

## 🧪 Tester l’API

L’API REST peut être testée avec **Postman** ou tout client HTTP.
