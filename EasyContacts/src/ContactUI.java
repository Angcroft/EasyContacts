import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactUI extends JFrame {
    private JLabel contactsLabel;
    private JButton addContactButton;
    private JButton editContactButton;
    private JButton deleteContactButton;
    private JButton lookContactButton;

    public ContactUI() {
        //  Window
        setTitle("EasyContacts: Contact agenda in Java");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        addContactButton = new JButton("Add contact");
        addContactButton.setBounds(10,40,100,25);
        add(addContactButton);

        editContactButton = new JButton("Edit contact");
        editContactButton.setBounds(10, 80, 100, 25);
        add(editContactButton);

        deleteContactButton = new JButton("Delete contact");
        deleteContactButton.setBounds(10, 120, 100,  25);
        add(deleteContactButton);

        lookContactButton = new JButton("Look contact");
        lookContactButton.setBounds(10, 160, 100, 25);
        add(lookContactButton);

        contactsLabel = new JLabel("Contacts: ");
        contactsLabel.setBounds(10, 400, 200, 25);
        add (contactsLabel);
    }
}
