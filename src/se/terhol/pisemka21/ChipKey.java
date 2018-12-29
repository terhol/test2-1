package se.terhol.pisemka21;

/**
 * Chip key.
 *
 * @author Tomas Pitner
 */
public class ChipKey {
    private ChipLocker lockerLocked = null;

    /**
     * @return locker locked by the key or null
     */
    public ChipLocker getLockerLocked() {
        return lockerLocked;
    }

    /**
     * Locks the locker, i.e. associates the locker with the key.
     *
     * @param lockerLocked locker to be associated with this key
     */
    void setLockerLocked(ChipLocker lockerLocked) {
        this.lockerLocked = lockerLocked;
    }
}