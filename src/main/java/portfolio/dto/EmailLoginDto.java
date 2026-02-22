package portfolio.dto;

import lombok.Data;

@Data
public class EmailLoginDto {
    private String emailId;
    private String password;
    private Boolean emailLoginSave;
}
