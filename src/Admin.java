import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin extends ReportProblem  {
	public static void show() {

		
		Stage window = new Stage();
		window.setTitle("Admin");
		VBox vbox = new VBox(10);

	Button close = new Button("close");
	close.setOnAction(e->{
		window.close();
	});
		Label Showbikecode = new Label("the bike number is "+ getbikenum() );
		Label ShowUserReport = new Label("this is what user has reported"+ getuserreport() );
		Label pq = new Label(" Popes key needs maintenence");
		Button fixlocation = new Button ("check maintenence log");
		
		
	// here this just promts the admin to fix the problem location 
		fixlocation.setOnAction(e->{
			Button debug = new Button("debug");
			Alert alert = new Alert (AlertType.WARNING);
		alert.setTitle("Maintenence needed");
		alert.setHeaderText("Maintenence");
		alert.setContentText("location Popes quay needs maintenence: issue, location screen due for bug test");
		Optional<ButtonType> option = alert.showAndWait();
		if(option.get()==ButtonType.OK) {
			pq.setText("location updated");
			System.out.println("location 'popes key' is in maintenence");
		}

		});

		vbox.setPadding(new Insets(30, 30, 30, 30));
		vbox.getChildren().addAll(close,Showbikecode,ShowUserReport,pq,fixlocation);

		Scene scene = new Scene(vbox, 300, 400);
		window.setScene(scene);
		window.show();
		
	}
}
