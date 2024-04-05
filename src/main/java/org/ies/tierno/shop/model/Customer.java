package org.ies.tierno.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer implements  Comparable<Customer>{
    private String nif;
    private String name;

    private String surname;

    private List<Order> orders;



    @Override
    public int compareTo(Customer o) {
        int compare = this.surname.compareTo(o.surname);
        if( compare == 0) {
            compare = this.name.compareTo(o.name);
            if( compare == 0) {
                compare = this.nif.compareTo(o.nif);
            }
        }
        return compare;
    }

}
