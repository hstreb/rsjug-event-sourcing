package org.exemplo.seguros.apolice.dominio;

import java.util.Optional;

public interface ApoliceRespository {
    Optional<Apolice> ler(Long numero);
}
