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
		
		// for (Rank r : Rank.values()) {
		// for (Suit s : Suit.values()) {
		// deck.add(new Card(r, s));
		// }
		// }

		// for (Card card : deck) {
		// System.out.println(card.getRank() + " " + card.getSuit() + " " +
		// card.getValue());

		shuffleDeck();
	}

	public void resetDeck() {
//		for (Card card : deck) {
			deck.removeAll(deck);
//		}
		System.out.println("Reset Deck " + deck);
	}

	// method to establish the cards remaining
	public void cardsRemaining() {
		System.out.println("(deck now contains " + deck.size() + " cards)");
	}

	// method which deals cards and returns a hand with two cards
	// public static Hand dealCard() {
	// // for (Card card : deck) {
	// // System.out.println(card);
	// // deck.remove(0);
	// // break;
	// // }
	//
	// for (int i = 0; i < 2; i++) {
	// h.addCard(deck.get(i));
	// deck.remove(i);
	//
	// }
	// return h;
	// }

	public static Card takeHit() {

		return deck.get(0);
	}

	public void removeCard(Card c) {

		deck.remove(0);
	}

	// method called from makeDeck method to shuffle cards
	public static void shuffleDeck() {
		// this method successfully shuffles a deck
		// if instantiate a list of 52 cards within deck class
		// then enter like so; Collections.shuffle(this);
		Collections.shuffle(deck);
	}

	// getters and setters
	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		Deck.deck = deck;
	}

	// public static Card getCardsInHand() {
	// Card c = new Card();
	// for (int i = 0; i < 1; i++) {
	// c = ((Deck) deck).getDeck().get(i);
	// deck.remove(i);
	// hand.add(c);
	// }
	// return c;
	// }

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}