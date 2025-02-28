def buildApp() {
    echo "building the application...." 
    sh 'mvn package'
}

def testApp() {
    echo "testing application..."
}

def imageApp() {
    echo "building the docker image...."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t nateallon/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push nateallon/demo-app:jma-2.0'
    }

}

def deployApp() {
    echo "deploying the application...."
}

return this