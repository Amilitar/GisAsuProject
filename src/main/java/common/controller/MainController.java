package common.controller;

import common.controller.base.BaseController;
import common.unitofwork.HibernateUnitOfWork;
import common.unitofwork.IRepository;
import data.entities.ContactsEntity;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */
public class MainController extends BaseController {

    private static final String VIEW_INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", 1);
        logger.debug("[welcome] counter : {}", 1);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/getContacts", method = RequestMethod.GET, produces={"application/json; charset=cp1251"})
    public @ResponseBody String getContacts(){
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<ContactsEntity> contacts = (ArrayList<ContactsEntity>) getContactEntities();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }


    @RequestMapping(value = "/deleteContact/{idContact}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteContact(@PathVariable("idContact")int idContact){

        deleteContactEntity(idContact);

    }

    private java.util.List<ContactsEntity> getContactEntities(){
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<ContactsEntity> repo = unitOfWork.<ContactsEntity>getRepository();
            return repo.getAll(ContactsEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void deleteContactEntity(int idContact){
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<ContactsEntity> repo = unitOfWork.<ContactsEntity>getRepository();
            ContactsEntity contactsEntity = repo.getById(ContactsEntity.class, idContact);
            repo.delete(contactsEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
