package com.oms;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SampleOrderManagementApp {
    public static void main(String[] args) {
        WireMockConfiguration wireMockConfiguration = new WireMockConfiguration();
        loadWireMockConfigurations(wireMockConfiguration);
        WireMockServer wireMockServer = new WireMockServer(wireMockConfiguration);
        wireMockServer.start();

        SpringApplication.run(SampleOrderManagementApp.class, args);
    }

    public static void loadWireMockConfigurations(WireMockConfiguration wireMockConfiguration) {
        wireMockConfiguration.port(8090);
        wireMockConfiguration.notifier(new ConsoleNotifier(true));
        wireMockConfiguration.usingFilesUnderClasspath("./src/main/resources/config/");
    }
}
