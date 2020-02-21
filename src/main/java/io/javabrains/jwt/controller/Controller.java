package io.javabrains.jwt.controller;

import io.javabrains.jwt.model.AuthenticationResponse;
import io.javabrains.jwt.model.AutheticationRequest;
import io.javabrains.jwt.repo.DemonRepo;
import io.javabrains.jwt.service.MyUserDetailsService;
import io.javabrains.jwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {


    @Autowired
    private DemonRepo repo;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUtil jwtTokenUtil;

    /*
      user details service
     */

    @Autowired
    private MyUserDetailsService userDetailsService;

    @GetMapping({"/hello"})
    public String hello()
    {
        System.out.println(repo.count());
        return "Hello";
    }
    @PostMapping({"/authenticate"})
    public ResponseEntity<?> authenticate(@RequestBody AutheticationRequest authenticationRequest) throws Exception{

            /*
                Authentificate user
            */

        try {

            /*
               Autentification by auth manager provided by spring
            */

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
