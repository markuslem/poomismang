Poomismäng
Autorid: Markus Lemberg ja Marttis Ladev

Programmi käivitamiseks käivitada Main klass. "mehike.txt" ja "tabel1.txt" peavad asuma java klassidega samas kaustas.

Kasutaja peab ära arvama talle etteantud sõna. Pakkuda saab 1 tähe kaupa. 
Võib pakkuda nii suure tähena, kui väikse tähena. Neid mõlemaid koheldakse kui suurt tähte.
Kui täht arvatakse ära, siis näidatakse kas see täht sõnas sisaldub ja mitte. 
Lõppeesmärk on arvata ära võimalikult palju tähti nii, et
ühe sõna kohta võib pakkuda valesid tähti maksimaalselt 5 korda.
Kui ühe sõna puhul pakutakse 6 valet tähte, siis mäng lõppeb


Sõnad pärinevad:
Eestikeelsed 10000 kõige levinumat sõna pärinevad Eesti Kirjakeele Sagedussõnastikust, 
mille aluseks on võetud üks miljon sõna ajakirjandusest ja ilukirjandusest.
Allikas: https://www.cl.ut.ee/ressursid/sagedused/index.php?lang=et 

Failis "tabel1.txt" on kirjas sõna ise selle liik ja selle esinemissagedused.
Selles programmis eraldatakse failst ainult sõna tulp.


FailiLugeja klassis loeb programm failist suvalise rea. Suvalisest reast eraldatakse sõna.

Mängija klassis hoitakse infot mängija punktide ja elude kohta. Lisaks hoolitseb Mängija klass mehikese väljastamise eest
vastavalt sellele, kui palju  elusid alles on.

Sõna klassi loomisel väärtustatakse isendiväli String suvalineSõna FailiLugejast saadud sõnaga. 
Vastavalt suvalisele sõnale väärtustatakse arvatud tähed
Sõna klass hoolitseb peamiselt selle eest, et kasutaja saaks tagasisidet enda pakutud tähtede kohta.

Kõike koondab Main klass, kus kõigepealt luuakse Sõna ja Mängija isendid. Siis küsitakse
mängijalt sisendit. Korrektne sisend on 1 täht nt "a" või "A" (need on samaväärsed).
Siis kontrollitakse, kas täht kuulub sõnasse ja avatakse vastavad lüngad. Kui kogu sõna on juba
mängija poolt ära arvatud, siis luuakse uus Sõna isend ja pakkumine algab uuesti.
Elude otsa saamisel mäng lõpetatakse.

Jaotasime tegevuse:

1) Ideede seast õige valimine - Markus ja Marttis - 30 min
2) Faililugeja klassi loomine koos failide otsimisega - Markus - 30 min
2) Mängija klassi loomine koos "mehike.txt" faili kirjutamisega - Markus - 1 h 15 min
3) Sõna klassi loomine - Marttis - <ajakulu>
4) Main klassi loomine - Markus ja Marttis - 2 h 30 min

Projekti tegemisel suuri muresid ei tekkinud. Saime mängu loomisega konsooliprogrammina väga ilusti hakkama.

Testimine: FailiLugeja faili testisime, kutsudes sõna lugemise meetodit tuhandeid kordi välja, et veenduda, et
ei tekiks vigu. Sõna klassi puhul katsetaisme, kas sõna arvamise meetodid töötavad. Lisaks katsetasime mängu läbi mängimist.