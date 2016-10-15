package week3;

import java.util.Scanner;

public class Game {
	Player dealer = new Player();
	Player user = new Player();

	public static void main(String[] args) {
		// tester class instantiating all objects
		Game g = new Game();
		g.start();
	}

	// this method should start the game
	public void start() {
		Scanner scanner = new Scanner(System.in);
		Deck deck = new Deck();
		System.out.println("Welcome to Black Jack ");
		Deck.makeDeck();
		System.out.println("What may I call you? ");
		String name = scanner.next();
		user.setName(name);
		System.out.println("How much money is in your wallet?");
		double wallet = scanner.nextInt();
		user.setWallet(wallet);
		Hand h = deck.dealCard();
		// System.out.println(h.getHand().size());

		user.setHand(h);
		for (Card c : user.getHand().getHand()) {
			System.out.println(c.getRank() + " " + c.getSuit() + " " + c.getValue());
		}
		Hand d = deck.dealCard();
		dealer.setName("Dealer");
		dealer.setWallet(wallet);
		dealer.setHand(d);
		for (Card c : dealer.getHand().getHand()) {
			System.out.println(c.getRank() + " " + c.getSuit() + " " + c.getValue());
		}
		deck.cardsRemaining();
		System.out.println(user.getName() + ": " + h.totalHandValue());
		System.out.println(dealer.getName() + ": " + d.totalHandValue());
		System.out.println("Hit or stay?");
		String nextTurn = scanner.next();
		if (nextTurn.toLowerCase().equals("hit")) {
			h.addNewCard(deck);
			System.out.println(h.getHand());
			deck.cardsRemaining();

		} else if (nextTurn.toLowerCase().equals("stay"))

			if (h.totalHandValue() == 21) {
				System.out.println("You won!");

			} else if (d.totalHandValue() == 21) {
				System.out.println("Darn you lost!");

			}
		

		scanner.close();

	}

}