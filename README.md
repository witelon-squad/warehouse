# Projekt warehouse
## Opis
Aplikacja ma za zadanie pomóc pracownikom wprowadzać nowe towary i komunikować się ze sklepem po przez api restowe.
Aplikacja jest podzielona na takie kontenery jak:backend,view,baza danych i narzędzie phpmyadmin. Jest to przykład architektury mikrousług ponieważ mamy wiele usług które ze sobą się komunikują. Kontenery można podzielić poprzez wage czyli w projekcie mamy głównie kontenery wagi  muszej tzw 'flyweight' i lekie.Zapewne zapytasz dlaczego nie ma wagi cieżkiej tzw 'Heavyweight'.Ponieważ w obrazach projektu nie były potrzebne na danym kontenerze narzędzia do pracy z nim.Aplikacja jest budowana na dockerze poprzez plik dockerfile i z pliku jar pożniej  a nie tylko odpala z pliku jar.Ponieważ jest to furtka do za implementowania prosecu automatyzacji czyli wgrywamy najnowszą wersje projektu na githuba a githube actions uruchamia proces wgrywania plików na serwer i uruchomienia budowania obrazu na dockerze czy z budowania nawet na githubie i przerzuceniu pliku jar na serwer i tylko jego odpalenie.
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

|Lp  |nazwa  | akcja|
|--|--|--|
| 1 | GET | |
| 2| POST| |
| 3 | PUT| |
| 4 | DELETE| |

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
