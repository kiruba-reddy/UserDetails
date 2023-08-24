node{
    environment{
        DOCKERHUB_CREDENTIALS = credentials('docker-creds')
    }
    stage('checkout'){
        git branch:'master', url:'https://github.com/kiruba-reddy/UserDetails.git', changelog: false, poll: false
    }
    stage('build'){
        sh 'docker build -t kirubareddy/user-app:latest .'
    }
    stage('push'){
            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -password-stdin'
            sh 'docker push kirubareddy/user-app:latest'
    }
}