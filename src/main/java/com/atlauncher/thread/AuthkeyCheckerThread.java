package com.atlauncher.thread;

import com.atlauncher.ATLauncher;
import com.atlauncher.acc.Accounts;

import javax.swing.*;

public final class AuthkeyCheckerThread extends SwingWorker<Void, Void>{
    @Override
    protected Void doInBackground()
    throws Exception {
        ATLauncher.LOGGER.info("Checking Authkey");

        if(Accounts.getInstance().getAccounts().size() == 0){
            return null;
        }

        return null;
    }
}