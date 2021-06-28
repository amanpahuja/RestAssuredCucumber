# RestAssuredCucumber

This is Rest Assured Cucumber Framework for Get Quotes APIs.
The structure for a Test case is as below:

1. Go to src/test/resources/features folder . This contains the feature file having Scenarios and test data as examples
2. Go to src/test/java/stepDefinitions folder. This contains all the step definitions for the steps written in scenarios.
3. Src/test/java/runner folder - This contains the Runner file for th Cucumber framework.
4. Go to src/main/java/CoreFunctions/GetQuotes/triggers folder. This contains the Interface functions and their implementations
5. Go to src/main/java/CoreFunctions/GetQuotes/services folder. This contains the methods related to specific API
6. Go to src/main/java/CoreComponents/Common folder. This contains the common functions used within the framework like RestUtil,AssertUtil etc.
7. Go to src/main/java/CoreComponents/Cucumber or managers folder. This contains the Test Context and is the managers for core functions when called in definition files.
8. Go to src/test/resources/jsonSchema folder. This contains the json schema for the response to be verified.

The High level:
1. Creating a feature file with tags like filters used for this api.
2. Having the implementation of the steps with folder structure which can be used with complex api count as well.
3. Verifying the json schema for the api response as validation
4. Valdiations for the specific inputs made with the response.
5. Running the steps with multiple data scenarios having positive and negative test cases.

Reports:
1. Run command : mvn clean verify [It will run all the test cases] if specific tags required then (mvn test -DcucumberOptions="--tags @tagname")
2. Under target/cucumber-html-report folder there will be html file named "report-feature_file-src-test-resources-features-getQuotes-feature.html"
3. Open this html in any Browser.


**API INVENTORY QUESTION:**
The question for all the Test sceanrios to be written is preent in **Inventory API Test Scenarios** folder within the project.
