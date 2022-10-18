pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: "main", url:'https://github.com/ankitkumar5184/JavaFrameworkExtentReport.git'
            }
        }
        stage('Test') {
            steps{
                xml 'testng.xml'
            }
        }
    }
   post {
        	always {
          echo 'test executed'
	  	}
	   success {  
             echo 'Build successfully executed'
         }  
       failure {
         mail to: 'ankit.kumar@infostride.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Build number ${env.BUILD_NUMBER} has been failed. Track the issues by visiting the url  ${env.BUILD_URL}"
	    }
    }
}
	
