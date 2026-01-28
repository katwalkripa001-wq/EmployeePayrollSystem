import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println(" EMPLOYEE PAYROLL SYSTEM");
        System.out.println("===================================");

        int choice;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Add Contract Employee");
            System.out.println("4. View All Employees (From File)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> addFullTimeEmployee();
                    case 2 -> addPartTimeEmployee();
                    case 3 -> addContractEmployee();
                    case 4 -> viewEmployees();
                    case 5 -> System.out.println("Exiting... Thank you!");
                    default -> System.out.println("Invalid choice! Please choose 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
                choice = 0;
            }
        } while (choice != 5);

        sc.close();
    }

    private static void addFullTimeEmployee() {
        try {
            int id = inputInt("Enter ID: ");
            String name = inputString("Enter Name: ");
            String email = inputString("Enter Email: ");
            double basicSalary = inputDouble("Enter Basic Salary: ");
            double bonus = inputDouble("Enter Bonus: ");
            Employee emp = new FullTimeEmployee(id, name, email, basicSalary, bonus);
            FileManager.saveEmployee(emp);
            System.out.println("\nEmployee Added Successfully!");
            System.out.println(emp.displayDetails());
        } catch (InvalidInputException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: Unable to save employee!");
        }
    }

    private static void addPartTimeEmployee() {
        try {
            int id = inputInt("Enter ID: ");
            String name = inputString("Enter Name: ");
            String email = inputString("Enter Email: ");
            int hours = inputInt("Enter Hours Worked: ");
            double rate = inputDouble("Enter Rate Per Hour: ");
            Employee emp = new PartTimeEmployee(id, name, email, hours, rate);
            FileManager.saveEmployee(emp);
            System.out.println("\nEmployee Added Successfully!");
            System.out.println(emp.displayDetails());
        } catch (InvalidInputException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: Unable to save employee!");
        }
    }

    private static void addContractEmployee() {
        try {
            int id = inputInt("Enter ID: ");
            String name = inputString("Enter Name: ");
            String email = inputString("Enter Email: ");
            double contractAmount = inputDouble("Enter Contract Amount: ");
            Employee emp = new ContractEmployee(id, name, email, contractAmount);
            FileManager.saveEmployee(emp);
            System.out.println("\nEmployee Added Successfully!");
            System.out.println(emp.displayDetails());
        } catch (InvalidInputException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: Unable to save employee!");
        }
    }

    private static void viewEmployees() {
        try {
            ArrayList<String> employees = FileManager.loadEmployees();
            if (employees.isEmpty()) {
                System.out.println("\nNo employee records found.");
                return;
            }
            System.out.println("\n----- EMPLOYEES LIST (From File) -----");
            System.out.println("Format: ID,Name,Email,Type,Salary\n");
            for (String emp : employees) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("File Error: Unable to load employees!");
        }
    }

    private static int inputInt(String msg) throws InvalidInputException {
        System.out.print(msg);
        String input = sc.nextLine();
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) throw new InvalidInputException("Value must be greater than 0.");
            return value;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid integer number.");
        }
    }

    private static double inputDouble(String msg) throws InvalidInputException {
        System.out.print(msg);
        String input = sc.nextLine();
        try {
            double value = Double.parseDouble(input);
            if (value < 0) throw new InvalidInputException("Value cannot be negative.");
            return value;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid decimal number.");
        }
    }

    private static String inputString(String msg) throws InvalidInputException {
        System.out.print(msg);
        String input = sc.nextLine();
        if (input.trim().isEmpty()) {
            throw new InvalidInputException("This field cannot be empty.");
        }
        return input;
    }
}
