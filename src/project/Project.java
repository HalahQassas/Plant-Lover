package project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import org.hibernate.Session;
import java.io.Serializable;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import org.hibernate.*;
  
public class Project extends Application {

    @Override
    public void start(Stage primaryStage) {
        // welcome 
       BorderPane pane = new BorderPane();
       pane.setPadding(new Insets(0,10,60,50));
        Text t = new Text("المسرات النباتية");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 45));
        t.setFill(Color.WHITE);
        pane.setBottom(t);
        FadeTransition fadeIn= new FadeTransition(Duration.seconds(2),pane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.play();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);
        Image imgbackgroundwelcome = new Image("IMG_1336.JPG");
        pane.setBackground(Background.EMPTY);
        ImagePattern swelcome = new ImagePattern(imgbackgroundwelcome);
        Scene scene = new Scene(pane, 500, 660);
        scene.setFill(swelcome);
        primaryStage.setTitle("المسرات النباتية");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // page 1
       BorderPane paneEnter= new BorderPane();
       paneEnter.setPadding(new Insets(30,20,100,30));
       Label labelEnter = new Label( "المسرات النباتية");
       labelEnter.setFont(new Font("Verdana Bold", 60));
       labelEnter.setTextFill(Color.WHITE);
       labelEnter.setPadding(new Insets(100, 0,0, 0));
       paneEnter.setTop(labelEnter);
       Button signupButton=new Button("انشاء حساب");
       signupButton.setPrefSize(160, 30);
       signupButton.setFont(new Font("Verdana Bold", 10));
       signupButton.setAlignment(Pos.CENTER);
       signupButton.setStyle("-fx-background-color:DARKSEAGREEN; -fx-text-fill:WHITE;");
       Button loginButton=new Button ("تسجيل دخول");
       loginButton.setPrefSize(160, 30);
       loginButton.setFont(new Font("Verdana Bold", 10));
       loginButton.setAlignment(Pos.CENTER);
       loginButton.setStyle("-fx-background-color:DARKSEAGREEN; -fx-text-fill:WHITE;");
       VBox vboxEnter = new VBox(17);
       vboxEnter.getChildren().addAll(signupButton,loginButton);
       paneEnter.setBottom(vboxEnter);
       vboxEnter.setAlignment(Pos.TOP_CENTER);
       Image backgroundEnter = new Image("background1.JPG");
       paneEnter.setBackground(Background.EMPTY);
       ImagePattern backgroundEnter1 = new ImagePattern(backgroundEnter);
       Scene mainScene = new Scene(paneEnter, 540, 700);
       mainScene.setFill(backgroundEnter1);
      
     
        //sign up
        BorderPane panesignup = new BorderPane();
        panesignup.setPadding(new Insets(50,0,50, 0));
        HBox firstRow = new HBox(15);
        Label userNameLabel = new Label( "اسم المستخدم");
        userNameLabel.setFont(new Font("Verdana", 18));
        userNameLabel.setTextFill(Color.DARKSLATEGRAY);
        TextField nameTextField = new TextField();
        firstRow.getChildren().addAll(userNameLabel,nameTextField);
        HBox secondRow = new HBox(25);
        Label passwordLabel = new Label( "كلمة السر ");
        passwordLabel.setFont(new Font("Verdana", 20));
        passwordLabel.setTextFill(Color.DARKSLATEGRAY);
        TextField passwordTextField = new TextField();
        secondRow.getChildren().addAll(passwordLabel,passwordTextField);
        HBox thirdRow = new HBox(47);
        Label emailLabel = new Label( "الإيميل ");
        emailLabel.setFont(new Font("Verdana", 20));
        emailLabel.setTextFill(Color.DARKSLATEGRAY);
        TextField emailTextField = new TextField();
        thirdRow.getChildren().addAll(emailLabel,emailTextField);
        VBox signup = new VBox(20);
        signup.getChildren().addAll(firstRow,secondRow,thirdRow);
        signup.setPadding(new Insets(50,0,50, 80));
        signup.setAlignment(Pos.CENTER);
        HBox buttonsignup = new HBox(19);     
        buttonsignup.setAlignment(Pos.CENTER);
        Button signupButton1=new Button("تسجيل دخول");
        signupButton1.setFont(new Font("Verdana Bold", 10));
        signupButton1.setPrefSize(130, 30);
        signupButton1.setStyle("-fx-background-color:DARKSLATEGRAY; -fx-text-fill:WHITE;");
        Button cancelButton2=new Button("الغاء");
        cancelButton2.setFont(new Font("Tahoma Bold", 10));
        cancelButton2.setPrefSize(130, 30);
        cancelButton2.setStyle("-fx-background-color:DARKSLATEGRAY; -fx-text-fill:WHITE;");
        buttonsignup.getChildren().addAll(cancelButton2,signupButton1);
        panesignup.setCenter(signup);
        panesignup.setBottom(buttonsignup);
        Image i11 = new Image("background4.jpeg");
        panesignup.setBackground(Background.EMPTY);
        ImagePattern im = new ImagePattern(i11);
        Scene scenesignup = new Scene(panesignup,590, 510);
        scenesignup.setFill(im);
      
       
        //log in
        BorderPane panelogin = new BorderPane();
        panelogin.setPadding(new Insets(50,0,50, 0));
        HBox firstRow1 = new HBox(15);
        Label userNameLabel1 = new Label( "اسم المستخدم");
        userNameLabel1.setFont(new Font("Verdana", 18));
        userNameLabel1.setTextFill(Color.DARKSLATEGRAY);
        TextField nameTextField1 = new TextField();
        firstRow1.getChildren().addAll(userNameLabel1,nameTextField1);
        HBox secondRow1 = new HBox(25);
        Label passwordLabel1 = new Label( "كلمة السر ");
        passwordLabel1.setFont(new Font("Verdana", 20));
        passwordLabel1.setTextFill(Color.DARKSLATEGRAY);
        TextField passwordTextField1 = new TextField();
        secondRow1.getChildren().addAll(passwordLabel1,passwordTextField1);
        HBox thirdRow1 = new HBox(47);
        VBox login = new VBox(20);
        login.getChildren().addAll(firstRow1,secondRow1);
        login.setPadding(new Insets(50,0,50, 80));
        login.setAlignment(Pos.CENTER);
        HBox buttonlogin = new HBox(19);     
        buttonlogin.setAlignment(Pos.CENTER);
        Button signupButton0=new Button("تسجيل دخول");
        signupButton0.setFont(new Font("Verdana Bold", 10));
        signupButton0.setPrefSize(130, 30);
        signupButton0.setStyle("-fx-background-color:DARKSLATEGRAY; -fx-text-fill:WHITE;");
        Button cancelButton=new Button("الغاء");
        cancelButton.setFont(new Font("Tahoma Bold", 10));
        cancelButton.setPrefSize(130, 30);
        cancelButton.setStyle("-fx-background-color:DARKSLATEGRAY; -fx-text-fill:WHITE;");
        buttonlogin.getChildren().addAll(cancelButton,signupButton0);
        panelogin.setCenter(login);
        panelogin.setBottom(buttonlogin);
        Image i1l = new Image("background4.jpeg");
        panelogin.setBackground(Background.EMPTY);
        ImagePattern im1 = new ImagePattern(i1l);
        Scene scenelogin = new Scene(panelogin,590, 510);
        scenelogin.setFill(im1);
      
         // Home
        BorderPane paneHome = new BorderPane();
        paneHome.setPadding(new Insets(25,19,52,0));
        HBox hboxHome = new HBox();
        Image imgHome = new Image("exit.png");
        ImageView imgHome1 = new ImageView(imgHome);
        imgHome1.setFitHeight(25);
        imgHome1.setFitWidth(20);
        Button buttonHome = new Button();
        buttonHome.setPrefSize(20,20);
        buttonHome.setStyle("-fx-background-color: SLATEGRAY;");
        buttonHome.setGraphic(imgHome1);
        hboxHome.setAlignment(Pos.BOTTOM_RIGHT);
        hboxHome.getChildren().add(buttonHome);
        paneHome.setTop(hboxHome);
        
        VBox vboxHome = new VBox(20);
        Button buttonHome1 = new Button("معلومات عن النباتات");
        buttonHome1.setPrefSize(300,50);
        buttonHome1.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));
        buttonHome1.setStyle("-fx-background-color: SLATEGRAY; -fx-text-fill: WHITE;");
        Button buttonHome2 = new Button("نباتاتي");
        buttonHome2.setPrefSize(300,50);
        buttonHome2.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));
        buttonHome2.setStyle("-fx-background-color: SLATEGRAY; -fx-text-fill: WHITE;");
        vboxHome.getChildren().addAll(buttonHome1,buttonHome2);
        vboxHome.setAlignment(Pos.CENTER);
        paneHome.setCenter(vboxHome);    
        Image imgbackground = new Image("IMG_1220.JPG");
        paneHome.setBackground(Background.EMPTY);
        ImagePattern s = new ImagePattern(imgbackground);
        Scene sceneHome = new Scene(paneHome, 530, 650); 
        sceneHome.setFill(s);
        
        
        
        //نباتاتي
        Label PlantName  = new Label("اختر نبتتك  :\t\t\t");
        Label labelTime  = new Label("تاريخ اقتناء النبتة : \t\t");
        PlantName.setTextFill(Color.DARKOLIVEGREEN);
        PlantName.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        labelTime.setTextFill(Color.DARKOLIVEGREEN);
        labelTime.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        ComboBox<String> Plant = new ComboBox();
        Plant.getItems().addAll("بوتوس", "زنبق السلام","البامبو","الصبار","مونستيرا","بيليا","أريكا","جلد النمر","مارانتا");
        Plant.setValue("بوتوس");
        Plant.setPrefSize(160, 30);
        Plant.setStyle("-fx-background-color: DARKSEAGREEN; -fx-text-fill:WHITE;");
        DatePicker time = new DatePicker(); 
        time.setPrefSize(160, 20);
        time.setStyle("-fx-background-color: DARKSEAGREEN; -fx-text-fill:WHITE;");

        GridPane form = new GridPane();
        form.add(PlantName,1,0);
        form.add(Plant,1,1);

        form.add(labelTime,1,2);
        form.add(time,1,3);
        
        form.setAlignment(Pos.CENTER);
        form.setHgap(10);
        form.setVgap(10);
       

        Button Submit = new Button("إرسال");
        Button Delete = new Button("حذف");
        Submit.setPrefSize(120, 20);
        Delete.setPrefSize(120, 20);
        Submit.setStyle("-fx-background-color: DARKSEAGREEN; -fx-text-fill:WHITE;");
        Delete.setStyle("-fx-background-color: DARKSEAGREEN; -fx-text-fill:WHITE;");
        VBox buttonMyPlant = new VBox(15);
        buttonMyPlant.setAlignment(Pos.CENTER);
        buttonMyPlant.getChildren().addAll(Submit,Delete);

        VBox controls = new VBox(20);
        controls.setAlignment(Pos.CENTER_RIGHT);
        controls.getChildren().addAll(form, buttonMyPlant);
        
        HBox hboxMyPlant = new HBox();
        Image imgMyplant = new Image("arrow.png");
        ImageView imgMyplant1 = new ImageView(imgMyplant);
        imgMyplant1.setFitHeight(25);
        imgMyplant1.setFitWidth(20);
        Button buttonMyplant2 = new Button();
        buttonMyplant2.setPrefSize(20,20);
        buttonMyplant2.setStyle("-fx-background-color: DARKSEAGREEN;");
        buttonMyplant2.setGraphic(imgMyplant1);
        hboxMyPlant.setAlignment(Pos.BOTTOM_RIGHT);
        hboxMyPlant.getChildren().add(buttonMyplant2);
 
        ObservableList<String> obPlantsNames= FXCollections.observableArrayList();
        ListView <String> lvPlant = new ListView<>(obPlantsNames);
        
        ObservableList<String> obIrrigation= FXCollections.observableArrayList();
        ListView lvIrrigation  = new ListView(obIrrigation);
        
        ObservableList<String> obSunlight= FXCollections.observableArrayList();
        ListView lvSunlight = new ListView(obSunlight);
        
        ObservableList<String> obFertilization= FXCollections.observableArrayList();
        ListView lvFertilization = new ListView(obFertilization);


        HBox lvs = new HBox(10);
        lvs.setAlignment(Pos.CENTER_RIGHT);
        lvs.setMaxWidth(700);
        lvs.setMinWidth(700);


        VBox VBlvPlant = new VBox(10);
        Circle cimg1 = new Circle(20);
        Image imgp1 = new Image("img3.PNG");
        ImagePattern imgp2 = new ImagePattern(imgp1);
        cimg1.setFill(imgp2);

        
        VBox VBlvIrrigation = new VBox(10);
        Circle cimg2 = new Circle(20);
        Image imgi1 = new Image("time.png");
        ImagePattern imgi2 = new ImagePattern(imgi1);
        cimg2.setFill(imgi2);
        
        VBox VBlvSunlight = new VBox(10);
        Circle cimg3 = new Circle(20);
        Image imgsu1 = new Image("img1.PNG");
        ImagePattern imgsu2 = new ImagePattern(imgsu1);
        cimg3.setFill(imgsu2);
        
        VBox VBlvFertilization = new VBox(10);
        Circle cimg4 = new Circle(20);
        Image imgf1 = new Image("img2.PNG");
        ImagePattern imgf2 = new ImagePattern(imgf1);
        cimg4.setFill(imgf2);
        
        
        VBlvPlant.getChildren().addAll(cimg1, new ScrollPane(lvPlant));
        VBlvIrrigation.getChildren().addAll(cimg2, new ScrollPane(lvIrrigation));
        VBlvSunlight.getChildren().addAll(cimg3, new ScrollPane(lvSunlight));
        VBlvFertilization.getChildren().addAll(cimg4, new ScrollPane(lvFertilization));
 
        VBlvPlant.setAlignment(Pos.CENTER);
        VBlvIrrigation.setAlignment(Pos.CENTER);
        VBlvSunlight.setAlignment(Pos.CENTER);
        VBlvFertilization.setAlignment(Pos.CENTER);
        
        lvs.getChildren().addAll(VBlvFertilization,VBlvSunlight,VBlvIrrigation,VBlvPlant);


        HBox root = new HBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().addAll(lvs,controls,hboxMyPlant);

        root.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene sceneMyPlants = new Scene(root, 950,750);
        
        
        
        
        //صفحة النباتات
        VBox vboxplant = new VBox(30);
        HBox hboxplant1= new HBox(40);
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setHeight(140);
        rectangle1.setWidth(140);
        rectangle1.setArcHeight(20);
        rectangle1.setArcWidth(20);
        rectangle1.setFill(Color.DARKSLATEGRAY);
        Image imag1 = new Image("imag1.jpg");
        ImageView imagview1 = new ImageView(imag1);
        imagview1.setFitHeight(110);
        imagview1.setFitWidth(125);
        imagview1.setX(7);
        imagview1.setY(7);
        Text text1 = new Text("البامبو ");
        text1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text1.setX(57);
        text1.setY(130);
        text1.setFill(Color.WHITE);
        Group group1 = new Group(rectangle1,imagview1,text1);
        Rectangle rectangle2 = new Rectangle();
        rectangle2.setHeight(140);
        rectangle2.setWidth(140);
        rectangle2.setArcHeight(20);
        rectangle2.setArcWidth(20);
        rectangle2.setFill(Color.DARKSLATEGRAY);
        Image imag2 = new Image("imag2.jpg");
        ImageView imagview2= new ImageView(imag2);
        imagview2.setFitHeight(110);
        imagview2.setFitWidth(130);
        imagview2.setX(5);
        imagview2.setY(7);
        Text text2 = new Text("زنبق السلام ");
        text2.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text2.setX(35);
        text2.setY(130);
        text2.setFill(Color.WHITE);
        Group group2 = new Group(rectangle2,imagview2,text2);
        Rectangle rectangle3 = new Rectangle();
        rectangle3.setHeight(140);
        rectangle3.setWidth(140);
        rectangle3.setArcHeight(20);
        rectangle3.setArcWidth(20);
        rectangle3.setFill(Color.DARKSLATEGRAY);
        Image imag3 = new Image("imag3.jpeg");
        ImageView imagview3= new ImageView(imag3);
        imagview3.setFitHeight(110);
        imagview3.setFitWidth(130);
        imagview3.setX(5);
        imagview3.setY(7);
        Text text3 = new Text("البوتس");
        text3.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text3.setX(55);
        text3.setY(130);
        text3.setFill(Color.WHITE);
        Group group3 = new Group(rectangle3,imagview3,text3);
        hboxplant1.getChildren().addAll(group1,group2,group3);
        hboxplant1.setAlignment(Pos.CENTER);
        
        HBox hboxplant2= new HBox(40);
        Rectangle rectangle4 = new Rectangle();
        rectangle4.setHeight(140);
        rectangle4.setWidth(140);
        rectangle4.setArcHeight(20);
        rectangle4.setArcWidth(20);
        rectangle4.setFill(Color.DARKSLATEGRAY);
        Image imag4 = new Image("imag4.jpg");
        ImageView imagview4 = new ImageView(imag4);
        imagview4.setFitHeight(110);
        imagview4.setFitWidth(125);
        imagview4.setX(7);
        imagview4.setY(7);
        Text text4 = new Text("بيليا");
        text4.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text4.setX(55);
        text4.setY(130);
        text4.setFill(Color.WHITE);
        Group group4 = new Group(rectangle4,imagview4,text4);
        Rectangle rectangle5 = new Rectangle();
        rectangle5.setHeight(140);
        rectangle5.setWidth(140);
        rectangle5.setArcHeight(20);
        rectangle5.setArcWidth(20);
        rectangle5.setFill(Color.DARKSLATEGRAY);
        Image imag5 = new Image("imag5.jpg");
        ImageView imagview5= new ImageView(imag5);
        imagview5.setFitHeight(110);
        imagview5.setFitWidth(125);
        imagview5.setX(7);
        imagview5.setY(7);
        Text text5 = new Text("مونستيرا");
        text5.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text5.setX(45);
        text5.setY(130);
        text5.setFill(Color.WHITE);
        Group group5 = new Group(rectangle5,imagview5,text5);
        Rectangle rectangle6 = new Rectangle();
        rectangle6.setHeight(140);
        rectangle6.setWidth(140);
        rectangle6.setArcHeight(20);
        rectangle6.setArcWidth(20);
        rectangle6.setFill(Color.DARKSLATEGRAY);
        Image imag6 = new Image("imag6.jpg");
        ImageView imagview6= new ImageView(imag6);
        imagview6.setFitHeight(110);
        imagview6.setFitWidth(125);
        imagview6.setX(7);
        imagview6.setY(7);
        Text text6 = new Text("الصبار");
        text6.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text6.setX(55);
        text6.setY(130);
        text6.setFill(Color.WHITE);
        Group group6 = new Group(rectangle6,imagview6,text6);
        hboxplant2.getChildren().addAll(group4,group5,group6);
        hboxplant2.setAlignment(Pos.CENTER);
        
        HBox hboxplant3= new HBox(40);
        Rectangle rectangle7 = new Rectangle();
        rectangle7.setHeight(140);
        rectangle7.setWidth(140);
        rectangle7.setArcHeight(20);
        rectangle7.setArcWidth(20);
        rectangle7.setFill(Color.DARKSLATEGRAY);
        Image imag7 = new Image("imag7.jpg");
        ImageView imagview7 = new ImageView(imag7);
        imagview7.setFitHeight(110);
        imagview7.setFitWidth(125);
        imagview7.setX(7);
        imagview7.setY(7);
        Text text7 = new Text("مارانتا");
        text7.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text7.setX(55);
        text7.setY(130);
        text7.setFill(Color.WHITE);
        Group group7 = new Group(rectangle7,imagview7,text7);
        Rectangle rectangle8 = new Rectangle();
        rectangle8.setHeight(140);
        rectangle8.setWidth(140);
        rectangle8.setArcHeight(20);
        rectangle8.setArcWidth(20);
        rectangle8.setFill(Color.DARKSLATEGRAY);
        Image imag8 = new Image("imag8.png");
        ImageView imagview8= new ImageView(imag8);
        imagview8.setFitHeight(110);
        imagview8.setFitWidth(125);
        imagview8.setX(7);
        imagview8.setY(7);
        Text text8 = new Text("جلد النمر");
        text8.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text8.setX(46);
        text8.setY(130);
        text8.setFill(Color.WHITE);
        Group group8 = new Group(rectangle8,imagview8,text8);
        Rectangle rectangle9 = new Rectangle();
        rectangle9.setHeight(140);
        rectangle9.setWidth(140);
        rectangle9.setArcHeight(20);
        rectangle9.setArcWidth(20);
        rectangle9.setFill(Color.DARKSLATEGRAY);
        Image imag9 = new Image("imag9.jpg");
        ImageView imagview9= new ImageView(imag9);
        imagview9.setFitHeight(110);
        imagview9.setFitWidth(125);
        imagview9.setX(7);
        imagview9.setY(7);
        Text text9 = new Text("أريكا");
        text9.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        text9.setX(55);
        text9.setY(130);
        text9.setFill(Color.WHITE);
        Group group9 = new Group(rectangle9,imagview9,text9);
        hboxplant3.getChildren().addAll(group7,group8,group9);
        hboxplant3.setAlignment(Pos.CENTER);
        HBox hboxForPlantbutton = new HBox();
        Button buttonHome3 = new Button("الصفحة الرئيسية");
        buttonHome3.setStyle("-fx-background-color: DARKSLATEGRAY; -fx-text-fill: WHITE;");
        buttonHome3.setPrefSize(120, 20);
        hboxForPlantbutton.getChildren().add(buttonHome3);
        hboxForPlantbutton.setAlignment(Pos.BOTTOM_RIGHT);
        hboxForPlantbutton.setPadding(new Insets(30,30,20,20));
        vboxplant.getChildren().addAll(hboxplant1,hboxplant2,hboxplant3,hboxForPlantbutton);
        vboxplant.setAlignment(Pos.CENTER);
        Image imgbackground1 = new Image("backgroundplant.JPG");
        vboxplant.setBackground(Background.EMPTY);
        ImagePattern s1 = new ImagePattern(imgbackground1);
        Scene scenePlants = new Scene(vboxplant, 690,610);
        scenePlants.setFill(s1);

        
        
        
        
        //صفحة زهرة البوتس
        BorderPane paneBotos = new BorderPane();
        paneBotos.setPadding(new Insets(15,80,20,40));
        VBox vbotos1 = new VBox(40);
        Text botos = new Text("نبتة البوتس");
        botos.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        botos.setFill(Color.DARKOLIVEGREEN);
        Text botos1 = new Text("من نباتات الزينة الداخلية التي تنجح زراعتها بدرجات حرارة عالية موطنه الأصلي جزر سليمان وهو من النباتات الجميلة خاصة إذا استعملت في الأصص المعلقة"
                + "\n"+" حيث تتدلى فروعه بأوراقها الجميلة وهو من أنجح نباتات الزينة الداخلية لذلك ينجح كثيرا داخل المنازل في المناطق الجافة والصحراوية .");
        botos1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 13));
        botos1.setFill(Color.SLATEGRAY);
        vbotos1.getChildren().addAll(botos, botos1);
        vbotos1.setAlignment(Pos.CENTER);
        paneBotos.setTop(vbotos1);
        VBox vbotos2 = new VBox();
        Image img = new Image("botos1.JPG");
        ImageView img1 = new ImageView(img);
        img1.setFitHeight(460);
        img1.setFitWidth(330);
        img1.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vbotos2.getChildren().addAll(img1);
        vbotos2.setAlignment(Pos.CENTER_RIGHT);
        paneBotos.setLeft(vbotos2);
        HBox hbotos=new HBox(25);
        VBox vbotos3 = new VBox(20);
        Circle c1 = new Circle(20);
        Image img2 = new Image("img1.PNG");
        ImagePattern img3 = new ImagePattern(img2);
        c1.setFill(img3);
        Circle c2 = new Circle(20);
        Image img4 = new Image("img2.PNG");
        ImagePattern img5 = new ImagePattern(img4);
        c2.setFill(img5);
        Circle c3 = new Circle(20);
        Image img6 = new Image("img3.PNG");
        ImagePattern  img7 = new ImagePattern(img6);
        c3.setFill(img7);
        Circle c4 = new Circle(20);
        Image img8 = new Image("img4.PNG");
        ImagePattern  img9 = new ImagePattern(img8);
        c4.setFill(img9);
        Circle c5 = new Circle(20);
        Image img10 = new Image("img5.PNG");
        ImagePattern  img11 = new ImagePattern(img10);
        c5.setFill(img11);
        vbotos3.getChildren().addAll(c1,c2,c3,c4,c5);
        vbotos3.setAlignment(Pos.CENTER_LEFT);
        VBox vbotos4 = new VBox(45);
        Text t1 = new Text("الري بشكل معتدل دون إغراق في حالة جفاف التربة تروى مره كل أسبوع");
        t1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t1.setFill(Color.SLATEGRAY);
        Text t2 = new Text("تعيش في الضوء المنخفض والضوء الطبيعي الغير مباشر");
        t2.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t2.setFill(Color.SLATEGRAY);
        Text t3 = new Text("توضع بأوعية مناسبة لحجمها وعند إزدياد حجمها يستبدل بوعاء أكبر");
        t3.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t3.setFill(Color.SLATEGRAY);
        Text t4 = new Text("تتكاثر إما بالتجدير المائي ثم زراعتها بالتربة او بزراعتها مباشرة في التربة");
        t4.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t4.setFill(Color.SLATEGRAY);
        Text t5 = new Text("تسمد بالسماد العضوي او بالسماد NPK المتوازن كل شهر");
        t5.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t5.setFill(Color.SLATEGRAY);
        vbotos4.getChildren().addAll(t1,t2,t3,t4,t5);
        hbotos.getChildren().addAll(vbotos4,vbotos3);
        vbotos4.setAlignment(Pos.CENTER);
        paneBotos.setRight(hbotos);
        HBox hbuttonbotos = new HBox();
        Image imgb15 = new Image("arrow.png");
        ImageView imgb0 = new ImageView(imgb15);
        imgb0.setFitHeight(25);
        imgb0.setFitWidth(20);
        Button backbotos = new Button();
        backbotos.setPrefSize(20,20);
        backbotos.setStyle("-fx-background-color: DARKSEAGREEN;");
        backbotos.setGraphic(imgb0);
        hbuttonbotos.setAlignment(Pos.BOTTOM_RIGHT);
        hbuttonbotos.getChildren().add(backbotos);
        paneBotos.setBottom(hbuttonbotos);
        
        paneBotos.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene sceneBotos = new Scene(paneBotos, 900,750);
        
        
        
        //صفحة زنبق السلام
        BorderPane panePeacelily = new BorderPane();
        panePeacelily.setPadding(new Insets(15,80,20,40));
        VBox vboxpeace1 = new VBox(40);
        Text zanbag = new Text("زنبق السلام");
        zanbag.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        zanbag.setFill(Color.DARKOLIVEGREEN);
        Text zanbag1 = new Text("من النباتات المزهرة اصلها المناطق الاستوائية لها اسماء متعددة كنباتات الأشرعة البيضاءومن اشهر انواعها زهرة الاشرعة البيضاء"
         + "\n"+" وتعتبر من النباتات المعمرةوهي دائمة الخضرة اوراقها ذات حجم كبير تتعدد الوان ازهارها بين الأبيض والاصفر والاخضر");
        zanbag1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 13));
        zanbag1.setFill(Color.SLATEGRAY);
        vboxpeace1.getChildren().addAll(zanbag, zanbag1);
        vboxpeace1.setAlignment(Pos.CENTER);
        panePeacelily.setTop(vboxpeace1);
        VBox vboxpeace2 = new VBox();
        Image imgz = new Image("z.jpeg");
        ImageView imgzview = new ImageView(imgz);
        imgzview.setFitHeight(460);
        imgzview.setFitWidth(330);
        imgzview.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vboxpeace2.getChildren().addAll(imgzview);
        vboxpeace2.setAlignment(Pos.CENTER_RIGHT);
        panePeacelily.setLeft(vboxpeace2);
        HBox hboxpeace1=new HBox(25);
        VBox vboxpeace3 = new VBox(20);
        Circle circle1 = new Circle(20);
        circle1.setFill(img3);
        Circle circle2 = new Circle(20);
        circle2.setFill(img5);
        Circle circle3 = new Circle(20);
        circle3.setFill(img7);
        Circle circle4 = new Circle(20);
        circle4.setFill(img9);
        Circle circle5 = new Circle(20);
        circle5.setFill(img11);
        vboxpeace3.getChildren().addAll(circle1,circle2,circle3,circle4,circle5);
        vboxpeace3.setAlignment(Pos.CENTER_LEFT);
        VBox vboxpeace4 = new VBox(45);
        Text t6 = new Text("الري مرة وحدة كل أسبوع ويفضل أن تبقى التربة رطبة ولا تحتاج إلى السقاية إلا إذا جفت");
        t6.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 12));
        t6.setFill(Color.SLATEGRAY);
        Text t7 = new Text("تحتاج إلى توفير مكان ملائم بضوء خفيف إلى متوسط");
        t7.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t7.setFill(Color.SLATEGRAY);
        Text t8 = new Text("تحتاج الزنابق لأوعية لا يزيد قطرها عن 10سم بشكل عام");
        t8.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t8.setFill(Color.SLATEGRAY);
        Text t9 = new Text("تتكاثر عن طريق الخلفات التي تنمو بجوار النبات الأصلي .");
        t9.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t9.setFill(Color.SLATEGRAY);
        Text t10 = new Text("تسمد بالسماد العضوي او بالسماد NPK المتوازن كل شهر");
        t10.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t10.setFill(Color.SLATEGRAY);
        vboxpeace4.getChildren().addAll(t6,t7,t8,t9,t10);
        hboxpeace1.getChildren().addAll(vboxpeace4,vboxpeace3);
        vboxpeace4.setAlignment(Pos.CENTER);
        panePeacelily.setRight(hboxpeace1);
        HBox hboxpeace2 = new HBox();
        Image imgbtt = new Image("arrow.png");
        ImageView imgbttview = new ImageView(imgbtt);
        imgbttview.setFitHeight(25);
        imgbttview.setFitWidth(20);
        Button backPeacelily = new Button();
        backPeacelily.setPrefSize(20,20);
        backPeacelily.setStyle("-fx-background-color: DARKSEAGREEN;");
        backPeacelily.setGraphic(imgbttview);
        hboxpeace2.setAlignment(Pos.BOTTOM_RIGHT);
        hboxpeace2.getChildren().add(backPeacelily);
        panePeacelily.setBottom(hboxpeace2);
        
        panePeacelily.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene scenePeacelily = new Scene(panePeacelily, 900,750);
        
        
        
        
        //صفحة البامبو
        BorderPane paneBambo = new BorderPane();
        paneBambo.setPadding(new Insets(15,80,20,40));
        VBox vboxBambo1 = new VBox(40);
        Text bambo = new Text("نبتة البامبو");
        bambo.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        bambo.setFill(Color.DARKOLIVEGREEN);
        Text bambo1 = new Text("نبات البامبو أو نبتة الحظ نبات عشبي من عائلة نباتات الدراسينا وله اسماء مثل الخيزران وعصا موسى"
                + "\n"+" وقد يصل طولها الى عدة امتار ومايميزها قدرتها على العيش في الماء دون الحاجة للتربة");
        bambo1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 16));
        bambo1.setFill(Color.SLATEGRAY);
        vboxBambo1.getChildren().addAll(bambo, bambo1);
        vboxBambo1.setAlignment(Pos.CENTER);
        paneBambo.setTop(vboxBambo1);
        VBox vboxBambo2 = new VBox();
        Image imgba = new Image("bambo.jpeg");
        ImageView imgbaview = new ImageView(imgba);
        imgbaview.setFitHeight(460);
        imgbaview.setFitWidth(330);
        imgbaview.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vboxBambo2.getChildren().addAll(imgbaview);
        vboxBambo2.setAlignment(Pos.CENTER_RIGHT);
        paneBambo.setLeft(vboxBambo2);
        HBox hboxBambo1=new HBox(25);
        VBox vboxBambo3 = new VBox(20);
        Circle cb1 = new Circle(20);
        cb1.setFill(img3);
        Circle cb2 = new Circle(20);
        cb2.setFill(img5);
        Circle cb3 = new Circle(20);
        cb3.setFill(img7);
        Circle cb4 = new Circle(20);
        cb4.setFill(img9);
        Circle cb5 = new Circle(20);
        cb5.setFill(img11);
        vboxBambo3.getChildren().addAll(cb1,cb2,cb3,cb4,cb5);
        vboxBambo3.setAlignment(Pos.CENTER_LEFT);
        VBox vboxBambo4 = new VBox(45);
        Text t11 = new Text("يحتاج كمية قليلة من الماء مره كل اسبوع");
        t11.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t11.setFill(Color.SLATEGRAY);
        Text t12 = new Text("يحتاج لأشعة الشمس ولكن لابد من تجنبها في فترة الزراعة الآولى");
        t12.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t12.setFill(Color.SLATEGRAY);
        Text t13 = new Text("يفضل وضع نبات البامبو بأوعية معدنية");
        t13.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t13.setFill(Color.SLATEGRAY);
        Text t14 = new Text("تتكاثر بقص عقلةاو جزء من الساق ");
        t14.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t14.setFill(Color.SLATEGRAY);
        Text t15 = new Text("يحتاج الى الاسمدة السائلة مرة كل شهر");
        t15.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        t15.setFill(Color.SLATEGRAY);
        vboxBambo4.getChildren().addAll(t11,t12,t13,t14,t15);
        hboxBambo1.getChildren().addAll(vboxBambo4,vboxBambo3);
        vboxBambo4.setAlignment(Pos.CENTER);
        paneBambo.setRight(hboxBambo1);
        HBox hboxBambo2 = new HBox();
        Image imgbt = new Image("arrow.png");
        ImageView imgbtview = new ImageView(imgbt);
        imgbtview.setFitHeight(25);
        imgbtview.setFitWidth(20);
        Button backbambo = new Button();
        backbambo.setPrefSize(20,20);
        backbambo.setStyle("-fx-background-color: DARKSEAGREEN;");
        backbambo.setGraphic(imgbtview);
        hboxBambo2.setAlignment(Pos.BOTTOM_RIGHT);
        hboxBambo2.getChildren().add(backbambo);
        paneBambo.setBottom(hboxBambo2);
        
        paneBambo.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene sceneBambo = new Scene(paneBambo, 900,750);
       
        
        
        // صفحه جلد النمر
        BorderPane paneSansevieria = new BorderPane();
        paneSansevieria.setPadding(new Insets(15,80,20,40));
        VBox vboxSansevieria1 = new VBox(40);
        Text draccaena = new Text("نبتة جلد النمر");
        draccaena.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        draccaena.setFill(Color.DARKOLIVEGREEN);
        Text draccaena1 = new Text("موطنه الأصلي أفريقيا الغربية والاستوائية وله عدة أنواع تختلف في احجامها ودرجات تلون اوراقها"
                + "\n"+"يزرع نبات جلد النمر لجمال لون اوراقه في الحدائق الصخريه ويمكن زراعته في أصص كنبات داخلي");
        draccaena1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 16));
        draccaena1.setFill(Color.SLATEGRAY);
        vboxSansevieria1.getChildren().addAll(draccaena, draccaena1);
        vboxSansevieria1.setAlignment(Pos.CENTER);
        paneSansevieria.setTop(vboxSansevieria1);
        VBox vboxSansevieria2 = new VBox();
        Image imgd = new Image("sansevieria.JPG");
        ImageView imgd1 = new ImageView(imgd);
        imgd1.setFitHeight(460);
        imgd1.setFitWidth(325);
        imgd1.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vboxSansevieria2.getChildren().addAll(imgd1);
        vboxSansevieria2.setAlignment(Pos.CENTER_RIGHT);
        paneSansevieria.setLeft(vboxSansevieria2);
        HBox hboxSansevieria1=new HBox(25);
        VBox vboxSansevieria3 = new VBox(20);
        Circle cd1 = new Circle(20);
        Image imgd2 = new Image("img1.PNG");
        ImagePattern imgd3 = new ImagePattern(imgd2);
        cd1.setFill(imgd3);
        Circle cd2 = new Circle(20);
        Image imgd4 = new Image("img2.PNG");
        ImagePattern imgd5 = new ImagePattern(imgd4);
        cd2.setFill(imgd5);
        Circle cd3 = new Circle(20);
        Image imgd6 = new Image("img3.PNG");
        ImagePattern  imgd7 = new ImagePattern(imgd6);
        cd3.setFill(img7);
        Circle cd4 = new Circle(20);
        Image imgd8 = new Image("img4.PNG");
        ImagePattern  imgd9 = new ImagePattern(imgd8);
        cd4.setFill(imgd9);
        Circle cd5 = new Circle(20);
        Image imgd10 = new Image("img5.PNG");
        ImagePattern  imgd11 = new ImagePattern(imgd10);
        cd5.setFill(imgd11);
        vboxSansevieria3.getChildren().addAll(cd1,cd2,cd3,cd4,cd5);
        vboxSansevieria3.setAlignment(Pos.CENTER_LEFT);
        VBox vboxSansevieria4 = new VBox(45);
        Text td1 = new Text(" الري معتدل مرة واحده بالشهر ويجب عدم وصول الماء الى قلب النبات");
        td1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 13));
        td1.setFill(Color.SLATEGRAY);
        Text td2 = new Text("ينمو في الضوء الساطع وفي الظل الخفيف والمناخ الدافئ");
        td2.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        td2.setFill(Color.SLATEGRAY);
        Text td3 = new Text("يفضل أن يزرع نبات جلد النمر في أصص فخارية");
        td3.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        td3.setFill(Color.SLATEGRAY);
        Text td4 = new Text("سريع التكاثر بواسطة نمواته الصغيرة البارزة من الساق");
        td4.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        td4.setFill(Color.SLATEGRAY);
        Text td5 = new Text("يسمد بسماد متعادل العناصرخلال فترة النمو ويوقف التسميد فتره الشتاء");
        td5.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 13));
        td5.setFill(Color.SLATEGRAY);
        vboxSansevieria4.getChildren().addAll(td1,td2,td3,td4,td5);
        hboxSansevieria1.getChildren().addAll(vboxSansevieria4,vboxSansevieria3);
        vboxSansevieria4.setAlignment(Pos.CENTER);
        paneSansevieria.setRight(hboxSansevieria1);
        HBox hboxSansevieria = new HBox();
        Image imgd15 = new Image("arrow.png");
        ImageView imgd0 = new ImageView(imgd15);
        imgd0.setFitHeight(25);
        imgd0.setFitWidth(20);
        Button backSansevieria = new Button();
        backSansevieria.setPrefSize(20,20);
        backSansevieria.setStyle("-fx-background-color: DARKSEAGREEN;");
        backSansevieria.setGraphic(imgd0);
        hboxSansevieria.setAlignment(Pos.BOTTOM_RIGHT);
        hboxSansevieria.getChildren().add(backSansevieria);
        paneSansevieria.setBottom(hboxSansevieria);
        
        paneSansevieria.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene sceneSansevieria = new Scene(paneSansevieria, 900,750);
        
        //صفحه نبتة مونستيرا
        BorderPane panemonstera = new BorderPane();
        panemonstera.setPadding(new Insets(15,80,20,40));
        VBox vboxmonstera1 = new VBox(40);
        Text monstera = new Text("نبتة مونستيرا");
        monstera.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        monstera.setFill(Color.DARKOLIVEGREEN);
        Text monstera1 = new Text("نبات استوائي دائم الخضرة لاينمو في البلاد الباردة ينمو داخل البيوت الباردة ويزرع كنبات ورقي محب للظل" 
                + "\n"+"يكثر استخدام نبتة القفص الصدري كجزء من ديكور المنزل نظرا لشكل اوراقها المميز الذي يضيف على المكان لمسة جمالية");
        monstera1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 16));
        monstera1.setFill(Color.SLATEGRAY);
        vboxmonstera1.getChildren().addAll(monstera, monstera1);
        vboxmonstera1.setAlignment(Pos.CENTER);
        panemonstera.setTop(vboxmonstera1);
        VBox vboxmonstera2 = new VBox();
        Image imgm = new Image("monstera.JPG");
        ImageView imgm1 = new ImageView(imgm);
        imgm1.setFitHeight(460);
        imgm1.setFitWidth(325);
        imgm1.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vboxmonstera2.getChildren().addAll(imgm1);
        vboxmonstera2.setAlignment(Pos.CENTER_RIGHT);
        panemonstera.setLeft(vboxmonstera2);
        HBox hboxmonstera1 =new HBox(25);
        VBox vboxmonstera3 = new VBox(20);
        Circle cm1 = new Circle(20);
        Image imgm2 = new Image("img1.PNG");
        ImagePattern imgm3 = new ImagePattern(imgm2);
        cm1.setFill(imgm3);
        Circle cm2 = new Circle(20);
        Image imgm4 = new Image("img2.PNG");
        ImagePattern imgm5 = new ImagePattern(imgm4);
        cm2.setFill(imgm5);
        Circle cm3 = new Circle(20);
        Image imgm6 = new Image("img3.PNG");
        ImagePattern  imgm7 = new ImagePattern(imgm6);
        cm3.setFill(imgm7);
        Circle cm4 = new Circle(20);
        Image imgm8 = new Image("img4.PNG");
        ImagePattern  imgm9 = new ImagePattern(imgm8);
        cm4.setFill(imgm9);
        Circle cm5 = new Circle(20);
        Image imgm10 = new Image("img5.PNG");
        ImagePattern  imgm11 = new ImagePattern(imgm10);
        cm5.setFill(imgm11);
        vboxmonstera3.getChildren().addAll(cm1,cm2,cm3,cm4,cm5);
        vboxmonstera3.setAlignment(Pos.CENTER_LEFT);
        VBox vm4 = new VBox(45);
        Text tm1 = new Text("يروى مرتين في الأسبوع صيفا ، ومره واحدة كل 10-15يوم في الشتاء ");
        tm1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 12));
        tm1.setFill(Color.SLATEGRAY);
        Text tm2 = new Text("تحتاج الى ضوء ساطع مرشح مثل ضوء النافذة او الانارةالداخلية  للغرفة");
        tm2.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 12));
        tm2.setFill(Color.SLATEGRAY);
        Text tm3 = new Text("لترطيبها يوضع إناؤها على تربة رطبة او فوق حصى مغمور نصفه بالماء");
        tm3.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 12));
        tm3.setFill(Color.SLATEGRAY);
        Text tm4 = new Text("تتكاثر بتفصيص النبات الآصلي لعدة اقسام ثم تغرس الفصوص كل في أصيص مستقل");
        tm4.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 11));
        tm4.setFill(Color.SLATEGRAY);
        Text tm5 = new Text(" يستعمل السماد المركب السائل أو المحبب مره كل اسبوعين ");
        tm5.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 12));
        tm5.setFill(Color.SLATEGRAY);
        vm4.getChildren().addAll(tm1,tm2,tm3,tm4,tm5);
        hboxmonstera1 .getChildren().addAll(vm4,vboxmonstera3);
        vm4.setAlignment(Pos.CENTER);
        panemonstera.setRight(hboxmonstera1 );
        HBox hboxmonstera2 = new HBox();
        Image imgm15 = new Image("arrow.png");
        ImageView imgm0 = new ImageView(imgm15);
        imgm0.setFitHeight(25);
        imgm0.setFitWidth(20);
        Button backmonstera = new Button();
        backmonstera.setPrefSize(20,20);
        backmonstera.setStyle("-fx-background-color: DARKSEAGREEN;");
        backmonstera.setGraphic(imgm0);
        hboxmonstera2.setAlignment(Pos.BOTTOM_RIGHT);
        hboxmonstera2.getChildren().add(backmonstera);
        panemonstera.setBottom(hboxmonstera2);
        
        panemonstera.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene scenemonstera = new Scene(panemonstera, 900,750);
        
         //الصبار
        BorderPane panecactus = new BorderPane();
        panecactus.setPadding(new Insets(15,80,20,40));
        VBox vboxcactus1 = new VBox(40);
        Text cactus = new Text("نبتة الصبار");
        cactus.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        cactus.setFill(Color.DARKOLIVEGREEN);
        Text cactus1 = new Text("لها العديد من الأشكال والأحجام والأالوان  كما أنها تتطلب قدرا قليلا من العناية والاهتمام وهي نباتات زينة نظرا لأشكالها وألوانها الجميلة "
                + "\n"+" لذلك من الممكن وضعها داخل المنزل دون أن تكلف كثيرا من الأموال والوقت.");
        cactus1.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 13));
        cactus1.setFill(Color.SLATEGRAY);
        vboxcactus1.getChildren().addAll(cactus, cactus1);
        vboxcactus1.setAlignment(Pos.CENTER);
        panecactus.setTop(vboxcactus1);
        VBox vboxcactus2 = new VBox();
        Image imgs = new Image("cactus.jpeg");
        ImageView imgs1 = new ImageView(imgs);
        imgs1.setFitHeight(460);
        imgs1.setFitWidth(330);
        imgs1.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vboxcactus2.getChildren().addAll(imgs1);
        vboxcactus2.setAlignment(Pos.CENTER_RIGHT);
        panecactus.setLeft(vboxcactus2);
        HBox hboxcactus1 =new HBox(25);
        VBox vboxcactus3 = new VBox(20);
        Circle cs1 = new Circle(20);
        Image imgs2 = new Image("img1.PNG");
        ImagePattern imgs3 = new ImagePattern(imgs2);
        cs1.setFill(imgs3);
        Circle cs2 = new Circle(20);
        Image imgs4 = new Image("img2.PNG");
        ImagePattern imgs5 = new ImagePattern(imgs4);
        cs2.setFill(imgs5);
        Circle cs3 = new Circle(20);
        Image imgs6 = new Image("img3.PNG");
        ImagePattern  imgs7 = new ImagePattern(imgs6);
        cs3.setFill(imgs7);
        Circle cs4 = new Circle(20);
        Image imgs8 = new Image("img4.PNG");
        ImagePattern  imgs9 = new ImagePattern(imgs8);
        cs4.setFill(imgs9);
        Circle cs5 = new Circle(20);
        Image imgs10 = new Image("img5.PNG");
        ImagePattern  imgs11 = new ImagePattern(imgs10);
        cs5.setFill(imgs11);
        vboxcactus3.getChildren().addAll(cs1,cs2,cs3,cs4,cs5);
        vboxcactus3.setAlignment(Pos.CENTER_LEFT);
        VBox vboxcactus4 = new VBox(45);
        Text ts1 = new Text("الري باعتدال معظم أوقات السنة عدا الشتاء فيقلل الري ما أمكن");
        ts1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ts1.setFill(Color.SLATEGRAY);
        Text ts2 = new Text("تعيش في الضوء الساطع المباشر");
        ts2.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ts2.setFill(Color.SLATEGRAY);
        Text ts3 = new Text("توضع بأوعية مناسبة لحجمها وعند ازدياد حجمها يستبدل بوعاء أكبر");
        ts3.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ts3.setFill(Color.SLATEGRAY);
        Text ts4 = new Text("تتكاثر عن طريق البذور، أو بواسطة العقل إذا كان ينتج فروعا");
        ts4.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ts4.setFill(Color.SLATEGRAY);
        Text ts5 = new Text("تسمد بالسماد NPK أو بالسماد العضوي كل عدة أشهر");
        ts5.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ts5.setFill(Color.SLATEGRAY);
        vboxcactus4.getChildren().addAll(ts1,ts2,ts3,ts4,ts5);
        hboxcactus1 .getChildren().addAll(vboxcactus4,vboxcactus3);
        vboxcactus4.setAlignment(Pos.CENTER);
        panecactus.setRight(hboxcactus1 );
        HBox hboxcactus2 = new HBox();
        Image imgs15 = new Image("arrow.png");
        ImageView imgs0 = new ImageView(imgs15);
        imgs0.setFitHeight(25);
        imgs0.setFitWidth(20);
        Button backcactus = new Button();
        backcactus.setPrefSize(20,20);
        backcactus.setStyle("-fx-background-color: DARKSEAGREEN;");
        backcactus.setGraphic(imgs0);
        hboxcactus2.setAlignment(Pos.BOTTOM_RIGHT);
        hboxcactus2.getChildren().add(backcactus);
        panecactus.setBottom(hboxcactus2); 
        
        panecactus.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene scenecactus = new Scene(panecactus, 900,750);

///***************************************************************************************************************************
         //الاريكا
       
        BorderPane panearica = new BorderPane();
        panearica.setPadding(new Insets(15,80,20,40));
        VBox vboxarica1 = new VBox(40);
        Text arica = new Text("نبتة الاريكا");
        arica.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        arica.setFill(Color.DARKOLIVEGREEN);
        Text arica1 = new Text("موطنها الأصلي مدغشقر، هذه النبتة ممتازة لتعبئة زوايا المنزل بأوراقها المائلة للخارج، وتعتبرالاريكا من النباتات المنقية للجو، "
                + "\n"+"وتمتاز بسهولة رعايتها، فضلا عن أنها غير سامة للإنسان أو للحيوانات الأليفة.\t\t\t\t");
        arica1.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        arica1.setFill(Color.SLATEGRAY);
        vboxarica1.getChildren().addAll(arica, arica1);
        vboxarica1.setAlignment(Pos.CENTER);
        panearica.setTop(vboxarica1);
        VBox vboxarica2 = new VBox();
        Image imgarica = new Image("arica.jpeg");
        ImageView imgarica1 = new ImageView(imgarica);
        imgarica1.setFitHeight(460);
        imgarica1.setFitWidth(330);
        imgarica1.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vboxarica2.getChildren().addAll(imgarica1);
        vboxarica2.setAlignment(Pos.CENTER_RIGHT);
        panearica.setLeft(vboxarica2);
        HBox hboxarica1 =new HBox(25);
        VBox vboxarica3 = new VBox(20);
        Circle ca1 = new Circle(20);
        Image imga2 = new Image("img1.PNG");
        ImagePattern imga3 = new ImagePattern(imga2);
        ca1.setFill(imga3);
        Circle ca2 = new Circle(20);
        Image imga4 = new Image("img2.PNG");
        ImagePattern imga5 = new ImagePattern(imga4);
        ca2.setFill(imga5);
        Circle ca3 = new Circle(20);
        Image imga6 = new Image("img3.PNG");
        ImagePattern  imga7 = new ImagePattern(imga6);
        ca3.setFill(imga7);
        Circle ca4 = new Circle(20);
        Image imga8 = new Image("img4.PNG");
        ImagePattern  imga9 = new ImagePattern(imga8);
        ca4.setFill(imga9);
        Circle ca5 = new Circle(20);
        Image imga10 = new Image("img5.PNG");
        ImagePattern  imga11 = new ImagePattern(imga10);
        ca5.setFill(imga11);
        vboxarica3.getChildren().addAll(ca1,ca2,ca3,ca4,ca5);
        vboxarica3.setAlignment(Pos.CENTER_LEFT);
        VBox vboxarica4 = new VBox(45);
        Text ta1 = new Text("الري بشكل منتظم بحيث يتم ريها كلما جفت النبتة");
        ta1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ta1.setFill(Color.SLATEGRAY);
        Text ta2 = new Text("تعيش في ضوء الشمس الساطع الغير مباشر");
        ta2.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ta2.setFill(Color.SLATEGRAY);
        Text ta3 = new Text("تغيير الوعاء لوعاء أكبر عند امتلائه بالجذور ويكون ذلك كل 2 إلى 3 سنوات");
        ta3.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ta3.setFill(Color.SLATEGRAY);
        Text ta4 = new Text("تتكاثر بالبذور أو بالتقسيم ولكنها صعبة على المربي بالبيت");
        ta4.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ta4.setFill(Color.SLATEGRAY);
        Text ta5 = new Text("تسمد بسماد متعدد الأغراض مرة في الشهر عدا فترة السكون بالشتاء");
        ta5.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        ta5.setFill(Color.SLATEGRAY);
        vboxarica4.getChildren().addAll(ta1,ta2,ta3,ta4,ta5);
        hboxarica1 .getChildren().addAll(vboxarica4,vboxarica3);
        vboxarica4.setAlignment(Pos.CENTER);
        panearica.setRight(hboxarica1 );
        HBox hboxarica2 = new HBox();
        Image imga15 = new Image("arrow.png");
        ImageView imga0 = new ImageView(imga15);
        imga0.setFitHeight(25);
        imga0.setFitWidth(20);
        Button backarica = new Button();
        backarica.setPrefSize(20,20);
        backarica.setStyle("-fx-background-color: DARKSEAGREEN;");
        backarica.setGraphic(imga0);
        hboxarica2.setAlignment(Pos.BOTTOM_RIGHT);
        hboxarica2.getChildren().add(backarica);
        panearica.setBottom(hboxarica2); 
        
        panearica.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene scenearica  = new Scene(panearica, 900,750);
        
        //صفحه مارانتا 
        BorderPane panemaranta = new BorderPane();
        panemaranta.setPadding(new Insets(15,80,20,40));
        VBox vboxmaranta1 = new VBox(40);
        Text maranta = new Text("نبتة مارانتا");
        maranta.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        maranta.setFill(Color.DARKOLIVEGREEN);
        Text maranta1 = new Text("من نباتات الظل يزرع لجمال أوراقه وألوانه الزاهية وهي نبتة منزلية بإمتياز وذات جذور حساسة مع اوراق الزينة المتنوعة"
                + "\n"+"او المضلعة او المرقطة وهي ايضا موضع تقدير لخائصهاالمزيلة للتلوث");
        maranta1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        maranta1.setFill(Color.SLATEGRAY);
        vboxmaranta1.getChildren().addAll(maranta, maranta1);
        vboxmaranta1.setAlignment(Pos.CENTER);
        panemaranta.setTop(vboxmaranta1);
        VBox vboxmaranta2 = new VBox();
        Image imgmaranta = new Image("maranta.JPG");
        ImageView imgmaranta1 = new ImageView(imgmaranta);
        imgmaranta1.setFitHeight(460);
        imgmaranta1.setFitWidth(330);
        imgmaranta1.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vboxmaranta2.getChildren().addAll(imgmaranta1);
        vboxmaranta2.setAlignment(Pos.CENTER_RIGHT);
        panemaranta.setLeft(vboxmaranta2);
        HBox hboxmaranta1 =new HBox(25);
        VBox vboxmaranta3 = new VBox(20);
        Circle cmaranta1 = new Circle(20);
        Image imgmaranta2 = new Image("img1.PNG");
        ImagePattern imgmaranta3 = new ImagePattern(imgmaranta2);
        cmaranta1.setFill(imgmaranta3);
        Circle cmaranta2 = new Circle(20);
        Image imgmaranta4 = new Image("img2.PNG");
        ImagePattern imgmaranta5 = new ImagePattern(imgmaranta4);
        cmaranta2.setFill(imgmaranta5);
        Circle cmaranta3 = new Circle(20);
        Image imgmaranta6 = new Image("img3.PNG");
        ImagePattern  imgmaranta7 = new ImagePattern(imgmaranta6);
        cmaranta3.setFill(imgmaranta7);
        Circle cmaranta4 = new Circle(20);
        Image imgmaranta8 = new Image("img4.PNG");
        ImagePattern  imgmaranta9 = new ImagePattern(imgmaranta8);
        cmaranta4.setFill(imgmaranta9);
        Circle cmaranta5 = new Circle(20);
        Image imgmaranta10 = new Image("img5.PNG");
        ImagePattern  imgmaranta11 = new ImagePattern(imgmaranta10);
        cmaranta5.setFill(imgmaranta11);
        vboxmaranta3.getChildren().addAll(cmaranta1,cmaranta2,cmaranta3,cmaranta4,cmaranta5);
        vboxmaranta3.setAlignment(Pos.CENTER_LEFT);
        VBox vboxmaranta4 = new VBox(45);
        Text tmaranta1 = new Text("لايتم ريهاالا بعد جفاف التربة جزئيا ويفضل رش اوراقها برذاذ الماء بإستمرار");
        tmaranta1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 13));
        tmaranta1.setFill(Color.SLATEGRAY);
        Text tmaranta2 = new Text("تعيش في الضوء الغير مباشر");
        tmaranta2.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tmaranta2.setFill(Color.SLATEGRAY);
        Text tmaranta3 = new Text("توضع في اوعيه فخارية");
        tmaranta3.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tmaranta3.setFill(Color.SLATEGRAY);
        Text tmaranta4 = new Text("تتكاثر بالعقل او التقسيم في اول الربيع");
        tmaranta4.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tmaranta4.setFill(Color.SLATEGRAY);
        Text tmaranta5 = new Text("تسمد بالسماد NPK بشكل شهري من الربيع الى الخريف");
        tmaranta5.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tmaranta5.setFill(Color.SLATEGRAY);
        vboxmaranta4.getChildren().addAll(tmaranta1,tmaranta2,tmaranta3,tmaranta4,tmaranta5);
        hboxmaranta1 .getChildren().addAll(vboxmaranta4,vboxmaranta3);
        vboxmaranta4.setAlignment(Pos.CENTER);
        panemaranta.setRight(hboxmaranta1);
        HBox hboxmaranta2 = new HBox();
        Image imgmaranta15 = new Image("arrow.png");
        ImageView imgmaranta0 = new ImageView(imgmaranta15);
        imgmaranta0.setFitHeight(25);
        imgmaranta0.setFitWidth(20);
        Button backmaranta = new Button();
        backmaranta.setPrefSize(20,20);
        backmaranta.setStyle("-fx-background-color: DARKSEAGREEN;");
        backmaranta.setGraphic(imgmaranta0);
        hboxmaranta2.setAlignment(Pos.BOTTOM_RIGHT);
        hboxmaranta2.getChildren().add(backmaranta);
        panemaranta.setBottom(hboxmaranta2); 
        
        panemaranta.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene scenemaranta  = new Scene(panemaranta, 900,750);
        
        // صفحه بيليا
        BorderPane panepilea = new BorderPane();
        panepilea.setPadding(new Insets(15,80,20,40));
        VBox vboxpilea1 = new VBox(40);
        Text pilea = new Text("نبتة بيليا");
        pilea.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 50));
        pilea.setFill(Color.DARKOLIVEGREEN);
        Text pilea1 = new Text("تعتبر من النباتات دائمة الخضرة وموطنها الأصلي في جنوب الصين وهو نبات غير سام ويتميز بجماله"
                + "\n"+"حيث انه يضفي إشراقة وجمال للمكان وله اوراق دائرية الشكل تحمل على عنق رفيع وطويل");
        pilea1.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 18));
        pilea1.setFill(Color.SLATEGRAY);
        vboxpilea1.getChildren().addAll(pilea, pilea1);
        vboxpilea1.setAlignment(Pos.CENTER);
        panepilea.setTop(vboxpilea1);
        VBox vboxpilea2 = new VBox();
        Image imgpilea = new Image("imgpilea.jpg");
        ImageView imgpilea1 = new ImageView(imgpilea);
        imgpilea1.setFitHeight(460);
        imgpilea1.setFitWidth(330);
        imgpilea1.setStyle("-fx-border-color : BLUE;" + "-fx-border-style : dashed; " + "-fx-border-width : 7px;");
        vboxpilea2.getChildren().addAll(imgpilea1);
        vboxpilea2.setAlignment(Pos.CENTER_RIGHT);
        panepilea.setLeft(vboxpilea2);
        HBox hboxpilea1 =new HBox(25);
        VBox vboxpilea3 = new VBox(20);
        Circle cpilea1 = new Circle(20);
        Image imgpilea2 = new Image("img1.PNG");
        ImagePattern imgpilea3 = new ImagePattern(imgpilea2);
        cpilea1.setFill(imgpilea3);
        Circle cpilea2 = new Circle(20);
        Image imgpilea4 = new Image("img2.PNG");
        ImagePattern imgpilea5 = new ImagePattern(imgpilea4);
        cpilea2.setFill(imgpilea5);
        Circle cpilea3 = new Circle(20);
        Image imgpilea6 = new Image("img3.PNG");
        ImagePattern  imgpilea7 = new ImagePattern(imgpilea6);
        cpilea3.setFill(imgpilea7);
        Circle cpilea4 = new Circle(20);
        Image imgpilea8 = new Image("img4.PNG");
        ImagePattern  imgpilea9 = new ImagePattern(imgpilea8);
        cpilea4.setFill(imgpilea9);
        Circle cpilea5 = new Circle(20);
        Image imgpilea10 = new Image("img5.PNG");
        ImagePattern  imgpilea11 = new ImagePattern(imgpilea10);
        cpilea5.setFill(imgpilea11);
        vboxpilea3.getChildren().addAll(cpilea1,cpilea2,cpilea3,cpilea4,cpilea5);
        vboxpilea3.setAlignment(Pos.CENTER_LEFT);
        VBox vboxpilea4 = new VBox(45);
        Text tpilea1 = new Text("تروى بإعتدال ولايتم ريها الا بعد جفاف التربة جزئيا");
        tpilea1.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tpilea1.setFill(Color.SLATEGRAY);
        Text tpilea2 = new Text("تعيش في الضوء الساطع غير المباشر");
        tpilea2.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tpilea2.setFill(Color.SLATEGRAY);
        Text tpilea3 = new Text("توضع في وعاء مناسب لحجمها");
        tpilea3.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tpilea3.setFill(Color.SLATEGRAY);
        Text tpilea4 = new Text("تتكاثر بالخلفات والعقل");
        tpilea4.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tpilea4.setFill(Color.SLATEGRAY);
        Text tpilea5 = new Text("تسمد بسماد NPK متعادل مرة واحدة في الشهر والتوقف في فصل الشتاء");
        tpilea5.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14));
        tpilea5.setFill(Color.SLATEGRAY);
        vboxpilea4.getChildren().addAll(tpilea1,tpilea2,tpilea3,tpilea4,tpilea5);
        hboxpilea1 .getChildren().addAll(vboxpilea4,vboxpilea3);
        vboxpilea4.setAlignment(Pos.CENTER);
        panepilea.setRight(hboxpilea1);
        HBox hboxpilea2 = new HBox();
        Image imgpilea15 = new Image("arrow.png");
        ImageView imgpilea0 = new ImageView(imgpilea15);
        imgpilea0.setFitHeight(25);
        imgpilea0.setFitWidth(20);
        Button backpilea = new Button();
        backpilea.setPrefSize(20,20);
        backpilea.setStyle("-fx-background-color: DARKSEAGREEN;");
        backpilea.setGraphic(imgpilea0);
        hboxpilea2.setAlignment(Pos.BOTTOM_RIGHT);
        hboxpilea2.getChildren().add(backpilea);
        panepilea.setBottom(hboxpilea2); 
        
        panepilea.setBackground(new Background(new BackgroundFill(Color.HONEYDEW,null,null)));
        Scene scenepilea  = new Scene(panepilea, 900,750);
        
        
        //actions for buttonMyPlant
        signupButton.setOnAction(e ->{
            primaryStage.setTitle("انشاء حساب");
            primaryStage.setScene(scenesignup);
            primaryStage.show();
         });
        loginButton.setOnAction(e -> {
            primaryStage.setTitle("تسجيل الدخول");
            primaryStage.setScene(scenelogin);
            primaryStage.show();
         });
        
        cancelButton.setOnAction(e -> {
               primaryStage.setTitle("مرحبا");
               primaryStage.setScene(mainScene);
               primaryStage.show();
       });
        cancelButton2.setOnAction(e -> {
               primaryStage.setTitle("مرحبا");
               primaryStage.setScene(mainScene);
               primaryStage.show();
       });
        signupButton1.setOnAction(e -> {
            primaryStage.setTitle("تسجيل الدخول");
            primaryStage.setScene(scenelogin);
            primaryStage.show();
         });
       signupButton0.setOnAction( e-> {
          primaryStage.setTitle("الصفحة الرئيسية");
          primaryStage.setScene(sceneHome);
          primaryStage.show();
    });
        
        buttonHome.setOnAction(e -> {
               primaryStage.setTitle("مرحبا");
               primaryStage.setScene(mainScene);
               primaryStage.show();
       });
        
          backbotos.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
          backbambo.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
          backPeacelily.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
          backSansevieria.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
          backmonstera.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
        
         backcactus.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
         
         backarica.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
          backmaranta.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
          backpilea.setOnAction( e-> {
          primaryStage.setTitle("النباتات");
          primaryStage.setScene(scenePlants);
          primaryStage.show();
    });
         buttonMyplant2.setOnAction( e-> {
          primaryStage.setTitle("الصفحة الرئيسية");
          primaryStage.setScene(sceneHome);
          primaryStage.show();
    });
       
          
         Submit.setOnAction( e -> {
             
             if("بوتوس".equals(Plant.getValue())) {
                 obPlantsNames.add("نبتة البوتوس");
                 obIrrigation.add(t1.toString());
                 obSunlight.add(t2.toString());
                 obFertilization.add(t5.toString());
                 plant plant = new plant();
                 plant.setPlantName("البوتوس");
                 plant.setIrrigation("٦-٧ أيام في الشهر");
                 plant.setFertilization("مرة كل شهر");
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                 session.save(plant);
                tx.commit();
                session.close();
             }
             else if("زنبق السلام".equals(Plant.getValue())) {
                     obPlantsNames.add("زنبق السلام");
                     obIrrigation.add(t6.toString());
                     obSunlight.add(t7.toString());
                     obFertilization.add(t10.toString());
                     plant plant = new plant();
                     plant.setPlantName("زنبق السلام");
                     plant.setIrrigation("مرة كل أسبوع");
                     plant.setFertilization("٢-٣ مرة في السنة");
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = session.beginTransaction();
                     session.save(plant);
                    tx.commit();
                    session.close();
             }
              else if("البامبو".equals(Plant.getValue())) {
                 obPlantsNames.add("نبتة البامبو");
                 obIrrigation.add(t11.toString());
                 obSunlight.add(t12.toString());
                 obFertilization.add(t15.toString());
                 plant plant = new plant();
                 plant.setPlantName("البامبو");
                 plant.setIrrigation("كل يوم");
                 plant.setFertilization("مرة كل شهر");
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                 session.save(plant);
                tx.commit();
                session.close();
             }
             else if("الصبار".equals(Plant.getValue())) {
                 obPlantsNames.add("نبتة الصبار");
                 obIrrigation.add(ts1.toString());
                 obSunlight.add(ts2.toString());
                 obFertilization.add(ts5.toString());
                 plant plant = new plant();
                 plant.setPlantName("الصبار");
                 plant.setIrrigation("مرة كل أسبوعين");
                 plant.setFertilization("مرة كل شهرين");
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                 session.save(plant);
                tx.commit();
                session.close();
             }
             else if("مونستيرا".equals(Plant.getValue())) {
                 obPlantsNames.add("نبتة مونستيرا");
                 obIrrigation.add(tm1.toString());
                 obSunlight.add(tm2.toString());
                 obFertilization.add(tm5.toString());
                 plant plant = new plant();
                 plant.setPlantName("مونستيرا");
             plant.setIrrigation("مرة كل أسبوعين");
             plant.setFertilization("مرة كل أسبوعين");
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
             session.save(plant);
            tx.commit();
            session.close();
             }
             else if("بيليا".equals(Plant.getValue())) {
                 obPlantsNames.add("نبتة بيليا");
                 obIrrigation.add(ts1.toString());
                 obSunlight.add(ts2.toString());
                 obFertilization.add(ts5.toString());
                 plant plant = new plant();
                 plant.setPlantName("بيليا");
                 plant.setIrrigation("مرة كل أسبوع");
                 plant.setFertilization("مرة كل شهر");
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                 session.save(plant);
                tx.commit();
                session.close();
             }
             else if("أريكا".equals(Plant.getValue())) {
                 obPlantsNames.add("أريكا");
                 obIrrigation.add(ta1.toString());
                 obSunlight.add(ta2.toString());
                 obFertilization.add(ta5.toString());
                 plant plant = new plant();
                 plant.setPlantName("أريكا");
                 plant.setIrrigation("٢-٣ كل أسبوعين");
                 plant.setFertilization("مرة كل شهر");
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                 session.save(plant);
                tx.commit();
                session.close();
             }
             else if("جلد النمر".equals(Plant.getValue())) {
                 obPlantsNames.add("نبتة جلد النمر");
                 obIrrigation.add(td1.toString());
                 obSunlight.add(td2.toString());
                 obFertilization.add(td5.toString());
                 plant plant = new plant();
                 plant.setPlantName("جلد النمر");
                 plant.setIrrigation("مرة كل أسبوعين");
                 plant.setFertilization("مرة كل شهر");
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                 session.save(plant);
                tx.commit();
                session.close();
             }
             
             else if("مارانتا".equals(Plant.getValue())) {
                 obPlantsNames.add("نبتة مارانتا");
                 obIrrigation.add("مارانتا");
                 obSunlight.add("مرة كل شهر ماعدا الشتاء");
                 obFertilization.add(ts5.toString());
                 plant plant = new plant();
                 plant.setPlantName("مارانتا");
                 plant.setIrrigation("١-٢ كل أسبوع");
                 plant.setFertilization("مرة كل شهر ماعدا الشتاء");
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                 session.save(plant);
                tx.commit();
                session.close();
             }
                             
         });
         
         Delete.setOnAction(e-> {
            String m = Plant.getValue();
            int index = obPlantsNames.indexOf(m);
            String name = obPlantsNames.get(index);
            obPlantsNames.remove(index);
            obIrrigation.remove(index);
            obSunlight.remove(index);
            obFertilization.remove(index);
            //lblmsg.setText("Patient "+name+" was Deleted");
        });
         
         buttonHome1.setOnAction(e-> {
        primaryStage.setTitle("النباتات");
        primaryStage.setScene(scenePlants);
        primaryStage.show();
         });
        buttonHome2.setOnAction(e-> {
         primaryStage.setTitle("نباتاتي");
        primaryStage.setScene(sceneMyPlants);
        primaryStage.show();
         });
         
        buttonHome3.setOnAction(e -> {
        primaryStage.setTitle("الصفحة الرئيسية");
        primaryStage.setScene(sceneHome);
        primaryStage.show();
          });
        
        fadeIn.setOnFinished((e) -> {
        fadeOut.play();
        });
        fadeOut.setOnFinished((e) -> {
        primaryStage.setTitle("الصفحة الرئيسية");
        primaryStage.setScene(mainScene);
        primaryStage.show();
         });
          group1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("نبتة البامبو");
                    primaryStage.setScene(sceneBambo);
                    primaryStage.show();
                 
                  
                }
        });
            group2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("زنبق السلام");
                    primaryStage.setScene(scenePeacelily);
                    primaryStage.show();
                 
                  
                }
        });
               group3.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("نبتة البوتس");
                    primaryStage.setScene(sceneBotos);
                    primaryStage.show();
                 
                  
                }
        });
               group7.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("نبتة مارانتا");
                    primaryStage.setScene(scenemaranta);
                    primaryStage.show();
                 
                  
                }
        });
               group4.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("نبتة بيليا");
                    primaryStage.setScene(scenepilea);
                    primaryStage.show();
                 
                  
                }
        });
               group8.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("نبتة جلد النمر");
                    primaryStage.setScene(sceneSansevieria);
                    primaryStage.show();
                 
                  
                }
        });
               group5.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("نبتة مونستيرا");
                    primaryStage.setScene(scenemonstera);
                    primaryStage.show();
                 
                  
                }
        });
               
               group6.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("نبتةالصبار");
                    primaryStage.setScene(scenecactus);
                    primaryStage.show();
                 
                  
                }
        });
               
               group9.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setTitle("نبتةأريكا");
                    primaryStage.setScene(scenearica );
                    primaryStage.show();
                 
                  
                }
        });
        
    }

   

    public static void main(String[] args) {
        launch(args);
    }

}
