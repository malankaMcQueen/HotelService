package org.example.hotelsinfo.service;

import lombok.AllArgsConstructor;
import org.example.hotelsinfo.dto.HistogramElement;
import org.example.hotelsinfo.dto.HotelShortResponse;
import org.example.hotelsinfo.exception.BadRequestException;
import org.example.hotelsinfo.exception.ResourceNotFoundException;
import org.example.hotelsinfo.model.Hotel;
import org.example.hotelsinfo.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelService {
    private HotelRepository hotelRepository;

    public List<HotelShortResponse> getAllHotelsShort() {
        return hotelRepository.findAll().stream().map(HotelShortResponse::hotelShortResponseFromHotel).collect(Collectors.toList());
    }


    public Hotel getInfoAboutHotel(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The hotel was not found"));
    }

    public List<HotelShortResponse> getInfoAboutHotelsByParams(String name, String brand, String city, String country, String amenities) {
        List<Hotel> hotels = hotelRepository.findHotelsByParams(name, brand, city, country, amenities);

        return hotels.stream().map(HotelShortResponse::hotelShortResponseFromHotel).collect(Collectors.toList());
    }

    public HotelShortResponse createHotel(Hotel hotel) {
        return HotelShortResponse.hotelShortResponseFromHotel(hotelRepository.save(hotel));
    }

    public Hotel addAmenities(Long hotelId, List<String> amenities) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()
                -> new ResourceNotFoundException("The hotel was not found"));
        hotel.setAmenities(amenities);
        return hotelRepository.save(hotel);
    }


    public Map<String, Integer> getHistogram(String param) {
        List<HistogramElement> histogramElementList = switch (param.toLowerCase()) {
            case "brand" -> hotelRepository.countHotelsByBrand();
            case "city" -> hotelRepository.countHotelsByCity();
            case "country" -> hotelRepository.countHotelsByCountry();
            case "amenities" -> hotelRepository.countHotelsByAmenities();
            default -> throw new BadRequestException("Invalid parameter: " + param);
        };
        return histogramElementList.stream()
                .collect(Collectors.toMap(
                        HistogramElement::getName,
                        HistogramElement::getCount
                ));
    }
}
