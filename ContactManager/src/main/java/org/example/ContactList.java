package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactList {
    Logger ou = Logger.getLogger("com.api.jar");
    private Map<String, Contact> contacts;

    public ContactList() {
        contacts = new HashMap<String, Contact>();
    }

    public void addContact(String name, String phoneNumber, String email) {
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.put(name, contact);
        ou.log(Level.INFO,()->"Contact added successfully!");
    }

    public void deleteContact(String name) {
        Contact contact = contacts.get(name);
        if (contact != null) {
            contacts.remove(name);
            ou.log(Level.INFO,()->"Contact deleted successfully!");
        } else {
            ou.log(Level.INFO,()->"Contact not found.");
        }
    }

    public void searchContact(String name) {
        Contact contact = contacts.get(name);
        if (contact != null) {
            ou.log(Level.INFO,()->"Name: " + contact.getName());
            ou.log(Level.INFO,()->"Phone Number: " + contact.getPhoneNumber());
            ou.log(Level.INFO,()->"Email Address: " + contact.getEmail());
        } else {
            ou.log(Level.INFO,()->"Contact not found.");
        }
    }

    public static void main(String[] args) {
        Logger ou = Logger.getLogger("com.api.jar");
        Scanner scanner = new Scanner(System.in);
        ContactList contactList = new ContactList();

        while (true) {
            ou.log(Level.INFO,()->"1. Add Contact");
            ou.log(Level.INFO,()->"2. Delete Contact");
            ou.log(Level.INFO,()->"3. Search Contact");
            ou.log(Level.INFO,()->"4. Exit");
            ou.log(Level.INFO,()->"Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ou.log(Level.INFO,()->"Enter name: ");
                    String name = scanner.nextLine();
                    ou.log(Level.INFO,()->"Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    ou.log(Level.INFO,()->"Enter email address: ");
                    String email = scanner.nextLine();
                    contactList.addContact(name, phoneNumber, email);
                    break;
                case 2:
                    ou.log(Level.INFO,()->"Enter the Name: ");
                    name = scanner.nextLine();
                    contactList.deleteContact(name);
                    break;
                case 3:
                    ou.log(Level.INFO,()->"Enter thee name: ");
                    name = scanner.nextLine();
                    contactList.searchContact(name);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    ou.log(Level.INFO,()->"Invalid choice. Please try again.");
            }

            ou.log(Level.INFO,()->"");
        }
    }
}

