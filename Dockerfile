FROM openjdk:8-jdk
MAINTAINER Sunhwan Jung <znzn9292@gmail.com>

# 환경 변수 및 작업 경로
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
RUN mkdir -p "$CATALINA_HOME"
WORKDIR ${CATALINA_HOME}

# 패키지 설치 wget은 톰캣 설치 파일 다운로드 위한
RUN apt-get update;
RUN apt-get install -y --no-install-recommends
RUN apt-get install -y gnupg dirmngr
RUN apt-get install -y wget ca-certificates

# 톰캣 설치 파일 다운로드 실행 및 압축해제            
RUN wget http://apache.mirror.cdnetworks.com/tomcat/tomcat-9/v9.0.41/bin/apache-tomcat-9.0.41.tar.gz;
RUN tar -xf apache-tomcat-9.0.41.tar.gz  --strip-components=1;

# 불필요 파일 삭제 후 배포 후 war 파일 위치(webapps) 설정
#RUN find . -name "*.bat" -exec rm -rf {} \;
#RUN rm -rf *tomcat*.tar.gz;
#RUN mv webapps webapps.org
#RUN mkdir webapps

# war 파일 복사
#COPY ./app/ROOT.war $CATALINA_HOME/webapps

# 컨테이너에서 사용할 포트
EXPOSE 8080

# 설정 완료 후 실행
CMD ["catalina.sh", "run"]
