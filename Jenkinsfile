node(){
    stage('Checkout code') {
      
        checkout scm
        
    }
    
    stage('check what is in dir'){
        sh 'ls'
    }
    
    stage('run test'){
       
            sh 'mvn clean test'
        
    }
    
}
