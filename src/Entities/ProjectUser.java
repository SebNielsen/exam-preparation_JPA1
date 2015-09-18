/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author sebastiannielsen
 */
@Entity
public class ProjectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userName;
    private String email;
    private String created;
    
    @ManyToMany(mappedBy = "users")
    private List<Project> projects = new ArrayList<>();
    
    public ProjectUser(){
        
    }
    
    public ProjectUser(String userName, String email, String created){
        this.userName = userName;
        this.email = email;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
    
    public void addProject(Project project){
        projects.add(project);
    }
    
}
