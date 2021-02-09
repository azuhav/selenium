Feature: Search ducks with Google

  Scenario Outline: Search ducks in the page text

    Given a user opens Google search page
    When the user performs <birds> search
    Then ducks are present on the search result page
    Examples:
      | birds |
    | ducks |


  Scenario Outline: Search ducks in links

    Given a user opens Google search page
    When the user performs <birds> search
    Then ducks are present on the link text
    Examples:
      | birds |
    | ducks |
