package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EndPoints {
    GET("/api/users?page=2"),
    USER("/api/users/");

    private final String endpoint;
}
