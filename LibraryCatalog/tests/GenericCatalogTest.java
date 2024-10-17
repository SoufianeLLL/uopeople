package tests;

import library.LibraryItem;
import library.GenericCatalog;

public class GenericCatalogTest {

    public static void main(String[] args) {

        GenericCatalog<LibraryItem> testCatalog = new GenericCatalog<>();
        
        // Test adding items
        testCatalog.addItem(new LibraryItem<>("Harry Potter and the Goblet of Fire", "J. K. Rowling", 1));
        testCatalog.addItem(new LibraryItem<>("DVD 2006 FIFA World Cup", "Circle Studio Limited", 2));
        testCatalog.addItem(new LibraryItem<>("The Book of Bill", "Alex Hirsch", 3));
        
        // Test viewing catalog
        testCatalog.printCatalog();
        
        // Test removing item
        testCatalog.removeItem(1);
        testCatalog.printCatalog();
        
        // Test removing non existent item
        testCatalog.removeItem(99);
    }
}
