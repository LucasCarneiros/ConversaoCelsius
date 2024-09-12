# Usar a imagem oficial do Maven para compilar o projeto
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências do projeto
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar o código-fonte e construir o aplicativo
COPY src ./src
RUN mvn clean package

# Usar a imagem oficial do JDK para rodar o projeto
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copiar o JAR gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expôr a porta do Spring Boot (8080 por padrão)
EXPOSE 8080

# Comando para rodar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
