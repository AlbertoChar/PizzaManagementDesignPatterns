package pizzaPlace;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class FactoryDecoratorTests {
	
    @Test
    public void testMargherita() throws ToppingAlreadyAddedException {
        PizzaFactory margheritaFactory = new PizzaFactory();
        IPizza margheritaPizza = margheritaFactory.createMargheritaPizza();
        assertThat(margheritaPizza.getName()).isEqualTo("MargheritaPizza");
        assertThat(margheritaPizza.getPrice()).isEqualTo(9.5);
        
        IPizza margheritaPizzaOlives = new OlivesDecorator(margheritaPizza);
        assertThat(margheritaPizzaOlives.getName()).isEqualTo("MargheritaPizza");
        assertThat(margheritaPizzaOlives.getDescription())
        .isEqualTo("A classic pizza topped with tomato sauce, mozzarella cheese, and fresh basil leaves with olives");
        assertThat(margheritaPizzaOlives.getPrice()).isEqualTo(10.25);
        
        assertThat(margheritaPizzaOlives.getToppingsIterator())
        .extracting(PizzaDecorator::toString)
        .containsExactlyInAnyOrder("Olives");
        
        assertThatThrownBy(() -> new OlivesDecorator(margheritaPizzaOlives)).isInstanceOf(ToppingAlreadyAddedException.class)
        .hasMessage("OlivesDecorator has already been added to the pizza.");
        
        assertThat(margheritaPizzaOlives.getToppingsIterator()).hasSize(1);
        
        IPizza margheritaPizzaOlivesEggplant = new EggplantDecorator(margheritaPizzaOlives);
        assertThat(margheritaPizzaOlivesEggplant.getName()).isEqualTo("MargheritaPizza");
        assertThat(margheritaPizzaOlivesEggplant.getDescription())
        .isEqualTo("A classic pizza topped with tomato sauce, mozzarella cheese, and fresh basil leaves with olives with eggplant");
        assertThat(margheritaPizzaOlivesEggplant.getPrice()).isEqualTo(11.75);
        
        assertThat(margheritaPizzaOlivesEggplant.getToppingsIterator())
        .extracting(PizzaDecorator::toString)
        .containsExactlyInAnyOrder("Olives", "Eggplant");
        
        assertThatThrownBy(() -> new EggplantDecorator(margheritaPizzaOlivesEggplant)).isInstanceOf(ToppingAlreadyAddedException.class)
        .hasMessage("EggplantDecorator has already been added to the pizza.");
        
        assertThat(margheritaPizzaOlivesEggplant.getToppingsIterator()).hasSize(2);
    }
    
    @Test
    public void testPepperoni() throws ToppingAlreadyAddedException {
        PizzaFactory pepperoniFactory = new PizzaFactory();
        Pizza pepperoniPizza = pepperoniFactory.createPepperoniPizza();
        assertThat(pepperoniPizza.getName()).isEqualTo("PepperoniPizza");
        assertThat(pepperoniPizza.getPrice()).isEqualTo(10.5); 
        
        IPizza pepperoniPizzaOlives = new OlivesDecorator(pepperoniPizza);
        assertThat(pepperoniPizzaOlives.getName()).isEqualTo("PepperoniPizza");
        assertThat(pepperoniPizzaOlives.getDescription())
        .isEqualTo("A delicious pizza topped with tomato sauce, mozzarella cheese, and slices of pepperoni with olives");
        assertThat(pepperoniPizzaOlives.getPrice()).isEqualTo(11.25);
        
        assertThat(pepperoniPizzaOlives.getToppingsIterator())
        .extracting(PizzaDecorator::toString)
        .containsExactlyInAnyOrder("Olives");
        
        assertThatThrownBy(() -> new OlivesDecorator(pepperoniPizzaOlives)).isInstanceOf(ToppingAlreadyAddedException.class)
        .hasMessage("OlivesDecorator has already been added to the pizza.");
        
        assertThat(pepperoniPizzaOlives.getToppingsIterator()).hasSize(1);
        
        IPizza pepperoniPizzaOlivesEggplant = new EggplantDecorator(pepperoniPizzaOlives);
        assertThat(pepperoniPizzaOlivesEggplant.getName()).isEqualTo("PepperoniPizza");
        assertThat(pepperoniPizzaOlivesEggplant.getDescription())
        .isEqualTo("A delicious pizza topped with tomato sauce, mozzarella cheese, and slices of pepperoni with olives with eggplant");
        assertThat(pepperoniPizzaOlivesEggplant.getPrice()).isEqualTo(12.75);
        
        assertThat(pepperoniPizzaOlivesEggplant.getToppingsIterator())
        .extracting(PizzaDecorator::toString)
        .containsExactlyInAnyOrder("Olives", "Eggplant");
        
        assertThatThrownBy(() -> new EggplantDecorator(pepperoniPizzaOlivesEggplant)).isInstanceOf(ToppingAlreadyAddedException.class)
        .hasMessage("EggplantDecorator has already been added to the pizza.");
        
        assertThat(pepperoniPizzaOlivesEggplant.getToppingsIterator()).hasSize(2);
    }
}
