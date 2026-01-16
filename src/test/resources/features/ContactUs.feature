@ContactUs
Feature: Verifying the Contact Us page

  Background: When I open the browser

  @smoke
  Scenario: Contact Us Page
    When I added URL 'https://automationexercise.com/'
    Then I should able to see the homepage
    And I navigate to the contactus page
    When I enter the following details in the contact form
      | name    | shiva           |
      | email   | shiva@gmail.com |
      | subject | text            |
      | message | Hello !!!       |
    And I upload the file 'C:\\Users\\Swapna\\OneDrive\\Documents\\Agile Foundation.docx'
    And I click on the submit button
    Then I should see the success message 'Success! Your details have been submitted successfully.'
    And I click on the Home button
    #Then I should be navigated to the Home page
