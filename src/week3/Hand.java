package week3;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> hand = new ArrayList<>(2);
	
//no argument constructor
	public Hand() {

	}
//method used for adding card in to hand
	public void addCard(Card card) {
		hand.add(card);
		return;
	}
//method used for instantiating cards in hand from deck
	public Hand getCardsInHand(Deck deck) {
		for (int i = 0; i < 2; i++) {
			Card c = deck.getDeck().get(i);
			hand.add(c);

		}
		return null;
	}
//getters and setters
	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> h) {
		hand = h;
	}

}