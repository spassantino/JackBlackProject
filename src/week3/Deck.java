package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck implements Comparator<Card> {
	public static void main(String[] args) {
		dealCard();
	}
	static List<Card> deck = new ArrayList<>(52);

	// this method successfully deals and prints a card
	public static Card dealCard() {
		for (int i = 0; i < Rank.values().length; i++) {
			for (Suit s : Suit.values()){
				if (i < 8) {

					deck.add(new Card(Rank.values()[i], s, i+2));
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

		for (Card card : deck) {
			System.out.println(card.getRank() + " " + card.getSuit() + " " + card.getValue());

			// method to establish the cards remaining

		}
		return null;
	}

	public void shuffleDeck() {
		// this method successfully shuffles a deck
		// if instantiate a list of 52 cards within deck class
		// then enter like so; Collections.shuffle(this);
		Collections.shuffle(deck);
		for (Card card : deck) {
			System.out.println(card);
		}

	}

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}