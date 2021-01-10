# Projekt warehouse
## Opis
Przygotowana przez nas aplikacja ma za zadanie zarówno pomóc pracownikom w wprowadzaniu nowych towarów, jak i w komunikacji ze sklepem poprzez wykorzystanie API restowego. 
Aplikacja jest podzielona na takie kontenery jak:
- backend,
- view,
- baza danych,
- narzędzie phpmyadmin. 

Jest to przykład architektury mikrousług, ponieważ korzystamy z wielu usług, które 
się ze sobą komunikują. Kontenery można podzielić poprzez wagę, czyli w projekcie mamy głównie kontenery wagi muszej tzw. „flyweight” i lekkie. Na myśl przychodzi jednak pytanie: 
Dlaczego w naszym projekcie nie korzystamy z kontenerów wagi ciężkiej, tzw. „Heavyweight”?
Dzieje się tak, ponieważ w naszym projekcie nie były one nam po prostu potrzebne. 
Aplikacja jest zbudowana na dockerze, poprzez plik dockerfile, a następnie jar. Zdecydowaliśmy się by aplikacja nie włączała się tylko z pliku jar, ponieważ jest to furtka do zaimplementowania procesu automatyzacji. Działanie to polega na wgraniu najnowszej wersji projektu na githuba, który to za pomocą githube actions uruchamia proces wgrywania plików na serwer, a następnie budowania obrazu na dockerze. Innym rozwiązaniem jest wykorzystanie github action do zbudowania gotowego obrazu, który zostanie przerzucony jako gotowy plik jar na serwer, gdzie następnie zostanie uruchomiony.

## Technologia

 - Spring 
 -  React (frontend)
 -  MySql(8.0.22)

## Komunikacja między kontenerami
![Diagram](https://raw.githubusercontent.com/witelon-squad/warehouse/af14330df9df116320fa62621bb9e7915771528a/diagram.svg)
## Uruchomienie środowiska

```
$ docker-compose up -d
```
Jeżeli podczas budowania wystąpi błąd przebuduj jeszcze raz ale nie z cache

```
$ docker-compose build --no-cache --pull
```
## Struktura plików
```
./
├── client
│   ├── Dockerfile
│   ├── nginx
│   │   └── conf.d
│   │       └── nginx.conf
│   ├── nginx.conf
│   ├── package.json
│   ├── package-lock.json
│   ├── public
│   │   └── index.html
│   ├── README.md
│   └── src
│       ├── actions
│       │   ├── errors.js
│       │   ├── messages.js
│       │   ├── products.js
│       │   └── types.js
│       ├── components
│       │   ├── AddProduct.js
│       │   ├── Alerts.js
│       │   ├── App.js
│       │   ├── Header.js
│       │   ├── MinorForm.js
│       │   ├── ProductDetails.js
│       │   └── Products.js
│       ├── index.js
│       ├── reducers
│       │   ├── errors.js
│       │   ├── index.js
│       │   ├── messages.js
│       │   └── products.js
│       ├── static
│       │   └── images
│       │       └── logo.png
│       └── store.js
├── docker-compose.yml
├── server
│   ├── Dockerfile
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   ├── README.md
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── warehouse
│       │   │           └── warehouse
│       │   │               ├── exceptions
│       │   │               │   ├── ExceptionMethodAdvice.java
│       │   │               │   └── ProductNotFoundException.java
│       │   │               ├── product
│       │   │               │   ├── ProductController.java
│       │   │               │   ├── Product.java
│       │   │               │   ├── ProductModelAssembler.java
│       │   │               │   └── ProductRepository.java
│       │   │               ├── security
│       │   │               │   └── ApplicationSecurityConfig.java
│       │   │               ├── subproducts
│       │   │               │   ├── models
│       │   │               │   │   ├── Cooler.java
│       │   │               │   │   ├── Cpu.java
│       │   │               │   │   ├── Gpu.java
│       │   │               │   │   ├── Hdd.java
│       │   │               │   │   ├── Motherboard.java
│       │   │               │   │   ├── Psu.java
│       │   │               │   │   ├── Ram.java
│       │   │               │   │   └── Ssd.java
│       │   │               │   └── repositories
│       │   │               │       ├── CoolerRepository.java
│       │   │               │       ├── CpuRepository.java
│       │   │               │       ├── GpuRepository.java
│       │   │               │       ├── HddRepository.java
│       │   │               │       ├── MotherboardRepository.java
│       │   │               │       ├── PsuRepository.java
│       │   │               │       ├── RamRepository.java
│       │   │               │       └── SsdRepository.java
│       │   │               └── WarehouseApplication.java
│       │   └── resources
│       │       └── application.properties
│       └── test
│           └── java
│               └── com
│                   ├── warehouse
│                   │   └── warehouse
│                   │       └── WarehouseApplicationTests.java
│                   └── witelon_squad
│                       └── crud
│                           └── WarehouseApplicationTests.java
└── warehousedatabase.sql
```
## REST

| Lp  | nazwa  | akcja                                                                                                                                |
| --- | ------ | ------------------------------------------------------------------------------------------------------------------------------------ |
| 1   | GET    | '''/products''' pobiera wszystkie możliwe produkty z bazy danych                                                                           |
| 2   | GET    | /products/{id} pobiera jeden konkretny produkt sprecyzowany przez 'id'                                                                          |
| 3   | POST   | /products dodaje nowy produkt do bazy danych na podstawie przekazanego ciała                                                         |
| 4   | PUT    | /products/{id} zamienia istniejący produkt na danym id z przekazanym ciałem                                                          |
| 5   | DELETE | /products/{id} usuwa z bazy danych istniejący produkt o podanym id                                                                   |
| 6   | PATCH  | /products/{id} zmniejsza ilość danego produktu o 1 jednostkę w bazie danych  

##  Contributors

 <table>
  <tr>
    <td align="center"><a href="https://github.com/MrHDOLEK"><img src="https://avatars3.githubusercontent.com/u/27227621?s=460&u=069465d3f3be2023b139af01b624136ee7c34f25&v=4" width="100px;" alt=""/><br /><sub><b>Aleksander Kowalski</b></sub></a><br />Devops
    <a href="#question-kentcdodds" title="Answering Questions"></td>
    <td align="center"><a href="https://github.com/shiragaira"><img src="https://avatars0.githubusercontent.com/u/66391990?s=460&v=4" width="100px;" alt=""/><br /><sub><b>Kacper Frankowski </b></sub></a><br />Programmer
     </td>
    <td align="center"><a href="https://github.com/Aceaelus"><img src="https://avatars3.githubusercontent.com/u/72414936?s=460&u=46621f1c6fae8a996942b1f1f00dc5110e8ca1a2&v=4" width="100px;" alt=""/><br /><sub><b>Jakub </b></sub></a><br />Programmer</td>
     <td align="center"><a href="https://github.com/Aceaelus"><img src="https://avatars2.githubusercontent.com/u/72552648?s=400&v=4" width="100px;" alt=""/><br /><sub><b>Michał</b></sub></a><br />Programmer</td>
    <td align="center"><a href="https://github.com/Elterr"><img src="https://avatars3.githubusercontent.com/u/72750026?s=460&u=96ccc7e85acd26d76240a508e95f3249c27314f0&v=4" width="100px;" alt=""/><br /><sub><b>Szymon</b></sub></a><br />Document writer</td>
    <td align="center"><a href="https://github.com/Shayarin"><img src="https://avatars3.githubusercontent.com/u/73511650?s=400&v=4" width="100px;" alt=""/><br /><sub><b>Aleksandra</b></sub></a><br /> Graphic Artist</td>
  </tr>
</table>
