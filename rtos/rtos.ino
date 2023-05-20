#include <Arduino_JSON.h>
#include <FirebaseESP32.h>
#include  <WiFi.h>
#include <DHT.h>


#define FIREBASE_HOST "htniot-default-rtdb.firebaseio.com/"
#define WIFI_SSID "Xiaomi 11 Lite 5G NE" // Change the name of your WIFI
#define WIFI_PASSWORD "12345678" // Change the password of your WIFI
#define FIREBASE_Authorization_key "y2a9wUQiGvkj1bw3oJ2cGPPrxVhgm0HfNjqz4iIr"

#define DHTPIN 4 // chân đọc nhiệt độ độ ẩm
#define DHTTYPE DHT11  
DHT dht(DHTPIN, DHTTYPE);

WiFiClient client;
 
FirebaseData firebaseData;
FirebaseJson json;
const int potPin = 34; // chân đọc analog
int potValue = 0;

const int ledPin = 5;  // chân pwm

// setting PWM properties
const int freq = 5000;
const int ledChannel = 0;
const int resolution = 8;
int dutyCycle = 0;

void setup() {
 
  Serial.begin(115200);
  dht.begin();
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting...");
  while (WiFi.status() != WL_CONNECTED)
  {
    Serial.print(".");
    delay(300);
 }
    Serial.println();
    Serial.print("IP Address: ");
    Serial.println(WiFi.localIP());
    Serial.println();
    Firebase.begin(FIREBASE_HOST,FIREBASE_Authorization_key);

    ledcSetup(ledChannel, freq, resolution);
    ledcAttachPin(ledPin, ledChannel);

 
  xTaskCreate(
                    taskOne,          /* Task function. */
                    "TaskOne",        /* String with name of task. */
                    10000,            /* Stack size in bytes. */
                    NULL,             /* Parameter passed as input of the task */
                    2,                /* Priority of the task. */
                    NULL);            /* Task handle. */
 
  xTaskCreate(
                    taskTwo,          /* Task function. */
                    "TaskTwo",        /* String with name of task. */
                    10000,            /* Stack size in bytes. */
                    NULL,             /* Parameter passed as input of the task */
                    3,                /* Priority of the task. */
                    NULL);            /* Task handle. */
 
  xTaskCreate(
                    taskThree,          /* Task function. */
                   "TaskThree",        /* String with name of task. */
                    10000,            /* Stack size in bytes. */
                    NULL,             /* Parameter passed as input of the task */
                    1,                /* Priority of the task. */
                    NULL);            /* Task handle. */
 delay(1000);
}
 
void loop() {
  delay(1000);
}
 
void taskOne( void * parameter )
{
    for( ;;){
      potValue = analogRead(potPin);
      Serial.println(potValue);
      Firebase.setFloat(firebaseData, "ANALOG", potValue);
      delay(1000);
    }
}
 
void taskTwo( void * parameter)
{
    for( ;;){
      float hum = dht.readHumidity();
      float temp = dht.readTemperature();  
    
      if (isnan(hum) || isnan(temp)  ){
        Serial.println("Failed to read from DHT sensor!");
        //return;
      }
      Firebase.setFloat(firebaseData, "NHIET_DO", temp);
      Firebase.setFloat(firebaseData, "DO_AM", hum);
      Serial.print("Temperature: ");
      Serial.print(temp);
      Serial.print("°C");
      Serial.print(" Humidity: ");
      Serial.print(hum);
      Serial.print("%");
      Serial.println();
      delay(2000);
    }
 
}
void taskThree( void * parameter)
{
 
    for( ;;){
      if (Firebase.getInt(firebaseData, "PWM" )) dutyCycle = firebaseData.intData();
      //dutyCycle = 100;
      ledcWrite(ledChannel, dutyCycle);
      Serial.println(dutyCycle);
      delay(15);
    }
 
}