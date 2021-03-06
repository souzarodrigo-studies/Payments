package org.souzarodrigo.modules.user.repository.impl;

import org.souzarodrigo.global.models.Admin;
import org.souzarodrigo.global.models.Customer;
import org.souzarodrigo.global.models.Shopkeeper;
import org.souzarodrigo.modules.user.repository.IUserRepository;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserRepository implements IUserRepository {

    @Override
    public Customer findByEmailCustomer(String email) {
        return Customer.find("email", email).firstResult();
    }

    @Override
    public Shopkeeper findByEmailShopkeeper(String email) {
        return Shopkeeper.find("email", email).firstResult();
    }

    @Override
    public Admin findByEmailAdmin(String email) {
        return Admin.find("email", email).firstResult();
    }
}
