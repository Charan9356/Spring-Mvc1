package spring_mvc2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import spring_mvc2.dto.Employee;

@Repository
public class EmployeeDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("charan");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Employee saveEmployee(Employee employee) throws Exception{
		et.begin();
		em.persist(employee);
		et.commit();
		return employee;
	}
	public Employee fetchByEmail(String email) throws Exception{
		Query q = em.createQuery("select a from Employee a where a.email=?1");
		q.setParameter(1,email);
		return (Employee) q.getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<Employee> fetchAll(){
		Query q = em.createQuery("select a from Employee a");	
		return q.getResultList();
	}
	public Employee update(Employee employee) {
		Employee db = em.find(Employee.class, employee.getId());
		if(db!=null) {
			et.begin();
			em.merge(employee);
			et.commit();
			return employee;
		}
		else {
			return null;
		}
	}
	public Employee fetchByid(int id) {
		Employee db = em.find(Employee.class,id);
		if(db!=null) {
			return db;
		}
		else {
			return null;
		}
	}
	public Employee delete(int id) {
		Employee db = em.find(Employee.class,id);
			if(db!=null) {
				et.begin();
				em.remove(db);
				et.commit();
				return db;
			}
			else {
				return null;
			}
	}
}
