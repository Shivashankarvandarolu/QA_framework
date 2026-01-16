@Registration
Feature: Signup to the applicaiton

  Background: When I open the browser

  Scenario: New User Signup
    When I added URL 'https://automationexercise.com/'
    Then I should able to see the homepage
    And I navigate to the New User Signup page
    When I enter name 'Shiva Shankar Goud'
    And I enter email 'ssgoud96+test3@gmail.com'
    And I click on the Signup button
    Then I should navigate to the signup page
    And I entered details for creating an account
      | title     | Mr         |
      | day       |          8 |
      | month     | November   |
      | year      |       1996 |
      | firstName | Shiva      |
      | lastName  | Goud       |
      | company   | ABC        |
      | address1  | Area 1     |
      | address2  | Area 2     |
      | country   | India      |
      | state     | Telangana  |
      | city      | Hyderabad  |
      | mobile    | 9999999999 |
      | password  | test1234   |
      | zipcode   |     509001 |
    Then verify the account creation is completed or not
    And I should be able to see the name 'Shiva Shankar Goud'

  Scenario: Try to signup with existing user and verify the text
    When I am on Login or Sign up Page
    When I enter name 'Shiva Shankar Goud'
    And I enter email 'ssgoud96+test3@gmail.com'
    And I click on the Signup button
    Then I should see a signup validation text message
