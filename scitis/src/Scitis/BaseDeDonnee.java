package Scitis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BaseDeDonnee {
    
    //Constructeur qui creer le fichier et le met dans un fichier txt
    public BaseDeDonnee() {

        String fichier="1;Veux-tu faire de longues études ?;Te verrais-tu faire des études supérieures à 3 ans ?;Aimerrais-tu faire de longues études ?;null;2;2\n" +
"2;As-tu le goût des responsabilités ?;Es-tu prêt à prendre des décisions conséquentes ?;Aimes-tu prendre des responsabilités ?;7;3;3\n" +
"3;Penses-tu avoir le sens du devoir ?;Serais-tu prêt à intervenir pour aider quelqu'un ?;La justice pour toi est-elle importante ?;44;4;4\n" +
"4;Penses-tu avoir un esprit plus scientifique que littéraire ?;Aimes-tu les sciences ?;Préfères-tu étudier les sciences que la littérature ?;61;5;5\n" +
"5;Te vois-tu te déplacer pour ton travail ?;Cela te dérangerais de partir en déplacement ?;Serais-tu prêt à bouger pour ton travail ?;83;6;6\n" +
"6;Es-tu créatif ?;As-tu de l'imagination ?;As-tu déjà créé quelque chose ?;74;null;null\n" +
"\n" +
"7;Es-tu un bon orateur ?;Es-tu à l'aise à l'oral ?;Arrives-tu à capter l'attention quand tu parles ?;Expression orale;8;25\n" +
"8;Es-tu à l'aise avec les chiffres ?;Aimes-tu faire des calculs ?;Les chiffres t'amusent-ils ?;Sens des chiffres;12;9\n" +
"9;As-tu déjà travaillé sous pression ?;Te débrouilles-tu quand certaines choses ne se passent pas bien ?;As-tu déjà manqué de temps ?;null;10;11\n" +
"10;Aimes-tu cela ?;Cela te plait-il ?;Aimes-tu travailler sous pression ?;Résistance;13;11\n" +
"11;Es-tu engagé dans ce que tu entreprends ?;Portes-tu de l'intérêt à ce que tu entreprends ?;Vas-tu au bout des choses quand tu commences un projet ?;Engagement;16;14\n" +
"12;Fais-tu attention à tes dépenses ?;Regardes-tu souvent combien tu dépenses par mois ?;As-tu tendance à réfléchir à 2 fois avant d'acheter ?;null;15;14\n" +
"13;Es-tu souvent disponible ?;Accordes-tu du temps aux autres ?;Serais-tu prêt à modifier ton emplois du temps pour rendre service ?;Disponible;17;14\n" +
"14;Aimes-tu conseiller les gens autour de toi ?;Donnes-tu souvent des conseils ?;Des personnes viennent-elles te voir pour demander des conseils ?;Aimer conseiller;18;16\n" +
"15;Te tiens-tu au courant de l'actualité ?;Regardes-tu les informations ?;T'arrives-t-il de lire le journal ?;Etre informé des nouveautés;20;18\n" +
"16;T'es tu déjà dit que tu étais un animateur ?;Aimes-tu animer un évènement ?;Es-tu celui que l'on appelle quand il faut mettre l'ambiance ?;Capacité d'animation;19;13\n" +
"17;Es-tu quelqu'un qui réagit vite ?;Penses-tu avoir un esprit vif ?;As tu de bons réflexes ?;Vivacité d'esprit;1001;16\n" +
"18;Maitrises-tu les langues étrangères ?;Te débrouilles-tu en anglais ?;Aimes-tu les langues étrangères ?;Langues étrangères;21;11\n" +
"19;Es-tu à l'aise devant un public ?;Es-tu à l'aise en public ?;Oses-tu parler devant beaucoup de monde ?;Expression orale;22;14\n" +
"20;Fais-tu attention à ta présentation ?;Aimes-tu prendre soin de toi ?;Fais-tu attention à ton apparence ?;Présentation irréprochable;1006;18\n" +
"21;As-tu déjà convaincu quelqu'un de tes opinions ?;Sais-tu trouver les bons arguments ?;Penses-tu être convaincant ?;Argumenter ses choix;24;9\n" +
"22;Aimes-tu la nature ?;Aimes-tu aller à la campagne ?;Le grand air te plait-il ?;Aimer la nature;1004;23\n" +
"23;Les enjeux environnementaux te préoccupent-ils ?;Fais-tu du tri-sélectif ?;Fais-tu attention à l'environnement ?;Protection de l'environnement;1003;1002\n" +
"24;Es-tu organisé ?;Planifies-tu souvent des choses ?;Aimes-tu organiser des évènements ?;Organisé;1005;11\n" +
"25;Aimes-tu prendre soin des gens autour de toi ?;Aimes-tu aider les autres ?;T'es tu déjà occupé de quelqu'un ?;Aime aider les autres;26;27\n" +
"26;La vue du sang t'effraie-t-elle ?;As-tu peur du sang ?;Voir du sang te dérange-t-il ?;Non-sensible;28;29\n" +
"27;As-tu tendance à dire quoi faire aux autres ?;Aimes-tu donner des ordres ?;Aimes-tu diriger ?;null;38;35\n" +
"28;As-tu deja réussi à reconforter quelqu'un ?;Sais-tu remonter le moral ?;Sais-tu trouver les bons mots pour redonner le sourire ?;Aime aider les autres;31;30\n" +
"29;Aimes-tu réaliser des expériences scientifiques ?;Fais-tu attention en manipulant des produits dangereux ?;Es-tu minutieux ?;Rigueur;1013;31\n" +
"30;As-tu une forte capacité à travailler ?;Travailles-tu beaucoup ?;Pourrais-tu beaucoup travailler pour une chose qui te plait ?;Travailleur;32;27\n" +
"31;Aimes-tu les enfants ?;T'es tu déjà occupé d'enfants ?;Aimerais-tu prendre soin d'enfants ?;Aime aider les autres;34;33\n" +
"32;Le corps humain te fascine-t-il ?;Te demandes-tu comment le corps fonctionne ?;Es-tu intrigué par le corps humain ?;Corps humain;1010;29\n" +
"33;Aimerais-tu t'occuper des accouchements ?;Te verrais-tu t'occuper de la naissance d'enfants ?;Aimerais-tu t'occuper des nouveaux nés ?;Rigueur;1011;30\n" +
"34;Serais-tu prêt à fournir des soins à quelqu'un ?;Aimerais-tu soigner les autres ?;Te vois-tu apporter des soins aux personnes agées ou malades ?;Aime aider les autres;1012;33\n" +
"35;Es-tu un bon dessinateur ?;T'a ton déjà dit que tu dessinais bien ?;Sais-tu dessiner ?;Maitrise dessin;36;37\n" +
"36;Es-tu quelqu'un de créatif et innovant ?;As-tu de l'imagination ?;As-tu déjà créé quelque chose ?;Créatif;39;38\n" +
"37;Es-tu organisé ?;Aimes-tu organiser des évènements ?;Planifies-tu souvent des choses ?;Organisé;40;26\n" +
"38;Es-tu polyvalent ?;Es-tu efficaces dans plusieurs domaines ?;Sais-tu gérer plusieurs choses en même temps ?;Polyvalent;41;37\n" +
"39;Sais-tu t'adapter suivant des situations ?; Peux-tu agir différemment pour avantager une situation ?;Serais-tu prêt à t'adapter pour aider les autres ?;Adaptable;1007;37\n" +
"40;Es-tu un bon négociateur ?;Arrives-tu à obtenir quelque chose quand tu le souhaites ?;As-tu déjà négocier ?;Négociateur;41;36\n" +
"41;As-tu déjà pris des décisions importantes ?;Sais-tu peser le pour et le contre justement ?;Vient-on te demander conseil pour prendre des déicions ?;Prendre des décisions;43;42\n" +
"42;T'es tu déjà occupé d'un groupe ?;As-tu déjà eu à gérer un groupe ?;Penses-tu être capable t'occuper d'un groupe ?;Travail d'équipe;1008;37\n" +
"43;Es-tu quelqu'un de dynamique ?;T'a t-on déjà dit que tu débordais d'énergie ?;As-tu la pêche ?;Dynamique;1009;42\n" +
"\n" +
"44;T'intérresses tu à l'actualité ?;T'arrives-t-il de lire le journal ?;Regardes-tu les informations ?;Cultivé;45;46\n" +
"45;Penses-tu bien gérer ton stress ?;Penses-tu bien agir sous pression ?;As-tu déjà réussi à surmonter ton stress ?;Résistance;47;48\n" +
"46;As-tu le sentiment de vouloir aider les autres ?;Aimes-tu prendre soin des gens autour de toi ?;Prends-tu des initiatives pour aider les autres ?;Aime aider les autres;49;45\n" +
"47;Sais-tu t'exprimer à l'oral ?;Es-tu un bon orateur ?;Es-tu à l'aise à l'oral ?;Expression orale;50;48\n" +
"48;Peux-tu expliquer les choses différemment pour qu'on te comprenne ?;Sais-tu t'adapter pour qu'on te comprenne ?;Sais-tu reformuler tes idées ?;Adaptable;51;49\n" +
"49;Serais-tu prêt à te mettre en danger pour aider quelqu'un ?;Pourrais-tu prendre des risques pour aider ?;As-tu le goût du risque ?;Courage;53;52\n" +
"50;Penses-tu être ouvert d'esprit ?;Fais-tu abstraction de tes premières impressions sur une personne ?;Es-tu déjà passé outre tes préjugés ?;Ouverture d'esprit;54;55\n" +
"51;Te verrais-tu dans l'enseignement ?;Aimerais-tu apprendre à des élèves ?;Te verrais-tu enseigner à des élèves ?;Pédagogue;1017;50\n" +
"52;Penses-tu être à l'écoute des autres ?;Vient-on souvent te parler ?;Passes-tu du temps pour écouter les autres ?;Etre à l'écoute;57;56\n" +
"53;Serais-tu prêt à accorder beaucoup de temps pour ton travail ?;Penses-tu pouvoir consacrer du temps pour ton travail ?;Si tu es passioné par ton travail compterais-tu les heures ?;Disponible;1020;52\n" +
"54;As-tu une grande capacité de travail ?;Pourrais-tu beaucoup travailler pour une chose qui te plait ?;Travailles-tu beaucoup ?;Travailleur;58;48\n" +
"55;L'Economie t'interesse-t-elle ?;T'interesses-tu à l'économie du pays ?;Te verrais-tu faire des études dans l'Economie ?;Etre informé des nouveautés;1016;49\n" +
"56;La littérature et les langues t'interessent-elles ?; Lis tu beaucoup de livre ?;Aimes-tu les langues étrangères ?;Langues étrangères;1018;45\n" +
"57;Penses-tu être sensible ?;Est-ce que de nombreuses choses te touches ?;Es-tu de nature inquiète ?;null;56;1019\n" +
"58;Penses-tu avoir une bonne mémoire ?;Passes-tu beaucoup de temps à apprendre tes leçons ?;Aimes-tu les jeux de mémoires ?;Bonne mémoire;59;60\n" +
"59;Te verrais-tu travailler dans la justice ?;Aimerais-tu défendre des personnes face à la loi ?;Penses-tu pouvoir décider du sort d'une personne justement ?;Impartial;1014;60\n" +
"60;T'intérresses-tu à la politique ?;Portes-tu un grand intérêt à la politique ?;Te verrais-tu en tant que politicien ?;Diplomate;1015;48\n" +
"\n" +
"61;Es-tu à l'aise avec les nouvelles techonologies ?;Arrives-tu rapidement à prendre en main un nouvel appareil ?;Aimes-tu découvrir une nouvelle techonologie ?;Aime nouvelles technologies;62;63\n" +
"62;Le corps humain t'intrigue-t-il ?;Le corps humain te fascine-t-il ?;Te demandes-tu comment le corps fonctionne ?;Corps humain;63;65\n" +
"63;La vue du sang t'effraie-t-elle ?;Voir du sang te dérange-t-il ?;As-tu peur du sang ?;Non-sensible;67;68\n" +
"64;As-tu un esprit de compétition ?;Te mettre en compétition te fait-il peur ?;Penses-tu devoir être dans les meilleurs pour réussir ?;null;68;67\n" +
"65;Connais-tu l'algorithmie ?;Le langage informatique te parle-t-il ?;As-tu déjà entendu parler d'algorithmie ?;null;66;64\n" +
"66;Aimes-tu faire des algorithmes ?;As-tu déjà réussi à écrire un algorithme fonctionnel ?;Aimes-tu exécuter des choses pas à pas ?;null;1021;67\n" +
"67;Aimes-tu faire des expériences ?;Fais-tu attention en manipulant des produits dangereux ?;Es-tu minutieux ?;Rigueur;71;70\n" +
"68;As-tu une forte capacité de travail ?;Travailles-tu beaucoup ?;Pourrais-tu beaucoup travailler pour une chose qui te plait ?;Travailleur;69;67\n" +
"69;Aimerais-tu aider les autres ?;Prends-tu des initiatives pour aider les autres ?;T'es tu déjà occupé de quelqu'un ?;Aime aider les autres;1025;67\n" +
"70;As-tu le sens des chiffres ?;Les chiffres t'amusent-ils ?;Aimes-tu faire des calculs ?;Sens des chiffres;1026;65\n" +
"71;L'Etude de la nature t'interesse-t-elle ?;Aimerais-tu étudier la faune et la flore ?;L'étude des sols t'interresse-t-elle ?;Aimer la nature;1022;73\n" +
"72;Es-tu intérressé par la physique ou la chimie ?;Les molécules ou les forces t'intriguent-elles ?;Aimes-tu faire des expériences ?;Précis;1024;70\n" +
"73;La génétique t'intéresse-t-elle ?;Les animaux et leurs agissements t'intriguent-ils ?;Te demandes-tu comment les corps fonctionnent ?;Curieux;1023;72\n" +
"\n" +
"74;Penses-tu être patient ?;Peux-tu attendre patiemment ?;Peux-tu rester dans une salle d'attente sans rien faire ?;Patience;75;76\n" +
"75;Sais-tu t'exprimer de différentes manières ?;Arrive-t-on à te comprendre quand tu t'exprimes de plusieurs manières ?;Penses-tu être pédagogue ?;Adaptable;77;78\n" +
"76;Es-tu résistant au stress ?;As-tu déjà réussi à surmonter ton stress ?;Penses-tu bien agir sous pression ?;Résistance;78;75\n" +
"77;Penses-tu être observateur ?;Fais-tu attention aux choses qui t'entourent ?;T'a t-on déjà dit que tu avais des yeux de lynx ?;Observateur;79;76\n" +
"78;Es-tu pédagogue ?;Penses-tu pouvoir transmettre tes connaissances ?;T'a t-on déjà dit que tu étais pédagogue ?;Pédagogue;80;77\n" +
"79;As-tu un esprit critique ?;Es-tu capable de faire des critiques constructives ?;Peux-tu expliquer pourquoi tu n'es pas en accord avec d'autres personnes ?;null;81;80\n" +
"80;As-tu déjà imaginé designer des meubles, objets ou autres ?;As-tu déjà voulu modifier des affaires à toi ?;T'a-t-on déjà dit que tu avais de bonnes idées ?;null;1007;77\n" +
"81;Aimes-tu dessiner ?;Quand tu t'ennuis as-tu tendance à attraper une feuille et un crayon ?;T'a-t-on déjà dit que tu dessinais bien ?;Maitrise dessin;82;78\n" +
"82;Pourrais-tu en faire un métier ?;Penses-tu pouvoir vivre de tes oeuvres ?;Te verrais-tu travailler dans l'art ?;null;1035;80\n" +
"\n" +
"83;Es-tu observateur ?;T'a t-on déjà dit que tu avais des yeux de lynx ?;Fais-tu attention aux choses qui t'entourent ?;Observateur;85;84\n" +
"84;Penses-tu être organisé ?;Planifies-tu souvent des choses ?;Aimes-tu organiser des évènements ?;Organisé;87;86\n" +
"85;As-tu de bon réflexes ?;Es-tu réactif ?;Réussis-tu à attraper des objets en vol ?;Reflexes;88;87\n" +
"86;Penses-tu être compétitif ?;Penses-tu devoir être dans les meilleurs pour réussir ?;Te mettre en compétition te fait-il peur ?;Compétition;89;87\n" +
"87;As-tu un bon sens du relationnel ?;Es-tu à l'aise quand tu parles à des inconnus ?;Es-tu chaleureux avec les gens autour de toi ?;Relationnel;91;90\n" +
"88;Es-tu ponctuel ?;Trouves-tu que arriver à l'heure est important ?;Dois-tu attendre les autres à un rendez-vous ?;Ponctualité;92;87\n" +
"89;Es-tu résistant à la fatigue ?;As-tu déjà fait des nuits blanches ?;Es-tu souvent le dernier à aller te coucher ?;Résistant;93;90\n" +
"90;Penses-tu être polyvalent ?;Peux-tu faire plusieurs choses en même temps ?;Es-tu efficaces dans plusieurs domaines ?;Polyvalent;94;96\n" +
"91;Es-tu prêt à prendre des décisions conséquentes ?;Aimes-tu te sentir utile ?;As-tu le goût des responsabilités ?;Responsable;92;96\n" +
"92;Aimes-tu manipuler des machines ?;Te verrais-tu conduire des camions ?;Te verrais-tu conduire des véhicules de chantier ?;Attentif;97;98\n" +
"93;Aimes-tu la nature ?;Le grand air te plait-il ?;Aimes-tu aller à la campagne ?;Aimer la nature;99;100\n" +
"94;Aimes-tu les langues étrangères ?;Regardes-tu des films ou des séries dans d'autres langues ?;Les langues t'interessent-elles ?;Langues étrangères;95;89\n" +
"95;Es-tu à l'écoute des autres ?;Passes-tu du temps pour écouter les autres ?;Vient-on souvent te parler ?;Etre à l'écoute;101;87\n" +
"96;Es-tu rigoureux ?;Penses-tu être pointilleux ?;Vas-tu au bout de tes projets ?;Rigueur;92;95\n" +
"97;Aimes-tu travailler en équipe ?;Penses-tu que travailler avec des personnes est intéressant ?;As-tu déjà travaillé en équipe ?;Travail d'équipe;1031;1032\n" +
"98;Penses-tu être diplomate ?;Peux-tu gérer des conflits ?;Te poses-tu avant d'agir ?;Diplomate;1033;1034\n" +
"99;Pourrais-tu vivre de tes récoltes ?;Te verrais-tu travailler dans l'agriculture ?;Travailler en pleine nature te plairait-il ?;null;1027;95\n" +
"100;Te verrais-tu pratiquer un sport tout les jours ?;Aimes-tu te dépenser ?;Penses-tu que le sport est important pour toi ?;Aimer se dépenser;1028;95\n" +
"101;Aimes-tu faire des calculs ?;As-tu le sens des chiffres ?;Les chiffres t'amusent-ils ?;Sens des chiffres;102;1030\n" +
"102;Penses-tu être convaincant ?;Sais-tu trouver les bons arguments ?;As-tu déjà réussi à convaincre quelqu'un ?;Convaincant;1029;92\n" +
"\n" +
"1001;Hotellerie Restauration Tourisme\n" +
"1002;Energie\n" +
"1003;Energie renouvelable\n" +
"1004;Environnement\n" +
"1005;Commerce\n" +
"1006;Banque Assurance Immobiler\n" +
"1007;Architecture\n" +
"1008;Management\n" +
"1009;Gestion entreprise\n" +
"1010;Medecine\n" +
"1011;Obstetrique\n" +
"1012;Infirmier\n" +
"1013;Chirurgie\n" +
"1014;Droit\n" +
"1015;Science politique\n" +
"1016;Economie\n" +
"1017;Enseignement\n" +
"1018;Lettres Langues\n" +
"1019;Sciences Humaines\n" +
"1020;Defense publique\n" +
"1021;Informatique\n" +
"1022;Géologie\n" +
"1023;Biologie\n" +
"1024;Physique chimie\n" +
"1025;Sante\n" +
"1026;Mathématique\n" +
"1027;Agriculture\n" +
"1028;Sport\n" +
"1029;Commerce\n" +
"1030;Fonction Production\n" +
"1031;Mécanique\n" +
"1032;Fonction Transport\n" +
"1033;Génie civil\n" +
"1034;Electricité\n" +
"1035;Arts\n" +
"9999;Tu pourrais peut-être réessayer plus tard\n" +
"\n" +
"Hotellerie Restauration Tourisme;oui;BTS : tourisme, hôtellerie-restauration;Écoles hôtelières\n" +
"Hotellerie Restauration Tourisme;non;BTS : hôtellerie-restauration, tourisme\n" +
"Energie;oui;Prépa MPSI;DUT: Génie thermique et énergie;Licences: Maîtrise de l'énergie et des énergies renouvelables, Valorisation des énergies renouvelables et techniques énergétiques, Science et technologies des énergies renouvelables;Master: Génie des systèmes industriels – spécialité énergies solaires, Système énergétique et énergies renouvelables;Ecoles d'ingénieurs dans les énergies\n" +
"Energie;non;DUT: Génie thermique et énergie;Licences: Maîtrise de l'énergie et des énergies renouvelables, Valorisation des énergies renouvelables et techniques énergétiques, Science et technologies des énergies renouvelables\n" +
"Energie renouvelable;oui;Prépa MPSI;DUT: Génie thermique et énergie;Licences: Maîtrise de l'énergie et des énergies renouvelables, Valorisation des énergies renouvelables et techniques énergétiques, Science et technologies des énergies renouvelables;Master: Génie des systèmes industriels – spécialité énergies solaires, Système énergétique et énergies renouvelables;Ecoles d'ingénieurs dans les énergies renouvelables\n" +
"Energie renouvelable;non;DUT: Génie thermique et énergie;Licences: Maîtrise de l'énergie et des énergies renouvelables, Valorisation des énergies renouvelables et techniques énergétiques, Science et technologies des énergies renouvelables\n" +
"Environnement;oui;BTS: HPE, FEE;BTSA GEMEAU;DUT: génie biologique option environnement, HSE;Ecoles d'ingénieurs spécialisées dans l'environnement\n" +
"Environnement;non;BTS: HPE, FEE;BTSA GEMEAU;DUT: génie biologique option environnement, HSE;Licence STER\n" +
"Commerce;oui;DUT: GEA, TC;BTS: MUC, NRC, CI, TC;Licence AES;Master IAE;Ecoles de commerce\n" +
"Commerce;non;DUT: GEA, TC;BTS: MUC, NRC, CI, TC;Licence AES;Ecoles de commerce\n" +
"Banque Assurance Immobiler;oui;BTS: banque, assurances, NRC, MUC;DUT: CJ, TC;Ecoles supérieures de commerce;Licence: Assurance, Banque, Finance spécialité Chargé de clientèle;Master MBA\n" +
"Banque Assurance Immobiler;non;BTS: banque, assurances, NRC, MUC;Licence Assurance, Banque, Finance spécialité Chargé de clientèle;DUT: CJ, TC\n" +
"Architecture;oui;Ecoles nationales supérieures d'architecture\n" +
"Architecture;non;Il n'y a pas d'études courtes;Je peux donc te proposer les écoles nationales supérieures d'architecture\n" +
"Management;oui;BTS: technico-commercial, MUC;DUT: Gaco;Licence: métiers de l'information et de la communication;Ecoles de communication : Celsa, ECS, Iscom, CFJ\n" +
"Management;non;BTS: technico-commercial, MUC;DUT: Gaco;Licence: métiers de l'information et de la communication\n" +
"Gestion entreprise;oui;DUT: GEA;Licence: AES;Master AGE, MBA;Ecoles de commerce et de gestion\n" +
"Gestion entreprise;non;DUT: GEA;Licence: AES;Ecoles de commerce et de gestion\n" +
"Medecine;oui;PACES;Suite des études de médecine à la fac\n" +
"Medecine;non;Licence: santé;PACES\n" +
"Obstetrique;oui;PACES;PCEM2;DCEM1,2,3,4\n" +
"Obstetrique;non;Il n'y a pas d'études courtes;Je peux donc te proposer: PACES;PCEM2;DCEM1,2,3,4\n" +
"Infirmier;oui;Instituts de formation aux soins infirmiers\n" +
"Infirmier;non;Instituts de formation aux soins infirmiers\n" +
"Chirurgie;oui;PACES;DES;DESC\n" +
"Chirurgie;non;Il n'y a pas d'études courtes;Je peux donc te proposer:PACES;DES;DESC\n" +
"Droit;oui;DUT: Carrières juridiques;Licence de droits;Master de droits;Doctorat de droits\n" +
"Droit;non;DUT: Carrières juridiques;Licence de droits\n" +
"Science politique;oui;Science Po (diplôme en 5 ou 8ans);ENA\n" +
"Science politique;non;Science Po (diplôme en 3ans)\n" +
"Economie;oui;DUT: GEA, TC;BTS: MUC, NRC, CI, TC;Licence AES;Master IAE\n" +
"Economie;non;DUT: GEA, TC;BTS: MUC, NRC, CI, TC;Licence AES\n" +
"Enseignement;oui;Licence dans la matière que tu souhaites enseigner;Master au sein de l'ESPE: MEEF, CRPE, CAPES\n" +
"Enseignement;non;Il n'y a pas d'études courtes;Je peux donc te proposer: Licence dans la matière que tu souhaites enseigner;Master au sein de l'ESPE: MEEF, CRPE, CAPES\n" +
"Lettres Langues;oui;Filières à la fac: Lettres classiques, lettres modernes et sciences du langage;Prépa ENS;Ecoles spécialisées en lettre et langues\n" +
"Lettres Langues;non;Filières à la fac: Lettres classiques, lettres modernes et sciences du langage\n" +
"Sciences Humaines;oui;Filières à la fac pour l'histoire, la géographie, la philosophie, la psychologie et la sociologie;Ecoles : EHESS, Ecole Doctorale Sciences Humaines et Sociales\n" +
"Sciences Humaines;non;Filières à la fac pour l'histoire, la géographie, la philosophie, la psychologie et la sociologie\n" +
"Defense publique;oui;IHEDN;BSPP;BMPM;Les écoles militaires;Ecoles de polices\n" +
"Defense publique;non;IHEDN;BSPP;BMPM;Les écoles militaires;Ecoles de polices\n" +
"Informatique;oui;DUT: Informatique, GEII, STID;BTS: systèmes numériques, option informatique et réseaux;Licence en sciences et technologies, mention informatique;Master: MIAGE;Ecoles d'ingénieurs et d'informatique\n" +
"Informatique;non;DUT: Informatique, GEII, STID;BTS: systèmes numériques, option informatique et réseaux;Licence en sciences et technologies, mention informatique\n" +
"Géologie;oui;BTS: géologie appliquée;Masters dans les domaines des sciences de la Terre et de l'Univers, des géosciences, ou de l'environnement avec spécialisations en géologie ou géologie appliquée;Ecoles d'ingénieurs spécialisées en géologie\n" +
"Géologie;non;BTS géologie appliquée\n" +
"Biologie;oui;Prépa BCPST;Licence de biologie;Master de biologie;Ecoles d'ingénieurs en biologie\n" +
"Biologie;non;Licence de biologie;Ecoles d'ingénieurs en biologie\n" +
"Physique chimie;oui;Licences en sciences et technologies spécialité physique/chimie;Prépa: PC, PSI, BCPST;Ecoles d'ingénieurs\n" +
"Physique chimie;non;Licences en sciences et technologies spécialité physique/chimie;Ecoles d'ingénieurs\n" +
"Sante;oui;PACES;Suite des études de médecine à la fac\n" +
"Sante;non;Licence santé;PACES\n" +
"Mathématique;oui;Licences en mathématique;Master en mathématique et sciences informatiques;Prépa MPSI;Ecoles d'ingénieurs comme ENSIMAG, EISTI\n" +
"Mathématique;non;Licences en mathématique;Ecoles d'ingénieurs comme ENSIMAG, EISTI\n" +
"Agriculture;oui;Prépa agro-véto, TB;Ecoles de la FESIA;Autres écoles d'ingénieurs en Agronomie\n" +
"Agriculture;non;Les BTSA\n" +
"Sport;oui;STAPS;Le BEES;Le BPJEPS;Ecoles spécialisées dans le sport\n" +
"Sport;non;STAPS;Le BEES;Le BPJEPS\n" +
"Fonction Production;oui;BTSA Sciences et technologies des aliments;DUT Génie de conditionnement et d'emballage;Ecoles spécialisées dans la fonction production\n" +
"Fonction Production;non;BTSA Sciences et technologies des aliments;DUT Génie de conditionnement et d'emballage\n" +
"Mécanique;oui;BTS: CPI, CIM, constructions métalliques, CIRA, maintenance et après-vente des engins de travaux publics, mise en forme des matériaux par forgeage, fonderie;DUT: GIM, GMP, sciences et génie des matériaux\n" +
"Mécanique;non;BTS: CPI, CIM, constructions métalliques, CIRA, maintenance et après-vente des engins de travaux publics, mise en forme des matériaux par forgeage, fonderie;DUT: GIM, GMP, sciences et génie des matériaux\n" +
"Fonction Transport;oui;BTS Transport et prestations logistiques;DUT gestion logistique et transport\n" +
"Fonction Transport;non;BTS Transport et prestations logistiques;DUT gestion logistique et transport\n" +
"Génie civil;oui;DUT Génie civil;Licence en génie civil;Master en génie civil;Prépa ATS;Ecoles d'ingénieurs spécialisées en génie civil\n" +
"Génie civil;non;DUT Génie civil;Licence en génie civil\n" +
"Electricité;oui;BTS: domotique, électrotechnique;Licence électricité et électronique;Masters: génie électrique et informatique industrielle, gestion et transformation de l'énergie électrique, électrotechnique;CFA d'EDF;Ecoles d'ingénieurs spécialisées en électricité\n" +
"Electricité;non;BTS domotique, électrotechnique;Licence électricité et électronique;CFA d'EDF\n" +
"Arts;oui;Les écoles d'Arts;Licences: Arts, Lettres et Arts;Master en Art, Arts et médias numériques, Art contemporain et nouveaux médias\n" +
"Arts;non;Les écoles d'Arts;Licences: Arts, Lettres et Arts";
        try {
            System.out.println(fichier);
            FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/"+ "Question.txt", false);
            BufferedWriter output = new BufferedWriter(fw);
            output.write(fichier);
            output.flush();
            output.close();
            System.out.println("fichier créé");
	} catch(IOException ioe){
            System.out.print("Erreur : ");
            ioe.printStackTrace();
	}
    }


    public static List<String> rechercherNoeud(String numNoeud) {
        return rechercherNoeud(numNoeud, false, "");
    }

    //Methode qui permet de chercher dans le fichier texte LE noeud interessant
    //Retourne la ligne du noeud à exploiter
    public static List<String> rechercherNoeud(String numNoeud, boolean isApplet, String linesParameter){
        List<String> mot = null;
        try {
                String str;
                Stream<String> lines;
                if(isApplet) {
                    lines = Stream.of(linesParameter);
                } else {
                    lines = Files.lines(FileSystems.getDefault().getPath(System.getProperty("user.dir") + "/"+ "Question.txt"));
                }

                Optional<String> hasPassword = lines.filter(s -> s.startsWith(numNoeud)).findFirst();
                if(hasPassword.isPresent()){
                    str = hasPassword.get();
                    mot = Arrays.asList(str.split(";"));
                }
                //Close the stream and it's underlying file as well
                lines.close();
            } catch (Exception e){
                System.out.println(e.toString());
        }
        return(mot);
    }
    
    //Methode qui permet de chercher dans le fichier texte LE noeud interessant
    //Retourne la ligne du noeud à exploiter
    public static List<String> rechercherEtude(String nomDomaine, String typeEtude){
        List<String> mot = null;
	try {
            String str;
            Stream<String> lines;
            lines = Files.lines(FileSystems.getDefault().getPath(System.getProperty("user.dir") + "/"+ "Question.txt"));
            Optional<String> hasPassword = lines.filter(s -> s.startsWith(nomDomaine) && s.contains(typeEtude)).findFirst();
            if(hasPassword.isPresent()){
                str = hasPassword.get();
                mot = Arrays.asList(str.split(";"));
            }
            //Close the stream and it's underlying file as well
            lines.close();
        } catch (Exception e){
        	System.out.println(e.toString());
	}
        return(mot);
    }
    
}
