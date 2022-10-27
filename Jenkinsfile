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
    }
    stage('Post') {
          steps {
            emailext attachLog: true, body: 'Email test', subject: 'Email test', to: 'andyholmes8@hotmail.com'
          }
    }
  }
}