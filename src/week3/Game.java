package week3;

import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Player dealer = new Player();
	Player user = new Player();
	Deck gameDeck = new Deck();

	// this method starts the game
	public void start() {
		System.out.println("Welcome to Black Jack ");
		gameDeck.makeDeck();
		System.out.println("What may I call you? ");
		String name = scanner.next();
		user.setName(name);
		System.out.println("How much money is in your wallet?");
		double wallet = scanner.nextInt();
		user.setWallet(wallet);
		Hand h = new Hand();
		h.addCard(Deck.takeHit());
		gameDeck.removeCard(Deck.takeHit());
		h.addCard(Deck.takeHit());
		gameDeck.removeCard(Deck.takeHit());

		user.setHand(h);
		user.getHand().getHand();

		Hand d = new Hand();
		d.addCard(Deck.takeHit());
		gameDeck.removeCard(Deck.takeHit());
		d.addCard(Deck.takeHit());
		gameDeck.removeCard(Deck.takeHit());
		dealer.setName("Dealer");
		dealer.setWallet(wallet);
		dealer.setHand(d);

		dealer.getHand().getHand();

		System.out.println(user.getName() + "'s hand: " + h.toString() + " " + h.totalHandValue());
		System.out.println(dealer.getName() + "'s hand: " + d.toString() + " " + d.totalHandValue());
		gameDeck.cardsRemaining();
		hitOrStay();
		scanner.close();

	}

	public void hitOrStay() {
		if (user.getHand().totalHandValue() > 21) {
			System.out.println("Bust!");
			System.out.println(dealer.getName() + " wins!");
			playAgain();
			return;
		}
		if (user.getHand().totalHandValue() == 21) {
			System.out.println("You won!");
			playAgain();
			return;
		}
		if (dealer.getHand().totalHandValue() == 21) {
			System.out.println("Darn you lost!");
			playAgain();
			return;
		}
		System.out.println("Hit or stay?");
		String nextTurn = scanner.next();
		if (nextTurn.toLowerCase().equals("hit")) {
			user.getHand().addCard(Deck.takeHit());
			gameDeck.removeCard(Deck.takeHit());
			System.out.println(
					user.getName() + "'s hand: " + user.getHand().toString() + " " + user.getHand().totalHandValue());
			dealersChoice();
		} else if (nextTurn.toLowerCase().equals("stay")) {
			if (dealer.getHand().totalHandValue() == user.getHand().totalHandValue()) {
				System.out.println(dealer.getName() + " and " + user.getName() + " have tied with "
						+ user.getHand().totalHandValue());
				playAgain();
			}
			if (dealer.getHand().totalHandValue() > user.getHand().totalHandValue()) {
				System.out.println(dealer.getName() + " wins with " + dealer.getHand().totalHandValue());
				playAgain();
			}

			else if (dealer.getHand().totalHandValue() < user.getHand().totalHandValue()) {
				System.out.println(user.getName() + " wins with " + user.getHand().totalHandValue());
				playAgain();
			}
		}
	}

	public void dealersChoice() {
		if (dealer.getHand().totalHandValue() > 21) {
			System.out.println(dealer.getName() + " busts!");
			playAgain();
		}
		// if (user.getHand().totalHandValue() > 21) {
		// System.out.println(user.getName() + " busts!");
		// }
		if (dealer.getHand().totalHandValue() >= 17) {
			System.out.println("Dealer chose to stay with " + dealer.getHand().totalHandValue());
		}
		if (dealer.getHand().totalHandValue() < 16) {
			dealer.getHand().addCard(Deck.takeHit());
			gameDeck.removeCard(Deck.takeHit());
			System.out.println("Dealer chose to hit ");
			// System.out.println(dealer.getHand());
			System.out.println(dealer.getName() + "'s hand: " + dealer.getHand().toString() + " "
					+ dealer.getHand().totalHandValue());

		}
		hitOrStay();
	}

	public void playAgain() {
		System.out.println("Play again? Yes or no");
		String choice = scanner.next();
		if (choice.toLowerCase().equals("yes")) {
			gameDeck.resetDeck();
			start();
		} else {
			System.out.println("You have left the game. Have a nice day!");
		}
	}
}
