
package com.example.imccalculator.service;
import org.springframework.stereotype.Service;

import com.example.imccalculator.model.Person;


@Service
public class IMCservice {
    public double calculateIMC(Person person) {
        if (person.getHeight() == 0) {
            throw new IllegalArgumentException("Height cannot be zero");
        }
        return person.getWeight() / (person.getHeight() * person.getHeight());
    }
    
    
}
