node{
    stage('checkout'){
        git branch:'master', url:'https://github.com/kiruba-reddy/UserDetails.git', changelog: false, poll: false
    }
    stage('build'){
        sh 'docker build -t microservice/user-app:latest .'
    }
    stage('push'){
        withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'pass', usernameVariable: 'user')]) {
            sh 'docker login -u $user -p $pass'
            sh 'docker push microservice/user-app:latest'
        }
    }
}