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

    public void setLockedBy(ChipKey lockedBy) {
        this.lockedBy = lockedBy;
    }

    /**
     * @return true if the locker is locked, false otherwise
     */
    public boolean isLocked() {
        return lockedBy != null;
    }

    public void lock(ChipKey key) throws LockerException {
        if (key == null) {
            throw new NullPointerException();
        }

        if (this.isLocked() || key.getLockerLocked() != null && key.getLockerLocked() != this) {
            throw new LockerException();
        }

        this.setLockedBy(key);
        key.setLockerLocked(this);
    }

    public void unlock(ChipKey key) throws LockerException {
        if (key == null) {
            throw new NullPointerException();
        }

        if (!this.isLocked() || key.getLockerLocked() != this) {
            throw new LockerException();
        }

        this.setLockedBy(null);
        key.setLockerLocked(null);
    }
}