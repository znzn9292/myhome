# myhome Docker Test!!!!!

### Installation
<pre>
 cd /home
 git clone https://github.com/znzn9292/myhome
 cd Docker-Practice
</pre>

### Run AWS
<pre>
 # Login For Private Docker Repository
 docker login
 docker pull znzn9292/docker-practice
 docker run -p 8080:8080 -v /home/ubuntu/myhome/project:/usr/local/tomcat/webapps znzn9292/docker-practice
</pre>

### Run NAS
<pre>
 # Login For Private Docker Repository
 docker login
 docker pull znzn9292/docker-practice
 docker run -p 8080:8080 -v /homes/znzn/docker/tomcat:/usr/local/tomcat/webapps znzn9292/docker-practice
</pre>
