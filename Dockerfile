# Étape 1 : Utiliser une image de base avec JDK
FROM openjdk:17-jdk-slim

# Étape 2 : Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré dans l'image Docker
COPY target/mon-application-1.0.0.jar app.jar

# Étape 4 : Exposer le port sur lequel l'application Spring Boot écoutera
EXPOSE 8080

# Étape 5 : Lancer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
