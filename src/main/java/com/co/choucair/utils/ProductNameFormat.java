package com.co.choucair.utils;

public class ProductNameFormat {

    /**
     * Convierte un nombre de producto a kebab-case para construir el data-test/id:
     * - minúsculas
     * - espacios a guiones
     * - remueve caracteres no alfanuméricos
     */
    public static String toKebabCase(String name) {
        if (name == null) return "";
        String normalized = name.trim().toLowerCase();
        normalized = normalized.replaceAll("[^a-z0-9\\s]", ""); // elimina caracteres especiales
        normalized = normalized.replaceAll("\\s+", "-");        // espacios a guiones
        return normalized;
    }
}
