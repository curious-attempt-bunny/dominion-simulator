def supply = new Supply()
supply.add(Card.Colony, 10)
supply.add(Card.Silver, 50)
supply.add(Card.Gold, 30)
supply.add(Card.Platinum, 15)
supply.add(Card.Salvager, 10)
def deck = new Deck()
3.times { deck << new Card.Estate() }
7.times { deck << new Card.Copper() }
def player = new Player()

int turnCount = 0
while(supply.count(Card.Colony) > 0) {
	turnCount++
	def hand = deck.draw(5)
	def turn = new Turn(deck:deck, hand:hand, player:player)
	player.act(turn, hand, deck, supply)
	player.buy(turn, hand, deck, supply)
	deck.discard(hand)
}
println "Game ended on turn# $turnCount"