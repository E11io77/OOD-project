# ood-project
This project is a project within the Object Oriented Design course.
The goal is to design a menu-driven console program handling product management, material management, calculation of the environmental impact and lastly providing recycling guidance.
The author of the project is Elliott Knotek, based on a group work by: Adrián Carrillo Jordán, Elliott Knotek, Flavio Colangelo and Osikoya Omotoyosi Nelson.

Architectual Decisions:

The application is structured using a layered architecture with the Presentation, Application and Domain Layer.

In the first Presentation layer we have the Menu class. This class facilitates the interaction between the user and system. It handles the display of menus and user choices.

The next Application layer consists of the ProductService class, RecyclingGuidanceService class and strategies WeightedByLifespan and SimpleSumStrategy, implementing the EnvironmentalImpactCalculator interface.
The Product, ProductRepository and Material classes exist in the Domain layer.
In the last Framework layer we have the DatabaseManager as we plan on using a database to hold the different products and materials (including its recycling guidance).

Design pattern: Strategy

1. What problem did the pattern solve?
   The designed system should be able to calculate the environmental impact of a product. That is done in multiple way - SimpleSum and WeightedByLifespan. Withou a strategy, we would need  an else/if logic inside the productService and Product. In that way, every new calculation method would bring a new modification of the exising code. However, that would violate the Open Close Principle.
2. Why was the pattern appropriate?
  Strategy is appropriate when multiple algorithms share the same purpose 
and should be interchangeable without modifying the caller.
3. What improved?
   ProductService never changes when a new strategy is introduced. In addition, the Product class has no knowledge of any calculation logic. Each of the calculation strategies can be tested in isolation.
6. What would happen without it?
  The productService would have a growing if(else logic that would not be as easy to read, would complicate testing and maintaning the code.
