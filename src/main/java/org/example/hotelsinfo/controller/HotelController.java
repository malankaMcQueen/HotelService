package org.example.hotelsinfo.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.example.hotelsinfo.dto.HotelShortResponse;
import org.example.hotelsinfo.model.Hotel;
import org.example.hotelsinfo.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/property-view")
@AllArgsConstructor
public class HotelController {
    private HotelService hotelService;

    @Operation(summary = "Получить все отели",
            description = "Метод выводит сжатую информацию о всех отелях")
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelShortResponse>> getAllHotels() {
        return new ResponseEntity<>(hotelService.getAllHotelsShort(), HttpStatus.OK);
    }
    @Operation(summary = "Получить информацию об отеле",
            description = "Метод выводит полную информацию об отеле")
    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getInfoAboutHotel(@PathVariable("id") Long id) {
        return new ResponseEntity<>(hotelService.getInfoAboutHotel(id), HttpStatus.OK);
    }

    @Operation(summary = "Поиск по параметрам",
            description = "Метод выполняет поиск по заданным параметрам")
    @GetMapping("/search")
    public ResponseEntity<List<HotelShortResponse>> getInfoAboutHotelsByParam(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "brand", required = false) String brand,
                                                                              @RequestParam(name = "city", required = false) String city, @RequestParam(name = "amenities", required = false) String amenities,
                                                                              @RequestParam(name = "country", required = false) String country) {
        return new ResponseEntity<>(hotelService.getInfoAboutHotelsByParams(name, brand, city, country, amenities), HttpStatus.OK);
    }

    @Operation(summary = "Добавить отель",
            description = "Метод создаёт новый отель")
    @PostMapping("/hotels")
    public ResponseEntity<HotelShortResponse> createHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }
    @Operation(summary = "Установить преимущества отеля",
            description = "Метод Устанавливает преимущества отеля")
    @PostMapping("/hotels/{id}/amenities")
    public ResponseEntity<Hotel> addAmenities(@PathVariable("id") Long hotelId, @RequestBody List<String> amenities) {
        return new ResponseEntity<>(hotelService.addAmenities(hotelId, amenities), HttpStatus.OK);
    }

    @Operation(summary = "Получить гистограмму",
            description = "Метод выводит гистограмму по заданному параметру")
    @GetMapping("/histogram/{param}")
    public ResponseEntity<Map<String, Integer>> getHotelsNumbersByParam(@PathVariable("param") String param) {
        return new ResponseEntity<>(hotelService.getHistogram(param), HttpStatus.OK);
    }
}
