package ev.koslov.web.controller;

import ev.koslov.db.entity.Account;
import ev.koslov.services.AccountService;
import ev.koslov.services.AuthenticationService;
import ev.koslov.web.dto.LoginForm;
import ev.koslov.web.dto.RegisterForm;
import ev.koslov.web.validators.LoginFormValidator;
import ev.koslov.web.validators.RegisterFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 *
 */

@Controller
@RequestMapping("/")
public class AccountController {

    private AccountService accountService;
    private AuthenticationService authenticationService;
    private LoginFormValidator loginFormValidator;
    private RegisterFormValidator registerFormValidator;

    @Autowired
    public AccountController(AccountService accountService,
                             AuthenticationService authenticationService,
                             LoginFormValidator loginFormValidator,
                             RegisterFormValidator registerFormValidator)
    {
        this.accountService = accountService;
        this.authenticationService = authenticationService;
        this.loginFormValidator = loginFormValidator;
        this.registerFormValidator = registerFormValidator;
    }

    @InitBinder("loginForm")
    public void initLoginFormBinder(WebDataBinder binder) {
        binder.addValidators(loginFormValidator);
    }

    @InitBinder("registerForm")
    public void initRegisterFormBinder(WebDataBinder binder) {
        binder.addValidators(registerFormValidator);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm,
                          BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        authenticationService.authenticate(loginForm);

        //TODO: add redirection to requested page. Example: session.getAttribute("requestedPage")...

        return "redirect:/";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        Account account = accountService.createAccount(registerForm);

        return "redirect:/login";
    }
}
