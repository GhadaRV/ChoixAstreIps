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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
                                
                                
 
            table.setItems(oblist);
            id_btnHyp1.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                validateHypothese1();
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
    
}
