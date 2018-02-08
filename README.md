# HHS BizFlow HR Tracking System Common Modules

Modules

- **psclocator** : PSC Locator interface where user information is pulled from PSC Locator database onto BizFlow database.
- **usastaff** : USA Staffing interface where report data from USA Staffing site onto HHS common database. 

## PSC Locator Interface




## USA Staffing Interface
USA Staffing Interface module is to pull HR related data from USA Staffing site through Data Self Service (DSS) web service call.

In order to call DSS web service, there should be an existing report created for the data collection.  DSS provides access to run the report remotely and capture the report output as XML format.


### Pre-requisite
* Identify the report to run in USA Staffing site.
* DSS account with credential to access the report in USA Staffing site.
* JDK 1.7
* Apache Ant 1.9.x or later


### Directory Structure

* **usastaff/src** : Source code directory for DSS web service client and interface
* **usastaff/lib** : Library directory for dependency


### Build Instruction

1. Using a text editor, open build.xml file, and modify the JDK location in the following property.


1. Open command line, and run ANT.

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
The deployed module can be run on demand as a stand alone application.

For regular usage in server environment, it is expected to be executed periodically by a cron job.
