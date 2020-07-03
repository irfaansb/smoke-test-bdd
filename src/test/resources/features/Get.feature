Feature: Smoke Test
  @SmokeTest
  Scenario Outline: Smoke Test for GET Endpoint of PetId
    Given API is up and running
    When I validate Response code"<ID>"
 #   Then Validate Response body
    Examples:
    |         ID                |
    | 8815634192425159          |


    Scenario Outline: Smoke Test for POST Endpoint of CreateUser API
      Given User API is up and running
      When I submit a request to create an user
      Then I validate Response code"<Response Code>"

      Examples:
      |Response Code|
      |    200      |

