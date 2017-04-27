#include <AESLib.h>
static char outstr[16];
uint8_t key[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
int pin = 2; //Water flow sensor attached to digital pin 2

volatile unsigned int pulse;

const int pulses_per_litre = 450;

const int interval = 3600000; // one hour = 60*60*1000 millis 

volatile float litersPerInterval;

void setup()

{

Serial.begin(9600);

pinMode(pin, INPUT);

attachInterrupt(0, count_pulse, RISING);

}

void loop()

{

pulse = 0;

interrupts();

delay(5000);

noInterrupts();

litersPerInterval = (float)pulse/(float)pulses_per_litre;

dtostrf(litersPerInterval,16, 2, outstr);

aes128_enc_single(key, outstr);
Serial.println(outstr);
//aes128_dec_single(key, outstr);
//Serial.print("decrypted:");
//Serial.println(outstr);

//Serial.println(litersPerInterval);

// Send litersPerInterval to HTTP service

}

void count_pulse()

{

pulse++;

}



