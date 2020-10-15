package application;


import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Communes_confinement.*;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;


// TODO: Auto-generated Javadoc
/**
 * The Class SampleController.
 */
public class SampleController implements Initializable{
	

	/** Objet France. */
	protected Modele france = new Modele("France");
	


		/** Boutton ajout commune. */
		public Button boutton_ajout_commune;
		
		/** Boutton suppr commune. */
		public Button boutton_suppr_commune;
		
		/** Boutton modif commune. */
		public Button boutton_modif_commune;
		
		/** Boutton ajout historique. */
		public Button boutton_ajout_historique;
		
		/** Boutton afficher historique. */
		public Button boutton_afficher_historique;
		
		/** Boutton stats. */
		public Button boutton_stats;
		
		/** Boutton confiner. */
		public Button boutton_confiner;
		
		/** Boutton deconfiner. */
		public Button boutton_deconfiner;
		
		/** Boutton lier. */
		public Button boutton_lier;
		
		/** Boutton selectionner. */
		public Button boutton_selectionner;
		
		/** Boutton generer dijkstra. */
		public Button genererDijkstra;
		
		/**  historique disp. */
		public Label historiqueDisp;
		
		/**  disp commune selectionnee. */
		public Label dispCommuneSelectionnee;
		
		/**  link success. */
		public Label linkSuccess;
		
		/**  link disp. */
		public Label linkDisp;
	    
    	/**  detailscomulabel. */
    	public Label detailscomulabel;
	    
    	/**  dpt. */
    	public Label dpt;
	    
    	/**  regionlabel. */
    	public Label regionlabel;
	    
    	/**  nbclabel. */
    	public Label nbclabel;
	    
    	/**  nbdlabel. */
    	public Label nbdlabel;
	    
    	/**  nbglabel. */
    	public Label nbglabel;
	    
    	/**  statutlabel. */
    	public Label statutlabel;
	    
    	/**  nbhistolabel. */
    	public Label nbhistolabel;
	    
    	/**  details histo. */
    	public Label detailsHisto;
	    
    	/**  details H date. */
    	public Label detailsHDate;
	    
    	/**  details H nbc. */
    	public Label detailsHNbc;
	    
    	/**  details H nbd. */
    	public Label detailsHNbd;
	    
    	/**  details H nbg. */
    	public Label detailsHNbg;
	    
    	/**  date details. */
    	public Label dateDetails;
	    
    	/**  resultat dijkstra. */
    	public Label resultatDijkstra;
		
		/**  input ajout commune codepostal. */
		public TextField input_ajout_commune_codepostal;
		
		/**  nb jours prevus confinement. */
		public TextField nb_jours_prevus_confinement;
		
		/**  input ajout commune dep. */
		public TextField input_ajout_commune_dep;
		
		/**  input ajout commune region. */
		public TextField input_ajout_commune_region;
		
		/**  cp historique input. */
		public TextField cp_historique_input;
		
		/**  nb C. */
		public TextField nbC;
		
		/**  nb D. */
		public TextField nbD;
		
		/**  nb G. */
		public TextField nbG;
		
		/**  day. */
		public TextField day;
		
		/**  month. */
		public TextField month;
		
		/**  year. */
		public TextField year;
		
		/**  commune lier commune. */
		public TextField communeLierCommune;
		
		/**  distance lier commune. */
		public TextField distanceLierCommune;
		
		/**  commune depart. */
		public TextField communeDepart;
		
		/**  commune arivee. */
		public TextField communeArivee;
		
		/**  date historique. */
		public DatePicker dateHistorique;
		
		/**  cp. */
		protected String cp;
		
		/**  liste communes. */
		public ListView<String> liste_communes;
		
		/**  liste historiques. */
		public ListView<String> liste_historiques;
		
		/**  table communes. */
		public TableView<Commune> table_communes;
		
		/**  col code postal. */
		public TableColumn<Commune, Integer> col_code_postal;
		
		/**  col statut. */
		public TableColumn<Commune, Boolean> col_statut;
		
		/**  col nb histo. */
		public TableColumn<Commune, Integer> col_nb_histo;
		
		/**  col nb links. */
		public TableColumn<Commune, Integer> col_nbLinks;
		
		/**  pie chart 1. */
		public PieChart pieChart1;
		
		/**  area chart. */
		public AreaChart<String,Integer> areaChart;
		
		/**  comnonconf str. */
		protected ArrayList<String> comnonconf_str = france.get_comNonConf_String();
		
		/**  comconf str. */
		protected ArrayList<String> comconf_str = france.get_comConf_String();
		
		/**  ac str. */
		protected ArrayList<String> ac_str = france.get_AC_String();
		
		/**  histo str. */
		protected ArrayList<String> histo_str = new ArrayList<String>();
		
		/**  listprops. */
		protected ListProperty<String> listprops = new SimpleListProperty<>();
		
		/**  listprops 1. */
		protected ListProperty<String> listprops1 = new SimpleListProperty<>();
		
		/**  list tab. */
		public ObservableList<Commune> listTab = get_communes_list();
		
		/**  web view. */
		public WebView webView;

	
	/**
	 * Gets the france.
	 *
	 * @return the france
	 */
	public Modele getFrance() {
		return france;
	}
	
	//getter setters

	/**
	 * Sets the france.
	 *
	 * @param france the new france
	 */
	public void setFrance(Modele france) {
		this.france = france;
	}
	
	/**
	 * Gets the cp.
	 *
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Sets the cp.
	 *
	 * @param cp the new cp
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	
	//Divers 
	
	/**
	 * Gets the communes list.
	 *
	 * @return the communes list
	 */
	public ObservableList<Commune> get_communes_list()
	{
			ObservableList<Commune> liste = FXCollections.observableArrayList((france.getAC()));

		return liste;

	}
	
	/**
	 * Gets the date.
	 *
	 * @param d the d
	 * @param m the m
	 * @param y the y
	 * @return the date
	 */
	@SuppressWarnings("deprecation")
	public Date getDate(String d, String m, String y)
	{
		Date date = new Date();
		date.setYear(Integer.parseInt(y));
		date.setMonth(Integer.parseInt(m));
		date.setDate(Integer.parseInt(d));
		return date;
	}
	
	
	
	/**
	 * Refresh list view.
	 */
	public void	refreshListView()
	{
		//communes
		
			// - listview
		
				ac_str = france.get_AC_String();
				comconf_str = france.get_comConf_String();
				comnonconf_str = france.get_comNonConf_String();
				listprops.set(FXCollections.observableArrayList(ac_str));
				
			// - tabview
				
				listTab.removeAll(listTab);
				listTab = get_communes_list();
				table_communes.setItems(listTab);
		
	}
	
	/**
	 * Refresh historique.
	 */
	public void refreshHistorique()
	{
		String selected = liste_communes.getSelectionModel().getSelectedItem().toString();
		for (int i = 0; i < france.getAC().size(); i++)
		{
			if (selected.equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
					{
						histo_str = france.getAC().get(i).getHistoTabStr();
					}
		}		
	}

	/**
	 * Gets the histo id.
	 *
	 * @param str the str
	 * @return the histo id
	 */
	public int getHistoId(String str)
	{
		String tmp;
		int i = 12;
		while (str.charAt(i+1) != '\n' && str.charAt(i) != '\0')
			i++;
		tmp = str.substring(12, (i+1));
		return Integer.parseInt(tmp);
	}



	/**
	 * Handle generer stats.
	 *
	 * @param event the event
	 */
	@SuppressWarnings("deprecation")
	public void handleGenererStats(ActionEvent event)
	{
		ObservableList<PieChart.Data> pieChartData =
				FXCollections.observableArrayList(
						new PieChart.Data("Confinee ", france.getList_comconf().size()),
						new PieChart.Data("Non confinee",france.getList_comnonconf().size())
						);
		pieChart1.setData(pieChartData);
		
		areaChart.getData().clear();
		String bigSelected = liste_communes.getSelectionModel().getSelectedItem().toString();
		
		XYChart.Series<String,Integer> serieC = new XYChart.Series<String,Integer>();
		XYChart.Series<String,Integer>  serieD = new XYChart.Series<String,Integer>();
		XYChart.Series<String,Integer>  serieG = new XYChart.Series<String,Integer>();
		serieC.setName("Nombre de contaminations");
		serieD.setName("Nombre de deces");
		serieG.setName("Nombre de guerisons");

		for (Commune c : france.getAC())
		{
			if (bigSelected.equals(Integer.toString(c.getCodePostal()) ))
			{
				for (Historique h : c.getListe_historique())
				{
						serieC.getData().add(new XYChart.Data<String, Integer>((Integer.toString(h.getDate().getDay()) + "/" +Integer.toString(h.getDate().getMonth()) + "/" +Integer.toString(h.getDate().getYear()) ),h.getNbContamination()));
						serieD.getData().add(new XYChart.Data<String, Integer>((Integer.toString(h.getDate().getDay()) + "/" +Integer.toString(h.getDate().getMonth()) + "/" +Integer.toString(h.getDate().getYear()) ),h.getNbDeces()));
						serieG.getData().add(new XYChart.Data<String, Integer>((Integer.toString(h.getDate().getDay()) + "/" +Integer.toString(h.getDate().getMonth()) + "/" +Integer.toString(h.getDate().getYear()) ),h.getNbGuerison()));
				}
			}

		}
		areaChart.getData().add(serieC);
		areaChart.getData().add(serieD);
		areaChart.getData().add(serieG);
	}
	
	/**
	 * Handle afficher historique.
	 *
	 * @param event the event
	 */
	public void handleAfficherHistorique(ActionEvent event)
	{
		String selected = liste_communes.getSelectionModel().getSelectedItem().toString();
		for (int i = 0; i < france.getAC().size(); i++)
		{
			if (selected.equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
					{
						histo_str = france.getAC().get(i).getHistoTabStr();
					}
		}		
		listprops1.set(FXCollections.observableArrayList(histo_str));
		historiqueDisp.setText("Historique pour : " + selected);
		refreshHistorique();

	}
	
	/**
	 * Handle lier commune.
	 *
	 * @param event the event
	 */
	public void handleLierCommune(ActionEvent event)
	{
		
		try {
		String com = null;
		int dist = 0;
		int indice = 0;
		int tem = 0;
		@SuppressWarnings("unused")
		int tem2 = 0;
		com = communeLierCommune.getText();
		dist = Integer.parseInt(distanceLierCommune.getText());
		
		for (int i = 0; i < france.getAC().size(); i++)
		{
			if (com.equals(Integer.toString(france.getAC().get(i).getCodePostal())))
					{
						indice = i; // On recupere l'indice de la commune que l'on veut lier
					}
		}		
		String selected = liste_communes.getSelectionModel().getSelectedItem().toString();
		linkDisp.setText("Lier une commune a : " + selected);

		for (int i = 0; i < france.getAC().size(); i++)
		{
			//recherche de la commune selectionnee dans la listview
			if (com.equals(Integer.toString(france.getAC().get(i).getCodePostal())))
					{
						tem2 = 1;
					}
		}
		for (int i = 0; i < france.getAC().size(); i++)
		{
			//recherche de la commune selectionnee dans la listview
			if (selected.equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
					{
						tem = france.getAC().get(i).lierCommune2(france.getAC().get(indice),dist);
						tem = france.getAC().get(indice).lierCommune2(france.getAC().get(i),dist);
					}
		}
		
		if (tem == 1)
		{
			linkSuccess.setText("Ajout de : " + communeLierCommune.getText() + " aux liens de " + selected);

		}
		else
			linkSuccess.setText("Vous ne pouvez pas ajouter cette commune aux liens de " + selected);
		}catch(Exception e) {
			linkSuccess.setText("Echec de l'ajout, verifiez qu'une commune est bien selectionnee\n"
					+ "ou que la commune a ajouter existe ");

		}
		refreshListView();
		refreshHistorique();
	}
	
	/**
	 * Handle selection.
	 *
	 * @param event the event
	 */
	public void	handleSelection(ActionEvent event)
	{
		String selected = liste_communes.getSelectionModel().getSelectedItem().toString();
		
		 int nbNouveauContamine24h = 0;
		 int nbDeces24h = 0;
		 int departement = 0;
		 String region = null;
		boolean estConfinee = false;

		 int nbGuerison24h = 0;
		 int nbhisto = 0;
		 @SuppressWarnings("unused")
		int dureeconf = 0;
		 dureeconf = 0;
		refreshHistorique();
		linkDisp.setText("Lier une commune a : " + selected);
		historiqueDisp.setText("Historique pour : " + selected);
		dispCommuneSelectionnee.setText("Commune selectionnee : " + selected);
		for (int i = 0; i < france.getAC().size(); i++)
		{
			if (selected.equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
					{
					departement = france.getAC().get(i).getDepartement();
					region =  france.getAC().get(i).getRegion();
					nbNouveauContamine24h = france.getAC().get(i).getNbNouveauContamine24h();
					nbDeces24h = france.getAC().get(i).getNbDeces24h();
					nbGuerison24h = france.getAC().get(i).getNbGuerison24h();
					estConfinee = france.getAC().get(i).isEstConfinee();
					nbhisto = france.getAC().get(i).get_nb_histo();
					for(ComConf c : france.comConf())	
						if (estConfinee && Integer.toString(c.getCodePostal()).equals(selected))
							dureeconf = c.getDureePrevisionelle();
						}
		}	
		detailscomulabel.setText("Commune : " + selected);
		dpt.setText("Departement : " + departement );
		regionlabel.setText("Region : " + region.toString());
		nbclabel.setText("Nombre de contamines sur les dernieres 24h : " + nbNouveauContamine24h);
		nbdlabel.setText("Nombre de deces sur les dernieres 24h : " + nbDeces24h );
		nbglabel.setText("Nombre de guerisons sur les dernieres 24h : " + nbGuerison24h);
		statutlabel.setText("Statut : " + (estConfinee ? "Confinee" : "Non confinee"));
		//dateDetails.setText("Date de " + (estConfinee ? "confinenement pour une duree de " + dureeconf + " jours" : "dernier confinement : "  ));
		nbhistolabel.setText("Nombre d'historiques renseignés : " + nbhisto);
		listprops1.set(FXCollections.observableArrayList(histo_str));
		
	}
	
	
	/**
	 * Handle details historique.
	 *
	 * @param event the event
	 */
	@SuppressWarnings("deprecation")
	public void handleDetailsHistorique(ActionEvent event)
	{
		String bigSelected = liste_communes.getSelectionModel().getSelectedItem().toString();

		String selected = liste_historiques.getSelectionModel().getSelectedItem().toString();

		for (int i = 0; i < france.getAC().size(); i++)
		{
			if (bigSelected.equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
			{

				for (int j = 0; j < france.getAC().get(i).getListe_historique().size(); j++)
				{


					if (getHistoId(selected) == (france.getAC().get(i).getListe_historique().get(j).getId()))
					{
						//Historique trouve ! 
						detailsHisto.setText("Historique #" + france.getAC().get(i).getListe_historique().get(j).getId());
					    detailsHDate.setText("Date : " + france.getAC().get(i).getListe_historique().get(j).getDate().toLocaleString());
					    detailsHNbc.setText("Nombre de contaminations : " + france.getAC().get(i).getListe_historique().get(j).getNbContamination() );
					    detailsHNbd.setText("Nombre de deces : " + france.getAC().get(i).getListe_historique().get(j).getNbDeces());
					    detailsHNbg.setText("Nombre de guerisons : " + france.getAC().get(i).getListe_historique().get(j).getNbGuerison());
					}
				}
			}

		}
		refreshHistorique();
		refreshListView();

	}
	
	/**
	 * Handle confiner.
	 */
	public void handle_confiner()
	{
		String selected = liste_communes.getSelectionModel().getSelectedItem().toString();
		Date date = new Date();
		for (int i = 0; i < france.getAC().size(); i++)
		{
			if (selected.equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
					{
						france.confiner(date, france.getAC().get(i), Integer.parseInt(nb_jours_prevus_confinement.getText()));
						refreshListView();
					}
		}
		refreshListView();

	}
	
	/**
	 * Handle deconfiner.
	 */
	public void handle_deconfiner()
	{
		String selected = liste_communes.getSelectionModel().getSelectedItem().toString();
		Date date = new Date();

		for (int i = 0; i < france.getAC().size(); i++)
		{
			if (selected.equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
					{
						france.deconfiner(date,france.getAC().get(i));
						refreshListView();
					}
		}	
		refreshListView();

	}
	
	/**
	 * Saisir historique.
	 */
	@SuppressWarnings("unlikely-arg-type")
	public void saisir_historique()
	{
	//	Date today = new Date();
		ZoneId defaultZoneId = ZoneId.systemDefault();

		 Date date = Date.from(dateHistorique.getValue().atStartOfDay(defaultZoneId).toInstant());
		this.setCp(cp_historique_input.getText());
		if(!france.getAC().contains(Integer.parseInt(cp_historique_input.getText())))
		{
			for (int i = 0; i < france.getAC().size(); i++)
			{
				if(cp.equals(Integer.toString(france.getAC().get(i).getCodePostal())))
						{
							france.getAC().get(i).creerUnHistorique(Integer.parseInt(nbC.getText()),
									Integer.parseInt(nbD.getText()),
									Integer.parseInt(nbG.getText()),
									date);
						}
			}
		}
		refreshListView();
	}

	/**
	 * Handle suppr.
	 */
	public void handleSuppr()
	{
		String selected = liste_communes.getSelectionModel().getSelectedItem().toString();
		for (int i = 0; i < france.getAC().size(); i++)
		{
			if (selected.equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
					{
						france.supprimerCommune(france.getAC().get(i));
						refreshListView();
					}
		}		
	}
	
	/**
	 * Handle ajout commune.
	 */
	public void handleAjoutCommune()
	{

		try {
			int cp = Integer.parseInt(input_ajout_commune_codepostal.getText());
			int dep = Integer.parseInt(input_ajout_commune_dep.getText());;
			String reg = input_ajout_commune_region.getText();
			if (france.ajouterCommune(cp, dep, reg) == 0)
				{
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Echec de l'ajout de la commune !");
					errorAlert.setContentText("La commune n'a pas pu etre ajoutee, elle est peut etre deja presente.");
					errorAlert.showAndWait();
				}
			else 
				{
					refreshListView();
				}
				
		}catch(NumberFormatException e){
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Echec de l'ajout de la commune !");
				errorAlert.setContentText("Le code postal ou le departement n'a pas le bon format");
				errorAlert.showAndWait();
	     }
	}
	
	/**
	 * Handle generer.
	 *
	 * @param event the event
	 */
	public void handleGenerer(ActionEvent event)
	{
		try {
			int c1=0;
			int c2=0;
			String res = "test";
			for (int i = 0; i < france.getAC().size(); i++)
			{
				//recherche de la commune 
				if (communeDepart.getText().equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
						{
							c1 = i;
							//c1 = france.getAC().get(i);
						}
			}
			
			for (int i = 0; i < france.getAC().size(); i++)
			{
				//recherche de la commune 
				if (communeArivee.getText().equals(Integer.toString(france.getAC().get(i).getCodePostal()) ))
						{
							c2 = i;
							//c2 = france.getAC().get(i);
						}
			}
	
			res = "Chemin : " + france.getAC().get(c1).shortestPath(france.getAC().get(c2)); 
			resultatDijkstra.setText(res);
		}catch(Exception e)
		{
			resultatDijkstra.setText("Les communes n'existent pas ou ne sont pas liees");
		}
	}
	
	/**
	 * Initialize.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
				// TODO Auto-generated method stub
				
		
		
				//LISTVIEW COMMUNES

				liste_communes.itemsProperty().bind(listprops);
				listprops.set(FXCollections.observableArrayList(ac_str));


				liste_historiques.itemsProperty().bind(listprops1);
				listprops1.set(FXCollections.observableArrayList(histo_str));


				//TABVIEW COMMUNES
				col_code_postal.setCellValueFactory(new PropertyValueFactory<Commune,Integer>("codePostal"));
				col_nbLinks.setCellValueFactory(new PropertyValueFactory<Commune,Integer>("nbCommunesLiees"));
				col_statut.setCellValueFactory(new PropertyValueFactory<Commune,Boolean>("estConfinee"));
				col_statut.setCellFactory
				(
						tc -> new TableCell<Commune,Boolean>()
							{	
								@Override
								protected void updateItem(Boolean item, boolean empty)
								{
									super.updateItem(item,empty);
									setText(empty ? null : item ? "Confinee" : "Non confinee");
								}
							}
				);

				col_nb_histo.setCellValueFactory(new PropertyValueFactory<Commune,Integer>("nbhisto"));
				table_communes.setItems(listTab);
				table_communes.getColumns().clear();
				table_communes.getColumns().add(col_code_postal);
				table_communes.getColumns().add(col_statut);
				table_communes.getColumns().add(col_nb_histo);
				table_communes.getColumns().add(col_nbLinks);
				
				WebEngine engine = webView.getEngine();
		        engine.load(getClass().getResource("./testMapJs/index.html").toString());
		        
				
		}

	
}



































