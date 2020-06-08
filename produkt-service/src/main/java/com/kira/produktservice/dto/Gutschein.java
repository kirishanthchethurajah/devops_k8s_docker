package com.kira.produktservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Gutschein {
    private Long id;
    private String code;
    private BigDecimal angebot;
    private String ablaufdatum;
}
