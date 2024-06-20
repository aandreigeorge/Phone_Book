package phonebook;

import java.util.HashSet;
import java.util.List;

class Utils {

    static String formatTime(long milliseconds) {

        long minutes = milliseconds / 60000;
        long seconds = (milliseconds % 60000) / 1000;
        long millis = milliseconds % 1000;

        return String.format("%d min. %d sec. %d ms.", minutes, seconds, millis);
    }

    static String extractPhoneNumber(String entry) {

        String[] parts = entry.split(" ", 2);
        return parts[0];
    }

    static String extractName(String entry) {

        String[] parts = entry.split(" ", 2); // Split by first space only
        return parts[1];
    }

    static HashSet<PhoneBookContact> convertToHashSet(List<String> list) {

        HashSet<PhoneBookContact> contactsHashSet = new HashSet<>();

        if (list.get(0).matches(".*\\d.*")) {
            for (String entry : list) {
                String number = Utils.extractPhoneNumber(entry);
                String name = Utils.extractName(entry);
                contactsHashSet.add(new PhoneBookContact(number, name));
            }
        } else {
            for (String entry : list) {
                contactsHashSet.add(new PhoneBookContact(null, entry));
            }
        }

        return contactsHashSet;
    }
}
