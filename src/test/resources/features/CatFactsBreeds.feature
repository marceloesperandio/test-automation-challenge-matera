Feature: Cat Facts Breeds API

  @functional_tests @positive_tests
  Scenario: Valid request with limit=20
    Given I send a GET request with limit 20
    Then the response status code should be 200
    And the breeds list should contain 20 items

  @functional_tests @positive_tests
  Scenario: Valid request with limit=5
    Given I send a GET request with limit 5
    Then the response status code should be 200
    And the breeds list should contain 5 items

  @functional_tests @positive_tests
  Scenario: Valid request with limit=1
    Given I send a GET request with limit 1
    Then the response status code should be 200
    And the breeds list should contain 1 item

  @functional_tests @negative_tests
  Scenario: Invalid request with negative limit
    Given I send a GET request with limit -1
    Then the response status code should not be 200

  @functional_tests @negative_tests
  Scenario: Invalid request with large limit
    Given I send a GET request with limit 10000
    Then the response status code should not be 200

  @functional_tests @negative_tests
  Scenario: Invalid request with limit as string
    Given I send a GET request with invalid string limit
    Then the response status code should not be 200