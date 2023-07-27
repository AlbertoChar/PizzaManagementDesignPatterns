# PizzaManagementDesignPatterns
Application of OOP design patterns and SOLID principles in a pizza management system w/ Java

# Pizza Place Management System

## Introduction

The Pizza Place Management System is a Java project that simulates a pizza restaurant's management system. It allows users to order various types of pizzas, add toppings, and manage the preparation process. The project uses design patterns to achieve modularity and flexibility in creating different pizza types and handling customer orders.

## Features

- Create different types of pizzas, including Margherita, Pepperoni, Gourmet Margherita, and Gourmet Pepperoni.
- Add toppings to pizzas using the decorator pattern.
- Manage the pizza preparation process with status updates.
- Implement different eating strategies for customers (Eat-In or Take-Away) using the strategy pattern.
- Utilize the Abstract Factory pattern to create pizzas through a unified interface.
- Use the Template Method pattern to define the preparation process for different pizza types.

## Design Patterns Used

- **Abstract Factory Pattern**: The project uses the Abstract Factory pattern to provide a unified interface for creating different types of pizzas without exposing the concrete implementation details. The `PizzaFactoryInterface` serves as the abstract factory, and the `PizzaFactory` and `GourmetFactory` are concrete implementations responsible for creating regular and gourmet pizzas respectively.

- **Decorator Pattern**: The Decorator pattern is employed to add toppings to pizzas without modifying their original classes. The `PizzaDecorator` class is the base decorator, and concrete decorator classes such as `OlivesDecorator` and `EggplantDecorator` add toppings to pizzas.

- **Strategy Pattern**: The Strategy pattern is used to implement different eating strategies for customers. The `EatStrategy` interface defines the common eating strategy, and the `EatIn` and `TakeAway` classes are concrete implementations of this interface for eating in the restaurant or taking the pizza away.

- **Template Method Pattern**: The Template Method pattern is applied to define the preparation process for different pizza types. The `Pizza` class acts as the template, with abstract methods `preparePizza()`, `addExtras()`, and `bakePizza()` that are implemented by the concrete pizza subclasses (e.g., `MargheritaPizza`, `PepperoniPizza`, `GourmetMargherita`, `GourmetPepperoni`). This allows for a standardized pizza preparation flow while enabling customization in each pizza type's implementation.
