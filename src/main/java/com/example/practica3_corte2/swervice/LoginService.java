package com.example.practica3_corte2.swervice;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface LoginService {
    Optional<String> getUsername(HttpServletRequest req);
}
