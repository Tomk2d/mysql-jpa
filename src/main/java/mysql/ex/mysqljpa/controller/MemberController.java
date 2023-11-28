package mysql.ex.mysqljpa.controller;

import lombok.RequiredArgsConstructor;
import mysql.ex.mysqljpa.domain.Member;
import mysql.ex.mysqljpa.repository.MemberRepository;
import mysql.ex.mysqljpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/new")
    public String createForm(){
        return "member/createMember";
    }

    @PostMapping("/member/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setId(form.getId());
        member.setNickname(form.getNickname());
        member.setPassword(form.getPassword());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/member")      // 여기서 받는 member 는 전체 멤버 뽑는거라서 "members" 로 했음
    public String list(Model model){    //모델에 있는걸 직접 받을거임.
        List<Member> members = memberService.findMembers(); //리스트 형식으로 memberService에 구현해둔 findMembers 함수를 통해서 리스트를 받는다.
        model.addAttribute("members", members); //모델에 members(리스트)를 넘겨준다.
        return "member/memberList";    // 이후 members/memberList 페이지를 반환한다.
    }


    @PostMapping("/member/login")
    public String login(MemberForm form, Model model, RedirectAttributes redirectAttributes) {
        try {
            Member member = new Member();
            member.setEmail(form.getEmail());
            member.setPassword(form.getPassword());

            memberService.login(member);

            // 로그인 성공 시, 홈페이지나 대시보드 등으로 리디렉션
            return "member/createMember";
        } catch (LoginFailureException e) {
            // 로그인 실패 시, 오류 메시지를 설정하고 로그인 페이지로 다시 이동
            model.addAttribute("loginError", "로그인 정보를 확인해주세요");
            return "";
        }
    }

}
