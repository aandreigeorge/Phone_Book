package phonebook;

public class NameExtractor {


    public static String extractName(String entry) {

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
