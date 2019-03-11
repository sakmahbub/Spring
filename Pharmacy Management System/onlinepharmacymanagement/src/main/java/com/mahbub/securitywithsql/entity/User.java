package com.mahbub.securitywithsql.entity;


import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Name at lest 2 character")
    private String name;


    @NotBlank(message = "Enter your email")
    @Column(nullable = false)
    private String email;


    @Size(min = 5, max = 30, message = "UserName at lest 5 character")
    @Column(nullable = false , unique = true)
    private String userName;


    @Size(min = 4, max = 300, message = "Password at lest 4 character")
    @Column(nullable = true)
    private String password;


    private String gender;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate=new Date();


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date birthDate;

    private boolean enabled;

    @Column(nullable = false)
    private String confirmationToken;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    //////File Upload==============
    @Column(nullable = true)
    private long fileSize;
    private String fileName;
    //  @Lob
    // private byte[] file;
    private String filePath;
    private String fileExtension;

    public User() {
    }

    public User(@NotNull @Size(min = 2, max = 30, message = "Name at lest 2 character") String name, @NotBlank(message = "Enter your email") String email, @Size(min = 5, max = 30, message = "UserName at lest 5 character") String userName, @Size(min = 4, max = 300, message = "Password at lest 4 character") String password, Date birthDate, boolean enabled, String confirmationToken, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.enabled = enabled;
        this.confirmationToken = confirmationToken;
        this.roles = roles;
    }

    public User(User user) {
        this.name = user.name;
        this.email = user.email;
        this.userName = user.userName;
        this.password = user.password;
        this.gender = user.gender;
        this.regiDate = user.regiDate;
        this.lastModifiedDate = user.lastModifiedDate;
        this.birthDate = user.birthDate;
        this.enabled = user.enabled;
        this.confirmationToken = user.confirmationToken;
        this.roles = user.roles;
        this.fileSize = user.fileSize;
        this.fileName = user.fileName;
        this.filePath = user.filePath;
        this.fileExtension = user.fileExtension;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                fileSize == user.fileSize &&
                Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(regiDate, user.regiDate) &&
                Objects.equals(lastModifiedDate, user.lastModifiedDate) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(confirmationToken, user.confirmationToken) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(fileName, user.fileName) &&
                Objects.equals(filePath, user.filePath) &&
                Objects.equals(fileExtension, user.fileExtension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, userName, password, gender, regiDate, lastModifiedDate, birthDate, enabled, confirmationToken, roles, fileSize, fileName, filePath, fileExtension);
    }
}

