import java.util.Scanner;

class Employee {
    String name;
    int age;
    double basicPay, newPay;

    // Parameterized constructor
    Employee(String name, int age, double basicPay) {
        this.name = name;
        this.age = age;
        this.basicPay = basicPay;
    }

    // Method to calculate new basic pay
    void calculatePay() {
        if (age > 56)
            newPay = basicPay + (basicPay * 0.20);
        else if (age >= 46 && age <= 56)
            newPay = basicPay + (basicPay * 0.15);
        else
            newPay = basicPay + (basicPay * 0.10);
    }

    // Method to display details
    void display() {
        System.out.println("Employee Name : " + name);
        System.out.println("Age           : " + age);
        System.out.println("Basic Pay     : " + basicPay);
        System.out.println("New Basic Pay : " + newPay);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Basic Pay: ");
        double basicPay = sc.nextDouble();

        Employee emp = new Employee(name, age, basicPay);

        emp.calculatePay();
        emp.display();

        sc.close();
    }
}
