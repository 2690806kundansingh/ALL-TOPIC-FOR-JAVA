/*
1.created project
2.created jar file of project(it create from left maven lifecycle and the double click on package)
 but we use terminal beacause when we use pipiline thier is no intelliji
 ..\mvnw clean package(to clean package) and help to create jar file

3.crating dockerfile --> docker images --> docker container
(writing docker file for java project) 

4.after writing dokcer file build docker image
------docker build -t spring-boot-app .

5.localy bhi test kar liya run karke
==> to see or run the project in terminal using docker
-----docker run -d -p 8081:8081 --name spring-boot-app spring-boot-app:latest

6. push docker images to docker hub repository
   .first login to docker hub
   .write tag name
   - docker tag spring-boot-app kundansingh2690806/spring-boot-app:latest
   - docker push kundansingh2690806/spring-boot-app:latest
    
7.to check we create a instance on aws launce instace and we use
ubuntu and create ci/cd instance

8.create a repository CI-CD
https://github.com/2690806kundansingh/CI-CD.git
--< in terminal
  .git init
  .git status
  .git add .
  .git commit -m "Initial project"
  .git remote add origin https://github.com/2690806kundansingh/CI-CD.git
  .git push origin main

9.action perform karne ke liye hum intelli or project folder me jake
.github(folder)
uske under .workflows(folder)
  fir workflow ke under deploye.yml(file)
 */