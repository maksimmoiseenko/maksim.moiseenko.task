package maksim.moiseenko.controllers;

import lombok.RequiredArgsConstructor;
import maksim.moiseenko.JwtTokenGenerator;
import maksim.moiseenko.UserDetailsServiceImpl;
import maksim.moiseenko.dto.AccountDto;
import maksim.moiseenko.dto.JwtResponse;
import maksim.moiseenko.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping(produces = "application/json")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenGenerator jwtTokenGenerator;

    private final UserRepository userService;

    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> signIn(@RequestBody AccountDto userDto) {
        authenticate(new UsernamePasswordAuthenticationToken(userDto.getLogin(), userDto.getPassword()));

        UserDetails userByUsername = userDetailsService.loadUserByUsername(userDto.getLogin());
        String token = jwtTokenGenerator.generateToken(userByUsername);
        String role = userByUsername.getAuthorities().iterator().next().toString();
        return ResponseEntity.ok(new JwtResponse(token, role));
    }

    private void authenticate(Authentication authentication) {
        authenticationManager.authenticate(authentication);
    }
}