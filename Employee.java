public abstract class Employee implements Payable {

    private int id;
    private String name;
    private String email;

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public abstract double calculateSalary();

    public abstract String getEmployeeType();

    public String toFileString() {
        return id + "," + name + "," + email + "," + getEmployeeType() + "," + String.format("%.2f", calculateSalary());
    }

    public String displayDetails() {
        return "ID: " + id +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nType: " + getEmployeeType() +
                "\nSalary: " + String.format("%.2f", calculateSalary());
    }
}
