package ALL_Frames;

/**
 *
 * @author ranvi
 */
public class CARbin {
    private int ENO;
    private String CNAME;
    private String CCLR;
    private String CMOD;
    private String CSTS;
    private String CMIL;
    private String CETYPE;
    private Double CPRICE;
   private byte[] CIMAGE;
    public CARbin(int ENO,String CNAME,String CCLR,String CMOD,String CSTS,String CMIL,String CETYPE,Double CPRICE,byte[] CIMAGE){
        this.ENO=ENO;
        this.CNAME=CNAME;
        this.CCLR=CCLR;
        this.CMOD=CMOD;
        this.CSTS=CSTS;       
        this.CMIL=CMIL;
        this.CETYPE=CETYPE;
        this.CPRICE=CPRICE;
        this.CIMAGE=CIMAGE;
    }    

    /*CARbin(int aInt, String string, float parseFloat, String string0, byte[] bytes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    CARbin(int aInt, String string, float parseFloat, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public int getENO() {
        return ENO;
    }

    public void setENO(int ENO) {
        this.ENO = ENO;
    }

    public String getCNAME() {
        return CNAME;
    }

    public void setCNAME(String CNAME) {
        this.CNAME = CNAME;
    }

    public String getCCLR() {
        return CCLR;
    }

    public void setCCLR(String CCLR) {
        this.CCLR = CCLR;
    }

    public String getCMOD() {
        return CMOD;
    }

    public void setCMOD(String CMOD) {
        this.CMOD = CMOD;
    }

    public String getCSTS() {
        return CSTS;
    }

    public void setCSTS(String CSTS) {
        this.CSTS = CSTS;
    }

    public String getCMIL() {
        return CMIL;
    }

    public void setCMIL(String CMIL) {
        this.CMIL = CMIL;
    }

    public String getCETYPE() {
        return CETYPE;
    }

    public void setCETYPE(String CETYPE) {
        this.CETYPE = CETYPE;
    }

    public Double getCPRICE() {
        return CPRICE;
    }

    public void setCPRICE(Double CPRICE) {
        this.CPRICE = CPRICE;
    }

    public byte[] getCIMAGE() {
        return CIMAGE;
    }

    public void setCIMAGE(byte[] CIMAGE) {
        this.CIMAGE = CIMAGE;
    }
    
}
