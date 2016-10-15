package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Player dealer = new Player();
	Player user = new Player();
	Deck gameDeck = new Deck();
	// static List<Card> deck = new ArrayList<>(52);

	public static void main(String[] args) {
		// tester class instantiating all objects
		Game g = new Game();
		g.start();
	}

	// this method should start the game
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
		h.addCard(gameDeck.takeHit());
		gameDeck.removeCard(gameDeck.takeHit());
		h.addCard(gameDeck.takeHit());
		gameDeck.removeCard(gameDeck.takeHit());
		System.out.println(h.toString());
		System.out.println(h.getHand().size());

		user.setHand(h);
		for (Card c : user.getHand().getHand()) {
			System.out.println(c.getRank() + " " + c.getSuit());
		}
		Hand d = new Hand();
		d.addCard(gameDeck.takeHit());
		gameDeck.removeCard(gameDeck.takeHit());
		d.addCard(gameDeck.takeHit());
		gameDeck.removeCard(gameDeck.takeHit());
		dealer.setName("Dealer");
		dealer.setWallet(wallet);
		dealer.setHand(d);
		for (Card c : dealer.getHand().getHand()) {
			System.out.println(c.getRank() + " " + c.getSuit());
		}
		System.out.println(user.getName() + ": " + h.totalHandValue());
		System.out.println(dealer.getName() + ": " + d.totalHandValue());
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
			System.out.println(user.getHand());

			System.out.println(user.getHand().totalHandValue());

			dealersChoice();
			// hitOrStay();
			// dealersChoice();
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
			System.out.println("Dealer busts!");
			playAgain();
			return;
		}
		if (dealer.getHand().totalHandValue() > 13) {
			System.out.println("Dealer chose to stay with " + dealer.getHand().totalHandValue());
		}
		if (dealer.getHand().totalHandValue() <= 13) {
			dealer.getHand().addCard(Deck.takeHit());
			gameDeck.removeCard(Deck.takeHit());
			System.out.println("Dealer chose to hit ");
			System.out.println(dealer.getHand());
			System.out.println("Dealer's hand: " + dealer.getHand().totalHandValue());
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
