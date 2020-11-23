package com.example.andriod_project.models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RemoteService {
    public static final String BASE_URL="http://192.168.1.9:8080/quizApp/";

    @POST("insertUser.jsp")
    Call<Void> insertUser(@Query("userid") String userid, @Query("userpw") String userpw, @Query("username") String username, @Query("usernickname") String usernickname,
                            @Query("userrankpoint") int userrankpoint, @Query("usersolveproblem") int usersolveproblem, @Query("usercorrectproblem") int usercorrectproblem);

    @GET("loginUser.jsp")
    Call<UserVO> loginUser(@Query("userid") String userid);

}