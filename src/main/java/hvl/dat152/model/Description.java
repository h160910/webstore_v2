package hvl.dat152.model;

public class Description {

    private int pid;
    private String langCode;
    private String text;

    public Description(int pid, String langCode, String text) {
        this.pid = pid;
        this.langCode = langCode;
        this.text = text;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
