# 🧮 Java Calculator: CLI to GUI

A comprehensive Java project demonstrating the transition from a **Command-Line Interface (CLI)** to a modern **Graphical User Interface (GUI)**. This repository showcases progress in **Object-Oriented Programming (OOP)**, **MVC Architecture**, and **JavaFX development**.

---

## 🚀 Project Overview
This repository contains two versions of a calculator, each highlighting different software engineering principles:

1.  **v1.0 (CLI):** Focused on core logic, input validation, and console-based control flow.
2.  **v2.0 (GUI):** A modern desktop application built with **JavaFX** and **FXML**, featuring advanced state management and a responsive UI.

---

## ✨ Features

### 🖼️ GUI Version (v2.0)
* **MVC Architecture:** Clean separation of concerns between Logic (`MathProcessor`), UI (`FXML`), and Event Handling (`Controller`).
* **Persistent History:** Interactive `TextArea` that tracks and displays the last **10 results** using an optimized array-shifting algorithm.
* **Smart Editing:**
    * **Backspace (`<-`):** Character-by-character deletion for precise corrections.
    * **Sign Toggle (`+/-`):** Instant negation/sign-switching logic.
* **Industry-Ready UI:** Fixed window scaling (`setResizable(false)`), centered screen placement, and specialized error handling for division by zero.

### ⌨️ CLI Version (v1.0)
* **Keyboard Commands:** Support for Reset (`!`), Terminate (`#`), and History view (`@`).
* **Robust Validation:** Comprehensive error handling for non-numeric entries and zero-division.
* **Automated Exit:** Features a scheduled termination logic with a countdown timer.

---

## 🛠️ Tech Stack
* **Language:** Java 21
* **Framework:** JavaFX 21
* **Build Tool:** Maven
* **UI Design:** Gluon Scene Builder
* **IDE:** IntelliJ IDEA

---

## 📂 Project Structure
```text
.
├── CLI-Version/             # v1.0 Command Line code
│   ├── CalculatorApp.java   # Main entry point
│   ├── MathProcessor.java   # Arithmetic logic
│   └── CalStart.java        # Menu & History handling
│
└── GUI-Version/             # v2.0 JavaFX Maven project
    ├── src/main/java        # Controller and Logic classes
    └── src/main/resources   # FXML layout and assets
```
---

## ⚙️ How to Run

### GUI Version
1. Ensure you have Java 21 and Maven installed.
2. Navigate to the GUI-Version directory.
3. Run the following command:
```
mvn javafx:run
```
### CLI Version

1. Navigate to the CLI-Version directory.
2. Compile and run:
```
javac CalculatorApp.java
java CalculatorApp
```
