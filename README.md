Product Version: Apache NetBeans IDE version 24
https://netbeans.apache.org/front/main/download/nb24/
Java: 17.0.12 https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
Jar para conectar a la base de datos de Oracle ojdbc11.jar (Tiene que ir dentro de glasshfish
D:\Users\USER\Downloads\glassfish7\glassfish\lib en la carpeta de lib para cuando se haga el
pool de conexión todo funcione. ) https://www.oracle.com/database/technologies/appdev/jdbcdownloads.html
Version de Servidor: glassfish7 .
https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-7.0.23.zip

Agregamos el Server faces en la configuración del proyecto en frameworks.
Creación del pool de conexiones:
Entramos en http://localhost:4848/common/index.jsf y ahi buscamos jdbc
Creamos un pool y mas o menos deben de quedar estas conexiones para poder conectarnos en la
base de datos. (Primero en connections pools y luego en Jdbc resources para que en el persistence
nos pueda reconocer el jdbc

Name Value
User PRUEBATECNICA
MaxStatements 0
DatabaseName PRUEBATECNICA
ImplicitCachingEnabled false
NetworkProtocol tcp
URL jdbc:oracle:thin:@localhost:1521:XE
DataSourceName OracleDataSource
LoginTimeout 0
DriverType thin
PortNumber 1521
ExplicitCachingEnabled false
Password PRUEBATECNICA
driverClass oracle.jdbc.OracleDriver
serverName localhost


EL PERSISTENCE QUEDA MAS O MENOS ASI
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
 http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
 version="2.1">
 <persistence-unit name="trabajadoresPU" transaction-type="JTA">
 <jta-data-source>jdbc/trabajadores</jta-data-source>
 <class>com.prueba.proyectoprueba.Trabajadores</class>
 <properties>
 <property name="javax.persistence.schema-generation.database.action" value="none"/>
 <!-- Aquí podrías agregar más propiedades si quieres -->
 </properties>
 </persistence-unit>
</persistence>
Siempre asegurarse que debe de ponerse jdbc/ para que reconozca el pool y aparte agregar la
clase que se mapeo
