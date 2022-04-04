package com.gabriel.code.Http;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;



public class ClienteHttp {

	public static void main(String[] args) throws URISyntaxException {

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("https://imdb-api.com/API/Search/${APY_KEY}/senhor%20dos%20aneis")).GET().build();

		try {
			client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body)
					.thenAccept(System.out::println).join();
		} catch (HttpClientErrorException e) {
			e.getMessage();
			e.getStackTrace();
		}

	}

}
