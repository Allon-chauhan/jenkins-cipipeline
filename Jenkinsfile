@Library('jenkins-shared-library')

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
                    buildApp()
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    imageApp()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}