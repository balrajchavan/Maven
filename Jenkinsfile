node(){
    stage('Checkout code') {
        steps {
            checkout scm
        }
    }
    
    stage('check current dir'){
        sh 'pwd'
    }
    
    stage('check what is in dir'){
        sh 'ls'
    }
    
    stage('run test'){
        dir('Maven'){
            sh 'mvn clean test'
        }
    }
    
}
