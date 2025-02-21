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
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}