# WeatherBoxApp

Das ist die App für die graphische Darstellung der Daten der IoT-Box für den Wettbewerb 3-IoT-Stars 2018. 

## Getting Started

Die App holt sich die Daten vom 3-Server, die sie dann in Balken darstellt.

### Voraussetzungen

Diese App ist erst einmal nur in Android programmiert und bedarf daher einem Android basierten Handy. 

### Authentifikation

Zusätzlich ist noch ein Creadential.java in app/src/main/java/at/talentehaus/weatherbox zu erstellen mit folgendem Format:
```
package at.talentehaus.weatherbox;

public class Credentials {
    static public String url = "https://URL/api"; // Backend URL
    static public String cid = "customerId@mail.com"; // Customer ID
    static public String uid = "UserId"; // User ID
    static public String sid = "SiteId"; // Site ID
    static public String passwd = "Password12345"; // Password
    static public String did = "DeviceId"; // Device ID
}
```

## Installation

Der Code muss mittels Android Studio auf das Gerät hochgeladen werden.

## Autoren

* **Harald Moritz** - *Hauptentwickler* - [Github](https://github.com/wicket1001)
* **Rene Fischer** - *Graphische Darstellung*
