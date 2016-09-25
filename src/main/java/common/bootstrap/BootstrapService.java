package common.bootstrap;

import common.bootstrap.steps.CreateTestData;
import common.unitofwork.UnitOfWorkFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */
@Service
public class BootstrapService implements InitializingBean {
    protected final static org.slf4j.Logger logger = LoggerFactory.getLogger(BootstrapService.class);
    protected UnitOfWorkFactory unitOfWorkFactory;

    @Override
    @Transactional()
    public void afterPropertiesSet() throws Exception {
        logger.debug("Bootstrapping data...");

        CreateTestData createTestData = new CreateTestData(unitOfWorkFactory);
        createTestData.doStep();

        logger.debug("...Bootstrapping completed");
    }

    public void setUnitOfWorkFactory(UnitOfWorkFactory unitOfWorkFactory) {
        this.unitOfWorkFactory = unitOfWorkFactory;
    }


}
