package pizzaPlace;

interface IPizza extends Product {
	
	public Iterable<PizzaDecorator> getToppingsIterator();

	public void addTopping(PizzaDecorator topping);

}
