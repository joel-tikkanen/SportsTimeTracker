pipeline {
    agent any
    stages {
        stage('Pull Code') {
            steps {
                git 'https://github.com/joel-tikkanen/SportsTimeTracker'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                sh 'mvn jacoco:report'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t joeltikk/sports-time-tracker .'
            }
        }
        stage('Push Docker Image') {
            steps {
                sh 'docker push joeltikk/sports-time-tracker'
            }
        }
    }
}
