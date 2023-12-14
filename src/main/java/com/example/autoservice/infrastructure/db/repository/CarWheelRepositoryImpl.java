package com.example.autoservice.infrastructure.db.repository;

import com.example.autoservice.domain.repository.CarWheelRepository;
import com.example.autoservice.domain.model.CarWheel;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CarWheelRepositoryImpl implements CarWheelRepository {

    private final EntityManager entityManager;

    @Autowired
    public CarWheelRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CarWheel> getCarWheels() {
        Session session = entityManager.unwrap(Session.class);
        Query<CarWheel> query = session.createQuery("from CarWheel", CarWheel.class);
        return query.getResultList();
    }

    @Override
    public CarWheel getCarWheelById(UUID id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(CarWheel.class, id);
    }

    @Override
    public void save(CarWheel carWheel) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(carWheel);
    }

    @Override
    public void removeById(UUID id) {
        Session session = entityManager.unwrap(Session.class);
        CarWheel carWheel = session.get(CarWheel.class, id);
        session.remove(carWheel);
    }

}
