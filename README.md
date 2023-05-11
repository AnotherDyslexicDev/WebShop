WebShop
WebShop es una aplicación web desarrollada en Java utilizando las tecnologías Spring MVC 5.3.3, Hibernate 5.4.1 Final, Bootstrap y JavaScript. El objetivo de la aplicación es proporcionar una plataforma genérica para la gestión de tiendas en línea.

Requisitos
JDK 8 o superior / preferente 17
Maven 3.6.3 o superior/preferente 5.X.X
Instalación
Clonar el repositorio:
bash
Copy code
git clone https://github.com/tu-usuario/WebShop.git
Ejecutar el script database.sql en una base de datos MySQL para crear las tablas necesarias para la aplicación.

Configurar los parámetros de conexión a la base de datos en el archivo application.properties que se encuentra en la ruta src/main/resources.

Compilar la aplicación:

go
Copy code
mvn clean package
Ejecutar la aplicación:
Copy code
java -jar target/WebShop-0.0.1-SNAPSHOT.jar
Acceder a la aplicación en un navegador web en la dirección http://localhost:8080.webshop
Funcionalidades:
Login
Agregar productos al carrito.
procesar pagos.
finalizar pago
Registro de usuarios. #pendiente
Autenticación de usuarios. #pendiente
Gestión de productos. #pendiente
Gestión de carritos de compra.
Realización de pedidos.
Envío de correos electrónicos de confirmación de pedidos.

BD
El script de creacion de la BD tiene tambien los insert de prueba mientras no esta listo el modulo de administracion.

Contribuciones
¡Las contribuciones son bienvenidas! Siéntete libre de enviar pull requests o reportar problemas en el repositorio de GitHub.


