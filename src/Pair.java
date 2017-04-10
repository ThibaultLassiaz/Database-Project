/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lassiazt
 */
public class Pair {
    
    private int integer;
    private String string;

    
    public Pair(int i, String s)
    {
        this.integer = i;
        this.string = s;
    }
    
    /**
     * @return the integer
     */
    public int getInteger() {
        return integer;
    }

    /**
     * @return the string
     */
    public String getString() {
        return string;
    }

    /**
     * @param string the string to set
     */
    public void setString(String string) {
        this.string = string;
    }

    
}
