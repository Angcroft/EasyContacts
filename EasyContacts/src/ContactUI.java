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
    private JButton saveDeleteButton;

    private JTextArea createNameArea;
    private JTextArea createEmailArea;
    private JTextArea createPhoneArea;
    private JTextArea editNameArea;
    private JTextArea editEmailArea;
    private JTextArea editPhoneArea;
    private JTextArea indexContactArea;
    public JTextArea contactsArea;

    private boolean isAddContactFieldsVisible = false;
    private boolean isEditContactFieldsVisible = false;
    private boolean isDeleteContactFieldsVisible = false;

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

        // Initialize Add Contact Fields
        createNameLabel = new JLabel("Add a Name");
        createNameLabel.setBounds(180, 20, 200, 25);
        createNameArea = new JTextArea();
        createNameArea.setBounds(180, 40, 200, 25);

        createPhoneLabel = new JLabel("Add a Phone number");
        createPhoneLabel.setBounds(180, 60, 200, 25);
        createPhoneArea = new JTextArea();
        createPhoneArea.setBounds(180, 80, 200, 25);

        createEmailLabel = new JLabel("Add an Email");
        createEmailLabel.setBounds(180, 100, 200, 25);
        createEmailArea = new JTextArea();
        createEmailArea.setBounds(180, 120, 200, 25);

        saveContactButton = new JButton("Save");
        saveContactButton.setBounds(180, 160, 80, 25);

        // Initialize Edit Contact Fields
        indexContactLabel = new JLabel("Index of the contact");
        indexContactLabel.setBounds(400, 20, 200, 25);
        indexContactArea = new JTextArea();
        indexContactArea.setBounds(400, 40, 200, 25);

        editNameLabel = new JLabel("Edit the Name");
        editNameLabel.setBounds(180, 20, 200, 25);
        editNameArea = new JTextArea();
        editNameArea.setBounds(180, 40, 200, 25);

        editPhoneLabel = new JLabel("Add a Phone number");
        editPhoneLabel.setBounds(180, 60, 200, 25);
        editPhoneArea = new JTextArea();
        editPhoneArea.setBounds(180, 80, 200, 25);

        editEmailLabel = new JLabel("Add an Email");
        editEmailLabel.setBounds(180, 100, 200, 25);
        editEmailArea = new JTextArea();
        editEmailArea.setBounds(180, 120, 200, 25);

        saveEditButton = new JButton("Save");
        saveEditButton.setBounds(180, 160, 80, 25);

        saveDeleteButton = new JButton("Delete");
        saveDeleteButton.setBounds(400, 80, 80, 25); // Make sure this is not overlapping with others
        saveDeleteButton.setVisible(false); // Initially invisible
        add(saveDeleteButton);

        addContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleAddContactFields();
            }
        });

        editContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleEditContactFields();
            }
        });

        saveContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling method for adding new contact
                addContact(
                        createNameArea.getText(),
                        createPhoneArea.getText(),
                        createEmailArea.getText()
                );

                // Cleaning after saving
                createNameArea.setText("");
                createPhoneArea.setText("");
                createEmailArea.setText("");

                revalidate();
                repaint();
            }
        });

        saveEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling method for editing contact
                editContact(
                        Integer.parseInt(indexContactArea.getText()),
                        editNameArea.getText(),
                        editPhoneArea.getText(),
                        editEmailArea.getText()
                );

                // Clean fields after edit
                indexContactArea.setText("");
                editNameArea.setText("");
                editPhoneArea.setText("");
                editEmailArea.setText("");

                revalidate();
                repaint();
            }
        });

        saveDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact(
                        Integer.parseInt(indexContactArea.getText())
                );

                //  Clean index text after it
                indexContactArea.setText("");

                revalidate();
                repaint();
            }
        });

        deleteContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleDeleteContactFields();
            }
        });

        // Updating contact list
        updateContactList();
    }

    private void toggleAddContactFields() {
        isAddContactFieldsVisible = !isAddContactFieldsVisible;
        createNameLabel.setVisible(isAddContactFieldsVisible);
        createNameArea.setVisible(isAddContactFieldsVisible);
        createPhoneLabel.setVisible(isAddContactFieldsVisible);
        createPhoneArea.setVisible(isAddContactFieldsVisible);
        createEmailLabel.setVisible(isAddContactFieldsVisible);
        createEmailArea.setVisible(isAddContactFieldsVisible);
        saveContactButton.setVisible(isAddContactFieldsVisible);

        if (isAddContactFieldsVisible) {
            add(createNameLabel);
            add(createNameArea);
            add(createPhoneLabel);
            add(createPhoneArea);
            add(createEmailLabel);
            add(createEmailArea);
            add(saveContactButton);
        } else {
            remove(createNameLabel);
            remove(createNameArea);
            remove(createPhoneLabel);
            remove(createPhoneArea);
            remove(createEmailLabel);
            remove(createEmailArea);
            remove(saveContactButton);
        }

        revalidate();
        repaint();
    }

    private void toggleEditContactFields() {
        isEditContactFieldsVisible = !isEditContactFieldsVisible;
        indexContactLabel.setVisible(isEditContactFieldsVisible);
        indexContactArea.setVisible(isEditContactFieldsVisible);
        editNameLabel.setVisible(isEditContactFieldsVisible);
        editNameArea.setVisible(isEditContactFieldsVisible);
        editPhoneLabel.setVisible(isEditContactFieldsVisible);
        editPhoneArea.setVisible(isEditContactFieldsVisible);
        editEmailLabel.setVisible(isEditContactFieldsVisible);
        editEmailArea.setVisible(isEditContactFieldsVisible);
        saveEditButton.setVisible(isEditContactFieldsVisible);

        if (isEditContactFieldsVisible) {
            add(indexContactLabel);
            add(indexContactArea);
            add(editNameLabel);
            add(editNameArea);
            add(editPhoneLabel);
            add(editPhoneArea);
            add(editEmailLabel);
            add(editEmailArea);
            add(saveEditButton);
        } else {
            remove(indexContactLabel);
            remove(indexContactArea);
            remove(editNameLabel);
            remove(editNameArea);
            remove(editPhoneLabel);
            remove(editPhoneArea);
            remove(editEmailLabel);
            remove(editEmailArea);
            remove(saveEditButton);
        }

        revalidate();
        repaint();
    }

    private void toggleDeleteContactFields() {
        isDeleteContactFieldsVisible = !isDeleteContactFieldsVisible;
        indexContactLabel.setVisible(isDeleteContactFieldsVisible);
        indexContactArea.setVisible(isDeleteContactFieldsVisible);
        saveDeleteButton.setVisible(isDeleteContactFieldsVisible);

        if (isDeleteContactFieldsVisible) {
            add(indexContactLabel);
            add(indexContactArea);
            add(saveDeleteButton);
        } else {
            remove(indexContactLabel);
            remove(indexContactArea);
            remove(saveDeleteButton);
        }

        revalidate();
        repaint();
    }

    private void addContact(String contactName, String contactPhone, String contactEmail) {
        // Main logic for adding a contact to ContactList
        Contact newContact = new Contact(contactName, contactPhone, contactEmail);
        ContactManager.addContact(newContact);
        updateContactList();
    }

    private void editContact(int index, String contactName, String contactPhone, String contactEmail) {
        // Main logic for modifying a contact from ContactList
        Contact toEditContact = new Contact(contactName, contactPhone, contactEmail);
        ContactManager.editContact(index, toEditContact);
        updateContactList();
    }

    private void deleteContact(int index) {
        // Main logic for deleting a contact from ContactList
        ContactManager.deleteContact(index);
        updateContactList();
    }

    private void updateContactList() {
        contactsArea.setText(ContactManager.listContacts());
    }
}