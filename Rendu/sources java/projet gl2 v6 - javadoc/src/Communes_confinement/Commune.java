package Communes_confinement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import Dijkstra_v2.*;


// TODO: Auto-generated Javadoc
/**
 * The Class Commune.
 */
public class Commune {

	/** The code postal. */
	protected int codePostal;
	
	/** The departement. */
	protected int departement;
	
	/** The region. */
	protected String region;
	
	/** The nb nouveau contamine 24 h. */
	protected int nbNouveauContamine24h = 0;
	
	/** The nb deces 24 h. */
	protected int nbDeces24h = 0;
	
	/** The nb guerison 24 h. */
	protected int nbGuerison24h = 0;


	/** The est confinee. */
	protected boolean estConfinee = false;
	
	/** The nbhisto. */
	protected int nbhisto = 0;
	
	/** The nb communes liees. */
	protected int nbCommunesLiees = 0;
	
	/** The vertex. */
	protected Vertex vertex = new Vertex(Integer.toString(this.codePostal));
	
	/** The liste historique. */
	protected ArrayList<Historique> liste_historique = new ArrayList<Historique>();
	
	/** The histo tab str. */
	protected ArrayList<String> histoTabStr = new ArrayList<String>();
	
	/** The histo tabid. */
	protected ArrayList<String> histoTabid = new ArrayList<String>();
	
							/**
							 *  Constructeur *.
							 *
							 * @param codePostal the code postal
							 * @param departement the departement
							 * @param region the region
							 */
	
	public Commune(int codePostal, int departement, String region) {
		
			this.codePostal = codePostal;
			this.departement = departement;
			this.region = region;
			this.vertex = new Vertex(Integer.toString(this.codePostal));

		}
	
	// Methodes


		//Handle Historique

			/**
	 * Creer un historique.
	 *
	 * @param nbContamination the nb contamination
	 * @param nbDeces the nb deces
	 * @param nbGuerison the nb guerison
	 * @param date the date
	 */
	// A voir pour le estConfine s'il est possible de recuperer le statut dans la classe fille
			public void creerUnHistorique(int nbContamination, int nbDeces, int nbGuerison, Date date)
			{
				int			last = this.liste_historique.size();
				int tem = 0;
				for (int i = 0; i < liste_historique.size(); i++)
				{
					Historique	h1 = new Historique(nbContamination,nbDeces, nbGuerison, this.estConfinee, date, this.nbhisto-1);
		
					if (liste_historique.get(i).getDate().equals(h1.getDate()))
					{		
						tem = 1;
						liste_historique.remove(i);
						liste_historique.add(h1);
					}
				}	
				
				if (tem == 0)
				{
					Historique	h1 = new Historique(nbContamination,nbDeces, nbGuerison, this.estConfinee, date, this.nbhisto);
					liste_historique.add(h1);
					if (last != this.liste_historique.size())
						this.nbhisto++;
					
				}
	
				last = this.liste_historique.size();
				if (last >= 2)
				{
					this.setNbDeces24h(this.liste_historique.get(last-1).getNbDeces()
							- this.liste_historique.get(last-2).getNbDeces());
					this.setNbNouveauContamine24h(this.liste_historique.get(last-1).getNbContamination()
							- this.liste_historique.get(last-2).getNbContamination());
					this.setNbGuerison24h(this.liste_historique.get(last-1).getNbGuerison()
							- this.liste_historique.get(last-2).getNbGuerison());
				}
				
				get_histolist_string();
				get_histolist_id();
			}
			
			
			/**
			 * Gets the histolist id.
			 *
			 * @return the histolist id
			 */
			public void get_histolist_id()
			{
				
					for (int i = 0; i < this.getListe_historique().size(); i++)
					{
						this.histoTabid.add(Integer.toString(getListe_historique().get(i).getId()));
					}
					Set<String> set = new HashSet<>(histoTabid);
					histoTabid.clear();
					histoTabid.addAll(set);
					histoTabid.sort(null);
				
			}
			
			
			
			/**
			 * Gets the histolist string.
			 *
			 * @return the histolist string
			 */
			public void get_histolist_string()
			{
				for (int i = 0; i < this.getListe_historique().size(); i++)
				{
					this.histoTabStr.add("Historique #" + getListe_historique().get(i).getId() + "\n Date : " + this.getListe_historique().get(i).getDate().toString());
				}
				Set<String> set = new HashSet<>(histoTabStr);
				histoTabStr.clear();
				histoTabStr.addAll(set);
				histoTabStr.sort(null);
			}
	
	
			//Lier Commune
	
				//Handle Disjkstra


				/**
			 * Lier commune 2.
			 *
			 * @param c the c
			 * @param dist the dist
			 * @return the int
			 */
			public int lierCommune2(Commune c, int dist)
				{
					if (c.isEstConfinee() == false)
					{
						vertex.addNeighbour(new Edge(dist, vertex, c.getVertex()));
						nbCommunesLiees++;
						return 1;
					}
					return 0;
				}
	
				/**
				 * Shortest path.
				 *
				 * @param c the Commune
				 * @return the list
				 */
				public List<Vertex> shortestPath(Commune c)
				{
			        Dijkstra dijkstra = new Dijkstra();
			        dijkstra.computePath(this.vertex);
			        return (dijkstra.getShortestPathTo(c.getVertex()));
				}
	
	
	//Getters - Setter - Overrides

		/**
	 * Gets the histo tab str.
	 *
	 * @return the histo tab str
	 */
	public ArrayList<String> getHistoTabStr() {
			return histoTabStr;
		}
	
		/**
		 * Sets the histo tab str.
		 *
		 * @param histoTabStr the new histo tab str
		 */
		public void setHistoTabStr(ArrayList<String> histoTabStr) {
			this.histoTabStr = histoTabStr;
		}
	
		/**
		 * Gets the nbhisto.
		 *
		 * @return the nbhisto
		 */
		public int getNbhisto() {
			return nbhisto;
		}
	
		/**
		 * Sets the nbhisto.
		 *
		 * @param nbhisto the new nbhisto
		 */
		public void setNbhisto(int nbhisto) {
			this.nbhisto = nbhisto;
		}
	
		/**
		 * Gets the nb histo.
		 *
		 * @return the nb histo
		 */
		public int get_nb_histo()
		{
			return this.getListe_historique().size();
		}
		
		/**
		 * Gets the code postal.
		 *
		 * @return the code postal
		 */
		public int getCodePostal() {
			return codePostal;
		}
	
		/**
		 * Sets the code postal.
		 *
		 * @param codePostal the new code postal
		 */
		public void setCodePostal(int codePostal) {
			this.codePostal = codePostal;
		}
	
		/**
		 * Gets the nb nouveau contamine 24 h.
		 *
		 * @return the nb nouveau contamine 24 h
		 */
		public int getNbNouveauContamine24h() {
			return nbNouveauContamine24h;
		}
	
		/**
		 * Sets the nb nouveau contamine 24 h.
		 *
		 * @param nbNouveauContamine24h the new nb nouveau contamine 24 h
		 */
		public void setNbNouveauContamine24h(int nbNouveauContamine24h) {
			this.nbNouveauContamine24h = nbNouveauContamine24h;
		}
	
		/**
		 * Gets the nb deces 24 h.
		 *
		 * @return the nb deces 24 h
		 */
		public int getNbDeces24h() {
			return nbDeces24h;
		}
	
		/**
		 * Sets the nb deces 24 h.
		 *
		 * @param nbDeces24h the new nb deces 24 h
		 */
		public void setNbDeces24h(int nbDeces24h) {
			this.nbDeces24h = nbDeces24h;
		}
	
		/**
		 * Gets the departement.
		 *
		 * @return the departement
		 */
		public int getDepartement() {
			return departement;
		}
	
		/**
		 * Sets the departement.
		 *
		 * @param departement the new departement
		 */
		public void setDepartement(int departement) {
			this.departement = departement;
		}
	
		/**
		 * Gets the region.
		 *
		 * @return the region
		 */
		public String getRegion() {
			return region;
		}
	
		/**
		 * Sets the region.
		 *
		 * @param region the new region
		 */
		public void setRegion(String region) {
			this.region = region;
		}
	
		/**
		 * Gets the nb guerison 24 h.
		 *
		 * @return the nb guerison 24 h
		 */
		public int getNbGuerison24h() {
			return nbGuerison24h;
		}
	
		/**
		 * Sets the nb guerison 24 h.
		 *
		 * @param nbGuerison24h the new nb guerison 24 h
		 */
		public void setNbGuerison24h(int nbGuerison24h) {
			this.nbGuerison24h = nbGuerison24h;
		}
	
		/**
		 * Checks if is est confinee.
		 *
		 * @return true, if is est confinee
		 */
		public boolean isEstConfinee() {
			return estConfinee;
		}
	
		/**
		 * Sets the est confinee.
		 *
		 * @param estConfinee the new est confinee
		 */
		public void setEstConfinee(boolean estConfinee) {
			this.estConfinee = estConfinee;
		}
	
		/**
		 * Gets the liste historique.
		 *
		 * @return the liste historique
		 */
		public ArrayList<Historique> getListe_historique() {
			return liste_historique;
		}
	
		/**
		 * Sets the liste historique.
		 *
		 * @param liste_historique the new liste historique
		 */
		public void setListe_historique(ArrayList<Historique> liste_historique) {
			this.liste_historique = liste_historique;
		}
	
	
		/**
		 * Gets the vertex.
		 *
		 * @return the vertex
		 */
		public Vertex getVertex() {
			return vertex;
		}
	
		/**
		 * Sets the vertex.
		 *
		 * @param vertex the new vertex
		 */
		public void setVertex(Vertex vertex) {
			this.vertex = vertex;
		}
		
		/**
		 * Gets the nb communes liees.
		 *
		 * @return the nb communes liees
		 */
		public int getNbCommunesLiees() {
			return nbCommunesLiees;
		}

		/**
		 * Sets the nb communes liees.
		 *
		 * @param nbCommunesLiees the new nb communes liees
		 */
		public void setNbCommunesLiees(int nbCommunesLiees) {
			this.nbCommunesLiees = nbCommunesLiees;
		}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codePostal;
		return result;
	}



	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commune other = (Commune) obj;
		if (codePostal != other.codePostal)
			return false;
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "\nCommune [\ncodePostal=" + codePostal + ", nbNouveauContamine24h=" + nbNouveauContamine24h
				+ ", nbDeces24h=" + nbDeces24h + ", departement=" + departement + ", region=" + region
				+ ", nbGuerison24h=" + nbGuerison24h + ", estConfinee=" + estConfinee + ", liste_historique="
				+ liste_historique +"\n]\n";
	}

	// Redefinitions
	
	
	
}
