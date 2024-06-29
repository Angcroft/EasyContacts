import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    //  Add a contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    //  Edit a contact
    public void editContact(int index, Contact contact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, contact);
        }
    }

    //  Delete a contact
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    //  Look a contact by name
    public Contact lookContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;

    }

    //  List all contacts
    public void listContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
