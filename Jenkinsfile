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

        stage('Chrome Test') {
            steps {
               sh 'curl http://192.168.1.12:4444/wd/hub/status/'
               sh 'mvn test -pl selenium3 -DdriverType=REMOTE_CHROME'
               sh 'mvn surefire:test -pl selenium3 -DdriverType=REMOTE_CHROME'
            }
            post {
                always {
                    archiveArtifacts artifacts:'$WORKSPACE/selenium3/target/allure-results'
                }
            }
        }
        stage('Firefox Test') {
                    steps {
                       sh 'curl http://192.168.1.12:4444/wd/hub/status/'
                       sh 'mvn surefire:test -pl selenium3 -DdriverType=REMOTE_FIREFOX'
                    }
                    post {
                        always {
                            unarchive mapping: ['target/allure-results' : 'target/allure-results2']
                            script {
                                allure([
                                    includeProperties: false,
                                    jdk: '',
                                    properties: [],
                                    reportBuildPolicy: 'ALWAYS',
                                    results: [[path: 'selenium3/target/allure-results']]
                                ])
                            }
                        }
                    }
                }
    }
}