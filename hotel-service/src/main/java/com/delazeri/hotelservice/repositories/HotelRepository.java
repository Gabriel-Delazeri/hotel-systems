package com.delazeri.hotelservice.repositories;

import com.delazeri.hotelservice.entities.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends ElasticsearchRepository<Hotel, String> {
    Page<Hotel> findAllByNumberOfRoomsGreaterThanAndCapacityGreaterThan(int rooms, int capacity, Pageable pageable);
}
