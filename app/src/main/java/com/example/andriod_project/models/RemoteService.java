package com.example.andriod_project.models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RemoteService {
    public static final String BASE_URL="http://1.247.180.181:8080/quizApp/";

    @POST("insertUser.jsp")
    Call<Void> insertUser(@Query("userid") String userid, @Query("userpw") String userpw, @Query("username") String username, @Query("usernickname") String usernickname,
                            @Query("userrankpoint") int userrankpoint, @Query("usersolveproblem") int usersolveproblem, @Query("usercorrectproblem") int usercorrectproblem,
                            @Query("userstorymodelevel") String userstorymodelevel, @Query("userstorymodestage") int userstorymodestage);

    @GET("loginUser.jsp")
    Call<UserVO> loginUser(@Query("userid") String userid);

    @GET("ranking.jsp")
    Call<List<RankingVO>> ranking();

    @GET("storymodequestion.jsp")
    Call<QuestionVO> storymodequestion(@Query("questioncategory") String questioncategory, @Query("questionid") int questionid);

    @GET("storymodesave.jsp")
    Call<UserVO> readSaveData(@Query("userid") String userid);

}