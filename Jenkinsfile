def gv 

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'], description: 'version options')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage("test") {
            when {
                expression {
                    params.executeTests == true
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy") {
            input {
                message "Select the environment to deploy to"
                ok "Environment selected!"
                parameters{
                    choice(name: 'ENV', choices: ['Dev', 'staging','prod'], description: 'version options')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "Deploying to ${ENV}"
                }
            }
           /* withCredentials([
                usernamePassword(credentials: 'server-creds', usernameVariable: USER, passwordVariable: PWD)
            ]) {
                sh "echo ${USER}"
            } */
        }
    }
}