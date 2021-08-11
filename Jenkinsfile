pipeline {
    agent any
    tools {
        maven 'maven_home'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage('Build') {
            steps {
               sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}