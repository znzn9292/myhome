# myhome
# Docker 실전 연습 예제입니다.

### Installation
<pre>
 cd /home
 git clone https://github.com/znzn9292/myhome
 cd Docker-Practice
</pre>

### Run
<pre>
 # Login For Private Docker Repository
 docker login
 docker pull znzn9292/docker-practice
 docker run -p 8080:8080 -v /home/ubuntu/myhome/project:/usr/local/tomcat/webapps znzn9292/docker-practice
</pre>
