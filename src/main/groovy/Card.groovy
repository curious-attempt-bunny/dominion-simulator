
class Card {
	enum Type { VICTORY, TREASURE, ACTION, OTHER }
	
	Type type
	int cost
	int buyValue
	
	String toString() { this.class.name.substring(this.class.name.indexOf('$')+1) }
	
	class Treasure extends Card {
		Treasure() {
			type = Type.TREASURE
		}
	}
	
	class Platinum extends Treasure { Platinum() { cost=9; buyValue=5 } }
	class Gold extends Treasure { Gold() { cost=6; buyValue=3 } }
	class Silver extends Treasure { Silver() { cost=3; buyValue=2 } }
	class Copper extends Treasure { Copper() { cost=0; buyValue=1 } } 
	
	class Victory extends Card {
		int victoryValue
		
		Victory() {
			type = Type.VICTORY
		}	
	}

	class Colony extends Victory { Colony() { cost=11; victoryValue=10 } }	
	class Estate extends Victory { Estate() { cost=2; victoryValue=1 } }	
	
	class Action extends Card {
		int buys
		int trashes
		int cards
		int actions
		
		Action() {
			type = Type.ACTION
		}
		
		def play(Turn turn) {
			if (cards) turn.addCards(cards)
			if (actions) turn.addActions(actions)	
			if (buys) turn.addBuys(buys)
		}
	}

	class Salvager extends Action {
		Salvager() { cost=4; }
		def play(Turn turn) {
			Card card = turn.trashCard()
			if (turn == null) throw new RuntimeException()
			if (card == null) throw new RuntimeException()
			turn.addBuyValue(card.cost)
		}	
	}
}
