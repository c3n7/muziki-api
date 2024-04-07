package tech.c3n7.muziki.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.c3n7.muziki.auth.dao.AuthenticationRequest;
import tech.c3n7.muziki.auth.dao.AuthenticationResponse;
import tech.c3n7.muziki.auth.dao.RegistrationRequest;
import tech.c3n7.muziki.security.service.JwtTokenService;
import tech.c3n7.muziki.users.dao.UserRepository;
import tech.c3n7.muziki.users.entity.Role;
import tech.c3n7.muziki.users.entity.User;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegistrationRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        String jwtToken= jwtTokenService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwtToken= jwtTokenService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
