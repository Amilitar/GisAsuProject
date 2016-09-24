package common.controller;

import common.unitofwork.*;
import entities.ContactsEntity;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Enumeration;
import java.util.List;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
@Controller
public class BaseController {

    private UnitOfWorkFactory unitOfWorkFactory;
    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<ContactsEntity> repo = unitOfWork.<ContactsEntity>getRepository();
            Iterable<ContactsEntity> contacts = repo.getAll(ContactsEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcome] counter : {}", counter);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {

        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter : {}", counter);
        return VIEW_INDEX;

    }

    public void setUnitOfWorkFactory(UnitOfWorkFactory unitOfWorkFactory) {
        this.unitOfWorkFactory = unitOfWorkFactory;
    }

}
