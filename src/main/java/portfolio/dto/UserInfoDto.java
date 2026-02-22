package portfolio.dto;

import lombok.Data;
import portfolio.domain.MemberType;

@Data
public class UserInfoDto {
    private String username;
    private Integer age;
    private MemberType memberType;
}
