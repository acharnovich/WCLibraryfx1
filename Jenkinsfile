pipeline {
  agent any
  stages {
    stage('Log Ant version info') {
      steps {
        sh 'mvn -version'
      }
    }
    stage('GitHub Jenkins Maven Build') {
      steps {
        git 'https://github.com/acharnovich/WCLibraryfx1.git'
        sh 'mvn clean compile test package war'
      }
    }
  }
}