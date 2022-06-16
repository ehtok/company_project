package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static Constant.Constants.NAME_PERSIST;

public class EntityFactoryManager {

    private static final String PERSISTENCE_UNIT_NAME = NAME_PERSIST;

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);


    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }


    public static void close() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
