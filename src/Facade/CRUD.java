/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Project;
import Entities.ProjectUser;
import Entities.Task;
import java.util.List;

/**
 *
 * @author sebastiannielsen
 */
public interface CRUD {
    
    public void createUser(String userName, String email);
    public void createProject(String name, String description);
    public void createTaskAndAssignToProject(String name, String descriotion, int hoursAssigned, long id);
    
    public Project getProject(long id);
    public ProjectUser getUser(long id);
    public Task getTask(long id);
    
    public List<ProjectUser> getAllProjectUsers();
    public List<Task> getAllTasks();
    public List<Project> getAllProjects();
    
    public void assignUserToProject(long UserId, long projectId);
    
}
