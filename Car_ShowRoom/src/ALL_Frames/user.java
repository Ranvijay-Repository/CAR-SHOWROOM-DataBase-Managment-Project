/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ALL_Frames;

/**
 *
 * @author ranvi
 */
class user {
    private String SSID,SNAME,SSEX,SPHN,SADR,SIDPT,SIDNO,SSAL;
   private byte[] EIMG;
    public user(String SSID,String SNAME,String SSEX,String SPHN,String SADR,String SIDPT,String SIDNO,String SSAL,byte[] EIMG)
    {
        this.SSID=SSID;
        this.SNAME=SNAME;
        this.SSEX=SSEX;
        this.SPHN=SPHN;
        this.SADR=SADR;
        this.SIDPT=SIDPT;
        this.SIDNO=SIDNO;
        this.SSAL=SSAL;
        this.EIMG=EIMG;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getSNAME() {
        return SNAME;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = SNAME;
    }

    public String getSSEX() {
        return SSEX;
    }

    public void setSSEX(String SSEX) {
        this.SSEX = SSEX;
    }

    public String getSPHN() {
        return SPHN;
    }

    public void setSPHN(String SPHN) {
        this.SPHN = SPHN;
    }

    public String getSADR() {
        return SADR;
    }

    public void setSADR(String SADR) {
        this.SADR = SADR;
    }

    public String getSIDPT() {
        return SIDPT;
    }

    public void setSIDPT(String SIDPT) {
        this.SIDPT = SIDPT;
    }

    public String getSIDNO() {
        return SIDNO;
    }

    public void setSIDNO(String SIDNO) {
        this.SIDNO = SIDNO;
    }

    public String getSSAL() {
        return SSAL;
    }

    public void setSSAL(String SSAL) {
        this.SSAL = SSAL;
    }

    public byte[] getEIMG() {
        return EIMG;
    }

    public void setEIMG(byte[] EIMG) {
        this.EIMG = EIMG;
    }
    
    
    
}
