node(){
    stage('check current dir'){
        sh 'pwd'
    }
    stage('check what is in dir'){
        sh 'ls'
    }
    stage('clone directory'){
        sh 'git clone git@github.com:balrajchavan/Maven'
    }
    stage('run test'){
        dir('Maven'){
            sh 'mvn clean'
        }
    }
}
