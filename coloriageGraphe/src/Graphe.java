import java.util.ArrayList;


public class Graphe {
    private ArrayList<Sommet> sommets;
    private ArrayList<Arete> aretes;

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
    public void colorier(int nbCouleur, Graphe graphe){

    }
}
