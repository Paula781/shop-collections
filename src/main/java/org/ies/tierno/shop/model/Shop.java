package org.ies.tierno.shop.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

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

    public Customer findCustomer(String nif){
        for (var customer: customers){
            if (customer.getNif().equals(nif)){
                return customer;
            }
        }
       return null;
    }

    /*
    Dado un nif y un id de pedido, devuelve el pedido del cliente.
     */

    public Order findCustomerOrder(String nif, int orderid){
        Customer customer= findCustomer(nif);
        if (customer!=null){
            for (var order: customer.getOrders()){
                if (order.getId()==orderid){
                    return order;
                }
            }
        }
        return  null;
    }

    /*
    Dado un id de producto, devuelve el producto con ese id.
     */

    public Product findProduct(int Id){
        for (var product: productsById.values()){
            if (productsById.containsKey(Id)){
                return product;
            }
        }
        return null;
    }

    /*
    Dado un nif y un id de pedido, devuelve una lista con
    los productos que se han pedido.
     */

    public List<Product> findProductCustomerOrder(String nif, int orderId){

        List<Product> orderProduct= new ArrayList<>();
        Order order= findCustomerOrder(nif, orderId);

        if (order!=null){

            for (var item: order.getItems()){
               item.getProductId();+

            }
        }
        return  orderProduct;
    }

    /*
    Dado una etiqueta (String), devuelve una lista de productos
    que tienen esa etiqueta.
     */

    /*
    Dado un nif, devuelve cuánto se ha gastado el cliente en la tienda.
     */



}
