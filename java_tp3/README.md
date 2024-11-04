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

![image_alt](https://github.com/lilyhabti/s1_projects/blob/main/java_tp3/src/ex1/imgs/cap1.PNG)

### 2. `Vehicule` Class

![image_alt](https://github.com/lilyhabti/s1_projects/blob/main/java_tp3/src/ex1/imgs/cap2.PNG)

### 3. Example of Execution

The `main` method tests `testVitesse` with two speeds, 80 and 100. Since 100 exceeds the speed limit, it triggers `TropViteException`, displaying the stack trace.

![image_alt](https://github.com/lilyhabti/s1_projects/blob/main/java_tp3/src/ex1/imgs/cap3.PNG)

---

This setup allows testing custom exception handling based on speed, showcasing how `TropViteException` is thrown and handled in Java.

# Exercice 2
# Square Root Exception Exercise

This exercise involves creating a custom exception, `RacineCarreeException`, and a `Calculateur` class to handle cases where an invalid square root operation is attempted (e.g., calculating the square root of a negative number). The goal is to throw and handle this exception when such cases arise.

## Exercise Requirements

1. **RacineCarreeException Class**:
   - This class inherits from `Exception`.
   - It contains no attributes.
   - Its constructor takes an integer as a parameter and calls the superclass constructor with the following message:  
     `"C'est une exception de type RacineCarreeException. Nombre négatif : " + number`.

2. **Calculateur Class**:
   - This class has no attributes.
   - It includes an empty constructor.
   - It provides a single method, `testRacineCarree(int number)`, which throws a `RacineCarreeException` if `number` is negative.

3. **Execution**:
   - The `main` method in the `Calculateur` class creates a `Calculateur` object and tests `testRacineCarree()` with two values: -5 and 25.
   - The stack trace is displayed if `RacineCarreeException` is thrown.

## Code Overview

### 1. `RacineCarreeException` Class

![RacineCarreeException Class](https://github.com/lilyhabti/s1_projects/blob/main/java_tp3/src/ex2/imgs/cap1.PNG)

### 2. `Calculateur` Class

![Calculateur Class](https://github.com/lilyhabti/s1_projects/blob/main/java_tp3/src/ex2/imgs/cap2.PNG)

### 3. Example of Execution

In the `main` method, `testRacineCarree` is called with values -5 and 25. Since -5 is negative, it triggers `RacineCarreeException`, displaying the stack trace.

![Example of Execution](https://github.com/lilyhabti/s1_projects/blob/main/java_tp3/src/ex2/imgs/cap3.PNG)

---

This exercise demonstrates custom exception handling in Java when dealing with invalid square root operations, such as attempting to calculate the square root of a negative number.



