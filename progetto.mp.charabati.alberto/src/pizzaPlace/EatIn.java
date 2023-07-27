package pizzaPlace;

class EatIn implements EatStrategy {

	@Override
	public double eatingStrategy(IPizza pizza) {
		try {
			pizza = new OlivesDecorator(pizza);
		} catch (ToppingAlreadyAddedException e) {
		}
		return pizza.getPrice()-0.75;
	}

}
