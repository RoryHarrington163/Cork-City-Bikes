
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ReportProblem {
static String bikecode;
static String userReport;
	public static void show() { // passing 2 parameters, title and label
		
		
		
		Stage window = new Stage();
		window.setTitle("Report a problem");
		window.setMinHeight(200);
		window.setMinWidth(500);
// This makes sure that it dosent load , windows pop up from errors 
		window.initModality(Modality.APPLICATION_MODAL);

		Label label = new Label(); // passed in as a parameter
		Button close = new Button("Close");
		Button submit = new Button("submit");
		Label lblbikenumber = new Label("enter in bike number");
		TextField bikenumber = new TextField();
		bikenumber.setPromptText("enter your bike number");
		Button signin = new Button("sign in");
		signin.setOnAction(e->{
			PinSIgnIN.show();
		});
	
		bikecode = (bikenumber.getText());
		 
		TextField problem = new TextField();
		problem.setPromptText(" tell us whats wrong with the bikes");
		
		userReport = (problem.getText());
		close.setOnAction(e -> window.close());

		VBox layout = new VBox(10); // Vertical box layout
		layout.getStylesheets().add(("Style.css"));
		layout.getChildren().addAll(label,lblbikenumber,bikenumber,problem,close,submit,signin);
		layout.setAlignment(Pos.CENTER); // set vertical line into the centre
		submit.setOnAction(e->{
			
			Admin.show();
			});
		
		// Display window and wait for it to be closed before returning
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
		
	}
	public static String getbikenum() {
	
		return bikecode;
	}
	public static String getuserreport() {
		return userReport;
	}
}
