Feature: Testing example

    @dev
    Scenario: Query google DEV
        When I hit search query "search?q=test"
        Then I want to get result

    @prod
    Scenario: Query google PROD
        When I hit search query "search?q=test"
        Then I want to get result


