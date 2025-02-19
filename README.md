# Progetto TPSIT Laboratorio
## Progettazione di una chat con architettura client-server 
### Realizzato da Luca Carbone, Matteo Medola e Giovanni Giove classe 5E, Anno Scolastico 2024/25

_CLIENT + SERVER_: **Luca Carbone** [@Luca Carbone](https://github.com/lucarbone)

_SERVER CODE+GUI_: **Giovanni Giove** [@Giovanni Giove](https://github.com/giove06)

_CLIENT CODE+GUI_: **Matteo Medola** [@Matteo Medola](https://github.com/MatteoMedola)

# 1.Introduzione
In questo progetto ci è stata richiesta dall'insegnate la realizzazione di una chat client-server in Java sfruttando il lavoro svolto precedentemente in classe. Siamo stati suddivisi in più gruppi e ci sono state date le direttive per sviluppare il tutto.

## Ambiente di sviluppo utilizzato
Abbiamo deciso di utilizzare come ambiente di sviluppo: _NetBeans_, perché ci ha permesso di realizzare l'interfaccia grafica della nostra chat, in maniera semplice e veloce.
Permettendoci poi di modificarla e aggiornarla in maniera rapida avanzando nella fase di realizzazione del progetto.

## Obiettivi minimi
Nella realizzazione del progetto, ci siamo concentrati subito sul realizzare gli obiettivi minimi creando appunto due cartelle differenti: una client e una server, così da porre le basi per l'architettura client-server.
Dopo aver creato le cartelle, abbiamo progettato l'interfaccia grafica di base sia del server che del client, integrando poi le funzionalità di base richieste dalla consegna.

* La chat deve funzionare su una rete locale (LAN).

* Il server deve accettare la connessione da diversi client identificati da un username univoco,
e verificare che provengano da identità differenti (non a livello ip, ma a livello username).

* Ogni client dovrà leggere e scrivere messaggi simultaneamente. 

* Ogni messaggio deve essere preceduto dall'username di colui che l'ha inviato, in modo che ciascun client sappia chi ha scritto il messaggio e l'ora in cui è stato scritto.

* Il server deve provvedere a un sistema di logging degli eventi principali.

## Funzionalità aggiuntive 
Una volta terminata l'implementazione degli obiettivi minimi, ci siamo concentrati sulla realizzazione di nuove funzionalità che permettessero alla chat di essere più completa e funzionale. inizialmente abbiamo seguito i punti suggeriteci dal professore per poi mettere insieme qualche idea personale per rendere l'applicazione più interessante e presonalizzata.


# 2.Primi schizzi per la progettazzione dell'interfaccia grafica
  ![SchizzoServer](images/SchizzoServer.png)
  ![SchizzoClient](images/SchizzoClient.png)



# 3.Caratteristiche dell'applicazione

### Funzionalità del Server
* Il server è parte della chat: infatti il server tramite la scrittura di determinati messaggi da parte del client fornirà delle risposte, ogni qualvolta un client entra/abbandona la chat,
  o viene bannato il server lo farà presente a tutti gli altri client connessi ad esso. Il server risponde a determinati messaggi scritti dagli utenti, e sono:
    * Comando "Help": il server invia come risposta all'utente, i comandi che lui stesso può svolgere.
    * Comando "Data": il server risponde all'utente che ha inviato questo messaggio con la data e l'ora aggiornata al momento dell'invio del messaggio.
    * Comando "Utenti": il server invia come risposta all'utente la lista degli utenti commessi in quel momento all'interno della chat.
    * Comando "Report" seguito da uno spazio e dall'username dell'utente che si desidera segnalare: permette di segnalare solamente una volta uno specifico utente in modo che l'amministratore del server venga allertato di eventuali comportamenti scorretti all'interno della chat e possa provvedere bannando gli utenti. 

* Visualizzazione in tempo reale degli utenti connessi alla chat con informazioni riguardanti nickname, indirizzo ip e quantità di report.
* Ban degli utenti: nell'interfaccia del server quando viene mostrato l'utente che si è connesso, oltre alla informazioni descritte prima, viene mostrato affianco un bottone rosso che permette di bannare un client dalla chat.
* Controllo inserimento porta (se è utilizzata da un'altro processo viene visualizzato un messaggio).
* Gestione completa degli errori che possono occorrere.
* Controllo e avviso ai client della chiusura del server.

### Funzionalità del Client
* Gestione degli errori di inserimento di porta e indirizzo ip, (in caso di errore per l'indirizzo ip se non si è sbagliata proprio la forma occorre aspettare qualche secondo perchè il server tenta per un certo tempo di connettersi all'indirizzo che gli è stato fornito)
* Gestione del nickname: viene controllato che l'utente inserisca effettivamente un nickname e che non sia già in utilizzo. Se il nickname è già stato utilizzato da un'altro utente gli viene chiesto di inserirne uno nuovo.
* Visualizzazione dei messaggi in modo differenziato (i messaggi inviati dal client sono di colore verde, quelli ricevuti di colore grigio)
* Indentificazione autore del messaggio e orario preciso a cui è stato inviato.
* Richiedere servizi al server: tramite alcuni comandi specifici (descritti prima) il singolo utente può far svolgere al server determinati compiti. 
* Bottone di abbandono della chat: funzionalità che permette ad ogni client di abbandonare la chat, in qualsiasi momento.

# 4.Problematiche riscontrate
Nella realizzazione dell'applicazione, ci siamo imbattuti in alcuni problemi. Uno di essi si è verificato, durante la suddivisione del lavoro su due branch differenti(main, client). Abbiamo avuto problemi con il mantenere le versioni di entrambi i branch sempre aggiornate contemporaneamente, perciò abbiamo deciso di tornare a lavorare su un unico branch (main), per portare a termine il progetto.
Inoltre abbiamo avuto dei problemi con le commit, perché alcune di esse dopo l'arrivo di una nuova commit sparivano, per risolvere questo problema, abbiamo caricato manualmente dalla repository su git hub i nuovi aggiornamenti.

All'interno del programma durante la scrittura del codice ci siamo imbattuti in errori dovuti alla grafica sia del client che del server, errori che portavano la chat a non funzionare correttamente, dopo un po' di ricerche su cosa potesse essere il problema, abbiamo trovato l'errore: sia per il lato server nella classe(ControllerServer.java), sia per il lato client nella classe (ChatClient.java), la prefferredSize dai noi messa precedentemente, non permetteva il corretto utilizzo della scrollbar nei pannelli, limitando così la comparsa a schermo dei messaggi. Il problema è stato risolto riportando entrambe le prefferedSize al loro valore di default.

Durante la scrittura della parte server, nella parte della lista dei client connessi, abbiamo avuto un paio di problemi, per esempio la lista del client non andava correttamente e non mostrava il numero corretto di utenti connessi , oppure non rimuoveva il client quando si disconnetteva.
Per sistemare questi problemi abbiamo corretto alcune parti del ciclo che creano le caselle dei client, abbiamo implementato un sistema in cui, ogni volta che il pannello dei clienti connessi deve essere aggiornato, tutti i client vengono ridisegnati da zero. Infine il pannello al posto di doversi aggiornare ogni tot secondi, si aggiorna quando un cliente si connette, inserisce il nome o si disconnette.

Mentre facevamo dei test, per verificare il funzionamento della chat, ci siamo imbattuti in un errore curioso, infatti ci eravamo chiesti cosa succedesse mettendo come porta della connessione una Well Known Port.
Abbiamo quindi provato ad utilizzare la porta 80, dedicata al servizio http, e il server una volta avviata la chat dal lato client ci ha inviato la risposta che proveniva da google chrome, che nel mentre il client era in funzione, non andava più nella maniera corretta. Essendo questo un problema che poteva presentarsi con gli utenti, che non conoscono le Well Known Port, abbiamo deciso di risolvere questo problema aggiungendo un controllo, che bloccasse l'inserimento di tale tipo di porte.

Durante la creazione del server, abbiamo notato che facendo partire due server sulla medesima porta, entrambi funzionavano, però mentre uno faceva tutte le operazioni normalmente, l’altro rimaneva aperto e non faceva nulla, per risolvere questo problema, prima di far partire il Server Socket abbiamo messo un controllo nel quale si verifica che la porta scelta dall’utente non sia già in utilizzo, nel caso sia già utilizzata il server dice all’utente che la porta è già in uso e di sceglierne un altra.

# 5.Test svolti

Abbiamo stressato il programma, svolgendo vari test dell'applicazione per vedere se si creassero nuovi problemi: abbiamo creato un elevato spam di messaggi, abbiamo scritto messaggi dalla lunghezza molto elavata, abbiamo connesso un numero elevato di utenti, così da portare l'applicazione al limite testando tutti gli accessi concorrenti. I risultati sono stati soddisfacenti, l'applicazione si è comportata molto bene su tutti i fronti.

# 6.Presentazione del funzionamento dell'applicazione
Come nome dell'applicazione abbiamo deciso "Easy SMS".

Per avviare l'applicazione per prima cosa si deve avviare il server, che una volta avviato mostrerà la seguente interfaccia:

![Starter  del Server](images/ServerStarter.png)

Successivamente cliccando sul bottone per creare il server, si aprirà un'altra finestra che consentirà di vedere lo stato del server:

![Stato del Server](images/StatoInizialeServer.png)

Una volta fatto questo ci spostiamo dal server e avviamo il client, che una volta avviato, mostrerà la seguente interfaccia:

![Starter del Client](images/ClientStart.png)

Cliccando sul bottone per collegarsi alla chat, si apre una nuova finestra in cui viene richiesto di inserire il proprio nickname, per poter accedere alla chat: 

![Client Nickname](images/NameClient.png)

Una volta messo il nickname in maniera corretta, si clicca sul tasto di accesso alla chat e si entra nella finestra in cui si possono inviare i messaggi:

![Client Chat](images/chatClient.png)

Successivamente l'utente può iniziare ad inviare messaggi, o aspettare che altri client si colleghino, eccone un esempio:

![Client Chat Esempio](images/EsempioChat.png)

Ora che ci sono connessi più utenti al server torniamo sullo stato del server come è cambiata la situazione:

![Stato del server](images/ServerState.png)

Vediamo un esempio di comunicazione nella chat tra più utenti

![Stato del server](images/EsempioChats.png)

# 7.Conclusioni

Questo progetto si è concluso con successo, le difficoltà incontrate nell'implementazione e nella creazione della chat sono state risolte con più o meno difficoltà. Lo sviluppo sia del codice che dell'interfaccia è avvenuto
gradualmente, partendo da un'idea trasformata in un semplice schizzo per passare successivamente ad una beta dell'applicazione per arrivare poi al progetto terminato.
Esprimendo il nostro punto di vista questo progetto ci ha permesso di crescere molto sia personalmente che come gruppo. Abbiamo imparato a relazionarci in modo efficace, a risolvere problemi lavorando come un team arricchendoci a vicenda e migliorando notevolmente le nostre capacità di programmazione. Le insicurezze e dubbi che avevamo all'inizio sono completamente svaniti e grazie all'esperienza (anche se misera) che ci ha fornito questo compito siamo già pronti ad affrontare lavori simili a testa alta.

Luca Carbone, Giovanni Giove, Matteo Medola
5 gennaio 2025.

