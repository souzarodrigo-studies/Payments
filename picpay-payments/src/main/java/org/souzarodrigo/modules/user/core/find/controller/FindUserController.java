package org.souzarodrigo.modules.user.core.find.controller;

import org.souzarodrigo.modules.user.core.find.useCase.FindUserUseCase;
import org.souzarodrigo.global.models.Admin;
import org.souzarodrigo.global.models.Customer;
import org.souzarodrigo.global.models.Shopkeeper;
import org.souzarodrigo.core.utils.security.constants.Roles;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class FindUserController {

    @Inject
    FindUserUseCase findUserUseCase;

    public Response handleFindUser(SecurityContext context) {

        Object user = null;

        if (context.getUserPrincipal() == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        if (context.isUserInRole(String.valueOf(Roles.ADMIN))) {
            user = findUserUseCase.executeFindUser(context, Roles.ADMIN, Admin.class);
        }
        if (context.isUserInRole(String.valueOf(Roles.CUSTOMER))) {
            user = findUserUseCase.executeFindUser(context, Roles.CUSTOMER, Customer.class);
        }
        if (context.isUserInRole(String.valueOf(Roles.SHOPKEEPER))) {
            user = findUserUseCase.executeFindUser(context, Roles.SHOPKEEPER, Shopkeeper.class);
        }

        return Response.status(200).entity(user).build();
    }
}
