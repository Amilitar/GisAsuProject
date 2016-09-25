package common.bootstrap.steps;

import common.unitofwork.HibernateUnitOfWork;
import common.unitofwork.IRepository;
import common.unitofwork.UnitOfWorkFactory;
import data.entities.CitiesEntity;
import data.entities.ContactsEntity;
import data.entities.PhoneTypeEntity;

/**
 * User: nikpodrivnik
 * Date: 25/09/16
 */
public class CreateTestData extends BaseStep {
    protected UnitOfWorkFactory unitOfWorkFactory;

    @Override
    public void doStep() {
        try (HibernateUnitOfWork unitOfWork = unitOfWorkFactory.createUnitOfWork()) {
            IRepository<CitiesEntity> repoCity= unitOfWork.<CitiesEntity>getRepository();
            CitiesEntity citiesEntity= new CitiesEntity();
            citiesEntity.setName("Томск");
            repoCity.insert(citiesEntity);

            IRepository<PhoneTypeEntity> repoPhoneType= unitOfWork.<PhoneTypeEntity>getRepository();
            PhoneTypeEntity phoneTypeEntity= new PhoneTypeEntity();
            citiesEntity.setName("Мобильный");
            repoPhoneType.insert(phoneTypeEntity);
             phoneTypeEntity= new PhoneTypeEntity();
            citiesEntity.setName("Домашний");
            repoPhoneType.insert(phoneTypeEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setUnitOfWorkFactory(UnitOfWorkFactory unitOfWorkFactory) {
        this.unitOfWorkFactory = unitOfWorkFactory;
    }
}
