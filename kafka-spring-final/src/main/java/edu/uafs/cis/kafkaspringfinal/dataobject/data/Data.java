
package edu.uafs.cis.kafkaspringfinal.dataobject.data;

public class Data {

  String content;
  int value;

  public Data() {
  }

  public Data(String content, int value) {
    this.content = content;
    this.value = value;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
  
  public String getContent() {
    return content;
  }
  
  public int getValue() {
    return value;
  }
  
  public String toString() {
    return "Data{content='" + content + "\', value='" + value + "\'}";
  }

}
