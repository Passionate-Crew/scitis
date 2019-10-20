package ClasseUml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Domaines {
    
    private Map<String, ArrayList<String>> domaines;
    private ArrayList<String> agriculture_Agronome = new ArrayList(Arrays.asList("Aimer la nature","Travailleur","Autonome","Protection de l’environnement","Polyvalent","Machinisme","Gestion","Technique de production","Compétence technique de production agricole","Biologie"));
    private ArrayList<String> arts = new ArrayList(Arrays.asList("Créatif","Curieux","Observateur","Adaptable","Energie","Maitrise dessin","Patience","Inventif","Esprit critique","Argumenter ses choix"));
    private ArrayList<String> banque_Assurance_Immobiler = new ArrayList(Arrays.asList("Sens des chiffres","Relationnel","Négociateur","Savoir vendre","Aimer conseiller","Convaincant","Impliquer","Présentation irréprochable","Prendre des décisions","Etre informé des nouveautés"));
    private ArrayList<String> commerce = new ArrayList(Arrays.asList("Sens des chiffres","Organisé","Langues étrangères","Relationnel","Convaincant","Initiative","Etre à l’écoute ","Adaptable","Expression orale","Entreprenant" ));
    private ArrayList<String> defensePublique = new ArrayList(Arrays.asList("Courage","Résistance","Discipline","Travail d’équipe","Disponible","Altruisme","Initiative","Neutralité","Relationnel"));
    private ArrayList<String> economie_Droit_SciencePo = new ArrayList(Arrays.asList("Impartial","Sens du devoir","Etre informé des nouveautés","Cultivé","Diplomate","Expression orale","Esprit de synthèse","Bonne mémoire","Esprit critique","Langues étrangères","Ouverture d’esprit"));
    private ArrayList<String> sciencesHumaines_Sociales = new ArrayList(Arrays.asList("Aime aider les autres","Non-sensible","Patience","Organisé","Observateur","Relationnel","Rigueur","Capacité d’accueil","Argumenter ses choix","Responsable"));
    private ArrayList<String> lettresLangues_Enseignement = new ArrayList(Arrays.asList("Langues étrangères","Cultivé","Précis","Rigueur","Souplesse","Pédagogue","Curieux","Etre informé des nouveautés","Rapidité d’exécution","Etre à l’écoute"));
    private ArrayList<String> electricite_Electronique = new ArrayList(Arrays.asList("Habile","Précautionneux","Méthodique","Polyvalent","Observateur","Rigueur","Mobile","Attentif","Sens de l’espace","Etre informé des nouveautés"));
    private ArrayList<String> environnement_Energies_Amenagement = new ArrayList(Arrays.asList("Travail d’équipe","Polyvalent","Organisé","Aimer la nature","Expression orale","Capacité d’accueil","Protection de l’environnement","Engagement","Redaction"));
    private ArrayList<String> architecture = new ArrayList(Arrays.asList("Artistique","Adaptable","Réactif","Résistance","Organisé","Vivacité d’esprit","Cultivé","Pédagogue","Maitrise dessin","Créatif"));
    private ArrayList<String> fonctionProduction = new ArrayList(Arrays.asList("Vision globale","Adaptable","Gérer situation","Capacité d’animation","Prendre des décisions","Relationnel","Etre à l’écoute","Diplomate","Langues étrangères","Polyvalent"));
    private ArrayList<String> fonctionTransport = new ArrayList(Arrays.asList("Attentif","Reflexes","Ponctualité","Courtois","Mobile","Serviable","Connaissance mécanique","Bonne santé","Aime nouvelles technologies"));
    private ArrayList<String> genieCivil_Construction = new ArrayList(Arrays.asList("Responsable","Diplomate","Ingéniosité","Organisé","Initiative","Force de proposition","Rigueur","Responsable","Condition physique","Relationnel"));
    private ArrayList<String> gestionEntreprise = new ArrayList(Arrays.asList("Résistance","Autonome","Rigueur","Convaincant","Innovateur","Initiative","Polyvalent","Dynamique","Relationnel","Etre à l’écoute" ));
    private ArrayList<String> hotellerie_Restauration_Tourisme = new ArrayList(Arrays.asList("Relationnel","Accueillant","Etre à l’écoute","Réactif","Serviable","Disponible","Rigueur","Polyvalent","Initiative","Présentation irréprochable"));
    private ArrayList<String> informatique = new ArrayList(Arrays.asList("Adaptable","Analyse","Organisé","Rigueur","Autonome","Travail d’équipe","Relationnel","Innovateur","Langues étrangères","Aime nouvelles technologies"));
    private ArrayList<String> mecanique = new ArrayList(Arrays.asList("Connaissance mécanique","Rigueur","Responsable","Travail d’équipe","Relationnel","Organisé","Condition physique","Initiative"));
    private ArrayList<String> sante = new ArrayList(Arrays.asList("Travailleur","Résistance","Non-sensible","Organisé","Autonome","Rigueur","Initiative","Esprit de synthèse","Vivacité d’esprit","Aime aider les autres"));
    private ArrayList<String> sport = new ArrayList(Arrays.asList("Travailleur","Se surpasser","Résistance","Compétition","Rigueur","Sociologie","Corps humain","Aimer se dépenser","Passionné","Condition physique"));
    private ArrayList<String> sciences = new ArrayList(Arrays.asList("Analyse","Esprit de synthèse","Précis","Curieux","Patience","Adaptable","Organisé","Rigueur","Travailleur","Redaction"));


    public Domaines (){
        this.domaines = new HashMap<String,ArrayList<String>>();
        this.domaines.put("Agriculture", this.agriculture_Agronome);
        this.domaines.put("Arts", this.arts);
        this.domaines.put("Banque Assurance Immobiler", this.banque_Assurance_Immobiler);
        this.domaines.put("Commerce", this.commerce);
        this.domaines.put("Defense publique", this.defensePublique);
        this.domaines.put("Science politique", this.economie_Droit_SciencePo);
        this.domaines.put("Droit", this.economie_Droit_SciencePo);
        this.domaines.put("Economie", this.economie_Droit_SciencePo);
        this.domaines.put("Sciences Humaines", this.sciencesHumaines_Sociales);
        this.domaines.put("Enseignement", this.lettresLangues_Enseignement);
        this.domaines.put("Lettres Langues", this.lettresLangues_Enseignement);
        this.domaines.put("Electricité", this.electricite_Electronique);
        this.domaines.put("Energie", this.environnement_Energies_Amenagement);
        this.domaines.put("Energie renouvelable", this.environnement_Energies_Amenagement);
        this.domaines.put("Environnement", this.environnement_Energies_Amenagement);
        this.domaines.put("Architecture", this.architecture);
        this.domaines.put("Fonction Production", this.fonctionProduction);
        this.domaines.put("Fonction Transport", this.fonctionTransport);
        this.domaines.put("Génie civil", this.genieCivil_Construction);
        this.domaines.put("Gestion entreprise", this.gestionEntreprise);
        this.domaines.put("Management", this.gestionEntreprise);
        this.domaines.put("Hotellerie Restauration Tourisme", this.hotellerie_Restauration_Tourisme);
        this.domaines.put("Informatique", this.informatique);
        this.domaines.put("Mécanique", this.mecanique);
        this.domaines.put("Sante", this.sante);
        this.domaines.put("Medecine", this.sante);
        this.domaines.put("Obstetrique", this.sante);
        this.domaines.put("Infirmier", this.sante);
        this.domaines.put("Chirurgie", this.sante);
        this.domaines.put("Sport", this.sport);
        this.domaines.put("Mathématique", this.sciences);
        this.domaines.put("Physique chimie", this.sciences);
        this.domaines.put("Biologie", this.sciences);
        this.domaines.put("Géologie", this.sciences);
        
}
     
    public String getCompetence(String nomDomaine, int competence){
        return this.domaines.get(nomDomaine).get(competence);
    }
 
    public ArrayList<String> getAllCompetence(String domaine){
        return this.domaines.get(domaine);
    }
 
    public int comparaison(List<Competence> userC, String NomDomaineC) {
        int res = 0;
        ArrayList<String> domaineC = this.getAllCompetence(NomDomaineC);
        
        for (int i=0 ; i < userC.size() ; i++) {
            String d = userC.get(i).toString();
            //Creation du stream
            Stream<String> competenceDomaine;
            competenceDomaine = domaineC.stream();
            //Stream qui contient le resultat
            Optional<String> resultat;
            resultat = competenceDomaine.parallel().filter(s -> s.equals(d)).findFirst();
            if(resultat.isPresent()) {
                res += 1;
                System.out.println(res);
            }
        }
        return res;
    }   
}
