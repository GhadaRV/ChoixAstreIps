/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choixastreips.model;

import java.util.Objects;

/**
 *
 * @author Ghada
 */
public class Data {

    String id, timestamp, num_etu, pays, parcours, toeic, associations, telephone, fiction,
            freetime, serie, navigateur, languageProg, arduinoRasp, logRetouche, linux, mac, windows,
            logMontageVid, logCAOSolidworks, logCreationJeu, logo, robot, appMobile, jeuxVideo, logPc,
            sysElectronique, avisVS, avisNotepad, avisCodeblocks, avisAndroidStudio, avisEclipse, avisIntellij, avisLabview,
            avisUnity, avisUnrealEngine, avisSublmimeText, avisAtom, avisAnaconda, avisIonic;

    public Data(String id, String timestamp, String num_etu, String pays, String parcours, String toeic, String associations, String telephone, String fiction, String freetime, String serie, String navigateur, String languageProg, String arduinoRasp, String logRetouche, String linux, String mac, String windows, String logMontageVid, String logCAOSolidworks, String logCreationJeu, String logo, String robot, String appMobile, String jeuxVideo, String logPc, String sysElectronique, String avisVS, String avisNotepad, String avisCodeblocks, String avisAndroidStudio, String avisEclipse, String avisIntellij, String avisLabview, String avisUnity, String avisUnrealEngine, String avisSublmimeText, String avisAtom, String avisAnaconda, String avisIonic) {
        this.id = id;
        this.timestamp = timestamp;
        this.num_etu = num_etu;
        this.pays = pays;
        this.parcours = parcours;
        this.toeic = toeic;
        this.associations = associations;
        this.telephone = telephone;
        this.fiction = fiction;
        this.freetime = freetime;
        this.serie = serie;
        this.navigateur = navigateur;
        this.languageProg = languageProg;
        this.arduinoRasp = arduinoRasp;
        this.logRetouche = logRetouche;
        this.linux = linux;
        this.mac = mac;
        this.windows = windows;
        this.logMontageVid = logMontageVid;
        this.logCAOSolidworks = logCAOSolidworks;
        this.logCreationJeu = logCreationJeu;
        this.logo = logo;
        this.robot = robot;
        this.appMobile = appMobile;
        this.jeuxVideo = jeuxVideo;
        this.logPc = logPc;
        this.sysElectronique = sysElectronique;
        this.avisVS = avisVS;
        this.avisNotepad = avisNotepad;
        this.avisCodeblocks = avisCodeblocks;
        this.avisAndroidStudio = avisAndroidStudio;
        this.avisEclipse = avisEclipse;
        this.avisIntellij = avisIntellij;
        this.avisLabview = avisLabview;
        this.avisUnity = avisUnity;
        this.avisUnrealEngine = avisUnrealEngine;
        this.avisSublmimeText = avisSublmimeText;
        this.avisAtom = avisAtom;
        this.avisAnaconda = avisAnaconda;
        this.avisIonic = avisIonic;
    }

    public String getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getNum_etu() {
        return num_etu;
    }

    public String getPays() {
        return pays;
    }

    public String getParcours() {
        return parcours;
    }

    public String getToeic() {
        return toeic;
    }

    public String getAssociations() {
        return associations;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getFiction() {
        return fiction;
    }

    public String getFreetime() {
        return freetime;
    }

    public String getSerie() {
        return serie;
    }

    public String getNavigateur() {
        return navigateur;
    }

    public String getLanguageProg() {
        return languageProg;
    }

    public String getArduinoRasp() {
        return arduinoRasp;
    }

    public String getLogRetouche() {
        return logRetouche;
    }

    public String getLinux() {
        return linux;
    }

    public String getMac() {
        return mac;
    }

    public String getWindows() {
        return windows;
    }

    public String getLogMontageVid() {
        return logMontageVid;
    }

    public String getLogCAOSolidworks() {
        return logCAOSolidworks;
    }

    public String getLogCreationJeu() {
        return logCreationJeu;
    }

    public String getLogo() {
        return logo;
    }

    public String getRobot() {
        return robot;
    }

    public String getAppMobile() {
        return appMobile;
    }

    public String getJeuxVideo() {
        return jeuxVideo;
    }

    public String getLogPc() {
        return logPc;
    }

    public String getSysElectronique() {
        return sysElectronique;
    }

    public String getAvisVS() {
        return avisVS;
    }

    public String getAvisNotepad() {
        return avisNotepad;
    }

    public String getAvisCodeblocks() {
        return avisCodeblocks;
    }

    public String getAvisAndroidStudio() {
        return avisAndroidStudio;
    }

    public String getAvisEclipse() {
        return avisEclipse;
    }

    public String getAvisIntellij() {
        return avisIntellij;
    }

    public String getAvisLabview() {
        return avisLabview;
    }

    public String getAvisUnity() {
        return avisUnity;
    }

    public String getAvisUnrealEngine() {
        return avisUnrealEngine;
    }

    public String getAvisSublmimeText() {
        return avisSublmimeText;
    }

    public String getAvisAtom() {
        return avisAtom;
    }

    public String getAvisAnaconda() {
        return avisAnaconda;
    }

    public String getAvisIonic() {
        return avisIonic;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.timestamp);
        hash = 83 * hash + Objects.hashCode(this.num_etu);
        hash = 83 * hash + Objects.hashCode(this.pays);
        hash = 83 * hash + Objects.hashCode(this.parcours);
        hash = 83 * hash + Objects.hashCode(this.toeic);
        hash = 83 * hash + Objects.hashCode(this.associations);
        hash = 83 * hash + Objects.hashCode(this.telephone);
        hash = 83 * hash + Objects.hashCode(this.fiction);
        hash = 83 * hash + Objects.hashCode(this.freetime);
        hash = 83 * hash + Objects.hashCode(this.serie);
        hash = 83 * hash + Objects.hashCode(this.navigateur);
        hash = 83 * hash + Objects.hashCode(this.languageProg);
        hash = 83 * hash + Objects.hashCode(this.arduinoRasp);
        hash = 83 * hash + Objects.hashCode(this.logRetouche);
        hash = 83 * hash + Objects.hashCode(this.linux);
        hash = 83 * hash + Objects.hashCode(this.mac);
        hash = 83 * hash + Objects.hashCode(this.windows);
        hash = 83 * hash + Objects.hashCode(this.logMontageVid);
        hash = 83 * hash + Objects.hashCode(this.logCAOSolidworks);
        hash = 83 * hash + Objects.hashCode(this.logCreationJeu);
        hash = 83 * hash + Objects.hashCode(this.logo);
        hash = 83 * hash + Objects.hashCode(this.robot);
        hash = 83 * hash + Objects.hashCode(this.appMobile);
        hash = 83 * hash + Objects.hashCode(this.jeuxVideo);
        hash = 83 * hash + Objects.hashCode(this.logPc);
        hash = 83 * hash + Objects.hashCode(this.sysElectronique);
        hash = 83 * hash + Objects.hashCode(this.avisVS);
        hash = 83 * hash + Objects.hashCode(this.avisNotepad);
        hash = 83 * hash + Objects.hashCode(this.avisCodeblocks);
        hash = 83 * hash + Objects.hashCode(this.avisAndroidStudio);
        hash = 83 * hash + Objects.hashCode(this.avisEclipse);
        hash = 83 * hash + Objects.hashCode(this.avisIntellij);
        hash = 83 * hash + Objects.hashCode(this.avisLabview);
        hash = 83 * hash + Objects.hashCode(this.avisUnity);
        hash = 83 * hash + Objects.hashCode(this.avisUnrealEngine);
        hash = 83 * hash + Objects.hashCode(this.avisSublmimeText);
        hash = 83 * hash + Objects.hashCode(this.avisAtom);
        hash = 83 * hash + Objects.hashCode(this.avisAnaconda);
        hash = 83 * hash + Objects.hashCode(this.avisIonic);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Data other = (Data) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.timestamp, other.timestamp)) {
            return false;
        }
        if (!Objects.equals(this.num_etu, other.num_etu)) {
            return false;
        }
        if (!Objects.equals(this.pays, other.pays)) {
            return false;
        }
        if (!Objects.equals(this.parcours, other.parcours)) {
            return false;
        }
        if (!Objects.equals(this.toeic, other.toeic)) {
            return false;
        }
        if (!Objects.equals(this.associations, other.associations)) {
            return false;
        }
        if (!Objects.equals(this.telephone, other.telephone)) {
            return false;
        }
        if (!Objects.equals(this.fiction, other.fiction)) {
            return false;
        }
        if (!Objects.equals(this.freetime, other.freetime)) {
            return false;
        }
        if (!Objects.equals(this.serie, other.serie)) {
            return false;
        }
        if (!Objects.equals(this.navigateur, other.navigateur)) {
            return false;
        }
        if (!Objects.equals(this.languageProg, other.languageProg)) {
            return false;
        }
        if (!Objects.equals(this.arduinoRasp, other.arduinoRasp)) {
            return false;
        }
        if (!Objects.equals(this.logRetouche, other.logRetouche)) {
            return false;
        }
        if (!Objects.equals(this.linux, other.linux)) {
            return false;
        }
        if (!Objects.equals(this.mac, other.mac)) {
            return false;
        }
        if (!Objects.equals(this.windows, other.windows)) {
            return false;
        }
        if (!Objects.equals(this.logMontageVid, other.logMontageVid)) {
            return false;
        }
        if (!Objects.equals(this.logCAOSolidworks, other.logCAOSolidworks)) {
            return false;
        }
        if (!Objects.equals(this.logCreationJeu, other.logCreationJeu)) {
            return false;
        }
        if (!Objects.equals(this.logo, other.logo)) {
            return false;
        }
        if (!Objects.equals(this.robot, other.robot)) {
            return false;
        }
        if (!Objects.equals(this.appMobile, other.appMobile)) {
            return false;
        }
        if (!Objects.equals(this.jeuxVideo, other.jeuxVideo)) {
            return false;
        }
        if (!Objects.equals(this.logPc, other.logPc)) {
            return false;
        }
        if (!Objects.equals(this.sysElectronique, other.sysElectronique)) {
            return false;
        }
        if (!Objects.equals(this.avisVS, other.avisVS)) {
            return false;
        }
        if (!Objects.equals(this.avisNotepad, other.avisNotepad)) {
            return false;
        }
        if (!Objects.equals(this.avisCodeblocks, other.avisCodeblocks)) {
            return false;
        }
        if (!Objects.equals(this.avisAndroidStudio, other.avisAndroidStudio)) {
            return false;
        }
        if (!Objects.equals(this.avisEclipse, other.avisEclipse)) {
            return false;
        }
        if (!Objects.equals(this.avisIntellij, other.avisIntellij)) {
            return false;
        }
        if (!Objects.equals(this.avisLabview, other.avisLabview)) {
            return false;
        }
        if (!Objects.equals(this.avisUnity, other.avisUnity)) {
            return false;
        }
        if (!Objects.equals(this.avisUnrealEngine, other.avisUnrealEngine)) {
            return false;
        }
        if (!Objects.equals(this.avisSublmimeText, other.avisSublmimeText)) {
            return false;
        }
        if (!Objects.equals(this.avisAtom, other.avisAtom)) {
            return false;
        }
        if (!Objects.equals(this.avisAnaconda, other.avisAnaconda)) {
            return false;
        }
        if (!Objects.equals(this.avisIonic, other.avisIonic)) {
            return false;
        }
        return true;
    }

}
