package org.vip.info;

import org.wso2.msf4j.MicroservicesRunner;
import org.vip.info.dao.UserRepository ;
import org.vip.info.resource.UserResource;

import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        new MicroservicesRunner()
                .deploy(new UserResource(getUserRepository()))
                .start();
    }

    public static UserRepository getUserRepository() {
        return new UserRepository(Persistence.createEntityManagerFactory("org.hibernate.jpa"));
    }

}
