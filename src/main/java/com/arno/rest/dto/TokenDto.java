package com.arno.rest.dto;

import com.arno.domain.Token;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TokenDto {

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer id;

    private String value;

    @JsonProperty(value = "expirationDate")
    private long expirationDate;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer userId;

    public static TokenDto toDto(Token token){
        long formatDate = Long.parseLong(String.valueOf(token.getExpirationDate().getTime()).substring(0,10));
        return new TokenDto(
                token.getId(),
                token.getValue(),
                formatDate,
                token.getUserId()
        );
    }

    public static Token toDomainObject(TokenDto tokenDto){
        return new Token(
                tokenDto.getId(),
                tokenDto.getValue(),
                new Date(tokenDto.getExpirationDate()),
                tokenDto.getUserId()
        );
    }
}
