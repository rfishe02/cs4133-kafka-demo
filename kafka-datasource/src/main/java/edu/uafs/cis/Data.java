
package edu.uafs.cis;

public class Data {

  private String content;
  private int value;
  
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
    return "Data{" + "content=" + content + ", value='" + value + "\'" + "}";
  }

}
