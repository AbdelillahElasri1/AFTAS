package com.elasri.aftas.Member;

import java.util.List;

public interface MemberService {
    MemberRequest saveMember(MemberRequest memberRequest);
    MemberRequest updateMember(MemberRequest memberRequest);
    List<MemberResponse> getAllMembers();
    MemberResponse getMember(Integer num);
    void deleteMember(Integer num);
}
