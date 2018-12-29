package se.terhol.pisemka21;

/**
 * @author Tereza Holm
 */
public class ChangeRoom {
    private ChipLocker[] lockers;
    private ChipKey[] keys;

    public ChangeRoom(int numberOfLockers) {
        ChipLocker[] lockers = new ChipLocker[numberOfLockers];
        for (int i = 0; i < numberOfLockers; i++) {
            lockers[i] = new ChipLocker();
        }
        this.lockers = lockers;
        ChipKey[] keys = new ChipKey[numberOfLockers];
        for (int i = 0; i < numberOfLockers; i++) {
            keys[i] = new ChipKey();
        }
        this.keys = keys;
    }

    public boolean tryToLock(int keyId, int lockerId) {
        try {
            lockers[lockerId].lock(keys[keyId]);
            return lockers[lockerId].getLockedBy() == keys[keyId];
        } catch (LockerException le) {
            System.err.println(le.getMessage());
        }

        return false;
    }

    public boolean tryToUnlock(int keyId, int lockerId) {
        try {
            lockers[lockerId].unlock(keys[keyId]);
            return !lockers[lockerId].isLocked();
        } catch (LockerException le) {
            System.err.println(le.getMessage());
        }

        return false;
    }
}
