pipeline {
    agent any
    tools {
        maven 'maven_home'
        jdk 'jdk'
    }
    stages {
        stage('Build') {
            steps {
               sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test -pl selenium3.x'
            }

            post {
                always {
                    junit 'selenium3.x/target/surefire-reports/*.xml'
                }
            }
        }
    }
}