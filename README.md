QuizApplication/
│
├── src/                        # Main source code folder
│   ├── model/                  # Contains the database models (Player, Question, Report)
│   │   ├── Player.java         # Player data model
│   │   ├── Question.java       # Question data model
│   │   └── Report.java         # Report data model
│   │
│   ├── view/                   # GUI components (Swing UI)
│   │   ├── AdminLoginFrame.java# Admin login screen
│   │   ├── AdminDashboardFrame.java # Admin panel
│   │   ├── PlayerLoginFrame.java # Player login screen
│   │   ├── QuizFrame.java      # Quiz interface for players
│   │   └── HighScoresFrame.java # High scores leaderboard
│   │
│   ├── controller/             # Logic for handling user interaction with GUI
│   │   ├── AdminController.java # Admin panel logic
│   │   ├── PlayerController.java # Player functionality logic
│   │   ├── QuizController.java  # Quiz logic (question generation, score calculation)
│   │   └── ReportController.java # Report generation logic
│   │
│   ├── db/                     # Database connection and queries
│   │   ├── DBConnection.java   # Database connection setup (JDBC)
│   │   ├── PlayerDAO.java      # CRUD operations for players
│   │   ├── QuestionDAO.java    # CRUD operations for questions
│   │   ├── ReportDAO.java      # CRUD operations for reports
│   │   └── HighScoreDAO.java   # Fetch high scores from database
│   │
│   └── utils/                  # Utility classes
│       ├── Constants.java      # Any constant variables (e.g., difficulty levels)
│       ├── ShuffleQuestions.java # Method to shuffle questions
│       └── ValidationUtils.java # Validation methods (e.g., check if player exists)
│
├── resources/                  # Non-code resources (icons, config files, etc.)
│   ├── images/                 # Images for icons or buttons
│   └── config/                 # Configuration files (e.g., db config)
│
├── lib/                        # External libraries (JDBC driver, etc.)
│   └── mysql-connector-java-x.x.x.jar # MySQL connector (JDBC driver)
│
├── bin/                        # Compiled bytecode (after build)
│
├── docs/                       # Documentation files (reports, class diagrams, etc.)
│   ├── report.pdf              # Coursework report
│   └── class-diagram.png       # UML class diagram
│
├── build/                      # Build files (created after compiling)
│
└── .gitignore                  # Git ignore file (ignore compiled files, libraries)
