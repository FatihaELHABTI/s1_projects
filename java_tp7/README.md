# Multi-Threading Examples in Java

## General Idea on Threads
Threads are an essential feature of Java that allow programs to perform multiple tasks simultaneously. Threads enable the execution of concurrent operations within a single process, making applications more efficient, especially on multi-core processors. 

Using threads, developers can:
- Perform parallel computations.
- Improve responsiveness in applications by handling long-running tasks in the background.
- Divide large tasks into smaller, manageable units that can execute concurrently.

In Java, threads can be created by:
1. Extending the `Thread` class.
2. Implementing the `Runnable` interface.

This project provides examples of threads applied to two different problems.

---

## Exercise 1: Talkative Threads

### Problem Description
The goal is to create multiple threads, each of which outputs a specific number twice. The threads run concurrently, showcasing basic thread creation and execution.

### Code Explanation
- **`Talkative` Class**: Implements the `Runnable` interface. Each thread prints the shared static attribute value twice.
- **`Main` Class**: Creates and starts 10 threads, each initialized with a different integer value.

### Key Concepts Demonstrated
- Thread creation using the `Runnable` interface.
- Concurrent execution of multiple threads.

### Example Output
Threads may output their values in different orders due to concurrent execution. An example output could be:
```
10
10
10
10
...
10
10
```
The actual order depends on the thread scheduler.

---

## Exercise 2: Summing an Array with Threads

### Problem Description
The goal is to calculate the sum of an array using multiple threads. The array is divided into equal parts, and each thread computes the sum of its portion. The results are then combined for the total sum.

### Code Explanation
- **`Sommeur` Class**: Implements the `Runnable` interface. Each thread calculates the sum of a specific segment of the array.
- **`Main` Class**:
  - Initializes an array of integers from 1 to 100.
  - Divides the array into 4 equal parts.
  - Creates 4 threads, each assigned to sum a specific part of the array.
  - Waits for all threads to complete using `join()`.
  - Aggregates the results from all threads to calculate the total sum.

### Key Concepts Demonstrated
- Dividing tasks among threads.
- Synchronization using `join()` to ensure all threads finish before proceeding.
- Aggregating results from multiple threads.

### Example Output
For an array of integers from 1 to 100, the output will be:
```
La somme totale du tableau est : 5050
```

---

## How to Run
1. Clone the repository and navigate to the project directory.
2. Compile the code using:
   ```bash
   javac package_name/*.java
   ```
   Replace `package_name` with `ex1` or `ex2` based on the exercise.
3. Run the program using:
   ```bash
   java package_name.Main
   ```

---

## Lessons Learned
These examples demonstrate:
- How to use threads for parallel execution.
- Managing thread lifecycle and synchronizing their results.
- Leveraging threads to improve computational efficiency.

