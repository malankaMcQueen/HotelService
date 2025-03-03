package org.example.hotelsinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "hotel", name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private Integer houseNumber;
    private String street;
    private String city;
    private String country;
    private String postCode;

    public String toFormattedString() {
        return String.format("%s %s, %s, %s, %s",
                houseNumber != null ? houseNumber : "",
                street != null ? street : "",
                city != null ? city : "",
                postCode != null ? postCode : "",
                country != null ? country : "");
    }


}

