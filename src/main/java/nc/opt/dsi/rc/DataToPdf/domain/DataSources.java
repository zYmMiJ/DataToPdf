package nc.opt.dsi.rc.DataToPdf.domain;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataSources {

    public static final String FIRSTNAME_1 = "prenom1";
    public static final String FIRSTNAME_2 = "prenom2";
    public static final String DESIGNATION = "designation";
    public static final String NUMERO = "numero";

    public static String getDir() {
        Path resourceDirectory = Paths.get("src","main","resources");
        return resourceDirectory.toAbsolutePath() + "\\pdf\\";
    }
}
