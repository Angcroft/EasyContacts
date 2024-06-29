import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add contact");
            System.out.println("2. Edit contact");
            System.out.println("3. Delete contact");
            System.out.println("4. Look contact");
            System.out.println("5. List contacts");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Contact contact = new Contact(name, phone, email);
                    manager.addContact(contact);
                    break;
                case 2:
                    System.out.print("Index the number to edit: ");
                    int indexEditor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New name: ");
                    name = scanner.nextLine();
                    System.out.print("New phone: ");
                    phone = scanner.nextLine();
                    System.out.print("New email: ");
                    email = scanner.nextLine();
                    contact = new Contact(name, phone, email);
                    manager.editContact(indexEditor, contact);
                    break;
                case 3:
                    System.out.print("Index the number to delete: ");
                    int indexDelete = scanner.nextInt();
                    manager.deleteContact(indexDelete);
                    break;
                case 4:
                    System.out.print("Name the contact you want to look: ");
                    name = scanner.nextLine();
                    contact = manager.lookContactByName(name);
                    if(contact != null) {
                        System.out.println(contact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 5:
                    manager.listContacts();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    scanner.close();    //  Closing the Scanner loop
                    return;
                default:
                    System.out.println("Not valid option.");
            }
        }
    }
}
