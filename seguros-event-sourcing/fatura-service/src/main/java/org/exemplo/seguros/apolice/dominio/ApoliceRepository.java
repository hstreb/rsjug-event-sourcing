package org.exemplo.seguros.apolice.dominio;

import java.util.Optional;

public interface ApoliceRepository {
    Optional<Apolice> buscar(Long numero);
}
