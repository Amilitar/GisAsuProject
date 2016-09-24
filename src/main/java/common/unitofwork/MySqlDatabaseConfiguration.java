package common.unitofwork;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public class MySqlDatabaseConfiguration implements IDatabaseConfiguration {

    //region Fields

    private String _connectionString;

    //endregion Fields

    //region IDatabaseConfiguration implementation

    public MySqlDatabaseConfiguration(String connectionString)
    {
        _connectionString = connectionString;
    }

    public String getConnectionString(){
        return _connectionString;
    }

    public Configuration getConfiguration(String connectionString)
    {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        configuration.setProperty("command_timeout", "60");

        /*ModelMapper mapper = new ModelMapper();
        mapper.AddMappings(Class(BaseEntity).Assembly.GetTypes().Where(t => t.Name.EndsWith(@"Mapping")));

        configuration.addAnnotatedClass(mapper.CompileMappingForAllExplicitlyAddedEntities()); */
        //Раньше было true, true
        //new SchemaUpdate(configuration).Execute(false, false);

        return configuration;
    }

    //endregion //IDatabaseConfiguration
}
