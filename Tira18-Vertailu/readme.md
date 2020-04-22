# TiRa 18 Vaertailua
Testissä käytettiin miljoona alkioista taulukkoa. Tulosteessa näkyvä aika on nanosekunneissa.

## Benchmark omalle toteutukselle
![kuva1](https://raw.githubusercontent.com/wesenbergg/TiRa-k2020/master/TiRa18-Vertailu/tira18-puu.PNG)
Oma puu sijoitti alkiot puuhun noin 1,8 sekunnissa.

## Benchmark JCAPI TreeSetille
![kuva1](https://raw.githubusercontent.com/wesenbergg/TiRa-k2020/master/TiRa17-TreeSet/tira18-treeset.PNG)
TreeSet asetti alkiot puuhun noin 0,8 sekunnissa.

## Ei duplikaatteja
![kuva1](https://raw.githubusercontent.com/wesenbergg/TiRa-k2020/master/TiRa17-TreeSet/tira18-insert.PNG)
Syötettyä dataa verrataan puun dataan. Jos data on duplikaatti niin `compareTo` metodi palauttaa 0, silloin ohjelma ei mene kumpaakaan if-silmukkaan ja rekursio katkeaa.
