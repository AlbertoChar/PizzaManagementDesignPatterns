package pizzaPlace;

class TakeAway implements EatStrategy {
	private static final double TAKEAWAYDISCOUNT = 0.1;

	@Override
	public double eatingStrategy(IPizza pizza) {
			return pizza.getPrice() - (pizza.getPrice() * TAKEAWAYDISCOUNT);
	}
	
}
