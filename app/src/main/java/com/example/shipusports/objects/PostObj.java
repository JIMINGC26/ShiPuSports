package com.example.shipusports.objects;

public class PostObj {

    private int Pid;
    private String title;
    private String content;

    public PostObj(int pid, String title, String content){
        Pid = pid;
        this.title = title;
        this.content = content;
    }

    public int getPid() {
        return Pid;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
