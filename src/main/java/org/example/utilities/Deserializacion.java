package org.example.utilities;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.*;
import org.example.interfaces.InterfaceSuperHeroes;

import java.lang.reflect.Type;

public class Deserializacion implements InterfaceSuperHeroes<SuperHeroe> {


    @Override
    public SuperHeroe deserializar(JsonElement elemento, Type tipo, JsonDeserializationContext deserializacion) throws JsonParseException {

        JsonObject jObject = elemento.getAsJsonObject();
        JsonObject data = jObject.get("data").getAsJsonObject();
        JsonObject heroe = data.get("results").getAsJsonArray().get(0).getAsJsonObject();

        var name = heroe.get("name").getAsString();
        var description = heroe.get("description").getAsString();
        return new SuperHeroe(name, description);
    }


}
