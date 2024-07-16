package api_service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import modelo.Moeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaMoeda {

    public double BuscarMoeda(int opcaoDeConversao) throws IOException, InterruptedException {
        String moedaBase = "";
        String convertePara = "";

        if (opcaoDeConversao == 1){
            moedaBase = "USD";
            convertePara = "BRL";
        }
        if (opcaoDeConversao == 2){
            moedaBase = "ARS";
            convertePara = "USD";
        }
        if (opcaoDeConversao == 3){
            moedaBase = "USD";
            convertePara = "COP";
        }


        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/5c05678479ee3fd1ea7faf9b/pair/" + moedaBase + "/" + convertePara);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson().newBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Moeda valorParaConverter = gson.fromJson(response.body(), Moeda.class);


        return valorParaConverter.conversion_rate();

    }
}
