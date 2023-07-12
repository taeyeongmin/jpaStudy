package com.example.jpa.member.vo;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "member")
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

    @Id
    @Column(name = "member_no")
    private Long memberNo;
    @Column(name = "member_nm")
    private String memberNm;

    @Column
    private String gender;
    @Column(name = "dept_cd")
    private String deptCd;
}
