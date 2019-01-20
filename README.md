
# Patrones y Arquitecturas Web

> #### [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
> #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*

### Estado del código

[![Build Status](https://travis-ci.org/ropili19/APAW-ECP2-rosarioOrbezo.svg?branch=master)](https://travis-ci.org/ropili19/APAW-ECP2-rosarioOrbezo.svg?branch=master)

<!---
![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3AAPAW-pd&metric=alert_status)
-->
### Diagrama UML de las entidades tratadas en el proyecto.
![Alt text](https://github.com/ropili19/APAW.-ECP1.-rosario.orbezo/blob/master/src/main/images/uml_1.jpeg?raw=true "uml")

### Arquitectura de un mini API-Rest simulado
Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código

## Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)
Asignatura: Arquitectura y Patrones para Aplicaciones Web
Build Status

Tecnologías necesarias
* Java
* Maven
* GitHub
### Responsabilidades
Dispatcher
Centraliza las peticiones y hace de repartidor
Recupera los datos de la petición y los pasa como parámetros de método
Captura las excepciones y las convierte en errores Http
###restControllers
Define el path del recurso
Valida la entrada
Traspasa la petición a los controladores de la capa de negocio
###businessControllers
Procesa la petición, apoyándose en los DAO’s
Crea las entidades a partir de los DTO’s
Gestiona la respuesta a partir de las entidades. Delega en los DTO’s la creación a partir de la entidad
### daos
Gestionan la BD
### entities
Son las entidades persistentes en la BD
>### API

## POST /clients

	Parámetros del cuerpo
	* name: String (requerido)
	* surname: String
  
Respuesta

	* 200 OK
	* id: String
	* 403 BAD_REQUEST
## PUT /clients/{id}

Parámetros del cuerpo

	* name: String (requerido)
	* surname: String
  
Respuesta

	* 200 OK
	* 403 BAD_REQUEST
	* 404 NOT_FOUND
  
## POST /meanstransports

Parámetros del cuerpo
  
 * price: Integer (requerido)
  
 * description: String
  
Respuesta

* 200 OK
  
* id: String
  
* 403 BAD_REQUEST
  
  
## POST /trips

Parámetros del cuerpo

	* origin: String (requerido)
	* destination: String (requerido)
	
Respuesta

*	200 OK
*	403 BAD_REQUEST

## GET /clients
Respuesta
*	200 OK
	[ {name:String,surname:String} ]
## DELETE /clients/{id}
Respuesta
*	200 OK


## PATH /trips/{id}/state
Parámetros del cuerpo
state: String (requerido)
Respuesta
*	200 OK
*	403 BAD_REQUEST
*	404 NOT_FOUND
## GET /trips/search?q=origin:madrid
Respuesta

	* 200 OK
	[ {origin:String,destination:String,clients:[],meanlist:[],state:String} ]
	* 403 BAD_REQUEST
