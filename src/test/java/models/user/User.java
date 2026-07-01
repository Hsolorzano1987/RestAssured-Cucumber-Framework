package models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.util.List;

public record User(
        @JsonProperty("firstName") String fistName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("age") int age,
        @JsonProperty("gender") String gender,
        @JsonProperty("email") String email,
        @JsonProperty("phone") String phone,
        @JsonProperty("role") String role,
        @JsonProperty("address") Address address,
        @JsonProperty("Company") Company company

) {
    public static User generateRandomUser() {
        final var faker = new Faker();

        final var firstName = faker.name().firstName();
        final var lastName = faker.name().lastName();
        final var age = faker.number().numberBetween(18, 70);
        final var gender = List.of("male", "female").get(faker.number().numberBetween(0, 1));
        final var email = faker.internet().emailAddress();
        final var phone = faker.phoneNumber().cellPhone();
        final var role = faker.job().position();
        final var address = Address.generateRandomAddress();
        final var company = Company.generateRandomCompany();

        return new User(firstName, lastName, age, gender, email, phone, role, address, company);
    }
}
