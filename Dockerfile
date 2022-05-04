FROM openjdk:8-jdk-alpine
COPY target/pfe-gitops-demo-*.jar pfe-gitops-demo.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar", "pfe-gitops-demo.jar"]
HEALTHCHECK --interval=25s --timeout=3s --retries=3 CMD wget --spider http://localhost:8081/actuator/health || exit 1