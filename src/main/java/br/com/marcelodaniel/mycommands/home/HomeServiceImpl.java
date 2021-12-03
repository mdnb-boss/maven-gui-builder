/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.marcelodaniel.mycommands.home;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class HomeServiceImpl implements HomeService {
    
    public List<String> getmodules() {
        List<String> modulos = new ArrayList<>();
        modulos.add("digital-account");
        modulos.add("rodobank-connector");
        return modulos;
    }
}
