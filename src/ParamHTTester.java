public class ParamHTTester {
    public static void main(String[] args) {

        // Hashtabelle mit 10 Einträgen
        ParamHT<String, Integer> hashtable = new ParamHT<>(10);

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

        // Größe der Hashtabelle
        System.out.println(hashtable.size); // --> 3

        // Hashtabelle mit der Hashfunktion
        ParamHT<String, Integer> customHashtable = new ParamHT<>(10, (key, m) -> key.length() % m);

        // Key-Value-Paare einfügen
        customHashtable.insert("Apfel", 10);
        customHashtable.insert("Pfirsich", 20);
        customHashtable.insert("Kiwi", 30);
        customHashtable.insert("Orange", 40);

        // Values auslesen
        System.out.println(customHashtable.get("Apfel"));
        System.out.println(customHashtable.get("Kiwi"));
        System.out.println(customHashtable.get("Orange"));

        // Key-Value-Paaren entfernen
        customHashtable.remove("Pfirsich");
        System.out.println(customHashtable.get("Pfirsich")); // --> null
        System.out.println(customHashtable.get("Kiwi"));

        // Größe der Hashtabelle
        System.out.println(customHashtable.size); // --> 3
    }
}
