package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Table(name="users")
@NamedQueries({
    @NamedQuery(
            name = "getAllUsers",
            query = "SELECT u FROM User AS u ORDER BY u.id DESC"
            ),
    @NamedQuery(
            name ="getUsersCount",
            query="SELECT COUNT(u) FROM User AS u"
            ),
    @NamedQuery(  //ログインする時にメールアドレスとパスワードが正しいかをチェックする
            name="checkLoginPassword",
            query="SELECT u FROM User AS u WHERE u.password = :pass AND u.mail = :mail"
            )

})
@Entity
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name = "mail" , nullable=false)
    private String mail;

    @Column(name="password",length=64,nullable=false)
    private String password;

    @Column(name="admin_flag",nullable=false)
    private Integer admin_flag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



}
