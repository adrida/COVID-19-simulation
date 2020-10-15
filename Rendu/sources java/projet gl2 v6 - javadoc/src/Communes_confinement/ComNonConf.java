package Communes_confinement;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ComNonConf.
 */
public class ComNonConf extends Commune {
			
			/** The date deconfinement. */
			protected Date dateDeconfinement;

			/**
			 * Instantiates a new com non conf.
			 *
			 * @param codePostal the code postal
			 * @param departement the departement
			 * @param region the region
			 * @param dateDeconfinement the date deconfinement
			 */
			public ComNonConf(int codePostal, int departement, String region, Date dateDeconfinement) {
				super(codePostal, departement, region);
				this.dateDeconfinement = dateDeconfinement;
				super.setEstConfinee(false);
			}

			/**
			 * Gets the date deconfinement.
			 *
			 * @return the date deconfinement
			 */
			public Date getDateDeconfinement() {
				return dateDeconfinement;
			}

			/**
			 * Sets the date deconfinement.
			 *
			 * @param dateDeconfinement the new date deconfinement
			 */
			public void setDateDeconfinement(Date dateDeconfinement) {
				this.dateDeconfinement = dateDeconfinement;
			}

			/**
			 * To string.
			 *
			 * @return the string
			 */
			@Override
			public String toString() {
				return "ComNonConf [dateDeconfinement=" + dateDeconfinement + ", codePostal=" + codePostal
						+ ", nbNouveauContamine24h=" + nbNouveauContamine24h + ", nbDeces24h=" + nbDeces24h
						+ ", departement=" + departement + ", region=" + region + ", nbGuerison24h=" + nbGuerison24h
						+ ", liste_historique=" + liste_historique + "]";
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
				result = prime * result + ((dateDeconfinement == null) ? 0 : dateDeconfinement.hashCode());
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
				ComNonConf other = (ComNonConf) obj;
				if (dateDeconfinement == null) {
					if (other.dateDeconfinement != null)
						return false;
				} else if (!dateDeconfinement.equals(other.dateDeconfinement))
					return false;
				return true;
			}
			
			
}
