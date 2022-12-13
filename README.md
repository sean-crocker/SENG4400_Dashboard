Part Three - The Dashboard
==================

REST endpoint creating using the public Cloud-Hosted PAAS Google App Engine.

## Requirements

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven](https://maven.apache.org/download.cgi) (at least 3.5)
* [Google Cloud SDK](https://cloud.google.com/sdk/) (gcloud)

## Setup

With the requirements installed, the gcloud CLI `app-engine-java` component needs to be installed. This can be achieved
by running the command:

    gcloud components install app-engine-java

From the project directory (folder containing pom.xml), run the command:

    mvn clean install

From the same directory either run locally or deploy with the respective commands:

### Running locally

    mvn package appengine:run

### Deploying

    mvn package appengine:deploy

If issues arise when deploying try using the command:

    mvn appengine:deploy -Dapp.deploy.projectId=seng4400-350016 -Dapp.deploy.version=1 -Dapp.deploy.promote=False

## More Information or Help

See more information about [Java on Google App Engine][ae-docs]. To display help information on the App Engine Maven
plugin use the command:

[ae-docs]: https://cloud.google.com/appengine/docs/java/

    mvn appengine:help -Ddetail=true -Dgoal=[GOAL_NAME]

Parameters that can be applied:

| Parameter  	| Description                                                                               	| User Property 	|
|------------	|-------------------------------------------------------------------------------------------	|---------------	|
| detail     	| If true, display all settable properties for each goal. Default is False                  	| detail        	|
| goal       	| The name of the goal for which to show help. If unspecified, all goals will be displayed. 	| goal          	|
| indentSize 	| The number of spaces per indentation level. Should be a positive number. Default is 2.    	| indentSize    	|
| lineLength 	| The maximum length of a display line. Should be a positive number. Default is 80.         	| lineLength    	|
