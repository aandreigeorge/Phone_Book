package phonebook;

class TimeFormatter {


    static String formatTime(long milliseconds) {

        long minutes = milliseconds / 60000;
        long seconds = (milliseconds % 60000) / 1000;
        long millis = milliseconds % 1000;

        return String.format("%d min. %d sec. %d ms.", minutes, seconds, millis);
    }
}
