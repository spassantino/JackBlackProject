package week3;

public class Player {
	private String name;
	private Hand hand;
	private Double wallet;

	public Player(){
		
	}
	public Player(String name, Hand hand, Double wallet) {

		setName(name);
		setHand(hand);
		setWallet(wallet);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand h) {
		System.out.println("In " + name + "'s hand");
		this.hand = h;
		System.out.println(hand.getHand().size());
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public void placeWager(int wager) {

	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hand=" + hand + ", wallet=" + wallet + "]";
	}
}