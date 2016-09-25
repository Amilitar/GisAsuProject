package common.controller;

import common.controller.base.BaseController;
import common.unitofwork.HibernateUnitOfWork;
import common.unitofwork.IRepository;
import data.entities.CitiesEntity;
import data.entities.ContactsEntity;
import data.entities.PhoneTypeEntity;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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


        return VIEW_INDEX;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST,
            produces = {"application/json; charset=cp1251"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String saveContact(@RequestBody String json) {
        URLDecoder urlDecoder = new URLDecoder();
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = URLDecoder.decode(json, "UTF-8");
            try {
                ContactsEntity contactsEntity = mapper.readValue(json, ContactsEntity.class);
                saveContactEntity(contactsEntity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(value = "/getContacts", method = RequestMethod.GET, produces = {"application/json; charset=cp1251"})
    public
    @ResponseBody
    String getContacts() {
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

    @RequestMapping(value = "/getCities", method = RequestMethod.GET, produces = {"application/json; charset=cp1251"})
    public
    @ResponseBody
    String getCities() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<CitiesEntity> cities = (ArrayList<CitiesEntity>) getCityEntities();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(cities);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }

    @RequestMapping(value = "/getPhoneTypes", method = RequestMethod.GET, produces = {"application/json; charset=cp1251"})
    public
    @ResponseBody
    String getPhoneTypes() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<PhoneTypeEntity> phoneTypes = (ArrayList<PhoneTypeEntity>) getPhoneTypeEntity();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(phoneTypes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }

    @RequestMapping(value = "/getContactsByFilter/{filterString}", method = RequestMethod.GET, produces = {"application/json; charset=cp1251"})
    public
    @ResponseBody
    String getContactsByFilter(@PathVariable("filterString") String filterString) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<ContactsEntity> contacts = (ArrayList<ContactsEntity>) getContactEntitiesByFilter(filterString);
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }


    @RequestMapping(value = "/deleteContact/{idContact}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void deleteContact(@PathVariable("idContact") int idContact) {

        deleteContactEntity(idContact);

    }

    private void saveContactEntity(ContactsEntity contactsEntity) {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<ContactsEntity> repo = unitOfWork.<ContactsEntity>getRepository();
            if (contactsEntity.getId() == null) {
                repo.insert(contactsEntity);
            } else {
                repo.update(contactsEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private java.util.List<ContactsEntity> getContactEntities() {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<ContactsEntity> repo = unitOfWork.<ContactsEntity>getRepository();
            return repo.getAll(ContactsEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private java.util.List<CitiesEntity> getCityEntities() {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<CitiesEntity> repo = unitOfWork.<CitiesEntity>getRepository();
            return repo.getAll(CitiesEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private java.util.List<PhoneTypeEntity> getPhoneTypeEntity() {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<PhoneTypeEntity> repo = unitOfWork.<PhoneTypeEntity>getRepository();
            return repo.getAll(PhoneTypeEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private java.util.List<ContactsEntity> getContactEntitiesByFilter(String filterString) {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<ContactsEntity> repo = unitOfWork.<ContactsEntity>getRepository();
            //todo не забыть реализоватьrepo.
            return repo.getAll(ContactsEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void deleteContactEntity(int idContact) {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<ContactsEntity> repo = unitOfWork.<ContactsEntity>getRepository();
            ContactsEntity contactsEntity = repo.getById(ContactsEntity.class, idContact);
            repo.delete(contactsEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
