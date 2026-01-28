public class ContractEmployee extends Employee {

    private double contractAmount;

    public ContractEmployee(int id, String name, String email, double contractAmount) {
        super(id, name, email);
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculateSalary() {
        return contractAmount;
    }

    @Override
    public String getEmployeeType() {
        return "Contract";
    }
}
