package nms.magotalk.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private Long memberId;
    private String memberPassword;
    private String memberDepartment;
    private int memberGrade;
    private int memberClass;
    private String memberName;
    private String memberEmail;

    public Member(String memberPassword, String memberDepartment, int memberGrade, int memberClass, String memberName, String memberEmail) {
        this.memberPassword = memberPassword;
        this.memberDepartment = memberDepartment;
        this.memberGrade = memberGrade;
        this.memberClass = memberClass;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }
}
