# ApiClienteLH
Esta aplicación fue desarrollada con la herramienta Spring Tool Suite
Corresponde a una api rest desarrollada con springboot y contiene los siguientes endpoints

http://localhost:3000/ObtenerClientes (GET)
Método mediante el cual se obtienen todos los clientes registrados

http://localhost:3000/guardarCliente (POST)
Método mediante el cual se agregan nuevos clientes, a continuación se muestra un script JSON de ejemplo para realizar nuevos registros

{
	"nombre" : "Cristian Vicencio",
	"rut" : "15716617-4",
	"correo" : "c.vicencio.rios@gmail.com"
	
}

http://localhost:3000/eliminarCliente/{id} (POST)
Método mediante el cual se eliminan clientes

http://localhost:3000/actualizarCliente (POST)
Método mediante el cual se actualizan los datos de los clientes existentes, a continuación se muestra un script JSON de ejemplo para realizar nuevos registros

{
	"id": 1,
	"nombre": "Cristian Vicencio",
	"rut": "15716617-4",
	"correo": "otroCorreo@gmail.com"
}

La base de datos utilizada para realizar el registro de clientes fue creada con el motor de base de datos MySQL y se creo una tabla para realizar la persistencia de los registros, a continuación se adjuntan los scripts correspondientes

CREATE DATABASE testlh;

CREATE TABLE cliente (
  id 		int(10) unsigned NOT NULL AUTO_INCREMENT,
  nombre 	varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  rut 		varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  correo 	varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci

Para las pruebas se utilizó la herramienta POSTMAN, y dentro del proyecto git compartido se incluye un directirio con el proyecto POSTMAN ()
