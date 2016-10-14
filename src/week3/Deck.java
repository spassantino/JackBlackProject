package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck implements Comparator<Card> {

	static List<Card> deck = new ArrayList<>(52);

	public Deck() {
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		Deck.deck = deck;
	}

	// this method successfully instantiates and prints a deck
	public static void makeDeck() {
		for (int i = 0; i < Rank.values().length; i++) {
			for (Suit s : Suit.values()) {
				if (i < 8) {

					deck.add(new Card(Rank.values()[i], s, i + 2));
				}
				if (i >= 8 && i < Rank.values().length - 1) {

					deck.add(new Card(Rank.values()[i], s, 10));
				}
				if (i == Rank.values().length - 1) {

					deck.add(new Card(Rank.values()[i], s, 11));
				}
			}
		}

		// for (Rank r : Rank.values()) {
		// for (Suit s : Suit.values()) {
		// deck.add(new Card(r, s));
		// }
		// }

		// for (Card card : deck) {
		// System.out.println(card.getRank() + " " + card.getSuit() + " " +
		// card.getValue());

		// method to establish the cards remaining
		shuffleDeck();
	}

	public static Hand dealCard() {
		// for (Card card : deck) {
		// System.out.println(card);
		// deck.remove(0);
		// break;
		// }
		Hand hand = new Hand();
		for (int i = 0; i < 2; i++) {
			hand.addCard(deck.get(i));
			deck.remove(i);
		}
		// System.out.println(deck.size());
		return hand;
	}

	public static void shuffleDeck() {
		// this method successfully shuffles a deck
		// if instantiate a list of 52 cards within deck class
		// then enter like so; Collections.shuffle(this);
		Collections.shuffle(deck);
	}

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}