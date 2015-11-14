package xyz.safety.vo;

import org.apache.ibatis.type.Alias;

import java.util.Date;
import javax.persistence.*;

@Alias("Users")
public class Users {
    @Id
    @Column(name = "_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "MAIL_CONFIRM_YN")
    private String mailConfirmYn;

    @Column(name = "REG_DATE")
    private Date regDate;

    /**
     * @return _ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return NICK_NAME
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return MAIL_CONFIRM_YN
     */
    public String getMailConfirmYn() {
        return mailConfirmYn;
    }

    /**
     * @param mailConfirmYn
     */
    public void setMailConfirmYn(String mailConfirmYn) {
        this.mailConfirmYn = mailConfirmYn;
    }

    /**
     * @return REG_DATE
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * @param regDate
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}