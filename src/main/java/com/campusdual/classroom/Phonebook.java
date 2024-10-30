package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private Map<String, Contact> data;

    public Phonebook() {
        this.data = new HashMap<>();
    }

    public void addContact(Contact contact) {
        data.put(contact.getCode(), contact);
    }

    public void deleteContact(String code) {
        data.remove(code);
    }

    public void showPhonebook() {
        for (Contact contact : data.values()) {
            contact.showContactDetails();
            System.out.println("-------------------");
        }
    }

    public void selectContact(String code) {
        Contact contact = data.get(code);
        if (contact != null) {
            showContactMenu(contact);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public Map<String, Contact> getData() {
        return this.data;
    }

    private void showContactMenu(Contact contact) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menú de acciones para " + contact.getName());
            System.out.println("1. Llamar a mi número");
            System.out.println("2. Llamar a otro número");
            System.out.println("3. Mostrar detalles de contacto");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    contact.callMyNumber();
                    break;
                case 2:
                    System.out.print("Ingrese el número a llamar: ");
                    String number = scanner.next();
                    contact.callOtherNumber(number);
                    break;
                case 3:
                    contact.showContactDetails();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 4);
    }
}
