# Test 2-1
Second test version 1 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description (Czech language only)

Rozhraní ani třídu `Demo` neměňte, pokud to přímo nevyžaduje zadání!
Metody NEMUSÍTE dokumentovat pomocí JavaDoc komentářů. Používejte
zásadně privátní atributy.

Zadání simuluje zamykání skříněk v šatně (např. v bazénu) pomocí
elektronických zámků a klíčů. Platí:

1.  Libovolným (čipovým) klíčem se dá zamnout libovolná skříňka.
2.  Jakmile klíč zamkne skříňku, nemůže zamknout žádnou další až do
    odemčení.
3.  Skříňku lze odemknout jen klíčem, který ji zamknul.
4.  Informace o tom, která skříňka je zamčena kterým klíčem, je uložena
    v zámku skříňky a v klíči, tj. klíč si pamatuje zámek, který zamkl a
    naopak. Není zde žádná centrální správa.

**Zadání:**

-   Do třídy `ChipLocker` doplňte metody pro odemykání a zamykání.\
     Metoda `void lock(ChipKey key)` je definována následující
    dokumentací:

        /**
         * Attempts to lock the locker by given key.
         *
         * @param key key
         * @throws NullPointerException if the given key is null
         * @throws LockerException if the locker is already locked or
         *     if the given key alredy locks some another locker
         */


    Metoda `void unlock(ChipKey key)` je definována následujícím
    dokumentací:

        /**
         * Attempts to unlock the locker by given key.
         *
         * @param key key
         * @throws NullPointerException if the given key is null
         * @throws LockerException if the locker is either not locked or
         *     is locked by another key
         */

-   Vytvořte **hlídanou** výjimku `LockerException`. Výjimka bude mít
    dva konstruktory: bezparametrický a s textovým popisem chyby.
-   Vytvořte třídu `ChangeRoom` představující šatnu. Třída bude
    implementována **pomocí polí** (nikoliv kolekcí!) a bude mít
    následující vlastnosti:
    -   Počet skříněk je dán jako parametr konstruktoru. Konstruktor
        vytvoří a uloží příslušný počet zámků (skříněk) a klíčů.
    -   Třída bude mít metody
        `boolean tryToLock(int keyId, int lockerId)` a
        `boolean tryToUnlock(int keyId, int lockerId)`, kde `keyId` a
        `lockerId` jsou pořadová čísla klíčů/zámků (indexováno od nuly).
        Metody vezmou příslušný klíč a zámek a pokusí se
        zamknout/odemknout. Pokud operace uspěje, vrátí true, pokud
        neuspěje vrítí false. Metody NEBUDOU vyhazovat výjimku
        `LockerException`. Naopak, musí ji odchytit a "převést" na
        návratovou hodnotu true/false. \
         Pozn: Pokud je číslo klíče nebo zámku neplatné (mimo rozsah
        pole), vyhodí se výjimka `IndexOutOfBoundsException`, tj.
        nemusíte to ošetřovat, systém ji vyhodí sám.

Třída `Demo` slouží pro vaši kontrolu funkčnosti kódu a obsahuje také
logiku volání metod. Správný výstup by měl vypadat následovně:

    Locking the locker 0 with key 9: success
    Locking the locker 1 with key 5: success
    Locking the locker 0 with key 5: failure
    Locking the locker 1 with key 5: failure
    Locking the locker 2 with key 5: failure
    Unlocking the locker 2 with key 5: failure
    Unlocking the locker 0 with key 9: success
    Unlocking the locker 1 with key 9: failure
    Unlocking the locker 1 with key 5: success
    Tests: OK

## License
MIT