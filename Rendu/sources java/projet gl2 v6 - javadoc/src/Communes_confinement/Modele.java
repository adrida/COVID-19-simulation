package Communes_confinement;

import java.util.ArrayList;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class Modele.
 */
public class Modele {
	
	/** The nom pays. */
	protected String nomPays;
	final int green = 10;
	final int orange = 50;	
	
	/** The list comconf. */
	protected ArrayList<ComConf> list_comconf = new ArrayList<ComConf>();
	
	/** The list comnonconf. */
	protected ArrayList<ComNonConf> list_comnonconf = new ArrayList<ComNonConf>();
	
	/** All comunes (AC) */
	protected ArrayList<Commune> AC = new ArrayList<Commune>();
	
	/**
	 * Instantiates a new modele.
	 *
	 * @param nomPays the nom pays
	 */
	public Modele(String nomPays) {
		this.nomPays = nomPays;
		
		//Ces communes sont ajoutees uniquement pour le bien de la demo dans le but de faire des essais plus rapidement
		this.ajouterCommune(75001, 75, "IDF");
		this.ajouterCommune(75002, 75, "IDF");
		this.ajouterCommune(75003, 75, "IDF");
		this.ajouterCommune(75004, 75, "IDF");
		this.ajouterCommune(75005, 75, "IDF");
		this.ajouterCommune(75006, 75, "IDF");
	}

	
	/**
	 * Update AC.
	 */
	public void updateAC()
	{
		AC.clear();
		for (int i = 0; i < this.list_comnonconf.size(); i++)
		{
			AC.add((Commune)list_comnonconf.get(i));
		}
		for (int i = 0; i < this.list_comconf.size(); i++)
		{
			AC.add((Commune)list_comconf.get(i));
		}
	}
	
	/**
	 * Gets the All communes to string.
	 *
	 * @return the AC string
	 */
	public ArrayList<String> get_AC_String()
	{
		updateAC();
		ArrayList<String> tab = new ArrayList<String>();
		for (int i = 0; i < this.getAC().size(); i++)
		{
			tab.add(Integer.toString(this.getAC().get(i).getCodePostal()));
		}
		return tab;
	}	
	
	/**
	 * Gets the com conf string.
	 *
	 * @return the com conf string
	 */
	public ArrayList<String> get_comConf_String()
	{
		ArrayList<String> tab = new ArrayList<String>();
		for (int i = 0; i < this.comConf().size(); i++)
		{
			tab.add(Integer.toString(this.comConf().get(i).getCodePostal()));
		}
		return tab;
	}
	
	/**
	 * Gets the com non conf string.
	 *
	 * @return the com non conf string
	 */
	public ArrayList<String> get_comNonConf_String()
	{
		ArrayList<String> tab = new ArrayList<String>();
		for (int i = 0; i < this.comNonConf().size(); i++)
		{
			tab.add(Integer.toString(this.comNonConf().get(i).getCodePostal()));
		}
		return tab;
	}
	
	/**
	 * Gets the ac.
	 *
	 * @return the ac
	 */
	public ArrayList<Commune> getAC()
	{
		updateAC();
		return AC;
	}
	
	/**
	 * Com conf.
	 *
	 * @return the array list
	 */
	public ArrayList<ComConf> comConf()
	{
		return list_comconf;
	}
	
	/**
	 * Com non conf.
	 *
	 * @return the array list
	 */
	public ArrayList<ComNonConf> comNonConf()
	{
		return list_comnonconf;
	}
	
	/**
	 * Confiner.
	 *
	 * @param date the date
	 * @param c the c
	 * @param duree_prevue the duree prevue
	 */
	public void confiner(Date date, Commune c, int duree_prevue)
	{
		if (!c.estConfinee)
		{
			ArrayList<Historique> listehistorique = c.getListe_historique();
			int cp = c.getCodePostal();
			int dep = c.getDepartement();
			String reg = c.getRegion();
			ComConf c1 = new ComConf(cp, dep, reg, date, duree_prevue);
			c1.setListe_historique(listehistorique);
			c1.get_histolist_string();
			c1.get_histolist_id();

			this.supprimerCommune(c); // suppression de la liste comnonconf
			list_comconf.add(c1);
		}
		 updateAC();
	}
	
	/**
	 * Deconfiner.
	 *
	 * @param date the date
	 * @param c the c
	 */
	public void deconfiner(Date date, Commune c)
	{
		if (c.estConfinee == true)
		{
			ArrayList<Historique> listehistorique = c.getListe_historique();
			int cp = c.getCodePostal();
			int dep = c.getDepartement();
			String reg = c.getRegion();
			ComNonConf c1 = new ComNonConf(cp, dep, reg, date);
			c1.setListe_historique(listehistorique);
			c1.get_histolist_string();
			c1.get_histolist_id();
			this.supprimerCommune(c); // suppression de la liste comnonconf
			list_comnonconf.add(c1);
		}
		 updateAC();
	}
	
	/**
	 * Gets the colors.
	 *
	 * @return the colors
	 */
	//genere le fichier avec les couleurs sous le format CP : Couleur (ex : "75004 : VERT")
	public void get_colors()
	{
		try {
	     FileWriter writer = new FileWriter("col.csv");

		for (int i = 0; i < this.AC.size(); i++)
		{
			if (AC.get(i).getNbNouveauContamine24h() < green)
			{
				writer.write(AC.get(i).getCodePostal() + " : VERT\n");
			}
			else
				if(AC.get(i).getNbNouveauContamine24h() >= green && AC.get(i).getNbNouveauContamine24h() < orange)
				{
					writer.write(AC.get(i).getCodePostal() + " : ORANGE\n");
				}
				else
				{
					writer.write(AC.get(i).getCodePostal() + " : ROUGE\n");
				}
		}
		writer.close();
		}
		catch (IOException e){
		      e.printStackTrace();
		}
	}

	/**
	 * Ajouter commune.
	 *
	 * @param codePostal the code postal
	 * @param departement the departement
	 * @param region the region
	 * @return the int
	 */
	public int ajouterCommune(int codePostal, int departement, String region) 
	{
		/*Par defaut une nouvelle commune est consideree deconfinee
		et sa date de dernier deconfinement n'est pas intialisee*/
		if (!this.get_AC_String().contains(Integer.toString(codePostal)) &&
				!(codePostal <= 10000 || departement <= 0 || codePostal > 99999 || departement > 100)
				)
		{
	        ComNonConf c = new ComNonConf(codePostal, departement, region, null);
	        this.list_comnonconf.add(c);
	        updateAC();
			return 1;
		}
		return 0;
	}

	/**
	 * Supprimer commune.
	 *
	 * @param c the c
	 * @return the int
	 */
	public int supprimerCommune(Commune c)
	{
		for (int i = 0; i < this.list_comconf.size(); i++)
		{
			if (c.codePostal == list_comconf.get(i).codePostal)
			{
				this.list_comconf.remove(i);
				updateAC();

				return 1;
			}
		}
		for (int i = 0; i < this.list_comnonconf.size(); i++)
		{
			if (c.codePostal == list_comnonconf.get(i).codePostal)
			{
				this.list_comnonconf.remove(i);
				updateAC();

				return 1;
			}
		}

		return 0;
		
	        
	}
	
	/**
	 * Gets the nom pays.
	 *
	 * @return the nom pays
	 */
	public String getNomPays() {
		return nomPays;
	}


	/**
	 * Sets the nom pays.
	 *
	 * @param nomPays the new nom pays
	 */
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}


	/**
	 * Gets the list comconf.
	 *
	 * @return the list comconf
	 */
	public ArrayList<ComConf> getList_comconf() {
		return list_comconf;
	}


	/**
	 * Sets the list comconf.
	 *
	 * @param list_comconf the new list comconf
	 */
	public void setList_comconf(ArrayList<ComConf> list_comconf) {
		this.list_comconf = list_comconf;
	}


	/**
	 * Gets the list comnonconf.
	 *
	 * @return the list comnonconf
	 */
	public ArrayList<ComNonConf> getList_comnonconf() {
		return list_comnonconf;
	}


	/**
	 * Sets the list comnonconf.
	 *
	 * @param list_comnonconf the new list comnonconf
	 */
	public void setList_comnonconf(ArrayList<ComNonConf> list_comnonconf) {
		this.list_comnonconf = list_comnonconf;
	}


	/**
	 * Sets the ac.
	 *
	 * @param aC the new ac
	 */
	public void setAC(ArrayList<Commune> aC) {
		AC = aC;
	}


	/**
	 * Carte colore tau.
	 *
	 * @param date the date
	 */
	//++
	public void carteColoreTau(Date date)
	{
		
	}
	
	/**
	 * Carte fortement connexe.
	 *
	 * @return the array list
	 */
	//++
	public ArrayList<ArrayList<ComNonConf>> carteFortementConnexe()
	{
		return new  ArrayList<ArrayList<ComNonConf>>();
	}
	
		
	

	    
	/**
	 * Modifier commune.
	 *
	 * @param c the c
	 * @param codePostal the code postal
	 * @param departement the departement
	 * @param region the region
	 */
	public void modifierCommune(Commune c, int codePostal, int departement, String region) 
	{
	        c.setCodePostal(codePostal);
	        c.setDepartement(departement);
	        c.setRegion(region);
	        updateAC();
	}
	   

}
