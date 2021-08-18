pipeline {
    agent any
    tools {
        maven 'maven_home'
        jdk 'jdk'
    }

    stages {
        stage('Build') {
            steps {
               sh 'docker-compose -f up -d'
               sh 'mvn -B -DskipTests clean package'
            }

            step([$class: 'DockerComposeBuilder'])
        }

        stage('Chrome Test') {
            steps {
               sh 'curl http://192.168.1.12:4444/wd/hub/status/'
               sh 'mvn test -pl selenium3 -DdriverType=CHROME'
            }
        }

        stage('Firefox Test') {
            steps {
               sh 'curl http://192.168.1.12:4444/wd/hub/status/'
               sh 'mvn test -pl selenium3 -DdriverType=FIREFOX'
            }
        }
    }
}