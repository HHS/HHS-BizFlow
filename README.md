# HHS BizFlow HR Tracking System Common Modules

Modules

- **biis** : BIIS interface where user information and reference data is pulled from the BIIS interface into the BizFlow and HHS common database. 
- **database** : HHS BizFlow common database script.
- **jdbcconn** : JDBC Connection test tool.
- **usas** : USA Staffing interface has two parts - batch and web. 



## JDBC Connection test tool
This is a development project to produce a simple program to test JDBC connection.

### Pre-requisite
* JDK 1.7
* Apache Ant 1.9.x


### Build Instruction

1. In the build machine, download the project repository files.

1. Open a command line, and change directory to `jdbcconn` directory.

		cd jdbcconn

1. Using a text editor, open `jdbcconn.properties` file, and modify the JDK location in the following property.

		jdk.home.1.7=<full_path_to_jdk_home_dir>

1. In the command line, run ANT build script.

		ant

1. Capture the generated module JAR file as well as dependent library JAR files.

		jdbcconn/dist/lib/jdbcconn.jar
		jdbcconn/dist/lib/*.jar
		jdbcconn/dist/run.sh
		jdbcconn/dist/run.bat


### Deployment Instruction

1. Log in to the target environment server.

1. Create a directory where the JDBC Connection test tool will be installed.

	For example:

		mkdir -p <server_dir>/jdbcconn/

1. Copy the module JAR file and its dependent library JAR files.

	* From (build machine):
		* jdbcconn/dist/lib/*.jar
		* jdbcconn/dist/run.sh
		* jdbcconn/dist/run.bat
	* To (target environment):
		* <server_dir>/jdbcconn/

1. For UNIX environment, make the run script executable.

		cd <server_dir>/jdbcconn
		chmod 744 run.sh

### Usage
The deployed module can be run on demand as a stand alone application.

	./run.sh

Running the program without parameter will show the usage instruction.  Run the program with proper parameters according to the instruction.

For example:

	./run.sh oracle dev.dbhost.com 1521 dbsid dev devpass




## BIIS Interface
This module is to pull HHS employee directory information into BizFlow user profile database table. BIIS and EHRP reference data is also imported into HHS common database and is refreshed nightly.

Note: Once the user profile information is imported, BizFlow system administrator will need to manually maintain license assignment, authority group assignment, and user group assignment through BizFlow Administration menu.


### Pre-requisite
* Source and target database connection information.
* JDK 1.7
* Apache Ant 1.9.x


### Directory Structure

* **biis/src** : Source code directory for BIIS batch job interface
* **biis/lib** : Library directory for dependency


### Build Instruction

1. In the build machine, download the project repository files.

1. Open a command line, and change directory to `biis` directory.

		cd biis

1. Using a text editor, open `biis.properties` file, and modify the JDK location in the following property.

		jdk.home.1.7=<full_path_to_jdk_home_dir>

1. In the command line, run ANT build script.

		ant package.exejar

1. Capture the generated module JAR file, configuration files, and shell script to run the module.

		biis/dist/run-jar.sh
		biis/dist/application.properties
		biis/dist/biis-<version>.jar


### Deployment Instruction

1. Log in to the target environment server as the BizFlow service owner (or sudo).

1. Create a directory where the BIIS Interface module will be installed.

	For example:

		mkdir -p <server_dir>/biis/

1. Copy the module JAR file and its dependent library JAR files.

	* From (build machine):
		* biis/dist/*
	* To (target environment):
		* <server_dir>/biis/

1. Make sure the script has correct JAVA_HOME environment variable set.  Open and edit `run-jar.sh` script.

	JAVA_HOME=<path_to_java_runtime_home_dir>

1. Configure properties.  Open and edit `application.properties` file for the following entries.  There are many other properties, but the following entries are essential.

		hhs.datasource.url=
		hhs.datasource.username=
		hhs.datasource.password=


### Usage
The deployed module can be run on demand or as a stand alone application.  


For UNIX environment, make the run script executable.

	cd <server_dir>/biis
	chmod 744 run-jar.sh

For on-demand run, execute the shell script in command line.

	./run-jar.sh

For regular usage in server environment, it is expected to be executed periodically by a cron job.

	crontab -e

		# BIIS Batch job
		40 20 * * * /bin/sh <server_dir>/biis/run-jar.sh




## USA Staffing Interface (Batch)
USA Staffing Interface module is to pull HR related data from USA Staffing site through Data Self Service (DSS) web service call.

In order to call DSS web service, there should be an existing report created for the data collection.  DSS provides access to run the report remotely and capture the report output as XML format.

This is a batch job module as opposed to web application.  Therefore, it should be packaged as JAR and be deployed to a server which can run a stand-alone batch job.


### Pre-requisite
* Identify the report to run in USA Staffing site.
* DSS account with credential to access the report in USA Staffing site.
* Target database connection information.
* JDK 1.7
* Apache Ant 1.9.x


### Directory Structure

* **usas/batch/src** : Source code directory for DSS web service client and interface
* **usas/batch/lib** : Library directory for dependency


### Build Instruction

1. In the build machine, download the project repository files.

1. Open a command line, and change directory to `usas/batch` directory.

		cd usas/batch

1. Using a text editor, open `usastaff.properties` file, and modify the JDK location in the following property.

		jdk.home.1.7=<full_path_to_jdk_home_dir>

1. In the command line, run ANT build script.

		ant package.exejar

1. Capture the generated module JAR file, configuration files, and shell script to run the module.

		usas/batch/dist/run-jar.sh
		usas/batch/dist/application.properties
		usas/batch/dist/report.properties
		usas/batch/dist/log4j.properties
		usas/batch/dist/usasdss-<version>.jar


### Deployment Instruction

1. Log in to the target environment server as the BizFlow service owner (or sudo).

1. Create a directory where the USA Staffing Interface module will be installed.

	For example:

		mkdir -p <server_dir>/usas/

1. Copy the module JAR file and its dependent library JAR files.

	* From (build machine):
		* usas/batch/dist/*
	* To (target environment):
		* <server_dir>/usas/

1. Make sure the script has correct JAVA_HOME environment variable set.  Open and edit `run-jar.sh` script.

	JAVA_HOME=<path_to_java_runtime_home_dir>

1. Configure properties.  Open and edit `application.properties` file for the following entries.  There are many other properties, but the following entries are essential.

		target.datasource.url=
		target.datasource.username=
		target.datasource.password=
		cognos.username=
		cognos.password=
		cognos.namespace=
		cognos.url=


### Usage
The deployed module can be run on demand or as a stand alone application.  


For UNIX environment, make the run script executable.

	cd <server_dir>/usas
	chmod 744 run-jar.sh

For on-demand run, execute the shell script in command line.

	./run-jar.sh

For regular usage in server environment, it is expected to be executed periodically by a cron job.

	crontab -e

		# USA Staffing Batch job
		40 20 * * * /bin/sh <server_dir>/usas/run-jar.sh




## USA Staffing Interface (Web)
USA Staffing Interface module is to pull HR related data from USA Staffing site through Data Self Service (DSS) web service call.

In order to call DSS web service, there should be an existing report created for the data collection.  DSS provides access to run the report remotely and capture the report output as XML format.

This is a web application module as opposed to batch job.  Therefore, it should be packaged as WAR and be deployed to a web server.


### Pre-requisite
* Identify the report to run in USA Staffing site.
* DSS account with credential to access the report in USA Staffing site.
* Target web server (Apache Tomcat 8)
* JDK 1.7
* Apache Ant 1.9.x


### Directory Structure

* **usas/web/src** : Source code directory for DSS web service client and interface
* **usas/web/lib** : Library directory for dependency


### Build Instruction

1. In the build machine, download the project repository files.

1. Open a command line, and change directory to `usas/web` directory.

		cd usas/web

1. Using a text editor, open `usasrwsc.properties` file, and modify the JDK location in the following property.

		jdk.home.1.7=<full_path_to_jdk_home_dir>

1. In the command line, run ANT build script.

		ant

1. Capture the generated module JAR file, configuration files, and shell script to run the module.

		usas/web/dist/usasrwsc-<version>.war


### Deployment Instruction

1. Log in to the target environment server as the BizFlow service owner (or sudo).

1. Copy the module WAR file to the designated web application (i.e., `tomcat/webapps`) directory.  Make sure exclude the version number part of the WAR file since the file name will become the application context name.

	* From (build machine):
		* usas/web/dist/usasrwsc-\<version\>.war
	* To (target environment):
		* <webapps_dir>/usasrwsc.war

1. Wait until the web application is fully deployed.  You may watch that the `usasrwsc` directory is created under the web application directory, and check properties file under it.

		<tomcat_dir>/webapps/usasrwsc
		<tomcat_dir>/webapps/usasrwsc/WEB-INF/classes/application.properties

1. Configure properties.  Open and edit `application.properties` file for the following entries.  There are many other properties, but the following entries are essential.

		server.url=
		credentials.namespace=
		credentials.username=
		credentials.password=


### Usage
The deployed module can be accessed by web service call with the designated service URL and parameters. For example, 

		http://localhost:8080/usasrwsc/usas/reportXML/appointment/{requestNumber}
		http://localhost:8080/usasrwsc/usas/reportXML/recruitment/{requestNumber}
		http://localhost:8080/usasrwsc/usas/reportHTML/applicantnotification/{vacancyNumber}
		http://localhost:8080/usasrwsc/usas/reportHTML/applicantroster/{vacancyNumber}

Replace the protocol, server DNS name, port, and report identifying information as appropriate.
