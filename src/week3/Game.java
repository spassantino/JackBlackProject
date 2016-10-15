package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Player dealer = new Player();
	Player user = new Player();
	static List<Card> deck = new ArrayList<>(52);

	public static void main(String[] args) {
		// tester class instantiating all objects
		Game g = new Game();
		g.start();
	}

	// this method should start the game
	public void start() {
		Deck deck = new Deck();
		System.out.println("Welcome to Black Jack ");
		Deck.makeDeck();
		System.out.println("What may I call you? ");
		String name = scanner.next();
		user.setName(name);
		System.out.println("How much money is in your wallet?");
		double wallet = scanner.nextInt();
		user.setWallet(wallet);
		Hand h = new Hand();
		h.addCard(deck.takeHit());
		deck.removeCard(deck.takeHit());
		h.addCard(deck.takeHit());
		deck.removeCard(deck.takeHit());
		System.out.println(h.toString());
		System.out.println(h.getHand().size());

		user.setHand(h);
		for (Card c : user.getHand().getHand()) {
			System.out.println(c.getRank() + " " + c.getSuit());
		}
		Hand d = new Hand();
		d.addCard(deck.takeHit());
		deck.removeCard(deck.takeHit());
		d.addCard(deck.takeHit());
		deck.removeCard(deck.takeHit());
		dealer.setName("Dealer");
		dealer.setWallet(wallet);
		dealer.setHand(d);
		for (Card c : dealer.getHand().getHand()) {
			System.out.println(c.getRank() + " " + c.getSuit());
		}
		System.out.println(user.getName() + ": " + h.totalHandValue());
		System.out.println(dealer.getName() + ": " + d.totalHandValue());
		deck.cardsRemaining();
		hitOrStay();

		scanner.close();

	}

	public void hitOrStay() {
		System.out.println("Hit or stay?");
		String nextTurn = scanner.next();
		if ()
		if (nextTurn.toLowerCase().equals("hit")) {
			user.getHand().addCard(Deck.takeHit());
			deck.remove(Deck.takeHit());
			System.out.println(user.getHand());

			System.out.println(user.getHand().totalHandValue());

			hitOrStay();
		} else if (nextTurn.toLowerCase().equals("stay"))

			if (user.getHand().totalHandValue() == 21) {
				System.out.println("You won!");

			} else if (dealer.getHand().totalHandValue() == 21 || user.getHand().totalHandValue() > 21) {
				System.out.println("Darn you lost!");

			}

	}

}