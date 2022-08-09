FROM openjdk:8-jdk-alpine
COPY target/pfe-gitops-demo-*.jar pfe-gitops-demo.jar
COPY src/main/resources/application.yaml config/application.yaml
EXPOSE 8080
USER 1000:1000
ENTRYPOINT ["java","-jar", "pfe-gitops-demo.jar", "-Dspring.config.location=config/application.yaml"]
HEALTHCHECK --interval=25s --timeout=3s --retries=3 CMD wget --spider http://localhost:8080/app/actuator/health || exit 1