package com.delazeri.hotelservice.services;

import com.delazeri.hotelservice.dtos.CompareHotelDto;
import com.delazeri.hotelservice.entities.Hotel;
import com.delazeri.hotelservice.enums.HotelCriterion;
import com.delazeri.hotelservice.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class HotelComparisonService {
    private final HotelRepository hotelRepository;

    public Hotel compareHotels(CompareHotelDto compareHotelDto) {
        List<String> hotelIds = compareHotelDto.hotelIds();
        List<Hotel> hotels = StreamSupport.stream(hotelRepository.findAllById(hotelIds).spliterator(), false)
                .collect(Collectors.toList());

        List<HotelCriterion> criteria = compareHotelDto.criteria();

        Map<Hotel, Double> hotelsWithScore = new HashMap<>();
        hotels.forEach(hotel -> hotelsWithScore.put(hotel, 0.0));

        for (int i = 0; i < criteria.size(); i++) {
            HotelCriterion criterion = criteria.get(i);
            int weight = criteria.size() - i;

            switch (criterion) {
                case PRICE:
                    scoreCheapestHotel(hotels, hotelsWithScore, weight);
                    break;
                case RATING:
                    scoreBetterRatedHotel(hotels, hotelsWithScore, weight);
                    break;
                case AMENITIES:
                    scoreHotelWithMostMatchingAmenities(hotels, hotelsWithScore, compareHotelDto.amenities(), weight);
                default:
                    break;
            }
        }

        return hotelsWithScore.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private void scoreCheapestHotel(List<Hotel> hotels, Map<Hotel, Double> hotelsWithScore, int weight) {
        Comparator<Hotel> priceComparator = Comparator.comparingDouble(Hotel::getPrice);
        Hotel cheapestHotel = hotels.stream()
                .min(priceComparator)
                .orElse(null);

        if (cheapestHotel != null) {
            hotelsWithScore.compute(cheapestHotel, (hotel, score) -> score + weight);
        }
    }

    private void scoreBetterRatedHotel(List<Hotel> hotels, Map<Hotel, Double> hotelsWithScore, int weight) {
        Comparator<Hotel> ratingComparator = Comparator.comparingDouble(Hotel::getRating);
        Hotel bestRatedHotel = hotels.stream()
                .max(ratingComparator)
                .orElse(null);

        if (bestRatedHotel != null) {
            hotelsWithScore.compute(bestRatedHotel, (hotel, score) -> score + weight);
        }
    }

    private void scoreHotelWithMostMatchingAmenities(
            List<Hotel> hotels,
            Map<Hotel, Double> hotelsWithScore,
            List<String> amenitiesToCompare,
            int weight
    ) {
        Hotel bestMatchHotel = null;
        long maxCommonAmenities = 0;

        for (Hotel hotel : hotels) {
            long commonAmenitiesCount = hotel.getAmenities().stream()
                    .filter(amenitiesToCompare::contains)
                    .count();

            if (commonAmenitiesCount > maxCommonAmenities) {
                maxCommonAmenities = commonAmenitiesCount;
                bestMatchHotel = hotel;
            }
        }

        if (bestMatchHotel != null) {
            hotelsWithScore.compute(bestMatchHotel, (h, score) -> score + weight);
        }
    }
}
