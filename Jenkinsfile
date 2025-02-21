def gv 

pipeline {
    agent any
    tools {
        maven "maven-3.9.9"
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    gv.imageApp()
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
        }
    }
}