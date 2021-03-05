package com.haroldsep1.utils;

import com.haroldsep1.entities.Person;
import io.quarkus.kafka.client.serialization.JsonbSerializer;

public class PersonSerializer extends JsonbSerializer<Person> {
    
    public PersonSerializer() {
    }
}
