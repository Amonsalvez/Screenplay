package com.co.choucair.utils;


import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class ConfigChrome

        implements DriverSource {

    @Override
    public WebDriver newDriver() {

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        // Desactivar todos los servicios de contraseñas de Chrome
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // Desactivar detección de violación de contraseñas
        prefs.put("PasswordLeakDetectionEnabled", false);

        // Opcional: desactivar notificaciones
        Map<String, Object> contentSettings = new HashMap<>();
        contentSettings.put("notifications", 2); // bloquear todo
        prefs.put("profile.default_content_setting_values", contentSettings);

        options.setExperimentalOption("prefs", prefs);

        // Opcional: evitar barras informativas
        options.addArguments("--disable-infobars");

        // Opcional: incognito → Chrome no usa credenciales previas
        options.addArguments("--incognito");

        return new ChromeDriver(options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}

