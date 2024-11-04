# Handling Exceptions
# Exercice 1
# Vehicule and TropViteException Exercise

This exercise involves creating a custom exception, `TropViteException`, and a `Vehicule` class to test and throw this exception based on speed. The objective is to handle excessive speed cases and print the stack trace when the exception is triggered.

## Exercise Requirements

1. **TropViteException Class**:
   - This class inherits from `Exception`.
   - It contains no attributes.
   - Its constructor takes an integer as a parameter and calls the superclass constructor with the message:  
     `"C'est une exception de type TropViteException. Vitesse en cause : " + vitesse`.

2. **Vehicule Class**:
   - This class has no attributes.
   - It includes an empty constructor.
   - It provides a single method `testVitesse(int vitesse)` that throws a `TropViteException` if `vitesse > 90`.

3. **Execution**:
   - A `main` method in the `Vehicule` class creates a `Vehicule` object and tests `testVitesse()` with two different speeds.
   - The stack trace is printed if `TropViteException` is thrown.

## Code Overview

### 1. `TropViteException` Class

![image_alt](https://github.com/lilyhabti/s1_projects/blob/main/java_tp3/src/ex1/imgs/cap1.PNGg)

### 2. `Vehicule` Class

![Vehicule Class](src/ex1/imgs/cap2.png)

### 3. Example of Execution

The `main` method tests `testVitesse` with two speeds, 80 and 100. Since 100 exceeds the speed limit, it triggers `TropViteException`, displaying the stack trace.

![Example of Execution](src/ex1/imgs/cap3.png)

---

This setup allows testing custom exception handling based on speed, showcasing how `TropViteException` is thrown and handled in Java.

