FROM openjdk:17-jdk
EXPOSE 8080
ADD target/panda-food-employee-management.jar panda-food-employee-management.jar 
ENTRYPOINT ["java","-jar","/panda-food-employee-management.jar"]