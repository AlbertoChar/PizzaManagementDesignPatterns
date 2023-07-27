package pizzaPlace;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StrategyTests {
	
	@Test
	public void testMargheritaStrategyAndTemplate() throws OrderPreparationException, ToppingAlreadyAddedException {
	    PizzaFactory margheritaFactory = new PizzaFactory();
	    Pizza margherita = margheritaFactory.createMargheritaPizza();
	    
	    margherita.setEatStrategy(new TakeAway());
	    assertThat(margherita.totalCost()).isEqualTo(8.55);
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    margherita.PizzaOrderManagement();
	    assertThat(margherita.getOrderLogs().toString()).isEqualTo(
                "Pizza order has been received\n"
                + "Preparing a margherita pizza!\n"
                + "Baking a margherita pizza!\n"
                + "Serving the pizza!\n"
        );
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    margherita.getOrderLogs().clearLogs();
	    margherita.setOrderStatus(OrderStatus.WAITING);
	   
	    margherita.setEatStrategy(new EatIn());
	    assertThat(margherita.totalCost()).isEqualTo(9.5);
	    assertThat(margherita.getToppingsIterator())
        .extracting(PizzaDecorator::toString)
        .containsExactlyInAnyOrder("Olives");
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    margherita.PizzaOrderManagement();
	    assertThat(margherita.getOrderLogs().toString()).isEqualTo(
                "Pizza order has been received\n"
                + "Preparing a margherita pizza!\n"
                + "Adding Olives\n"
                + "Baking a margherita pizza!\n"
                + "Serving the pizza!\n"
        );
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    margherita.getOrderLogs().clearLogs();
	}
	
	@Test
	public void testGourmetMargheritaStrategyAndTemplate() throws OrderPreparationException, ToppingAlreadyAddedException {
	    GourmetFactory gourmetMargheritaFactory = new GourmetFactory();
	    Pizza gourmetMargherita = gourmetMargheritaFactory.createMargheritaPizza();
	    
	    gourmetMargherita.setEatStrategy(new TakeAway());
	    assertThat(gourmetMargherita.totalCost()).isEqualTo(12.15);
	    assertThat(gourmetMargherita.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    gourmetMargherita.PizzaOrderManagement();
	    assertThat(gourmetMargherita.getOrderLogs().toString()).isEqualTo(
                "Pizza order has been received\n"
                + "Preparing a gourmet margherita pizza with selected cheeses and selected tomatoes!\n" 
                + "Selected grilled vegetables sent to client\n"
                + "Baking a margherita pizza on our stone stove!\n"
                + "Serving the pizza!\n"
        );
	    assertThat(gourmetMargherita.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    gourmetMargherita.getOrderLogs().clearLogs();
	    gourmetMargherita.setOrderStatus(OrderStatus.WAITING);
	   
	    gourmetMargherita.setEatStrategy(new EatIn());
	    assertThat(gourmetMargherita.totalCost()).isEqualTo(13.5);
	    assertThat(gourmetMargherita.getToppingsIterator())
        .extracting(PizzaDecorator::toString)
        .containsExactlyInAnyOrder("Olives");
	    assertThat(gourmetMargherita.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    gourmetMargherita.PizzaOrderManagement();
	    assertThat(gourmetMargherita.getOrderLogs().toString()).isEqualTo(
                "Pizza order has been received\n"
                + "Preparing a gourmet margherita pizza with selected cheeses and selected tomatoes!\n" 
                + "Selected grilled vegetables sent to client\n"
                + "Adding Olives\n"
                + "Baking a margherita pizza on our stone stove!\n"
                + "Serving the pizza!\n"
        );
	    assertThat(gourmetMargherita.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    gourmetMargherita.getOrderLogs().clearLogs();
	}
	
	
	@Test
	public void testPepperoniStrategyAndTemplate() throws OrderPreparationException {
	    PizzaFactory pepperoniFactory = new PizzaFactory();
	    Pizza pepperoni = pepperoniFactory.createPepperoniPizza();
	    
	    pepperoni.setEatStrategy(new TakeAway());
	    assertThat(pepperoni.totalCost()).isEqualTo(9.45);
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    pepperoni.PizzaOrderManagement();
	    assertThat(pepperoni.getOrderLogs().toString()).isEqualTo(
                "Pizza order has been received\n"
                + "Preparing a pepperoni pizza!\n"
                + "Adding pepperoni to the pizza!\n"
                + "Baking a pepperoni pizza!\n"
                + "Serving the pizza!\n"
        );
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    pepperoni.getOrderLogs().clearLogs();
	   pepperoni.setOrderStatus(OrderStatus.WAITING);
	    
	    pepperoni.setEatStrategy(new EatIn());
	    assertThat(pepperoni.totalCost()).isEqualTo(10.5);
	    assertThat(pepperoni.getToppingsIterator())
        .extracting(PizzaDecorator::toString)
        .containsExactlyInAnyOrder("Olives");
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    pepperoni.PizzaOrderManagement();
	    assertThat(pepperoni.getOrderLogs().toString()).isEqualTo(
                "Pizza order has been received\n"
                + "Preparing a pepperoni pizza!\n"
                + "Adding pepperoni to the pizza!\n"
                + "Adding Olives\n"
                + "Baking a pepperoni pizza!\n"
                + "Serving the pizza!\n"
        );
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    pepperoni.getOrderLogs().clearLogs();
	}
	
	@Test
	public void testGourmetPepperoniStrategyAndTemplate() throws OrderPreparationException, ToppingAlreadyAddedException {
	    GourmetFactory gourmetPepperoniFactory = new GourmetFactory();
	    Pizza gourmetPepperoni = gourmetPepperoniFactory.createPepperoniPizza();
	    
	    gourmetPepperoni.setEatStrategy(new TakeAway());
	    assertThat(gourmetPepperoni.totalCost()).isEqualTo(13.05);
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    gourmetPepperoni.PizzaOrderManagement();
	    assertThat(gourmetPepperoni.getOrderLogs().toString()).isEqualTo(
                "Pizza order has been received\n"
                + "Gourmet pepperoni pizza being prepared\n"
                + "Selected grilled vegetables sent to client\n"
                + "Adding the best pepperoni to the pizza!\n"
                + "Baking a pepperoni pizza on our stone stove!\n"
                + "Serving the pizza!\n"
        );
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    gourmetPepperoni.getOrderLogs().clearLogs();
	    gourmetPepperoni.setOrderStatus(OrderStatus.WAITING);
	   
	    gourmetPepperoni.setEatStrategy(new EatIn());
	    assertThat(gourmetPepperoni.totalCost()).isEqualTo(14.5);
	    assertThat(gourmetPepperoni.getToppingsIterator())
        .extracting(PizzaDecorator::toString)
        .containsExactlyInAnyOrder("Olives");
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    gourmetPepperoni.PizzaOrderManagement();
	    assertThat(gourmetPepperoni.getOrderLogs().toString()).isEqualTo(
                "Pizza order has been received\n"
                + "Gourmet pepperoni pizza being prepared\n"
                + "Selected grilled vegetables sent to client\n"
                + "Adding the best pepperoni to the pizza!\n"
                + "Adding Olives\n"
                + "Baking a pepperoni pizza on our stone stove!\n"
                + "Serving the pizza!\n"
        );
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    gourmetPepperoni.getOrderLogs().clearLogs();
	}
	

}
