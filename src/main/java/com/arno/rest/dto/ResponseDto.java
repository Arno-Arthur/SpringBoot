package com.arno.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {

    private String message;

    private int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CallDto> calls;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDto user;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MedicationsDto> medications;

    public String getMessage() {
        if (message == null) {
            message = "";
        }
        return message;
    }
}
