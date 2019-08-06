package com.roman.demo.webapi;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import static com.roman.demo.webapi.services.WebService.pushService;


@SpringBootApplication
@EnableScheduling

public class DemoApplication {
    public static final String URL = "https://private-anon-77c38ebc71-zonky.apiary-proxy.com/loans/marketplace?fields=id,url,datePublished,revenueRate,rating,remainingInvestment,datePublished=placeholderpublished=trueX-Order:datePublished";
    public static final long WAIT_TASK_MINUTES = 5;
    public static final String MESSAGES_NEW_LOAN = "Nová požícka s úrokom %.2f%%, s hodnotenim %s a s dostupným vkladom  %.2f CZK";
    public static final long SHOW_NOTIFICATION_SECONDS = 10;


    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {

        // Add BouncyCastle as an algorithm provider
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }

        pushService.setPublicKey("BBYCxwATP2vVgw7mMPHJfT6bZrJP2iUV7OP_oxHzEcNFenrX66D8G34CdEmVULNg4WJXfjkeyT0AT9LwavpN8M4=");
        pushService.setPrivateKey("AKYLHgp-aV3kOys9Oy6QgxNI6OGIlOB3G6kjGvhl57j_");

        SpringApplication.run(DemoApplication.class, args);
    }


}
