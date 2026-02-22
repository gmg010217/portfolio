package portfolio.domain;

import lombok.Getter;

@Getter
public enum MemberType {
    ELEMENTARY_STUDENT("초등학생"),
    MIDDLE_SCHOOL_STUDENT("중학생"),
    HIGH_SCHOOL_STUDENT("고등학생"),
    COLLEGE_STUDENT("대학생"),
    WORKER("직장인"),
    OTHER("기타");

    private final String description;

    MemberType(String description) {
        this.description = description;
    }
}
