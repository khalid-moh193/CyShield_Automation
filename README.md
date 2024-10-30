Project Documentation
=====================

![CyShield_logo](src/main/resources/CyShield_logo.PNG)

### Maven project using TestNG, selenium, Appium driver and RestAssured with POM design pattern and Allure reporting

Overview
--------

This project contains automation for:

1. **todo website** using Selenium, Java, and Maven.

2. **SFA Android app** using Appium, Java, and Maven.

3. **reqres APIs** using java and RestAssured

Prerequisites
-------------

Before starting the setup, ensure the following are installed:

1. **Java Development Kit (JDK)**

    * Download and install JDK 8 or higher
      from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

    * Verify installation by running
   > * java -version

2. **Maven**

    * Download and install Apache Maven from [here](https://maven.apache.org/download.cgi).

    * After installation, verify by running:
   > * mvn -version

3. **IDE (e.g., IntelliJ IDEA or Eclipse)**

    * Install any Java IDE of your choice to work with the project.

4. **Node.js & Appium**

    * Install Node.js (required for Appium):
   > * https://nodejs.org/

    * Install Appium globally via npm
   > * npm install -g appium

    * Start the Appium server (this is handled programmatically, no need to do it manually)
   > * appium


5. **Android SDK & AVD Manager (For Appium)**

    * Download Android Studio from [here](https://developer.android.com/studio).

    * Set up an Android emulator via Android Virtual Device (AVD) manager or connect a physical device with USB
      debugging enabled.

6. **Browser Drivers (For Selenium)**

    * ChromeDriver (for Chrome):Download the version matching your installed Chrome from here.

    * Place it in a directory and add it to your system’s PATH.

7. **Environment Variables**

    * Add the paths of JAVA\_HOME, MAVEN\_HOME, ANDROID\_HOME, and CHROME\_DRIVER (or other drivers) to your system’s
      environment variables.

Project Setup
-------------

1. Clone the repository Clone the repository from your version control system (GitHub):

2. **Open in IDE**Open the project in your IDE of choice (IntelliJ IDEA or Eclipse).

3. In case the dependencies are not downloaded automatically,

> mvn clean install

### Key Dependencies in pom.xml

Here are some key dependencies used in this project:

1. **Configure Test Execution**

    * For Mobile Automation: Ensure Android devices are configured and reachable via ADB.

2. **Run Tests**

   > 1- To Run Mobile tests:
   > ```bash
   > mvn test -Dsurefire.suiteXmlFiles="mobile.xml"

   > 2- To Run Web tests:
   >```bash
   >mvn test -Dsurefire.suiteXmlFiles="web.xml"
   >mvn test -Dsurefire.suiteXmlFiles="web.xml" -DenableHeadlessExecution="yes"

   > 3- To run on a parametrized build:
   > ```bash
   > mvn test -Dsurefire.suiteXmlFiles="mobile.xml" -DdeviceName="$deviceType" -DplatformVersion="$platformVersion"
   > Replace each "$" and write the desired information

   > 4- To Run APIs tests:
   >```bash
   >mvn test -Dsurefire.suiteXmlFiles="api.xml"

   > 5- To generate allure report run the following command line:
   > ```bash
   > allure serve
