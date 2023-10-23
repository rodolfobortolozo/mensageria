package br.com.rodolfo.email.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmailDto {

    private UUID userId;
    private String name;
    private String emailTo;
    private String subject;
    private String Text;
}
