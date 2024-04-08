package org.ies.tierno.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Shop {
    private String name;
    private Map<Integer, Product> productsById;
    private TreeSet<Customer> customers;


  /*
    Dado un nif, devuelve el cliente con ese NIF.
     */

    public Customer findCustomer(String nif) {
        for (var customer : customers) {
            if (customer.getNif().equals(nif)) {
                return customer;
            }
        }
        return null;
    }

    /*
    Dado un nif y un id de pedido, devuelve el pedido del cliente.
     */

    public Order findCustomerOrder(String nif, int orderid) {
        Customer customer = findCustomer(nif);
        if (customer != null) {
            for (var order : customer.getOrders()) {
                if (order.getId() == orderid) {
                    return order;
                }
            }
        }
        return null;
    }

    /*
    Dado un id de producto, devuelve el producto con ese id.
     */

    public Product findProduct(int Id) {
        for (var product : productsById.values()) {
            if (productsById.containsKey(Id)) {
                return product;
            }
        }
        return null;
    }

    /*
    Dado un nif y un id de pedido, devuelve una lista con
    los productos que se han pedido.
     */

    public List<Product> findProductCustomerOrder(String nif, int orderId) {

        Order order = findCustomerOrder(nif, orderId);

        if (order != null) {

            return order
                    .getItems()
                    .stream()
                    .map(item -> productsById.get(item.getProductId()))
                    .collect(Collectors.toList());

        }
        return null;
    }


    /*
    Dado una etiqueta (String), devuelve una lista de productos
    que tienen esa etiqueta.
     */

    public  List<Product>findProductByTag(String tag){
        List<Product> productTag= new ArrayList<>();
        for (Product product: productsById.values()){
            if (product.getTags().contains(tag)){
                productTag.add(product);
            }
        }
         return  productTag;
    }

    /*
    Dado un nif, devuelve cuánto se ha gastado el cliente en la tienda.
     */

    public double totalAmountSpent (String nif){
        double totalSpent=0.0;
        Customer customer= findCustomer(nif);
                if(customer!=null){
                    for (Order order: customer.getOrders()){
                        totalSpent +=order.getPrice();
                    }
                }else{
                    System.out.println("No se ha encontrado al cliente con NIF: "+nif);
                }
                return  totalSpent;
    }


}
