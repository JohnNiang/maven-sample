package io.kubesphere.devops.sample;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Hello world APP.
 */
public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 6666), 0);
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.createContext("/greeting", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String greeting = "Hello, KubeSphere DevOps from maven sample!\n";
                OutputStream response = exchange.getResponseBody();
                exchange.sendResponseHeaders(200, greeting.length());
                response.write(greeting.getBytes(StandardCharsets.UTF_8));
                response.flush();
                response.close();
            }
        });
        LOGGER.info("Server started listening " + server.getAddress().getHostName() + ":" + server.getAddress().getPort());
        server.start();
    }
}
