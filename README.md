# Spring Boot using Openshift Configmaps

## This is a quick sample of how to use a Spring Boot App with OpenShift ConfigMaps.

Step 1 - Clone this project to your local machine
```
git clone https://github.com/quivsoth/springboot-configmap
```
<br/>

Step 2 (Optional) - Test if the build is running
```
- ./mvnw clean spring-boot:run
- Navigate to http://localhost:8080/greet/{name}
```
<br/>

Step 3 - Set up the desired variable you would like to be displayed in a config map
```
- /src/main/jkube/configmap.yaml
- myprop: [value]
```
<br/>

Step 4 (Optional) - Review the Role Bindings to ensure the namespaces match your project
```
/src/main/jkube/rolebinding.yaml
```
<br/>

Step 5 - Log in to your OCP instance
```
oc login [options] -user -password
```
<br/>

Step 6 - Create a new Project or go to an existing project (please the default namespace for RoleBinding is refresh-poc), if you create/use a new project you will need to change the RoleBinding.yaml namespace (step 4) to reflect this
```
oc new-project refresh--poc \
    --description="POC test" --display-name="Refresh POC"
```
<br/>

Step 7 - From the root of the /springboot-configmap directory, build the project to OCP, this will create the configmap and the rolebinding
```
./mvnw -Popenshift -DskipTests oc:deploy
```
<br/>

Step 8 - Open the REST endpoint from browser or run curl
```
http:/[OPENSHIFT URL]/greet/{user} - you will see the first variable is being called from the config.yaml variable!
```
