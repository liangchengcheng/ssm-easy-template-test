package com.lcc.secure.realm;

import com.lcc.jopo.UserPrincipal;
import com.lcc.model.User;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by lcc on 2016/12/13.
 */
public class StatelessToken implements AuthenticationToken {
    private UserPrincipal userPrincipal;

    private String password;

    private User user;

    public StatelessToken() {
    }

    private static final long serialVersionUID = 1L;

    public StatelessToken(UserPrincipal principal, String password) {
        super();
        this.userPrincipal = principal;
        this.password = password;
    }

    // 返回用户验证信息
    @Override
    public Object getCredentials() {
        return password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param principal 要设置的 principal
     */
    public void setPrincipal(UserPrincipal principal) {
        this.userPrincipal = principal;
    }

    /*
     * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "StatelessToken [principal=" + userPrincipal + ", password="
                + password + "]";
    }

    @Override
    public Object getPrincipal() {
        return userPrincipal;
    }

    /**
     * @return 获取 userPrincipal
     */
    public UserPrincipal getUserPrincipal() {
        return userPrincipal;
    }

    /**
     * @param userPrincipal 要设置的 userPrincipal
     */
    public void setUserPrincipal(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

    /**
     * @return 获取 user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user 要设置的 user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
