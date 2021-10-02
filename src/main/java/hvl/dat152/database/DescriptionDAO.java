package hvl.dat152.database;

import hvl.dat152.model.Description;

import java.util.Arrays;
import java.util.List;

public class DescriptionDAO {

    private final List<Description> descriptionList;

    public DescriptionDAO() {
        descriptionList = Arrays.asList(
                new Description(32, "en", "A white cup"),
                new Description(32, "nn", "Ein kvit kopp"),
                new Description(32, "es", "Una taza blanca"),
                new Description(33, "en", "A black cup"),
                new Description(33, "nn", "Ein svart kopp"),
                new Description(33, "es", "Una taza negra"),
                new Description(21, "en", "For the Doctor Who fan"),
                new Description(21, "nn", "For fans av Doctor Who"),
                new Description(21, "es", "Para el fan de Doctor Who"),
                new Description(65, "en", "An elegant cup"),
                new Description(65, "nn", "En elegant kopp"),
                new Description(65, "es", "Una taza elegante")
        );
    }

    public String getDescription(int pid, String langCode) {
        Description description = descriptionList.stream().filter(desc -> desc.getPid() == pid && desc.getLangCode().equals(langCode)).findAny().orElse(null);

        if (description == null) {
            return "-1";
        }
        return description.getText();
    }

    public List<Description> getDescriptionList() {
        return descriptionList;
    }

}
