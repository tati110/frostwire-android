/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011, 2012, 2013, FrostWire(R). All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.frostwire.vuze;

import java.io.File;

import org.gudy.azureus2.core3.config.COConfigurationManager;
import org.gudy.azureus2.core3.util.SystemProperties;

import com.aelitis.azureus.core.AzureusCore;
import com.aelitis.azureus.core.AzureusCoreFactory;

/**
 * @author gubatron
 * @author aldenml
 *
 */
public abstract class VuzeEngine {

    private final AzureusCore core;

    public VuzeEngine() {
        initConfiguration();

        this.core = AzureusCoreFactory.create();
    }

    protected abstract File getVuzePath();

    protected abstract File getTorrentsPath();

    public void initConfiguration() {
        File azureusPath = getVuzePath();

        System.setProperty("azureus.config.path", azureusPath.getAbsolutePath());
        System.setProperty("azureus.install.path", azureusPath.getAbsolutePath());
        System.setProperty("azureus.loadplugins", "0"); // disable third party azureus plugins

        SystemProperties.APPLICATION_NAME = "azureus";
        SystemProperties.setUserPath(azureusPath.getAbsolutePath());

        COConfigurationManager.setParameter("Auto Adjust Transfer Defaults", false);
        COConfigurationManager.setParameter("General_sDefaultTorrent_Directory", getTorrentsPath().getAbsolutePath());

        // network parameters, fine tunning for android
        COConfigurationManager.setParameter("network.tcp.write.select.time", 1000);
        COConfigurationManager.setParameter("network.tcp.write.select.min.time", 1000);
        COConfigurationManager.setParameter("network.tcp.read.select.time", 1000);
        COConfigurationManager.setParameter("network.tcp.read.select.min.time", 1000);
        COConfigurationManager.setParameter("network.control.write.idle.time", 1000);
        COConfigurationManager.setParameter("network.control.read.idle.time", 1000);
    }
}
