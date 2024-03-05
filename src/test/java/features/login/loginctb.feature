Feature: Login to CTB
  As a user, I want to be able to log into the CTB

  Background:
    Given I go to login page


  @No-param @login
  Scenario: Successful login no param
    Given I enter my email and then click next page
    When I choose No i dont
    And I enter email and password
    And I sign on
    Then Go to landing page
    And Display My Gabage

  @Param @login
  Scenario: Successful login with param
    And I enter my email "trang@gmail.com" and then click next page
    And I choose No i dont
    And I enter email "trang113@yopmail.com" and password is "1234qwer"
    And I sign on
    Then Go to landing page
    And Display My Gabage



  @Datatable @login
  Scenario: Successful login datatable
    And I enter my email "trang@gmail.com" and then click next page
    And I choose No i dont
    And I enter email new email and password
    |email | password |
    |trang113@yopmail.com | 1234qwer |
    And I sign on
    Then Go to landing page
    And Display My Gabage

  @DataTestDrive @login
  Scenario Outline: Successful login datatable
    And I enter my email "trang@gmail.com" and then click next page
    And I choose No i dont
    And I enter email "<email>" and password is "<password>"
    And I sign on
    Then Go to landing page
    And Display My Gabage

    Examples:
      |email | password |
      |trang113@yopmail.com | 1234qwer |





