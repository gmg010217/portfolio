package portfolio.dto;

import lombok.Data;

@Data
public class EmailPasswordResetDto {
    private String password;
    private String passwordCheck;
}
