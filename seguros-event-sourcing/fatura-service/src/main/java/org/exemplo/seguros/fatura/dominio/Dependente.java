package org.exemplo.seguros.fatura.dominio;

import java.math.BigDecimal;

public class Dependente {
    private Integer idade;

    public Dependente(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdade() {
        return idade;
    }

    public BigDecimal getValor() {
        if (idade < 10)
            return BigDecimal.valueOf(10.0);
        if (idade < 20)
            return BigDecimal.valueOf(20.0);
        if (idade < 30)
            return BigDecimal.valueOf(30.0);
        return BigDecimal.valueOf(40.0);
    }
}
