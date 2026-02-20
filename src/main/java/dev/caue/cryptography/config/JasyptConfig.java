package dev.caue.cryptography.config;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Value("${jasypt.encryptor.password}")
    private String encryptorPassword;

    @Bean("jasyptStringEncryptor")
    public AES256TextEncryptor stringEncryptor() {
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword(encryptorPassword);

        return encryptor;
    }
}
