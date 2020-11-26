package com.example.andriod_project.models;

public class QuestionVO {
    private int questionid;
    private String content;
    private String selection1;
    private String selection2;
    private String selection3;
    private String selection4;
    private String exsummary;
    private String exdetail;
    private int answer;

    public int getQuestionid() { return questionid; }

    public void setQuestionid(int questionid) { this.questionid = questionid; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getSelection1() { return selection1; }

    public void setSelection1(String selection1) { this.selection1 = selection1; }

    public String getSelection2() { return selection2; }

    public void setSelection2(String selection2) { this.selection2 = selection2; }

    public String getSelection3() { return selection3; }

    public void setSelection3(String selection3) { this.selection3 = selection3; }

    public String getSelection4() { return selection4; }

    public void setSelection4(String selection4) { this.selection4 = selection4; }

    public String getExsummary() { return exsummary; }

    public void setExsummary(String exsummary) { this.exsummary = exsummary; }

    public String getExdetail() { return exdetail; }

    public void setExdetail(String exdetail) { this.exdetail = exdetail; }

    public int getAnswer() { return answer; }

    public void setAnswer(int answer) { this.answer = answer; }
}
