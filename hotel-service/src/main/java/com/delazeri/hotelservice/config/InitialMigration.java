package com.delazeri.hotelservice.config;

import com.delazeri.hotelservice.entities.Hotel;
import com.delazeri.hotelservice.repositories.HotelRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitialMigration {
    private final HotelRepository hotelRepository;

    @PostConstruct
    public void run() {
        if (hotelRepository.count() > 0) {
            return;
        }

        List<Hotel> hotels = Arrays.asList(
                new Hotel("Hotel Itaquera", new GeoPoint(-23.54159562449529, -46.47129729144524), 150.0, 60, 2, Arrays.asList("Free Wi-Fi", "Parking", "Restaurant/Bar", "Air Conditioning"), 4.2),
                new Hotel("Hotel Artur Alvim", new GeoPoint(-23.540841338194717, -46.484611612609086), 120.0, 50, 4, Arrays.asList("Free Wi-Fi", "Gym/Fitness Center", "Room Service"), 4.0),
                new Hotel("Hotel Patriarca", new GeoPoint(-23.531037915533915, -46.50154927054375), 180.0, 70, 3, Arrays.asList("Free Wi-Fi", "Swimming Pool", "Spa/Wellness", "24-Hour Reception"), 4.5),
                new Hotel("Hotel Guilhermina", new GeoPoint(-23.529152726763837, -46.516486930068574), 160.0, 65, 4, Arrays.asList("Free Wi-Fi", "Parking", "Room Service", "Events/Conferences"), 4.3),
                new Hotel("Hotel Vila Matilde", new GeoPoint(-23.531754939493666, -46.53095274726513), 140.0, 55, 2 , Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Transportation"), 4.1),
                new Hotel("Hotel Penha", new GeoPoint(-23.53335035850144, -46.54260296075676), 170.0, 68, 2, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Pet-friendly"), 4.4),
                new Hotel("Hotel Carrão", new GeoPoint(-23.537786634162078, -46.564143460756846), 190.0, 72, 2, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Restaurant/Bar"), 4.6),
                new Hotel("Hotel Penha", new GeoPoint(-23.540168983014595, -46.576587504937066), 200.0, 75, 4, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Events/Conferences"), 4.2),
                new Hotel("Hotel Belém", new GeoPoint(-23.5424489574305, -46.589592434844654), 210.0, 78, 4, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Pet-friendly"), 4.3),
                new Hotel("Hotel Bresser - Mooca", new GeoPoint(-23.54632952291805, -46.607208637477854),  220.0, 80, 2, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Room Service"), 4.5),
                new Hotel("Hotel Brás", new GeoPoint(-23.547815153235646, -46.61584413383652), 230.0, 82, 2, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Transportation"), 4.4),
                new Hotel("Hotel Pedro II", new GeoPoint(-23.549438967283407, -46.62585274541212), 240.0, 85, 3, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Spa/Wellness"), 4.6),
                new Hotel("Hotel Sé", new GeoPoint(-23.54998105583872, -46.6333639184285), 250.0, 87, 3, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Restaurant/Bar"), 4.7),
                new Hotel("Hotel Anhagabaú", new GeoPoint(-23.547854934836863, -46.63882000282775), 260.0, 90, 5, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Gym/Fitness Center"), 4.8),
                new Hotel("Hotel República", new GeoPoint(-23.54405370741762, -46.64279730308446), 270.0, 92, 4, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "24-Hour Reception"), 4.9),
                new Hotel("Hotel Santa Cecília", new GeoPoint(-23.538984265659305, -46.64931021842888), 280.0, 95,  2, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Transportation"), 4.6),
                new Hotel("Hotel Marechal Deodoro", new GeoPoint(-23.533704940228183, -46.65580862028144), 290.0, 97, 1, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Pet-friendly"), 4.3),
                new Hotel("Hotel Barra-Funda", new GeoPoint(-23.52475308906037, -46.66723487704766), 300.0, 100, 1, Arrays.asList("Free Wi-Fi", "Bar/Lounge", "Events/Conferences"), 4.2)
        );

        this.hotelRepository.saveAll(hotels);
    }
}
