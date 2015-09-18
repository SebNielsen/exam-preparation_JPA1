/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entities.Project;
import Entities.ProjectUser;
import Entities.Task;
import Facade.CRUD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sebastiannielsen
 */
public class Control implements CRUD {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exam-JPA1PU");
    EntityManager em = emf.createEntityManager();
    
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    
    
    @Override
    public void createUser(String userName, String email) {
        ProjectUser user = new ProjectUser(userName, email, dateFormat.format(date));
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void createProject(String name, String description) {
        Project project = new Project(name, description, dateFormat.format(date));
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
    }

    @Override
    public void createTaskAndAssignToProject(String name, String description, int hoursAssigned, long id) {
        Task task = new Task(name, description, hoursAssigned);
        Project project = em.find(Project.class, id);
        em.getTransaction().begin();
        em.persist(task);
        project.addTask(task);
        em.getTransaction().commit();
    }

    @Override
    public Project getProject(long id) {
        return em.find(Project.class, id);
    }

    @Override
    public ProjectUser getUser(long id) {
        return em.find(ProjectUser.class, id);
    }

    @Override
    public Task getTask(long id) {
        return em.find(Task.class, id);
    }
    
    @Override
    public List<ProjectUser> getAllProjectUsers() {
        Query query = em.createQuery("SELECT pu FROM ProjectUser pu", ProjectUser.class);
        List <ProjectUser> projectUsers = query.getResultList();
        return projectUsers;
    }
    
    @Override
    public List<Task> getAllTasks() {
        Query query = em.createQuery("SELECT t FROM Task t", Task.class);
        List <Task> tasks = query.getResultList();
        return tasks;
    }

    @Override
    public List<Project> getAllProjects() {
        Query query = em.createQuery("SELECT p FROM Project p", Project.class);
        List <Project> projects = query.getResultList();
        return projects;
    }

    @Override
    public void assignUserToProject(long UserId, long projectId) {
        Project project = em.find(Project.class, projectId);
        ProjectUser user = em.find(ProjectUser.class, UserId);
        em.getTransaction().begin();
        project.addUser(user);
        em.getTransaction().commit();
    }
    
}
