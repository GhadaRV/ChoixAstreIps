/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choixastreips.controller;

import choixastreips.model.Data;
import choixastreips.model.Historique;
import choixastreips.util.DBConnector;
import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author Ghada
 */
public class ResultsController implements Initializable {

    @FXML
    private TableColumn<Data, String> col_id;
    @FXML
    private TableColumn<Data, String> col_timestamp;
    @FXML
    private TableColumn<Data, String> col_numEtu;
    @FXML
    private TableColumn<Data, String> col_pays;
    @FXML
    private TableColumn<Data, String> col_parcours;
    @FXML
    private TableColumn<Data, String> id_toeic;
    @FXML
    private TableColumn<Data, String> id_associations;
    @FXML
    private TableColumn<Data, String> id_telephone;

    ObservableList<Data> oblist = FXCollections.observableArrayList();
    ObservableList<Data> list1 = FXCollections.observableArrayList();
    ObservableList<Data> list2 = FXCollections.observableArrayList();
    ObservableList<Data> list3 = FXCollections.observableArrayList();
    ObservableList<Data> list4 = FXCollections.observableArrayList();
    ObservableList<Data> list5 = FXCollections.observableArrayList();
    ObservableList<Data> list6 = FXCollections.observableArrayList();
    ObservableList<Data> list7 = FXCollections.observableArrayList();
    ObservableList<Data> list8 = FXCollections.observableArrayList();
    ObservableList<Data> listAstre = FXCollections.observableArrayList();
    ObservableList<Data> listIPS = FXCollections.observableArrayList();
    ObservableList<Data> listAutre = FXCollections.observableArrayList();
    ObservableList<Data> x = FXCollections.observableArrayList();
    ObservableList<Data> listDoute = FXCollections.observableArrayList();
    ObservableList<Historique> listHistorique = FXCollections.observableArrayList();
    @FXML
    private TableView<Data> table;
    @FXML
    private TableColumn<Data, String> col_fiction;
    @FXML
    private TableColumn<Data, String> col_freetime;
    @FXML
    private TableColumn<Data, String> col_serie;
    @FXML
    private TableColumn<Data, String> col_navigateur;
    @FXML
    private TableColumn<Data, String> col_languageProg;
    @FXML
    private TableColumn<Data, String> col_arduinoRasp;
    @FXML
    private TableColumn<Data, String> col_logRetouche;
    @FXML
    private TableColumn<Data, String> col_linux;
    @FXML
    private TableColumn<Data, String> col_mac;
    @FXML
    private TableColumn<Data, String> col_windows;
    @FXML
    private TableColumn<Data, String> col_LogMontageVid;
    @FXML
    private TableColumn<Data, String> col_LogCAOSolidworks;
    @FXML
    private TableColumn<Data, String> col_LogCreationJeu;
    @FXML
    private TableColumn<Data, String> col_logo;
    @FXML
    private TableColumn<Data, String> col_robot;
    @FXML
    private TableColumn<Data, String> col_appMobile;
    @FXML
    private TableColumn<Data, String> col_jeuxVidéo;
    @FXML
    private TableColumn<Data, String> col_logPc;
    @FXML
    private TableColumn<Data, String> col_sysElectronique;
    @FXML
    private TableColumn<Data, String> col_avisVS;
    @FXML
    private TableColumn<Data, String> col_avisNotepad;
    @FXML
    private TableColumn<Data, String> col_avisCodeblocks;
    @FXML
    private TableColumn<Data, String> col_avisAndroidStudio;
    @FXML
    private TableColumn<Data, String> col_avisEclipse;
    @FXML
    private TableColumn<Data, String> col_avisIntellij;
    @FXML
    private TableColumn<Data, String> col_avisLabview;
    @FXML
    private TableColumn<Data, String> col_avisUnity;
    @FXML
    private TableColumn<Data, String> col_avisUnrealEngine;
    @FXML
    private TableColumn<Data, String> col_avisSublimeText;
    @FXML
    private TableColumn<Data, String> col_avisAtom;
    @FXML
    private TableColumn<Data, String> col_avisAnaconda;
    @FXML
    private TableColumn<Data, String> col_avisIonic;
    @FXML
    private Button id_btnHyp1;
    @FXML
    private Text id_tvHyp1;
    @FXML
    private Text id_tvHyp2;
    @FXML
    private Text id_tvHyp3;
    @FXML
    private Text id_tvHyp4;
    @FXML
    private Text id_tvHyp5;
    @FXML
    private Text id_tvHyp7;
    @FXML
    private Text id_tvHyp6;
    @FXML
    private Text id_tvTotal;
    @FXML
    private Text id_tvReste;
    @FXML
    private PieChart chart;
    @FXML
    private RadioButton rb1_1;
    @FXML
    private RadioButton rb1_3;
    @FXML
    private RadioButton rb1_5;
    @FXML
    private RadioButton rb1_7;
    @FXML
    private RadioButton rb1_10;
    @FXML
    private RadioButton rb2_1;
    @FXML
    private RadioButton rb2_3;
    @FXML
    private RadioButton rb2_5;
    @FXML
    private RadioButton rb2_7;
    @FXML
    private RadioButton rb2_10;
    @FXML
    private RadioButton rb3_10;
    @FXML
    private RadioButton rb3_7;
    @FXML
    private RadioButton rb3_5;
    @FXML
    private RadioButton rb3_3;
    @FXML
    private RadioButton rb3_1;
    @FXML
    private RadioButton rb4_10;
    @FXML
    private RadioButton rb4_7;
    @FXML
    private RadioButton rb4_5;
    @FXML
    private RadioButton rb4_3;
    @FXML
    private RadioButton rb4_1;
    @FXML
    private RadioButton rb5_10;
    @FXML
    private RadioButton rb5_7;
    @FXML
    private RadioButton rb5_5;
    @FXML
    private RadioButton rb5_3;
    @FXML
    private RadioButton rb5_1;
    @FXML
    private RadioButton rb6_10;
    @FXML
    private RadioButton rb6_7;
    @FXML
    private RadioButton rb6_5;
    @FXML
    private RadioButton rb6_3;
    @FXML
    private RadioButton rb6_1;
    @FXML
    private RadioButton rb7_10;
    @FXML
    private RadioButton rb7_7;
    @FXML
    private RadioButton rb7_5;
    @FXML
    private RadioButton rb7_3;
    @FXML
    private RadioButton rb7_1;
    @FXML
    private ToggleButtonGroup tbg1;
    @FXML
    private ToggleButtonGroup tbg2;
    @FXML
    private ToggleButtonGroup tbg3;
    @FXML
    private ToggleButtonGroup tbg4;
    @FXML
    private ToggleButtonGroup tbg5;
    @FXML
    private ToggleButtonGroup tbg6;
    @FXML
    private ToggleButtonGroup tbg7;
    @FXML
    private Text txtnRB;
    @FXML
    private ToggleGroup tg1;
    @FXML
    private Text id_tvHyp8;
    @FXML
    private ToggleButtonGroup tbg8;
    @FXML
    private RadioButton rb8_10;
    @FXML
    private RadioButton rb8_7;
    @FXML
    private RadioButton rb8_5;
    @FXML
    private RadioButton rb8_3;
    @FXML
    private RadioButton rb8_1;
    private TableView<Data> table1;
    @FXML
    private TextArea txt_list_ips;
    @FXML
    private TextArea txt_list_astre;
    @FXML
    private TextArea txt_list_doute;
    @FXML
    private TextArea txt_list_difficile;
    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane n1;
    @FXML
    private AnchorPane n2;
    @FXML
    private AnchorPane n3;
    @FXML
    private AnchorPane n4;
    @FXML
    private AnchorPane n5;
    @FXML
    private AnchorPane n6;
    @FXML
    private ToggleGroup tg2;
    @FXML
    private ToggleGroup tg3;
    @FXML
    private ToggleGroup tg4;
    @FXML
    private ToggleGroup tg5;
    @FXML
    private ToggleGroup tg6;
    @FXML
    private ToggleGroup tg7;
    @FXML
    private ToggleGroup tg8;
    @FXML
    private Tab tab_add_pond;
    @FXML
    private Tab tab_res_pond;
    @FXML
    private Button id_btnResPond;
    @FXML
    private TabPane tabpane;
    @FXML
    private Text txtnRB1;
    @FXML
    private Text txtnRB2;
    @FXML
    private Text txtnRB3;
    @FXML
    private Text txtnRB4;
    @FXML
    private Text txtnRB5;
    @FXML
    private Text txtnRB6;
    @FXML
    private Text txtnRB7;
    @FXML
    private Text txtnRB8;

   
     private   int post_listeAstre; 
     private   int post_listeProbablementAstre; 
     private   int post_listeIPS; 
     private   int post_listeProbablementIPS; 
     private   int post_listeDoute; 
     private   int post_listeDifficile; 
     private int sizeReste; 
     private int sizeDoute;
    @FXML
    private PieChart chart2;
    
    String textFinalResults="";
    @FXML
    private TableView<Historique> t2;
    @FXML
    private TableColumn<Historique, String> d_1;
    @FXML
    private TableColumn<Historique, Integer> d_2;
    @FXML
    private TableColumn<Historique, Integer> d_3;
    @FXML
    private TableColumn<Historique, Integer> d_4;
    @FXML
    private TableColumn<Historique, Integer> d_5;
    @FXML
    private TableColumn<Historique, Integer> d_6;
       
    @Override
    public void initialize(URL location, ResourceBundle resources) {
 
        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from data ");

            while (rs.next()) {
                oblist.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
            
            
     
            col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_timestamp.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
            col_numEtu.setCellValueFactory(new PropertyValueFactory<>("num_etu"));
            col_pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
            col_parcours.setCellValueFactory(new PropertyValueFactory<>("parcours"));
            id_toeic.setCellValueFactory(new PropertyValueFactory<>("toeic"));
            id_associations.setCellValueFactory(new PropertyValueFactory<>("associations"));
            id_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            col_fiction.setCellValueFactory(new PropertyValueFactory<>("fiction"));
            col_freetime.setCellValueFactory(new PropertyValueFactory<>("freetime"));
            col_serie.setCellValueFactory(new PropertyValueFactory<>("serie"));
            col_navigateur.setCellValueFactory(new PropertyValueFactory<>("navigateur"));
            col_languageProg.setCellValueFactory(new PropertyValueFactory<>("languageProg"));
            col_arduinoRasp.setCellValueFactory(new PropertyValueFactory<>("arduinoRasp"));
            col_logRetouche.setCellValueFactory(new PropertyValueFactory<>("logRetouche"));
            col_linux.setCellValueFactory(new PropertyValueFactory<>("linux"));
            col_mac.setCellValueFactory(new PropertyValueFactory<>("mac"));
            col_windows.setCellValueFactory(new PropertyValueFactory<>("windows"));
            col_LogMontageVid.setCellValueFactory(new PropertyValueFactory<>("logMontageVid"));
            col_LogCAOSolidworks.setCellValueFactory(new PropertyValueFactory<>("logCAOSolidworks"));
            col_LogCreationJeu.setCellValueFactory(new PropertyValueFactory<>("logCreationJeu"));
            col_logo.setCellValueFactory(new PropertyValueFactory<>("logo"));
            col_robot.setCellValueFactory(new PropertyValueFactory<>("robot"));
            col_appMobile.setCellValueFactory(new PropertyValueFactory<>("appMobile"));
            col_jeuxVidéo.setCellValueFactory(new PropertyValueFactory<>("jeuxVideo"));
            col_logPc.setCellValueFactory(new PropertyValueFactory<>("logPc"));
            col_sysElectronique.setCellValueFactory(new PropertyValueFactory<>("sysElectronique"));
            col_avisVS.setCellValueFactory(new PropertyValueFactory<>("avisVS"));
            col_avisNotepad.setCellValueFactory(new PropertyValueFactory<>("avisNotepad"));
            col_avisCodeblocks.setCellValueFactory(new PropertyValueFactory<>("avisCodeblocks"));
            col_avisAndroidStudio.setCellValueFactory(new PropertyValueFactory<>("avisAndroidStudio"));
            col_avisEclipse.setCellValueFactory(new PropertyValueFactory<>("avisEclipse"));
            col_avisIntellij.setCellValueFactory(new PropertyValueFactory<>("avisIntellij"));
            col_avisLabview.setCellValueFactory(new PropertyValueFactory<>("avisLabview"));
            col_avisUnity.setCellValueFactory(new PropertyValueFactory<>("avisUnity"));
            col_avisUnrealEngine.setCellValueFactory(new PropertyValueFactory<>("avisUnrealEngine"));
            col_avisSublimeText.setCellValueFactory(new PropertyValueFactory<>("avisSublmimeText"));
            col_avisAtom.setCellValueFactory(new PropertyValueFactory<>("avisAtom"));
            col_avisAnaconda.setCellValueFactory(new PropertyValueFactory<>("avisAnaconda"));
            col_avisIonic.setCellValueFactory(new PropertyValueFactory<>("avisIonic"));
            
          

            /**
             * **************************************
             */
            /**
             * ************************************
             */
            tg1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (tg1.getSelectedToggle() != null) {

                        RadioButton selectedRadioButton = (RadioButton) tg1.getSelectedToggle();
                        String toogleGroupValue1 = selectedRadioButton.getText();
                        txtnRB.setText(toogleGroupValue1);
                        txtnRB1.setText(toogleGroupValue1);
                    }

                }
            });

            tg2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (tg2.getSelectedToggle() != null) {

                        RadioButton selectedRadioButton = (RadioButton) tg2.getSelectedToggle();
                        String toogleGroupValue = selectedRadioButton.getText();
                        txtnRB.setText(toogleGroupValue);
                        txtnRB6.setText(toogleGroupValue);

                    }

                }
            });

            tg3.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (tg3.getSelectedToggle() != null) {

                        RadioButton selectedRadioButton = (RadioButton) tg3.getSelectedToggle();
                        String toogleGroupValue = selectedRadioButton.getText();
                        txtnRB.setText(toogleGroupValue);
                        txtnRB8.setText(toogleGroupValue);

                    }

                }
            });

            tg4.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (tg4.getSelectedToggle() != null) {

                        RadioButton selectedRadioButton = (RadioButton) tg4.getSelectedToggle();
                        String toogleGroupValue = selectedRadioButton.getText();
                        txtnRB.setText(toogleGroupValue);
                        txtnRB2.setText(toogleGroupValue);
                    }

                }
            });

            tg5.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (tg5.getSelectedToggle() != null) {

                        RadioButton selectedRadioButton = (RadioButton) tg5.getSelectedToggle();
                        String toogleGroupValue = selectedRadioButton.getText();
                        txtnRB.setText(toogleGroupValue);
                        txtnRB3.setText(toogleGroupValue);

                    }

                }
            });

            tg6.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (tg6.getSelectedToggle() != null) {

                        RadioButton selectedRadioButton = (RadioButton) tg6.getSelectedToggle();
                        String toogleGroupValue = selectedRadioButton.getText();
                        txtnRB.setText(toogleGroupValue);
                        txtnRB4.setText(toogleGroupValue);

                    }

                }
            });

            tg7.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (tg7.getSelectedToggle() != null) {

                        RadioButton selectedRadioButton = (RadioButton) tg7.getSelectedToggle();
                        String toogleGroupValue = selectedRadioButton.getText();
                        txtnRB.setText(toogleGroupValue);
                        txtnRB5.setText(toogleGroupValue);

                    }

                }
            });

            tg8.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                    if (tg8.getSelectedToggle() != null) {

                        RadioButton selectedRadioButton = (RadioButton) tg8.getSelectedToggle();
                        String toogleGroupValue = selectedRadioButton.getText();
                        txtnRB.setText(toogleGroupValue);
                        txtnRB7.setText(toogleGroupValue);

                    }

                }
            });

            table.setItems(oblist);

            id_btnHyp1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    validateHypothese1();
                    validateHypothese2();
                    validateHypothese3();
                    validateHypothese4();
                    validateHypothese5();
                    validateHypothese6();
                    validateHypothese7();
                    validateHypothese8();

                    listAstre.addAll(list1);
                    listAstre.addAll(list6);
                    listAstre.addAll(list8);

                    Set<String> s1 = new HashSet<>();

                    listAstre.removeIf(p -> !s1.add(p.getNum_etu()));
                    int sizeListAstre = listAstre.size();

                    listIPS.addAll(list2);
                    listIPS.addAll(list3);
                    listIPS.addAll(list4);
                    listIPS.addAll(list5);
                    listIPS.addAll(list7);

                    Set<String> s2 = new HashSet<>();
                    listIPS.removeIf(p -> !s2.add(p.getNum_etu()));

                    int sizeListIps = listIPS.size();

                    x.addAll(listIPS);
                    x.addAll(listAstre);

                    Set<Data> ss = new HashSet<Data>();

                    for (Data i : x) {
                        if (!ss.add(i)) {
                            listDoute.add(i);
                        }
                    }

                    sizeDoute = listDoute.size();

                    listAstre.removeAll(listDoute);
                    sizeListAstre = listAstre.size();
                    listIPS.removeAll(listDoute);
                    sizeListIps = listIPS.size();

                    listAutre.addAll(oblist);
                    listAutre.removeAll(listIPS);
                    listAutre.removeAll(listAstre);
                    listAutre.removeAll(listDoute);

                    //  table.setItems(listAutre);
                    //   table1.setItems(listAstre);
                    //     table2.setItems(listIPS);
                    //  table3.setItems(listDoute);
                    //   table4.setItems(listAutre);
                    Set<String> s3 = new HashSet<>();
                    listAutre.removeIf(p -> !s3.add(p.getNum_etu()));
                    /**
                     * ****************************
                     */
                    String textIPS = "\n \n \n";
                    for (Data item : listIPS) {

                        textIPS = textIPS + "             ID : " + item.getId() + "      ; Le numero de l'étudiant est : " + item.getNum_etu() + "        ; Son pays est: " + item.getPays() + "." + "\n";
                    }
                    txt_list_ips.setText(textIPS);

                    /**
                     * *****************************
                     */
                    String textAstre = "\n \n \n";
                    for (Data item : listAstre) {

                        textAstre = textAstre + "             ID : " + item.getId() + "      ; Le numero de l'étudiant est : " + item.getNum_etu() + "        ; Son pays est: " + item.getPays() + "." + "\n";
                    }
                    txt_list_astre.setText(textAstre);
                    /**
                     * ************************************
                     */

                    String textDoute = "\n \n \n";
                    for (Data item : listDoute) {

                        textDoute = textDoute + "             ID : " + item.getId() + "      ; Le numero de l'étudiant est : " + item.getNum_etu() + "        ; Son pays est: " + item.getPays() + "." + "\n";
                    }
                    txt_list_doute.setText(textDoute);
                  
                    /**
                     * ************************************
                     */

                    String textDifficile = "\n \n \n";
                    for (Data item : listAutre) {

                        textDifficile = textDifficile + "             ID : " + item.getId() + "      ; Le numero de l'étudiant est : " + item.getNum_etu() + "        ; Son pays est: " + item.getPays() + "." + "\n";
                    }
                    txt_list_difficile.setText(textDifficile);
                    /**
                     * ************************************
                     */

                    sizeReste = listAutre.size();
                   
                    String resteS = String.valueOf(sizeReste);
                    id_tvReste.setText(resteS);

                    int total = sizeListIps + sizeListAstre + sizeReste + sizeDoute;
                    String totalS = String.valueOf(total);
                    id_tvTotal.setText(totalS);

                    ObservableList<PieChart.Data> pieChartData
                            = FXCollections.observableArrayList(
                                    new PieChart.Data("ASTRE", sizeListAstre),
                                    new PieChart.Data("IPS", sizeListIps),
                                    new PieChart.Data("Doublons Astre/IPS", sizeDoute),
                                    new PieChart.Data("Difficile à savoir", sizeReste));

                    chart.setData(pieChartData);
                    chart.setTitle("Choix Astre/IPS (Sans Pondération)");

                    pieChartData.forEach(data
                            -> data.nameProperty().bind(
                                    Bindings.concat(
                                            data.getName(), " : ", data.pieValueProperty().intValue(), " personnes. "
                                    )
                            )
                    );

                   
                }
            });

            /**
             * ******************************************************
             */
            id_btnResPond.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    
                    /**
                     * ***************************************************
                     */
                    int hyp1Num = Integer.parseInt(id_tvHyp1.getText());
                    int hyp2Num = Integer.parseInt(id_tvHyp2.getText());
                    int hyp3Num = Integer.parseInt(id_tvHyp3.getText());
                    int hyp4Num = Integer.parseInt(id_tvHyp4.getText());
                    int hyp5Num = Integer.parseInt(id_tvHyp5.getText());
                    int hyp6Num = Integer.parseInt(id_tvHyp6.getText());
                    int hyp7Num = Integer.parseInt(id_tvHyp7.getText());
                    int hyp8Num = Integer.parseInt(id_tvHyp8.getText());

                    /**
                     * ***************************************************
                     */
                   int coefHyp1Num = Integer.parseInt(txtnRB1.getText());
                   int coefHyp2Num = Integer.parseInt(txtnRB2.getText());
                   int coefHyp3Num = Integer.parseInt(txtnRB3.getText());
                   int coefHyp4Num = Integer.parseInt(txtnRB4.getText());
                   int coefHyp5Num = Integer.parseInt(txtnRB5.getText());
                   int coefHyp6Num = Integer.parseInt(txtnRB6.getText());
                   int coefHyp7Num = Integer.parseInt(txtnRB7.getText());
                   int coefHyp8Num = Integer.parseInt(txtnRB8.getText());
     
                   /*************************************************/
                   
          
      
   
                   
                switch (coefHyp1Num) {
                  case 1:
                   post_listeAstre=post_listeAstre+hyp1Num; 
                    break;
                  case 5:
                    post_listeDoute=post_listeDoute+hyp1Num; 
                    break;
                  case 10:
                  post_listeIPS=post_listeIPS+hyp1Num; 
                    break;
                    case 3:
                  post_listeProbablementAstre=post_listeProbablementAstre+hyp1Num; 
                    break;
                    case 7:
                  post_listeProbablementIPS=post_listeProbablementIPS+hyp1Num; 
                    break;
                 
                }
                
                  switch (coefHyp6Num) {
                  case 1:
                   post_listeAstre=post_listeAstre+hyp6Num; 
                    break;
                  case 5:
                    post_listeDoute=post_listeDoute+hyp6Num; 
                    break;
                  case 10:
                  post_listeIPS=post_listeIPS+hyp6Num; 
                    break;
                     case 3:
                  post_listeProbablementAstre=post_listeProbablementAstre+hyp6Num; 
                    break;
                    case 7:
                  post_listeProbablementIPS=post_listeProbablementIPS+hyp6Num; 
                    break;
                 
                }
                  
                    switch (coefHyp8Num) {
                  case 1:
                   post_listeAstre=post_listeAstre+hyp8Num; 
                    break;
                  case 5:
                    post_listeDoute=post_listeDoute+hyp8Num; 
                    break;
                  case 10:
                  post_listeIPS=post_listeIPS+hyp8Num; 
                    break;
                  case 3:
                  post_listeProbablementAstre=post_listeProbablementAstre+hyp8Num; 
                    break;
                    case 7:
                  post_listeProbablementIPS=post_listeProbablementIPS+hyp8Num; 
                    break;
                }
                     switch (coefHyp2Num) {
                  case 1:
                   post_listeAstre=post_listeAstre+hyp2Num; 
                    break;
                  case 5:
                    post_listeDoute=post_listeDoute+hyp2Num; 
                    break;
                  case 10:
                  post_listeIPS=post_listeIPS+hyp2Num; 
                    break;
                     case 3:
                  post_listeProbablementAstre=post_listeProbablementAstre+hyp2Num; 
                    break;
                    case 7:
                  post_listeProbablementIPS=post_listeProbablementIPS+hyp2Num; 
                    break;
                 
                }
                         switch (coefHyp3Num) {
                  case 1:
                   post_listeAstre=post_listeAstre+hyp3Num; 
                    break;
                  case 5:
                    post_listeDoute=post_listeDoute+hyp3Num; 
                    break;
                  case 10:
                  post_listeIPS=post_listeIPS+hyp3Num; 
                    break;
                     case 3:
                  post_listeProbablementAstre=post_listeProbablementAstre+hyp3Num; 
                    break;
                    case 7:
                  post_listeProbablementIPS=post_listeProbablementIPS+hyp3Num; 
                    break;
                 
                }
              switch (coefHyp4Num) {
                  case 1:
                   post_listeAstre=post_listeAstre+hyp4Num; 
                    break;
                  case 5:
                    post_listeDoute=post_listeDoute+hyp4Num; 
                    break;
                  case 10:
                  post_listeIPS=post_listeIPS+hyp4Num; 
                    break;
                  case 3:
                  post_listeProbablementAstre=post_listeProbablementAstre+hyp4Num; 
                    break;
                    case 7:
                  post_listeProbablementIPS=post_listeProbablementIPS+hyp4Num; 
                    break;
                }
              switch (coefHyp5Num) {
                  case 1:
                   post_listeAstre=post_listeAstre+hyp5Num; 
                    break;
                  case 5:
                    post_listeDoute=post_listeDoute+hyp5Num; 
                    break;
                  case 10:
                  post_listeIPS=post_listeIPS+hyp5Num; 
                    break;
                  case 3:
                  post_listeProbablementAstre=post_listeProbablementAstre+hyp5Num; 
                    break;
                    case 7:
                  post_listeProbablementIPS=post_listeProbablementIPS+hyp5Num; 
                    break;
                }
             switch (coefHyp7Num) {
                  case 1:
                   post_listeAstre=post_listeAstre+hyp7Num; 
                    break;
                  case 5:
                    post_listeDoute=post_listeDoute+hyp7Num; 
                    break;
                  case 10:
                  post_listeIPS=post_listeIPS+hyp7Num; 
                    break;
                  case 3:
                  post_listeProbablementAstre=post_listeProbablementAstre+hyp7Num; 
                    break;
                    case 7:
                  post_listeProbablementIPS=post_listeProbablementIPS+hyp7Num; 
                    break;
                }

                    post_listeDifficile=sizeReste;
                    
                    
                    int total= post_listeAstre+post_listeProbablementAstre+post_listeIPS+post_listeProbablementIPS+post_listeDoute;
                    int percentAstre = (int)(post_listeAstre* 100.0f) / total;
                    int percentMaybeAstre = (int)(post_listeProbablementAstre* 100.0f) / total;
                    int percentIps=(int)(post_listeIPS* 100.0f) / total;
                    int percentMaybeIps=(int)(post_listeProbablementIPS* 100.0f) / total;
                     int percentDoute=(int)(post_listeDoute* 100.0f) / total;
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss");
                    String dateCalcul =dateFormat.format(new Date());
                    
                    System.out.println("Astre: "+percentAstre+"%     ;Probablement en ASTRE: "+percentMaybeAstre+"%     ;IPS: "+percentIps+"%     ;Probablement en IPS: "+percentMaybeIps +"%     ;Neutre: " +percentDoute+"%");
                
                      Connection con = null;
                      
                        try {
                            con = DBConnector.getConnection();
                        } catch (SQLException ex) {
                            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                           String query = "INSERT INTO `historique`(`dateCalcul`, `ips`, `astre`, `maybeAstre`, `maybeIPS`, `neutre`)  VALUES('"+dateCalcul+"',"+percentIps+","+percentAstre+","+percentMaybeAstre+","+percentIps+"," +percentDoute+")";
      
                    ResultSet rs = null;
                    try {
                    Statement stmt = con.createStatement();

                       int c= stmt.executeUpdate(query);
                    } catch (SQLException ex) {
                        Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
 
                    
                    Connection con2 = null;
                    try {
                        con2 = DBConnector.getConnection();
                    } catch (SQLException ex) {
                        Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
                    }

            ResultSet rs2 = null;
                    try {
                        rs2 = con2.createStatement().executeQuery("select * from historique ");
                    } catch (SQLException ex) {
                        Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        while (rs2.next()) {
                            listHistorique.add(new Historique(rs2.getString("dateCalcul"), rs2.getInt("ips"),rs2.getInt("astre"),rs2.getInt("neutre"), rs2.getInt("maybeAstre"), rs2.getInt("maybeIPS") ));
                        }       } catch (SQLException ex) {
                        Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 d_1.setCellValueFactory(new PropertyValueFactory<>("date"));
                 d_2.setCellValueFactory(new PropertyValueFactory<>("p_ips"));
                 d_3.setCellValueFactory(new PropertyValueFactory<>("p_astre"));
                 d_4.setCellValueFactory(new PropertyValueFactory<>("p_neutre"));
                 d_5.setCellValueFactory(new PropertyValueFactory<>("p_p_astre"));
                 d_6.setCellValueFactory(new PropertyValueFactory<>("p_p_ips"));
                 
                    t2.setItems(listHistorique);
                        
                    
               
                
                /*********************************************/
                
                
                
                 ObservableList<PieChart.Data> pieChart2
                            = FXCollections.observableArrayList(
                                    new PieChart.Data("ASTRE", percentAstre),
                                    new PieChart.Data("IPS", percentIps),
                                    new PieChart.Data("Probablement en Astre", percentMaybeAstre),
                                    new PieChart.Data("Probablement en IPS", percentMaybeIps),
                                    new PieChart.Data("Neutre", percentDoute));

                    chart2.setData(pieChart2);
                    chart2.setTitle("Choix Astre/IPS (Avec Pondération)");

                    pieChart2.forEach(data
                            -> data.nameProperty().bind(
                                    Bindings.concat(
                                            data.getName(), " : ", data.pieValueProperty().intValue(), "%. "
                                    )
                            )
                    );


                
                     
                post_listeAstre=0;
                post_listeIPS=0;
                post_listeDoute=0;
                post_listeProbablementAstre=0;
                post_listeProbablementIPS=0;
                /********************************************/
                 tabpane.getSelectionModel().selectNext();
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void validateHypothese1() {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {

            rs = con.createStatement().executeQuery("select * from data where `As-tu deja  utilise ? [Une carte Arduino/Raspberry]` LIKE '%Regulierement%'"
                    + "and ( `Quel langage de programmation as-tu deja  utilise ?` LIKE '%C++%' or `Quel langage de programmation as-tu deja  utilise ?` LIKE '%C%' )  and `Quel langage de programmation as-tu deja  utilise ?` LIKE '%Python%' ");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                list1.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = String.valueOf(list1.size());
        id_tvHyp1.setText(s);

    }

    public void validateHypothese2() {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {

            rs = con.createStatement().executeQuery("select * from data where `Quel langage de programmation as-tu deja  utilise ?` LIKE '%HTML%CSS%Php%' OR "
                    + "`Quel langage de programmation as-tu deja  utilise ?` LIKE '%HTML%CSS%JavaScript%' "
                    + "OR `Quel langage de programmation as-tu deja  utilise ?` LIKE '%HTML%Php%JavaScript%' "
                    + "OR `Quel langage de programmation as-tu deja  utilise ?` LIKE '%CSS%Php%JavaScript%'  ");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                list2.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = String.valueOf(list2.size());
        id_tvHyp2.setText(s);

    }

    public void validateHypothese3() {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {

            rs = con.createStatement().executeQuery("select * from data where `Quel parcours avez vous fait avant d-integrer l-ensim` LIKE '%BTS%' AND "
                    + "(`Quel langage de programmation as-tu deja  utilise ?` LIKE '%HTML%' OR "
                    + "`Quel langage de programmation as-tu deja  utilise ?` LIKE '%CSS%' OR"
                    + "`Quel langage de programmation as-tu deja  utilise ?` LIKE '%Php%' OR"
                    + "`Quel langage de programmation as-tu deja  utilise ?` LIKE '%JavaScript%')");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                list3.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = String.valueOf(list3.size());
        id_tvHyp3.setText(s);

    }

    public void validateHypothese4() {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {

            rs = con.createStatement().executeQuery("select * from data where (`Que fais-tu de ton temps libre ?` LIKE '%Jeux%' OR "
                    + "`Que fais-tu de ton temps libre ?` LIKE '%jeux%' )"
                    + "AND `Quelles sont les associations de l-ensim qui t-interesse ?` LIKE '%Infographie%' ");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                list4.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = String.valueOf(list4.size());
        id_tvHyp4.setText(s);

    }

    public void validateHypothese5() {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {

            rs = con.createStatement().executeQuery("select * from data where (`Des logiciels de retouche (Paint- Photoshop)?` LIKE '%Regulierement%' OR "
                    + "`Des logiciels de retouche (Paint- Photoshop)?` LIKE '%Tout le temps%') "
                    + "AND (`Que fais-tu de ton temps libre ?` LIKE '%Jeux%' OR "
                    + "`Que fais-tu de ton temps libre ?` LIKE '%jeux%' )");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                list5.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = String.valueOf(list5.size());
        id_tvHyp5.setText(s);

    }

    public void validateHypothese6() {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {

            rs = con.createStatement().executeQuery("select * from data where `As-tu deja  utilise ? [Une carte Arduino/Raspberry]` LIKE '%Regulierement%' AND "
                    + "`As-tu deja  realise ? [Un robot]` LIKE '%Regulierement%' "
                    + "AND (`Que fais-tu de ton temps libre ?` LIKE '%Jeux%' OR "
                    + "`Que fais-tu de ton temps libre ?` LIKE '%jeux%')");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                list6.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = String.valueOf(list6.size());
        id_tvHyp6.setText(s);

    }

    public void validateHypothese7() {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {

            rs = con.createStatement().executeQuery("select * from data where (`Des logiciels de retouche (Paint- Photoshop)?` LIKE '%Regulierement%' OR "
                    + "`Des logiciels de retouche (Paint- Photoshop)?` LIKE '%Tout le temps%' OR"
                    + "`Des logiciels de retouche (Paint- Photoshop)?` LIKE '%Un peu%')"
                    + "AND (`As-tu deja  utilise ? [Mac]` LIKE '%Regulierement%' OR "
                    + "`As-tu deja  utilise ? [Mac]` LIKE '%Tout le temps%')");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                list7.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = String.valueOf(list7.size());
        id_tvHyp7.setText(s);

    }

    public void validateHypothese8() {

        Connection con = null;
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {

            rs = con.createStatement().executeQuery("select * from data where `Quel parcours avez vous fait avant d-integrer l-ensim` LIKE '%Prepa%' AND "
                    + "`Que fais-tu de ton temps libre ?` Not LIKE '%code%' AND"
                    + "`Quelles sont les associations de l-ensim qui t-interesse ?` Not LIKE '%Infographie%'");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                list8.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?"),
                        rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre"),
                        rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android"),
                        rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?"),
                        rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?"),
                        rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]"),
                        rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]"),
                        rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]"),
                        rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"),
                        rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]"),
                        rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]"),
                        rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]"),
                        rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]"),
                        rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]"),
                        rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]"),
                        rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]"),
                        rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]"),
                        rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]"),
                        rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = String.valueOf(list8.size());
        id_tvHyp8.setText(s);

    }
}
