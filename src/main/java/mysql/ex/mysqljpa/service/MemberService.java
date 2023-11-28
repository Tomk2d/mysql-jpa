package mysql.ex.mysqljpa.service;

import mysql.ex.mysqljpa.controller.ErrorMessage;
import mysql.ex.mysqljpa.controller.LoginFailureException;
import mysql.ex.mysqljpa.domain.Member;
import mysql.ex.mysqljpa.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        long start = System.currentTimeMillis();
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByEmail(member.getEmail());
        result.ifPresent(m -> {
            throw new ErrorMessage("이미 존재하는 회원입니다.");
        });
    }

    public Long login(Member member){
        return memberRepository.findByEmail(member.getEmail())
                .filter(m -> m.getPassword().equals(member.getPassword()))
                .orElseThrow(() -> new LoginFailureException("로그인 정보를 확인해주세요"))
                .getId();
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
