package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:webdriver.base.url")
public class PaginaCargaArchivo extends PageObject {

    public static final Target BTN_UPLOAD = Target
            .the("Boton Upload").locatedBy("//input[@id='file-submit']");
}
