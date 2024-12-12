package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean finDelPrograma=false;
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        do {
            System.out.println("Selecciona una opción:\n-0: Salir\n-1: Tabla customers\n-2: Tabla departments\n-3: Tabla employee_projects\n-4: Tabla employees_realistic\n-5: Tabla order_items\n-6: Tabla orders\n-7: Tabla projects\n-c1: Consulta 1\n-c2: Consulta 2\n-c3: Consulta 3");
            String opciones = teclado.nextLine();
            switch (opciones.toUpperCase().trim()) {
                case "0":
                    finDelPrograma = true;
                    System.out.println("Has salido del programa!");
                    break;
                case "1":
                    case1();
                    break;
                case "2":
                    case2();
                    break;
                case "3":
                    case3();
                    break;
                case "4":
                    case4();
                    break;
                case "5":
                    case5();
                    break;
                case "6":
                    case6();
                    break;
                case "7":
                    case7();
                    break;
                case "C1":
                    casec1();
                    break;
                case "C2":
                    casec2();
                    break;
                case "C3":
                    casec3();
                    break;
                default:
                    System.err.println("No has seleccionado ninguna opción");

            }
        } while (!finDelPrograma);
        teclado.close();
    }
    private static void case1() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customers.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String table = "FROM Customers";
        Query<Customers> query = sesion.createQuery(table, Customers.class);
        List<Customers> customersList = query.getResultList();
        System.out.println("customer_id | customer_name       | contact_email        | contact_phone");
        System.out.println("------------------------------------------------------------------------");
        for (Customers customer : customersList) {
            System.out.printf("%-12d | %-19s | %-20s | %-15s\n",
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getContactEmail(),
                    customer.getContactPhone());
        }
        System.out.println("------------------------------------------------------------------------");
        factory.close();
    }

    private static void case2() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Departments.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String table = "FROM Departments";
        Query<Departments> query = sesion.createQuery(table, Departments.class);
        List<Departments> departmentsList = query.getResultList();
        System.out.println("department_id | department_name | manager_id");
        System.out.println("--------------------------------------------");
        for (Departments department : departmentsList) {
            System.out.printf("%-14d | %-17s | %-10d\n",
                    department.getDepartmentId(),
                    department.getDepartmentName(),
                    department.getManagerId());
        }
        System.out.println("--------------------------------------------");
        factory.close();
    }
    private static void case3() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeProjects.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String table = "FROM EmployeeProjects";
        Query<EmployeeProjects> query = sesion.createQuery(table, EmployeeProjects.class);
        List<EmployeeProjects> employeeProjectsList = query.getResultList();
        System.out.println("employee_id | project_id | hours_worked | employee_projects_id");
        System.out.println("---------------------------------------------------------------");
        for (EmployeeProjects employeeProject : employeeProjectsList) {
            System.out.printf("%-12d | %-10d | %-12.2f | %-19d\n",
                    employeeProject.getEmployeeId(),
                    employeeProject.getProjectId(),
                    employeeProject.getHoursWorked(),
                    employeeProject.getEmployeeProjectsId());
        }
        System.out.println("---------------------------------------------------------------");
        factory.close();
    }

    private static void case4() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeRealistic.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String table = "FROM EmployeeRealistic";
        Query<EmployeeRealistic> query = sesion.createQuery(table, EmployeeRealistic.class);
        List<EmployeeRealistic> employeeRealisticsList = query.getResultList();
        System.out.println("employee_id | first_name | last_name | department_id | hire_date  | salary    | position           | employees_realistic_id");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (EmployeeRealistic employeeRealistic : employeeRealisticsList) {
            System.out.printf("%-12d | %-11s | %-9s | %-13d | %-10s | %-9.2f | %-18s | %-22d\n",
                    employeeRealistic.getEmployeeId(),
                    employeeRealistic.getFirstName(),
                    employeeRealistic.getLastName(),
                    employeeRealistic.getDepartmentId(),
                    employeeRealistic.getHireDate(),
                    employeeRealistic.getSalary(),
                    employeeRealistic.getPosition(),
                    employeeRealistic.getEmployeesRealisticId());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        factory.close();
    }

    private static void case5() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(OrderItems.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String table = "FROM OrderItems";
        Query<OrderItems> query = sesion.createQuery(table, OrderItems.class);
        List<OrderItems> orderItemsList = query.getResultList();
        System.out.println("order_item_id | order_id | product_name                | quantity | price");
        System.out.println("--------------------------------------------------------------------------");
        for (OrderItems orderItems : orderItemsList) {
            System.out.printf("%-14d | %-8d | %-25s | %-8d | %-10.2f\n",
                    orderItems.getOrderItemId(),
                    orderItems.getOrderId(),
                    orderItems.getProductName(),
                    orderItems.getQuantity(),
                    orderItems.getPrice());
        }
        System.out.println("--------------------------------------------------------------------------");
        factory.close();
    }

    private static void case6() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Orders.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String table = "FROM Orders";
        Query<Orders> query = sesion.createQuery(table, Orders.class);
        List<Orders> ordersList = query.getResultList();
        System.out.println("order_id | customer_id | order_date   | amount");
        System.out.println("----------------------------------------------");
        for (Orders orders : ordersList) {
            System.out.printf("%-10d | %-12d | %-12s | %-12.2f\n",
                    orders.getOrderId(),
                    orders.getCustomerId(),
                    orders.getOrderDate(),
                    orders.getAmount());
        }
        System.out.println("----------------------------------------------");
        factory.close();
    }

    private static void case7() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Projects.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String table = "FROM Projects";
        Query<Projects> query = sesion.createQuery(table, Projects.class);
        List<Projects> projectsList = query.getResultList();
        System.out.println("project_id | project_name                | department_id | budget      | start_date   | end_date");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (Projects projects : projectsList) {
            System.out.printf("%-10d | %-25s | %-13d | %-12.2f | %-12s | %-12s\n",
                    projects.getProjectId(),
                    projects.getProjectName(),
                    projects.getDepartmentId(),
                    projects.getBudget(),
                    projects.getStartDate(),
                    projects.getEndDate());
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        factory.close();
    }

    private static void casec1() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeRealistic.class).addAnnotatedClass(EmployeeProjects.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String consulta = "SELECT ep.employeeId, er.firstName, er.lastName, ROUND((er.salary / 1900) * ep.hoursWorked) AS totalSalary " +
                "FROM EmployeeProjects ep " +
                "INNER JOIN EmployeeRealistic er " +
                "ON ep.employeeId = er.employeeId " +
                "ORDER BY ep.employeeId ASC";

        Query<Object[]> query = sesion.createQuery(consulta);
        List<Object[]> query1List = query.getResultList();
        Iterator iterador = query1List.iterator();
        System.out.println("employee_id | first_name           | last_name           | total_salary");
        System.out.println("-----------------------------------------------------------------------");
        while(iterador.hasNext()){
            Object[] object = (Object[])iterador.next();
            int employeeId=(int)object[0];
            String firstName=(String)object[1];
            String lastName=(String)object[2];
            Double totalSalary=(Double) object[3];
            System.out.printf("%-12d | %-10s | %-9s | %-12.2f\n", employeeId, firstName, lastName, totalSalary);
        }
        System.out.println("-----------------------------------------------------------------------");
        factory.close();
    }
    private static void casec2() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeRealistic.class).addAnnotatedClass(EmployeeProjects.class).addAnnotatedClass(Projects.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String consulta2 = "SELECT p.projectId, p.projectName, p.budget, ROUND(SUM((er.salary / 1900) * ep.hoursWorked)) AS total " +
                "FROM EmployeeProjects ep " +
                "INNER JOIN EmployeeRealistic er ON er.id = ep.employeeId " +
                "INNER JOIN Projects p ON p.id = ep.projectId " +
                "GROUP BY p.projectName " +
                "ORDER BY p.projectId ASC";
        Query<Object[]> query = sesion.createQuery(consulta2);
        List<Object[]> query2List = query.getResultList();
        Iterator iterador = query2List.iterator();
        System.out.println("project_id | project_name                | budget      | total");
        System.out.println("--------------------------------------------------------------");
        while(iterador.hasNext()){
            Object[] object = (Object[])iterador.next();
            int projectId=(int)object[0];
            String projectName=(String)object[1];
            Double budget=(Double)object[2];
            Double total=(Double) object[3];
            System.out.printf("%-10d | %-25s | %-12s | %-10.2f\n", projectId, projectName, budget, total);
        }
        System.out.println("--------------------------------------------------------------");
        factory.close();
    }

    private static void casec3() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeRealistic.class).addAnnotatedClass(EmployeeProjects.class).addAnnotatedClass(Projects.class).buildSessionFactory();
        Session sesion = factory.getCurrentSession();
        sesion.beginTransaction();
        String consulta2 = "SELECT p.projectId, p.projectName, p.budget, ROUND(SUM((er.salary / 1900) * ep.hoursWorked)) AS total, ROUND(SUM((er.salary/1900)*ep.hoursWorked)/p.budget) AS project_fraction  " +
                "FROM EmployeeProjects ep " +
                "INNER JOIN EmployeeRealistic er ON er.id = ep.employeeId " +
                "INNER JOIN Projects p ON p.id = ep.projectId " +
                "GROUP BY p.projectName " +
                "ORDER BY p.projectId ASC";
        Query<Object[]> query = sesion.createQuery(consulta2);
        List<Object[]> query3List = query.getResultList();
        Iterator iterador = query3List.iterator();
        System.out.println("project_id | project_name                | budget      | total        | project_fraction");
        System.out.println("----------------------------------------------------------------------------------------");
        while(iterador.hasNext()){
            Object[] object = (Object[])iterador.next();
            int projectId=(int)object[0];
            String projectName=(String)object[1];
            Double budget=(Double)object[2];
            Double total=(Double) object[3];
            Double projectFraction=(Double) object[4];
            System.out.printf("%-10d | %-25s | %-12s | %-12.2f | %-15.2f\n", projectId, projectName, budget, total, projectFraction);
        }
        System.out.println("----------------------------------------------------------------------------------------");
        factory.close();
    }
}