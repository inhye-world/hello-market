package inhye.hellomarket.dto;

public class Member {
    private Long id;
    private String username;
    private String pwd;
    private String pwd_cf;
    private String authority;

    public boolean isPwdEqual(){
        return pwd.equals(pwd_cf);
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd_cf() {
        return pwd_cf;
    }

    public void setPwd_cf(String pwd_cf) {
        this.pwd_cf = pwd_cf;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", pwd_cf='" + pwd_cf + '\'' +
                ", authority=" + authority +
                '}';
    }
}
