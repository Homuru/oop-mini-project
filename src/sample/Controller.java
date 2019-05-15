package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {

	private Object ob = new Object();
    @FXML
    private Circle object;
    @FXML
    private Rectangle wall;
    @FXML
    private ToggleButton toggleWallBtn;
    @FXML
    private TextField massInput;
    @FXML
    private TextField forceInput;
    @FXML
    private TextField inputV0;
    @FXML
    private TextArea outPut;
    @FXML
    private Label v0;
    @FXML
    private Label m;
    @FXML
    private Label title;
    @FXML
    private Button Start;
    @FXML
    private Button Reset;
    public TranslateTransition transition = new TranslateTransition();


    @FXML
    public void initialize() {
        wall.setVisible(false);
    }
    @FXML
    public void toggleWall() {
        if(toggleWallBtn.isSelected()) {
            wall.setVisible(true);
        } else {
            wall.setVisible(false);
        }
    }

    public void move(float s ) {
        transition.setDuration(Duration.seconds(s/ob.getV()));
        transition.setNode(object);
        transition.setByX(s);
        transition.play();
    }
    public void action1() {
    	toggleWallBtn.setDisable(true);
    	if(setV0()) {
    		if(wall.isVisible())
    			move(400);
    		else move(600);
    	}
    }
    @FXML
    public void start() {
    	if(laws() == 1) {
    		if(sumForce() == 0) {
    			action1();
    		}
    		else {
    			outPut.setText(outPut.getText().concat("\n" + "Vat chuyen dong nhanh dan deu!"+ "\n Default: m = 1"));
    			action2();
    		}
    	}else if(laws() == 2) {
    		
    		action2();
    		
    	}else if(laws() == 3) {
    		
    	}
    }
    public void reset() {
    	if(laws() == 1) {
    		toggleWallBtn.setDisable(false);
    		outPut.setText(null);
    		object.setLayoutX(object.getLayoutX() - transition.getByX());
    	}
    	else if(laws() == 2) {
    		
    	}
    	else if(laws() == 3) {
    		
    	}
    }
    public void law1() {
    	title.setText("First Law");
    	m.setDisable(true);
    	massInput.setDisable(true);
    	v0.setDisable(false);
    	v0.setDisable(false);
    	Start.setDisable(false);
    }
    public void law2() {
    	title.setText("Second Law");
    	m.setDisable(false);
    	massInput.setDisable(false);
    	v0.setDisable(true);
    	v0.setDisable(true);
    	Start.setDisable(false);
    }
    public void law3() {
    	title.setText("Third Law");
    	m.setDisable(false);
    	massInput.setDisable(false);
    	v0.setDisable(true);
    	v0.setDisable(true);
    	Start.setDisable(false);
    }
    public boolean setV0() {
    	float v = Float.parseFloat(inputV0.getText());
    	ob.setV(v);
    	outPut.setText(outPut.getText().concat("\n" + "v0 = " + inputV0.getText()));
    	//System.out.println("v = " + outPut.getText());
    	if(v == 0) return false;
    	else return true;
    }
    public int laws() {
    	String s = title.getText();
    	if(s.equals("First Law")) return 1;
    	else if(s.equals("Second Law")) return 2;
    	else if(s.equals("Third Law")) return 3;
		return 0;
    }
    public float sumForce() {
    	String[] str = forceInput.getText().split(";");
    	float[] f = new float[10];
    	int i = 0;
    	float sum =0;
    	for(String n: str) {
    		f[i] = Float.parseFloat(n);
    		sum += f[i];
    		i++;
    	}
    	outPut.setText("F = "+ sum);
    	return sum;
    }
    public void action2() {	//check lai
    	float m = Float.parseFloat(massInput.getText());
    	ob.setMass(m);
    	if(m <= 0) outPut.setText(outPut.getText().concat("Error: m = " + m + "??"));
    	else {
    		ob.setA(sumForce(), ob.getMass());
    		float a = ob.getA();
    		outPut.setText(outPut.getText().concat("\n" + "a = " + a));
    		int t = 5, i = 1;
    		while(i<=t) {
    			float v = a*i;
    			ob.setV(v);
    			move(v);// chỉ run vòng lặp đầu
    			i++;
    		}
    	}
    }
}