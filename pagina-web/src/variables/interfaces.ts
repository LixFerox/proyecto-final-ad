export interface Customer {
    customer_id: number;
    customer_name: string;
    contact_email: string;
    contact_phone: string;
}
export interface Departments {
    department_id: number;
    department_name: string;
    manager_id: number;
}
export interface EmployeeProjects {
    employee_id: number;
    project_id: number;
    hours_worked: number;
    employee_projects_id: number;
}
export interface EmployeesRealistic {
    employee_id: number;
    first_name: string;
    last_name: string;
    department_id: number;
    hire_date: string;
    salary: number;
    position: string;
    employees_realistic_id: number;
}
export interface OrderItems {
   order_item_id: number;
   order_id: number;
   product_name: string;
   quantity: number;
   price: number;
}
export interface Orders {
    order_id: number;
    customer_id: number;
    order_date: string;
    amount: number;
 }
 export interface Projects {
    project_id: number;
    project_name: string;
    department_id: number;
    budget: number;
    start_date: string;
    end_date: string;
 }
 export interface Query1 {
    employee_id: number;
    first_name: string;
    last_name: string;
    total_salary: number;
 }
 export interface Query2 {
    project_id: number;
    project_name: string;
    budget: number;
    total: number;
 }
 export interface Query3 {
    project_id: number;
    project_name: string;
    budget: number;
    total: number;
    project_fraction: number;
 }