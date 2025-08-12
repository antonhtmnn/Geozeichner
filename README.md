
## Geozeichner

Geozeichner is an interactive program designed to draw 2D shapes into a coordinate system. Below is an overview of the project, its structure, and key components.

<p align="center">
  <a href="https://www.youtube.com/watch?v=HJqMfB_-E5g" title="Geozeichner">
    <img src="https://res.cloudinary.com/marcomontalbano/image/upload/v1649765888/video_to_markdown/images/youtube--HJqMfB_-E5g-c05b58ac6eb4c4700831b2b3070cd403.jpg" alt="Geozeichner — demo video thumbnail" width="640" />
  </a>
  <br/>
  <sub>▶ click image to watch demo video</sub>
</p>

### Table of Contents

- [Project Description](#project-description)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

### Project Description

Geozeichner allows users to draw and manipulate geometric shapes within a graphical coordinate system interface. The application is built using Java and Swing for the GUI components.

[![Geozeichner](https://res.cloudinary.com/marcomontalbano/image/upload/v1649765888/video_to_markdown/images/youtube--HJqMfB_-E5g-c05b58ac6eb4c4700831b2b3070cd403.jpg)](https://youtu.be/HJqMfB_-E5g "Geozeichner")

### Installation

To set up Geozeichner on your local machine, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/antonhtmnn/Geozeichner.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Geozeichner
    ```
3. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

### Usage

To run the application:

1. Compile the project.
2. Run the `Main` class located at `src/com/company/Main.java`.

The main GUI window should appear, allowing you to start drawing shapes.

### Features

- **Draw Shapes:** Draw rectangles and circles within a coordinate system.
- **Adjust Scale:** Adjust the scale of the coordinate system.
- **Reset Inputs:** Clear all inputs and drawings.
- **Settings:** Configure various settings for the shapes and coordinate system.

### Project Structure

The project is structured as follows:

```
Geozeichner/
├── .idea/
├── images/
│   ├── help.png
│   ├── info.png
│   └── trash.png
├── out/
├── src/
│   └── com/
│       └── company/
│           ├── CenterPanel.java
│           ├── CenterPanelEingabeAusgabe.java
│           ├── CenterPanelKoordinatensystem.java
│           ├── CenterPanelSettings.java
│           ├── Figur.java
│           ├── GeozeichnerFrame.java
│           ├── KoordinatensystemPanelMain.java
│           ├── Kreis.java
│           ├── Main.java
│           ├── Rechteck.java
│           ├── TopPanel.java
│           └── TopPanelTrash.java
├── LICENSE
└── README.md
```

- **Main.java:** Entry point of the application.
- **GeozeichnerFrame.java:** Sets up the main application window.
- **CenterPanel.java:** Main drawing area containing sub-panels for input and coordinate system.
- **CenterPanelEingabeAusgabe.java:** Handles user input and output of shape properties.
- **CenterPanelKoordinatensystem.java:** Manages the coordinate system display.
- **CenterPanelSettings.java:** Panel for adjusting settings.
- **Figur.java:** Abstract class representing a geometric figure.
- **Kreis.java:** Represents a circle.
- **Rechteck.java:** Represents a rectangle.
- **TopPanel.java:** Top panel with buttons for actions like reset and help.
- **TopPanelTrash.java:** Handles the reset action.

### Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Make sure to follow the coding conventions and include appropriate tests.

### License

This project is licensed under the MIT License.
