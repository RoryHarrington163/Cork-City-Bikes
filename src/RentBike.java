import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;







public class RentBike extends Locations {
	public static void show() { 

		Stage window = new Stage();
		
		window.setMinHeight(200);
		window.setMinWidth(500);
window.setTitle(" rent Bikes ");
		window.initModality(Modality.APPLICATION_MODAL);
		Button back = new Button("go back");
		Button problemBt = new Button("Report a problem");
		Button getBike = new Button("get a bike from a location");
		
		
		getBike.setOnAction(e->{

			Locations.show();
		});
		
		problemBt.setOnAction(e->{
			ReportProblem.show();
			
		});
		
		
		
		back.setOnAction(e -> window.close());
	
		GridPane gridpane = new GridPane();
		gridpane.getStylesheets().add(("Style.css"));
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5); 
		ColumnConstraints column1 = new ColumnConstraints(100);
		ColumnConstraints column2 = new ColumnConstraints(50, 250, 300);
		column2.setHgrow(Priority.ALWAYS);

		// user chooses a bike lication a nd number of bikes 
		GridPane.setHalignment(getBike, HPos.CENTER);
		gridpane.add(getBike, 0, 0);
		
		
		GridPane.setHalignment(problemBt, HPos.CENTER);
		gridpane.add(problemBt, 0, 1);
		
		
		GridPane.setHalignment(back, HPos.LEFT);
		gridpane.add(back, 0, 4);
		
		


		// Display window and wait for it to be closed before returning
		Scene scene = new Scene(gridpane);
		window.setScene(scene);
		window.show();
	}
}
