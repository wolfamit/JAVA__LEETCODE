import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume the newline character

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();sc.nextLine(); // consume the newline character
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine(); // consume the newline character
            char d = sc.nextLine().charAt(0);
            double e = sc.nextDouble();
            employees[i] = new Employee(a, b, c, d, e);
        }
        int age = sc.nextInt();
        sc.nextLine(); // consume the newline character
        Employee[] ans1 = getEmployeeWithSecondLowestSalary(emp);
        if(ans1!=null)
        {
            for(int i=0; i<ans1.length; i++)
            {
                System.out.println(ans1[i].getId()+"#"+ans1[i].getName());
            }
        }
        else
        {
            System.out.println("Null");
        }
        int ans2 = countEmployeesBasedOnAge(emp,age);
        if(ans2!=0)
        {
            System.out.println(ans2);
        }
        else
        {
            System.out.println("No employee found for the given age");
        }
    }


    // This method returns an array of Employee objects with the second lowest salary.
    // If there is no second lowest salary, it returns null.
     public static Employee[] getEmployeeWithSecondLowestSalary(Employee[] e)
    {
        Employee[] det = new Employee[0];
        if(e.length>1)
        {
            // Sort the employees based on their salary in ascending order
            for(int i=0; i<e.length; i++)
            {
                for(int j=i; j<e.length; j++)
                {
                    if(e[i].getSalary()>e[j].getSalary())
                    {
                        Employee k = e[i];
                        e[i] = e[j];
                        e[j] = k;
                    }
                }
            }
            Employee min = e[0];
            // Find the second lowest salary
            // Copy all of them in the det array of Employee objects
            for(int i=0; i<e.length; i++)
            {
                if(e[i].getSalary()>e[0].getSalary())
                {
                    det = Arrays.copyOf(det, det.length+1);
                    det[det.length-1] = e[i];
                    break;
                }
            }
           // find all the unique employees with the second lowest salary
            for(int i=0; i<e.length; i++)
            {
                if(det[0].getSalary() == e[i].getSalary() && e[i].getId()!= det[0].getId())
                {
                    det = Arrays.copyOf(det, det.length+1);
                    det[det.length-1] = e[i];
                }
            }
            return det;
        }        
        return null;    
    }

    // This method counts the number of employees with a specific age.
    // It returns the count of employees with that age.
    public static int countEmployeesBasedOnAge(Employee[] e, int a)
    {
        int count = 0;
        for(int i=0; i<e.length; i++)
        {
            if(e[i].getAge()==a)
            {
                count++;
            }
        }
        return count;
    }

}

class Employee{
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;

    public Employee(int employeeId, String employeeName, int age,char gender, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }

}
