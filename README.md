# ood-project
This project is a project within the Object Oriented Design course.
The goal is to design a menu-driven console program handling product management, material management, calculation of the environmental impact and lastly providing recycling guidance.
The author of the project is Elliott Knotek, based on a group work by: Adrián Carrillo Jordán, Elliott Knotek, Flavio Colangelo and Osikoya Omotoyosi Nelson.

Architectual Decisions:
In the first Presentation layer we have the Menu class. This class holds the UI through which the user interacts with the app.
The next Application layer consists of the ProductService class, RecyclingGuidanceService class and strategies WeightedByLifespan and SimpleSumStrategy, implementing the EnvironmentalImpactCalculator interface.
The Product, ProductRepository and Material classes exist in the Domain layer.
In the last Framework layer we have the DatabaseManager as we plan on using a database to hold the different products and materials (including its recycling guidance).
