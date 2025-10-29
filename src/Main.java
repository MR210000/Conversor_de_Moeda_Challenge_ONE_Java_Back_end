//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

class CurrencyConverterPro {

    static class ExchangeRateResponse {
        String base_code;
        Map<String, Double> conversion_rates;
    }

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/2613c71784799e8f9d277ee8/latest/USD";
    private static final String LOG_FILE = "historico_conversoes.txt";
    private static final String[] SUPPORTED_CODES = {"USD", "BRL", "ARS", "BOB", "CLP", "COP"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ExchangeRateResponse rates = gson.fromJson(response.body(), ExchangeRateResponse.class);

            if (rates.conversion_rates == null) {
                System.out.println("Erro: não foi possível obter as taxas de câmbio.");
                return;
            }

            int opcao;
            do {
                System.out.println("\n=== CONVERSOR DE MOEDAS PRO ===");
                System.out.println("Moedas disponíveis: USD, BRL, ARS, BOB, CLP, COP");
                System.out.println("1. Converter moeda");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite a moeda de origem (ex: USD): ");
                        String from = scanner.next().toUpperCase();

                        System.out.print("Digite a moeda de destino (ex: BRL): ");
                        String to = scanner.next().toUpperCase();

                        if (!isSupported(from) || !isSupported(to)) {
                            System.out.println("Moeda não suportada. Tente novamente.");
                            break;
                        }

                        System.out.print("Digite o valor a converter: ");
                        double amount = scanner.nextDouble();

                        double converted = convertCurrency(amount, from, to, rates.conversion_rates);
                        System.out.printf("Resultado: %.2f %s = %.2f %s%n", amount, from, converted, to);

                        logConversion(from, to, amount, converted);
                    }
                    case 0 -> System.out.println("Encerrando o programa...");
                    default -> System.out.println("Opção inválida, tente novamente.");
                }

            } while (opcao != 0);

        } catch (Exception e) {
            System.out.println("Erro ao conectar à API: " + e.getMessage());
        }

        scanner.close();
    }

    private static boolean isSupported(String code) {
        for (String c : SUPPORTED_CODES) {
            if (c.equalsIgnoreCase(code)) return true;
        }
        return false;
    }

    private static double convertCurrency(double amount, String from, String to, Map<String, Double> rates) {
        double rateFrom = rates.get(from);
        double rateTo = rates.get(to);
        return amount / rateFrom * rateTo;
    }

    private static void logConversion(String from, String to, double amount, double converted) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);
            writer.write(String.format("%s | %.2f %s -> %.2f %s%n", timestamp, amount, from, converted, to));
        } catch (IOException e) {
            System.out.println("Erro ao registrar histórico: " + e.getMessage());
        }
    }
}
