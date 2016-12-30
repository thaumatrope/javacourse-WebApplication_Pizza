/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

/**
 * CounterFields are textfields with numeric values. And can draw themselves on
 * the canvas.
 *
 * @author IBB Teilnehmer
 */
public class CounterField extends Textfield {

    // current value of the counter
    // private, because we need to call UpdateText() after every change
    private int value;

    // Name of the counter; if not empty this is shown as prefix.
    String name;

    /**
     * Create with value and position.
     *
     * @param value
     * @param x
     * @param y
     */
    public CounterField(String name, int value, int x, int y) {
        super(name, x, y);
        this.value = value;
        this.name = name;
        this.textsize = 12;
        UpdateText();
    }

    // update text field part
    public void UpdateText() {
        this.text = name + ": " + value;
    }
    
    // set value to specific amount 
    public void SetValue(int value) {
        this.value = value;
        UpdateText();
    }
    
    // getter for property value
    public int GetValue(){
        return value;
    }

    // increase score by certain amount 
    public void Increase(int amount) {
        value += amount;
        UpdateText();
    }

    // decrease score by certain amount
    // only decreases to zero
    void Decrease(int amount) {
        value -= amount;
        if (value < 0) {
            value = 0;
        }
        UpdateText();
    }

    // reset score to zero
    public void Reset() {
        value = 0;
        UpdateText();
    }
}
