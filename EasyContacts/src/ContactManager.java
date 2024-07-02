import java.util.ArrayList;

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    // Add contact
    public static void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Edit contact
    public static void editContact() {
    }

    // Delete contact
    public static void deleteContact() {
    }

    // Look contact by name
    public static Contact lookContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    // List all contact
    public static String listContacts() {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : contacts) {
            sb.append(contact).append("\n");
        }
        return sb.toString();
    }
}