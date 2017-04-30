import java.util.ArrayList;


public class Graphe {
    private ArrayList<Sommet> sommets;
    private ArrayList<Arete> aretes;

    /**
     * Récupérer la liste des arêtes liées au sommet
     * @param s sommet
     * @return
     */
    private ArrayList<Arete> getAreteAssociee(Sommet s){
        ArrayList<Arete> aretes = new ArrayList<Arete>();
        for (Arete arete : this.aretes){
            if (arete.isInArete(s)){
                aretes.add(arete);
            }
        }
        return aretes;
    }

    /**
     * Récupérer le degré d'un sommet (nombre d'arête d'interferance issu du sommet)
     * @param s Sommet dont on cherche le degré
     * @return
     */
    private int getSommetDegre(Sommet s){
        int degre = 0;
        ArrayList<Arete> areteAssociee = this.getAreteAssociee(s);
        for (Arete a : areteAssociee){
            if (a instanceof InterferenceArete){
                degre++;
            }
        }
        return degre;
    }

    /**
     * Récupérer le sommet dont le degré est maximal en calculant le degré de chaque sommet du graphe
     * @return
     */
    private Sommet getMaxDegre(){
        int degreMax = this.getSommetDegre(this.sommets.get(0));
        Sommet sommetMax = this.sommets.get(0);

        for (Sommet s : this.sommets){
            if (this.getSommetDegre(s) > degreMax) {
                degreMax = this.getSommetDegre(s);
                sommetMax = s;
            }
        }
        return sommetMax;
    }

    /**
     * Retourner une couleur disponible pour colorer un sommet tout en respectant les propriétés fixées
     * @param s Sommet
     * @param k Nombre de couleur
     * @return
     */
    private int getAvailableColor(Sommet s, int k){

        ArrayList<Integer> disponibles = new ArrayList<Integer>();
        // Ajouter toutes les couleurs
        for (int i = 1; i <= k; i++){
            disponibles.add(i);
        }

        ArrayList<Arete> aretesAssociee = this.getAreteAssociee(s);
        for (Arete a : aretesAssociee){
            // Si le sommet est contenu dans une arête de préférence on regarde si son voisin est coloré
            if (a instanceof PreferenceArete) {
                // Si il l'est on retourne la couleur car 2 sommets sur une arête de préférence ont la même couleur
                if (a.getOppositeSommet(s).isColored()){
                    return a.getOppositeSommet(s).getCouleur();
                }
            }

            // Si le sommet opposé est coloré et que la couleur est dans la liste des couleurs disponible, on l'enlève
            // De la liste
            if (a.getOppositeSommet(s).isColored()){
                if (disponibles.contains(a.getOppositeSommet(s).getCouleur())){
                    disponibles.remove(disponibles.indexOf(a.getOppositeSommet(s).getCouleur()));
                }
            }
        }
        return disponibles.get(0);
    }

    /**
     * Constructeur de l'objet Graphe
     * @param sommets Liste des sommets du graphe
     * @param aretes Liste des arêtes du graphe
     */
    public Graphe(ArrayList<Sommet> sommets, ArrayList<Arete> aretes){
        this.aretes = aretes;
        this.sommets = sommets;
    }

    /**
     * Arete à ajouter au Graphe
     * @param arete
     */
    public void addArete(Arete arete) {
        this.aretes.add(arete);
    }

    /**
     * Supprimer une arete d'un Graphe
     * @param arete
     * @return boolean (vrai si supprimé sinon faux)
     */
    public boolean removeArete(Arete arete){
        if(this.aretes.contains(arete)){
            return this.aretes.remove(arete);
        }
        return false;
    }

    /**
     * Supprimer un sommet du graph et ses arêtes associées
     * @param s Sommet à supprimer
     */
    public void removeSommet(Sommet s){
        // Supprimer les aretes associées
        ArrayList<Arete> areteAssociee = this.getAreteAssociee(s);

        this.sommets.remove(s);
        for (Arete a : areteAssociee) {
            this.removeArete(a);
        }
    }

    /**
     * Récupérer la liste des arêtes du Graphe
     * @return Liste des aretes du Graphe
     */
    public ArrayList<Arete> getAretes(){
        return this.aretes;
    }

    /**
     * Récupérer la liste des sommets du Graphe
     * @return Liste des sommets du Graphe
     */
    public ArrayList getSommets(){
        return this.sommets;
    }

    public void colorier(int k, Graphe graphe){
        Graphe G = new Graphe((ArrayList<Sommet>) graphe.sommets.clone(),(ArrayList<Arete>) graphe.aretes.clone());
        if(G.sommets.size() == 0){
            int i = 0;
            while(i<G.sommets.size() && G.getSommetDegre(G.sommets.get(i)) >= k){
                i++;
            }// i == G.sommets.size() || G.getSommetDegre(G.sommets.get(i)) < k

            System.out.println(G.sommets.size());

            if(!(G.sommets.size() == i)){
                Sommet s = G.sommets.get(i);//Sommet dont le degré est < k
                G.removeSommet(s);// G \ s
                this.colorier(k, G);//Appel récursif
                // Prendre une couleur disponible pour l'affecter au sommet du graphe
                s.setCouleur(graphe.getAvailableColor(s, k));
            }
            else{
                // On doit spiller dans ce cas le sommet de plus haut degré
                Sommet sommetDegreMax = G.getMaxDegre();
                G.removeSommet(sommetDegreMax);// G \ sommetDegreMax
                this.colorier(k,G);
                sommetDegreMax.spill();
            }
        }
    }
}
