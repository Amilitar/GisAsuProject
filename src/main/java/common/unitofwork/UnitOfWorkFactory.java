package common.unitofwork;

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public class UnitOfWorkFactory implements IUnitOfWorkFactory{
    //region Fields

    //private final IDatabaseConfiguration _databaseConfiguration;
    private SessionFactory sessionFactory;
    //private Configuration _configuration;

    //endregion // Fields

    //region Constructors

    public UnitOfWorkFactory()
    {
        //this.hibernate4AnnotatedSessionFactory
    }

    //endregion // Constructors

    //region Properties



    /// <summary>
    /// Строка подключения
    /// </summary>
    public String getConnectionString()
    {
        return "";//_databaseConfiguration.getConnectionString();
    }


    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    //endregion Properties

    //region Implementations


    /// <summary>
    /// Создание классического uow, для работы с сущностями
    /// </summary>
    /// <returns></returns>
    public HibernateUnitOfWork createUnitOfWork()
    {
        return
                new HibernateUnitOfWork(setupSession());
    }

//endregion //Implementations

    //region Methods

    //region setupSessionFactory

    /// <summary>
    /// Фабричный метод для создания фабрики сессии
    /// </summary>
    /// <param name="force"></param>
    private void setupSessionFactory()
    {
        setupSessionFactory(false);
    }
    /// <summary>
    /// Фабричный метод для создания фабрики сессии
    /// </summary>
    /// <param name="force"></param>
    private void setupSessionFactory(Boolean force)
    {

    }


    //endregion // setupSessionFactory

    //region setupSession

    /// <summary>
    /// Настройка новой сессии
    /// </summary>
    private Session setupSession()
    {
        //Configuration configuration = new Configuration().configure();
        //StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        //SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session session = this.sessionFactory.openSession();
        session.setFlushMode(FlushMode.COMMIT);
        session.setCacheMode(CacheMode.REFRESH);

        return session;
    }

    //endregion // setupSession

    //region configure

    /// <summary>
    /// Создание Hibernate соединения
    /// </summary>
    private void configure()
    {
        //_configuration = _databaseConfiguration.getConfiguration(_databaseConfiguration.getConnectionString());
    }

    //endregion // configure

    //endregion //Methods
}
