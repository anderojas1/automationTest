@UserRegistration
Feature: user registration on utest page
  As a tester
  I want to sign up on utest
  So that I become a new freelance software tester

  @SuccessfulUserRegistration
  Scenario Outline: successful user registration
    Given I opened the utest page
    When I register my personal information <name> <last_name> <email> <birth_month> <birth_day> <birth_year>
    And I register my location
    And I register my devices information for software testing
    And I create my account password <password>
    Then I should be redirected to welcome page <url_page> and copy <copy> is displayed

    Examples:
    |name|last_name|email                |birth_month|birth_day|birth_year|password      |url_page|copy|
    |"Antoine"|"Large"|"example@aadd.com"|"January"      |"8"     |"1989"    |"myPassword1@U" |"https://www.utest.com/welcome?from=signup"     |"Welcome to the world's largest community of freelance software testers!"|