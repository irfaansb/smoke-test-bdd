Feature: Smoke Test

  @SmokeTest
    Scenario Outline: Smoke Test for POST Endpoint of CreateUser API
      Given User API is up and running
      When I submit a request to create an user
     Then I validate Response "<Response Code>"
      Examples:
      |Response Code|
      |    200      |

  @SmokeTest
  Scenario Outline: Smoke Test for GET Endpoint of PetId
    Given API is up and running
    When I validate Response code"<UserName>"
    Then Validate Response code "<Response Code>"
    Examples:
      |        UserName               | Response Code   |
      |        talent12               |        200      |

  @SmokeTest
  Scenario Outline: Smoke Test for PUT Endpoint of CreateUser API
    Given User API is up and running
    When I submit a request to update a "<user>"
    Then I validate Response "<Response Code>"
    Examples:
      |Response Code| user        |
      |    200      | talent12    |

  @SmokeTest
  Scenario Outline: Smoke Test for DELETE Endpoint of CreateUser API
    Given User API is up and running
    When I submit a request to delete a "<user>"
    Then I validate Response "<Response Code>"
    Examples:
      |Response Code| user        |
      |    200      | talent12    |

