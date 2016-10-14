package week3;

public class Card {
	private Rank rank;
	private Suit suit;
	private int value;

	public Card() {

	}

	public Card(Rank r, Suit s, int v) {
		setRank(r);
		setSuit(s);
		setValue(v);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int v) {
		this.value = v;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank r) {
		this.rank = r;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit s) {
		this.suit = s;
	}

	@Override
	public String toString() {
		return (rank + " of " + suit).toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
}
