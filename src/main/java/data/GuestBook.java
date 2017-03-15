package data;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.TreeMap;

public class GuestBook {
    private static final Comparator<LocalDateTime> DATE_COMPARATOR = Comparator.reverseOrder();
    TreeMap<LocalDateTime, Entry> guestBookMap = new TreeMap<>(DATE_COMPARATOR);

    public TreeMap<LocalDateTime, Entry> getGuestBookMap() {
        return this.guestBookMap;
    }

    public void putGuestBookEntry(LocalDateTime time, String name, String message, int rating) {
        Entry entry = new Entry(name, message, rating );
        guestBookMap.put(time, entry);
    }
}