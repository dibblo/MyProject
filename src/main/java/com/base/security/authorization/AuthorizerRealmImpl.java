package com.base.security.authorization;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;
import java.util.List;

public class AuthorizerRealmImpl implements Authorizer {
    @Override
    public boolean isPermitted(PrincipalCollection principalCollection, String s) {
        return false;
    }

    @Override
    public boolean isPermitted(PrincipalCollection principalCollection, Permission permission) {
        return false;
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection principalCollection, String... strings) {
        return new boolean[0];
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection principalCollection, List<Permission> list) {
        return new boolean[0];
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection principalCollection, String... strings) {
        return false;
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection principalCollection, Collection<Permission> collection) {
        return false;
    }

    @Override
    public void checkPermission(PrincipalCollection principalCollection, String s) throws AuthorizationException {

    }

    @Override
    public void checkPermission(PrincipalCollection principalCollection, Permission permission) throws AuthorizationException {

    }

    @Override
    public void checkPermissions(PrincipalCollection principalCollection, String... strings) throws AuthorizationException {

    }

    @Override
    public void checkPermissions(PrincipalCollection principalCollection, Collection<Permission> collection) throws AuthorizationException {

    }

    @Override
    public boolean hasRole(PrincipalCollection principalCollection, String s) {
        return false;
    }

    @Override
    public boolean[] hasRoles(PrincipalCollection principalCollection, List<String> list) {
        return new boolean[0];
    }

    @Override
    public boolean hasAllRoles(PrincipalCollection principalCollection, Collection<String> collection) {
        return false;
    }

    @Override
    public void checkRole(PrincipalCollection principalCollection, String s) throws AuthorizationException {

    }

    @Override
    public void checkRoles(PrincipalCollection principalCollection, Collection<String> collection) throws AuthorizationException {

    }

    @Override
    public void checkRoles(PrincipalCollection principalCollection, String... strings) throws AuthorizationException {

    }
}
