pipeline {
    agent none
    options { skipDefaultCheckout(true) }
    stages {
        stage('Build and Test') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            options { skipDefaultCheckout(false) }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Docker build') {
            agent any
            steps {
                sh 'sudo docker build -t java-migrator-image:latest .'
            }
        }
        stage('Docker run') {
            agent any
            steps {
                sh 'sudo docker ps -f name=java-migrator-container -q | xargs --no-run-if-empty docker container stop'
                sh 'sudo docker container ls -a -fname=java-migrator-container -q | xargs -r docker container rm'
                sh 'sudo docker rmi $(docker images -f "dangling=true" -q)'
                sh 'sudo docker run -d --name java-migrator-container -p 8080:8080 java-migrator-image:latest'
            }
        }
    }
}