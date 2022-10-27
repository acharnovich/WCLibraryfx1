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
          always {
            emailext to: "charnovich@gmail.com",
            subject: 'Email test',
            body: 'Email test',
            attachLog: true
          }
    }
  }