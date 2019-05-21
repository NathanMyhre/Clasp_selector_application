/**
 * The Clasp Selector application implements functionality to select Removable
 * Partial Denture Prosthesis (RDP) based on patient criteria.
 *
 * @author Nathan J Myhre
 * @version 1.0
 * @since 2019-04-17
 */
package com.company;
import java.util.HashMap;

//probably should rename package at some point.
public class Main {

    public static void main(String[] args) {
	// write your code here
        HashMap<String, Integer> p = new HashMap<String, Integer>();
        p.put("Test", 1);
        System.out.println(p.get("Test"));
        p.remove("Test");
        p.remove("Test");
    }
}
