package library;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		GenericCatalog<LibraryItem> catalog = new GenericCatalog<>();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("\nLibrary Catalog Menu");
			System.out.println("1. Add Item");
			System.out.println("2. Remove Item");
			System.out.println("3. View Catalog");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1:
					System.out.print("Enter title: ");
					String title = scanner.nextLine();
					System.out.print("Enter author: ");
					String author = scanner.nextLine();
					System.out.print("Enter item ID: ");
					int id = scanner.nextInt();
					catalog.addItem(new LibraryItem<>(title, author, id));
				break;
				case 2:
					System.out.print("Enter item ID to remove: ");
					int removeId = scanner.nextInt();
					catalog.removeItem(removeId);
				break;
				case 3:
					catalog.printCatalog();
				break;
				case 4:
					System.out.println("Exiting...");
					scanner.close();
				return;
				default:
					System.out.println("Invalid choice.");
			}
		}
	}
}
