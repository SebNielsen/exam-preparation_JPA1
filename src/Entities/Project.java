/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author sebastiannielsen
 */
@Entity
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String description;
    private String created;
    private String lastModified;
    
    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();
    
    @ManyToMany
    private List<ProjectUser> users = new ArrayList<>();
    
    public Project(){
        
    }
    
    public Project(String name, String description, String created){
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
    
    public void addTask(Task task){
        tasks.add(task);
    }
    
    public void addUser(ProjectUser user){
        users.add(user);
    }
    
    
    
    
    
}
