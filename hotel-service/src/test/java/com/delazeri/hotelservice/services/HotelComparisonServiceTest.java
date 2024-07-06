package com.delazeri.hotelservice.services;

import com.delazeri.hotelservice.dtos.CompareHotelDto;
import com.delazeri.hotelservice.entities.Hotel;
import com.delazeri.hotelservice.enums.HotelCriterion;
import com.delazeri.hotelservice.repositories.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HotelComparisonServiceTest {
    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelComparisonService hotelComparisonService;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCompareHotels() {
        List<String> hotelIds = Arrays.asList("hotel1", "hotel2");
        List<HotelCriterion> criteria = Arrays.asList(HotelCriterion.PRICE, HotelCriterion.RATING);
        List<String> amenities = Arrays.asList("wifi", "pool");

        Hotel hotel1 = new Hotel("hotel1", "Hotel 1", new GeoPoint(0, 0), 100.0, 10, 2, Arrays.asList("wifi", "pool"), 4.5);
        Hotel hotel2 = new Hotel("hotel2", "Hotel 2", new GeoPoint(0, 0), 150.0, 20, 4, Arrays.asList("wifi", "gym"), 4.8);
        when(hotelRepository.findAllById(hotelIds)).thenReturn(Arrays.asList(hotel1, hotel2));

        CompareHotelDto compareHotelDto = new CompareHotelDto(hotelIds, criteria, amenities);
        Hotel result = hotelComparisonService.compareHotels(compareHotelDto);

        assertEquals(hotel1.getId(), result.getId());

        verify(hotelRepository, times(1)).findAllById(hotelIds);
    }
}
