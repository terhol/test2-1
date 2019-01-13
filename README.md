# Test 2-1
Second test version 1 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description
Do not change interface or already defined classes, if the task doesn’t require it explicitly! You do not have to document methods by JavaDoc comments. Use private attributes only.

This task simulates locking the lockers in a changing room (for example in a swimming pool) by electronic locks and keys. The following must be applied:

1.  Each locker can be locked by every (chip )key.
2.  If a locker is locked by a key, this key cannot lock another locker until the original locker is unlocked.
3.  A locker can be unlocked only by the key which has locked it.
4.  Information about which locker is locked by which key is saved in locker and key, in other words the key remembers which locker it locked and vice versa. There is not central administration.

**Task:**

-   Add methods for locking and unlocking into `ChipLocker` class.
The `void lock(ChipKey key)` is defined by following documentation:


        /**
         * Attempts to lock the locker by given key.
         *
         * @param key key
         * @throws NullPointerException if the given key is null
         * @throws LockerException if the locker is already locked or
         *     if the given key alredy locks some another locker
         */


   The `void unlock(ChipKey key)` is defined by following documentation:

        /**
         * Attempts to unlock the locker by given key.
         *
         * @param key key
         * @throws NullPointerException if the given key is null
         * @throws LockerException if the locker is either not locked or
         *     is locked by another key
         */

-   Create **checked** `LockerException` exception. This exception will have two constructors: one without parameters and one with textual error description.
-   Use `ChangeRoom` class which represents the changing room. This class will be implemented by **arrays** (not collections!) and will have following characteristics:
    -   Number of lockers is given by constructor parameter. Constructor creates and saves given numbers of locks (lockers) and keys.
    -   This class will have 
        `boolean tryToLock(int keyId, int lockerId)` ane
        `boolean tryToUnlock(int keyId, int lockerId)` methods, where `KeyID` and `lockerID` are serial numbers of keys\locks (indexed from zero). Methods take given key and try to lock\unlock the locker. If they are successful, they return true, otherwise they return false. These methods do not throw `LockerException`. They must catch it and transform it into correct return value true\false.
NOTE: If the key or lock number is not valid (out of array range), the `IndexOutOfBoundsException` exception is thrown and you do not need to handle it, system will throw it automatically.

`Demo` class is for checking code functionality and also contains logic of method calling. The right output should look like this:

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
