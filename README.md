# SK2-NetworkBridge
Projekt zaliczeniowy z przedmiotu Sieci Komputerowe 2 na piątym semestrze Informatyki na Politechnice Poznańskiej.  

Jest to implementacja brydża (wstępnie) w uproszczonej formie - bez dziadka.  

Pliki źródłowe po stronie serwera:  
-> mainS.cpp - funkcja tworząca serwer  
-> server.h - klasa obsługująca serwer, żądania klientów; tworzy wątek dla każdego nowego klienta; otrzymane wiadomości przekazuje niezmienione do menadżera w gameManager.h, stamtąd też pobiera wiadomości do wysłania; współbieżność możliwa dzięki mutexom  
-> gameManager.h - klasa zarządzająca rozgrywkami; tworzy nowe stoły i graczy; interpretuje otrzymane wiadomości i tworzy odpowiedzi na nie  
-> table.h - klasa stołu, przy którym "siedzą" gracze; zarządza rozgrywką na danym stole; rozdaje karty; wyznacza kolejność  
-> player.h - klasa gracza; przechowuje jego dane, karty  
-> message.h - klasa wiadomości; formatuje otrzymaną wiadomość na typ i treść według listy podanej poniżej; tworzy nowe wiadomości  
-> card.h - klasa karty; przechowuje jej typ oraz kolor  
-> makefile  

Pliki źródłowe po stronie klienta:  
-> Client.java - klasa z metodą główną; tworzy kontroler  
-> ConnectionController.java - klasa, w której otrzymywane i wysyłane są wiadomości; przekazuje polecenia do widoków; przełącza pomiędzy widokami  
-> Message.java - podobnie jak w serwerze, klasa formatuje otrzymane wiadomości i tworzy nowe; interpretuje podane wiadomości  
-> GameModel.java - pierwotnie miał być to model rozgrywki, jednak w trakcie pisania stwierdziłem, że tak naprawdę nie potrzebuję modelu, bo klient nie potrzebuje przechowywać danych o rozgrywce; całą grą zarządza serwer; klient jedynie otrzymuje i interpretuje wiadomości oraz odpowiada na zdarzenia; ostatecznie klasa przechowuje jedynie dwie zmienne  
-> ConnectionView.java - widok połączenia się z serwerem  
-> TablesView.java - widok wybierania stołu do gry  
-> GameView.java - widok gry; licytacja oraz sama gra  

Poniżej opisane są komunikaty w następujący sposób: [nazwa] - [format_komunikatu] - [src]->[dst] - [opis].  
-> DISCONNECTED  
-> NICKNAME - 01:[nickname] - klient->serwer - wysyłany na początku nickname gracza  
-> SEND_TABLES - 02:[id_stołu]-[liczba_graczy],... - serwer->klient - wysyłany po połączeniu (docelowo także w odpowiedzi na żądanie klienta po wciśnięciu przycisku)  
-> CREATE_TABLE - 03: - klient->serwer - chęć utworzenia nowego stołu  
-> JOIN_TABLE - 02:[id_stołu] - klient->serwer - chęć dołączenia do wybranego stołu  
-> CARDS - 05:[kolor][typ],... - serwer->klient - karty należące do gracza, wysyłane po każdej rundzie  
-> START_BID - 06: - serwer->klient - zachęta do licytacji  
-> GIVEN_BID - 07:[typ][wysokość] - klient->serwer - wybrana licytacja  
-> SEND_BID - 08:[gracz][typ][wysokość] - serwer->klient - informacja o wybranej licytacji  
-> BIDDING_RESULT - 09:[numer_gracza] - serwer->klient - przesyła zwycięzcę licytacji (0 - zwycięzca, 1 - pierwszy gracz po zwycięzcy itd.)  
-> PLAY_CARD - 10: - serwer->klient - zachęta do zagrania karty  
-> GIVEN_CARD - 11:[kolor][typ] - klient->serwer - zagrana karta  
-> SEND_CARD - 12:[gracz][kolor][typ] - serwer->klient - informacja o zagranej karcie  
-> ROUND_OVER - 13:[gracz] - serwer->klient - informacja o zwycięzcy rundy (0 - zwycięzca itd.)  
-> GAME_RESULT - 14:[nr_zwycięstwa] - serwer->klient - informacja o zwycięzcy gry (0 - zwycięzca, 1 - przegrany)  
-> ACCEPTANCE - 15:[nr_wiadomości]-[czy_zaakceptowano(T/F)] - klient->serwer - potwierdzenie poprawności otrzymanego komunikatu (na przykład zagranej karty, licytacji, możliwości dołączenia do stołu)  

Aby uruchomić serwer, należy go skompilować poleceniem "make" i włączyć. Aby uruchomić klienta, należy włączyć plik .jar ("java -jar client.jar").  

Serwer z klientem komunikują się za pomocą socketów.  
Serwer dla każdego klienta uruchamia osobny wątek, uruchamia taki tównież do zarządzania rozgrywką, a wątek główny nasłuchuje na nowych klientów. Wiadomości odczytywane są bajt po bajcie w oczekiwaniu na zakończenie wiadomości znakiem '&'. Wątki komunikują się z menadżerem gry, blokując dostęp do niego poprzez mutexy. Komunikacja polega na dokładaniu do kolejki komunikatów otrzymanych nowych wiadomości oraz odczytywaniu z kolejki komunikatów do wysłania, a także na poleceniu zaktualizowania danych (przeliczenia kart na stole itp.).  
Klient również uruchamia dodatkowy wątek w celu pobierania wiadomości z serwera. Wiadomości otrzymywane muszą być zakończone znakiem nowej linii.  
