/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.interblocks.eod.util;


import java.util.Comparator;

import com.interblocks.eod.util.bean.ModuleBean;


public class ModuleComparator implements Comparator<ModuleBean>{
    
        public int compare(ModuleBean _first, ModuleBean _second) {
            return _first.getMODULE_ID().compareTo(_second.getMODULE_ID());
    }

}
