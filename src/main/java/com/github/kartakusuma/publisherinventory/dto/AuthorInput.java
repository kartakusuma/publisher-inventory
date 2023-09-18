package com.github.kartakusuma.publisherinventory.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInput {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
}
