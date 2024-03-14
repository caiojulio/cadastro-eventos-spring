package com.eventapp.eventapp.repositories;

import com.eventapp.eventapp.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventsRepository extends JpaRepository<EventModel, Integer> {
}
