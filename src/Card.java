public class Card {
    int val;
    String suite;
    String face;
    boolean aceVal;

    public Card(String face, String suite) {
        this.suite = suite;
        this.face = face;
    }

    public String getSuite() {
        return suite;
    }

    public int getVal() {

        if (face.equals("A")) {
            if (aceVal) {
                return 11;
            }
            return 1;
        }

        try {
            return Integer.parseInt(face);
        } catch (Exception e) {
            return 10;
        }
    }

    public String getFace() {
        return face;
    }

    public void setAceVal(boolean b) {
        aceVal = b;
    }
}
