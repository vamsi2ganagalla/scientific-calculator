pipeline {
agent any

```
environment {
    IMAGE_NAME = "vamsi124/scientific-calculator"
}

stages {

    stage('Checkout') {
        steps {
            git branch: 'main', url: 'https://github.com/vamsi2ganagalla/scientific-calculator.git'
        }
    }

    stage('Build with Maven') {
        steps {
            sh 'mvn clean package'
        }
    }

    stage('Build Docker Image') {
        steps {
            sh '''
            docker build -t $IMAGE_NAME:$BUILD_NUMBER .
            docker tag $IMAGE_NAME:$BUILD_NUMBER $IMAGE_NAME:latest
            '''
        }
    }

    stage('Push Docker Image') {
        steps {
            withCredentials([usernamePassword(credentialsId: 'dockerhub-creds',
                usernameVariable: 'DOCKER_USER',
                passwordVariable: 'DOCKER_PASS')]) {

                sh '''
                echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                docker push $IMAGE_NAME:$BUILD_NUMBER
                docker push $IMAGE_NAME:latest
                '''
            }
        }
    }

    stage('Deploy with Ansible') {
        steps {
            sh 'ansible-playbook ansible/deploy.yml -i ansible/hosts'
        }
    }
}

post {
    success {
        emailext(
            subject: "SUCCESS: ${JOB_NAME} Build #${BUILD_NUMBER}",
            body: "Build succeeded! Check details: ${BUILD_URL}",
            to: "g.vamsi2001@gmail.com"
        )
    }

    failure {
        emailext(
            subject: "FAILED: ${JOB_NAME} Build #${BUILD_NUMBER}",
            body: "Build failed! Check console output: ${BUILD_URL}",
            to: "g.vamsi2001@gmail.com"
        )
    }
}
```

}

