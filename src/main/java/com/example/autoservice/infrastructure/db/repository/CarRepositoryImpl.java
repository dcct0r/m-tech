package com.example.autoservice.infrastructure.db.repository;

import com.example.autoservice.domain.model.Car;
import com.example.autoservice.domain.repository.CarRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final EntityManager entityManager;

    @Autowired
    public CarRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> getCars() {
        Session session = entityManager.unwrap(Session.class);
        Query<Car> query = session.createQuery("FROM Car", Car.class);
        return query.getResultList();
    }

    @Override
    public Car getCarById(UUID id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Car.class, id);
    }

    @Override
    public void save(Car car) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(car);
    }

    @Override
    public void removeById(UUID id) {
        Session session = entityManager.unwrap(Session.class);
        Car car = session.get(Car.class, id);
        session.remove(car);
    }

}
