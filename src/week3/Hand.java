package week3;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	static List<Card> hand = new ArrayList<>(2);
	
	public Hand(){
		
	}

	public void addCard(Card card) {
		return;
	}

	public static Hand getCardsInHand(Deck deck) {
		for (int i = 0; i < 2; i++) {
			Card c = deck.getDeck().get(i);
			hand.add(c);
			
		}
		return null;
	}

//	public static int getValueOfHand() {
//		int valueOfHand = .getValue();
//		return valueOfHand;

//	}
}