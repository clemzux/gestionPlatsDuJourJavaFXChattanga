package com.clemzux.chattanga.utilitaries;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * Created by clemzux on 20/11/16.
 */
public class CAppConstants {

    public static ObjectMapper objectMapper = new ObjectMapper();
    public static WebResource webResource;

    static {
        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
//        webResource = c.resource("http://176.157.85.69:9999");
        webResource = c.resource("http://localhost:10000");
    }

    public static final Background appBackGround = new Background(new BackgroundFill(Color.web("#D80000"), CornerRadii.EMPTY, Insets.EMPTY));

    // sizes

    public static final int HOME_WIDTH = 450;
    public static final int HOME_HEIGHT = 400;
    public static final int CONSULT_RESERVATION_WIDTH = 700;
    public static final int CONSULT_RESERVATION_HEIGHT = 700;

    public static final int BUTTON_WIDTH = 180;
    public static final int BUTTON_HEIGHT = 30;
    public static final int QUIT_BUTTON_WIDTH = 110;
    public static final int QUIT_BUTTON_HEIGHT = 30;
    public static final int FIELD_WIDTH = 200;
    public static final int FIELD_HEIGHT = 30;

    // spacings

    public static final int LOGO_SPACING = 70;
    public static final int GENERAL_SPACING = 10;

    // logo

    public static final String APP_LOGO = "logochattanga.png";

    // windows names

    public static final String APP_NAME = "La Chattanga";
    public static final String APP_HOME_NAME = " - Accueil";
    public static final String APP_CONSULT_RESERVATION_NAME = " - Consulter réservations";
    public static final String APP_DAYDISH_MODIFICATION_NAME = " - Modification plat du jour";
    public static final String APP_CONSULT_DAYDISH_NAME = " - Consultation plats du jour";

    // buttons text

    public static final String BACK_BUTTON = "Retour";
    public static final String QUIT_BUTTON = "Quitter";
    public static final String CREATE_DAYDISH_BUTTON = "Créer plat du jour";
    public static final String CONSULT_DAYDISH_BUTTON = "Consulter plats du jour";
    public static final String CONSULT_RESERVATIONS_BUTTON = "Consulter réservations";
    public static final String SEND_IMAGE_TO_SERVER_BUTTON = "Enregistrer une image";

    public static final String MODIFICATION_BUTTON = "Modifier";

    // text text

    public static final String DAYDISH_DETAILS_TEXT = "Détails : ";
    public static final String DATE_TEXT = "Date (jj/mm/aaaa) : ";
    public static final String DAYDISH_TEXT = "Nom du plat : ";
    public static final String IMAGE_IDENTIFIER_TEXT = "Identifiant image : ";
}