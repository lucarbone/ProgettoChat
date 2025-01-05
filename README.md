
# Creazione ed implementazione di una chat -Carbone-Giove-Medola

_CLIENT + SERVER_: **Luca Carbone** [@Luca Carbone](https://github.com/lucarbone)

_SERVER CODE GUI_: **Giovanni Giove** [@Giovanni Giove](https://github.com/giove06)

_CLIENT CODE GUI_: **Matteo Medola** [@Matteo Medola](https://github.com/MatteoMedola)

# 1.Introduzione
Per questo progetto presentiamo la realizzazione e l'implementzione di una chat, sviluppata con architettura _client-server_ .

## Obiettivi minimi da raggiungere
La chat deve funzionare su una rete locale (LAN).

Il server deve accettare la connessione da diversi client identificati da un username univoco,
e verificare che provengano da identità differenti (non a livello ip, ma a livello username).

Ogni client dovrà leggere e scrivere messaggi simultaneamente. 

Ogni messaggio deve essere preceduto dall'username di colui che l'ha inviato, in modo che ciascun client sappia chi ha scritto il messaggio e l'ora in cui è stato scritto.

Il server deve provvedere a un sistema di logging degli eventi principali.
#
Nella realizzazione del progetto, ci siamo concentrati subito sul realizzare gli obiettivi minimi creando appunto due repository differenti: una client e una server, così da porre le basi per l'architettura client-server.

Dopo aver creato le cartelle, abbiamo creato l'interfaccia grafica di base sia del server che del client, integrando poi all'interfaccia le funzionalità di base richieste dalla consegna.

## Ambiente di sviluppo utilizzato
Abbiamo deciso di utilizzare come ambiente di sviluppo: _NetBeans_, perché ci ha permesso di realizzare l'interfaccia grafica della nostra chat, in maniera semplice e veloce.
Permettendoci poi di modificarla e aggiornarla in maniera rapida, più avanti nella fase di realizzazione del progetto.

## Funzionalità aggiuntive 
Una volta terminata l'implementazione degli obiettivi minimi, ci siamo concentrati sulla realizzazione di nuove funzionalità che permettessero alla chat di essere più completa.

* Utilizzo dell'interfaccia grafica java Swing: ci ha permesso di dare una forma reale alla nostra chat, permettendoci di renderla interattiva per l'utente.

* Il server è parte della chat: infatti il server tramite la scrittura di determinati messaggi da parte del client fornirà delle risposte, ogni qualvolta un client abbandona la chat,
  o viene bannato il server lo farà presente a tutti gli altri client connessi ad esso.

* Bottone di abbandono della chat: funzionalità che permette ad ogni client di abbandonare la chat, in qualsiasi momento.

* Ban degli utenti: nell'interfaccia del server quando viene mostrato l'utente che si è connesso, viene mostrato affianco, un bottone rosso che permette di bannare un client dalla chat e quindi dal server.

  
  





