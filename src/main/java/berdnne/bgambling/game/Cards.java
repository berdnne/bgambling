package berdnne.bgambling.game;

public class Cards {

    public static Card[] getSortedDeck(){

        Card[] deck = new Card[52];

        for (int i = 0; i < 4; i++){

            for (int j = 0; j < 13; j++){

                if (j < 9){

                    deck[(i * 13) + j] = new Card(i,(j + 2) + "");

                }
                else switch (j){

                    case 9: deck[(i * 13) + j] = new Card(i,"J");
                        break;
                    case 10: deck[(i * 13) + j] = new Card(i,"Q");
                        break;
                    case 11: deck[(i * 13) + j] = new Card(i,"K");
                        break;
                    case 12: deck[(i * 13) + j] = new Card(i,"A");
                        break;
                }

            }

        }

        return deck;

    }

    public static int getIntValue(String cardValue){

        return switch (cardValue) {
            case "2", "3", "4", "5", "6", "7", "8", "9", "10" -> Integer.parseInt(cardValue);
            case "J", "Q", "K" -> 10;
            case "A" -> 11;
            default -> 0;
        };

    }

    public static String getStringSuit(int suit){

        return switch (suit){
            case 0 -> "spades";
            case 1 -> "hearts";
            case 2 -> "diamonds";
            case 3 -> "clubs";
            default -> "";
        };

    }

}
