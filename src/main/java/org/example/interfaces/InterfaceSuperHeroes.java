package org.example.interfaces;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public interface InterfaceSuperHeroes<SuperHeroe> {
    SuperHeroe deserializar(JsonElement elemento, Type tipo, JsonDeserializationContext jsonDeserializador) throws JsonParseException;
}
