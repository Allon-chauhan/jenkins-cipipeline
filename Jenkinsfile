@Library('jenkins-shared-library')

def gv

pipeline {   
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("increment version") {
            steps {
                script {
                    gv.incrementVersion()
                }
            }

        }

        stage("build jar") {
            steps {
                script {
                    gv.buildJar()

                }
            }
        }

        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    deployApp()
                }
            }
        }               
    }
} 
