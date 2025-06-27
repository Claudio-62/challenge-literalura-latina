                 CHALLENGER LITERALURA,
                 desafio propuesto por Alura Latam

LiterAluralatina es una aplicación de consola diseñada para interactuar con la API de Gutendex y gestionar una colección local de libros y autores. Este proyecto te permite buscar, registrar y consultar información sobre libros y sus autores clasicos españoles y latinos de una manera sencilla y eficiente.

Tecnologías Utilizadas
  *Java 17+: Lenguaje de programación principal del proyecto.
  *Spring Boot: Framework que facilita la creación de aplicaciones Java empresariales,  proporcionando una base sólida y una configuración simplificada.
  *Maven: Herramienta de automatización de construcción y gestión de dependencias.
  *PostgreSQL: Sistema de gestión de bases de datos relacional robusto y de código abierto,  utilizado para persistir la información de libros y autores localmente.
  *Spring Data JPA: Abstracción de JPA (Java Persistence API) que simplifica la  implementación de las capas de acceso a datos, interactuando con PostgreSQL.
  *Jackson: Librería utilizada internamente por Spring Boot para la serialización y   deserialización de objetos Java a/desde JSON (Data Transfer Objects).

---------------------------------------------------------------------------------------------------------------------------

Estructura del Proyecto

El proyecto sigue una estructura de paquetes organizada para mantener la modularidad y la separación de responsabilidades:

**com.aluracursos.literalura_latina: 
  Agrupa los paquetes, mantiene la modularidad, la implementacion y funcionalidad del programa
    *LiteraluraLatinaApplcacion: contiene las interfases e implementaciones para dar partida al programa implementado con   CommandLineRunner, creando librorepo y autorrepo los que interectuan para acceder a la clase Principal y desplegar el          menu de inicio.  
**com.aluracursos.literalura_latina.principal: 
  Agrupa la lógica de negocio específica para cada funcionalidad que el usuario puede ejecutar desde el menú.
    *Principal: Presenta el menú al usuario y delega las operaciones a los procesos correspondientes.
        ![image](https://github.com/user-attachments/assets/cb75e16f-6d17-4b5a-a198-2e0448aa67c2)    
**com.aluracursos.literalura_latina.model: 
  Define las entidades de la base de datos local de la aplicación.
     *Autor: Entidad que representa a un autor, mapeada a una tabla en PostgreSQL.
     *Libro: Entidad que representa un libro, mapeada a una tabla en PostgreSQL.
     *Datos: Almacena las clases DTO (Data Transfer Objects) que modelan la estructura de los datos intercambiados con la API externa (Gutendex).
     *DatosAutor: Captura la informacion del autor desde Gutendex y la almacena en la  base de datos PostgreSQL.
     *DatosLibros: Captura la informacion del libro desde Gutendex y la almacena en la base de datos PostgreSQL.
     *Libro: Potencia la gestión de libros y autores para almacenar lis listas relacionadas. 
**com.aluracursos.literalura_latina.repository:
  Contiene las interfaces de los repositorios de datos que interactúan con la   base de   datos PostgreSQL.
      *AutorRepository: Interface de Spring Data JPA para operaciones CRUD y consultas sobre la entidad del Autor.  
      *LibroReposiroty: Interface de Spring Data JPA para operaciones CRUD y consultas sobre la entidad del Libro.
**com.aluracursos.literalura_latina.service.
  Alberga la lógica de negocio principal y coordina las operaciones entre los clientes de API y los repositorios de datos. 
       *ConsumoAPI: Interfaz que define el contrato para el cliente y realiza la implementación concreta de Gutendex que utiliza para las llamadas a la API.
       *ConvierteDatos: Implementacion y mapeo de la optencion de datos
       
----------------------------------------------------------------------------------------------------------------------  

  Configuración y Ejecución

1.-Clonar el repositorio:
    git clone [https://github.com/Claudio-62/challenge-literAlura-latina]
    cd challenge-literAlura-latina

2.-Configurar PostgreSQL:
    Asegúrate de tener una instancia de PostgreSQL (pgAdmin 4) en ejecución.
    Crea una base de datos llamada literalura_latina.
    Verifica tus credenciales de base de datos (username, password) en
    src/main/resources/application.properties y ajústalas si es necesario.

3.-Compilar y Ejecutar:
    Puedes ejecutar la aplicación desde tu IDE (IntelliJ IDEA) ejecutando la clase LiteraturaLatinaApplication.
    Alternativamente, desde la línea de comandos, navega hasta la raíz del proyecto y usa Maven:
                mvn spring-boot:run

  Una vez que la aplicación se inicie, se mostrará el menú donde podrás interactuar con las diferentes opciones.

---------------------------------------------------------------------------------------------------------------

Características

  * Búsqueda de Libros y Autores: Consulta la colección de Gutendex por título o autor.
  * Registro Local: Preserva los libros y autores encontrados en tu base de datos  PostgreSQL.
  * Listados: Visualiza todos los libros y autores registrados localmente.
  * Filtrado de Autores: Encuentra autores que estuvieron vivos en un año específico.   
  * Libros por Idioma: Lista libros filtrados por idioma, tanto de Gutendex y registrados.
