#Slowly scroll down to "Browse Help Topics" and Count the number of links that are not working on Amazon customer care page

Feature: Count the number of links that are not working on Amazon customer care page


  Scenario: Count the number of broken links
    Given the user is on Amazon homepage
    When the user clicks Customer Service button
    And the user scrolls down to "Browse Help Topics"
    And the user counts the number of links in Customer Service page
    And the user counts the number of links not working
    Then all pages are working 
