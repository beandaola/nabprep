pipeline {
        options {
            buildDiscarder(logRotator(numToKeepStr: '3'))
        }
       
        agent any

        stages {
            stage('Bump Versions') {
                steps {
                    println 'Bump Versions'
                }
            }
            
            stage('Compile') {
                steps {
                    println 'Compile'
                }
                
            }
            
        }

        
  }
