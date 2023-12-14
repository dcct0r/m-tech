package com.example.autoservice.infrastructure.db.repository;

import com.example.autoservice.domain.repository.CarBodyRepository;
import com.example.autoservice.domain.model.CarBody;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CarBodyRepositoryImpl implements CarBodyRepository {

    private final EntityManager entityManager;

    @Autowired
    public CarBodyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CarBody> getBodyCars() {
        Session session = entityManager.unwrap(Session.class);
        Query<CarBody> query = session.createQuery("from CarBody", CarBody.class);
        return query.getResultList();
    }

    @Override
    public CarBody getCarBodyById(UUID id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(CarBody.class, id);
    }

    @Override
    public void save(CarBody carBody) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(carBody);
    }

    @Override
    public void removeById(UUID id) {
        Session session = entityManager.unwrap(Session.class);
        CarBody carBody = session.get(CarBody.class, id);
        session.remove(carBody);
    }

}
