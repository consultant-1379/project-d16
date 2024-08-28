FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar git-mining.jar

COPY CSV_Files CSV_Files
EXPOSE 8000
CMD ["java","-jar","/git-mining.jar"]


FROM python:3.10-slim
COPY CSV_Monitor.py CSV_Monitor.py
COPY CSV_New.py CSV_New.py
COPY requirements.txt requirements.txt
RUN pip3 install -r requirements.txt

