# Solución Desafío
Desafío para postulación de Ingeniero Desarrollo en PREVIRED
Desafío 3: Complemento valores UF

# Descripción de la implementación
Se obtiene el listado de la clase DatosUf, la cual no tiene lagunas y tiene datos entre el rango de fecha 1/1/2010 al 31/12/2014, 
pasándole como parámetro el rango de fechas de la clase Valores. Esto retorna un listado de tipo DatosUf sin lagunas.
Posteriormente, se asigna el listado retornado a la clase Valores.
Se ordena la lista sin lagunas.
Se crea un nuevo ArrayList y se itera el listado sin lagunas para asignar cada dato al nuevo ArrayList con los nombres de atributos nuevos. 
Finalmente se convierte a Json la lista nueva y se genera archivo de salida en formato Json (opción de formato 3 del desafío).


#### Control de versiones 
| Version | Ambiente      | Fecha      |
| ------- | ---------- | ---------- |
| 1.0     | Desarrollo | 29-03-2020 |

### Tecnología y librerías

* Java 8
* Maven 4.0.0
* java.io.FileWriter;
* java.io.IOException;
* java.text.DateFormat;
* java.text.SimpleDateFormat;
* java.util.ArrayList;
* java.util.HashSet;
* java.util.Iterator;
* java.util.List;
* java.util.Set;
* java.util.stream.Collectors;
* com.google.gson.Gson;

### Detalles de compilación y ejecución
Se incorporó y referención el archivo jar Generador_Datos_Desafio_Tres-1.0.0
La Clase a ejecutar (Main) es Despliega.java
Retorna un archivo llamado valores.json en la ruta "c://Desafio3/valores.json"


 
 