package com.openmarket.entity;

import com.openmarket.constant.Role;
import com.openmarket.dto.MemberFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final String name;
    @Column(unique = true)
    private final String email;
    private final String password;
    private final String address;
    @Enumerated(EnumType.STRING)
    private final Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        Member member = new Member(memberFormDto.getName(),
                            memberFormDto.getEmail(),
                            password,
                            memberFormDto.getAddress(),
                            Role.USER);

        return member;
    }

    public static Member createAdmin(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        Member member = new Member(memberFormDto.getName(),
                            memberFormDto.getEmail(),
                            password,
                            memberFormDto.getAddress(),
                            Role.ADMIN);

        return member;
    }
}
