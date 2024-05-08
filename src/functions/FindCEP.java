package functions;

import com.google.gson.Gson;
import models.Address;
import models.AddressViaCepAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FindCEP {

    public Address findAddress(String cep) {

        URI uri = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        AddressViaCepAPI addressViaCepAPI = new Gson()
                .fromJson(
                        response.body(),
                        AddressViaCepAPI.class
                );

        return new Address(addressViaCepAPI);

    }



}
