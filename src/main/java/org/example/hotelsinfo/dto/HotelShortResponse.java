package org.example.hotelsinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotelsinfo.model.Hotel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelShortResponse {
    private Long id;

    private String name;

    private String description;

    private String address;

    private String phone;

    static public HotelShortResponse hotelShortResponseFromHotel(Hotel hotel) {
        return HotelShortResponse.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .address(hotel.getAddress().toFormattedString())
                .phone(hotel.getContacts().getPhone())
                .build();
    }
}


