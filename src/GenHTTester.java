public class GenHTTester {
    public static void main(String[] args) {
        // Hashtabelle mit 10 Einträgen
        GenHT<String, Integer> hashtable = new GenHT<>(10);

        // Key-Value-Paare einfügen
        hashtable.insert("Lisa", 1);
        hashtable.insert("Paula", 10);
        hashtable.insert("Anton", 2);
        hashtable.insert("Felix", 3);

        // Values auslesen
        System.out.println(hashtable.get("Lisa"));
        System.out.println(hashtable.get("Paula"));
        System.out.println(hashtable.get("Anton"));
        System.out.println(hashtable.get("Felix"));

        // Key-Value-Paaren entfernen
        hashtable.remove("Paula");
        System.out.println(hashtable.get("Paula")); // --> null
        System.out.println(hashtable.get("Anton"));

        // Größe der Hashtabelle
        System.out.println(hashtable.size); // --> 3
    }
}
