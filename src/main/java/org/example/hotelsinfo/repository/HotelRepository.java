package org.example.hotelsinfo.repository;

import lombok.NonNull;
import org.example.hotelsinfo.dto.HistogramElement;
import org.example.hotelsinfo.model.Hotel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @NonNull
    @EntityGraph(attributePaths = {"amenities", "address", "contacts", "arrivalTime"})
    Optional<Hotel> findById(@NonNull Long id);

    @Query("SELECT h FROM Hotel h " +
            "WHERE (:name IS NULL OR h.name = :name) " +
            "AND (:brand IS NULL OR h.brand = :brand) " +
            "AND (:city IS NULL OR h.address.city = :city) " +
            "AND (:country IS NULL OR h.address.country = :city) " +
            "AND (:amenities IS NULL OR :amenities MEMBER OF h.amenities)")
    List<Hotel> findHotelsByParams(String name, String brand, String city, String country, String amenities);

    @Query("SELECT h.brand AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.brand")
    List<HistogramElement> countHotelsByBrand();

    @Query("SELECT h.address.city AS name, COUNT(h) AS count " +
            "FROM Hotel h GROUP BY h.address.city")
    List<HistogramElement> countHotelsByCity();

    @Query("SELECT h.address.country AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.address.country")
    List<HistogramElement> countHotelsByCountry();

    @Query("SELECT amenity AS name, COUNT(h) AS count FROM Hotel h JOIN h.amenities amenity GROUP BY amenity")
    List<HistogramElement> countHotelsByAmenities();
}
