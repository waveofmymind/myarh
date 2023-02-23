package wave.myarh.global.auth;

import wave.myarh.domain.member.domain.Member;

public class MemberContext {

    public static ThreadLocal<Member> currentMember = new ThreadLocal<>();
}
