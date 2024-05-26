package berdnne.bgambling.game;

public class Card {

    private int suit;
    private String value;

    public Card(int suit, String value) {

        this.suit = suit;
        this.value = value;

    }

    public int getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

}
