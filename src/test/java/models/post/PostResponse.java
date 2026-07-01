package models.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PostResponse(
        @JsonProperty("id") int id,
        @JsonProperty("title") String title,
        @JsonProperty("body") String body,
        @JsonProperty("tags") List<String> tags,
        @JsonProperty("reactions") Reactions reactions,
        @JsonProperty("views") int views,
        @JsonProperty("userId") int userId
) {

}

