package com.bridgeimpact.renewal.dao;

import com.bridgeimpact.renewal.dto.EmailAuthVO;

public interface EmailAuthDAO {

	public int insertEmailAuth(EmailAuthVO emailAuth) throws Exception;

}
