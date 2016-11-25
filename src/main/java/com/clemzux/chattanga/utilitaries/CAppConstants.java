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

import java.awt.*;

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

    private static Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_HEIGHT = (int)dimension.getHeight();
    public static final int SCREEN_WIDTH  = (int)dimension.getWidth();

    public static final int HOME_WIDTH = (int) (SCREEN_WIDTH * 0.3);
    public static final int HOME_HEIGHT = (int) (SCREEN_HEIGHT * 0.5);
    public static final int CONSULT_DAYDISH_WIDTH = (int) (SCREEN_WIDTH * 0.5);
    public static final int CONSULT_DAYDISH_HEIGHT = (int) (SCREEN_HEIGHT * 0.8);
    public static final int CREATE_DAYDISH_WIDTH = (int) (SCREEN_WIDTH * 0.5);
    public static final int CREATE_DAYDISH_HEIGHT = (int) (SCREEN_HEIGHT * 0.5);
    public static final int CONSULT_RESERVATION_WIDTH = (int) (SCREEN_WIDTH * 0.5);
    public static final int CONSULT_RESERVATION_HEIGHT = (int) (SCREEN_HEIGHT * 0.7);

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
    public static final String APP_CONSULT_DAYDISH_NAME = " - Consultation/modification plats du jour";
    public static final String APP_CREATE_DAYDISH_NAME = " - Créer plat du jour";

    // buttons text

    public static final String BACK_BUTTON = "Retour";
    public static final String QUIT_BUTTON = "Quitter";
    public static final String CREATE_DAYDISH_BUTTON = "Créer plat du jour";
    public static final String CONSULT_DAYDISH_BUTTON = "Consulter plats du jour";
    public static final String CONSULT_RESERVATIONS_BUTTON = "Consulter réservations";
    public static final String SEND_IMAGE_TO_SERVER_BUTTON = "Enregistrer une image";
    public static final String MODIFICATION_BUTTON = "Modifier";

    // text

    // consulter plats du jour
    public static final String DAYDISH_DETAILS_TEXT = "Détails : ";
    public static final String DATE_TEXT = "Date (jj/mm/aaaa) : ";
    public static final String DAYDISH_TEXT = "Nom du plat : ";
    public static final String IMAGE_IDENTIFIER_TEXT = "Identifiant image : ";

    // consulter reservations
    public static final String CONSULT_RESERVATIONS_FORM_NAME = "Détails réservation";
    public static final String CONSULT_RESERVATIONS_NAME = "Nom : ";
    public static final String CONSULT_RESERVATIONS_TEL = "Tel : ";
    public static final String CONSULT_RESERVATIONS_NB_PEOPLE = "Nombre personnes : ";
    public static final String CONSULT_RESERVATIONS_NB_DAYDISH = "Nombre plats du jour : ";
    public static final String CONSULT_RESERVATIONS_HOUR_ARRIVE = "Heure d'arrivée : ";
    public static final String CONSULT_RESERVATIONS_NOTE = "Remarque : ";

    // créer plat du jour
    public static final String CREATE_DAYDISH_FORM_NAME = "Nouveau plat du jour";
    public static final String CREATE_DAYDISH_DATE = "Date : ";
    public static final String CREATE_DAYDISH_NAME = "Nom du plat : ";
    public static final String CREATE_DAYDISH_IMAGE_IDENTIFIER = "Identifiant de l'image : ";
}