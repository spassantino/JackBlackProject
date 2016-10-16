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
			totalValue += card.getValue();
		}
		return totalValue;

	}

	@Override
	public String toString() {
		return " " + hand + " ";
	}
}