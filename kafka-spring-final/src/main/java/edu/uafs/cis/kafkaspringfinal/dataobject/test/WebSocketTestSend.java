package edu.uafs.cis.kafkaspringfinal.dataobject.test;

public class WebSocketTestSend {

  String message;
  int value;
  
  public WebSocketTestSend() {
  
  }
  
  public WebSocketTestSend(int value, String message) {
    this.message = message;
    this.value = value;
  }
  
  public String getMessage() {
    return message;
  }
  
  public int getValue() {
    return value; 
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
  
  public String toString() {
    return "WebSocketTestSend{" + "value='" + value + '\'' + ", message='" + message + '\'' + '}';
  }

}
