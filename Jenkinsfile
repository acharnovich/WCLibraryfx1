pipeline {
  agent any
  stages {
    stage('Log Maven version info') {
      steps {
        sh 'mvn -version'
      }
    }
    stage('GitHub Jenkins Maven Build') {
      steps {
        git 'https://github.com/acharnovich/WCLibraryfx1.git'
        sh 'mvn clean compile test package'
      }
    }}
    post {
         always{
              mail to: "charnovich@gmail.com",
              subject: "Test Email",
              body: "Test"
          }
          failure{
                      emailext to: "",
                      attachLog: true,
                      subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                      body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
                  }
    }
  }
