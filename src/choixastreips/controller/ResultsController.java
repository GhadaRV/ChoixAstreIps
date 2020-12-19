/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choixastreips.controller;

import choixastreips.model.Data;
import choixastreips.util.DBConnector;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 *
 * @author Ghada
 */
public class ResultsController implements Initializable{

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
          ObservableList<Data> listAstre= FXCollections.observableArrayList();
    ObservableList<Data> listIPS= FXCollections.observableArrayList();
    ObservableList<Data> listAutre= FXCollections.observableArrayList();
    ObservableList<Data> x= FXCollections.observableArrayList();
     ObservableList<Data> listDoute= FXCollections.observableArrayList();
       
      
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
    
    

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        try {
            Connection con= DBConnector.getConnection();
            
            ResultSet rs = con.createStatement().executeQuery("select * from data ");
            
            while(rs.next()){
               oblist.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?")
                                    , rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre")
                                    , rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android")
                                    , rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?")
                                    , rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?")
                                    , rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]")
                                    , rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]")
                                    , rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]")
                                    , rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]")
                                    , rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]")
                                    , rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]")
                                    , rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]")
                                    , rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]")
                                    , rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]")
                                    , rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]")
                                    , rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]")
                                    , rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]")
                                    , rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]")
                                    , rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                       
               
               )) ;
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
                                
                                
 
            
            id_btnHyp1.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                validateHypothese1();
                validateHypothese2();
                validateHypothese3();
                validateHypothese4();
                validateHypothese5();
                validateHypothese6();
                validateHypothese7();
        
                
                listAstre.addAll(list1);
                listAstre.addAll(list6);
                
                
                Set<String> s1 = new HashSet<>();

                listAstre.removeIf(p -> !s1.add(p.getNum_etu()));
             
                int sizeListAstre =listAstre.size();
                
                listIPS.addAll(list2);
                listIPS.addAll(list3);
                listIPS.addAll(list4);
                listIPS.addAll(list5);
                listIPS.addAll(list7);
                
                
                Set<String> s2 = new HashSet<>();
                 listIPS.removeIf(p -> !s2.add(p.getNum_etu()));

                int sizeListIps=listIPS.size();
                
                
                x.addAll(listIPS);
                x.addAll(listAstre);
                
                 Set<Data> ss=new HashSet<Data>();
        
                    for(Data  i:x)    {
                        if(!ss.add(i))   {
                            listDoute.add(i);
                        }
                    }
  
              int sizeDoute= listDoute.size();
        
                listAutre=oblist;
                listAutre.removeAll(listIPS);
                listAutre.removeAll(listAstre);
                listAutre.removeAll(listDoute);
                 Set<String> s3 = new HashSet<>();
                listAutre.removeIf(p -> !s3.add(p.getNum_etu()));
                
                
                int sizeReste= listAutre.size();
                String resteS=String.valueOf(sizeReste);  
                id_tvReste.setText(resteS);
                
                int total=sizeListIps+sizeListAstre-sizeDoute+sizeReste;
               String totalS=String.valueOf(total);  
               id_tvTotal.setText(totalS);
                
               table.setItems(listDoute);
               ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
            new PieChart.Data("ASTRE", sizeListAstre),
            new PieChart.Data("IPS", sizeListIps),
            new PieChart.Data("Doute", sizeDoute),
            new PieChart.Data("Autre", sizeReste));
            
            chart.setData(pieChartData);
               
               
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
            while(rs.next()){
                list1.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?")
                        , rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre")
                        , rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android")
                        , rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?")
                        , rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?")
                        , rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]")
                        , rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]")
                        , rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]")
                        , rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]")
                        , rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]")
                        , rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]")
                        , rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]")
                        , rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]")
                        , rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]")
                        , rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]")
                        , rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]")
                        , rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]")
                        , rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]")
                        , rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                        
                        
                )) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  String s=String.valueOf(list1.size()); 
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
            while(rs.next()){
                list2.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?")
                        , rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre")
                        , rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android")
                        , rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?")
                        , rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?")
                        , rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]")
                        , rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]")
                        , rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]")
                        , rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]")
                        , rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]")
                        , rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]")
                        , rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]")
                        , rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]")
                        , rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]")
                        , rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]")
                        , rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]")
                        , rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]")
                        , rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]")
                        , rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                        
                        
                )) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  String s=String.valueOf(list2.size()); 
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
            while(rs.next()){
                list3.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?")
                        , rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre")
                        , rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android")
                        , rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?")
                        , rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?")
                        , rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]")
                        , rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]")
                        , rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]")
                        , rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]")
                        , rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]")
                        , rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]")
                        , rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]")
                        , rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]")
                        , rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]")
                        , rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]")
                        , rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]")
                        , rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]")
                        , rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]")
                        , rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                        
                        
                )) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  String s=String.valueOf(list3.size()); 
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
            while(rs.next()){
                list4.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?")
                        , rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre")
                        , rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android")
                        , rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?")
                        , rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?")
                        , rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]")
                        , rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]")
                        , rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]")
                        , rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]")
                        , rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]")
                        , rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]")
                        , rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]")
                        , rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]")
                        , rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]")
                        , rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]")
                        , rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]")
                        , rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]")
                        , rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]")
                        , rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                        
                        
                )) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  String s=String.valueOf(list4.size()); 
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
            while(rs.next()){
                list5.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?")
                        , rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre")
                        , rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android")
                        , rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?")
                        , rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?")
                        , rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]")
                        , rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]")
                        , rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]")
                        , rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]")
                        , rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]")
                        , rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]")
                        , rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]")
                        , rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]")
                        , rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]")
                        , rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]")
                        , rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]")
                        , rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]")
                        , rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]")
                        , rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                        
                        
                )) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  String s=String.valueOf(list5.size()); 
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
                   +"`Que fais-tu de ton temps libre ?` LIKE '%jeux%')");
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            while(rs.next()){
                list6.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?")
                        , rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre")
                        , rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android")
                        , rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?")
                        , rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?")
                        , rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]")
                        , rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]")
                        , rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]")
                        , rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]")
                        , rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]")
                        , rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]")
                        , rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]")
                        , rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]")
                        , rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]")
                        , rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]")
                        , rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]")
                        , rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]")
                        , rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]")
                        , rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                        
                        
                )) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  String s=String.valueOf(list6.size()); 
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
            while(rs.next()){
                list7.add(new Data(rs.getString("id"), rs.getString("Timestamp"), rs.getString("Quel est ton numero etudiant ?")
                        , rs.getString("D-où viens tu ?"), rs.getString("Quel parcours avez vous fait avant d-integrer l-ensim"), rs.getString("As-tu dejà passe le TOEIC ? Tu peux mettre ton score dans autre")
                        , rs.getString("Quelles sont les associations de l-ensim qui t-interesse ?"), rs.getString("Plutôt apple ou android")
                        , rs.getString("Quel est ton personnage de fiction preferee ?"), rs.getString("Que fais-tu de ton temps libre ?")
                        , rs.getString("Quels sont tes films/series preferees ?"), rs.getString("Quel est ton navigateur prefere ?")
                        , rs.getString("Quel langage de programmation as-tu deja  utilise ?"), rs.getString("As-tu deja  utilise ? [Une carte Arduino/Raspberry]")
                        , rs.getString("Des logiciels de retouche (Paint- Photoshop)?"), rs.getString("As-tu deja  utilise ? [Linux]")
                        , rs.getString("As-tu deja  utilise ? [Mac]"), rs.getString("As-tu deja  utilise ? [Windows]")
                        , rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]"), rs.getString("As-tu deja  utilise ? [Des logiciels de montage video]")
                        , rs.getString("Des logiciels de creation de jeux videos (Unity- Unreal)?"), rs.getString("As-tu deja  realise ? [Des logos]")
                        , rs.getString("As-tu deja  realise ? [Un robot]"), rs.getString("As-tu deja  realise ? [Une application mobile]")
                        , rs.getString("As-tu deja  realise ? [Une application mobile]"), rs.getString("As-tu deja  realise ? [Un logiciel sur pc]")
                        , rs.getString("As-tu deja  realise ? [Un systeme electronique (capteurs...)]"), rs.getString("Que penses-tu de ? [Visual studio]")
                        , rs.getString("Que penses-tu de ? [NotePad++]"), rs.getString("Que penses-tu de ? [Codblock]")
                        , rs.getString("Que penses-tu de ? [AndroidStudio]"), rs.getString("Que penses-tu de ? [Eclipse]")
                        , rs.getString("Que penses-tu de ? [IntellJ]"), rs.getString("Que penses-tu de ? [LabView]")
                        , rs.getString("Que penses-tu de ? [Unity]"), rs.getString("Que penses-tu de ? [UnrealEngine]")
                        , rs.getString("Que penses-tu de ? [SublimeText]"), rs.getString("Que penses-tu de ? [Atom]")
                        , rs.getString("Que penses-tu de ? [Anaconda]"), rs.getString("Que penses-tu de ? [Ionic]")
                        
                        
                )) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                  String s=String.valueOf(list7.size()); 
                  id_tvHyp7.setText(s);
               
                             

        }
}
