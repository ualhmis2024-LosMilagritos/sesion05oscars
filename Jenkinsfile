pipeline {
  agent any

  tools {
    // Nombre dado a la instalación de Maven en "Tools configuration"
    maven "maven default"
  }

  stages {
    stage('Git fetch') {
      steps {
        // Get some code from a GitHub repository
        git branch: 'main', url: 'https://github.com/ualhmis2024-LosMilagritos/sesion05oscars.git'
      }
    }
    stage('Compile, Test, Package') {
      steps {
        // When necessary, use '-f path-to/pom.xml' to give the path to pom.xml
        // Run goal 'package'. It includes compile, test and package.
        sh "mvn -f hmis2024Oscars/pom.xml clean package"
      }
      post {
        // Record the test results and archive the jar file.
        success {
          junit '**/target/surefire-reports/TEST-*.xml'
          archiveArtifacts '**/target/*.jar'
          jacoco( 
            execPattern: '**/target/jacoco.exec',
            classPattern: '**/target/classes',
            sourcePattern: '**/src/',
            exclusionPattern: '**/test/'
          ) 
          publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')] 
        }
      }
    }
    stage('Documentation') {
      steps {
        sh "mvn -f hmis2024Oscars/pom.xml javadoc:javadoc javadoc:aggregate" 
      }
      post {
        success {
          step([$class: 'JavadocArchiver', javadocDir: 'hmis2024Oscars/target/site/apidocs', keepAll: false])
          publishHTML(target: [reportName: 'Maven Site', reportDir: 'hmis2024Oscars/target/site', reportFiles: 'index.html', keepAll: false])
        }
      }
    }
     stage ('Analysis') {
      steps {
	    // Warnings next generation plugin required
	    sh "mvn -f hmis2024Oscars/spotbugs:spotbugs"
	    sh "mvn -f hmis2024Oscars/findbugs:findbugs"
      }
      post {
        success {
	  sh "mvn -f hmis2024Oscars/pom.xml site"
          dependencyCheckPublisher pattern: '**/target/site/dependency-check-report.xml'
          recordIssues enabledForFailure: true, tool: checkStyle()
          recordIssues enabledForFailure: true, tool: pmdParser()
          recordIssues enabledForFailure: true, tool: cpd()
          recordIssues enabledForFailure: true, tool: findBugs(pattern: '**/target/findbugsXml.xml')
          recordIssues enabledForFailure: true, tool: spotBugs(pattern: '**/target/spotbugsXml.xml')
        }
      }
    }
  }
}
