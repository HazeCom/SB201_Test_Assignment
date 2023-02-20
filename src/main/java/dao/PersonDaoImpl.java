package dao;

import entities.Person;
import exceptions.PersonException;
import utility.EMUtil;

import jakarta.persistence.EntityManager;

public class PersonDaoImpl implements PersonDao{
    @Override
    public Person addPerson(Person person) throws PersonException {
        EntityManager em = EMUtil.provideEntityManager();
        if(person == null) throw new PersonException("Please provide valid data");
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        return person;
    }

    @Override
    public Person deletePerson(int id) throws PersonException{
        EntityManager em = EMUtil.provideEntityManager();
        Person person = em.find(Person.class,id);
        if(person == null) throw new PersonException("No data found");
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
        return person;
    }

    @Override
    public Person findPersonById(int id) throws PersonException{
        EntityManager em = EMUtil.provideEntityManager();
        Person person = em.find(Person.class,id);
        if(person == null) throw new PersonException("No data found");
        return person;
    }
}
