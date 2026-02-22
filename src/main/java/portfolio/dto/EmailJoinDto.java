package portfolio.dto;

import lombok.Data;

@Data
public class EmailJoinDto {
    private String emailId;
    private String password;
    private String passwordCheck;
}
