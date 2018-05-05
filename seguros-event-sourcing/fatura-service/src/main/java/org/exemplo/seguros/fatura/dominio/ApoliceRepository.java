package org.exemplo.seguros.fatura.dominio;

import java.util.Optional;

public interface ApoliceRepository {
    Optional<Apolice> buscar(Long numero);
}
