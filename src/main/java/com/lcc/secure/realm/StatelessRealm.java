package com.lcc.secure.realm;

import com.lcc.jopo.UserPrincipal;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * Created by lcc on 2016/12/13.
 */
public class StatelessRealm extends AuthorizingRealm {
    private static Logger logger = Logger.getLogger(StatelessRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserPrincipal userPrincipal = (UserPrincipal) principals.getPrimaryPrincipal();
        UserPrincipal.PrincipType principType = userPrincipal.getPrincipType();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(principType.getRoleName());
        switch (principType){
            case USER:
                authorizationInfo.addStringPermission("user:*");
                authorizationInfo.addStringPermission("avatar:read");
                break;
            case ADMIN:
                authorizationInfo.addStringPermission("user:*");
                authorizationInfo.addStringPermission("avatar:*");
                authorizationInfo.addStringPermission("admin:*");
                break;
        }
        logger.info("authrizations: Roles:" + authorizationInfo.getRoles()
                + " permesins" + authorizationInfo.getStringPermissions());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        StatelessToken statelessToken = (StatelessToken) token;
        UserPrincipal userPrincipal = statelessToken.getUserPrincipal();
        String pass = statelessToken.getPassword();
        statelessToken.setUser(null);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        SimplePrincipalCollection simplePrincipalCollection = new SimplePrincipalCollection();
        simplePrincipalCollection.add(userPrincipal,getName());
        authenticationInfo.setCredentials(simplePrincipalCollection);
        authenticationInfo.setCredentials(pass);
        logger.info("认证成功!!! principalls:" + userPrincipal + " credentiasl:" + pass);
        return authenticationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        boolean result = token instanceof StatelessToken;
        return result;
    }
}
