/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author lassiazt
 */
public class Voyage extends Application {
    
    private TableView table = new TableView();
    
    
    @Override
    public void start(Stage primaryStage) {
        
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn ColidVoyage = new TableColumn("ID Voyage");
        TableColumn ColDescVoyage = new TableColumn("Description");
        TableColumn ColDureeVoyage = new TableColumn("Durée");
        TableColumn ColPrixVoyage = new TableColumn("Prix");
        TableColumn ColTypeVoyage = new TableColumn("Type voyage");
        TableColumn ColDiffVoyage = new TableColumn("Difficulté");
        TableColumn ColNbPersMaxVoyage = new TableColumn("Capacité max");
        
        ColidVoyage.setCellValueFactory(
                new PropertyValueFactory<VoyageClass, String>("idvoyage"));
        ColDescVoyage.setCellValueFactory(
                new PropertyValueFactory<VoyageClass, String>("description"));
        ColDureeVoyage.setCellValueFactory(
                new PropertyValueFactory<VoyageClass, String>("duree"));
        ColPrixVoyage.setCellValueFactory(
                new PropertyValueFactory<VoyageClass, String>("prixvoyage"));
        ColTypeVoyage.setCellValueFactory(
                new PropertyValueFactory<VoyageClass, String>("typevoyage"));
        ColDiffVoyage.setCellValueFactory(
                new PropertyValueFactory<VoyageClass, String>("difficulte"));
        ColNbPersMaxVoyage.setCellValueFactory(
                new PropertyValueFactory<VoyageClass, String>("nbpersmax"));

        table.getColumns().addAll(ColidVoyage, ColDescVoyage, ColDureeVoyage, ColPrixVoyage, ColTypeVoyage, ColDiffVoyage, ColNbPersMaxVoyage);
        
        //Formulaire
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        ///
        
        // Labels
        Text scenetitle = new Text("Bienvenue");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Numéro client : ");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Mot de passe :");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button btnlog = new Button("Connexion");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnlog);
        grid.add(hbBtn, 1, 4);
    
        Scene scene = new Scene(grid, 800, 650);
        
        primaryStage.setTitle("Mon agence");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        // ACTION DU BOUTON //
        btnlog.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {

            // TEST DE CONNEXION -- PAS IMPLEMENTE //
            
            /*
            Connexionsgbd conn = new Connexionsgbd();
            conn.Connect();
            */
            
            //
            
            Button btnClient = new Button("Interface client");
            Button btnAdmin = new Button("Interface admin");
            btnClient.setMinSize(250, 180);
            btnAdmin.setMinSize(250, 180);
            Button BtnDecoAccueil = new Button("Deconnexion");
            Label NomAgenceGeneral = new Label("Agence de voyage");
            NomAgenceGeneral.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
            btnClient.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
            btnAdmin.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
                  
            StackPane btnDecoStack = new StackPane();
            btnDecoStack.getChildren().add(BtnDecoAccueil);
            btnDecoStack.setAlignment(Pos.CENTER_RIGHT);
            
            BorderPane borderpaneaccueil = new BorderPane();
            
            HBox topmenugeneral = new HBox();
            topmenugeneral.setPadding(new Insets(15, 12, 15, 12));
            topmenugeneral.setSpacing(10);
            topmenugeneral.setStyle("-fx-background-color: #FAB81E;");
            topmenugeneral.getChildren().addAll(NomAgenceGeneral, btnDecoStack);
            HBox.setHgrow(btnDecoStack, Priority.ALWAYS);

            HBox midmenugeneral = new HBox();
            midmenugeneral.setPadding(new Insets(15, 12, 15, 12));
            midmenugeneral.setSpacing(10);
            midmenugeneral.setStyle("-fx-background-color: #14171A;");
            midmenugeneral.getChildren().addAll(btnClient,btnAdmin);
            midmenugeneral.setAlignment(Pos.CENTER);
            
            borderpaneaccueil.setCenter(midmenugeneral);
            borderpaneaccueil.setTop(topmenugeneral);
            Scene Accueilgeneral = new Scene(borderpaneaccueil, 800, 650);
            
            primaryStage.setTitle("Mon compte");
            primaryStage.setScene(Accueilgeneral);
            primaryStage.show();
            
            BtnDecoAccueil.setOnAction(Client -> {
                primaryStage.setScene(scene);
            });
            
            // interface Client
            btnClient.setOnAction(Client -> {
                Button btnAjout = new Button("Réserver un voyage");
                Button btnConsult = new Button("Consulter les voyages");
                btnAjout.setMinSize(250, 180);
                btnConsult.setMinSize(250, 180);
                Button Btndeco = new Button("Deconnexion");
                Label NomAgence = new Label("Agence de voyage");
                NomAgence.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
                btnAjout.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
                btnConsult.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

                StackPane btnDeco = new StackPane();
                btnDeco.getChildren().add(Btndeco);
                btnDeco.setAlignment(Pos.CENTER_RIGHT);

                BorderPane border = new BorderPane();

                HBox topmenu = new HBox();
                topmenu.setPadding(new Insets(15, 12, 15, 12));
                topmenu.setSpacing(10);
                topmenu.setStyle("-fx-background-color: #FAB81E;");
                topmenu.getChildren().addAll(NomAgence, btnDeco);
                HBox.setHgrow(btnDeco, Priority.ALWAYS);

                HBox midmenu = new HBox();
                midmenu.setPadding(new Insets(15, 12, 15, 12));
                midmenu.setSpacing(10);
                midmenu.setStyle("-fx-background-color: #14171A;");
                midmenu.getChildren().addAll(btnAjout,btnConsult);
                midmenu.setAlignment(Pos.CENTER);

                border.setCenter(midmenu);
                border.setTop(topmenu);
                Scene Accueilclient = new Scene(border, 800, 650);

                primaryStage.setTitle("Mon compte");
                primaryStage.setScene(Accueilclient);
                primaryStage.show();

            
                Btndeco.setOnAction(event -> {
                    primaryStage.setScene(scene);                       
                });

                btnAjout.setOnAction(Add -> {
               
                    GridPane gridajout = new GridPane();
                    gridajout.setAlignment(Pos.CENTER);
                    gridajout.setHgap(10);
                    gridajout.setVgap(10);
                    gridajout.setPadding(new Insets(25, 25, 25, 25));

                    Label NomAgenceAjout = new Label("Agence de voyage");
                    NomAgenceAjout.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
                    Button retour = new Button("Retour");
                    StackPane btnRetour = new StackPane();
                    btnRetour.getChildren().add(retour);
                    btnRetour.setAlignment(Pos.CENTER_RIGHT);

                    BorderPane borderTop = new BorderPane();

                    HBox topmenuAdd = new HBox();
                    topmenuAdd.setPadding(new Insets(15, 12, 15, 12));
                    topmenuAdd.setSpacing(10);
                    topmenuAdd.setStyle("-fx-background-color: #FAB81E;");
                    topmenuAdd.getChildren().addAll(NomAgenceAjout, btnRetour);
                    HBox.setHgrow(btnRetour, Priority.ALWAYS);
                
                
                    Text scenetitleAdd = new Text("Réserver un voyage");
                    scenetitleAdd.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                    gridajout.add(scenetitleAdd, 0, 0, 2, 1);
                    Label NomReserv = new Label("Nom :");
                    gridajout.add(NomReserv, 0, 1);
                    TextField nom = new TextField();
                    gridajout.add(nom, 1, 1);
                    Label Prenom = new Label("Prénom :");
                    gridajout.add(Prenom, 0, 2);
                    TextField prenom = new TextField();
                    gridajout.add(prenom, 1, 2);

                    Label NbAdultes = new Label("Nombre d'adultes :");
                    gridajout.add(NbAdultes, 0, 3);
                    TextField nbadultes = new TextField();
                    gridajout.add(nbadultes, 1, 3);
                    Label NbEnfants = new Label("Dont enfants : ");
                    gridajout.add(NbEnfants, 0, 4);
                    TextField nbenfants = new TextField();
                    gridajout.add(nbenfants, 1, 4);

                    Button submit = new Button("Reserver");
                    HBox hbBtn = new HBox(10);
                    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
                    hbBtn.getChildren().add(submit);
                    gridajout.add(submit, 1, 6);

                    ObservableList<String> ListVoyages = 
                    FXCollections.observableArrayList(
                        "Le tour du monde en 40 jours",
                        "Taversée du desert du Sahara",
                        "Expédition en Mongolie"
                    );
                    final ComboBox comboBox = new ComboBox(ListVoyages);
                    comboBox.setValue("Choisissez un voyage");
                    gridajout.add(comboBox, 1,5);

                    borderTop.setCenter(gridajout);
                    borderTop.setTop(topmenuAdd);

                    Scene AddVoyage = new Scene(borderTop, 800, 650);
                    primaryStage.setScene(AddVoyage);
                    primaryStage.show();

                
                    retour.setOnAction(event -> {
                        primaryStage.setScene(Accueilclient);                       
                    });    
            });
            
                btnConsult.setOnAction(Consult -> { 

                    Connexionsgbd connfill = new Connexionsgbd();
                    connfill.FillTableView(table);
                    
                    final Label LabelConsult = new Label("Mes voyages");
                    LabelConsult.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

                    final VBox vboxConsult = new VBox();
                    vboxConsult.setSpacing(5);
                    vboxConsult.setPadding(new Insets(15, 15, 15, 15));
                    vboxConsult.getChildren().addAll(LabelConsult, table);

                    Label NomAgenceConsult = new Label("Agence de voyage");
                    NomAgenceConsult.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
                    Button retourConsult = new Button("Retour");
                    StackPane btnRetourConsult = new StackPane();
                    btnRetourConsult.getChildren().add(retourConsult);
                    btnRetourConsult.setAlignment(Pos.CENTER_RIGHT);

                    BorderPane borderTopConsult = new BorderPane();
            
                    HBox topmenuConsult = new HBox();
                    topmenuConsult.setPadding(new Insets(15, 12, 15, 12));
                    topmenuConsult.setSpacing(10);
                    topmenuConsult.setStyle("-fx-background-color: #FAB81E;");
                    topmenuConsult.getChildren().addAll(NomAgenceConsult, btnRetourConsult);
                    HBox.setHgrow(btnRetourConsult, Priority.ALWAYS);

                    borderTopConsult.setTop(topmenuConsult);
                    borderTopConsult.setCenter(vboxConsult);

                    Scene ShowVoyage = new Scene(borderTopConsult, 800, 650);
                    primaryStage.setScene(ShowVoyage);
                    primaryStage.show();

                    retourConsult.setOnAction(Back -> { 
                        primaryStage.setScene(Accueilclient);
                    });
            
                });
            });
            
            // Interface admin
            btnAdmin.setOnAction(Client -> { 
                
                Button btnCreer = new Button("Créer un voyage");
                Button btnConsultAdmin = new Button("Consulter tous les voyages");
                Button btnProgVoyage = new Button("Programmer un voyage");
                Button btnDecoAdmin = new Button("Deconnexion");
                
                btnCreer.setMinSize(190, 130);
                btnCreer.setMaxSize(190, 130);
                btnConsultAdmin.setMinSize(190, 130);
                btnConsultAdmin.setMaxSize(190, 130);
                btnProgVoyage.setMinSize(190,130);
                btnProgVoyage.setMaxSize(190, 130);
                Button Btndeco = new Button("Deconnexion");
                
                Label NomAgence = new Label("Agence de voyage");
                NomAgence.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

                Label NomAgenceAdmin = new Label("Agence de voyage");
                NomAgenceAdmin.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
                btnCreer.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
                btnConsultAdmin.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
                btnProgVoyage.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));

                StackPane btnDecoadmin = new StackPane();
                btnDecoadmin.getChildren().add(btnDecoAdmin);
                btnDecoadmin.setAlignment(Pos.CENTER_RIGHT);

                BorderPane borderAdmin = new BorderPane();

                HBox topmenuAdmin = new HBox();
                topmenuAdmin.setPadding(new Insets(15, 12, 15, 12));
                topmenuAdmin.setSpacing(10);
                topmenuAdmin.setStyle("-fx-background-color: #FAB81E;");
                topmenuAdmin.getChildren().addAll(NomAgenceAdmin, btnDecoadmin);
                HBox.setHgrow(btnDecoadmin, Priority.ALWAYS);

                HBox midmenuAdmin = new HBox();
                midmenuAdmin.setPadding(new Insets(15, 12, 15, 12));
                midmenuAdmin.setSpacing(10);
                midmenuAdmin.setStyle("-fx-background-color: #14171A;");
                midmenuAdmin.getChildren().addAll(btnCreer, btnProgVoyage, btnConsultAdmin);
                midmenuAdmin.setAlignment(Pos.CENTER);

                borderAdmin.setCenter(midmenuAdmin);
                borderAdmin.setTop(topmenuAdmin);
                Scene AccueilAdmin = new Scene(borderAdmin, 800, 650);

                primaryStage.setTitle("Mon compte");
                primaryStage.setScene(AccueilAdmin);
                primaryStage.show();
                
                btnDecoAdmin.setOnAction(Back -> { 
                    primaryStage.setScene(scene);
                });
                
                btnConsultAdmin.setOnAction(ConsultAdmin -> { 
                    Connexionsgbd connfillAdmin = new Connexionsgbd();
                    connfillAdmin.FillTableView(table);
                    
                    final Label LabelConsultAdmin = new Label("Voyages");
                    LabelConsultAdmin.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

                    final VBox vboxConsultAdmin = new VBox();
                    vboxConsultAdmin.setSpacing(5);
                    vboxConsultAdmin.setPadding(new Insets(15, 15, 15, 15));
                    vboxConsultAdmin.getChildren().addAll(LabelConsultAdmin, table);

                    Label NomAgenceConsultAdmin = new Label("Agence de voyage");
                    NomAgenceConsultAdmin.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
                    Button retourConsultAdmin = new Button("Retour");
                    StackPane btnRetourConsultAdmin = new StackPane();
                    btnRetourConsultAdmin.getChildren().add(retourConsultAdmin);
                    btnRetourConsultAdmin.setAlignment(Pos.CENTER_RIGHT);

                    BorderPane borderTopConsult = new BorderPane();
            
                    HBox topmenuConsultAdmin = new HBox();
                    topmenuConsultAdmin.setPadding(new Insets(15, 12, 15, 12));
                    topmenuConsultAdmin.setSpacing(10);
                    topmenuConsultAdmin.setStyle("-fx-background-color: #FAB81E;");
                    topmenuConsultAdmin.getChildren().addAll(NomAgenceConsultAdmin, btnRetourConsultAdmin);
                    HBox.setHgrow(btnRetourConsultAdmin, Priority.ALWAYS);

                    borderTopConsult.setTop(topmenuConsultAdmin);
                    borderTopConsult.setCenter(vboxConsultAdmin);

                    Scene ShowVoyage = new Scene(borderTopConsult, 800, 650);
                    primaryStage.setScene(ShowVoyage);
                    primaryStage.show();

                    retourConsultAdmin.setOnAction(Back -> { 
                        primaryStage.setScene(AccueilAdmin);
                    });
                });
                
                btnCreer.setOnAction(Create -> {
                    //Formulaire
                    GridPane gridAjout = new GridPane();
                    gridAjout.setAlignment(Pos.CENTER);
                    gridAjout.setHgap(25);
                    gridAjout.setVgap(25);
                    gridAjout.setPadding(new Insets(25, 25, 25, 25));
                    ///

                    // Labels
                    Text sceneTitleAjout = new Text("Ajouter un voyage");
                    sceneTitleAjout.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                    gridAjout.add(sceneTitleAjout, 0, 0, 2, 1);

                    final ToggleGroup group = new ToggleGroup();
                    final ToggleGroup group2 = new ToggleGroup();
                    final ToggleGroup group3 = new ToggleGroup();
                    
                    RadioButton TypeVoyagTraversee = new RadioButton();
                    // WARNING TRAVERSE SANS E sur la fin
                    TypeVoyagTraversee.setText("Traversee");
                    TypeVoyagTraversee.setToggleGroup(group);
                    gridAjout.add(TypeVoyagTraversee, 0, 1);
                    
                    RadioButton TypeVoyagCircuit = new RadioButton();
                    TypeVoyagCircuit.setText("Circuit");
                    TypeVoyagCircuit.setToggleGroup(group);
                    gridAjout.add(TypeVoyagCircuit, 1, 1);
                    
                    RadioButton TypeVoyageIndependant = new RadioButton();
                    TypeVoyageIndependant.setText("Independant");
                    TypeVoyageIndependant.setToggleGroup(group2);
                    gridAjout.add(TypeVoyageIndependant, 0, 2);
                    
                    RadioButton TypeVoyageGroupe = new RadioButton();
                    TypeVoyageGroupe.setText("Groupe");
                    TypeVoyageGroupe.setToggleGroup(group2);
                    gridAjout.add(TypeVoyageGroupe, 1, 2);
                    
                    RadioButton FormuleVoyageAdulte = new RadioButton();
                    FormuleVoyageAdulte.setText("Adulte");
                    FormuleVoyageAdulte.setToggleGroup(group3);
                    gridAjout.add(FormuleVoyageAdulte, 0, 3);
                    
                    RadioButton FormuleVoyageFamille = new RadioButton();
                    FormuleVoyageFamille.setText("Famille");
                    FormuleVoyageFamille.setToggleGroup(group3);
                    gridAjout.add(FormuleVoyageFamille, 1, 3);
                    

                    Label TitreVoyage = new Label("Titre du voyage");
                    gridAjout.add(TitreVoyage, 0, 4);
                    TextField InputTitreVoyage = new TextField();
                    gridAjout.add(InputTitreVoyage, 1, 4);
                  
                    Label DifficulteVoyage = new Label("Difficulte du voyage");
                    gridAjout.add(DifficulteVoyage, 0, 5);
                    ObservableList<String> ListeDifficulte = 
                    FXCollections.observableArrayList("1","2","3","4","5");
                    final ComboBox CBListDifficulte = new ComboBox(ListeDifficulte);
                    CBListDifficulte.setValue("Choisissez une difficulte");
                    gridAjout.add(CBListDifficulte, 1,5);

                    Label NbPersonneMin = new Label("Nombre de personnes minimum");
                    gridAjout.add(NbPersonneMin, 0, 6);
                    TextField InputNbPersonneMinVoyage = new TextField();
                    gridAjout.add(InputNbPersonneMinVoyage, 1, 6);
                    
                    Label NbPersonneMax = new Label("Nombre de personnes maximum");
                    gridAjout.add(NbPersonneMax, 0, 7);
                    TextField InputNbPersonneMaxVoyage = new TextField();
                    gridAjout.add(InputNbPersonneMaxVoyage, 1, 7);
                    
                    Label DuréeVoyage = new Label("Durée du voyage");
                    gridAjout.add(DuréeVoyage, 0, 8);
                    TextField InputDureeVoyage = new TextField();
                    gridAjout.add(InputDureeVoyage, 1, 8);
                    
                    
                    
                    Label VilleDep = new Label("Ville de départ");
                    gridAjout.add(VilleDep, 0, 9);
                    
                    
                    ArrayList<Pair> ListeArrayVilleDepA = new ArrayList();
                    Connexionsgbd connFillCity = new Connexionsgbd();
                    connFillCity.FillCity(ListeArrayVilleDepA);
                    
                    ObservableList<String> ListeVilleDep = 
                    FXCollections.observableArrayList();
                    ObservableList<String> ListeVilleArriv = 
                    FXCollections.observableArrayList();
                    
                    for (Pair p : ListeArrayVilleDepA) {
                        ListeVilleDep.add(p.getString());
                        ListeVilleArriv.add(p.getString());
                    }
 
                    
                    final ComboBox CBListVilleDep = new ComboBox(ListeVilleDep);
                    CBListVilleDep.setValue("Choisissez une ville");
                    gridAjout.add(CBListVilleDep, 1,9);
                    
                    Label VilleArrivee = new Label("Ville d'arrivée");
                    gridAjout.add(VilleArrivee, 0, 10);


                    final ComboBox CBListVilleArriv = new ComboBox(ListeVilleArriv);
                    CBListVilleArriv.setValue("Choisissez une ville");
                    gridAjout.add(CBListVilleArriv, 1, 10);
                    
                    Label PrixVoyage = new Label("Prix du voyage");
                    gridAjout.add(PrixVoyage, 0, 11);
                    TextField InputPrixVoyage = new TextField();
                    gridAjout.add(InputPrixVoyage, 1, 11);
                    
                    Button btnAddContinue = new Button("Continuer");
                    HBox HBAddForm = new HBox(10);
                    HBAddForm.setAlignment(Pos.BOTTOM_RIGHT);
                    HBAddForm.getChildren().add(btnAddContinue);
                    gridAjout.add(HBAddForm, 1, 12);

                    Scene sceneAjoutVoyage = new Scene(gridAjout, 800, 650);

                    primaryStage.setTitle("Mon agence");
                    primaryStage.setScene(sceneAjoutVoyage);
                    primaryStage.show();
                    
                    btnAddContinue.setOnAction(Continue -> {
                        // RECUP ID VILLES ARRIVE ET DEPART
                        String NomVilleDep = CBListVilleDep.getValue().toString();
                        String NomVilleArr = CBListVilleArriv.getValue().toString();
 
                        int idVilleDep = 0;
                        int idVilleArriv = 0;
                        for(Pair p : ListeArrayVilleDepA)
                        {
                            if(p.getString().equals(NomVilleDep))
                            {
                                idVilleDep = p.getInteger();
                            }
                            
                            if(p.getString().equals(NomVilleArr))
                            {
                                idVilleArriv = p.getInteger();
                            }
                        }
                        ////////////////////////////////////
                        
                        //RECUP VALEUR DES 3 PREMIERS BOUTONS
                        
                        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
                        String typevoyage = selectedRadioButton.getText();
                        
                        RadioButton selectedRadioButton1 = (RadioButton) group2.getSelectedToggle();
                        String toggleGroupValue1 = selectedRadioButton1.getText();
                        
                        RadioButton selectedRadioButton2 = (RadioButton) group3.getSelectedToggle();
                        String toggleGroupValue2 = selectedRadioButton2.getText();
                        
                        int typevoyageId = 0;
                        if(toggleGroupValue1.equals("Groupe"))
                            {
                                typevoyageId = 1;
                            }
                        int idformule = 0;
                        if(toggleGroupValue2.equals("Famille"))
                            {
                                idformule = 1;
                            }
                        /////////////////////////////////////
                        
                        String nbpersmin = InputNbPersonneMinVoyage.getText();
                        String nbpersmax = InputNbPersonneMaxVoyage.getText();
                        String duree = InputDureeVoyage.getText();
                        String prixvoyage = InputPrixVoyage.getText();
                        String description = InputTitreVoyage.getText();
                        String difficulte = CBListDifficulte.getValue().toString();
                        
                        
                        Connexionsgbd csInsert = new Connexionsgbd();
                        csInsert.InsertVoyage(idformule, typevoyageId, idVilleDep, idVilleArriv, nbpersmin, nbpersmax, duree, prixvoyage, description, typevoyage, difficulte);
                        
                        
                        GridPane gridAjoutEtape = new GridPane();
                        
                        gridAjoutEtape.setAlignment(Pos.CENTER);
                        gridAjoutEtape.setHgap(25);
                        gridAjoutEtape.setVgap(25);
                        gridAjoutEtape.setPadding(new Insets(25, 25, 25, 25));

                        int CurrentVoyageId = csInsert.GetMaxIdVoyage();
                        
                        
                        Text sceneTitleEtape = new Text("Ajouter une étape");
                        sceneTitleEtape.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                        gridAjoutEtape.add(sceneTitleEtape, 0, 0, 2, 1);

                        Label NumeroEtape = new Label("Numéro de l'étape");
                        gridAjoutEtape.add(NumeroEtape, 0, 2);
                        TextField InputNumeroEtapeVoyage = new TextField();
                        gridAjoutEtape.add(InputNumeroEtapeVoyage, 1, 2);
                        
                        Label DureeEtape = new Label("Durée de l'étape");
                        gridAjoutEtape.add(DureeEtape, 0, 3);
                        TextField InputDureeEtapeVoyage = new TextField();
                        gridAjoutEtape.add(InputDureeEtapeVoyage, 1, 3);
                        
                        ArrayList<Pair> ListeArrayVilleEtap = new ArrayList();
                        Connexionsgbd ConnFillEtape = new Connexionsgbd();
                        ConnFillEtape.FillCity(ListeArrayVilleEtap);

                        ObservableList<String> ListeVilleEtape = 
                        FXCollections.observableArrayList();

                        for (Pair p : ListeArrayVilleEtap) {
                            ListeVilleEtape.add(p.getString());
                        }
                        
                        Label ListEtapeLabel = new Label("Ville de l'étape");
                        gridAjoutEtape.add(ListEtapeLabel, 0, 4);
                        
                        final ComboBox CBListVilleEtape = new ComboBox(ListeVilleEtape);
                        CBListVilleEtape.setValue("Choisissez une ville");
                        gridAjoutEtape.add(CBListVilleEtape, 1,4);
                        
                        Button btnAddEtape = new Button("Ajouter une étape");
                        Button btnAddQuit = new Button("Terminer");
                        HBox HBAddEtapeForm = new HBox(10);
                        HBAddEtapeForm.setAlignment(Pos.BOTTOM_RIGHT);
                        HBAddEtapeForm.getChildren().addAll(btnAddEtape, btnAddQuit);
                        gridAjoutEtape.add(HBAddEtapeForm, 1, 5);
                        
                        Scene sceneAjoutEtape = new Scene(gridAjoutEtape, 800, 650);

                        primaryStage.setTitle("Mon agence");
                        primaryStage.setScene(sceneAjoutEtape);
                        primaryStage.show();
                        
                        btnAddEtape.setOnAction(AddEtape -> {
                            String NomVilleEtape = CBListVilleEtape.getValue().toString();
                            int idVilleEtape = 0;
                            for(Pair p : ListeArrayVilleEtap)
                            {
                                if(p.getString().equals(NomVilleEtape))
                                {
                                    idVilleEtape = p.getInteger();
                                }
                            }
                            
                            String dureeEtape = InputDureeEtapeVoyage.getText();
                            String numeroEtape = InputNumeroEtapeVoyage.getText();
                            Connexionsgbd ConnInsertEtape = new Connexionsgbd();
                            ConnInsertEtape.InsertEtape(idVilleEtape, CurrentVoyageId, numeroEtape, dureeEtape);
                            
                            primaryStage.setTitle("Mon agence");
                            primaryStage.setScene(sceneAjoutEtape);
                            primaryStage.show();
                        });
                        
                        btnAddQuit.setOnAction(QuitEtape -> { 
                            primaryStage.setTitle("Mon agence");
                            primaryStage.setScene(AccueilAdmin);
                            primaryStage.show();
                            
                        });
                        

                    });
                    
                });
                
            });
                    
        }
        });
        ///  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
