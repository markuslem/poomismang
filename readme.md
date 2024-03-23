Poomismäng
Autorid: Markus Lemberg ja Marttis Ladev

Kasutaja peab ära arvama talle etteantud sõna. Pakkuda saab 1 tähe kaupa. 
Kui täht arvatakse ära, siis näidatakse kas see täht sõnas sisaldub ja mitte. 
Lõppeesmärk on saada võimalikult palju sõnu ja punkte kokku nii, et
ühe sõna kohta võib pakkuda valesid tähti 6 korda.


Sõnad pärinevad:
Eestikeelsed 10000 kõige levinumat sõna pärinevad Eesti Kirjakeele Sagedussõnastikust, 
mille aluseks on võetud üks miljon sõna ajakirjandusest ja ilukirjandusest.
Allikas: https://www.cl.ut.ee/ressursid/sagedused/index.php?lang=et 

Failis "tabel1.txt" on märgitud ära ka esinemissagedus. 
Mis sa arvad, kas võiksime esinemissageduse põhjal anda mängijale kui sõnade äraarvajale vastavalt punkte?
nt esinemissagedusega 500 sõna annab vähem punkte kui esinemissagedusega 10.


FailiLugeja klassis loeb programm failist suvalise rea.

tegevuskava:
1) peaklass Main.java, mis annab ühe tähega sõna ette klassist faililugeja - peaaegu valmis, vaja ainult etteantud reast välja võtta see sõna ise.
2) Klassist Sõna.java võetakse väljundisse sõna, kus esimene täht on näha, aga ülejäänud tähtede asemel on lahtrid
3) Siis saab kasutaja, midagi pakkuda
4) Klass Mängija.java - Mängijal on elud, punktid, meetodid, millega saab punkte lisada ja elusid lisada. Kui elud otsa saavad on mäng läbi. Iga roundi alguses elud nullivad ära, ehk lähevad 6 peale. Iga roundi alguses väljastatakse, mitu elu mängijal on.
5) Klass Sõna.java - Sisaldab lünkliku sõna, mida kasutajale näidatakse. Sisaldab päris sõna, mida kasutaja peab ära arvama. Sisaldab meetodeid, millega kontrollitakse, kas täht on sõnas ja asendatakse lüngad tähtedega.
