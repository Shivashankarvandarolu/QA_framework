@login
Feature: Login to the applicaiton

  Background: When I open the browser

  Scenario: New User Signup
    When I added URL 'https://automationexercise.com/'
    Then I should able to see the homepage
    And I navigate to the New User Signup page
    And I enter email 'ssgoud96+test3@gmail.com'
    And I enter password 'test1234'
    Then I click on the login button
    And I should be able to see the name 'Shiva Shankar Goud'
    
