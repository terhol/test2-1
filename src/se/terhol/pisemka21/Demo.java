package se.terhol.pisemka21;

/**
 * @author Tomas Pitner
 */
public class Demo {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChangeRoom room = new ChangeRoom(10);

        boolean success = true;

        // test locking
        success &= tryToLock(room, 9, 0);
        success &= tryToLock(room, 5, 1);
        success &= !tryToLock(room, 5, 0);
        success &= !tryToLock(room, 5, 1);
        success &= !tryToLock(room, 5, 2);

        // test unlocking
        success &= !tryToUnlock(room, 5, 2);
        success &= tryToUnlock(room, 9, 0);
        success &= !tryToUnlock(room, 9, 1);
        success &= tryToUnlock(room, 5, 1);

        System.out.println("Tests: " + (success ? "OK" : "ERROR"));
    }

    private static boolean tryToLock(ChangeRoom room, int key, int locker) {
        boolean ret = room.tryToLock(key, locker);
        System.out.println("Locking the locker " + locker + " with key " + key + ": " + (ret ? "success" : "failure"));
        return ret;
    }

    private static boolean tryToUnlock(ChangeRoom room, int key, int locker) {
        boolean ret = room.tryToUnlock(key, locker);
        System.out.println("Unlocking the locker " + locker + " with key " + key + ": " + (ret ? "success" : "failure"));
        return ret;
    }
}