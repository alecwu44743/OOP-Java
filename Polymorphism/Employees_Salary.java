interface Employees{
    public double ernings();
    public void print();
}


class Employee implements Employees{
    public String firstName;
    public String lastName;
    public String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double ernings() {
        return 0;
    }

    public void print() {
        System.out.println("Employee: " + this.firstName + " " + this.lastName);
        System.out.println("Social Security Number: " + this.socialSecurityNumber);
        System.out.println("Earnings: " + this.ernings());
        System.out.println();
    }
}


class Salaried_Employee implements Employees{
    public String firstName;
    public String lastName;
    public String socialSecurityNumber;
    public double weeklySalary;

    public Salaried_Employee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.weeklySalary = weeklySalary;
    }

    public double ernings() {
        return this.weeklySalary;
    }

    public void print() {
        System.out.println("Salaried Employee: " + this.firstName + " " + this.lastName);
        System.out.println("Social Security Number: " + this.socialSecurityNumber);
        System.out.println("Weekly Salary: " + this.weeklySalary);
        System.out.println("Earnings: " + this.ernings());
        System.out.println();
    }
}


class Commission_Employee implements Employees{
    public String firstName;
    public String lastName;
    public String socialSecurityNumber;
    public double grossSales;
    public double commissionRate;

    public Commission_Employee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double ernings() {
        return this.grossSales * this.commissionRate;
    }

    public void print() {
        System.out.println("Commission Employee: " + this.firstName + " " + this.lastName);
        System.out.println("Social Security Number: " + this.socialSecurityNumber);
        System.out.println("Gross Sales: " + this.grossSales);
        System.out.println("Commission Rate: " + this.commissionRate);
        System.out.println("Earnings: " + this.ernings());
        System.out.println();
    }
}


class BasePlus_Commission_Employee implements Employees{
    public String firstName;
    public String lastName;
    public String socialSecurityNumber;
    public double grossSales;
    public double commissionRate;
    public double baseSalary;

    public BasePlus_Commission_Employee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        this.baseSalary = baseSalary;
    }

    public double ernings() {
        return this.grossSales * this.commissionRate + this.baseSalary;
    }

    public void print() {
        System.out.println("Base Plus Commission Employee: " + this.firstName + " " + this.lastName);
        System.out.println("Social Security Number: " + this.socialSecurityNumber);
        System.out.println("Gross Sales: " + this.grossSales);
        System.out.println("Commission Rate: " + this.commissionRate);
        System.out.println("Base Salary: " + this.baseSalary);
        System.out.println("Earnings: " + this.ernings());
        System.out.println();
    }
}


public class Employees_Salary{
    public static void main(String[] args) {
        Employees[] employees = new Employees[10];

        employees[0] = new Employee("Alec", "Wu", "111-11-1111");
        employees[1] = new Salaried_Employee("Evelyn", "Chen", "222-22-2222", 800);
        employees[2] = new Commission_Employee("Grace", "Huang", "333-33-3333", 10000, 0.06);
        employees[3] = new BasePlus_Commission_Employee("Rong Rong", "Liu", "444-44-4444", 5000, 0.04, 300);
        employees[4] = new Employee("Miyuki", "Chen", "111-11-1111");
        employees[5] = new Salaried_Employee("Alana", "Wang", "222-22-2222", 800);
        employees[6] = new Commission_Employee("Claire", "Chang", "333-33-3333", 10000, 0.06);
        employees[7] = new BasePlus_Commission_Employee("OOOO", "Chen", "444-44-4444", 5000, 0.04, 300);
        employees[8] = new Employee("Ariel", "Yang", "111-11-1111");
        employees[9] = new Salaried_Employee("Leo", "Chen", "222-22-2222", 800);

        for (Employees employee : employees) {
            employee.print();
        }
    }
}