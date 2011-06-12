
class Hand {
	def cards = []
	
	def leftShift(Card card) {
		cards << card
	}
	
	def remove(Card card) {
		cards.remove(card)
	}
	
	def getBuyValue() {
		cards.sum { it.buyValue }
	}
	
	def getActions() {
		cards.findAll { it.type == Card.Type.ACTION }
	}
}
