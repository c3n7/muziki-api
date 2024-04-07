package tech.c3n7.muziki.auth.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private final String token;
}
