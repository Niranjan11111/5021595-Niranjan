class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            Employee emp = employees[i];
            System.out.println(emp.getEmployeeId() + " " + emp.getName() + " " + emp.getPosition() + " " + emp.getSalary());
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                // Shift elements to the left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Adding employees
        ems.addEmployee(new Employee("1", "John Doe", "Manager", 80000));
        ems.addEmployee(new Employee("2", "Jane Smith", "Developer", 70000));
        ems.addEmployee(new Employee("3", "Mike Johnson", "Analyst", 60000));

        // Traversing employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Searching for an employee
        Employee emp = ems.searchEmployee("2");
        if (emp != null) {
            System.out.println("Found Employee: " + emp.getName() + " " + emp.getPosition() + " " + emp.getSalary());
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        ems.deleteEmployee("2");
        System.out.println("Employees after deletion:");
        ems.traverseEmployees();
    }
}
