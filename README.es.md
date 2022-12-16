ParkIT
===============
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/alejandroMAD/parkit/blob/master/README.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](https://github.com/alejandroMAD/parkit/blob/master/README.es.md)

Interfaz de usuario
----------
![Captura de pantalla](/screenshot.png)

Una aplicación de Java Swing para monitorizar el estado de las plazas de aparcamiento de un parking de vehículos, que simula el tráfico continuo de coches-hilo e ilustra un problema de programación concurrente resuelto mediante el empleo de dos objetos Semaphore.

Características
-------------------
* La aplicación crea el sistema de un parking como recurso compartido para que los vehículos puedan aparcar, ofreciendo 107 plazas regulares y 2 plazas de movilidad reducida reservadas para conductores con discapacidad. 
* Dos objetos Semaphore independientes regulan la adquisición y devolución de permisos de aparcamiento en las plazas regulares y las plazas de movilidad reducida, respectivamente.
* La aplicación genera un flujo infinito de hilos a un ritmo basado en reglas programáticas, cada uno de ellos representando a un vehículo que solicita permiso para usar una plaza de aparcamiento.
* Los objetos Coche generados incluyen como atributos una matrícula aleatoria según el formato de España, una marca y modelo de coche aleatorio tomados de un fichero de recursos y el atributo que define mediante un factor de probabilidad si es o no un vehículo de movilidad reducida
* Las solicitudes a los objetos Semaphore están moduladas por un plazo de "paciencia" en la espera y una variable booleana fijada en "true" que determina que los permisos se repartirán a los hilos en espera según una distribución "FIFO".
* A TimeGenerator provides distinct random times to be used by several timed events in the appñication, such as the CarGenerator pace, cars requests patience timeout and cars stay in the parking spot.
* A Graphical User Interface depicts the state of every parking spot at any given time and provides information of the parked vehicles.

This project is the product of a team effort made by the following students of the Multiplatform Applications Development grade course: Mario Cézar, Pablo Hurtado González, Alejandro M. González, Antonio Oliver and Helmer Villegas.

Reconocimiento
-------------------

* Fotografía de parking de fondo: [Fotografía de un parking por Timothy Tan - Unsplash](https://unsplash.com/es/fotos/NvQjfWey2H8)

Licencia
--------
    Copyright (C) 2022  Mario Cézar, Pablo Hurtado González, Alejandro M. González, Antonio Oliver, Helmer Villegas
    
    MIT License: http://opensource.org/licenses/MIT
