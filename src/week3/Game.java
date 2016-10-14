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

	public void start() {
		Scanner scanner = new Scanner(System.in);
		Deck deck = new Deck();
		// this method should start the game
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
			System.out.println(deck.cardsRemaining());
		}
		// System.out.println(user.getHand().getHand().get(0).getRank() + " " +
		// user.getHand().getHand().get(0).getSuit());
		// System.out.println(user.getHand().getHand().get(1).getRank() + " " +
		// user.getHand().getHand().get(1).getSuit());
		scanner.close();
	}
}
