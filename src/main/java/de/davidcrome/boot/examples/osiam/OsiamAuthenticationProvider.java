package de.davidcrome.boot.examples.osiam;

import org.osiam.client.OsiamConnector;
import org.osiam.client.exception.OsiamRequestException;
import org.osiam.client.oauth.AccessToken;
import org.osiam.client.oauth.Scope;
import org.osiam.resources.scim.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

public class OsiamAuthenticationProvider implements AuthenticationProvider {

    private final OsiamConnector osiamConnector;
    private final HttpSession httpSession;

    public OsiamAuthenticationProvider(OsiamConnector osiamConnector,
                                       HttpSession httpSession) {
        this.osiamConnector = osiamConnector;
        this.httpSession = httpSession;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        try {
            AccessToken accessToken = osiamConnector.retrieveAccessToken(username, password, Scope.ME);
            httpSession.setAttribute("accessToken", accessToken.getToken());
            User me = osiamConnector.getMe(accessToken);
            List<SimpleGrantedAuthority> authorities = me.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(me, null, authorities);
        } catch (OsiamRequestException e) {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}