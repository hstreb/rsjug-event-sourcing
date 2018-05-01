package org.exemplo.seguros.apolice.dominio.dominio;

public class ApoliceNotFoundException extends RuntimeException {
    public ApoliceNotFoundException(String message) {
        super(message);
    }
}
