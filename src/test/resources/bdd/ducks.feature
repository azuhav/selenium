Feature: Search ducks with Google

  Scenario: Search ducks in the page text

    Given a user opens Google search page
    When the user performs ducks search
    Then ducks are present on the search result page

  Scenario: Search ducks in links

    Given a user opens Google search page
    When the user performs ducks search
    Then ducks are present on the link text