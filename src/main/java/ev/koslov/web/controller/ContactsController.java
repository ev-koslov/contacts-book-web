package ev.koslov.web.controller;

import ev.koslov.db.entity.Contact;
import ev.koslov.services.ContactService;
import ev.koslov.web.dto.ContactForm;
import ev.koslov.web.validators.ContactFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/")
public class ContactsController {

    private ContactService contactService;
    private ContactFormValidator contactFormValidator;

    @Autowired
    public ContactsController(ContactService contactService, ContactFormValidator contactFormValidator) {
        this.contactService = contactService;
        this.contactFormValidator = contactFormValidator;
    }

    @InitBinder("contactForm")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(contactFormValidator);
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String contactsPage() {
        return "contacts/contacts";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createOrUpdateContact(@Valid @ModelAttribute("contactForm") ContactForm contactForm,
                                        BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "contacts/contact";
        }

        Contact contact;

        if (contactForm.getId() == 0) {
            contact = contactService.createContact(contactForm);
        } else {
            contact = contactService.updateContact(contactForm);
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newContactPage(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contacts/contact";
    }

    @RequestMapping(value = {"/view/{id}"}, method = RequestMethod.GET)
    public String viewContactPage(Model model,
                                  @PathVariable(value = "id") Long contactId
    ) {
        Contact requestedContact = contactService.getContact(contactId);

        if (requestedContact != null) {
            model.addAttribute("contactForm", new ContactForm(requestedContact));
            return "contacts/contact";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteContact(@PathVariable(value = "id") long idToDelete) {
        contactService.deleteContact(idToDelete);
        return "redirect:/";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getContacts(@RequestParam(value = "filter", required = false) String filter) {
        List<Contact> accountContacts;

        if (filter == null || filter.isEmpty()) {
            accountContacts = contactService.getContacts();
        } else {
            accountContacts = contactService.getFilteredContacts(filter);
        }

        ModelAndView modelAndView = new ModelAndView("contacts/contacts_list");
        modelAndView.addObject("contacts", accountContacts);

        return modelAndView;
    }
}
