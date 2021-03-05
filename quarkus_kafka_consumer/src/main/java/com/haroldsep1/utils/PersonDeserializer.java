package com.haroldsep1.utils;

import com.haroldsep1.entities.Person;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class PersonDeserializer extends JsonbDeserializer<Person> {
    
    public PersonDeserializer() {
        super(Person.class);
    }
}
