package com.wellgrounded;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {
  public static void main(String[] args) throws InterruptedException, IOException {
    var address = new InetSocketAddress("0.0.0.0", 8080);
    var server = HttpServer.create(address, 0);
    server.createContext("/hello", Main::handle);
    server.start();

    while (true) {
      var pair = Pair.of("Howdy", "Docker");
      System.out.println(pair);
      Thread.sleep(5000);
    }
  }

  private static void handle(HttpExchange exchange) throws IOException {
    var message = "Hello from HttpServer";
    exchange.sendResponseHeaders(200, message.length());

    var stream = exchange.getResponseBody();
    stream.write(message.getBytes(StandardCharsets.UTF_8));
    stream.flush();
    stream.close();
  }
}
