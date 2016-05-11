## Introduction - Fluently Functional BDD Tests (with Cucumber JVM and Fluentlenium)  
 
- This is light starter framework that makes use of Cucumber and Fluentlenium.
- Cucumber provides the Given, When, Then in our test cases whereas Fluentlenium provides easier DOM interactions and navigation.
- Fluentlenium leverages Selenium with Page Object Pattern, so a Page Object for every screen. 
- Ensure to provide ID attribute in HTML tags to facilitate testing.

## Chrome Driver 
- Chrome driver included in the project is ChromeDriver 2.21 and resides in src/main/resources. 
-  It supports Chrome version v46-50. For other versions, please replace accordingly.

## Firefox Driver 
- Chrome driver included in the project is ChromeDriver 2.21 and resides in src/main/resources. 
-  It supports Chrome version v46-50. For other versions, please replace accordingly.


## Cucumber Tests

- Amend the application.properties file to use the appropriate Web Driver i.e. Firefox, HTMLUnit 
- Simply run "uk.gov.dwp.rti.spec.RunFunctionalTest" from the IDE or alternatively run "mvn test" from command prompt. 

## Running different profile
- We can specify whether to pick default properties or jenkins by issuing e.g. "-Dactive.profile=jenkins" and the system will 
  pick up corresponding "application-jenkins.properties" file.  

## Overriding options

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:
    mvn -Dcucumber.options="..." test

*IMPORTANT*
When you override options with `-Dcucumber.options`, you will completely override whatever options are hard-coded in
your `@CucumberOptions` or in the script calling `cucumber.api.cli.Main`. There is one exception to this rule, and that
is the `--plugin` option. This will not _override_, but _add_ a plugin. The reason for this is to make it easier
for 3rd party tools (such as [Cucumber Pro](https://cucumber.pro/)) to automatically configure additional plugins by appending arguments to a `cucumber.properties`
file.

### Run a subset of Features or Scenarios

Specify a particular scenario by *line* (and use the pretty plugin, which prints the scenario back)
    -Dcucumber.options="classpath:skeleton/belly.feature:4 --plugin pretty"

This works because Maven puts `./src/test/resources` on your `classpath`.
You can also specify files to run by filesystem path:
    -Dcucumber.options="src/test/resources/skeleton/belly.feature:4 --plugin pretty"

You can also specify what to run by *tag*:
    -Dcucumber.options="--tags @bar --plugin pretty"    

### Running only the scenarios that failed in the previous run

    -Dcucumber.options="@target/rerun.txt"
    (This works as long as you have the `rerun` formatter enabled.)

### Specify a different formatter:

For example a JUnit formatter:

    -Dcucumber.options="--plugin junit:target/cucumber-junit-report.xml"
    
    