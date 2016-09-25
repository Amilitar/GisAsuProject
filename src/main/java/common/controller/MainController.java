package common.controller;

import common.controller.base.BaseController;
import common.unitofwork.HibernateUnitOfWork;
import common.unitofwork.IRepository;
import entities.ContactsEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */
public class MainController extends BaseController {

    private static final String VIEW_INDEX = "index";
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<ContactsEntity> repo = unitOfWork.<ContactsEntity>getRepository();
            Iterable<ContactsEntity> contacts = repo.getAll(ContactsEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", 1);
        logger.debug("[welcome] counter : {}", 1);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }
}
