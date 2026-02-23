interface BonusCalculator {
    double getBonus();
}

abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void displayBasicInfo() {
        System.out.println("Nhân viên: " + name);
        System.out.printf("Lương cơ bản: %f VNĐ\n", baseSalary);
    }

    public abstract double calculateSalary();
}

class OfficeStaff extends Employee {

    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee implements BonusCalculator {
    private double kpiPercentage;

    public Manager(String name, double baseSalary, double kpiPercentage) {
        super(name, baseSalary);
        this.kpiPercentage = kpiPercentage;
    }

    @Override
    public double getBonus() {
        return baseSalary * kpiPercentage;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + getBonus();
    }
}

// 5. Lớp Main chạy thử nghiệm
public class Bai5 {
    public static void main(String[] args) {
        Employee staff = new OfficeStaff("Nguyễn Văn A", 10000000);
        Manager manager = new Manager("Trần Thị B", 20000000, 0.25);

        System.out.println(" BẢNG LƯƠNG NHÂN VIÊN VĂN PHÒNG");
        staff.displayBasicInfo();
        System.out.printf("Thưởng KPI: Không có\n");
        System.out.printf("Tổng lương nhận: %,.0f VNĐ\n", staff.calculateSalary());

        System.out.println("\n BẢNG LƯƠNG QUẢN LÝ ");
        manager.displayBasicInfo();
        System.out.printf("Thưởng KPI: %f VNĐ\n", manager.getBonus());
        System.out.printf("Tổng lương nhận: %f VNĐ\n", manager.calculateSalary());
    }
}