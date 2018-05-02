package org.exemplo.seguros.fatura.dominio;

import java.util.List;

public interface FaturaRepository {

    List<Fatura> buscar(Long apolice);
}
