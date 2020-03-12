node
{
  stage('SCM-CheckIn From GitHub')
  {
      git 'https://github.com/amitbaria/ms-java-dashboard'
    
  }
  stage(Clean and Maven package)
  {
      sh 'mvn package'
  }

}
