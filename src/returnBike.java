import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.application.*;
	


// here the user can return a bike
public class returnBike extends UserTopup {
		
	

	static Double TheCost;
	static Double accountBal = (double) currentTopup;
	
		public static void show() {
			Stage window = new Stage();
			window.setTitle("return bike");
				window.setMinHeight(200);
				window.setMinWidth(500);
		// This makes sure that it dosent load , windows pop up from errors 
				window.initModality(Modality.APPLICATION_MODAL);
				Button back = new Button("go back");
				
				back.setOnAction(e -> window.close());
				GridPane gridpane = new GridPane();
				gridpane.setPadding(new Insets(5));
				gridpane.setHgap(5);
				gridpane.setVgap(5); 
				ColumnConstraints column1 = new ColumnConstraints(100);
				ColumnConstraints column2 = new ColumnConstraints(50, 250, 300);
				column2.setHgrow(Priority.ALWAYS);
			//	calculate();
				
				Label returnloc = new Label("return location");
	
				TextField durationHours = new TextField();
				durationHours.setPromptText("enter in hours");
				
				TextField durationMins = new TextField();
				durationMins.setPromptText("enter in minutes ");
				Label lblTheCost = new Label("?");
				
			
			Button anwser = new Button ();
			Button calculate = new Button("get TheCost"); 
			Button recipt = new Button("print recipt");
			Button returnBk = new Button();
			
			
			recipt.setOnAction(e->{
				complete.show();
			});
			
//			Button ChooseLocation = new Button();
			
			ToggleGroup group = new ToggleGroup();
			
			RadioButton ucc = new RadioButton("Ucc");
			returnloc.setText(" you have chosen to return your bike at "+ ucc);
			ucc.setToggleGroup(group);
			
			RadioButton coc = new RadioButton("Cork college of Commerce");
			returnloc.setText(" you have chosen to return your bike at Cork collage of commerce");
			coc.setToggleGroup(group);
			
			RadioButton mtu = new RadioButton("MTU");
			returnloc.setText(" you have chosen to return your bike at Mtu");
			mtu.setToggleGroup(group);
			
			RadioButton Nms = new RadioButton("North main Street");
			returnloc.setText(" you have chosen to return your bike at North main street ");
			Nms.setToggleGroup(group);
			
			if(group.getProperties() != null) {
				RadioButton confirmLocal = (RadioButton)group.getSelectedToggle();
				returnloc.setText("your selected return location"+ group.getSelectedToggle());
			}
			
		
			
			returnBk.setOnAction(e->{
				//returnYourBike();
			});
			
			// gets the calculation of the cost
			calculate.setOnAction(e -> {

				int hours = Integer.parseInt(durationHours.getText());
				int minutes = Integer.parseInt(durationMins.getText());

				if (hours == 0 && minutes < 30) {

					TheCost = 0.0;
					System.out.println("The total TheCost is €" + TheCost);

				} else if (hours > 0 && hours <= 2) {
					TheCost = 1.50;
					System.out.println("The total TheCost is " + TheCost);
				} else if (hours > 2 && hours <= 3) {
					TheCost = 6.50;
					System.out.println("The total TheCost is " + TheCost);
				} else if (hours > 3 && minutes <= 0) {
					float additionalTheCost = 4.0f;
					int overtime = hours - 3;
					TheCost = (double) (overtime * additionalTheCost);
					System.out.println("The total TheCost is " + TheCost);
				} else if (hours > 3 && minutes >= 30) {
					float additionalTheCost = 2.0f;
					int overtime = hours - 3 + minutes / 30;
					int TheCosting = overtime / 30;
					TheCost = (double) (TheCosting * additionalTheCost);
					System.out.println("The total TheCost is " + TheCost);

				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("error has occured");
					alert.setContentText("numbers in whole no letters ");
					alert.showAndWait();
				}

				lblTheCost.setText("your TheCost is :€" + TheCost);
			});
	
			
			// Display window and wait for it to be closed before returning
			
			
			
			VBox layout = new VBox(20); // Vertical box layout
			
			layout.getChildren().addAll(back,ucc,coc,mtu,Nms,durationHours,durationMins,calculate,lblTheCost,recipt);    
			
			layout.setAlignment(Pos.CENTER); // set vertical line into the centre
			layout.getStylesheets().add(("Style.css"));
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.show();
			
			
		
		
		}
		public static Double getTheCost(){
			return TheCost;
		}
		public static void setUserTheCost(double i) {
			TheCost = i;
			
		}
		public static Double getBalance() {
			accountBal=currentTopup-TheCost;
			return accountBal;
		}
}

	