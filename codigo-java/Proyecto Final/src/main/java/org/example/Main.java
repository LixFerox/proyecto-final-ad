package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> consultas=new ArrayList<String>();
    static String url="jdbc:sqlite:company_database.db";
    static boolean finDelPrograma=false;
    static String tabla="";

    public static void main(String[] args) {
        agregarConsultas();
        createDataBase();
    }
     public static void createDataBase(){
         System.out.println("Creando Base de Datos SQLite...");
         try ( Connection conn = DriverManager.getConnection(url)){
             Statement estado = conn.createStatement();
             System.out.println("Se ha conectado a la Base de Datos");
             Scanner teclado=new Scanner(System.in);
             do {
                 System.out.println("Selecciona una opción:\n-0: Salir\n-1: Tabla customers\n-2: Tabla departments\n-3: Tabla employee_projects\n-4: Tabla employees_realistic\n-5: Tabla order_items\n-6: Tabla orders\n-7: Tabla projects\n-c1: Consulta 1\n-c2: Consulta 2\n-c3: Consulta 3");
                 String opciones=teclado.nextLine();
                 switch (opciones.toUpperCase().trim()){
                     case "0":
                         estado.close();
                         conn.close();
                         finDelPrograma=true;
                         System.out.println("Has salido del programa!");
                         break;
                     case "1":
                         case1(estado);
                         break;
                     case "2":
                         case2(estado);
                         break;
                     case "3":
                         case3(estado);
                         break;
                     case "4":
                         case4(estado);
                         break;
                     case "5":
                         case5(estado);
                         break;
                     case "6":
                         case6(estado);
                         break;
                     case "7":
                         case7(estado);
                         break;
                     case "C1":
                         casec1(estado);
                         break;
                     case "C2":
                         casec2(estado);
                         break;
                     case "C3":
                         casec3(estado);
                         break;
                     default:
                         System.err.println("No has seleccionado ninguna opción");

                 }
             }while (!finDelPrograma);
             teclado.close();

         } catch (Exception e) {
             System.out.println("No se ha podido conectar con la Base de Datos");
         }
     }
     public static void case1(Statement estado) throws SQLException {
        tabla="customers";
        System.out.println("Viendo la tabla "+tabla);
         ResultSet resultado = estado.executeQuery("SELECT * FROM "+tabla);
         System.out.println("customer_id | customer_name       | contact_email        | contact_phone");
         System.out.println("------------------------------------------------------------------------");
         while(resultado.next()){
             int customer_id=resultado.getInt("customer_id");
             String customer_name=resultado.getString("customer_name");
             String contact_email=resultado.getString("contact_email");
             String contact_phone=resultado.getString("contact_phone");
             System.out.printf("%-12d | %-19s | %-20s | %-15s\n",
                     customer_id,
                     customer_name,
                     contact_email,
                     contact_phone);
         }
         System.out.println("------------------------------------------------------------------------");
         resultado.close();
    }
    public static void case2(Statement estado) throws SQLException {
        tabla="departments";
        System.out.println("Viendo la tabla "+tabla);
        ResultSet resultado = estado.executeQuery("SELECT * FROM "+tabla);
        System.out.println("department_id | department_name | manager_id");
        System.out.println("--------------------------------------------");
        while(resultado.next()){
            int department_id=resultado.getInt("department_id");
            String department_name=resultado.getString("department_name");
            int manager_id=resultado.getInt("manager_id");
            System.out.printf("%-14d | %-17s | %-10d\n",
                    department_id,
                    department_name,
                    manager_id);
        }
        System.out.println("--------------------------------------------");
        resultado.close();
    }
    public static void case3(Statement estado) throws SQLException {
        tabla="employee_projects";
        System.out.println("Viendo la tabla "+tabla);
        ResultSet resultado = estado.executeQuery("SELECT * FROM "+tabla);
        System.out.println("employee_id | project_id | hours_worked | employee_projects_id");
        System.out.println("---------------------------------------------------------------");
        while(resultado.next()){
           int employee_id=resultado.getInt("employee_id");
           int project_id=resultado.getInt("project_id");
           double hours_worked=resultado.getDouble("hours_worked");
           int employee_projects_id=resultado.getInt("employee_projects_id");
            System.out.printf("%-12d | %-10d | %-12.2f | %-19d\n",
                    employee_id,
                    project_id,
                    hours_worked,
                    employee_projects_id);
        }
        System.out.println("---------------------------------------------------------------");
        resultado.close();
    }
    public static void case4(Statement estado) throws SQLException {
        tabla="employees_realistic";
        System.out.println("Viendo la tabla "+tabla);
        ResultSet resultado = estado.executeQuery("SELECT * FROM "+tabla);
        System.out.println("employee_id | first_name | last_name | department_id | hire_date  | salary    | position           | employees_realistic_id");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        while(resultado.next()){
            int employee_id=resultado.getInt("employee_id");
            String first_name=resultado.getString("first_name");
            String last_name=resultado.getString("last_name");
            int department_id=resultado.getInt("department_id");
            String hire_date=resultado.getString("hire_date");
            double salary=resultado.getDouble("salary");
            String position=resultado.getString("position");
            int employees_realistic_id=resultado.getInt("employees_realistic_id");
            System.out.printf("%-12d | %-11s | %-9s | %-13d | %-10s | %-9.2f | %-18s | %-22d\n",
                    employee_id,
                    first_name,
                    last_name,
                    department_id,
                    hire_date,
                    salary,
                    position,
                    employees_realistic_id);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        resultado.close();
    }
    public static void case5(Statement estado) throws SQLException {
        tabla="order_items";
        System.out.println("Viendo la tabla "+tabla);
        ResultSet resultado = estado.executeQuery("SELECT * FROM "+tabla);
        System.out.println("order_item_id | order_id | product_name                | quantity | price");
        System.out.println("--------------------------------------------------------------------------");
        while(resultado.next()){
            int order_item_id=resultado.getInt("order_item_id");
            int order_id=resultado.getInt("order_id");
            String product_name=resultado.getString("product_name");
            int quantity=resultado.getInt("quantity");
            double price=resultado.getDouble("price");
            System.out.printf("%-14d | %-8d | %-25s | %-8d | %-10.2f\n",
                    order_item_id,
                    order_id,
                    product_name,
                    quantity,
                    price);
        }
        System.out.println("--------------------------------------------------------------------------");
        resultado.close();
    }
    public static void case6(Statement estado) throws SQLException {
        tabla="orders";
        System.out.println("Viendo la tabla "+tabla);
        ResultSet resultado = estado.executeQuery("SELECT * FROM "+tabla);
        System.out.println("order_id | customer_id | order_date   | amount");
        System.out.println("----------------------------------------------");
        while(resultado.next()){
            int order_id=resultado.getInt("order_id");
            int customer_id=resultado.getInt("customer_id");
            String order_date=resultado.getString("order_date");
            double amount=resultado.getDouble("amount");
            System.out.printf("%-10d | %-12d | %-12s | %-12.2f\n",
                    order_id,
                    customer_id,
                    order_date,
                    amount);
        }
        System.out.println("----------------------------------------------");
        resultado.close();
    }
    public static void case7(Statement estado) throws SQLException {
        tabla="projects";
        System.out.println("Viendo la tabla "+tabla);
        ResultSet resultado = estado.executeQuery("SELECT * FROM "+tabla);
        System.out.println("project_id project_name department_id budget start_date end_date");
        System.out.println("project_id | project_name                | department_id | budget      | start_date   | end_date");
        System.out.println("------------------------------------------------------------------------------------------------");
        while(resultado.next()){
            int project_id=resultado.getInt("project_id");
            String project_name=resultado.getString("project_name");
            int department_id=resultado.getInt("department_id");
            double budget=resultado.getDouble("budget");
            String start_date=resultado.getString("start_date");
            String end_date=resultado.getString("end_date");
            System.out.printf("%-10d | %-25s | %-13d | %-12.2f | %-12s | %-12s\n",
                    project_id,
                    project_name,
                    department_id,
                    budget,
                    start_date,
                    end_date);
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        resultado.close();
    }
    public static void casec1(Statement estado) throws SQLException {
        System.out.println("Realizando la consulta 1");
        tabla="order_items";
        ResultSet resultado = estado.executeQuery(consultas.get(0));
        System.out.println("employee_id | first_name           | last_name           | total_salary");
        System.out.println("-----------------------------------------------------------------------");
        while(resultado.next()){
            int employee_id=resultado.getInt("employee_id");
            String first_name=resultado.getString("first_name");
            String last_name=resultado.getString("last_name");
            double total_salary=resultado.getDouble("total_salary");
            System.out.printf("%-12d | %-20s | %-20s | %-12.2f\n",
                    employee_id,
                    first_name,
                    last_name,
                    total_salary);
        }
        System.out.println("-----------------------------------------------------------------------");
        resultado.close();
    }
    public static void casec2(Statement estado) throws SQLException {
        System.out.println("Realizando la consulta 2");
        ResultSet resultado = estado.executeQuery(consultas.get(1));
        System.out.println("project_id | project_name                | budget      | total");
        System.out.println("--------------------------------------------------------------");
        while(resultado.next()){
            int project_id=resultado.getInt("project_id");
            String project_name=resultado.getString("project_name");
            String budget=resultado.getString("budget");
            double total=resultado.getDouble("total");
            System.out.printf("%-10d | %-25s | %-12s | %-10.2f\n",
                    project_id,
                    project_name,
                    budget,
                    total);
        }
        System.out.println("--------------------------------------------------------------");
        resultado.close();
    }
    public static void casec3(Statement estado) throws SQLException {
        System.out.println("Realizando la consulta 3");
        ResultSet resultado = estado.executeQuery(consultas.get(2));
        System.out.println("project_id | project_name                | budget      | total        | project_fraction");
        System.out.println("----------------------------------------------------------------------------------------");
        while(resultado.next()){
            int project_id=resultado.getInt("project_id");
            String project_name=resultado.getString("project_name");
            String budget=resultado.getString("budget");
            double total=resultado.getDouble("total");
            double project_fraction=resultado.getDouble("project_fraction");
            System.out.printf("%-10d | %-25s | %-12s | %-12.2f | %-15.2f\n",
                    project_id,
                    project_name,
                    budget,
                    total,
                    project_fraction);
        }
        System.out.println("----------------------------------------------------------------------------------------");
        resultado.close();
    }
    public static void agregarConsultas(){
        String consulta1="SELECT employee_projects.employee_id, employees_realistic.first_name, employees_realistic.last_name, ROUND((employees_realistic.salary/1900)*employee_projects.hours_worked) AS total_salary " +
                "FROM employee_projects " +
                "INNER JOIN employees_realistic " +
                "ON employee_projects.employee_id=employees_realistic.employee_id " +
                "ORDER BY employee_projects.employee_id ASC";
        String consulta2="SELECT projects.project_id, projects.project_name, projects.budget, ROUND(SUM((employees_realistic.salary/1900)*employee_projects.hours_worked)) AS total " +
                "FROM employee_projects " +
                "INNER JOIN employees_realistic " +
                "ON employee_projects.employee_id=employees_realistic.employee_id " +
                "INNER JOIN projects " +
                "ON employee_projects.project_id=projects.project_id " +
                "GROUP BY projects.project_name " +
                "ORDER BY projects.project_id ASC";
        String consulta3="SELECT projects.project_id, projects.project_name, projects.budget, ROUND(SUM((employees_realistic.salary/1900)*employee_projects.hours_worked)) AS total,  ROUND(SUM((employees_realistic.salary/1900)*employee_projects.hours_worked)/projects.budget) AS project_fraction " +
                "FROM employee_projects " +
                "INNER JOIN employees_realistic " +
                "ON employee_projects.employee_id=employees_realistic.employee_id " +
                "INNER JOIN projects " +
                "ON employee_projects.project_id=projects.project_id " +
                "GROUP BY projects.project_name " +
                "ORDER BY projects.project_id ASC";

        consultas.add(consulta1);
        consultas.add(consulta2);
        consultas.add(consulta3);
    }
}