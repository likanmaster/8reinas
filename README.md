# Tarea 1 AMIN

### N-Reinas
Este código resuelve el problemas de las N-Reinas basandose en los algoritmos genéticos. El problema consiste en encontrar una solución óptima entre una población de individuos.
La funcionalidad del programa consiste en crear una población donde los individuos estan representados por los tableros, luego se calcula un fitness de cada individuo para ver cual es la cantidad de choques que presenta el tablero, a continuación se selecciona a traves de la metologia de ruleta a los padres que van a generar descendencia. Una vez selecionados los padres estos se cruzan si se encuentran dentro de esta probabilidad de cruza establecida como datos de entrada del algoritmo. Los hijos generados anteriormente forman parte de una nueva generación de individuos los se someten a una reparación que consiste en revisar si contienen numeros repetidos, luego se someten a una mutación y se repite todo el proceso mencionado anteriormente.

Los parametros de entrada del algoritmo son: la semilla, el número de reinas, el tamaño de la población, el número de generaciones, la probabilidad de cruza y por ultimo la probabilidad de mutación.

Para la ejecución del algoritmo se deben seguir los siguientes pasos:

- Primero abrir la terminal de Linux

- Luego se debe clonar el repositorio remoto en el repositorio local utilizando el siguiente comando:
 
          git clone https://github.com/likanmaster/8reinas.git

- Para poder clonar el repositorio luego de ejecutar el comando anterior, se solicitara el nombre de usuario y contraseña que deben ser ingresados por la persona que esta ejecutando el algoritmo
 
- El siguiente paso es acceder a la carpeta del repositorio local que se creo inicialmente, para esto es necesario cambiarse de directorio con el comando cd, como el siguiente ejemplo, en caso de que la carpeta se llame n_reinas se de usar el comando de la siguiente forma:
 
           cd n_reinas/src/pkg8reinas

- Luego primero se debe compilar el programa con la siguiente instrucción

                javac Main.java
               
- Una vez compilado el programa se debe ejecutar ingresando los parametros de entrada mencionados anteriormente como por ejemplo:

                java Main 2000 8 2000 100 0.5 0.6

Con la realización de todos los pasos mencionados anteriormente es posbible ejecutar el programa.
