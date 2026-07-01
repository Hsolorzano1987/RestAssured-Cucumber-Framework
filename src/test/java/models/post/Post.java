package models.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.util.List;

public record Post(
        @JsonProperty("title") String title,
        @JsonProperty("body") String body,
        @JsonProperty("tags") List<String> tags,
        @JsonProperty("reactions") Reactions reactions,
        @JsonProperty("userId") int userId
) {
    public static Post generateRandomPost() {
        final var faker = new Faker();

        final var title = faker.lorem().word();
        final var body = faker.lorem().sentence(10);
        final var tags = faker.lorem().words(5);
        final var reactions = Reactions.generateRandomReactions();
        final var userId = faker.number().numberBetween(1, 16);

        return new Post(title, body, tags, reactions, userId);
    }
}
