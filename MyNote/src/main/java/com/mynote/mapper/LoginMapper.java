package com.mynote.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mynote.model.LoginModel;

@Mapper
public interface LoginMapper {
	LoginModel findByAccount(String account);
}
