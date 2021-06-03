package nc.opt.dsi.rc.DataToPdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static nc.opt.dsi.rc.DataToPdf.domain.DataSources.*;
import static nc.opt.dsi.rc.DataToPdf.domain.DataSources.getDir;

@SpringBootApplication
public class AppMain {

	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);

		try {
			PdfReader reader = new PdfReader(getDir() + "template.pdf");
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(getDir() + "output.pdf"));

			AcroFields form = stamper.getAcroFields();
			form.setField(NUMERO, "005");
			form.setField(FIRSTNAME_1, "JAVA");
			form.setField(FIRSTNAME_2, "DONE");
			form.setField(DESIGNATION, "Lui"); // Champs de la page 2 (tester sur un autre fichier à plusieurs pages OK)
			form.setField("CheckBox_1", "Oui"); // Usual checkbox or YES depend on default lang
			form.setField("Group1", "Choice3"); // Group1 = le groupe des options, Choise l'otions à cocher
			String[] statesCheckBox = form.getAppearanceStates("CheckBox_1");
			Arrays.stream(statesCheckBox).forEach( s-> {
				System.out.println(s);
			});
			String[] statesOptions = form.getAppearanceStates("Group1");
			Arrays.stream(statesOptions).forEach( s-> {
				System.out.println(s);
			});

			stamper.close();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
