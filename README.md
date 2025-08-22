
### Escuela Colombiana de Ingeniería
### Arquitecturas de Software - ARSW
## Ejercicio Introducción al paralelismo - Hilos - Caso BlackListSearch


## 📌 Parte 1: CountThread y CountThreadsMain
 1.	Implementamos la clase **CountThread.java**, lo principal es guardar los dos atributos **A** y **B** , ellos representan el rango de números
      	 y el método run() para que el hilo imprima los números en el rango indicado

<p align="center">
<img src="https://github.com/user-attachments/assets/ca8dd249-2c53-4ed1-b355-7a4cebb2bfad" width="400" />
</p>

2.	Para **CountThreadsMain.java**, creamos los 3 hilos con los rangos especificados en el taller, primero con start() para probar que pasaría y luego con run()

<p align="center">
<img width="601" height="402" alt="image" src="https://github.com/user-attachments/assets/8c412b39-78e2-48ef-94ca-c8352294f41f" />
</p>

Con la salida de start() podemos ver como los números salen, pero no en un orden en especifico (mezclados), en cambio con run() vemos como salen mas ordenados:

- **Start()**

<p align="center">
<img width="480" height="238" alt="image" src="https://github.com/user-attachments/assets/e16eef9a-f355-46b9-97f2-17cb32419e1b" />
</p>
<p align="center">
<img width="37" height="259" alt="image" src="https://github.com/user-attachments/assets/e05323e6-edf1-4702-8f95-50e2a22ad2c5" />
</p>

- **Run()**

<p align="center">
<img width="503" height="245" alt="image" src="https://github.com/user-attachments/assets/27f626f7-8476-4699-87d3-2a1549ee6147" />
</p>
<p align="center">
<img width="61" height="404" alt="image" src="https://github.com/user-attachments/assets/87aa4e07-cdd0-4176-bcf4-023de6c205ea" />
</p>

## 📌 Parte 2: Búsqueda en Listas Negras
1.	Para este punto se implementó la búsqueda de una dirección IP dentro de múltiples listas negras, como se nos pedía se definió una nueva clase SearchThread la cual se encarga de revisar en un rango en especifico de listas, en el main se pusieron los hilos los cuales trabajan en paralelo para todas las listas, al final el programa tendría que decir si la dirección IP es confiable o no también junto con las listas en donde fueron encontradas

<p align="center">
<img width="827" height="64" alt="image" src="https://github.com/user-attachments/assets/f1d791c2-1106-48f8-ba6f-060f23469305" />
</p>

- La idea con **SearchThread.java**, revisa dentro de un rango de listas negras de inicio a final si una dirección IP aparece múltiples veces para considerarse no confiable, los hilos 		trabajan en paralelo verificando partes de los servidores y guarda las coincidencias haciéndolo más rápido con varios hilos

<p align="center">
<img width="680" height="494" alt="image" src="https://github.com/user-attachments/assets/3d6cee6b-9e7e-4dd6-be7b-9a44a783054d" />
</p>

2. En esta parte se modificó el método checkHost para recibir un parámetro N el cual seria el numero de hilos en los que se divide la búsqueda de la dirección IP en las listas negras, la idea es que cada hilo se encargue de revisar partes diferentes

<p align="center">
<img width="655" height="301" alt="image" src="https://github.com/user-attachments/assets/e78a5fed-4e00-4105-9a09-b680618e8aec" />
</p>

- Para comprobar miramos con la IP confiable 212.24.24.55 con 10 hilos

<p align="center">
<img width="450" height="52" alt="image" src="https://github.com/user-attachments/assets/2d42b5f2-ae74-4cf6-b126-de89dbc8ce8e" />
</p>

- Ahora con la IP no confiable 202.24.34.55 con 8 hilos

<p align="center">
<img width="464" height="65" alt="image" src="https://github.com/user-attachments/assets/929e7696-0615-44c1-938f-0a883cca77a6" />
</p>

## 📌 Parte 3: Experimentos con distintos hilos
Se hicieron pruebas con diferentes hilos para poder deducir o identificar el comportamiento y tiempos de respuesta, se implemento una nueva clase que se llamo **PerformanceEvaluator.java** la cual sirvio como clase de prueba, se implemento de la siguiente manera:

<p align="center">
<img width="734" height="539" alt="image" src="https://github.com/user-attachments/assets/bc4783f5-02b4-469f-a644-601f71da3d7e" />
</p>

- Primero fija el valor de **nThreads** (este se cambia a medida que queremos aumentar o disminuir los hilos), luego registra el tiempo de inicio, ejecuta la validación en paralelo con la clase HostBlackListsValidator y finalmente calcula el tiempo total que tomó la ejecución. Al imprimir la IP evaluada, el número de hilos, el tiempo consumido y el total de ocurrencias encontradas, se puede comparar fácilmente cómo varía el desempeño al aumentar o disminuir los hilos, encontramos lo siguiente:

- **1 hilo**:
<p align="center">
<img width="380" height="95" alt="image" src="https://github.com/user-attachments/assets/ff19e45b-540d-4807-a218-c24ae87fb80e" />
</p>

<p align="center">
<img width="694" height="149" alt="image" src="https://github.com/user-attachments/assets/7b19e881-8923-4364-a5fd-0ba19209f975" />
</p>
 
- **Para este caso hacemos uso de int nThreads =Runtime.getRuntime().availableProcessors(), esta nos devuelve el número de procesadores lógicos que tiene la CPU, en este caso fueron 4**:
<p align="center">
<img width="571" height="89" alt="image" src="https://github.com/user-attachments/assets/98c1310e-a36e-4472-bd6d-3e2301336b6d" />
</p>

<p align="center">
<img width="517" height="138" alt="image" src="https://github.com/user-attachments/assets/46fe0300-0475-42e2-8b33-f605c049bd25" />
</p>
  
- **Para este punto es el mismo ejercicio, pero la idea es dar como resultado el doble, por eso lo que hacemos es multiplicar por 2 y obtenemos 8 hilos en este caso:**
<p align="center">
<img width="533" height="89" alt="image" src="https://github.com/user-attachments/assets/f753593e-ceb7-4b5a-8aea-f8d322a5059e" />
</p>

<p align="center">
<img width="522" height="130" alt="image" src="https://github.com/user-attachments/assets/435c2ca5-6d7d-4d4a-85b8-2f8322ac508f" />
</p>
  
- **50 hilos**

<p align="center">
<img width="471" height="88" alt="image" src="https://github.com/user-attachments/assets/e32159be-9ce9-497a-902a-7f8a0eafcce8" />
</p>

<p align="center">
<img width="592" height="148" alt="image" src="https://github.com/user-attachments/assets/79e3b857-8d43-4632-b731-a50fab3f0652" />
</p>

- **100 hilos**
<p align="center">
<img width="389" height="98" alt="image" src="https://github.com/user-attachments/assets/eb1d3cac-efd7-42c6-a6d4-13f80002e26d" />
</p>

<p align="center">
<img width="484" height="136" alt="image" src="https://github.com/user-attachments/assets/4cbf171b-1c3c-422b-8036-cb97e584f070" />
</p>
  

📊  **Resultados:**

- Nos encontramos con distintos tiempos dependiendo de la cantidad de hilos que ingresamos, se hizo una tabla y luego una grafica de Hilos VS Tiempo para analizar los resultados:

<p align="center">
<img width="197" height="132" alt="image" src="https://github.com/user-attachments/assets/c7beac43-a9ac-48e1-bc58-6f7e6f6df1fe" />
</p>

Con un solo hilo la ejecución fue secuencial, saturando un único procesador lógico y generando un alto tiempo de procesamiento. Al aumentar el número de hilos, las tareas se distribuyeron en paralelo entre los núcleos disponibles, lo que incrementó el aprovechamiento del CPU y redujo significativamente el tiempo. Con 50 y 100 hilos la sobrecarga de creación y gestión de hilos aún se mantiene baja ya que trabajan de mejor manera

<p align="center">
<img width="679" height="398" alt="image" src="https://github.com/user-attachments/assets/929152a2-88af-4851-9dec-6aa14b68cf17" />
</p>

## 📌 Parte 4: Ley de Amdahl

- Expliación de la ley de Amdahl:
<p align="center">
<img width="502" height="193" alt="image" src="https://github.com/user-attachments/assets/da816dcf-5718-4598-b158-9be5dedf9c26" />
</p>
  

1.	Según la ley de Amdahl, aunque aumentemos mucho el número de hilos, el desempeño siempre está limitado por la parte del algoritmo que no se puede paralelizar. Por eso, al pasar de 200 a 500 hilos la mejora es mínima, con tantos hilos se generan sobrecostos de coordinación y cambios de contexto que hacen que no valga la pena

2.	Cuando usamos tantos hilos como núcleos reales de la CPU, el rendimiento es casi óptimo porque cada hilo puede ejecutarse sin competencia. Si duplicamos la cantidad de hilos, el sistema operativo debe repartir el tiempo de los núcleos entre más procesos, lo que introduce esperas y sobrecarga. Por eso, usar el doble de hilos no significa el doble de rendimiento, sino que incluso puede reducir la eficiencia

3.	Si en lugar de 100 hilos en una sola máquina distribuimos el trabajo en 100 máquinas con 1 hilo cada una, la ley de Amdahl sigue aplicando, pero además aparece el tiempo de comunicación y coordinación entre equipos. Solo conviene distribuir si el problema es muy paralelizable y requiere más memoria o recursos de los que una sola máquina puede ofrecer











