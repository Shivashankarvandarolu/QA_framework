Feature: Signup to the applicaiton

Background: When I open the browser

Scenario: New User Signup

When I added URL 'https://automationexercise.com/'
Then I should able to see the homepage 
And I navigate to the New User Signup page
When I enter name 'Shiva Shankar'
And I enter email 'ssgoud96@gmail.com'
And I click on the Signup button
Then I should navigate to the signup page
And I entered details for creating an account





