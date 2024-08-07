package com.geo.api_gerenciamento_ecommerce.model;

public enum CategoryModel {
    ELECTRONICS,
    FASHION,
    HOME_KITCHEN,
    HEALTH_BEAUTY,
    BOOKS_ENTERTAINMENT;

    public static CategoryModel fromString(String category) {
        return switch (category.toLowerCase()) {
            case "electronics" -> ELECTRONICS;
            case "fashion" -> FASHION;
            case "home", "kitchen" -> HOME_KITCHEN;
            case "health", "beauty" -> HEALTH_BEAUTY;
            case "books", "entertainment" -> BOOKS_ENTERTAINMENT;
            default -> throw new IllegalArgumentException("Unknown category: " + category);
        };
    }
}
