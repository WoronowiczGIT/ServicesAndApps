Template:

Data Fetcher:
establish establish and validate connection
fetch JSON string

JsonMapper:
converts JSON String to HashMap of GSONs JsonPrimitive Objects

PositionParser:
Maps Values of JsonPrimitives to Position Object

GeographicalCalculator:
uses Position instances to calculate desirable data,
and maps it to easy to read DataPackage Objects.

Main:
 sets up every interchangable parameter
 run a while loop that each interval:
  - fetch JSON String,
  - parses it to Position,
  - use old and new position to calculate velocity / distance,
  - displays data.

Bugs:

ToDo:
wyciagnac manipulacje czasem do osobnej klasy

Changelog:
1.JSON parser rozbity na 2 klasy:
  - JsonMapper mapuje String do Mapy Obiektów
  - PositionParser parsuje mape do obiektu Position

2.Logic i Repository połączone w jedną klasę Geographical clculator
  - przechowuje informacje o całkowitym czasie i dystansie
  - daje nam możliwość wyboru czy chcemy korzystać z timestampa podanego w JSONie
      (dokładność do +-1 sec) albo z naszego czasu systemowego.
  - oblicza interesujace nas informacje i zwraca w postaci DataPackage;

