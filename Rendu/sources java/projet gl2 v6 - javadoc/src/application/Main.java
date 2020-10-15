package application;
	
import Communes_confinement.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,1900,1000);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws java.lang.IllegalStateException {
		
		launch(args);
		Modele france = new Modele("france");
		france.get_colors();
	/**	
		// TESTS DIJSKTRA VERSION RAPIDE
		//test dijkstra v2
		System.out.println("\n\n\n\n --------- TEST v2 ---------- \n\n ");

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Vertex v6 = new Vertex("F");

        v1.addNeighbour(new Edge(10, v1, v2));
        v1.addNeighbour(new Edge(15, v1, v3));

        v2.addNeighbour(new Edge(12, v2, v4));
        v2.addNeighbour(new Edge(15, v2, v6));
        
        v3.addNeighbour(new Edge(10, v3, v5));
        
        v4.addNeighbour(new Edge(2, v4, v5));
        v4.addNeighbour(new Edge(1, v4, v6));
        
        v6.addNeighbour(new Edge(5, v6, v5));

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePath(v1);

        System.out.println("To B " + dijkstra.getShortestPathTo(v2));
        System.out.println("To C " + dijkstra.getShortestPathTo(v3));
        System.out.println("To D " + dijkstra.getShortestPathTo(v4));
        System.out.println("To E " + dijkstra.getShortestPathTo(v5));
        System.out.println("To F " + dijkstra.getShortestPathTo(v6));
        System.out.println("To F " + dijkstra.getShortestPathTo(v6));
        
    	//test dijkstra v2
		System.out.println("\n\n\n\n --------- TEST v3 ---------- \n\n ");
		Commune A = new Commune(75001,0,"75001");
		Commune B = new Commune(75002,0,"75002");
		Commune C = new Commune(75003,0,"75003");
		Commune D = new Commune(75004,0,"75004");
		Commune E = new Commune(75005,0,"75005");
		Commune F = new Commune(75006,0,"75006");
		

		System.out.println("Vertex de F = " + F.getVertex().getName());
		A.lierCommune2(B,10);
		B.lierCommune2(A,10);
		A.lierCommune2(C,15);
		C.lierCommune2(A,15);
		
		B.lierCommune2(D,12);
		B.lierCommune2(F,15);		
		F.lierCommune2(B,15);

		C.lierCommune2(E, 10);
		E.lierCommune2(C, 10);
		
		D.lierCommune2(E,2);
		D.lierCommune2(F, 1);
		
		E.lierCommune2(D,2);
		F.lierCommune2(D, 1);
		
		F.lierCommune2(E, 15);
		E.lierCommune2(F, 15);
		
		System.out.println("Vertex de F = " + F.getVertex().getName());
		System.out.println("Edges de F = " + F.getVertex().getEdges());

		
		//System.out.println("Shortest path from A to F : " + A.shortestPath(F));
		//System.out.println("Shortest path from F to F : " + B.shortestPath(F));
		//System.out.println("Shortest path from B to F : " + B.shortestPath(F));
		System.out.println("Shortest path from A to C : " + A.shortestPath(C));
		System.out.println("Shortest path from A to D : " + A.shortestPath(D));
		System.out.println("Shortest path from A to E : " + A.shortestPath(E));
		System.out.println("Shortest path from A to F : " + A.shortestPath(F));
	//	System.out.println("Shortest path from F to A : " + F.shortestPath(A)); 
		
//		System.out.println("paths from F: " + F.shortestPath(B));
 **/

	}
}

























