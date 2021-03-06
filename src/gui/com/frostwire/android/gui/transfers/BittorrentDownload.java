/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011-2013, FrostWire(R). All rights reserved.
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

package com.frostwire.android.gui.transfers;

import java.util.List;

/**
 * @author gubatron
 * @author aldenml
 *
 */
public interface BittorrentDownload extends DownloadTransfer {

    public String getHash();

    public String getPeers();

    public String getSeeds();

    public String getSeedToPeerRatio();

    public String getShareRatio();

    public boolean isResumable();

    public boolean isPausable();

    public boolean isSeeding();

    public void pause();

    public void resume();

    public void cancel(boolean deleteData, boolean async);
    
    public List<? extends BittorrentDownloadItem> getBittorrentItems();
}
