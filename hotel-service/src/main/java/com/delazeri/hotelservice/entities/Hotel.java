package com.delazeri.hotelservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "hotel", createIndex = true)
@RequiredArgsConstructor
public class Hotel {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    @NonNull
    private String name;
    @Field(type = FieldType.Text)
    @NonNull
    private GeoPoint locationPoint;
    @Field(type = FieldType.Double)
    @NonNull
    private double price;
    @Field(type = FieldType.Integer)
    @NonNull
    private int numberOfRooms;
    @Field(type = FieldType.Integer)
    @NonNull
    private int capacity;
    @Field(type = FieldType.Keyword)
    @NonNull
    private List<String> amenities;
    @Field(type = FieldType.Double)
    @NonNull
    private double rating;
}
