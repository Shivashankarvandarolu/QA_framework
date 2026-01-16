@login
Feature: Login to the applicaiton

  Background: When I open the browser

  @smoke
  Scenario: Login Flow with Valid
    When I added URL 'https://automationexercise.com/'
    Then I should able to see the homepage
    And I navigate to the New User Signup page
    And I enter email 'ssgoud96+test3@gmail.com' in log in email address
    And I enter password 'test1234'
    Then I click on the login button
    And I should be able to see the name 'Shiva Shankar Goud'

  Scenario: Logout
    When I log out of the application
    Then I should see the Signup/Login page

  Scenario: Login with invalid credintials
    And I navigate to the New User Signup page
    When I am on Login or Sign up Page
    And I enter email 'ssgoud96+test3@gmail.com' in log in email address
    And I enter password 'test12345'
    Then I click on the login button
    Then I should see a login error validation message
