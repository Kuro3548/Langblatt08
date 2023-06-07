import java.util.ArrayList;
import java.util.List;
/**
 * Eine einfache Hashtabelle, <br>
 * Speichert ganzzahlige Werte und ganzzahlige Schlüssel als Paare ab.
 */
public class SimpleHT{
    /**
     * Anzahl an Elementen in der Datenstruktur
     */
    public int size;
    /**
     * Listen, die Elemente verwalten
     */
    public final List<List<Pair>> data;

    /**
     * Verwaltet ein Paar von Schlüssel und Wert
     */
    public static class Pair{
        /**
         * Eindeutiger Schlüssel, der einen Wert verschlüsselt
         */
        private final Integer key;
        /**
         * Wert, der von dem Schlüssel verschlüsselt ist
         */
        private final Integer value;

        /**
         * Erstellt ein neues Schlüssel-Wert-Paar
         * @param key Schlüssel des Werts
         * @param value Verschlüsselter Wert
         */
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        public Integer getKey(){
            return key;
        }
        public Integer getValue(){
            return value;
        }
        @Override
        public String toString(){
            return "(" + key + " | " + value + ")";
        }
    }

    /**
     * Erstellt eine neue Hashtabelle für Integer mit Integer-Schlüsseln. <br>
     * Die Hash-Funktion ist eine einfache Modulo-Rechnung
     * @param capacity Anzahl an Listen
     */
    public SimpleHT(int capacity) {
        this.data = new ArrayList<>();
        this.size = 0;
        for(int i = 0; i < capacity; i++){
            data.add(new ArrayList<>());
        }
    }

    /**
     * Wendet die Hashfunktion an.
     * @param key Der Schlüssel eines Elements
     * @return Adresse der verketteten Liste, also der Index der Liste
     * @throws IllegalArgumentException Wenn die Tabelle leer ist
     */
    public int addressOf(Integer key) {
        if(data.isEmpty()){
            throw new IllegalArgumentException("Data Size is 0");
        }
        return Math.abs(key % data.size());
    }
    /**
     * Fügt ein Element mit den übergebenen Werten in die Tabelle ein. <br>
     * Überschreibt Elemente, wenn der Schlüssel bereits genutzt wird.
     * @param key Der eindeutige Schlüssel des neuen Elements
     * @param value Der Wert, der abgespeichert wird
     */
    public void insert(Integer key, Integer value){
        if(data.isEmpty()){
            return;
        }
        List<Pair> list = data.get(addressOf(key));
        Pair pair = new Pair(key, value);
        for(int i = 0; i < list.size(); i++){
            Pair content = list.get(i);
            if(content.key.equals(pair.key)){
                list.set(i, pair);
                return;
            }
        }
        list.add(pair);
        size++;
    }
    /**
     * Gibt den Wert des Elements mit dem Schlüssel aus
     * @param key Der Schlüssel des zu suchenden Elements
     * @return Der tatsächliche Wert des Elements; <br>
     * null, wenn es kein Element mit diesem Schlüssel gibt
     */
    public Integer get(Integer key) {
        if(data.isEmpty()){
            return null;
        }
        List<Pair> list = data.get(addressOf(key));
        for (Pair content : list) {
            if (content.key.equals(key)) {
                return content.value;
            }
        }
        return null;
    }
    /**
     * Entfernt das Element mit dem Schlüssel aus der Tabelle.
     * @param key Der Schlüssel des zu entfernenden Elements
     * @return true, wenn ein Element entfernt wurde; <br>
     * false, wenn keines gefunden wurde
     */
    public boolean remove(Integer key) {
        if(data.isEmpty()){
            return false;
        }
        List<Pair> list = data.get(addressOf(key));
        for(int i = 0; i < list.size(); i++){
            Pair content = list.get(i);
            if(content.key.equals(key)){
                list.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        for (List<Pair> datum : data) {
            out.append(datum.toString()).append(System.lineSeparator());
        }
        return out.toString();
    }
}