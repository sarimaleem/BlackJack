public class AI extends Player {

    public AI(String name) {
        super(name);
        isHuman = false;
    }

    public boolean shouldHit() {
        if (getHandValue() > 17) {
            return false;
        }

        return true;
    }
}
