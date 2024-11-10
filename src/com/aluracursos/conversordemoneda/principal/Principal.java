package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.modelos.Conversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        String conversion;

        double cantidad;

        Scanner lectura = new Scanner(System.in);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        //Crea un arreglo con los tipos de cambio
        String[] monedas = {"ARS/USD", "USD/ARS", "BRL/USD", "USD/BRL", "CLP/USD", "USD/CLP", "COP/USD", "USD/COP"};

        String menu = """
                Escriba la opcion de la conversion que desea realizar:
                
                1 - ARS a USD
                2 - USD a ARS
                3 - BRL a USD
                4 - USD a BRL
                5 - CLP a USD
                6 - USD a CLP
                7 - COL a USD
                8 - USD a COL
                
                9 - Salir.
                """;

        int opcion = 0;

        while(opcion != 9){
            System.out.println(menu);
            opcion = lectura.nextInt();
            if (opcion != 9){
                //Accede al arreglo y se toma el string para usarlo en la URI
                conversion = monedas[opcion - 1];
                //Tambien se usa la cantidad a convertir en la URI
                System.out.println("Escriba la cantidad a convertir: ");
                cantidad = lectura.nextDouble();

                try{
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("https://v6.exchangerate-api.com/v6/b9c610160ee886a4b4611dcc/pair/"+conversion+"/"+cantidad))
                            .build();

                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();

                    Conversion resultadoConversion = gson.fromJson(json, Conversion.class);

                    System.out.println("El monto convertido es: " + resultadoConversion);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } else {
                System.out.println("Gracias por usar el sistema de conversion");
            }

        }

    }
}
