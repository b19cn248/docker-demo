# Giai đoạn 1: Tải phụ thuộc
FROM maven:3.8.7 AS deps
WORKDIR /opt/app
COPY pom.xml .
RUN mvn dependency:go-offline

# Giai đoạn 2: Xây dựng ứng dụng
FROM maven:3.8.7 AS builder
WORKDIR /opt/app
COPY --from=deps /root/.m2 /root/.m2
COPY --from=deps /opt/app .
COPY /src /opt/app/src
RUN mvn clean package

# Giai đoạn 3: Tạo image cuối cùng để chạy ứng dụng
FROM eclipse-temurin:17-jre-alpine AS extractor
WORKDIR /opt/app
# Giả sử rằng tên file JAR là 'application.jar' và nó nằm trong thư mục 'target'
COPY --from=builder /opt/app/target/*.jar /opt/app/application.jar
CMD [ "java", "-jar", "/opt/app/application.jar" ]
