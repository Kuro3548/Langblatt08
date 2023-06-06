/**
 * Ein Interface, das eine einfache Hash-Funktion darstellt.
 * @param <K> Der Typ der empfangenen Schlüssel
 */
interface SimpleHashFunction<K>{
    /**
     * Eine Vorlage für eine Hash-Funktion. <br>
     * Sie bildet einen Schlüssel und einen weiteren Wert auf einen Array-Index ab
     * @param key Abzubildender Schlüssel
     * @param mod Weiterer Ganzzahliger Wert, z.B. zur Berechnung von Modulo
     * @return Ganzzahliger Wert, bestenfalls ein Array-Index für eine Hash-Table
     */
    int getHash(K key, int mod);
}
