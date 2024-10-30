package com.campusdual.classroom;


import java.util.Scanner;

public class Exercise26 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menú del Listín Telefónico");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Seleccionar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    String surnames = scanner.nextLine();
                    System.out.print("Ingrese el número de teléfono: ");
                    String phone = scanner.nextLine();
                    Contact newContact = new Contact(name, surnames, phone);
                    phonebook.addContact(newContact);
                    System.out.println("Contacto añadido.");
                    break;
                case 2:
                    phonebook.showPhonebook();
                    break;
                case 3:
                    System.out.print("Ingrese el código del contacto: ");
                    String code = scanner.nextLine();
                    phonebook.selectContact(code);
                    break;
                case 4:
                    System.out.print("Ingrese el código del contacto a eliminar: ");
                    String deleteCode = scanner.nextLine();
                    phonebook.deleteContact(deleteCode);
                    System.out.println("Contacto eliminado.");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
