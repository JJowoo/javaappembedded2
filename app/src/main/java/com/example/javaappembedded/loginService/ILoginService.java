package com.example.javaappembedded.loginService;

import com.example.javaappembedded.vo.MemberVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ILoginService {

    @GET("app/getMember.do")
    Call<MemberVO> getMember(@Query("mem_id") String mem_id, @Query("mem_pw") String mem_pw);
}
