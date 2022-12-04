FROM maven:3.8.4-openjdk-17-slim as build
WORKDIR /app
COPY . .
RUN mvn -f /app/account/pom.xml -B --no-transfer-progress dependency:go-offline
RUN mvn -f /app/account/pom.xml -B -U clean package -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn


FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/account/account-infra/target/account-infra*.jar /account-infra.jar

ENV TZ Europe/Istanbul

EXPOSE 9090

ENTRYPOINT ["java", "-XX:+UseG1GC", "-XX:+UseStringDeduplication", "-jar", "/account-infra.jar"]