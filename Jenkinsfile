node{
    stage('build'){
        sh 'docker build -t microservice/user-app:latest .'
    }
    stage('push'){
        withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'pass', usernameVariable: 'user')]) {
            sh 'docker login -u $user --password-stdin $pass'
            sh 'docker push microservice/user-app:latest'
        }
    }
}