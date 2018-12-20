public class Card {
    int val;
    String suite;
    String face;

    public Card(String face, String suite) {
        this.suite = suite;
        this.face = face;
    }

    public String getSuite() {
        return suite;
    }

    public int getVal() {
        try {
            return Integer.parseInt(face);
        } catch (Exception e) {
            return 10;
        }
    }

    public String getFace() {
        return face;
    }

    public String toString() {
        return face + " of " + suite;
    }




}
