package day13.solid.srp;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

// 급여 계산
class PayCalculator {
    public double calculatePay(Employee employee) {
        return employee.getSalary() * 0.05;
    }
}

// db 저장
class EmployeeRepository {
    public void save(Employee employee) {
        System.out.println("직원 정보를 저장합니다: " + employee.getName() + " " + employee.getSalary() + " ... 저장완료! ");
    }
}

// 보고서 생성
class ReportGenerator {
    public String generate(Employee employee) {
        String report = "보고서 내용: ... \n작성자: " + employee.getName();

        return report;
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp = new Employee("Kim", 5000);

        PayCalculator payCalc = new PayCalculator();
        EmployeeRepository repo = new EmployeeRepository();
        ReportGenerator reportGen = new ReportGenerator();

        double pay = payCalc.calculatePay(emp);
        repo.save(emp);
        String report = reportGen.generate(emp);

        System.out.println("실수령액: " + pay);
        System.out.println(report);
    }
}