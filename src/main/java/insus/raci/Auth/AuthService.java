package insus.raci.Auth;

import org.springframework.stereotype.Service;

import insus.raci.jwt.JwtService;
import insus.raci.models.Role;
import insus.raci.models.User;
import insus.raci.models.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final  UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user =  User.builder()
        .username(request.getUsername())
        .password(request.getPassword())
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .country(request.getCountry())
        .role(Role.USER)
        .build();

        userRepository.save(user);
        
        return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }

}
