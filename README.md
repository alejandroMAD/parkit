ParkIT
===============
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/alejandroMAD/parkit/blob/master/README.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](https://github.com/alejandroMAD/parkit/blob/master/README.es.md)

User interface
----------
![User interface](/screenshot.png)

A Java Swing parking to monitor the state of parking spots in a parking lot creating a continuous car-threads traffic simulation and illustrating a case of concurrency solved by means of two Semaphores.

Features
-------------------
* The application creates a parking system as a shared resource for cars to park, providing 107 regular parking spots and 2 reduced mobility reserved spots.
* Two different Semaphore objects regulate the acquiring and releasing of permits to park in the regular/reduced mobility parking spots.
* The application generates an infinite time-paced flow of threads, each representing a car requesting a permit to use the parking lot.
* The Car objects generated include attributes of a random license plate number in Spain's format, a random brand and car model picked from a resource file and the fact of being a reduced mobility car or not regulated by a probability.

Credits
-------------------

* Parking photo background: [Photo of a parking by Timothy Tan - Unsplash](https://unsplash.com/es/fotos/NvQjfWey2H8)

License
--------
    Copyright (C) 2022  Alejandro M. González
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    
    MIT License: http://opensource.org/licenses/MIT
