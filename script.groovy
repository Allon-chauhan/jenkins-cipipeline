def buildJar() {
    echo 'building the application...'
    sh 'mvn clean package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t nanatwn/demo-app:$IMAGE_NAME .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push nanatwn/demo-app:$IMAGE_NAME'
    }
}

def incrementVersion() {
    echo "incrementing app version"
    sh 'mvn build-helper:parse-version versions:set \
        n-DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit'
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    def version = matcher[0][1]
    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
}

return this
