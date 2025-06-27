                        CHALLENGE LITERALURA
                 desafio propuesto por Alura Latam

    LiterAluralatina es una aplicación de consola diseñada para interactuar con la API 
    de Gutendexy gestionar una colección local de libros y autores.
    Este proyecto te permite buscar, registrar y consultar información sobre libros
    y sus autores clasicos españoles y latinos de una manera y eficiente.

    Tecnologías Utilizadas

    〇 Java 17+: Lenguaje de programación principal del proyecto.

    〇 Spring Boot: Framework que facilita la creación de aplicaciones Java empresariales,  
                    proporcionando una base sólida y una configuración simplificada.

    〇 Maven: Herramienta de automatización de construcción y gestión de dependencias.

    〇 PostgreSQL: Sistema de gestión de bases de datos relacional robusto y de código
                   abierto, utilizado para persistir la información de libros y autores
                   localmente.
    〇 Spring Data JPA: Abstracción de JPA (Java Persistence API) que simplifica la  
                        implementación de las capas de acceso a datos, interactuando 
                        con PostgreSQL.
    〇 Jackson: Librería utilizada internamente por Spring Boot para la serialización y
                deserialización de objetos Java a/desde JSON (Data Transfer Objects).

__________________________________________________________________________________________________________ 

    Estructura del Proyecto

    El proyecto sigue una estructura de paquetes organizada para mantener la modularidad
    y la separación de responsabilidades:

    〇 com.aluracursos.literalura_latina: 
    Agrupa los paquetes, mantiene la modularidad, la implementacion y funcionalidad del
    programa.
        ◯ LiteraluraLatinaApplcacion: contiene las interfases e implementaciones para 
                                      dar partida al programa implementado con  
                                      CommandLineRunner, creando librorepo y autorrepo 
                                      los que interectuan para acceder a la clase Principal
                                      y desplegar el menu de inicio. 

    〇com.aluracursos.literalura_latina.principal: 
    Agrupa la lógica de negocio específica para cada funcionalidad que el usuario puede 
    ejecutar desde el menú.
        ◯ Principal: Presenta el menú al usuario y delega las operaciones a los procesos 
                     correspondientes.

        ◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊
                MENU DE LIBROS
        ◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊
            1 - Buscar Libro en la Web
            2 - Mostrar los Libros buscados
            3 - Buscar Libro por titulo
            4 - Lista de Libros Registrados
            5 - Lista de Autores Registrados
            6 - Buscar un Libros por su Idioma
            7 - Lista de Autores vivos en un año determinado
            0 - Salir
        ◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊
        Elija una opción:
        """;   
        
    〇com.aluracursos.literalura_latina.model: 
    Define las entidades de la base de datos local de la aplicación.
 
        ◯ Autor: Entidad que representa a un autor, mapeada a una tabla en PostgreSQL.
     
        ◯ Libro: Entidad que representa un libro, mapeada a una tabla en PostgreSQL.
     
        ◯ Datos: Almacena las clases DTO (Data Transfer Objects) que modelan la estructura
                 de los datos intercambiados con la API externa (Gutendex).
     
        ◯ DatosAutor: Captura la informacion del autor desde Gutendex y la almacena en la  
                      base de datos PostgreSQL.
     
        ◯ DatosLibros: Captura la informacion del libro desde Gutendex y la almacena en la 
                       base de datos PostgreSQL.
     
        ◯Libro: Potencia la gestión de libros y autores para almacenar lis listas relacionadas.

    〇com.aluracursos.literalura_latina.repository:
    Contiene las interfaces de los repositorios de datos que interactúan con la   base 
    de   datos PostgreSQL.
 
      ◯ AutorRepository: Interface de Spring Data JPA para operaciones CRUD y consultas 
                         sobre la entidad del Autor.
      
      ◯ LibroReposiroty: Interface de Spring Data JPA para operaciones CRUD y consultas 
                         sobre la entidad del
                         Libro.

    〇com.aluracursos.literalura_latina.service.
    Alberga la lógica de negocio principal y coordina las operaciones entre los clientes 
    de API y los 
      repositorios de datos. 
 
       ◯ ConsumoAPI: Interfaz que define el contrato para el cliente y realiza la 
                     implementación concreta 
                     de Gutendex que utiliza para las llamadas a la API.
       
       ◯ ConvierteDatos: Implementacion y mapeo de la optencion de datos
       
--------------------------------------------------------------------------------------------  

    Configuración y Ejecución

    〇 Clonar el repositorio:
        git clone [https://github.com/Claudio-62/challenge-literAlura-latina]
        cd challenge-literAlura-latina

    〇 Configurar PostgreSQL:
         Asegúrate de tener una instancia de PostgreSQL (pgAdmin 4) en ejecución.
        Crea una base de datos llamada literalura_latina.
        Verifica tus credenciales de base de datos (username, password) en
        src/main/resources/application.properties y ajústalas si es necesario.

    〇 Compilar y Ejecutar:
        Puedes ejecutar la aplicación desde tu IDE (IntelliJ IDEA) ejecutando la clase 
        LiteraturaLatinaApplication.
        Alternativamente, desde la línea de comandos, navega hasta la raíz del proyecto y usa 
        Maven:
                mvn spring-boot:run

    Una vez que la aplicación se inicie, se mostrará el menú donde podrás interactuar con las 
    diferentes opciones.

----------------------------------------------------------------------------------------------

    Características

    〇 Búsqueda de Libros y Autores: Consulta la colección de Gutendex por título o autor.
    〇 Registro Local: Preserva los libros y autores encontrados en tu base de datos  PostgreSQL.
    〇 Listados: Visualiza todos los libros y autores registrados localmente.
    〇 Filtrado de Autores: Encuentra autores que estuvieron vivos en un año específico.   
    〇 Libros por Idioma: Lista libros filtrados por idioma, tanto de Gutendex y registrados.

    ◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊
        PROYECTO CREADO POR  CLAUDIO-62
    ◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊◊