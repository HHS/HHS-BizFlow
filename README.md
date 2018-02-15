# HHS BizFlow HR Tracking System Common Modules

Modules

- **database** : HHS BizFlow common database script.
- **jdbcconn** : JDBC Connection test tool.
- **persondirectory** : Person Directory interface where user information is pulled from PSC Locator database onto BizFlow database.
- **usastaff** : USA Staffing interface where report data from USA Staffing site onto HHS common database. 


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





## Person Directory Interface
This module is to pull HHS empoyee directory information into BizFlow user profile database table.  

Note: Once the user profile information is imported, BizFlow system administrator will need to manually maintain license assignment, authority group assignment, and user group assignment through BizFlow Administration menu.



## USA Staffing Interface
USA Staffing Interface module is to pull HR related data from USA Staffing site through Data Self Service (DSS) web service call.

In order to call DSS web service, there should be an existing report created for the data collection.  DSS provides access to run the report remotely and capture the report output as XML format.


### Pre-requisite
* Identify the report to run in USA Staffing site.
* DSS account with credential to access the report in USA Staffing site.
* JDK 1.7
* Apache Ant 1.9.x


### Directory Structure

* **usastaff/src** : Source code directory for DSS web service client and interface
* **usastaff/lib** : Library directory for dependency


### Build Instruction

1. In the build machine, download the project repository files.

1. Open a command line, and change directory to `usastaff` directory.

		cd usastaff

1. Using a text editor, open `usastaff.properties` file, and modify the JDK location in the following property.

		jdk.home.1.7=<full_path_to_jdk_home_dir>

1. In the command line, run ANT build script.

		ant

1. Capture the generated module JAR file as well as dependent library JAR files.

		usastaff/dist/lib/usastaffdss.jar
		usastaff/dist/lib/*.jar


### Deployment Instruction

1. Log in to the target environment server as an administrator (or sudo).

1. Create a directory where the USA Staffing Interface module will be installed.

	For example:

		mkdir -p <server_dir>/usastaff/

1. Copy the module JAR file and its dependent library JAR files.

	* From (build machine):
		* usastaff/dist/lib/*.jar
	* To (target environment):
		* <server_dir>/usastaff/


### Usage
The deployed module can be run on demand as a stand alone application.  For on-demand run, assuming that the module is already built by ANT script following the build instruction above, you may use ANT script with run target.

	ant run

For regular usage in server environment, it is expected to be executed periodically by a cron job.
