package com.lcc.jopo;

/**
 * Created by lcc on 2016/12/13.
 */
public class UserPrincipal {

    private String username;

    /**
     */
    public UserPrincipal(String username, PrincipType principType) {
        super();
        this.username = username;
        this.principType = principType;
    }

    /**
     * 构造一个类型为guest的身份
     */
    public UserPrincipal() {
        this("", PrincipType.USER);
    }

    private PrincipType principType;

    public enum PrincipType {
        USER("user"), ADMIN("admin");
        private String roleName;

        private PrincipType(String roleName) {
            this.roleName = roleName;
        }

        /**
         * getRoleName
         * 我们都是
         */
        public String getRoleName() {
            return roleName;
        }

    }

    /**
     * @return 获取 username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username 要设置的 username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return 获取 principType
     */
    public PrincipType getPrincipType() {
        return principType;
    }

    /**
     * @param principType 要设置的 principType
     */
    public void setPrincipType(PrincipType principType) {
        this.principType = principType;
    }
}
