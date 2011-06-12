
class Deck {
	def cards = []
	def discards = []
	
	def leftShift(Card card) {
		cards << card
	}
	
	def draw(int count) {
		Hand hand = new Hand()
		count.times {
			Card card = draw()
			if (card) {
				hand << card
			}
		}
		hand
	}
	
	def draw() {
		if (!cards && discards) {
			Collections.shuffle(discards)
			cards = discards
			discards = []
		}
		cards ? cards.remove(0) : null
	}
	
	def discard(Card card) {
		//println "Discarded $card"
		discards << card
	}
	
	def discard(Hand hand) {
		//println "Discarded $hand.cards"
		discards.addAll hand.cards
	}
	
	def trash(Card card) {
		// NO-OP
	}
}
