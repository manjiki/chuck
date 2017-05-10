FROM jeanblanchard/java:8
VOLUME /tmp
ADD  ${project.build.finalName}.${project.packaging} app.jar
CMD ["java", "-jar", "app.jar"]
