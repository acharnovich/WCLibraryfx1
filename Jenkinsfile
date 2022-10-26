pipeline {
  agent any
  stages {
    stage('Log Ant version info') {
      steps {
        sh 'ant -version'
      }
    }
    stage('GitHub Jenkins Ant Build') {
      steps {
        git 'https://github.com/acharnovich/WCLibraryfx1.git'
        sh 'ant clean compile test package war'
      }
    }
  }
}