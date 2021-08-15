pipeline {
    agent any
    tools {
        maven 'maven_home'
        jdk 'jdk'
    }

    environment {
        AUTOMATION_MACHINE = 'CI'
    }

    stages {
        stage('Build') {
            steps {
               sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
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