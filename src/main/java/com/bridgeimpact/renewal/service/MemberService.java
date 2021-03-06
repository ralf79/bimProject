package com.bridgeimpact.renewal.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.bridgeimpact.renewal.dto.EmailAuthVO;
import com.bridgeimpact.renewal.dto.MemberVO;

public interface MemberService {
    
    public List<MemberVO> selectAllMember() throws Exception;

	public int insertMember(MemberVO member) throws Exception;

	public void editMember(HttpSession session,MemberVO inputMember) throws Exception;

	public void deleteMember(MemberVO member) throws Exception;

	public int loginMember(MemberVO member) throws Exception;

	public Map<String, String> checkMemberById(String id) throws Exception;

	public MemberVO getMemberById(String id) throws Exception;

	public boolean checkDeleteMemberByPassword(MemberVO sessionMember, String password) throws Exception;

	public Map<String, String> checkMemberEmail(String email) throws Exception;

	public boolean findAccountId(MemberVO member) throws Exception;

	public Map<String, String> findAccountPassword(MemberVO member) throws Exception;

	boolean ChangePasswordByTokenKey(EmailAuthVO emailAuthVO) throws Exception;
}


