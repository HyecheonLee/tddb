package chap07;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class CardNumberValidator {
    CardValidity validate(String cardNumber) {
        final HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://some-external-pg.com/card"))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString(cardNumber))
                .build();
        try {
            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            switch (response.body()) {
                case "ok":
                    return CardValidity.VALID;
                case "bad":
                    return CardValidity.INVALID;
                case "expired":
                    return CardValidity.EXPIRED;
                case "theft":
                    return CardValidity.THEFT;
                default:
                    return CardValidity.ERROR;
            }
        } catch (IOException | InterruptedException e) {
            return CardValidity.ERROR;
        }
    }
}
