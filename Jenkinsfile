pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'], description: 'version options')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage("build") {
            steps {
                echo "building the application...."
            }
        }

        stage("test") {
            when {
                expression {
                    params.executeTests == true
                }
            }
            steps {
                echo "testing the application...."
            }
        }

        stage("deploy") {

            steps {
                echo "deploying the application...."
                echo "deploying version ${params.VERSION}"
            }
            withCredentials([
                usernamePassword(credentials: 'server-creds', usernameVariable: USER, passwordVariable: PWD)
            ]) {
                sh "echo ${USER}"
            }
        }
    }
}