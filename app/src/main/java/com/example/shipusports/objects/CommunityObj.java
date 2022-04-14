package com.example.shipusports.objects;

public class CommunityObj {

    private String Cname;
    private int Cid;
    private int ImgId;

    public CommunityObj(String cname, int cid, int imgId) {
        Cname = cname;
        Cid = cid;
        ImgId = imgId;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }
}
