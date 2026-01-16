@Testcases
Feature: Verifying the testcases page

  Background: When I open the browser

  @smoke
  Scenario: Test cases Page
    When I added URL 'https://automationexercise.com/'
    Then I should able to see the homepage
    And I navigate to the testcases page
    Then I should see all the test cases
