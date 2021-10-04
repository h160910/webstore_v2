package hvl.dat152.utils;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CopyrightTag extends SimpleTagSupport {

    private int copyrightSince;
    private static final String CURRENT_YEAR = "MMXXI"; // 2021 in roman numerals

    public void setCopyrightSince(int copyrightSince) {
        this.copyrightSince = copyrightSince;
    }

    @Override
    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();

        String romanNumeral = RomanNumeralConverter.integerToRoman(copyrightSince);

        out.print("&copy; " + romanNumeral + " - " + CURRENT_YEAR + " Høgskulen på Vestlandet");
    }

}
