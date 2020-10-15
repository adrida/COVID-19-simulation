package Communes_confinement;

import java.util.Date;

public class Historique {
	protected int id;
	protected int nbContamination;
	protected int nbDeces;
	protected int nbGuerison;
	protected boolean estConfine;
	protected Date date;
	public Historique(int nbContamination, int nbDeces, int nbGuerison, boolean estConfine, Date date, int id) {
		this.nbContamination = nbContamination;
		this.nbDeces = nbDeces;
		this.nbGuerison = nbGuerison;
		this.estConfine = estConfine;
		this.date = date;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbContamination() {
		return nbContamination;
	}
	public void setNbContamination(int nbContamination) {
		this.nbContamination = nbContamination;
	}
	public int getNbDeces() {
		return nbDeces;
	}
	public void setNbDeces(int nbDeces) {
		this.nbDeces = nbDeces;
	}
	public int getNbGuerison() {
		return nbGuerison;
	}
	public void setNbGuerison(int nbGuerison) {
		this.nbGuerison = nbGuerison;
	}
	public boolean isEstConfine() {
		return estConfine;
	}
	public void setEstConfine(boolean estConfine) {
		this.estConfine = estConfine;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Historique [id=" + id + ", nbContamination=" + nbContamination + ", nbDeces=" + nbDeces
				+ ", nbGuerison=" + nbGuerison + ", estConfine=" + estConfine + ", date=" + date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (estConfine ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + nbContamination;
		result = prime * result + nbDeces;
		result = prime * result + nbGuerison;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historique other = (Historique) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (estConfine != other.estConfine)
			return false;
		if (id != other.id)
			return false;
		if (nbContamination != other.nbContamination)
			return false;
		if (nbDeces != other.nbDeces)
			return false;
		if (nbGuerison != other.nbGuerison)
			return false;
		return true;
	}

	
}
