<h1>Conversor de moneda</h1>
Proyecto de conversor de moneda

<h2>Funcionalidades</h2>
El proyecto consiste en un conversor de moneda que da 8 opciones de conversion, de monedas de algunos paises de suramerica a dolar y viceversa. 

Inicialmente se pide al usuario que elija el tipo de conversión a realizar, luego de lo cual, se pide la cantidad de la moneda de origen, que se desea convertir, obteniendo finalmente el monto convertido en el tipo de moneda destino.

<h2>Observaciones</h2>
<p>Estudiando la API de conversión de moneda, se observa que incluye una opción para obtener el calculo directo sin ser necesario realizar consultas por separado y multiplicar.
  
Esto llevó a que se procurara pedir el monto de la conversión para añadirlo como parte de la URI, con lo que se evita el calculo y se simplifica el código.</p>
