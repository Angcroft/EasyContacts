import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactUI extends JFrame {
    private JLabel contactsLabel;
    private JLabel createNameLabel;
    private JLabel createEmailLabel;
    private JLabel createPhoneLabel;
    private JLabel editNameLabel;
    private JLabel editEmailLabel;
    private JLabel editPhoneLabel;
    private JLabel indexContactLabel;

    private JButton addContactButton;
    private JButton editContactButton;
    private JButton deleteContactButton;
    private JButton lookContactButton;
    private JButton saveContactButton;
    private JButton saveEditButton;

    private JTextArea createNameArea;
    private JTextArea createEmailArea;
    private JTextArea createPhoneArea;
    private JTextArea editNameArea;
    private JTextArea editEmailArea;
    private JTextArea editPhoneArea;
    private JTextArea indexContactArea;
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
                createNameLabel.setBounds(180, 20, 200, 25);
                add(createNameLabel);

                createNameArea = new JTextArea();
                createNameArea.setBounds(180, 40, 200, 25);
                add(createNameArea);

                createPhoneLabel = new JLabel("Add a Phone number");
                createPhoneLabel.setBounds(180, 60, 200, 25);
                add(createPhoneLabel);

                createPhoneArea = new JTextArea();
                createPhoneArea.setBounds(180, 80, 200, 25);
                add(createPhoneArea);

                createEmailLabel = new JLabel("Add an Email");
                createEmailLabel.setBounds(180, 100, 200, 25);
                add(createEmailLabel);

                createEmailArea = new JTextArea();
                createEmailArea.setBounds(180, 120, 200, 25);
                add(createEmailArea);

                saveContactButton = new JButton("Save");
                saveContactButton.setBounds(180, 160, 80, 25);
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

                                        //  Cleaning after saving
                        createNameArea.setText("");
                        createPhoneArea.setText("");
                        createEmailArea.setText("");

                        revalidate();
                        repaint();

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
                indexContactLabel = new JLabel("Index of the contact");
                indexContactLabel.setBounds(400, 20, 200, 25);
                add(indexContactLabel);

                indexContactArea = new JTextArea();
                indexContactArea.setBounds(400, 40, 200, 25);
                add(indexContactArea);

                editNameLabel = new JLabel("Edit the Name");
                editNameLabel.setBounds(180, 20, 200, 25);
                add(editNameLabel);

                editNameArea = new JTextArea();
                editNameArea.setBounds(180, 40, 200, 25);
                add(editNameArea);

                editPhoneLabel = new JLabel("Add a Phone number");
                editPhoneLabel.setBounds(180, 60, 200, 25);
                add(editPhoneLabel);

                editPhoneArea = new JTextArea();
                editPhoneArea.setBounds(180, 80, 200, 25);
                add(editPhoneArea);

                editEmailLabel = new JLabel("Add an Email");
                editEmailLabel.setBounds(180, 100, 200, 25);
                add(editEmailLabel);

                editEmailArea = new JTextArea();
                editEmailArea.setBounds(180, 120, 200, 25);
                add(editEmailArea);

                saveEditButton = new JButton("Save");
                saveEditButton.setBounds(180, 160, 80, 25);
                add(saveEditButton);

                saveContactButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Calling method for adding new contact
                        editContact(
                            Integer.parseInt(indexContactArea.getText()),
                            editNameArea.getText(), 
                            editPhoneArea.getText(),
                            editEmailArea.getText()
                            );

                        //  Clean fields after edit
                        indexContactArea.setText("");
                        editNameArea.setText("");
                        editPhoneArea.setText("");
                        editEmailArea.setText("");

                        revalidate();
                        repaint();

                    }
                });
                revalidate();
                repaint();
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

    private void editContact(int index, String contactName, String contactPhone, String contactEmail) {
        //  Main logic for modifying a contact from ContactList
        Contact toEditContact = new Contact(contactName, contactPhone, contactEmail);
        ContactManager.editContact(index, toEditContact);
        updateContactList();
    }

    private void updateContactList() {
        contactsArea.setText(ContactManager.listContacts());
    }
}