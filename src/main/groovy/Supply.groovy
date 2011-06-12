
class Supply {
	def cards = [:].withDefault { 0 }
	
	def add(Class card, int quantity) {
		cards[card] += quantity/2 // emulates two players
	}
	
	def remove(Class card) {
		cards[card]--
	}
	
	int count(Class card) {
		cards[card]
	}
}	
