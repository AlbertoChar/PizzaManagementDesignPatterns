package pizzaPlace;

public abstract class PizzaDecorator implements IPizza {
    protected IPizza decoratedPizza;

    protected PizzaDecorator(IPizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
        this.decoratedPizza.addTopping(this);
    }

    protected IPizza getDecoratedPizza() {
        return decoratedPizza;
    }
    
    public String getName() {
    	return decoratedPizza.getName();
    }
    
    public Iterable<PizzaDecorator> getToppingsIterator() {
        return decoratedPizza.getToppingsIterator();
    }
    
    public void addTopping(PizzaDecorator topping) {
        decoratedPizza.addTopping(topping);
    }

}
