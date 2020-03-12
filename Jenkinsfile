node
{
  stage('SCM-CheckIn From GitHub')
  {
      git 'https://github.com/amitbaria/ms-java-dashboard11111'
    
  }
  stage('Clean and Mavenpackage')
  {
      def mvnHome= tool name: 'maven3', type: 'maven'
      sh  "${mvnHome}/bin/mvn package"  
    
      
  }

}
