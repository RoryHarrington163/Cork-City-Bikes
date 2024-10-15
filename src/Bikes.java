import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.application.*;

public class Bikes  extends Locations{

//  available to a customer account 
	public static void show() { 
		
		Stage window = new Stage();
		window.setTitle("choose Bikes rent or return");
		window.setMinHeight(200);
		window.setMinWidth(500);
// This makes sure that it dosent load , windows pop up from errors 
		window.initModality(Modality.APPLICATION_MODAL);
		Button close = new Button("go back");
		close.setOnAction(e -> window.close());
		GridPane gridpane = new GridPane();
	
	
	        Button reportProblem = new Button("report a problem");
	        Button returnaBike = new Button();
	        Button rentaBike = new Button();
	        Button button4 = new Button(); 
	        Button button5 = new Button();

		
		returnaBike.setOnAction(e -> returnBike.show());
		
		rentaBike.setOnAction(e-> Locations.show());
		reportProblem.setOnAction(e->{
			ReportProblem.show();
		});
		

		 gridpane.getStylesheets().add(("Style.css"));
		 	rentaBike.setText("Rent bike");
	        returnaBike.setText("return bike");
	        

			
			GridPane.setHalignment(close, HPos.LEFT);
			gridpane.add(close, 1, 0);
			gridpane.add(returnaBike,1,2);
			gridpane.add(rentaBike,1,3);
			gridpane.add(reportProblem,1,4);
	
			
			Scene  scene = new Scene(gridpane, 500, 400);
			
		
		
		window.setScene(scene);
		window.show();
		
      
      
      }
}

