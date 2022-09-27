/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interblocks.eod.util;

import java.util.List;

/**
 *
 * @author kreshan
 */
public interface AccessControlService {
    public boolean checkAccess(List<String> profilePageidList);
}