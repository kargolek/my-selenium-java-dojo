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

        stage('Smoke Test') {
            steps {
                sh 'curl http://192.168.1.12:4444/wd/hub/status/'
                sh 'mvn test -pl selenium3 -Dtest=HerokuSmokeTest -DdriverType=REMOTE_CHROME'
                fileOperations([fileRenameOperation(destination: 'selenium3/target/allure-results2', source: 'selenium3/target/allure-results')])
            }
        }
    }
	
	post {
		always {
			script {
				allure([includeProperties: false,
				jdk: '',
				properties: [],
				reportBuildPolicy: 'ALWAYS',
				results: [[path: 'selenium3/target/allure-results2'], [path: 'selenium3/target/allure-results']]
				])
			}
		}
    }
}