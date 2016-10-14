package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck implements Comparator<Card> {
	static List<Card> deck = new ArrayList<>(52);

	public static Card dealCard() {
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				deck.add(new Card(r, s, 0));
			}
		}

		for (Card card : deck) {
			System.out.println(card);

			return card;
		}
		return null;
	}

	public void shuffleDeck() {
		// if instantiate a list of 52 cards within deck class
		// then enter like so; Collections.shuffle(this);
		Collections.shuffle(deck);
		for (Card card : deck) {
			System.out.println(card);
		}

	}
	public void cardsLeft(){
		
	}

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}