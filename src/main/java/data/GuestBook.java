package data;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by alex on 24.02.17.
 */
public class GuestBook {
    private static final Comparator<LocalDateTime> DATE_COMPARATOR = Comparator.reverseOrder();
    TreeMap<LocalDateTime, String> guestBookMap = new TreeMap<>(DATE_COMPARATOR);

    public TreeMap<LocalDateTime, String> getGuestBookMap() {
        return this.guestBookMap;
    }

    public void putGuestBookEntry(LocalDateTime time, String name, String message, String rating) {
        String entry = name + " - " + message + " - " + rating + " at ";
        guestBookMap.put(time, entry);
    }
}