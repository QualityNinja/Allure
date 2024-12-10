pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Получение исходного кода
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Сборка проекта и выполнение тестов
                sh 'mvn clean test'
            }
        }
        stage('Allure Report') {
            steps {
                // Генерация Allure отчета
                sh 'mvn allure:report'
            }
        }
    }
    post {
        always {
            // Архивируем Allure результаты
            allure includeProperties: false, results: [[path: 'target/allure-results']]
        }
    }
}
