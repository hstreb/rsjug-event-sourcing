package org.exemplo.seguros.apolice;

public class ApoliceNotFoundException extends RuntimeException {
    public ApoliceNotFoundException(String message) {
        super(message);
    }
}
