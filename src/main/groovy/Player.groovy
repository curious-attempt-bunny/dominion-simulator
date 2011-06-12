
class Player {
	def preferences = [Card.Colony, Card.Platinum, Card.Gold, Card.Salvager, Card.Silver].collect { it.newInstance() }
	def likeToTrash = [Card.Estate, Card.Copper]

	def act(Turn turn, Hand hand, Deck deck, Supply supply) {
		def actions = hand.actions
		if (actions && pickCardToTrash(hand)) {
			turn.play(actions[0])
		}
	}
	
	Card pickCardToTrash(Hand hand) {
		hand.cards.find { it.class in likeToTrash }
	}

	def buy(Turn turn, Hand hand, Deck deck, Supply supply) {
		int buyValue = hand.buyValue
		println buyValue
		def purchase = preferences.find { buyValue >= it.cost && supply.count(it.class) > 0 }
		if (purchase) {
			println "Bought $purchase"
			supply.remove(purchase.class)
			deck.discard(purchase)
		}
	}
}
