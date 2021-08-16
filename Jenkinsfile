pipeline {
    agent any
    tools {
        maven 'maven_home'
        jdk 'jdk'
    }

    stages {
        stage('Build') {
            steps {
               sh 'export AUTOMATION_MACHINE=CI'
               sh 'env'
               sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'curl http://192.168.1.12:4444/wd/hub/status/'
                sh 'mvn test -pl selenium3'
            }

            post {
                always {
                    junit 'selenium3/target/surefire-reports/*.xml'
                }
            }
        }
    }
}