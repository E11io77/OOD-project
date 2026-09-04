# OOD Project
This project is a project within the Object Oriented Design course.
The goal is to design a menu-driven console program handling product management, material management, calculation of the environmental impact and lastly providing recycling guidance.
The author of the project is Elliott Knotek, based on a group work by: Adrián Carrillo Jordán, Elliott Knotek, Flavio Colangelo and Osikoya Omotoyosi Nelson.

## How to run:

For the program to start, we need to change the directory to acces the project (OOD-project\java-ood-project). Afterwards, `gradle run` shall be entered to run the program.

## Architectual Overview:

The application is structured using a layered architecture with the Presentation, Application and Domain Layer.

In the first Presentation layer we have the Menu class. This class facilitates the interaction between the user and system. It handles the display of menus and user choices.

The next Application layer consists of the ProductService class, RecyclingGuidanceService class and strategies WeightedByLifespan and SimpleSumStrategy, implementing the EnvironmentalImpactCalculator interface.
The Product, ProductRepository and Material classes exist in the Domain layer.
In the last Framework layer we have the DatabaseManager as we plan on using a database to hold the different products and materials (including its recycling guidance).

## Design pattern: Strategy

1. What problem did the pattern solve?
   The designed system should be able to calculate the environmental impact of a product. That is done in multiple way - SimpleSum and WeightedByLifespan. Withou a strategy, we would need  an else/if logic inside the productService and Product. In that way, every new calculation method would bring a new modification of the exising code. However, that would violate the Open Close Principle.
2. Why was the pattern appropriate?
  Strategy is appropriate when multiple algorithms share the same purpose 
and should be interchangeable without modifying the caller.
3. What improved?
   ProductService never changes when a new strategy is introduced. In addition, the Product class has no knowledge of any calculation logic. Each of the calculation strategies can be tested in isolation.
6. What would happen without it?
  The productService would have a growing if(else logic that would not be as easy to read, would complicate testing and maintaning the code.

## Handling Mixed-material products:

Products can contain one or more materials. In case of a product being made out of multiple materials:    the RecyclingGuidance shows the product's materials and lists its category and instructions of each material.
   the environmental impact is calculated in such a way where all material impact values are either summed or summed and divided by lifespan (depending on the strategy chosen).
   
Thanks to this approach, the system simulates real-world recycling practice where mixed-material 
products must be taken apart to recycle each material separately.

## Sequence diagram:
As a part of Week 10, a sequence diagram has been created via https://sequencediagram.org/. The ProductMenu is the key player in the creation of new products, calling other classes, obtaining result and so on. First the system asks the user to add basic information about the product, calling MaterialService to receive the list of materials, showing it to the user so they can choose from the selection. This continues in a loop until a "D" key is entered. Afterwards ProductMenu creates the new product with its new attributes, forwarding it then to the ProductService, adding it to the ProductRepository. ProductMenu then creates a message for the user, informing them of the action completion.

## Link to diagrams:

[Diagram link](Diagram.png)

[Sequence diagram link](sequenceDiagram.png)
