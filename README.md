# proyecto-final-ad
Proyecto final de Primera Evaluación para la asignatura de Acceso a Datos

## Descripción
Este proyecto permite realizar consultas a las diferentes tablas que hay en la [Base de datos](codigo-java/Proyecto%20Final/company_database.db). También se realizarán 3 consultas que se han indicado en el enunciado del ejercicio.

### Tablas

- customers
- departments
- employee_projects
- employees_realistic
- order_items
- orders
- projects

### Consultas 

- Calcula los costos salariales por proyecto, suponiendo que el salario del empleador es anual y la cantidad de horas de trabajo es de 1900 por año.
- Combina esto con el presupuesto en la tabla de proyectos.
- Calcula qué fracción del presupuesto del proyecto representan los costos salariales.

## Estructura del proyecto
El proyecto está dividido en 2 carpetas

[Código de Java](/codigo-java)

[Página web](/pagina-web)

## Como instalar las dependencias del proyecto
Para instalar las dependencias de la página de [Astro](https://astro.build/) pondremos los siguientes comandos
```sh
npm install
```
Luego de instalar las dependencias de Astro instalaremos sqlite
```sh
npm install sqlite3
```
