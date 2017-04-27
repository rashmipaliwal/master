#include <SPI.h>
#include <WiFi.h>

int pin = 2; //Water flow sensor attached to digital pin 2
volatile unsigned int pulse;
const int pulses_per_litre = 450;
const int interval = 3600000; // one hour = 60*60*1000 millis 
volatile float litersPerInterval;
unsigned long currentTime;

String deviceId = "1";

char ssid[] = "IPODS"; //  your network SSID (name) 
char pass[] = "Ip$r!aN0cP@$$";    // your network password (use for WPA, or use as key for WEP)
int keyIndex = 0;            // your network key Index number (needed only for WEP)

int status = WL_IDLE_STATUS;
// IPAddress server(172,16,15,122);  // numeric IP for Google (no DNS)
char server[] = "ec2-54-201-247-252.us-west-2.compute.amazonaws.com"; 

WiFiClient client;

void setup() {

  Serial.begin(9600);
  pinMode(pin, INPUT);

  // check for the presence of the shield:
  if (WiFi.status() == WL_NO_SHIELD) {
    Serial.println("WiFi shield not present"); 
    // don't continue:
    while(true);
  } 

  // attempt to connect to Wifi network:
  while (status != WL_CONNECTED) { 
    Serial.print("Attempting to connect to SSID: ");
    Serial.println(ssid);
    // Connect to WPA/WPA2 network. Change this line if using open or WEP network:    
    status = WiFi.begin(ssid, pass);
  
    // wait 10 seconds for connection:
    delay(10000);
  } 

  Serial.println("Connected to wifi");
  

  attachInterrupt(0, count_pulse, RISING);

}

void loop() {
  // if the server's disconnected, stop the client:
  if (!client.connected()) {
    Serial.println();
    Serial.println("disconnecting from server.");
    client.stop();

    // do nothing forevermore:
    while(true);
  }

  // Reset pulse after every reading
  pulse = 0;

  interrupts();
  // per minute delay
  delay(interval);
  noInterrupts();
  
  Serial.print("Pulses per interval: " + pulse);

  litersPerInterval = (float) pulse/(float) pulses_per_litre;

  String litersPerIntervalString  =  String(litersPerInterval, 3);
  Serial.println("Liters per interval" + litersPerIntervalString);
  
  // connect to server to send the reading
  // if you get a connection, report back via serial:
  httpRequest();
  
}

void count_pulse() {
  pulse++;
}

void httpRequest() {
  // connect to server to send the reading
  // if you get a connection, report back via serial:
  if (client.connect(server, 8080)) {
    Serial.println("connected to server");
    // Make a HTTP request:
    String litersPerIntervalStr  =  String(litersPerInterval, 3); 
    client.println("GET /H2O/record.htm?deviceId="+ deviceId + "&volume="+ litersPerIntervalStr +" HTTP/1.1");
    client.println("Host: ec2-54-201-247-252.us-west-2.compute.amazonaws.com");
    client.println("Connection: close");
    client.println();
  }
}

