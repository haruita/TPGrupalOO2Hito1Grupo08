<div align="center">
  <h1>Sistema de gestión: "Epicentro Gourmet"</h1>
  <p><i>Orientación a Objetos II</i></p>

  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" alt="Hibernate" />
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />
</div>

<br>

> **Estudiantes:** Enrique Leandro Ariel, Martín Ruino, Yamil Miño y Santiago Saavedra.

## Descripción

El proyecto diseña y desarrolla un sistema de gestión integral para el centro de convenciones y predio ferial **Epicentro Gourmet**.

Su objetivo principal es optimizar la administración de sus festivales gastronómicos anuales, controlando las unidades de venta, el personal asignado, los pedidos, los platos ofrecidos y el rendimiento económico de cada jornada.

La aplicación fue desarrollada en Java y utiliza Hibernate para la persistencia de datos en una base de datos MySQL. Su arquitectura se divide en las capas de datos, acceso a datos (DAO) y lógica de negocio (ABM).

## Distribución del trabajo

| Integrante | Clases y funcionalidades principales |
|---|---|
| **Enrique Leandro Ariel** | `Persona`, `Cocinero`, `Cajero`, `PersonaDao` y `PersonaABM`. Altas de personal y consultas por sueldo y rango de nacimiento. |
| **Martín Ruino** | `Plato`, `ItemPlato`, `Pedido`, sus respectivos DAO y ABM. Gestión de platos, composición y consulta de pedidos. |
| **Yamil Miño** | `Festival`, `Costo`, `FestivalDao`, `CostoDao`, `FestivalABM` y `CostoABM`. Gestión de festivales, costos y consultas por fechas. |
| **Santiago Saavedra** | `UnidadDeVenta`, `FoodTruck`, `PuestoDesarmable`, `UnidadDeVentaDao` y `UnidadDeVentaABM`. Gestión de las unidades de venta del predio. |

## Ejecución paso a paso

### 1. Preparar MySQL

Iniciar el servidor MySQL y crear la base de datos que utilizará el proyecto:

```sql
CREATE DATABASE bd_sistema_festival;
```

La conexión se encuentra configurada en `src/hibernate.cfg.xml` con los siguientes valores predeterminados:

```text
Base de datos: bd_sistema_festival
Usuario: root
Contraseña: root
Puerto: 3306
```

Si la instalación local utiliza otras credenciales o puerto, modificar las propiedades `connection.url`, `connection.username` y `connection.password` de ese archivo.

### 2. Importar el proyecto

1. Abrir Eclipse.
2. Seleccionar **File > Import > General > Existing Projects into Workspace**.
3. Elegir la carpeta raíz del repositorio.
4. Verificar que las bibliotecas de `libs` estén presentes en el **Build Path**.

### 3. Comprobar la conexión y crear las tablas

Ejecutar `src/test/TestHBM.java` como **Java Application**.

Este test abre una sesión de Hibernate, verifica la conexión con MySQL y provoca la creación o actualización de las tablas mapeadas. Si la configuración es correcta, muestra `OK` en la consola.

### 4. Poblar la base de datos

Ejecutar primero `src/test/TestInserciones.java` como **Java Application**.

Este programa carga los datos necesarios para las pruebas: personas, platos, pedidos y los ítems que componen cada pedido. Debe ejecutarse sobre una base vacía para conservar los identificadores esperados y evitar registros duplicados.

### 5. Ejecutar los tests de casos de uso

Después de poblar la base, ejecutar las siguientes clases, una por una, como **Java Application**:

1. **`TestLeandroEnrique.java`**

   Consulta al personal ordenado de mayor a menor según su sueldo calculado y obtiene las personas nacidas dentro de un rango de fechas.

2. **`TestMartinRuino.java`**

   Consulta los pedidos realizados entre distintos rangos de fechas y presenta sus datos e ítems en tablas ASCII.

3. **`TestYamilMino.java`**

   Crea costos y festivales de prueba; luego consulta festivales vigentes en una fecha, festivales comprendidos en un período, sus unidades de venta y los esquemas de costos asociados.
