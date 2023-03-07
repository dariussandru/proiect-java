# proiect-java
Creating a social network

Reţea de socializare – MAP_ToySocialNetwork

Implementaţi o reţea de socializare cu un model simplificat, dar din care să poată fi extrase informaţii relevante. 
Inițial vom implementa câteva funcționalități de bază, iar pe măsură ce vom parcurge materia, 
vor fi adăgate cerințe adiționale si vor fi extinse cele existente.

Funcționalități de bază (cerințe funcționale): 

- Gestiunea utilizatorilor: operații CRUD (pt a avansa mai rapid propun să citim acești utilizatori, 
inițial dintr-un fisier csv. 
- Gestiunea relațiilor de prietenie între utlizatori: adăgare/ștergere prieten 
- Determnarea comunitații din care face parte un anumit utilizator (componenta conexa a retelei care contine
 utlizatorul respectiv) 
- Gestiunea mesajelor: trimitere/stergere mesaj 
- Adaugarea unui obiect de tipul Page 
- Gestiunea evenimentelor: se va implementa șablonul Observer pentru notificări, abonare/dezabonare la un eveniment;
- Autentificare: logare/delogare 
- Vizulare istoric evenimente pe o anumită perioadă calenadaristică 
- Vizualizare istoric utilizaror pe o anumită perioadă calenadaristică 
Obs. Vor mai fi adăugate si alte cerințe pe parcurs; aveți posibiliatea să contribuiți și voi la completarea acestei liste. 

Modelul Conceptual si Arhitectura aplicației (cerințe nonfuncționale) 

1) Entitățile problemei ar putea fi (puteți să redenumiți îm limba engleză aceste entități și, de asemenea,
puteți identifica altele noi sau să le reprezentați altfel pe cele stabilite mai jos):
1. Utilizator:
2. Prietenie
3. Retea
4. Mesaj
5. Eveniment
6. ...

2) Relații între entități:
- Un utilizator al rețelei are o lista de prieteni
- O prietenie se stabilește între doi utilizatori ai rețelei
- Rețeau este definită de mulțimea utilizatorilor și a relațiilor de prietenie dintre aceștia
