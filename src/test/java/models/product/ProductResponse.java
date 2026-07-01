package models.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(
        @JsonProperty("id") int id,
        @JsonProperty("title") String title,
        @JsonProperty("description") String description,
        @JsonProperty("category") String category,
        @JsonProperty("price") double price,
        @JsonProperty("rating") double rating,
        @JsonProperty("stock") int stock
) {

}
