package org.example.utilities;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.*;
import java.lang.reflect.Type;

public class Deserializacion implements JsonDeserializer<SuperHeroe> {

    @Override
    public SuperHeroe deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jObject = jsonElement.getAsJsonObject();
        JsonObject data = jObject.get("data").getAsJsonObject();
        JsonObject heroe = data.get("results").getAsJsonArray().get(0).getAsJsonObject();

        Integer id = heroe.get("id").getAsInt();
        var name = heroe.get("name").getAsString();
        var description = heroe.get("description").getAsString();
        return new SuperHeroe(id,name, description);
    }
}
