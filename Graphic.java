import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Graphic extends JFrame implements ActionListener {
    NormalClient client;
    double saleAmount = 0;
    JLabel totalPriceLabel = new JLabel();
    JButton addedProduct = new JButton();
    JButton clientNewProduct = new JButton("Check New Products!");
    String userNameString;
    String firstNameString;
    String lastNameString;
    String phoneNumberString;
    String addressString;
    String passwordString;

    // These are url , user_name , password of data_base
    private static final String urlDB = "jdbc:mysql://localhost/client";
    private static final String userNameDB = "root";
    private static final String passwordDB = "Pouyan@23";

    // Double
    double totalPrice = 0;
    double balance;
    JLabel currentBalance = new JLabel();
    JButton clickMeButton = new JButton("CLICK ME");


    // Fonts
    Font font1 = new Font("berlin", Font.BOLD, 30);
    Font font2 = new Font("berlin", Font.ITALIC, 18);
    Font font3 = new Font("bevel", Font.BOLD, 55);
    Font messageFont = new Font("Milena", Font.BOLD, 18);

    int bananaNumberDB = getProductNumber("banana");
    int appleNumberDB = getProductNumber("apple");
    int orangeNumberDB = getProductNumber("orange");
    int cherryNumberDB = getProductNumber("cherry");
    int mangoNumberDB = getProductNumber("mango");
    int pearNumberDB = getProductNumber("pear");
    int peachNumberDB = getProductNumber("peach");
    int waterMelonDB = getProductNumber("water melon");
    int melonNumberDB = getProductNumber("melon");
    int pineAppleNumberDB = getProductNumber("pine apple");
    int grapeNumberDB = getProductNumber("grape");
    int strawberryNumberDB = getProductNumber("strawberry");

    // fruit labels
    JLabel bananaLabel = new JLabel("Banana");
    JLabel appleLabel = new JLabel("Apple");
    JLabel orangeLabel = new JLabel("Orange");
    JLabel cherryLabel = new JLabel("Cherry");
    JLabel mangoLabel = new JLabel("Mango");
    JLabel pearLabel = new JLabel("Pear");
    JLabel peachLabel = new JLabel("Peach");
    JLabel watermelonLabel = new JLabel("Water Melon");
    JLabel melonLabel = new JLabel("Melon");
    JLabel pineAppleLabel = new JLabel("Pine Apple");
    JLabel grapeLabel = new JLabel("Grape");
    JLabel strawberryLabel = new JLabel("Strawberry");

    // Address of pictures on shopping panel Buttons and then making them to icon , so we can put them on buttons
    String cartPath = "/Users/pouyanmb/Desktop/cartButton.png";
    String accountInfoPath = "/Users/pouyanmb/Desktop/account.png";
    String balancePath = "/Users/pouyanmb/Desktop/balance.png";
    String sortPath = "/Users/pouyanmb/Desktop/sort.png";
    String searchPath = "/Users/pouyanmb/Desktop/search.png";
    String miniBackPath = "/Users/pouyanmb/Desktop/miniBack.png";
    String ratePath = "/Users/pouyanmb/Desktop/rate.png";
    ImageIcon rateIcon = new ImageIcon(ratePath);

    ImageIcon cartIcon = new ImageIcon(cartPath);
    ImageIcon accountIcon = new ImageIcon(accountInfoPath);
    ImageIcon balanceIcon = new ImageIcon(balancePath);
    ImageIcon sortIcon = new ImageIcon(sortPath);
    ImageIcon searchIcon = new ImageIcon(searchPath);
    ImageIcon miniBackIcon = new ImageIcon(miniBackPath);


    // Buttons we need in multiple methods , so we declare them global
    JButton changePassButton = new JButton("click here to change your pass");
    JButton clientButton;
    ImageIcon managerButtonIcon = new ImageIcon("/Users/pouyanmb/Desktop/m1.png");
    JButton managerButton = new JButton(managerButtonIcon);
    JButton signUpButton = new JButton("SIGN UP");
    JButton signInButton = new JButton("LOG IN");
    JButton backButton = new JButton("BACK");
    JButton welcomeButton;
    JButton submitButton = new JButton("Submit");
    JButton loginButton = new JButton("Login");
    JButton cartButton = new JButton(cartIcon);
    JButton personalInfoButton = new JButton(accountIcon);
    JButton balanceButton = new JButton(balanceIcon);
    JButton resetShoppingList = new JButton("Reset Cart");
    JButton continueShoppingButton = new JButton("CONTINUE SHOPPING");
    JButton continueShoppingButton2 = new JButton("CONTINUE SHOPPING");
    JButton sortByPriceButton = new JButton(sortIcon);
    JButton searchButton = new JButton(searchIcon);
    JButton finalCartButton = new JButton("Final & Go To Pay");
    JButton searchEngineButton = new JButton("GO !");
    JButton chargeAmount1 = new JButton("10 $");
    JButton chargeAmount2 = new JButton("20 $");
    JButton chargeAmount3 = new JButton("30 $");
    JButton increaseBalance = new JButton("UPDATE BALANCE ACCOUNT");
    JButton rateButton = new JButton(rateIcon);
    JButton confirmRates = new JButton("CONFIRM");


    // Buttons of fruits and address of them
    String bananaPath = "/Users/pouyanmb/Desktop/banana.png";
    ImageIcon bananaIcon = new ImageIcon(bananaPath);
    String cherryPath = "/Users/pouyanmb/Desktop/cherry.png";
    ImageIcon cherryIcon = new ImageIcon(cherryPath);

    String peachPath = "/Users/pouyanmb/Desktop/peach.png";
    ImageIcon peachIcon = new ImageIcon(peachPath);

    String pineApplePath = "/Users/pouyanmb/Desktop/pineApple.png";
    ImageIcon pineAppleIcon = new ImageIcon(pineApplePath);
    String applePath = "/Users/pouyanmb/Desktop/apple.png";
    ImageIcon appleIcon = new ImageIcon(applePath);
    String mangoPath = "/Users/pouyanmb/Desktop/mango.png";
    ImageIcon mangoIcon = new ImageIcon(mangoPath);
    String waterMelonPath = "/Users/pouyanmb/Desktop/waterMelon.png";
    ImageIcon waterMelonIcon = new ImageIcon(waterMelonPath);
    String grapePath = "/Users/pouyanmb/Desktop/grape.png";
    ImageIcon grapeIcon = new ImageIcon(grapePath);
    String orangePath = "/Users/pouyanmb/Desktop/orange.png";
    ImageIcon orangeIcon = new ImageIcon(orangePath);
    String pearPath = "/Users/pouyanmb/Desktop/pear.png";
    ImageIcon pearIcon = new ImageIcon(pearPath);
    String melonPath = "/Users/pouyanmb/Desktop/melon.png";
    ImageIcon melonIcon = new ImageIcon(melonPath);
    String strawberryPath = "/Users/pouyanmb/Desktop/strawberry.png";
    ImageIcon strawberryIcon = new ImageIcon(strawberryPath);
    JButton bananaButton = new JButton(bananaIcon);
    JButton cherryButton = new JButton(cherryIcon);
    JButton peachButton = new JButton(peachIcon);
    JButton pineAppleButton = new JButton(pineAppleIcon);
    JButton appleButton = new JButton(appleIcon);
    JButton mangoButton = new JButton(mangoIcon);
    JButton waterMelonButton = new JButton(waterMelonIcon);
    JButton grapeButton = new JButton(grapeIcon);
    JButton orangeButton = new JButton(orangeIcon);
    JButton pearButton = new JButton(pearIcon);
    JButton melonButton = new JButton(melonIcon);
    JButton strawberryButton = new JButton(strawberryIcon);


    // Text fields of fruits where in cart we get the number of them
    JTextField bananaText = new JTextField("banana");
    JTextField appleText = new JTextField("apple");
    JTextField orangeText = new JTextField("orange");
    JTextField cherryText = new JTextField("cherry");
    JTextField mangoText = new JTextField("mango");
    JTextField pearText = new JTextField("pear");
    JTextField peachText = new JTextField("peach");
    JTextField waterMelonText = new JTextField("water melon");
    JTextField melonText = new JTextField("melon");
    JTextField pineAppleText = new JTextField("pine apple");
    JTextField grapeText = new JTextField("grape");
    JTextField strawberryText = new JTextField("strawberry");
    JTextField bananaRateText = new JTextField();
    JTextField appleRateText = new JTextField();
    JTextField orangeRateText = new JTextField();
    JTextField cherryRateText = new JTextField();
    JTextField mangoRateText = new JTextField();
    JTextField pearRateText = new JTextField();
    JTextField peachRateText = new JTextField();
    JTextField waterMelonRateText = new JTextField();
    JTextField melonRateText = new JTextField();
    JTextField pineAppleRateText = new JTextField();
    JTextField grapeRateText = new JTextField();
    JTextField strawberryRateText = new JTextField();

    // Label and doubles of showing price
    final double bananaPrice = 1.05;
    final double applePrice = 0.70;
    final double cherryPrice = 1.25;
    final double orangePrice = 0.75;
    final double mangoPrice = 1.35;
    final double pearPrice = 0.65;
    final double peachPrice = 0.80;
    final double waterMelonPrice = 0.85;
    final double melonPrice = 0.65;
    final double pineApplePrice = 1.75;
    final double strawberryPrice = 0.85;
    final double grapePrice = 0.80;

    JLabel bananaPriceLabel = new JLabel("");
    JLabel applePriceLabel = new JLabel("");
    JLabel cherryPriceLabel = new JLabel("");
    JLabel orangePriceLabel = new JLabel("");
    JLabel mangoPriceLabel = new JLabel("");
    JLabel pearPriceLabel = new JLabel("");
    JLabel peachPriceLabel = new JLabel("");
    JLabel waterMelonPriceLabel = new JLabel("");
    JLabel melonPriceLabel = new JLabel("");
    JLabel pineApplePriceLabel = new JLabel("");
    JLabel strawberryPriceLabel = new JLabel("");
    JLabel grapePriceLabel = new JLabel("");


    // Panel
    JPanel firstPage = new JPanel();
    JPanel showItems = new JPanel(); // because of sort by price
    JPanel showSearchedItemPanel = new JPanel();

    // Sign up and Sign in labels and text fields and string
    JLabel userName = new JLabel("user  name  ( Maximum 10 )");
    JLabel firstName = new JLabel("first name  (Maximum 15 )");
    JLabel lastName = new JLabel("last name (Maximum 15 )");
    JLabel phoneNumber = new JLabel("phone number ( = 11 digits )");
    JLabel address = new JLabel("address ( Maximum 50 )");
    JLabel password = new JLabel("password ");
    JLabel passwordCondition = new JLabel("(8 < length < 12 / " +
            "Uppercase and Lowercase letters / " +
            "At Least One Numerical digit / " +
            "At Least One Special character :@,#,$,etc)");

    JTextField userNameText = new JTextField();
    JTextField firstNameText = new JTextField();
    JTextField lastNameText = new JTextField();
    JTextField phoneNumberText = new JTextField();
    JTextField addressText = new JTextField();
    JTextField passwordText = new JTextField();
    JTextField searchTextField = new JTextField();

    // Array list and string of shopping list
    private ArrayList<String> shoppingList = new ArrayList<>();
    String shoppingListString = String.valueOf(shoppingList);


    // DataBase methods :

    // 1. This method add user to DataBase when new user sign up
    public void addUserToDB(String userName, String firstName, String lastName, String phoneNumber, String address, String password) {
        Connection con;
        Statement stm;
        try {
            con = DriverManager.getConnection(urlDB, userNameDB, passwordDB);

            stm = con.createStatement();
            String sql = "INSERT INTO  CLIENT_DATA (user_name , first_Name , last_Name , phone_Number , address , password ) VALUES (?,?,?,?,?,?)";


            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, password);

            ResourceBundle resultSet = null;

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                client = new NormalClient(userName, firstName, lastName, phoneNumber, address, password, shoppingListString);
            }

            stm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // 2. This method check userName and Password while login ( check that this user and pass is correct or not )
    public boolean checkLoginInfoToDB(String userName, String password) {
        boolean isThereThisAccount = false;

        Connection con;

        try {
            con = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
            String query = "SELECT * FROM CLIENT_DATA WHERE user_name = ? AND password = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isThereThisAccount = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isThereThisAccount;
    }

    public static void addProductToDB(String productName, double productPrice, int productNumber) {
        String selectSQL = "SELECT COUNT(*) FROM product WHERE product_name = ?";
        String insertSQL = "INSERT INTO product (product_name, product_price, product_number) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {

            // Check if the product name already exists
            selectStmt.setString(1, productName);
            ResultSet rs = selectStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                System.out.print("");
            } else {
                // Set the parameters for the insert statement
                insertStmt.setString(1, productName);
                insertStmt.setDouble(2, productPrice);
                insertStmt.setInt(3, productNumber);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getProductNumber(String productName) {
        String selectSQL = "SELECT product_number FROM product WHERE product_name = ?";
        int productNumber = -1;

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            // Set the product name parameter
            pstmt.setString(1, productName);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            if (rs.next()) {
                productNumber = rs.getInt("product_number");
            } else {
                System.out.println("No product found with name: " + productName);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productNumber;
    }
    public static void updateProductNumber(String productName, int number) {
        String selectSQL = "SELECT product_number FROM product WHERE product_name = ?";
        String updateSQL = "UPDATE product SET product_number = ? WHERE product_name = ?";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

            // Retrieve the current product number
            selectStmt.setString(1, productName);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int currentProductNumber = rs.getInt("product_number");
                int newProductNumber = currentProductNumber - number;

                if (newProductNumber < 0) {
                    System.out.println("Error: The resulting product number cannot be negative.");
                    return;
                }

                // Set the parameters for the update statement
                updateStmt.setInt(1, newProductNumber);
                updateStmt.setString(2, productName);

                // Execute the update statement
                int affectedRows = updateStmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Product number updated successfully for product: " + productName);
                } else {
                    System.out.println("Product not found: " + productName);
                }
            } else {
                System.out.println("No product found with name: " + productName);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void updateBalance(String userName, double amount) {
        String selectSQL = "SELECT balance FROM client_data WHERE user_Name = ?";
        String updateSQL = "UPDATE client_data SET balance = ? WHERE user_Name = ?";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

            // Retrieve the current balance
            selectStmt.setString(1, userName);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");
                double newBalance = currentBalance - amount;

                if (newBalance < 0) {
                    System.out.println("Error: The resulting balance cannot be negative.");
                    return;
                }

                // Set the parameters for the update statement
                updateStmt.setDouble(1, newBalance);
                updateStmt.setString(2, userName);

                // Execute the update statement
                int affectedRows = updateStmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Balance updated successfully for user: " + userName);
                } else {
                    System.out.println("User not found: " + userName);
                }
            } else {
                System.out.println("No user found with name: " + userName);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void updateSale(String userName, double saleAmount) {
        String updateSQL = "UPDATE client_data SET sale = ? WHERE user_Name = ?";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // Set the parameters
            pstmt.setDouble(1, saleAmount);
            pstmt.setString(2, userName);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sale amount updated successfully for user: " + userName);
            } else {
                System.out.println("No user found with the username: " + userName);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double getTotalSales() {
        String sumSQL = "SELECT SUM(sale) AS total_sales FROM client_data";
        double totalSales = 0.0;

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(sumSQL);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                totalSales = rs.getDouble("total_sales");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return totalSales;
    }

    // This method is for add every Button we have action Listener
    public void addActionListener() {
        // button of item in shopping panel
        bananaButton.addActionListener(this);
        cherryButton.addActionListener(this);
        peachButton.addActionListener(this);
        pineAppleButton.addActionListener(this);
        appleButton.addActionListener(this);
        mangoButton.addActionListener(this);
        waterMelonButton.addActionListener(this);
        grapeButton.addActionListener(this);
        orangeButton.addActionListener(this);
        pearButton.addActionListener(this);
        melonButton.addActionListener(this);
        strawberryButton.addActionListener(this);

        changePassButton.addActionListener(this);
        continueShoppingButton.addActionListener(this);
        cartButton.addActionListener(this);
        searchButton.addActionListener(this);
        finalCartButton.addActionListener(this);
        continueShoppingButton2.addActionListener(this);
        sortByPriceButton.addActionListener(this);
        searchEngineButton.addActionListener(this);
        balanceButton.addActionListener(this);
        chargeAmount1.addActionListener(this);
        chargeAmount2.addActionListener(this);
        chargeAmount3.addActionListener(this);
        increaseBalance.addActionListener(this);
        rateButton.addActionListener(this);
        confirmRates.addActionListener(this);
        clickMeButton.addActionListener(this);

        managerButton.addActionListener(this);
        clientNewProduct.addActionListener(this);
        addedProduct.addActionListener(this);
    }


    // Constructor of graphic class
    Graphic() throws IOException, SQLException {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameDimension = new Dimension(dim);
        this.setSize(frameDimension);
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        backButton.setFont(font1);
        welcome();
        addActionListener();
        backButton.addActionListener(this);
    }


    // This is method for welcome to store page
    public void welcome() {
        String path = "/Users/pouyanmb/Desktop/welcome.png";
        ImageIcon icon = new ImageIcon(path);
        welcomeButton = new JButton(icon);
        welcomeButton.addActionListener(this);
        welcomeButton.setSize(this.getSize());
        sendProductToDB();
        this.add(welcomeButton);
    }

    // This method is for the page you choose that you are client / manager
    public void firstPage() throws IOException {
        firstPage.setLayout(new GridLayout(2, 2));
        firstPage.setSize(this.getSize());
        firstPage.setBackground(Color.white);

        String imagePathClient = "/Users/pouyanmb/Desktop/client.png";
        ImageIcon clientPicture = new ImageIcon(imagePathClient);
        JLabel clientPictureLabel = new JLabel(clientPicture);

        String imagePathManager = "/Users/pouyanmb/Desktop/manager.png";
        ImageIcon managerPicture = new ImageIcon(imagePathManager);
        JLabel managerPictureLabel = new JLabel(managerPicture);

        ImageIcon clientButtonIcon = new ImageIcon("/Users/pouyanmb/Desktop/c1.png");
        clientButton = new JButton(clientButtonIcon);
        clientButton.setFont(font1);
        clientButton.setSize(200, 50);
        clientButton.setBackground(Color.white);
        clientButton.setAlignmentY(CENTER_ALIGNMENT);
        clientButton.setAlignmentX(CENTER_ALIGNMENT);
        clientButton.addActionListener(this);

        managerButton.setFont(font1);
        managerButton.setSize(200, 50);

        firstPage.add(clientPictureLabel);
        firstPage.add(managerPictureLabel);
        firstPage.add(clientButton);
        firstPage.add(managerButton);

        this.add(firstPage);
    }

    // This is the page of sign in / sign up / back
    public void clientLoginSignup() {
        JPanel loginSignupPanelUp = new JPanel();
        JPanel loginSignupPanelDown = new JPanel();
        JPanel loginSignupPanelBack = new JPanel();
        loginSignupPanelUp.setLayout(new GridLayout(1, 1));
        loginSignupPanelDown.setLayout(new GridLayout(1, 2));
        loginSignupPanelBack.setLayout(new GridLayout(1, 1));
        loginSignupPanelUp.setBounds(0, 0, this.getWidth(), this.getHeight() / 2);
        loginSignupPanelDown.setBounds(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2 - 100);
        loginSignupPanelBack.setBounds(0, this.getHeight() - 103, this.getWidth(), 100);

        String picture = "/Users/pouyanmb/Desktop/picture.png";
        ImageIcon pictureIcon = new ImageIcon(picture);
        JLabel pictureLabel = new JLabel(pictureIcon);
        loginSignupPanelUp.add(pictureLabel);

        String signUpButtonPath = "/Users/pouyanmb/Desktop/signup.jpg";
        ImageIcon signupIcon = new ImageIcon(signUpButtonPath);
        signUpButton = new JButton(signupIcon);

        String loginButtonPath = "/Users/pouyanmb/Desktop/login.jpg";
        ImageIcon loginIcon = new ImageIcon(loginButtonPath);
        signInButton = new JButton(loginIcon);

        String backButtonPath = "/Users/pouyanmb/Desktop/back.png";
        ImageIcon backIcon = new ImageIcon(backButtonPath);
        backButton = new JButton(backIcon);

        signUpButton.setFont(font1);
        signUpButton.addActionListener(this);
        loginSignupPanelDown.add(signUpButton);

        loginSignupPanelBack.add(backButton);
        backButton.addActionListener(this);

        signInButton.setFont(font1);
        signInButton.addActionListener(this);
        loginSignupPanelDown.add(signInButton);

        this.add(loginSignupPanelBack);
        this.add(loginSignupPanelUp);
        this.add(loginSignupPanelDown);
    }

    // This method is for the page of signing up
    public void signUp() {
        JPanel signUpPanel = new JPanel();
        signUpPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        signUpPanel.setLayout(null);

        ImageIcon signBackIcon = new ImageIcon("/Users/pouyanmb/Desktop/signback.png");
        JLabel signBackLabel = new JLabel(signBackIcon);
        signBackLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        signUpPanel.add(signBackLabel);

        JLabel signUPLabel = new JLabel("SIGN UP");
        signUPLabel.setFont(font1);
        signUPLabel.setBounds(400, 100, 650, 30);
        signUPLabel.setBackground(new Color(80, 165, 185));
        signUPLabel.setForeground(Color.white);
        signBackLabel.add(signUPLabel);

        userName.setBounds(400, 170, 300, 50);
        userName.setForeground(Color.white);
        userName.setFont(font2);
        firstName.setBounds(400, 220, 300, 50);
        firstName.setForeground(Color.white);
        firstName.setFont(font2);
        lastName.setBounds(400, 270, 300, 50);
        lastName.setForeground(Color.white);
        lastName.setFont(font2);
        phoneNumber.setBounds(400, 320, 300, 50);
        phoneNumber.setForeground(Color.white);
        phoneNumber.setFont(font2);
        address.setBounds(400, 370, 300, 50);
        address.setForeground(Color.white);
        address.setFont(font2);
        password.setBounds(400, 420, 300, 50);
        password.setForeground(Color.white);
        password.setFont(font2);
        passwordCondition.setBounds(200, 480, 1500, 100);
        passwordCondition.setForeground(Color.white);
        passwordCondition.setFont(font2);

        signBackLabel.add(userName);
        signBackLabel.add(firstName);
        signBackLabel.add(lastName);
        signBackLabel.add(phoneNumber);
        signBackLabel.add(address);
        signBackLabel.add(password);
        signBackLabel.add(passwordCondition);

        backButton = new JButton("Back");
        backButton.setForeground(new Color(80, 165, 185));
        backButton.setFont(font2);
        submitButton.setFont(font2);
        submitButton.setForeground(new Color(80, 165, 185));
        backButton.setBounds(400, 600, 650, 70);
        submitButton.setBounds(400, 700, 650, 70);
        backButton.addActionListener(this);
        submitButton.addActionListener(this);

        userNameText.setBounds(800, 180, 300, 30);
        userNameText.setForeground(new Color(80, 165, 185));
        userNameText.setFont(font2);
        firstNameText.setBounds(800, 230, 300, 30);
        firstNameText.setForeground(new Color(80, 165, 185));
        firstNameText.setFont(font2);
        lastNameText.setBounds(800, 280, 300, 30);
        lastNameText.setForeground(new Color(80, 165, 185));
        lastNameText.setFont(font2);
        phoneNumberText.setBounds(800, 330, 300, 30);
        phoneNumberText.setForeground(new Color(80, 165, 185));
        phoneNumberText.setFont(font2);
        addressText.setBounds(800, 380, 300, 30);
        addressText.setForeground(new Color(80, 165, 185));
        addressText.setFont(font2);
        passwordText.setBounds(800, 430, 300, 30);
        passwordText.setForeground(new Color(80, 165, 185));
        passwordText.setFont(font2);

        signBackLabel.add(userNameText);
        signBackLabel.add(firstNameText);
        signBackLabel.add(lastNameText);
        signBackLabel.add(phoneNumberText);
        signBackLabel.add(addressText);
        signBackLabel.add(passwordText);

        signBackLabel.add(backButton);
        signBackLabel.add(submitButton);

        this.add(signUpPanel);
    }

    // This method check that the entry information by user has the required condition or not by returning boolean
    public boolean signUpConditions(String userName, String firstName, String lastName, String phoneNumber, String address, String password) {
        boolean conditions = true;
        if (isUserNameExist(userNameString)) {
            sendMessageToUser(" This user name is already taken by some one else !");
            conditions = false;
        }
        if (userName.length() > 10) {
            sendMessageToUser(" Your user name must be under 10 character . Try again !");
            conditions = false;
        }
        if (lastName.length() > 15) {
            sendMessageToUser(" Your last name must be under 15 character . Try again !");
            conditions = false;
        }
        if (firstName.length() > 15) {
            sendMessageToUser(" Your first name must be under 15 characters . Try again ! ");
            conditions = false;
        }
        if (phoneNumber.length() != 11) {
            sendMessageToUser(" Your phone number has to be 11 digits . Please try again !");
            conditions = false;
        }
        if (address.length() > 50) {
            sendMessageToUser(" Your address length must be under 50 characters . Please try again ! ");
            conditions = false;
        }

        if (!isStrongPassword(password)) {
            sendMessageToUser(" Your password is weak . Check password condition !");
            conditions = false;
        }

        return conditions;
    }

    // This method is for checking with DataBase that we don't have same UserName twice by returning boolean
    public static boolean isUserNameExist(String userName) {
        boolean exists = false;

        try (Connection connection = DriverManager.getConnection(urlDB, userNameDB, passwordDB)) {
            String query = "SELECT COUNT(*) FROM Client_data WHERE user_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, userName);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        exists = count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }

    // This method return boolean which is answer of the chosen password is strong or not
    public boolean isStrongPassword(String password) {
        String UPPER_CASE = ".*[A-Z].*";
        final String LOWER_CASE = ".*[a-z].*";
        final String DIGIT = ".*\\d.*";
        final String SPECIAL_CHAR = ".*[!@#$%^&*(),.?\":{}|<>].*";

        if (password.length() < 8) {
            return false;
        }

        if (!Pattern.compile(UPPER_CASE).matcher(password).matches()) {
            return false;
        }

        if (!Pattern.compile(LOWER_CASE).matcher(password).matches()) {
            return false;
        }

        if (!Pattern.compile(DIGIT).matcher(password).matches()) {
            return false;
        }

        if (!Pattern.compile(SPECIAL_CHAR).matcher(password).matches()) {
            return false;
        }

        return true;
    }

    // This method is for sign in page
    public void login() {
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        loginPanel.setLayout(null);

        ImageIcon signBackIcon = new ImageIcon("/Users/pouyanmb/Desktop/signback.png");
        JLabel signBackLabel = new JLabel(signBackIcon);
        signBackLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        loginPanel.add(signBackLabel);

        JLabel signINLabel = new JLabel("Log In");
        signINLabel.setFont(font1);
        signINLabel.setBounds(400, 100, 650, 40);
        signINLabel.setBackground(new Color(80, 165, 185));
        signINLabel.setForeground(Color.white);
        signBackLabel.add(signINLabel);

        loginButton.addActionListener(this);
        loginButton.setFont(font2);
        loginButton.setForeground(Color.white);
        loginButton.setForeground(new Color(80, 165, 185));
        loginButton.setBounds(400, 600, 650, 70);

        backButton = new JButton("Back");
        backButton.setForeground(Color.white);
        backButton.setForeground(new Color(80, 165, 185));
        backButton.setFont(font2);
        backButton.addActionListener(this);
        backButton.setBounds(400, 500, 650, 70);

        userName.setBounds(400, 170, 300, 50);
        userName.setForeground(Color.white);
        userName.setFont(font2);

        userNameText.setBounds(800, 180, 300, 30);
        userNameText.setForeground(new Color(80, 165, 185));
        userNameText.setFont(font2);

        password.setBounds(400, 220, 300, 50);
        password.setForeground(Color.white);
        password.setFont(font2);

        passwordText.setBounds(800, 230, 300, 30);
        passwordText.setForeground(new Color(80, 165, 185));
        passwordText.setFont(font2);


        signBackLabel.add(userNameText);
        signBackLabel.add(passwordText);
        signBackLabel.add(userName);
        signBackLabel.add(password);
        signBackLabel.add(backButton);
        signBackLabel.add(loginButton);

        this.add(loginPanel);
    }

    // This is the panel which user enter after login
    public void shoppingPanel(String userName, String password) {
        JPanel welcomeFirstNamePanel = new JPanel();
        welcomeFirstNamePanel.setLayout(new GridLayout(1, 1));
        welcomeFirstNamePanel.setBounds(0, 0, this.getWidth(), 160);
        JButton welcomeFirstNameLabel = new JButton("WELCOME  " + userNameString);
        welcomeFirstNameLabel.setForeground(new Color(22, 66, 77));
        welcomeFirstNameLabel.setFont(font3);

        welcomeFirstNamePanel.add(welcomeFirstNameLabel);
        this.add(welcomeFirstNamePanel);

        JPanel shoppingListAndDetailAndBalance = new JPanel();
        shoppingListAndDetailAndBalance.setLayout(new GridLayout(1, 6));
        shoppingListAndDetailAndBalance.setBounds(0, 160, this.getWidth(), 160);
        cartButton.setFont(font2);
        shoppingListAndDetailAndBalance.add(cartButton);
        personalInfoButton.setFont(font2);
        personalInfoButton.addActionListener(this);
        shoppingListAndDetailAndBalance.add(personalInfoButton);
        shoppingListAndDetailAndBalance.add(balanceButton);
        shoppingListAndDetailAndBalance.add(sortByPriceButton);
        shoppingListAndDetailAndBalance.add(searchButton);
        shoppingListAndDetailAndBalance.add(rateButton);
        this.add(shoppingListAndDetailAndBalance);

        showItems.setLayout(new GridLayout(3, 4));
        showItems.setBounds(0, 320, this.getWidth(), this.getHeight() - 320);

        showItems.add(bananaButton);
        showItems.add(cherryButton);
        showItems.add(peachButton);
        showItems.add(pineAppleButton);
        showItems.add(appleButton);
        showItems.add(mangoButton);
        showItems.add(waterMelonButton);
        showItems.add(grapeButton);
        showItems.add(orangeButton);
        showItems.add(pearButton);
        showItems.add(melonButton);
        showItems.add(strawberryButton);

        this.add(showItems);
    }

    public void sendProductToDB() {
        addProductToDB("banana", bananaPrice, 50);
        addProductToDB("apple", applePrice, 50);
        addProductToDB("cherry", cherryPrice, 50);
        addProductToDB("orange", orangePrice, 50);
        addProductToDB("melon", melonPrice, 50);
        addProductToDB("water melon", waterMelonPrice, 50);
        addProductToDB("pine apple", pineApplePrice, 50);
        addProductToDB("mango", mangoPrice, 50);
        addProductToDB("peach", peachPrice, 50);
        addProductToDB("pear", pearPrice, 50);
        addProductToDB("grape", grapePrice, 50);
        addProductToDB("strawberry", strawberryPrice, 50);

    }

    // This is the method for page account Info
    public void accountInfoPanel(String userNameModifier) {

        try (Connection connection = DriverManager.getConnection(urlDB, userNameDB, passwordDB)) {
            String query = "SELECT first_name, last_name, address, password, user_name, phone_number FROM CLIENT_DATA WHERE user_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, userNameModifier);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        userNameString = resultSet.getString("user_name");
                        firstNameString = resultSet.getString("first_name");
                        lastNameString = resultSet.getString("last_name");
                        phoneNumberString = resultSet.getString("phone_number");
                        addressString = resultSet.getString("address");
                        passwordString = resultSet.getString("password");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JPanel personalInfoPanel = new JPanel();
        personalInfoPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        personalInfoPanel.setLayout(null);

        ImageIcon personalInfoIcon = new ImageIcon("/Users/pouyanmb/Desktop/personalInfo.png");
        JLabel personalInfoBackground = new JLabel(personalInfoIcon);
        personalInfoBackground.setBounds(0, 0, this.getWidth(), this.getHeight());
        personalInfoPanel.add(personalInfoBackground);

        JLabel accountInfoLabel = new JLabel("ACCOUNT INFO");
        accountInfoLabel.setFont(font1);
        accountInfoLabel.setBounds(50, 60, 300, 50);
        accountInfoLabel.setForeground(Color.white);
        personalInfoBackground.add(accountInfoLabel);

        userName.setBounds(430, 100, 300, 50);
        userName.setFont(font2);
        userName.setForeground(Color.white);
        firstName.setBounds(430, 150, 300, 50);
        firstName.setForeground(Color.white);
        firstName.setFont(font2);
        lastName.setBounds(430, 200, 300, 50);
        lastName.setForeground(Color.white);
        lastName.setFont(font2);
        phoneNumber.setBounds(430, 250, 300, 50);
        phoneNumber.setForeground(Color.white);
        phoneNumber.setFont(font2);
        address.setBounds(430, 300, 300, 50);
        address.setForeground(Color.white);
        address.setFont(font2);
        password.setBounds(430, 350, 300, 50);
        password.setFont(font2);
        password.setForeground(Color.white);

        personalInfoBackground.add(userName);
        personalInfoBackground.add(firstName);
        personalInfoBackground.add(lastName);
        personalInfoBackground.add(phoneNumber);
        personalInfoBackground.add(address);
        personalInfoBackground.add(password);

        userNameText.setBounds(750, 110, 300, 30);
        userNameText.setFont(font2);
        userNameText.setText(userNameString);
        userNameText.setForeground(new Color(80, 165, 185));
        firstNameText.setBounds(750, 160, 300, 30);
        firstNameText.setFont(font2);
        firstNameText.setForeground(new Color(80, 165, 185));
        firstNameText.setText(firstNameString);
        lastNameText.setBounds(750, 210, 300, 30);
        lastNameText.setFont(font2);
        lastNameText.setForeground(new Color(80, 165, 185));
        lastNameText.setText(lastNameString);
        phoneNumberText.setBounds(750, 260, 300, 30);
        phoneNumberText.setFont(font2);
        phoneNumberText.setForeground(new Color(80, 165, 185));
        phoneNumberText.setText(phoneNumberString);
        addressText.setBounds(750, 310, 300, 30);
        addressText.setFont(font2);
        addressText.setForeground(new Color(80, 165, 185));
        addressText.setText(addressString);
        passwordText.setBounds(750, 360, 300, 30);
        passwordText.setFont(font2);
        passwordText.setText(passwordString);
        passwordText.setForeground(new Color(80, 165, 185));

        continueShoppingButton2.setBounds(450, 450, 550, 50);
        continueShoppingButton2.setForeground(new Color(80, 165, 185));
        continueShoppingButton2.setFont(font2);

        personalInfoBackground.add(userNameText);
        personalInfoBackground.add(firstNameText);
        personalInfoBackground.add(lastNameText);
        personalInfoBackground.add(phoneNumberText);
        personalInfoBackground.add(addressText);
        personalInfoBackground.add(passwordText);
        personalInfoBackground.add(continueShoppingButton2);

        changePassButton.setFont(font2);
        changePassButton.setBounds(1100, 360, 300, 35);
        changePassButton.setForeground(new Color(80, 165, 185));
        personalInfoBackground.add(changePassButton);

        this.add(personalInfoPanel);
    }

    // This method is for changing password part in Account Info page
    public boolean changePassword(String userName, String password) {
        boolean isPasswordChanged = false;

        if (passwordString == password) {
            return false;
        } else {
            try (Connection connection = DriverManager.getConnection(urlDB, userNameDB, passwordDB)) {
                String updateQuery = "UPDATE client_data SET password = ? WHERE user_name = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, password);
                    preparedStatement.setString(2, userNameString);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        isPasswordChanged = true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return isPasswordChanged;
        }
    }

    // This is the method for updating shopping list in our Data Base client_data table
    public static boolean updateShoppingList(String userName, String shoppingList) {
        boolean isUpdated = false;

        try (Connection connection = DriverManager.getConnection(urlDB, userNameDB, passwordDB)) {
            String query = "UPDATE Client_data SET shopping_list = ? WHERE user_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, shoppingList);
                preparedStatement.setString(2, userName);

                int rowsAffected = preparedStatement.executeUpdate();
                isUpdated = rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    // This method id for showing error / success / message to user by creating a new frame
    public void sendMessageToUser(String message) {
        JFrame messageFrame = new JFrame("Message From Program");
        messageFrame.setBounds(450, 350, 600, 200);
        messageFrame.setBackground(Color.white);
        JLabel messageLabel = new JLabel();
        messageLabel.setText(message);
        messageLabel.setForeground(Color.darkGray);
        messageLabel.setFont(messageFont);
        messageFrame.add(messageLabel);
        messageFrame.setVisible(true);
    }

    // This method count how many fruit does client have in his/her cart
    public int fruitCounter(String fruitName) {
        int count = 0;

        for (String fruit : shoppingList) {
            if (fruit.equalsIgnoreCase(fruitName)) {
                count++;
            }
        }
        return count;
    }

    // This method is for page of Cart
    public void cart() {
        JPanel cartPanel = new JPanel();
        cartPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        cartPanel.setLayout(null);

        ImageIcon cartIcon = new ImageIcon("/Users/pouyanmb/Desktop/cart.png");
        JLabel cartBackgroundLabel = new JLabel(cartIcon);
        cartBackgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        cartPanel.add(cartBackgroundLabel);

        JLabel cartLabel = new JLabel("CART");
        cartLabel.setFont(font1);
        cartLabel.setBounds(50, 60, 100, 50);
        cartLabel.setForeground(Color.white);
        cartBackgroundLabel.add(cartLabel);

        bananaLabel.setForeground(Color.white);
        bananaLabel.setFont(font2);
        bananaLabel.setBounds(50, 150, 200, 50);

        appleLabel.setForeground(Color.white);
        appleLabel.setFont(font2);
        appleLabel.setBounds(50, 200, 200, 50);

        orangeLabel.setForeground(Color.white);
        orangeLabel.setFont(font2);
        orangeLabel.setBounds(50, 250, 200, 50);

        cherryLabel.setForeground(Color.white);
        cherryLabel.setFont(font2);
        cherryLabel.setBounds(50, 300, 200, 50);

        mangoLabel.setForeground(Color.white);
        mangoLabel.setFont(font2);
        mangoLabel.setBounds(50, 350, 200, 50);

        pearLabel.setForeground(Color.white);
        pearLabel.setFont(font2);
        pearLabel.setBounds(50, 400, 200, 50);

        peachLabel.setForeground(Color.white);
        peachLabel.setFont(font2);
        peachLabel.setBounds(50, 450, 200, 50);

        watermelonLabel.setForeground(Color.white);
        watermelonLabel.setFont(font2);
        watermelonLabel.setBounds(50, 500, 200, 50);

        melonLabel.setForeground(Color.white);
        melonLabel.setFont(font2);
        melonLabel.setBounds(50, 550, 200, 50);

        pineAppleLabel.setForeground(Color.white);
        pineAppleLabel.setFont(font2);
        pineAppleLabel.setBounds(50, 600, 200, 50);

        grapeLabel.setForeground(Color.white);
        grapeLabel.setFont(font2);
        grapeLabel.setBounds(50, 650, 200, 50);

        strawberryLabel.setForeground(Color.white);
        strawberryLabel.setFont(font2);
        strawberryLabel.setBounds(50, 700, 200, 50);

        cartBackgroundLabel.add(bananaLabel);
        cartBackgroundLabel.add(appleLabel);
        cartBackgroundLabel.add(orangeLabel);
        cartBackgroundLabel.add(cherryLabel);
        cartBackgroundLabel.add(mangoLabel);
        cartBackgroundLabel.add(pearLabel);
        cartBackgroundLabel.add(watermelonLabel);
        cartBackgroundLabel.add(melonLabel);
        cartBackgroundLabel.add(peachLabel);
        cartBackgroundLabel.add(pineAppleLabel);
        cartBackgroundLabel.add(grapeLabel);
        cartBackgroundLabel.add(strawberryLabel);

        bananaText.setFont(font2);
        bananaText.setForeground(new Color(123, 170, 102));
        bananaText.setBounds(250, 150, 50, 50);
        bananaText.setText(String.valueOf(fruitCounter("banana")));
        bananaPriceLabel.setText(Double.parseDouble(bananaText.getText()) * bananaPrice + " $");
        bananaPriceLabel.setBounds(330, 150, 120, 50);
        bananaPriceLabel.setFont(font2);
        bananaPriceLabel.setForeground(Color.white);


        appleText.setFont(font2);
        appleText.setBounds(250, 200, 50, 50);
        appleText.setForeground(new Color(123, 170, 102));
        appleText.setText(String.valueOf(fruitCounter("apple")));
        applePriceLabel.setText(Double.parseDouble(appleText.getText()) * applePrice + " $");
        applePriceLabel.setBounds(330, 200, 120, 50);
        applePriceLabel.setFont(font2);
        applePriceLabel.setForeground(Color.white);

        orangeText.setFont(font2);
        orangeText.setBounds(250, 250, 50, 50);
        orangeText.setForeground(new Color(123, 170, 102));
        orangeText.setText(String.valueOf(fruitCounter("orange")));
        orangePriceLabel.setText(Double.parseDouble(orangeText.getText()) * orangePrice + " $");
        orangePriceLabel.setBounds(330, 250, 120, 50);
        orangePriceLabel.setFont(font2);
        orangePriceLabel.setForeground(Color.white);

        cherryText.setFont(font2);
        cherryText.setBounds(250, 300, 50, 50);
        cherryText.setForeground(new Color(123, 170, 102));
        cherryText.setText(String.valueOf(fruitCounter("cherry")));
        cherryPriceLabel.setText(Double.parseDouble(cherryText.getText()) * cherryPrice + " $");
        cherryPriceLabel.setBounds(330, 300, 120, 50);
        cherryPriceLabel.setFont(font2);
        cherryPriceLabel.setForeground(Color.white);

        mangoText.setFont(font2);
        mangoText.setBounds(250, 350, 50, 50);
        mangoText.setForeground(new Color(123, 170, 102));
        mangoText.setText(String.valueOf(fruitCounter("mango")));
        mangoPriceLabel.setText(Double.parseDouble(mangoText.getText()) * mangoPrice + " $");
        mangoPriceLabel.setBounds(330, 350, 120, 50);
        mangoPriceLabel.setFont(font2);
        mangoPriceLabel.setForeground(Color.white);

        pearText.setFont(font2);
        pearText.setBounds(250, 400, 50, 50);
        pearText.setForeground(new Color(123, 170, 102));
        pearText.setText(String.valueOf(fruitCounter("pear")));
        pearPriceLabel.setText(Double.parseDouble(pearText.getText()) * pearPrice + " $");
        pearPriceLabel.setBounds(330, 400, 120, 50);
        pearPriceLabel.setFont(font2);
        pearPriceLabel.setForeground(Color.white);

        peachText.setFont(font2);
        peachText.setBounds(250, 450, 50, 50);
        peachText.setForeground(new Color(123, 170, 102));
        peachText.setText(String.valueOf(fruitCounter("peach")));
        peachPriceLabel.setText(Double.parseDouble(peachText.getText()) * peachPrice + " $");
        peachPriceLabel.setBounds(330, 450, 120, 50);
        peachPriceLabel.setFont(font2);
        peachPriceLabel.setForeground(Color.white);

        waterMelonText.setFont(font2);
        waterMelonText.setBounds(250, 500, 50, 50);
        waterMelonText.setForeground(new Color(123, 170, 102));
        waterMelonText.setText(String.valueOf(fruitCounter("watermelon")));
        waterMelonPriceLabel.setText(Double.parseDouble(waterMelonText.getText()) * waterMelonPrice + " $");
        waterMelonPriceLabel.setBounds(330, 500, 120, 50);
        waterMelonPriceLabel.setFont(font2);
        waterMelonPriceLabel.setForeground(Color.white);

        melonText.setFont(font2);
        melonText.setBounds(250, 550, 50, 50);
        melonText.setForeground(new Color(123, 170, 102));
        melonText.setText(String.valueOf(fruitCounter("melon")));
        melonPriceLabel.setText(Double.parseDouble(melonText.getText()) * melonPrice + " $");
        melonPriceLabel.setBounds(330, 550, 120, 50);
        melonPriceLabel.setFont(font2);
        melonPriceLabel.setForeground(Color.white);

        pineAppleText.setFont(font2);
        pineAppleText.setBounds(250, 600, 50, 50);
        pineAppleText.setForeground(new Color(123, 170, 102));
        pineAppleText.setText(String.valueOf(fruitCounter("pine apple")));
        pineApplePriceLabel.setText(Double.parseDouble(pineAppleText.getText()) * pineApplePrice + " $");
        pineApplePriceLabel.setBounds(330, 600, 120, 50);
        pineApplePriceLabel.setFont(font2);
        pineApplePriceLabel.setForeground(Color.white);

        grapeText.setFont(font2);
        grapeText.setBounds(250, 650, 50, 50);
        grapeText.setForeground(new Color(123, 170, 102));
        grapeText.setText(String.valueOf(fruitCounter("grape")));
        grapePriceLabel.setText(Double.parseDouble(grapeText.getText()) * grapePrice + " $");
        grapePriceLabel.setBounds(330, 650, 120, 50);
        grapePriceLabel.setFont(font2);
        grapePriceLabel.setForeground(Color.white);

        strawberryText.setFont(font2);
        strawberryText.setBounds(250, 700, 50, 50);
        strawberryText.setForeground(new Color(123, 170, 102));
        strawberryText.setText(String.valueOf(fruitCounter("strawberry")));
        strawberryPriceLabel.setText(Double.parseDouble(strawberryText.getText()) * strawberryPrice + " $");
        strawberryPriceLabel.setBounds(330, 700, 120, 50);
        strawberryPriceLabel.setFont(font2);
        strawberryPriceLabel.setForeground(Color.white);

        totalPriceLabel.setText("Total Price                               " + calculateTotalPrice() + " $");
        totalPriceLabel.setBounds(48, 775, 600, 50);
        totalPriceLabel.setFont(font2);
        totalPriceLabel.setForeground(Color.white);

        JLabel note = new JLabel();
        note.setText("note : for update the cart click continue shopping and then get back to cart !");
        note.setBounds(45, 860, 900, 50);
        note.setFont(font2);
        note.setForeground(Color.white);

        cartBackgroundLabel.add(bananaText);
        cartBackgroundLabel.add(appleText);
        cartBackgroundLabel.add(orangeText);
        cartBackgroundLabel.add(cherryText);
        cartBackgroundLabel.add(mangoText);
        cartBackgroundLabel.add(pearText);
        cartBackgroundLabel.add(waterMelonText);
        cartBackgroundLabel.add(melonText);
        cartBackgroundLabel.add(peachText);
        cartBackgroundLabel.add(pineAppleText);
        cartBackgroundLabel.add(grapeText);
        cartBackgroundLabel.add(strawberryText);

        cartBackgroundLabel.add(bananaPriceLabel);
        cartBackgroundLabel.add(applePriceLabel);
        cartBackgroundLabel.add(orangePriceLabel);
        cartBackgroundLabel.add(cherryPriceLabel);
        cartBackgroundLabel.add(mangoPriceLabel);
        cartBackgroundLabel.add(pearPriceLabel);
        cartBackgroundLabel.add(waterMelonPriceLabel);
        cartBackgroundLabel.add(melonPriceLabel);
        cartBackgroundLabel.add(peachPriceLabel);
        cartBackgroundLabel.add(pineApplePriceLabel);
        cartBackgroundLabel.add(grapePriceLabel);
        cartBackgroundLabel.add(strawberryPriceLabel);
        cartBackgroundLabel.add(totalPriceLabel);
        cartBackgroundLabel.add(note);

        resetShoppingList.addActionListener(this);
        resetShoppingList.setFont(font2);
        resetShoppingList.setBounds(1100, 160, 300, 77);
        resetShoppingList.setForeground(new Color(123, 170, 102));

        cartBackgroundLabel.add(resetShoppingList);

        finalCartButton.setFont(font2);
        finalCartButton.setForeground(new Color(123, 170, 102));
        finalCartButton.setBounds(1100, 410, 300, 80);
        cartBackgroundLabel.add(finalCartButton);

        continueShoppingButton.setFont(font2);
        continueShoppingButton.setForeground(new Color(123, 170, 102));
        continueShoppingButton.setBounds(1100, 650, 300, 80);
        cartBackgroundLabel.add(continueShoppingButton);

        clientNewProduct.setBounds(1100, 860, 300, 50);
        clientNewProduct.setFont(font2);
        clientNewProduct.setForeground(new Color(123, 170, 102));
        cartBackgroundLabel.add(clientNewProduct);

        this.add(cartPanel);
    }

    // This method calculate cart final total price
    public double calculateTotalPrice() {
        totalPrice =

                Double.parseDouble(bananaPriceLabel.getText().substring(0, bananaPriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(applePriceLabel.getText().substring(0, applePriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(cherryPriceLabel.getText().substring(0, cherryPriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(orangePriceLabel.getText().substring(0, orangePriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(mangoPriceLabel.getText().substring(0, mangoPriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(pearPriceLabel.getText().substring(0, pearPriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(peachPriceLabel.getText().substring(0, peachPriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(waterMelonPriceLabel.getText().substring(0, waterMelonPriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(melonPriceLabel.getText().substring(0, melonPriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(pineApplePriceLabel.getText().substring(0, pineApplePriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(strawberryPriceLabel.getText().substring(0, strawberryPriceLabel.getText().indexOf(" "))) +
                        Double.parseDouble(grapePriceLabel.getText().substring(0, grapePriceLabel.getText().indexOf(" ")))+
                        newProductPriceDouble;

        return totalPrice;
    }

    // This me
    public void changeCartInCartPanel() {

        int bananaNumber = fruitCounter("banana");
        int appleNumber = fruitCounter("apple");
        int orangeNumber = fruitCounter("orange");
        int cherryNumber = fruitCounter("cherry");
        int mangoNumber = fruitCounter("mango");
        int pearNumber = fruitCounter("pear");
        int peachNumber = fruitCounter("peach");
        int watermelonNumber = fruitCounter("watermelon");
        int melonNumber = fruitCounter("melon");
        int pineAppleNumber = fruitCounter("pine apple");
        int grapeNumber = fruitCounter("grape");
        int strawberryNumber = fruitCounter("strawberry");

        if (!Objects.equals(bananaText.getText(), " ") && Integer.parseInt(bananaText.getText()) > bananaNumber) {
            for (int i = 0; i < Integer.parseInt(bananaText.getText()) - bananaNumber; i++) {
                shoppingList.add("banana");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else if (Integer.parseInt(bananaText.getText()) < bananaNumber) {
            for (int i = 0; i < bananaNumber - Integer.parseInt(bananaText.getText()); i++) {
                shoppingList.remove("banana");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(appleText.getText(), " ") && Integer.parseInt(appleText.getText()) > appleNumber) {
            for (int i = 0; i < Integer.parseInt(appleText.getText()) - appleNumber; i++) {
                shoppingList.add("apple");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < appleNumber - Integer.parseInt(appleText.getText()); i++) {
                shoppingList.remove("apple");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(orangeText.getText(), " ") && Integer.parseInt(orangeText.getText()) > orangeNumber) {
            for (int i = 0; i < Integer.parseInt(orangeText.getText()) - orangeNumber; i++) {
                shoppingList.add("orange");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < orangeNumber - Integer.parseInt(orangeText.getText()); i++) {
                shoppingList.remove("orange");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(cherryText.getText(), " ") && Integer.parseInt(cherryText.getText()) > cherryNumber) {
            for (int i = 0; i < Integer.parseInt(cherryText.getText()) - cherryNumber; i++) {
                shoppingList.add("cherry");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < cherryNumber - Integer.parseInt(cherryText.getText()); i++) {
                shoppingList.remove("cherry");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(mangoText.getText(), " ") && Integer.parseInt(mangoText.getText()) > mangoNumber) {
            for (int i = 0; i < Integer.parseInt(mangoText.getText()) - mangoNumber; i++) {
                shoppingList.add("mango");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < mangoNumber - Integer.parseInt(mangoText.getText()); i++) {
                shoppingList.remove("mango");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(pearText.getText(), " ") && Integer.parseInt(pearText.getText()) > pearNumber) {
            for (int i = 0; i < Integer.parseInt(pearText.getText()) - pearNumber; i++) {
                shoppingList.add("pear");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < pearNumber - Integer.parseInt(pearText.getText()); i++) {
                shoppingList.remove("pear");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(peachText.getText(), " ") && Integer.parseInt(peachText.getText()) > peachNumber) {
            for (int i = 0; i < Integer.parseInt(peachText.getText()) - peachNumber; i++) {
                shoppingList.add("peach");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < peachNumber - Integer.parseInt(peachText.getText()); i++) {
                shoppingList.remove("peach");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(waterMelonText.getText(), " ") && Integer.parseInt(waterMelonText.getText()) > watermelonNumber) {
            for (int i = 0; i < Integer.parseInt(waterMelonText.getText()) - watermelonNumber; i++) {
                shoppingList.add("watermelon");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < watermelonNumber - Integer.parseInt(waterMelonText.getText()); i++) {
                shoppingList.remove("watermelon");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(melonText.getText(), " ") && Integer.parseInt(melonText.getText()) > melonNumber) {
            for (int i = 0; i < Integer.parseInt(melonText.getText()) - melonNumber; i++) {
                shoppingList.add("melon");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < melonNumber - Integer.parseInt(melonText.getText()); i++) {
                shoppingList.remove("melon");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(pineAppleText.getText(), " ") && Integer.parseInt(pineAppleText.getText()) > pineAppleNumber) {
            for (int i = 0; i < Integer.parseInt(pineAppleText.getText()) - pineAppleNumber; i++) {
                shoppingList.add("pine apple");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < pineAppleNumber - Integer.parseInt(pineAppleText.getText()); i++) {
                shoppingList.remove("pine apple");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(grapeText.getText(), " ") && Integer.parseInt(grapeText.getText()) > grapeNumber) {
            for (int i = 0; i < Integer.parseInt(grapeText.getText()) - grapeNumber; i++) {
                shoppingList.add("grape");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < grapeNumber - Integer.parseInt(bananaText.getText()); i++) {
                shoppingList.remove("grape");
                shoppingListString = String.valueOf(shoppingList);
            }
        }

        if (!Objects.equals(strawberryText.getText(), " ") && Integer.parseInt(strawberryText.getText()) > strawberryNumber) {
            for (int i = 0; i < Integer.parseInt(strawberryText.getText()) - strawberryNumber; i++) {
                shoppingList.add("strawberry");
                shoppingListString = String.valueOf(shoppingList);
            }
        } else {
            for (int i = 0; i < strawberryNumber - Integer.parseInt(strawberryText.getText()); i++) {
                shoppingList.remove("strawberry");
                shoppingListString = String.valueOf(shoppingList);
            }
        }
    }

    // This is method for page payment
    public void goToPay() {
        JPanel paymentPanel = new JPanel();
        paymentPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        paymentPanel.setLayout(null);

        ImageIcon paymentIcon = new ImageIcon("/Users/pouyanmb/Desktop/payment.png");
        JLabel paymentBackgroundLabel = new JLabel(paymentIcon);
        paymentBackgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        paymentPanel.add(paymentBackgroundLabel);

        JLabel paymentLabel = new JLabel("PAYMENT");
        paymentLabel.setFont(font1);
        paymentLabel.setBounds(50, 60, 300, 50);
        paymentLabel.setForeground(Color.white);
        paymentBackgroundLabel.add(paymentLabel);

        JLabel announceFinalPrice = new JLabel(" YOUR FINAL TOTAL PRICE IS = " + totalPrice + " $");
        announceFinalPrice.setFont(font2);
        announceFinalPrice.setForeground(Color.white);
        announceFinalPrice.setBounds(90, 145, 400, 50);

        JLabel announceGoToPay = new JLabel("CLICK HERE TO CONNECT PAY PAL !");
        announceGoToPay.setFont(font2);
        announceGoToPay.setForeground(Color.white);
        announceGoToPay.setBounds(95, 240, 400, 50);

        clickMeButton.setForeground(new Color(138, 43, 226));
        clickMeButton.setFont(font1);
        clickMeButton.setBackground(Color.white);
        clickMeButton.setBounds(70, 350, 420, 45);

        paymentBackgroundLabel.add(announceGoToPay);
        paymentBackgroundLabel.add(clickMeButton);
        paymentBackgroundLabel.add(announceFinalPrice);

        continueShoppingButton2.setForeground(new Color(138, 43, 226));
        continueShoppingButton2.setFont(font1);
        continueShoppingButton2.setBackground(Color.white);
        continueShoppingButton2.setBounds(70, 410, 420, 45);
        paymentBackgroundLabel.add(continueShoppingButton2);

        this.add(paymentPanel);
    }

    // This method is for search panel
    public void searchPanel() {
        JPanel searchingPanel = new JPanel();
        searchingPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        searchingPanel.setLayout(null);

        ImageIcon searchIcon = new ImageIcon("/Users/pouyanmb/Desktop/searchback.PNG");
        JLabel searchBackground = new JLabel(searchIcon);
        searchBackground.setBounds(0, 0, this.getWidth(), this.getHeight());
        searchingPanel.add(searchBackground);

        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.setFont(font3);
        searchLabel.setBounds(170, 120, 300, 80);
        searchLabel.setForeground(Color.white);
        searchBackground.add(searchLabel);

        searchTextField.setForeground(new Color(197, 218, 215));
        searchTextField.setFont(font1);
        searchTextField.setBounds(100, 200, 400, 60);

        searchEngineButton.setForeground(new Color(197, 218, 215));
        searchEngineButton.setBackground(Color.white);
        searchEngineButton.setFont(font1);
        searchEngineButton.setBounds(100, 270, 400, 60);

        searchBackground.add(searchEngineButton);
        searchBackground.add(searchTextField);

        showSearchedItemPanel.setBounds(984, 448, 365, 215);
        showSearchedItemPanel.setBackground(Color.white);
        searchBackground.add(showSearchedItemPanel);

        continueShoppingButton2.setForeground(new Color(197, 218, 215));
        continueShoppingButton2.setFont(font1);
        continueShoppingButton2.setBounds(100, 340, 400, 60);
        searchBackground.add(continueShoppingButton2);

        this.add(searchingPanel);
    }

    // This is a method which show the result in searching item
    public void searchResult() {
        if (Objects.equals(searchTextField.getText(), "banana")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(bananaButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "apple")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(appleButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "cherry")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(cherryButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "orange")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(orangeButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "melon")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(melonButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "water melon")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(waterMelonButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "pine apple")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(pineAppleButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "grape")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(grapeButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "pear")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(pearButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "peach")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(peachButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "strawberry")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(strawberryButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
        if (Objects.equals(searchTextField.getText(), "mango")) {
            showSearchedItemPanel.removeAll();
            showSearchedItemPanel.add(mangoButton);
            showSearchedItemPanel.revalidate();
            showSearchedItemPanel.repaint();
        }
    }

    // This method is for balance Panel
    public void balancePanel() {
        JPanel balanceP = new JPanel();
        balanceP.setBounds(0, 0, this.getWidth(), this.getHeight());
        balanceP.setLayout(null);

        ImageIcon balanceIcon = new ImageIcon("/Users/pouyanmb/Desktop/balancebackground.png");
        JLabel balanceBackground = new JLabel(balanceIcon);
        balanceBackground.setBounds(0, 0, this.getWidth(), this.getHeight());
        balanceP.add(balanceBackground);

        JLabel balanceLabel = new JLabel("BALANCE");
        balanceLabel.setFont(font3);
        balanceLabel.setBounds(50, 60, 300, 50);
        balanceLabel.setForeground(Color.white);
        balanceBackground.add(balanceLabel);

        currentBalance.setText("Your Current Balance : " + getBalanceByUsername(userNameString) + " $");
        currentBalance.setFont(font1);
        currentBalance.setForeground(Color.white);
        currentBalance.setBounds(50, 155, 1000, 100);
        balanceBackground.add(currentBalance);

        JLabel chargeBalance = new JLabel("Charge Your Account : ");
        chargeBalance.setFont(font1);
        chargeBalance.setForeground(Color.white);
        chargeBalance.setBounds(50, 240, 500, 100);
        balanceBackground.add(chargeBalance);

        chargeAmount1.setFont(font1);
        chargeAmount1.setForeground(new Color(220, 72, 77));
        chargeAmount1.setBackground(Color.white);
        chargeAmount1.setBounds(480, 260, 300, 70);
        balanceBackground.add(chargeAmount1);

        chargeAmount2.setFont(font1);
        chargeAmount2.setForeground(new Color(220, 72, 77));
        chargeAmount2.setBackground(Color.white);
        chargeAmount2.setBounds(790, 260, 300, 70);
        balanceBackground.add(chargeAmount2);

        chargeAmount3.setFont(font1);
        chargeAmount3.setForeground(new Color(220, 72, 77));
        chargeAmount3.setBackground(Color.white);
        chargeAmount3.setBounds(1100, 260, 300, 70);
        balanceBackground.add(chargeAmount3);

        balanceBackground.add(continueShoppingButton2);
        continueShoppingButton2.setFont(font1);
        continueShoppingButton2.setForeground(new Color(220, 72, 77));
        continueShoppingButton2.setBounds(480, 350, 930, 70);

        increaseBalance.setFont(font1);
        increaseBalance.setForeground(new Color(220, 72, 77));
        increaseBalance.setBounds(480, 440, 930, 70);
        balanceBackground.add(increaseBalance);


        this.add(balanceP);
    }

    public void updateClientBalance(String username, double balance) {
        String updateSQL = "UPDATE client_data SET balance = ? WHERE user_name = ?";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // Set the parameters
            pstmt.setDouble(1, balance);
            pstmt.setString(2, username);

            // Execute the update
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                sendMessageToUser("Your balance now is : " + balance + " !");
            } else {
                sendMessageToUser("Error !");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Double getBalanceByUsername(String username) {
        String selectSQL = "SELECT balance FROM client_data WHERE user_Name = ?";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            // Set the username parameter
            pstmt.setString(1, username);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            if (rs.next()) {
                balance = rs.getDouble("balance");
            } else {
                System.out.println("No user found with username: " + username);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return balance;
    }

    // This method is for rating panel
    public void ratePanel() {
        JPanel rateP = new JPanel();
        rateP.setBounds(0, 0, this.getWidth(), this.getHeight());
        rateP.setLayout(null);

        ImageIcon rateIcon = new ImageIcon("/Users/pouyanmb/Desktop/rateback.png");
        JLabel rateBackground = new JLabel(rateIcon);
        rateBackground.setBounds(0, 0, this.getWidth(), this.getHeight());
        rateP.add(rateBackground);

        JLabel rateLabel = new JLabel("RATE");
        rateLabel.setFont(font1);
        rateLabel.setBounds(50, 60, 300, 50);
        rateLabel.setForeground(Color.white);
        rateBackground.add(rateLabel);

        bananaLabel.setFont(font2);
        bananaLabel.setForeground(Color.white);
        bananaLabel.setBounds(50, 150, 200, 50);

        appleLabel.setForeground(Color.white);
        appleLabel.setFont(font2);
        appleLabel.setBounds(50, 200, 200, 50);

        orangeLabel.setForeground(Color.white);
        orangeLabel.setFont(font2);
        orangeLabel.setBounds(50, 250, 200, 50);

        cherryLabel.setForeground(Color.white);
        cherryLabel.setFont(font2);
        cherryLabel.setBounds(50, 300, 200, 50);

        mangoLabel.setForeground(Color.white);
        mangoLabel.setFont(font2);
        mangoLabel.setBounds(50, 350, 200, 50);

        pearLabel.setForeground(Color.white);
        pearLabel.setFont(font2);
        pearLabel.setBounds(50, 400, 200, 50);

        peachLabel.setForeground(Color.white);
        peachLabel.setFont(font2);
        peachLabel.setBounds(50, 450, 200, 50);

        watermelonLabel.setForeground(Color.white);
        watermelonLabel.setFont(font2);
        watermelonLabel.setBounds(50, 500, 200, 50);

        melonLabel.setForeground(Color.white);
        melonLabel.setFont(font2);
        melonLabel.setBounds(50, 550, 200, 50);

        pineAppleLabel.setForeground(Color.white);
        pineAppleLabel.setFont(font2);
        pineAppleLabel.setBounds(50, 600, 200, 50);

        grapeLabel.setForeground(Color.white);
        grapeLabel.setFont(font2);
        grapeLabel.setBounds(50, 650, 200, 50);

        strawberryLabel.setForeground(Color.white);
        strawberryLabel.setFont(font2);
        strawberryLabel.setBounds(50, 700, 200, 50);

        rateBackground.add(bananaLabel);
        rateBackground.add(appleLabel);
        rateBackground.add(orangeLabel);
        rateBackground.add(cherryLabel);
        rateBackground.add(mangoLabel);
        rateBackground.add(pearLabel);
        rateBackground.add(watermelonLabel);
        rateBackground.add(melonLabel);
        rateBackground.add(peachLabel);
        rateBackground.add(pineAppleLabel);
        rateBackground.add(grapeLabel);
        rateBackground.add(strawberryLabel);

        bananaRateText.setFont(font2);
        bananaRateText.setForeground(new Color(75,0,130));
        bananaRateText.setBounds(250, 150, 50, 50);
        bananaRateText.setText(String.valueOf(fruitCounter("banana")));

        appleRateText.setFont(font2);
        appleRateText.setBounds(250, 200, 50, 50);
        appleRateText.setForeground(new Color(75,0,130));
        appleRateText.setText(String.valueOf(fruitCounter("apple")));

        orangeRateText.setFont(font2);
        orangeRateText.setBounds(250, 250, 50, 50);
        orangeRateText.setForeground(new Color(75,0,130));
        orangeRateText.setText(String.valueOf(fruitCounter("orange")));

        cherryRateText.setFont(font2);
        cherryRateText.setBounds(250, 300, 50, 50);
        cherryRateText.setForeground(new Color(75,0,130));
        cherryRateText.setText(String.valueOf(fruitCounter("cherry")));

        mangoRateText.setFont(font2);
        mangoRateText.setBounds(250, 350, 50, 50);
        mangoRateText.setForeground(new Color(75,0,130));
        mangoRateText.setText(String.valueOf(fruitCounter("mango")));

        pearRateText.setFont(font2);
        pearRateText.setBounds(250, 400, 50, 50);
        pearRateText.setForeground(new Color(75,0,130));
        pearRateText.setText(String.valueOf(fruitCounter("pear")));

        peachRateText.setFont(font2);
        peachRateText.setBounds(250, 450, 50, 50);
        peachRateText.setForeground(new Color(75,0,130));
        peachRateText.setText(String.valueOf(fruitCounter("peach")));

        waterMelonRateText.setFont(font2);
        waterMelonRateText.setBounds(250, 500, 50, 50);
        waterMelonRateText.setForeground(new Color(75,0,130));
        waterMelonRateText.setText(String.valueOf(fruitCounter("watermelon")));

        melonRateText.setFont(font2);
        melonRateText.setBounds(250, 550, 50, 50);
        melonRateText.setForeground(new Color(75,0,130));
        melonRateText.setText(String.valueOf(fruitCounter("melon")));

        pineAppleRateText.setFont(font2);
        pineAppleRateText.setBounds(250, 600, 50, 50);
        pineAppleRateText.setForeground(new Color(75,0,130));
        pineAppleRateText.setText(String.valueOf(fruitCounter("pine apple")));

        grapeRateText.setFont(font2);
        grapeRateText.setBounds(250, 650, 50, 50);
        grapeRateText.setForeground(new Color(75,0,130));
        grapeRateText.setText(String.valueOf(fruitCounter("grape")));

        strawberryRateText.setFont(font2);
        strawberryRateText.setBounds(250, 700, 50, 50);
        strawberryRateText.setForeground(new Color(75,0,130));
        strawberryRateText.setText(String.valueOf(fruitCounter("strawberry")));

        rateBackground.add(bananaRateText);
        rateBackground.add(appleRateText);
        rateBackground.add(orangeRateText);
        rateBackground.add(cherryRateText);
        rateBackground.add(mangoRateText);
        rateBackground.add(pearRateText);
        rateBackground.add(waterMelonRateText);
        rateBackground.add(melonRateText);
        rateBackground.add(peachRateText);
        rateBackground.add(pineAppleRateText);
        rateBackground.add(grapeRateText);
        rateBackground.add(bananaRateText);
        rateBackground.add(strawberryRateText);

        confirmRates.setForeground(new Color(75,0,130));
        confirmRates.setFont(font2);
        confirmRates.setBackground(Color.white);
        confirmRates.setBounds(40 ,780 , 280 , 50);

        continueShoppingButton2.setForeground(new Color(75,0,130));
        continueShoppingButton2.setBackground(Color.white);
        continueShoppingButton2.setFont(font2);
        continueShoppingButton2.setBounds(40 , 840, 280 , 50);

        rateBackground.add(continueShoppingButton2);
        rateBackground.add(confirmRates);


        this.add(rateP);
    }

    public static void updateRate(String productName, int newRate) {
        // Check if the rate is within the valid range
        if (newRate < 1 || newRate > 5) {
            System.out.println("Rate must be between 1 and 5.");
            return;
        }

        String selectSQL = "SELECT rate FROM product WHERE product_name = ?";
        String updateSQL = "UPDATE product SET rate = ? WHERE product_name = ?";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

            // Retrieve the current rate
            selectStmt.setString(1, productName);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                double currentRate = rs.getDouble("rate");
                double newAverageRate = (currentRate + newRate) / 2;

                // Set the parameters for the update statement
                updateStmt.setDouble(1, newAverageRate);
                updateStmt.setString(2, productName);

                // Execute the update statement
                int affectedRows = updateStmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Rate updated successfully for product: " + productName);
                } else {
                    System.out.println("Product not found: " + productName);
                }
            } else {
                System.out.println("No product found with name: " + productName);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clientNewProductPanel () {
        JPanel NPP = new JPanel();
        NPP.setBounds(0 , 0 ,this.getWidth() , this.getHeight() - 100);
        NPP.setLayout(new GridLayout(2 , 3));
        JButton b1 = new JButton("");
        JButton b2 = new JButton("");
        JButton b3 = new JButton("");
        JButton b4 = new JButton("");
        JButton b5 = new JButton("");

        addedProduct.setForeground(new Color(123, 170, 102));

        continueShoppingButton2.setBounds( 0 , this.getHeight() - 100 , this.getWidth() , 100 );
        continueShoppingButton2.setFont(font1);
        continueShoppingButton2.setForeground(new Color(123, 170, 102));
        this.add(continueShoppingButton2);

        NPP.add(addedProduct);
        NPP.add(b1);
        NPP.add(b2);
        NPP.add(b3);
        NPP.add(b4);
        NPP.add(b5);

        this.add(NPP);

    }


    ///////////////////////////////////////////////////////////// MANAGER GRAPHIC ///////////////////////////////////////////////////////////////
    // HERE IS MANAGER PART GRAPHIC :

    JButton managerBack = new JButton("BACK");

    // these are 6 buttons of manager panel and manger panel its self
    JPanel managerPanel = new JPanel();
    JButton searchManagerButton = new JButton("Search");
    JButton clientsButton = new JButton("Clients");
    JButton saleButton = new JButton("Sale $");
    JButton repositoryButton = new JButton("Repository");
    JButton addingProductButton = new JButton("Add Product");
    JButton productsButton = new JButton("Product List");
    JButton managerSearchEngine = new JButton("GO !") ;

    // these are login manager items
    JButton loginManagerButton = new JButton("LOG IN");
    JLabel employee_code = new JLabel("Employee Code");
    JTextField employee_codeText = new JTextField();
    JLabel employeePassword = new JLabel("Password");
    JTextField employeePasswordText = new JTextField();

    // these are search panel things
    JPanel managerShowSearchedItemPanel = new JPanel();
    JTextField managerSearchText = new JTextField();

    String employeeCodeString;
    String employeePasswordString;

    public void addManagerActionListener() {
        clientsButton.addActionListener(this);
        managerBack.addActionListener(this);
        repositoryButton.addActionListener(this);
        searchManagerButton.addActionListener(this);
        managerSearchEngine.addActionListener(this);
        saleButton.addActionListener(this);
        productsButton.addActionListener(this);
        addingProductButton.addActionListener(this);
        addProductButton.addActionListener(this);
    }

    public void loginManager () {
        JPanel managerLogin = new JPanel();
        managerLogin.setBounds(0 , 0 , this.getWidth() , this.getHeight());
        managerLogin.setBackground(new Color(0 , 65 , 80));
        managerLogin.setLayout(null);

        JLabel signInManagerLabel = new JLabel("Log In");
        signInManagerLabel.setFont(font1);
        signInManagerLabel.setBounds(400, 100, 650, 40);
        signInManagerLabel.setBackground(new Color(80, 165, 185));
        signInManagerLabel.setForeground(Color.white);
        managerLogin.add(signInManagerLabel);

        loginManagerButton.addActionListener(this);
        loginManagerButton.setFont(font2);
        loginManagerButton.setForeground(Color.white);
        loginManagerButton.setForeground(new Color(0 , 65 , 80));
        loginManagerButton.setBounds(400, 600, 650, 70);

        backButton = new JButton("Back");
        backButton.setForeground(Color.white);
        backButton.setForeground(new Color(0 , 65 , 80));
        backButton.setFont(font2);
        backButton.addActionListener(this);
        backButton.setBounds(400, 500, 650, 70);

        employee_code.setBounds(400, 170, 300, 50);
        employee_code.setForeground(Color.white);
        employee_code.setFont(font2);

        employee_codeText.setBounds(800, 180, 300, 30);
        employee_codeText.setForeground(new Color(0 , 65 , 80));
        employee_codeText.setFont(font2);

        employeePassword.setBounds(400, 220, 300, 50);
        employeePassword.setForeground(Color.white);
        employeePassword.setFont(font2);

        employeePasswordText.setBounds(800, 230, 300, 30);
        employeePasswordText.setForeground(new Color(0 , 65 , 80));
        employeePasswordText.setFont(font2);

        managerLogin.add(employeePasswordText);
        managerLogin.add(employee_codeText);
        managerLogin.add(employee_code);
        managerLogin.add(employeePassword);
        managerLogin.add(backButton);
        managerLogin.add(loginManagerButton);

        this.add(managerLogin);
    }

    public boolean checkLoginManagerDB(String employeeCode, String password) {
        String selectSQL = "SELECT COUNT(*) FROM manager_data WHERE employee_code = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            // Set the parameters for the select statement
            pstmt.setString(1, employeeCode);
            pstmt.setString(2, password);

            // Execute the select statement
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // return true if at least one row matches
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public void managerPanel() {

        managerPanel.setBounds(0 , 0 , this.getWidth() , this.getHeight()-100);
        managerPanel.setLayout(new GridLayout(2, 3));

        searchManagerButton.setFont(font3);
        searchManagerButton.setForeground(new Color(0 , 65 , 80));

        clientsButton.setFont(font3);
        clientsButton.setForeground(new Color(0 , 65 , 80));

        saleButton.setFont(font3);
        saleButton.setForeground(new Color(0 , 65 , 80));

        repositoryButton.setFont(font3);
        repositoryButton.setForeground(new Color(0 , 65 , 80));

        addingProductButton.setFont(font3);
        addingProductButton.setForeground(new Color(0 , 65 , 80));

        productsButton.setFont(font3);
        productsButton.setForeground(new Color(0 , 65 , 80));

        managerPanel.add(searchManagerButton);
        managerPanel.add(clientsButton);
        managerPanel.add(saleButton);
        managerPanel.add(repositoryButton);
        managerPanel.add(addingProductButton);
        managerPanel.add(productsButton);

        backButton.setText("Back");
        backButton.setFont(font1);
        backButton.setBounds(0 , this.getHeight() - 100 , this.getWidth() , 100);
        this.add(backButton);

        System.out.println(getUserNamesAndShoppingLists());
        getUserNamesAndShoppingLists();

        this.add(managerPanel);
    }

    public void clientList() {
            // Initialize the JLabel
            JLabel resultLabel = new JLabel();
            resultLabel.setOpaque(true);
            resultLabel.setBackground(new Color(0, 65, 80));
            resultLabel.setBounds(0 , 0 , this.getWidth() , this.getHeight() - 100);
            resultLabel.setFont(font1);
            resultLabel.setForeground(Color.white);

            JLabel clientListLabel = new JLabel("Client List");
            clientListLabel.setFont(font3);
            clientListLabel.setBounds(50, 60, 400, 50);
            clientListLabel.setForeground(Color.white);
            resultLabel.add(clientListLabel);

            managerBack.setFont(font1);
            managerBack.setForeground(new Color(0 , 65 , 80));
            managerBack.setBounds(0 , this.getHeight()-100 , this.getWidth() , 100);
            this.add(managerBack);

            this.add(resultLabel);

            // Fetch data and set text of the JLabel
            String userList = getUserNamesAndShoppingLists();
            resultLabel.setText("<html>" + userList.replace("\n", "<br>") + "</html>");
    }
    public String getUserNamesAndShoppingLists() {
        String selectSQL = "SELECT user_Name, shopping_list FROM client_data";
        StringBuilder result = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String userName = rs.getString("user_Name");
                String shoppingList = rs.getString("shopping_list");
                result.append("User: ").append(userName).append(", Shopping List: ").append(shoppingList).append("\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result.toString();
    }

    public  String getProductNamesAndNumbers() {
        StringBuilder result = new StringBuilder();
        String selectSQL = "SELECT product_name, product_number FROM product";

        try (Connection conn = DriverManager.getConnection(urlDB, userNameDB, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String productName = rs.getString("product_name");
                int productNumber = rs.getInt("product_number");
                result.append("Product: ").append(productName).append(", Number: ").append(productNumber).append("\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result.toString();
    }

    public void repositoryPanel() {
        // Initialize the JLabel
        JLabel productLabel = new JLabel();
        productLabel.setBounds(0 , 0 , this.getWidth() , this.getHeight()-100);
        productLabel.setFont(font1);

        JLabel repositoryLabel = new JLabel("Repository Record");
        repositoryLabel.setFont(font3);
        repositoryLabel.setBounds(50, 60, 600, 50);
        repositoryLabel.setForeground(Color.white);
        productLabel.add(repositoryLabel);

        // Set the background color of the JLabel
        productLabel.setOpaque(true); // Make the JLabel opaque
        productLabel.setBackground(new Color(0, 65, 80));

        // Set the text color of the JLabel to ensure it is readable
        productLabel.setForeground(Color.WHITE);

        managerBack.setFont(font1);
        managerBack.setForeground(new Color(0, 65, 80));
        managerBack.setBounds(0 , this.getHeight()-100 , this.getWidth() , 100);

        this.add(managerBack);
        this.add(productLabel);

        // Fetch data and set text of the JLabel
        String productList = getProductNamesAndNumbers();
        productLabel.setText("<html>" + productList.replace("\n", "<br>") + "</html>");
    }
    public void managerSearchPanel () {
        JPanel managerSearchPanel = new JPanel();
        managerSearchPanel.setBounds(0 , 0, this.getWidth() , this.getHeight() - 100);
        managerSearchPanel.setLayout(null);
        managerSearchPanel.setBackground(new Color(0, 65, 80));

        JLabel managerSearchLabel = new JLabel("SEARCH");
        managerSearchLabel.setFont(font1);
        managerSearchLabel.setBounds(670 , 100 , 200 , 100 );
        managerSearchLabel.setForeground(Color.white);
        managerSearchPanel.add(managerSearchLabel);

        managerSearchText.setFont(font1);
        managerSearchText.setBounds(550 , 200 , 400 , 60 );
        managerSearchText.setForeground(new Color(0, 65, 80));
        managerSearchPanel.add(managerSearchText);

        managerSearchEngine.setBounds(550 , 280 , 400 , 60);
        managerSearchEngine.setFont(font1);
        managerSearchEngine.setForeground(new Color(0, 65, 80));
        managerSearchPanel.add(managerSearchEngine);

        managerShowSearchedItemPanel.setBounds(570 , 400 ,365, 215 );
        managerShowSearchedItemPanel.setBackground(Color.white);
        managerSearchPanel.add(managerShowSearchedItemPanel);

        managerBack.setBounds(0 , this.getHeight()-100 , this.getWidth() , 100);
        managerBack.setForeground(new Color(0, 65, 80));
        managerBack.setFont(font1);
        this.add(managerBack);

        this.add(managerSearchPanel);
    }
    public void managerSearchResult() {
        if (Objects.equals(managerSearchText.getText(), "banana")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(bananaButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "apple")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(appleButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "cherry")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(cherryButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "orange")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(orangeButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "melon")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(melonButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "water melon")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(waterMelonButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "pine apple")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(pineAppleButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "grape")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(grapeButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "pear")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(pearButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "peach")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(peachButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "strawberry")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(strawberryButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
        if (Objects.equals(managerSearchText.getText(), "mango")) {
            managerShowSearchedItemPanel.removeAll();
            managerShowSearchedItemPanel.add(mangoButton);
            managerShowSearchedItemPanel.revalidate();
            managerShowSearchedItemPanel.repaint();
        }
    }

    public void salePanel () {
        JPanel sailP = new JPanel();
        sailP.setBounds(0 , 0, this.getWidth() , this.getHeight() - 100);
        sailP.setLayout(null);
        sailP.setBackground(new Color(0, 65, 80));

        JLabel saleLabel = new JLabel("Sale Amount");
        saleLabel.setFont(font3);
        saleLabel.setBounds(50, 60, 600, 50);
        saleLabel.setForeground(Color.white);
        sailP.add(saleLabel);

        JLabel sailAmount = new JLabel(getTotalSales() + " $");
        sailAmount.setFont(font3);
        sailAmount.setBounds(670 , 100 , 200 , 100 );
        sailAmount.setForeground(Color.white);
        sailP.add(sailAmount);

        managerBack.setBounds(0 , this.getHeight()-100 , this.getWidth() , 100);
        managerBack.setForeground(new Color(0, 65, 80));
        managerBack.setFont(font1);
        this.add(managerBack);

        this.add(sailP);
    }

    public void productsPanel() {
        JPanel sailP = new JPanel();
        sailP.setBounds(0 , 0, this.getWidth() , this.getHeight() - 100);
        sailP.setLayout(new GridLayout(3,4));
        sailP.setBackground(new Color(0, 65, 80));

        sailP.add(bananaButton);
        sailP.add(appleButton);
        sailP.add(cherryButton);
        sailP.add(orangeButton);
        sailP.add(pearButton);
        sailP.add(peachButton);
        sailP.add(pineAppleButton);
        sailP.add(mangoButton);
        sailP.add(strawberryButton);
        sailP.add(grapeButton);
        sailP.add(melonButton);
        sailP.add(waterMelonButton);


        managerBack.setBounds(0 , this.getHeight()-100 , this.getWidth() , 100);
        managerBack.setForeground(new Color(0, 65, 80));
        managerBack.setFont(font1);
        this.add(managerBack);

        this.add(sailP);
    }

    JLabel newProductName = new JLabel();
    JLabel newProductPrice = new JLabel();
    JLabel newProductRepositoryNumber = new JLabel();

    JTextField newProductNameText = new JTextField();
    JTextField newProductPriceText = new JTextField();
    JTextField newProductRepositoryNumberText = new JTextField();

    JButton addProductButton = new JButton("Add Item");

    double newProductPriceDouble;
    String newProductNameString;
    int newProductNumberInteger;


    public void addProductPanel() {
        JPanel addPanel = new JPanel();
        addPanel.setBounds(0 , 0, this.getWidth() , this.getHeight() - 100);
        addPanel.setLayout(null);
        addPanel.setBackground(new Color(0, 65, 80));

        JLabel addProductLabel = new JLabel("Add Product");
        addProductLabel.setFont(font3);
        addProductLabel.setBounds(50, 60, 600, 50);
        addProductLabel.setForeground(Color.white);
        addPanel.add(addProductLabel);

        newProductName.setText("New Product Name");
        newProductName.setBounds(300 , 250 , 200 , 50);
        newProductName.setForeground(Color.white);
        newProductName.setFont(font2);

        newProductPrice.setText("New Product Price");
        newProductPrice.setBounds(300 , 350 , 200 , 50);
        newProductPrice.setForeground(Color.white);
        newProductPrice.setFont(font2);

        newProductRepositoryNumber.setText("Repository Number");
        newProductRepositoryNumber.setBounds(300 , 450 , 200 , 50);
        newProductRepositoryNumber.setForeground(Color.white);
        newProductRepositoryNumber.setFont(font2);

        newProductNameText.setBounds(600 , 250 , 400 , 50);
        newProductNameText.setForeground(new Color(0, 65, 80));
        newProductNameText.setFont(font2);

        newProductPriceText.setBounds(600 , 350 , 400 , 50);
        newProductPriceText.setForeground(new Color(0, 65, 80));
        newProductPriceText.setFont(font2);

        newProductRepositoryNumberText.setBounds(600 , 450 , 400 , 50);
        newProductRepositoryNumberText.setForeground(new Color(0, 65, 80));
        newProductRepositoryNumberText.setFont(font2);

        addProductButton.setBounds(290 , 550 , 715 , 70);
        addProductButton.setFont(font1);
        addProductButton.setForeground(new Color(0, 65, 80));

        addPanel.add(newProductPrice);
        addPanel.add(newProductRepositoryNumber);
        addPanel.add(newProductName);
        addPanel.add(newProductPriceText);
        addPanel.add(newProductRepositoryNumberText);
        addPanel.add(newProductNameText);
        addPanel.add(addProductButton);

        managerBack.setBounds(0 , this.getHeight()-100 , this.getWidth() , 100);
        managerBack.setForeground(new Color(0, 65, 80));
        managerBack.setFont(font1);
        this.add(managerBack);

        this.add(addPanel);
    }

    public  void addProduct(String productName, int productNumber, double productPrice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(urlDB, userNameDB, passwordDB);

            // Prepare the SQL query
            String sql = "INSERT INTO product (product_name, product_number, product_price) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters
            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, productNumber);
            preparedStatement.setDouble(3, productPrice);

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }










    // This is action listeners
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            backButton.setFont(font1);
            this.getContentPane().removeAll();
            this.add(firstPage);
            this.revalidate();
            this.repaint();

            userNameText.setText("");
            passwordText.setText("");
            firstNameText.setText("");
            lastNameText.setText("");
            addressText.setText("");
            phoneNumberText.setText("");

            shoppingList.clear();
        }
        if (e.getSource() == clientButton) {
            this.getContentPane().removeAll();
            clientLoginSignup();
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == signUpButton) {
            this.getContentPane().removeAll();
            signUp();
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == signInButton) {
            this.getContentPane().removeAll();
            login();
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == welcomeButton) {
            this.getContentPane().removeAll();
            try {
                firstPage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.revalidate();
            this.repaint();
        }

        if (e.getSource() == submitButton) {
            userNameString = userNameText.getText();
            firstNameString = firstNameText.getText();
            lastNameString = lastNameText.getText();
            phoneNumberString = phoneNumberText.getText();
            addressString = addressText.getText();
            passwordString = passwordText.getText();

            if (userNameText.getText().length() != 0 && firstNameText.getText().length() != 0 && lastNameText.getText().length() != 0
                    && phoneNumberText.getText().length() != 0 && addressText.getText().length() != 0 && passwordText.getText().length() != 0) {

                if (signUpConditions(userNameString, firstNameString, lastNameString, phoneNumberString, addressString, passwordString)) {
                    addUserToDB(userNameString, firstNameString, lastNameString, phoneNumberString, addressString, passwordString);
                    this.getContentPane().removeAll();
                    sendMessageToUser("You created your account successfully . Go log in !");
                    clientLoginSignup();
                    this.revalidate();
                    this.repaint();
                    userNameText.setText("");
                    firstNameText.setText("");
                    lastNameText.setText("");
                    phoneNumberText.setText("");
                    addressText.setText("");
                    passwordText.setText("");
                }
            }
        }

        if (e.getSource() == loginButton) {
            if (userNameText.getText().length() != 0 && passwordText.getText().length() != 0) {

                userNameString = userNameText.getText();
                passwordString = passwordText.getText();

                if (checkLoginInfoToDB(userNameString, passwordString)) {
                    this.getContentPane().removeAll();
                    shoppingPanel(userNameString, passwordString);
                    this.revalidate();
                    this.repaint();
                    sendMessageToUser(" Your login was completely successful ! ");
                    userNameText.setText("");
                    passwordText.setText("");
                } else {
                    sendMessageToUser(" Your UserName Or Password Is Incorrect . Try again!");
                    userNameText.setText("");
                    passwordText.setText("");
                }
            }
        }

        if (e.getSource() == personalInfoButton) {
            this.getContentPane().removeAll();
            accountInfoPanel(userNameString);
            this.revalidate();
            this.repaint();
        }

        if (e.getSource() == cartButton) {
            this.getContentPane().removeAll();
            cart();
            this.revalidate();
            this.repaint();
        }

        if (e.getSource() == resetShoppingList) {
            bananaText.setText(String.valueOf(fruitCounter("")));
            appleText.setText(String.valueOf(fruitCounter("")));
            orangeText.setText(String.valueOf(fruitCounter("")));
            cherryText.setText(String.valueOf(fruitCounter("")));
            mangoText.setText(String.valueOf(fruitCounter("")));
            pearText.setText(String.valueOf(fruitCounter("")));
            peachText.setText(String.valueOf(fruitCounter("")));
            waterMelonText.setText(String.valueOf(fruitCounter("")));
            melonText.setText(String.valueOf(fruitCounter("")));
            pineAppleText.setText(String.valueOf(fruitCounter("")));
            grapeText.setText(String.valueOf(fruitCounter("")));
            strawberryText.setText(String.valueOf(fruitCounter("")));

            bananaPriceLabel.setText("0 $");
            applePriceLabel.setText("0 $");
            cherryPriceLabel.setText("0 $");
            mangoPriceLabel.setText("0 $");
            orangePriceLabel.setText("0 $");
            pearPriceLabel.setText("0 $");
            peachPriceLabel.setText("0 $");
            waterMelonPriceLabel.setText("0 $");
            melonPriceLabel.setText("0 $");
            pineApplePriceLabel.setText("0 $");
            grapePriceLabel.setText("0 $");
            strawberryPriceLabel.setText("0 $");

            totalPriceLabel.setText("");
            totalPrice = 0;

            shoppingList.clear();

            try (Connection connection = DriverManager.getConnection(urlDB, userNameDB, passwordDB)) {
                String query = "UPDATE Client_data SET shopping_list = NULL WHERE user_name = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, userNameString);
                }
            } catch (SQLException p) {
                p.printStackTrace();
            }

        }

        if (e.getSource() == finalCartButton) {
            if (getBalanceByUsername(userNameString) > totalPrice) {
                this.getContentPane().removeAll();
                goToPay();
                this.revalidate();
                this.repaint();
            } else {
                sendMessageToUser("You have not enough mooney ! Charge your balance.");
            }
        }

        if ( e.getSource() == clickMeButton) {
            updateProductNumber("banana" , Integer.parseInt(bananaText.getText()));
            updateProductNumber("apple" , Integer.parseInt(appleText.getText()));
            updateProductNumber("orange" , Integer.parseInt(orangeText.getText()));
            updateProductNumber("cherry" , Integer.parseInt(cherryText.getText()));
            updateProductNumber("mango" , Integer.parseInt(mangoText.getText()));
            updateProductNumber("pear" , Integer.parseInt(pearText.getText()));
            updateProductNumber("peach" , Integer.parseInt(peachText.getText()));
            updateProductNumber("water melon" , Integer.parseInt(waterMelonText.getText()));
            updateProductNumber("melon" , Integer.parseInt(melonText.getText()));
            updateProductNumber("pine apple" , Integer.parseInt(pineAppleText.getText()));
            updateProductNumber("grape" , Integer.parseInt(grapeText.getText()));
            updateProductNumber("strawberry" , Integer.parseInt(strawberryText.getText()));

            updateBalance(userNameString,totalPrice);

            updateShoppingList(userNameString , shoppingListString);

            sendMessageToUser("DONE SUCCESSFULLY !");

            saleAmount += totalPrice;

            updateSale(userNameString , saleAmount);

            bananaText.setText("");
            appleText.setText("");
            orangeText.setText("");
            cherryText.setText("");
            pearText.setText("");
            peachText.setText("");
            melonText.setText("");
            waterMelonText.setText("");
            mangoText.setText("");
            grapeText.setText("");
            strawberryText.setText("");
            pineAppleText.setText("");
            totalPriceLabel.setText("");
            shoppingList.clear();

        }
        if (e.getSource() == continueShoppingButton) {
            this.getContentPane().removeAll();
            shoppingPanel(userNameString, passwordString);
            changeCartInCartPanel();
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == continueShoppingButton2) {
            this.getContentPane().removeAll();
            shoppingPanel(userNameString, passwordString);
            this.revalidate();
            this.repaint();

            searchTextField.setText("");
        }

        if (e.getSource() == changePassButton) {
            if (changePassword(userNameString, passwordText.getText())) {
                sendMessageToUser(" Your Password Has Changes Successfully ! ");
                this.getContentPane().removeAll();
                shoppingPanel(userNameString, passwordString);
                this.revalidate();
                this.repaint();
            }
        }

        if (e.getSource() == sortByPriceButton) {

            showItems.remove(bananaButton);
            showItems.remove(appleButton);
            showItems.remove(cherryButton);
            showItems.remove(grapeButton);
            showItems.remove(peachButton);
            showItems.remove(pearButton);
            showItems.remove(waterMelonButton);
            showItems.remove(melonButton);
            showItems.remove(strawberryButton);
            showItems.remove(orangeButton);
            showItems.remove(mangoButton);
            showItems.remove(pineAppleButton);

            showItems.revalidate();
            showItems.repaint();

            showItems.add(pineAppleButton);
            showItems.add(mangoButton);
            showItems.add(cherryButton);
            showItems.add(bananaButton);
            showItems.add(strawberryButton);
            showItems.add(waterMelonButton);
            showItems.add(grapeButton);
            showItems.add(peachButton);
            showItems.add(orangeButton);
            showItems.add(appleButton);
            showItems.add(pearButton);
            showItems.add(melonButton);
        }

        if (e.getSource() == searchButton) {
            this.getContentPane().removeAll();
            searchPanel();
            this.revalidate();
            this.repaint();
        }

        if (e.getSource() == searchEngineButton) { // GO! button
            searchResult();
        }
        if (e.getSource() == balanceButton) {
            this.getContentPane().removeAll();
            balancePanel();
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == chargeAmount1) {
            balance += 10;
            currentBalance.setText("Your Current Balance : " + balance + " $");
        }
        if (e.getSource() == chargeAmount2) {
            balance += 20;
            currentBalance.setText("Your Current Balance : " + balance + " $");
        }
        if (e.getSource() == chargeAmount3) {
            balance += 30;
            currentBalance.setText("Your Current Balance : " + balance + " $");
        }
        if (e.getSource() == increaseBalance) {
            updateClientBalance(userNameString, balance);
        }
        if ( e.getSource() == rateButton) {
            this.getContentPane().removeAll();
            ratePanel();
            this.revalidate();
            this.repaint();
        }
        if ( e.getSource() == confirmRates){
            this.getContentPane().removeAll();
            updateRate("banana" , Integer.parseInt(bananaRateText.getText()));
            updateRate("apple" , Integer.parseInt(appleRateText.getText()));
            updateRate("cherry" , Integer.parseInt(cherryRateText.getText()));
            updateRate("orange" , Integer.parseInt(orangeRateText.getText()));
            updateRate("mango" , Integer.parseInt(mangoRateText.getText()));
            updateRate("water melon" , Integer.parseInt(waterMelonRateText.getText()));
            updateRate("pear" , Integer.parseInt(pearRateText.getText()));
            updateRate("peach" , Integer.parseInt(peachRateText.getText()));
            updateRate("melon" , Integer.parseInt(melonRateText.getText()));
            updateRate("pine apple" , Integer.parseInt(pineAppleRateText.getText()));
            updateRate("grape" , Integer.parseInt(grapeRateText.getText()));
            updateRate("strawberry" , Integer.parseInt(strawberryRateText.getText()));
            this.sendMessageToUser("FINISHED SUCCESSFULLY ! THANK YOU FOR YOUR TIME !");
            shoppingPanel(userNameString,passwordString);
            this.revalidate();
            this.repaint();

            bananaRateText.setText("");
            appleRateText.setText("");
            cherryRateText.setText("");
            orangeRateText.setText("");
            mangoRateText.setText("");
            waterMelonRateText.setText("");
            pearRateText.setText("");
            peachRateText.setText("");
            melonRateText.setText("");
            pineAppleRateText.setText("");
            grapeRateText.setText("");
            strawberryRateText.setText("");
        }

        // fruits action listener for shopping list
        if (e.getSource() == bananaButton) {
            shoppingList.add("banana");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("banana") <= bananaNumberDB) {
                    sendMessageToUser(fruitCounter("banana") + "st 'Banana' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + bananaNumberDB + " BANANA IN OUR STORE !");
                shoppingList.remove("banana");
            }
        }
        if (e.getSource() == appleButton) {
            shoppingList.add("apple");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("apple") <= appleNumberDB) {
                    sendMessageToUser(fruitCounter("apple") + "st 'Apple' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + appleNumberDB + " APPLE IN OUR STORE !");
                shoppingList.remove("apple");
            }
        }
        if (e.getSource() == orangeButton) {
            shoppingList.add("orange");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("orange") <= orangeNumberDB) {
                    sendMessageToUser(fruitCounter("orange") + "st 'ORANGE' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + orangeNumberDB + " orange IN OUR STORE !");
                shoppingList.remove("orange");
            }
        }
        if (e.getSource() == cherryButton) {
            shoppingList.add("cherry");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("cherry") <= cherryNumberDB) {
                    sendMessageToUser(fruitCounter("cherry") + "st 'CHERRY' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + cherryNumberDB + " cherry IN OUR STORE !");
                shoppingList.remove("cherry");
            }
        }
        if (e.getSource() == mangoButton) {
            shoppingList.add("mango");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("mango") <= mangoNumberDB) {
                    sendMessageToUser(fruitCounter("mango") + "st 'MANGO' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + mangoNumberDB + " Mango IN OUR STORE !");
                shoppingList.remove("mango");
            }
        }
        if (e.getSource() == pearButton) {
            shoppingList.add("pear");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("pear") <= pearNumberDB) {
                    sendMessageToUser(fruitCounter("pear") + "st 'pear' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + pearNumberDB + " PEAR IN OUR STORE !");
                shoppingList.remove("pear");
            }
        }
        if (e.getSource() == peachButton) {
            shoppingList.add("peach");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("peach") <= peachNumberDB) {
                    sendMessageToUser(fruitCounter("peach") + "st 'peach' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + peachNumberDB + " PEACH IN OUR STORE !");
                shoppingList.remove("peach");
            }
        }
        if (e.getSource() == waterMelonButton) {
            shoppingList.add("watermelon");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("watermelon") <= waterMelonDB) {
                    sendMessageToUser(fruitCounter("waterMelon") + "st 'Water Melon' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + waterMelonDB + " WATER MELON IN OUR STORE !");
                shoppingList.remove("watermelon");
            }
        }
        if (e.getSource() == melonButton) {
            shoppingList.add("melon");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("melon") <= melonNumberDB) {
                    sendMessageToUser(fruitCounter("melon") + "st 'Melon' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + melonNumberDB + " MELON IN OUR STORE !");
                shoppingList.remove("melon");
            }
        }
        if (e.getSource() == pineAppleButton) {
            shoppingList.add("pine apple");
            if (fruitCounter("pine apple") <= pineAppleNumberDB) {
                shoppingListString = String.valueOf(shoppingList);
                    sendMessageToUser(fruitCounter("pine apple") + "st 'PINE APPLE' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + pineAppleNumberDB + " PINE APPLE IN OUR STORE !");
                shoppingList.remove("pine apple");
            }
        }
        if (e.getSource() == grapeButton) {
            shoppingList.add("grape");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("grape") <= grapeNumberDB) {
                    sendMessageToUser(fruitCounter("grape") + "st 'GRAPE' has added to your cart successfully !");
            } else {
                sendMessageToUser("WE HAVE ONLY " + grapeNumberDB + " GRAPE IN OUR STORE !");
                shoppingList.remove("grape");
            }
        }
        if (e.getSource() == strawberryButton) {
            shoppingList.add("strawberry");
            shoppingListString = String.valueOf(shoppingList);
            if (fruitCounter("strawberry") <= strawberryNumberDB) {
                    sendMessageToUser(fruitCounter("strawberry") + "st 'Strawberry' has added to your cart successfully !");
            }
        else {
                sendMessageToUser("WE HAVE ONLY " + strawberryNumberDB + " STRAWBERRY IN OUR STORE !");
                shoppingList.remove("strawberry");
            }
        }
        if (e.getSource() == clientNewProduct) {
            this.getContentPane().removeAll();
            clientNewProductPanel();
            addManagerActionListener();
            this.revalidate();
            this.repaint();
        }




        // Manager Action listener

        if ( e.getSource() == managerButton ) {
            this.getContentPane().removeAll();
            loginManager();
            addManagerActionListener();
            this.revalidate();
            this.repaint();
        }
        if ( e.getSource() == loginManagerButton) {
            employeeCodeString = employee_codeText.getText();
            employeePasswordString = employeePasswordText.getText();
            if (checkLoginManagerDB(employeeCodeString,employeePasswordString)) {
                sendMessageToUser(" YOUR LOGIN WAS SUCCESSFUL !");
                this.getContentPane().removeAll();
                managerPanel();
                this.revalidate();
                this.repaint();
            }
            else {
                sendMessageToUser("YOUR EMPLOYEE CODE OR PASSWORD IS INCORRECT");
            }
        }
        if ( e.getSource() == clientsButton) {
            this.getContentPane().removeAll();
            clientList();
            this.revalidate();
            this.repaint();
        }
        if ( e.getSource() == managerBack) {
            this.getContentPane().removeAll();
            managerPanel();
            this.revalidate();
            this.repaint();
        }
        if ( e.getSource() == repositoryButton ) {
            this.getContentPane().removeAll();
            repositoryPanel();
            this.revalidate();
            this.repaint();
        }
        if ( e.getSource() == searchManagerButton) {
            this.getContentPane().removeAll();
            managerSearchPanel();
            this.revalidate();
            this.repaint();
        }
        if ( e.getSource() == managerSearchEngine ) {
            managerSearchResult();
        }
        if ( e.getSource() == saleButton ) {
            this.getContentPane().removeAll();
            salePanel();
            this.revalidate();
            this.repaint();
        }
        if ( e.getSource() == productsButton ) {
            this.getContentPane().removeAll();
            productsPanel();
            this.revalidate();
            this.repaint();
        }
        if(e.getSource() == addingProductButton) {
            this.getContentPane().removeAll();
            addProductPanel();
            this.revalidate();
            this.repaint();
        }
        if ( e.getSource() == addProductButton) {
            this.getContentPane().removeAll();
            sendMessageToUser("This item added to shop successfully !");
            newProductPriceDouble = Double.parseDouble(newProductPriceText.getText());
            newProductNumberInteger = Integer.parseInt(newProductPriceText.getText());
            newProductNameString =newProductNameText.getText();

            addProduct(newProductNameString , newProductNumberInteger , newProductPriceDouble);
            addedProduct.setText( newProductNameText.getText() +"  "+ newProductPriceText.getText() + " $");
            addedProduct.setFont(font1);
            newProductPriceText.getText();
            newProductNameText.getText();
            managerPanel();
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == addedProduct ) {
            shoppingList.add(addedProduct.getText());
            shoppingListString = String.valueOf(shoppingList);
            System.out.println("in gheymat producte: " + newProductPriceDouble);
            sendMessageToUser(fruitCounter(addedProduct.getText()) + " added to your cart successfully !");
        }
    }
}





