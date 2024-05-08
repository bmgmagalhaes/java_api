package functions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Address;

import java.io.FileWriter;
import java.io.IOException;

public class CreateFileCepJson {

    public void createFile (Address address) {

        try {
            FileWriter writer = new FileWriter(address.getZipcode()+".json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            writer.write(gson.toJson(address));
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
