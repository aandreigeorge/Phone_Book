package phonebook;

class Utils {

    static String formatTime(long milliseconds) {

        long minutes = milliseconds / 60000;
        long seconds = (milliseconds % 60000) / 1000;
        long millis = milliseconds % 1000;

        return String.format("%d min. %d sec. %d ms.", minutes, seconds, millis);
    }

    static String extractName(String entry) {

        StringBuilder fullName = new StringBuilder();
        String[] parts = entry.split(" "); // Split by whitespace

        for (int i = 1; i < parts.length; i++) {
            fullName.append(parts[i]);
            if (i < parts.length - 1) {  // Append space only if it's not the last part
                fullName.append(" ");
            }
        }
        return fullName.toString();
    }
}
