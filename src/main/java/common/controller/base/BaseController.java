package common.controller.base;

import common.unitofwork.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
@Controller
public class BaseController implements IBaseController {

    protected UnitOfWorkFactory unitOfWorkFactory;
    protected final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);



    /*@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {

        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter : {}", counter);
        return VIEW_INDEX;

    } */

    public void setUnitOfWorkFactory(UnitOfWorkFactory unitOfWorkFactory) {
        this.unitOfWorkFactory = unitOfWorkFactory;
    }

}
