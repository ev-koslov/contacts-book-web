package ev.koslov.services;

import ev.koslov.authentication.AccountDetails;
import ev.koslov.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AccountService accountService;

    public void authenticate(LoginForm loginForm) {
        AccountDetails accountDetails = new AccountDetails(accountService.getAccountByLogin(loginForm.getLogin()));
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                accountDetails.getUsername(),
                accountDetails.getPassword(),
                accountDetails.getAuthorities()
        );

        securityContext.setAuthentication(authentication);
    }

    public String getAuthenticatedLogin() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        return (authentication == null) ? null : (String) authentication.getPrincipal();
    }

    public boolean isAuthenticated() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication() != null;
    }
}
