package com.example.andriod_project;

public class UserVO {
    private String userId;
    private String userPw;
    private String userName;
    private String userNickname;
    private int userRankPoint;
    private int userSolveProblem;
    private int userCorrectProblem;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserPw() { return userPw; }

    public void setUserPw(String userPw) { this.userPw = userPw; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserNickname() { return userNickname; }

    public void setUserNickname(String userNickname) { this.userNickname = userNickname; }

    public int getUserRankPoint() { return userRankPoint; }

    public void setUserRankPoint(int userRankPoint) { this.userRankPoint = userRankPoint; }

    public int getUserSolveProblem() { return userSolveProblem; }

    public void setUserSolveProblem(int userSolveProblem) { this.userSolveProblem = userSolveProblem; }

    public int getUserCorrectProblem() { return userCorrectProblem; }

    public void setUserCorrectProblem(int userCorrectProblem) { this.userCorrectProblem = userCorrectProblem; }
}
