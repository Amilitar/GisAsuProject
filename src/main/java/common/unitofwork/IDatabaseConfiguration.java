package common.unitofwork;

import org.hibernate.cfg.Configuration;

/**
 * User: nikpodrivnik
 * Date: 19/09/16
 */
public interface IDatabaseConfiguration {

    String getConnectionString();

    Configuration getConfiguration(String connectionString);
}
