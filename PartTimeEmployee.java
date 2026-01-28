public class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double ratePerHour;

    public PartTimeEmployee(int id, String name, String email, int hoursWorked, double ratePerHour) {
        super(id, name, email);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * ratePerHour;
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time";
    }
}
