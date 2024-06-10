package com.softtek.BitFest.Controlador;



import com.softtek.BitFest.dto.response.JwtAuthenticationResponse;
import com.softtek.BitFest.dto.response.LoginRequest;
import com.softtek.BitFest.dto.response.RegistroRequest;
import com.softtek.BitFest.servicio.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/registro")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody RegistroRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }

}