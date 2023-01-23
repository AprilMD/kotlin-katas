# Kotlin TDD Starter
A sample project for getting started with TDD in Kotlin.

The file _src/test/kotlin/CalculatorTest.kt contains one test case and a few in comments.
Start by coming up with a few test cases and add them to the lists,
then implement them one at a time,
test-driving the solution forwards.

## Tools

Uses Gradle for the build system and JUnit 5 as the test runner.

Run the tests with:
```shell
./gradlew test
```

If you want to rerun passed tests for some reason you may need to run 
```shell
./gradlew cleanTest
```

first since Gradle caches the test results.


