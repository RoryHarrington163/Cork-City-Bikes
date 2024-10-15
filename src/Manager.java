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
	
public class Manager extends returnBike  {


	// should only be available to a manager  account 
		public static void show() { 
			
			Stage window = new Stage();
			window.setTitle("manager");
			window.setMinHeight(200);
			window.setMinWidth(500);
	
			window.initModality(Modality.APPLICATION_MODAL);
			Button close = new Button("go back");
			close.setOnAction(e -> window.close());
			GridPane gridpane = new GridPane();
			gridpane.getStylesheets().add(("Style.css"));

			
				Label log = new Label("The money made today" + TheCost);				
			
		
		       
		        
		        
		       // Button button5 = new Button();
			GridPane.setHalignment(close, HPos.CENTER);
			gridpane.add(close, 0, 0);
			
			GridPane.setHalignment(log, HPos.CENTER);
			gridpane.add(log, 2, 1);


			getuserTopUp();
			 

				gridpane.getChildren().addAll();
				
		

				Scene scene = new Scene(gridpane);
			
			
			window.setScene(scene);
			window.show();
			
	      
	      
	      }
	


}
