package apresentação;

import lojas.ChicagoStylePizzaStore;
import lojas.NYStylePizzaStore;
import lojas.PizzaStore;
import pizzas.Pizza;

public class PizzariaObjetolandia {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("queijo");
        System.out.println("Ethan pediu uma " + pizza + "\n");

        pizza = chicagoStore.orderPizza("queijo");
        System.out.println("Joel pediu uma " + pizza + "\n");

        pizza = nyStore.orderPizza("mariscos");
        System.out.println("Ethan pediu uma " + pizza + "\n");

        pizza = chicagoStore.orderPizza("mariscos");
        System.out.println("Joel pediu uma " + pizza + "\n");

        pizza = nyStore.orderPizza("vegetariana");
        System.out.println("Ethan pediu uma " + pizza + "\n");

        pizza = chicagoStore.orderPizza("calabresa");
        System.out.println("Joel pediu uma " + pizza + "\n");
    }
}
