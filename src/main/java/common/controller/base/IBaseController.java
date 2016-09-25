package common.controller.base;

import common.unitofwork.UnitOfWorkFactory;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */
public interface IBaseController {
    void setUnitOfWorkFactory(UnitOfWorkFactory unitOfWorkFactory);
}
