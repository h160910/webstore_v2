package hvl.dat152.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class ShortTextTag extends SimpleTagSupport {

    private int maxchars;

    public void setMaxchars(int maxchars) {
        this.maxchars = maxchars;
    }

    @Override
    public void doTag() throws IOException, JspException {
        JspWriter out = getJspContext().getOut();

        StringWriter stringWriter = new StringWriter();

        JspFragment body = getJspBody();
        body.invoke(stringWriter);

        String bodyText = stringWriter.getBuffer().toString().trim();
        out.print(bodyText.substring(0, maxchars) + " ...");
    }

}
