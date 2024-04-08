# Barbering Shop

Barbering Shop is a simple Java console application that simulates the operations of a barber shop owned by Mr. Johnson. The shop has a main chair for hair trimming and five waiting chairs. The shop serves two types of clients: ordinary customers (ORD) and VIP customers. Each customer is labeled with an index, such as ORD1, ORD2 for ordinary customers, and VIP1, VIP2 for VIP customers.

## Problem Description

The seating and movement of customers follow specific rules:

1. If both main and waiting chairs are empty, the incoming client sits in the main chair.
2. If the main chair is occupied, incoming clients sit in the waiting chairs in their arrival order. If no chair is available, the client leaves and comes back later.
3. If a VIP client comes in and the main chair is occupied, they sit in the first waiting chair, causing any seated ORD client and others to shift backward by one seat.
4. If a VIP is already in the queue, the next VIP takes a seat after the last VIP.
5. When the barber finishes with the client in the main chair, the next client in chair No. 1 takes their place, and the rest shift successively to occupy the next chairs.
6. After getting their hair trimmed, clients leave and do not return to the shop.

## User Interaction

The user interacts with the console application by pressing the space key. Each press generates a random event:

- If x = 0: The barber finishes trimming the current client's hair.
- If x = 1: A VIP client enters the shop and takes a seat.
- If x = 2 or x = 3: An ordinary client enters the shop and takes a seat.
- If all seats are occupied and x > 0: A client enters the shop but leaves because no seats are available.

Each event is displayed in a new line in the format: `x ---> ( event ) [ sitting order of clients in the shop ]`. If the user presses any key other than space, the program ends.

To interact with the application, run it and press the space key followed by the enter key to move to the next event.

## Demo

Below shows a demo of the application after 20 simulations:

![Barbering Shop Demo](simulation.jpg)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

- JDK 11 or later
- IntelliJ IDEA 2023.3.6 or any other IDE that supports Java

### Installing and Running

A step by step series of examples that tell you how to get a development environment running:

1. Clone the repository:
    ```
    git clone https://github.com/MawuliB/BarberingShop.git
    ```
2. Navigate to the project directory:
    ```
    cd BarberingShop
    ```
3. Open the project in your preferred IDE (IntelliJ IDEA recommended).
4. Build the project (usually there's a build option in the IDE).
5. Run the main class or the class with the main method.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/MawuliB/BarberingShop/blob/main/LICENSE.md) file for details