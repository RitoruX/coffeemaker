Feature: Purchasing some beverages

  Background:
    Given Coffee maker wait for a user input.
    
    Scenario: Common purchase a beverage
      When I want to purchase a Coffee
      And  I give coffee maker 100
      Then I get money 50 back
      
    Scenario: Purchase a beverage with has not in recipe
      When I want to purchase a Mojito
      And  I give coffee maker 100
      Then I get money 100 back
      
    Scenario: Purchase a beverage that hasn't enough ingredients
      When I want to purchase a Latte
      And  I give coffee maker 100
      Then I get money 100 back
      
    Scenario: Purchase a beverage with not enough money
      When I want to purchase a Americano
      And  I give coffee maker 10
      Then I get money 10 back