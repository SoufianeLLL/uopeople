import java.util.HashMap;

public class GenericCatalog<T extends LibraryItem> {

	private HashMap<Integer, T> catalog;

	public GenericCatalog() {
		catalog = new HashMap<>();
	}

	public void addItem(T item) {
		catalog.put((Integer) item.getItemID(), item);
		System.out.println("Item added: " + item);
	}

	public void removeItem(int itemID) {
		if (catalog.containsKey(itemID)) {
			T removedItem = catalog.remove(itemID);
			System.out.println("Removed: " + removedItem);
		}
		else {
			System.out.println("Item not found.");
		}
	}


	public void printCatalog() {
		if (catalog.isEmpty()) {
			System.out.println("The catalog is empty.");
		}
		else {
			System.out.println("Library Catalog:");
			for (T item : catalog.values()) {
				System.out.println(item);
			}
		}
	}
}
