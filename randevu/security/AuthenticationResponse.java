package learn.randevu.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

    @Getter
    @Setter
    public class AuthenticationResponse {

        private final String jwt;


        public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

        public String getJwt() {
        return jwt;
    }
}
