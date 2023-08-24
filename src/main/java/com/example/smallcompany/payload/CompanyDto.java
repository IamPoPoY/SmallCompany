package com.example.smallcompany.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    @NotNull
    private String corpName;

    @NotNull
    private String directorName;

    @NotNull
    private String street;

    @NotNull
    private String homeNumber;
}
