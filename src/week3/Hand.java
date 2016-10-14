package week3;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> hand = new ArrayList<>(2);
	
	public Hand(){
		
	}

	public static void addCard(Card card) {
		return;
	}

	public Hand getCardsInHand(Deck deck) {
		for (int i = 0; i < 2; i++) {
			Card c = new Card(deck.dealCard().getRank(),c.getSuit());
			hand.add(c);
		}
		return null;
	}

	public static int getValueOfHand() {
//		int valueOfHand = .getValue();
//		return valueOfHand;

	}
}