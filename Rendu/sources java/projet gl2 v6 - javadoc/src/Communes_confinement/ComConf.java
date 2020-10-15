package Communes_confinement;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ComConf.
 */
public class ComConf extends Commune {

	/** The date confinement. */
	protected Date dateConfinement;
	
	/** The duree previsionelle. */
	protected int dureePrevisionelle;
	
	/**
	 * Instantiates a new com conf.
	 *
	 * @param codePostal the code postal
	 * @param departement the departement
	 * @param region the region
	 * @param dateConfinement the date confinement
	 * @param dureePrevisionelle the duree previsionelle
	 */
	public ComConf(int codePostal, int departement, String region, Date dateConfinement, int dureePrevisionelle) {
		super(codePostal, departement, region);
		this.dateConfinement = dateConfinement;
		this.dureePrevisionelle = dureePrevisionelle;
		super.setEstConfinee(true);
	}
	
	/**
	 * Gets the date confinement.
	 *
	 * @return the date confinement
	 */
	public Date getDateConfinement() {
		return dateConfinement;
	}
	
	/**
	 * Sets the date confinement.
	 *
	 * @param dateConfinement the new date confinement
	 */
	public void setDateConfinement(Date dateConfinement) {
		this.dateConfinement = dateConfinement;
	}
	
	/**
	 * Gets the duree previsionelle.
	 *
	 * @return the duree previsionelle
	 */
	public int getDureePrevisionelle() {
		return dureePrevisionelle;
	}
	
	/**
	 * Sets the duree previsionelle.
	 *
	 * @param dureePrevisionelle the new duree previsionelle
	 */
	public void setDureePrevisionelle(int dureePrevisionelle) {
		this.dureePrevisionelle = dureePrevisionelle;
	}
	
	/**
	 * Gets the duree confinement actuelle.
	 *
	 * @return the duree confinement actuelle
	 */
	@SuppressWarnings("deprecation")
	public int getDureeConfinementActuelle()
	{
		Date today = new Date();
		return(this.dateConfinement.getDate()-today.getDate());
	}
	
	/**
	 * Override To string.
	 *
	 * 
	 */
	@Override
	public String toString() {
		return "ComConf [dateConfinement=" + dateConfinement + ", dureePrevisionelle=" + dureePrevisionelle
				+ ", codePostal=" + codePostal + ", nbNouveauContamine24h=" + nbNouveauContamine24h + ", nbDeces24h="
				+ nbDeces24h + ", departement=" + departement + ", region=" + region + ", nbGuerison24h="
				+ nbGuerison24h + ", liste_historique=" + liste_historique + "]";
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateConfinement == null) ? 0 : dateConfinement.hashCode());
		result = prime * result + dureePrevisionelle;
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComConf other = (ComConf) obj;
		if (dateConfinement == null) {
			if (other.dateConfinement != null)
				return false;
		} else if (!dateConfinement.equals(other.dateConfinement))
			return false;
		if (dureePrevisionelle != other.dureePrevisionelle)
			return false;
		return true;
	}
	
	
	
}
