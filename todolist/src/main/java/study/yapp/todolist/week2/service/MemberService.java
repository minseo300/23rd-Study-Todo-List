package study.yapp.todolist.week2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.yapp.todolist.common.ResponseCode;
import study.yapp.todolist.dto.MemberDto;
import study.yapp.todolist.exception.DuplicateUserException;
import study.yapp.todolist.exception.InvalidUserException;
import study.yapp.todolist.week2.dao.Member;
import study.yapp.todolist.week2.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDto.ResponseMemberDto signUp(MemberDto.RequestSignUpDto request) {
        Optional<Member> existMember = memberRepository.findByEmail(request.getEmail());
        if (existMember.isPresent()) {
            throw new DuplicateUserException("이미 존재하는 유저입니다.", ResponseCode.DUPLICATE_USER);
        }

        Member member = Member.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .build();

        memberRepository.save(member);

        MemberDto.ResponseMemberDto result = MemberDto.ResponseMemberDto.builder()
                .memberId(member.getId())
                .build();

        return result;
    }

    public MemberDto.ResponseMemberDto signIn(MemberDto.RequestSignInDto request) {
        Member member = memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()).orElseThrow(() -> new InvalidUserException("존재하지 않는 유저입니다.",
                                                                                                                                                        ResponseCode.INVALID_USER));


        MemberDto.ResponseMemberDto result = MemberDto.ResponseMemberDto.builder()
                .memberId(member.getId())
                .build();

        return result;
    }
}