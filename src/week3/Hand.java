package week3;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> hand = new ArrayList<>();

	// no argument constructor
	public Hand() {

	}

	// method used for adding card in to hand
	public void addCard(Card card) {
		hand.add(card);
		return;
	}

	// method used for instantiating cards in hand from deck
	// public List<Card> getCardsInHand(Deck deck) {
	//
	// for (int i = 0; i < 1; i++) {
	// Card c = deck.getDeck().get(i);
	// hand.add(c);
	// }
	// return hand;
	// }

	// getters and setters
	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> h) {
		hand = h;
	}

	public int totalHandValue() {
		int totalValue = 0;

		for (Card card : hand) {
			totalValue+= card.getValue();
		}
//		for (int i = 0; i < cards.size(); i++) {
//			totalValue = hand.get(0).getValue() + (hand.get(i).getValue());
//			System.out.println(totalValue);
//		}
		return totalValue;

	}

	// public List<Card> addToHand(Hand hand) {
	// Card c = new Card();
	// for (int i = 0; i < 1; i++) {
	// c = ((Deck) deck).getDeck().get(i);
	// hand.setHand(c);

	// }

	// }
	@Override
	public String toString() {
		return "Hand [hand=" + hand +  "]";
	}
}