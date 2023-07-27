package pizzaPlace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PizzaToppingsManager implements Iterable<PizzaDecorator> {
    private List<PizzaDecorator> toppings;

    PizzaToppingsManager() {
        this.toppings = new ArrayList<>();
    }
     
    public Iterator<PizzaDecorator> iterator() {
        return toppings.iterator();
    }
    
    protected void addTopping(PizzaDecorator topping) {
    	toppings.add(topping);
    }
    
    protected static IPizza checkAndAddTopping(IPizza decoratedPizza, Class<? extends PizzaDecorator> toppingClass)
            throws ToppingAlreadyAddedException {
        Iterable<PizzaDecorator> toppingsIterator = decoratedPizza.getToppingsIterator();

        for (PizzaDecorator currentTopping : toppingsIterator) {
            if (currentTopping.getClass().equals(toppingClass)) {
                String toppingName = toppingClass.getSimpleName();
                throw new ToppingAlreadyAddedException(toppingName + " has already been added to the pizza.");
            }
        }
        return decoratedPizza;
    }
    
    @Override
    public String toString() {
        StringBuilder toppingsBuilder = new StringBuilder();
        Iterator<PizzaDecorator> iterator = toppings.iterator();
        while (iterator.hasNext()) {
            toppingsBuilder.append(iterator.next().toString());
            if (iterator.hasNext()) {
                toppingsBuilder.append(", ");
            }
        }
        return toppingsBuilder.toString();
    }

}
