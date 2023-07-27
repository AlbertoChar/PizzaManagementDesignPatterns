package pizzaPlace;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class TemplateTests {
	
	@Test
	public void testMargheritaTemplateParts() throws OrderPreparationException {
	    PizzaFactory margheritaFactory = new PizzaFactory();
	    Pizza margherita = margheritaFactory.createMargheritaPizza();

	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    margherita.orderPizza();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.ORDER_RECEIVED);
	    margherita.preparePizza();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.IN_PREPARATION);
	    margherita.addExtras();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.RAW);
	    margherita.bakePizza();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.BAKING);
	    margherita.servePizza();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    
	    GourmetFactory gourmetMargheritaFactory = new GourmetFactory();
	    Pizza gourmet = gourmetMargheritaFactory.createMargheritaPizza();

	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    gourmet.orderPizza();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.ORDER_RECEIVED);
	    gourmet.preparePizza();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.IN_PREPARATION);
	    gourmet.addExtras();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.RAW);
	    gourmet.bakePizza();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.BAKING);
	    gourmet.servePizza();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.READY);
	}
	
	@Test
	public void testMargheritaTemplatePartsWrongOrder() throws OrderPreparationException {
	    PizzaFactory margheritaFactory = new PizzaFactory();
	    Pizza margherita = margheritaFactory.createMargheritaPizza();

	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    
	    assertThatThrownBy(() -> margherita.preparePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("No margherita pizza order received yet!");
	    
	    margherita.orderPizza();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.ORDER_RECEIVED);
	    
	    assertThatThrownBy(() -> margherita.addExtras()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Margherita pizza needs to be assembled!");
	    
	    margherita.preparePizza();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.IN_PREPARATION);
	    
	    assertThatThrownBy(() -> margherita.bakePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Margherita pizza needs to be prepared before baking!");
	    
	    margherita.addExtras();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.RAW);
	    
	    assertThatThrownBy(() -> margherita.servePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Pizza not baked yet!");
	    
	    margherita.bakePizza();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.BAKING);
	    margherita.servePizza();
	    assertThat(margherita.getOrderStatus()).isEqualTo(OrderStatus.READY);
	}
	
	@Test
	public void testGourmetMargheritaTemplatePartsWrongOrder() throws OrderPreparationException {
		GourmetFactory gourmetMargheritaFactory = new GourmetFactory();
	    Pizza gourmet = gourmetMargheritaFactory.createMargheritaPizza();

	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    
	    assertThatThrownBy(() -> gourmet.preparePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("No gourmet margherita order received yet!");
	    
	    gourmet.orderPizza();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.ORDER_RECEIVED);
	    
	    assertThatThrownBy(() -> gourmet.addExtras()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Gourmet margherita pizza needs to be assembled!");
	    
	    gourmet.preparePizza();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.IN_PREPARATION);
	    
	    assertThatThrownBy(() -> gourmet.bakePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Gourmet margherita pizza needs to be prepared before baking!");
	    
	    gourmet.addExtras();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.RAW);
	    
	    assertThatThrownBy(() -> gourmet.servePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Pizza not baked yet!");
	    
	    gourmet.bakePizza();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.BAKING);
	    gourmet.servePizza();
	    assertThat(gourmet.getOrderStatus()).isEqualTo(OrderStatus.READY);
	}
	
	@Test
	public void testPepperoniTemplateParts() throws OrderPreparationException {
	    PizzaFactory pepperoniFactory = new PizzaFactory();
	    Pizza pepperoni = pepperoniFactory.createPepperoniPizza();

	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    pepperoni.orderPizza();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.ORDER_RECEIVED);
	    pepperoni.preparePizza();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.IN_PREPARATION);
	    pepperoni.addExtras();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.RAW);
	    pepperoni.bakePizza();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.BAKING);
	    pepperoni.servePizza();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.READY);
	    
	    GourmetFactory gourmetPepperoniFactory = new GourmetFactory();
	    Pizza gourmetPepperoni = gourmetPepperoniFactory.createPepperoniPizza();

	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    gourmetPepperoni.orderPizza();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.ORDER_RECEIVED);
	    gourmetPepperoni.preparePizza();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.IN_PREPARATION);
	    gourmetPepperoni.addExtras();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.RAW);
	    gourmetPepperoni.bakePizza();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.BAKING);
	    gourmetPepperoni.servePizza();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.READY);
	}
	
	@Test
	public void testPepperoniTemplatePartsWrongOrder() throws OrderPreparationException {
	    PizzaFactory pepperoniFactory = new PizzaFactory();
	    Pizza pepperoni = pepperoniFactory.createPepperoniPizza();

	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    
	    assertThatThrownBy(() -> pepperoni.preparePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Pepperoni pizza order not received yet!");
	    
	    pepperoni.orderPizza();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.ORDER_RECEIVED);
	    
	    assertThatThrownBy(() -> pepperoni.addExtras()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Pepperoni pizza needs to be assembled!");
	    
	    pepperoni.preparePizza();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.IN_PREPARATION);
	    
	    assertThatThrownBy(() -> pepperoni.bakePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Pepperoni pizza needs to be prepared before baking!");
	    
	    pepperoni.addExtras();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.RAW);
	    
	    assertThatThrownBy(() -> pepperoni.servePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Pizza not baked yet!");
	    
	    pepperoni.bakePizza();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.BAKING);
	    pepperoni.servePizza();
	    assertThat(pepperoni.getOrderStatus()).isEqualTo(OrderStatus.READY);
	}
	
	@Test
	public void testGourmetPepperoniTemplatePartsWrongOrder() throws OrderPreparationException {
		GourmetFactory gourmetPepperoniFactory = new GourmetFactory();
	    Pizza gourmetPepperoni = gourmetPepperoniFactory.createPepperoniPizza();

	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.WAITING);
	    
	    assertThatThrownBy(() -> gourmetPepperoni.preparePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Gourmet pepperoni order not received yet!");
	    
	    gourmetPepperoni.orderPizza();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.ORDER_RECEIVED);
	    
	    assertThatThrownBy(() -> gourmetPepperoni.addExtras()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Gourmet pepperoni needs to be assembled!");
	    
	    gourmetPepperoni.preparePizza();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.IN_PREPARATION);
	    
	    assertThatThrownBy(() -> gourmetPepperoni.bakePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Gourmet pepperoni needs to be prepared before baking!");
	    
	    gourmetPepperoni.addExtras();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.RAW);
	    
	    assertThatThrownBy(() -> gourmetPepperoni.servePizza()).isInstanceOf(OrderPreparationException.class)
        .hasMessage("Pizza not baked yet!");
	    
	    gourmetPepperoni.bakePizza();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.BAKING);
	    gourmetPepperoni.servePizza();
	    assertThat(gourmetPepperoni.getOrderStatus()).isEqualTo(OrderStatus.READY);
	}

}
