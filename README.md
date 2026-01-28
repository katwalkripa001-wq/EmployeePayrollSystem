Java OOP Employee Payroll System

## Description
This is a Java-based Employee Payroll System developed using Object-Oriented Programming (OOP) principles. 
The system supports Full-Time, Part-Time, and Contract employees and calculates salaries accordingly.

## OOP Concepts Used
- Abstraction: abstract Employee class
- Inheritance: FullTimeEmployee, PartTimeEmployee, ContractEmployee inherit from Employee
- Polymorphism: calculateSalary method is overridden in each subclass
- Interface: Payable interface implemented by Employee
- Encapsulation: private data members with getters

## Features
- Add Full-Time, Part-Time, and Contract Employees
- Salary calculation based on employee type
- Save and load employee records from a file
- Input validation and custom exception handling
- Console-based user interface

## Technologies Used
- Java
- IntelliJ IDEA
- File Handling
- GitHub

## How to Run
1. Open the project in IntelliJ IDEA
2. Run `PayrollSystem.java`
3. Follow the console menu to add/view employees

## Sample Output
- Employee details printed on console
- Records stored in `employee_data.txt` file

## Future Enhancements
- GUI implementation
- Database integration
- Update and delete employee records
