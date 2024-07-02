import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactUI extends JFrame {
    private JLabel contactsLabel;
    private JLabel createNameLabel;
    private JLabel createEmailLabel;
    private JLabel createPhoneLabel;
    private JButton addContactButton;
    private JButton editContactButton;
    private JButton deleteContactButton;
    private JButton lookContactButton;
    private JButton saveContactButton;
    private JTextArea createNameArea;
    private JTextArea createEmailArea;
    private JTextArea createPhoneArea;
    public JTextArea contactsArea;

    public ContactUI() {
        // Window
        setTitle("EasyContacts: Contact agenda in Java");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        addContactButton = new JButton("Add contact");
        addContactButton.setBounds(10, 40, 150, 25);
        add(addContactButton);

        editContactButton = new JButton("Edit contact");
        editContactButton.setBounds(10, 80, 150, 25);
        add(editContactButton);

        deleteContactButton = new JButton("Delete contact");
        deleteContactButton.setBounds(10, 120, 150, 25);
        add(deleteContactButton);

        lookContactButton = new JButton("Look contact");
        lookContactButton.setBounds(10, 160, 150, 25);
        add(lookContactButton);

        contactsLabel = new JLabel("Contacts:");
        contactsLabel.setBounds(10, 200, 200, 25);
        add(contactsLabel);

        contactsArea = new JTextArea();
        contactsArea.setBounds(10, 220, 450, 300);
        contactsArea.setEditable(false);
        add(contactsArea);

        addContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createNameLabel = new JLabel("Add a Name");
                createNameLabel.setBounds(170, 16, 200, 25);
                add(createNameLabel);

                createNameArea = new JTextArea();
                createNameArea.setBounds(170, 40, 200, 25);
                add(createNameArea);

                createPhoneLabel = new JLabel("Add a Phone number");
                createPhoneLabel.setBounds(400, 16, 200, 25);
                add(createPhoneLabel);

                createPhoneArea = new JTextArea();
                createPhoneArea.setBounds(400, 40, 200, 25);
                add(createPhoneArea);

                createEmailLabel = new JLabel("Add an Email");
                createEmailLabel.setBounds(630, 16, 200, 25);
                add(createEmailLabel);

                createEmailArea = new JTextArea();
                createEmailArea.setBounds(630, 40, 200, 25);
                add(createEmailArea);

                saveContactButton = new JButton("Save");
                saveContactButton.setBounds(630, 80, 80, 25);
                add(saveContactButton);

                saveContactButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Calling method for adding new contact
                        addContact(
                            createNameArea.getText(), 
                            createPhoneArea.getText(),
                            createEmailArea.getText()
                            );
                    }
                });
                revalidate();
                repaint();
            }
        });

        editContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling method for editing contact
                ContactManager.editContact();
            }
        });

        deleteContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling method for deleting contact
                ContactManager.deleteContact();
            }
        });

        // Updating contact list
        updateContactList();
    }

    private void addContact(String contactName, String contactPhone, String contactEmail) {
        // Main logic for adding a contact to ContactList
        Contact newContact = new Contact(contactName, contactPhone, contactEmail);
        ContactManager.addContact(newContact);
        updateContactList();
    }

    private void updateContactList() {
        contactsArea.setText(ContactManager.listContacts());
    }
}