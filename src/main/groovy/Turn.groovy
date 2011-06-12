class Turn {
	Player player
	Hand hand
	Deck deck
	
	def play(Card card) {
		card.play(this)
	}
	
	Card trashCard() {
		Card card = player.pickCardToTrash(hand)
		if ( hand.cards.size() > 0 && card == null ) throw new RuntimeException()
		hand.remove(card)
		deck.trash(card)
	}
}
