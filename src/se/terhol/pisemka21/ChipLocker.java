package se.terhol.pisemka21;

/**
 * Chip locker.
 *
 * @author Tomas Pitner
 */
public class ChipLocker {
    private int id;
    private ChipKey lockedBy = null;

    /**
     * @return locking key or null
     */
    public ChipKey getLockedBy() {
        return lockedBy;
    }

    /**
     * @return true if the locker is locked, false otherwise
     */
    public boolean isLocked() {
        return lockedBy != null;
    }
}