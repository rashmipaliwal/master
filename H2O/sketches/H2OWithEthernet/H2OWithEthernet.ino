/*
  Web client

 This sketch connects to a website (http://www.google.com)
 using an Arduino Wiznet Ethernet shield.

 Circuit:
 * Ethernet shield attached to pins 10, 11, 12, 13

 created 18 Dec 2009
 by David A. Mellis
 modified 9 Apr 2012
 by Tom Igoe, based on work by Adrian McEwen

 */

#include <SPI.h>
#include <Ethernet.h>

// Enter a MAC address for your controller below.
// Newer Ethernet shields have a MAC address printed on a sticker on the shield
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
// if you don't want to use DNS (and reduce your sketch size)
// use the numeric IP instead of the name for the server:
//IPAddress server(172,16,15,122);  // numeric IP for Google (no DNS)
char server[] = "ec2-54-201-247-252.us-west-2.compute.amazonaws.com";    // name address for Google (using DNS)

// Set the static IP address to use if the DHCP fails to assign
IPAddress ip(192, 168, 0, 177);

// Initialize the Ethernet client library
// with the IP address and port of the server
// that you want to connect to (port 80 is default for HTTP):
EthernetClient client;

int pin = 2; //Water flow sensor attached to digital pin 2

volatile unsigned int pulse;

const int pulses_per_litre = 450;

const int interval = 3600000; // one hour = 60*60*1000 millis 

volatile float litersPerInterval;

unsigned long currentTime;

String deviceId = "1";

void setup() {
  // Open serial communications and wait for port to open:
  Serial.begin(9600);
  while (!Serial) {
    ; // wait for serial port to connect. Needed for native USB port only
  }

  // start the Ethernet connection:
  if (Ethernet.begin(mac) == 0) {
    Serial.println("Failed to configure Ethernet using DHCP");
    // try to congifure using IP address instead of DHCP:
    Ethernet.begin(mac, ip);
  }
  // give the Ethernet shield a second to initialize:
  delay(1000);
  Serial.println("connecting...");
  Serial.print("My IP address: ");
  Serial.println(Ethernet.localIP());

  pinMode(pin, INPUT);
  attachInterrupt(0, count_pulse, RISING);
}

void loop() {
  // if there are incoming bytes available
  // from the server, read them and print them for debug:
  if (client.available()) {
    char c = client.read();
    Serial.print(c);
  }

  pulse = 0;

  interrupts();

  delay(5000);
  noInterrupts();

  Serial.print("Pulses per interval: " + pulse);
  
  litersPerInterval = (float) pulse/(float) pulses_per_litre;

  String litersPerIntervalString  =  String(litersPerInterval, 3);
  Serial.println("Liters per interval" + litersPerIntervalString);

  httpRequest(); 
}

void count_pulse() {
  pulse++;
}


// this method makes a HTTP connection to the server:
void httpRequest() {
  // close any connection before send a new request.
  // This will free the socket on the WiFi shield
  client.stop();

  // if there's a successful connection:
  if (client.connect(server, 8080)) {
    Serial.println("connecting...");
    // send the HTTP GET request:
    String litersPerIntervalStr  =  String(litersPerInterval, 3); 
    client.println("GET /h2o/record.htm?deviceId="+ deviceId + "&volume="+ litersPerIntervalStr +" HTTP/1.1");
    client.println("Host: ec2-54-201-247-252.us-west-2.compute.amazonaws.com");
    client.println("User-Agent: arduino-ethernet");
    client.println("Connection: close");
    client.println();
  } else {
    // if you couldn't make a connection:
    Serial.println("connection failed");
  }
}
