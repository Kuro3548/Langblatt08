public class SimpleHTTester {
    public static void main(String[] args) {
        // Hashtabelle mit 10 Einträgen
        SimpleHT hashtable = new SimpleHT(10);

        // Key-Value-Paare einfügen
        hashtable.insert(1, 10);
        hashtable.insert(10, 3); // Kollision
        hashtable.insert(2, 20);
        hashtable.insert(3, 30);

        System.out.println("Hashtable: \n" + hashtable);
        // Values auslesen
        System.out.println(hashtable.get(1));
        System.out.println(hashtable.get(10));
        System.out.println(hashtable.get(2));
        System.out.println(hashtable.get(3));

        // Key-Value-Paaren entfernen
        hashtable.remove(2);
        System.out.println(hashtable.get(2)); // --> null
        System.out.println(hashtable.get(3));

        System.out.println("Hashtable: \n" + hashtable);
        // Größe der Hashtabelle
        System.out.println(hashtable.size); // --> 3
    }
}
