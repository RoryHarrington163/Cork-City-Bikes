import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.util.ArrayList;

// hav it show when 1234 is in it takes u t o the bikes page 
// hav wen 1111 is typed in it brings u to the admin page 
// 2222 manager page 

	public class PinSIgnIN extends UserTopup{
		static int i= 0;
		static int[][] PinNum = new int[3][3];{

			PinNum[i][0] = 1234;
			PinNum[i][1] = 1111;
			PinNum[i][2] = 2222;
			
			//System.out.println("Pin " + i+ " " + PinNum[i][0]);
			//System.out.println("Top up " + PinNum[i][1]);

		}
		
		public static void show() {

		

		
		
			Stage window = new Stage();
			window.setTitle("Pin sign-in");
			Button signIn = new Button();
			TextField Pin = new TextField();
			TextField Topup = new TextField();
			Pin.setPromptText("Please enter Pin");
			Topup.setPromptText("plese enter amount in whole");
			Button confirm = new Button (" confirm ");
			Button b1 = new Button("login");

			Button b2 = new Button("enter Pin");
			
System.out.println(" customer = 1234\n Admin = 1111\nManager=2222");
				b2.setOnAction(e -> {
				int cpin = Integer.parseInt(Pin.getText());
				
		// gets the users pin brings the user to a top up
				//PinNum[i][0] = cpin;
				if (cpin == 1234) {
					cpin = PinNum[i][0];
					System.out.println(" logged in customer ");
					UserTopup.show();
					
				}
				// gets the admin pin and brings you to admin page
				else if (cpin == 1111) {
					cpin = PinNum[i][1];
					System.out.println(" logged in admin ");
					Admin.show();
					
				}
				else if (cpin == 2222) {
					cpin = PinNum[i][2];
					System.out.println(" logged in Manager ");
					Manager.show();
				}
				
				
				//PinNum[i][1] = newtopup number
				
				});
				

			VBox vbox = new VBox(10);
			vbox.getStylesheets().add(("Style.css"));
			vbox.setPadding(new Insets(30, 30, 30, 30));
			vbox.getChildren().addAll( Pin,b2);

			Scene scene = new Scene(vbox, 300, 400);
			window.setScene(scene);
			window.show();


	}
		
		}
	