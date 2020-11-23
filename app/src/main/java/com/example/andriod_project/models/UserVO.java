package com.example.andriod_project.models;

public class UserVO {
    private String userid;
    private String userpw;
    private String username;
    private String usernickname;
    private int userrankpoint;
    private int usersolveproblem;
    private int usercorrectproblem;

    public String getUserid() { return userid; }

    public void setUserid(String userid) { this.userid = userid; }

    public String getUserpw() { return userpw;}

    public void setUserpw(String userpw) { this.userpw = userpw; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getUsernickname() { return usernickname; }

    public void setUsernickname(String usernickname) { this.usernickname = usernickname; }

    public int getUserrankpoint() { return userrankpoint; }

    public void setUserrankpoint(int userrankpoint) { this.userrankpoint = userrankpoint; }

    public int getUsersolveproblem() { return usersolveproblem; }

    public void setUsersolveproblem(int usersolveproblem) { this.usersolveproblem = usersolveproblem; }

    public int getUsercorrectproblem() { return usercorrectproblem; }

    public void setUsercorrectproblem(int usercorrectproblem) { this.usercorrectproblem = usercorrectproblem; }
}
