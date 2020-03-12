node
{
  stage('SCM-CheckIn From GitHub')
  {
      git 'https://github.com/amitbaria/ms-java-dashboard'
    
  }
  stage('Clean and Maven package')
  {
      def mvnHome= tool name: 'maven3', type: 'maven'
      sh  "${mvnHome}/bin/mvn package"  
    
      
  }

}
