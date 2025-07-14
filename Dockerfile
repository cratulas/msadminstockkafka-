# Etapa 1: build con Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagen liviana con JDK 21
FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
WORKDIR /app

# Copiamos el .jar compilado desde la etapa anterior
COPY --from=builder /app/target/msadminstockkafka-0.0.1-SNAPSHOT.jar app.jar

# Puerto expuesto (debe coincidir con application.properties → 8088)
EXPOSE 8088

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
