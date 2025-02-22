Feature: Elements Test

  Scenario: Element navigation test
    Given I am on demo site
    When I click Elements
    Then I am on Elements page
    When I click TextBox
    Then I am on TextBox page
    When I complete the form
    |FullName|Email      |CurrentAddress|ParmanentAddress|
    | Joe    |abc@abc.com| abc street   | abc street     |