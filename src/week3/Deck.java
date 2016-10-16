package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck implements Comparator<Card> {

	private static List<Card> deck = new ArrayList<>(52);

	// no argument constructor
	public Deck() {
	}

	// this method successfully instantiates and prints a deck
	public void makeDeck() {
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
		shuffleDeck();
	}

	public void resetDeck() {
		deck.removeAll(deck);
		System.out.println("Shuffling deck " + deck);
	}

	// method to establish the cards remaining
	public void cardsRemaining() {
		System.out.println("(deck now contains " + deck.size() + " cards)");
	}

	public static Card takeHit() {
		return deck.get(0);
	}

	public void removeCard(Card c) {
		deck.remove(0);
	}

	// method called from makeDeck method to shuffle cards
	public static void shuffleDeck() {
		Collections.shuffle(deck);
	}

	// getters and setters
	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		Deck.deck = deck;
	}

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}