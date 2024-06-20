package phonebook;

import java.util.Objects;

class PhoneBookContact {

    private final String number;
    private final String name;

    PhoneBookContact(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PhoneBookContact other = (PhoneBookContact) obj;
        return Objects.equals(name, other.name);
    }

}
